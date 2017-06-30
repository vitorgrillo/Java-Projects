package servidor;

import dao.UsuarioDAO;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import modelo.Usuario;

/**
 * <h1>CLASSE SERVIDOR</h1>
 * Classe Servidor é responsável pelas implementações das: ( Conexões de Usuarios, Jogos em Andamentos, Tempo das Partidas, Mensagens Erros e Vitórias)
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */

public class Servidor extends Thread implements ComunicaChamante {

    private List<Integer> numerosDoServidor;
    private ServerSocket server;
    private List<ConexaoNoServidor> listaConexoes = new ArrayList<ConexaoNoServidor>();
    private boolean alguemConectou = false;
    private boolean jogoAndamento = false;
    private Timer timerPartida;
    
      /**
     * <h2>Método Servidor</h2>
     * Método cujo qual tem a função de instanciar e definir os sockets por meio da porta do Servidor.
     *  @throws Exception alguns dos valores são inválidos ou não correspondem ao esperado pela função.
     * @param  porta é o valor correspondente a porta principal do socket em questão.
     */
    public Servidor(int porta) throws Exception {
        this.server = new ServerSocket(porta);
    }

      /**
      * <h1>Método Run (Conexões de Usuários)</h1>     
      * Método cujo qual tem a função de receber as conexões a serem estabelecidas dentro do Servidor.
      */
    @Override
    public void run() {
        System.out.println("Servidor esperando por conexoes na porta " + this.server.getLocalPort());
        while (true) {
            try {
                Socket conexao = this.server.accept();
                ConexaoNoServidor c1 = new ConexaoNoServidor(conexao, this);
                if (!jogoAndamento) {
                    listaConexoes.add(c1);

                    if (!alguemConectou) {
                        alguemConectou = true;
                        Servidor.this.escreverParaTodos("Aguardando jogadores");
                        Timer t = new Timer();
                        t.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                System.out.println("Servidor inicializando jogo");
                                jogar();
                            }
                        }, 10000);
                    }
                } else {
                    c1.getWriterObjetos().writeObject("Volte mais tarde, jogo em andamento!");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

      /**
      * <h2>Método Jogar (Jogos em Andamentos)</h2>     
      * Método cujo qual define as funcionalidade básicas do Jogo Bingo e o tempo da partida dentro do Servidor.
      */
    private void jogar() {
        Servidor.this.escreverParaTodos("O jogo comecara em 5 segundos");
        this.numerosDoServidor = new ArrayList<Integer>();

        List<Integer> numerosASortear = new ArrayList<Integer>();

        for (int i = 1; i <= 30; i++) {
            numerosASortear.add(i);
        }
        Collections.shuffle(numerosASortear);

        timerPartida = new Timer();
        timerPartida.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (numerosASortear.isEmpty()) {
                    Servidor.this.escreverParaTodos("O jogo terminou sem ganhadores");
                    jogoAndamento = false;
                } else {
                    jogoAndamento = true;
                    Integer numero = numerosASortear.get(0);
                    Servidor.this.escreverParaTodos("Numero sorteado: " + numero);
                    Servidor.this.numerosDoServidor.add(new Integer(numero));
                    numerosASortear.remove(0);
                }
            }
        }, 5000, 5000);
    }

      /**
      * <h2>Método Escrever Para Todos</h2>     
      * Método cujo qual tem a função de exibir as mensagens de erro para os usuários conectados ao Servidor.
      * @param o é o valor correspondente a mensagem em questão que deverá ser passada ao Servidor para os usuários que foram desconectados.
      */
    public void escreverParaTodos(Object o) {
        Iterator i = this.listaConexoes.iterator();

        while (i.hasNext()) {
            ConexaoNoServidor c = (ConexaoNoServidor) i.next();
            try {
                c.getWriterObjetos().writeObject(o);
            } catch (Exception e) {
                System.out.println("Cliente perdeu a conexao, desconectando");
                i.remove();
            }

        }
    }

      /**
      * <h2>Método Comunicar (Exibe Vitorioso da Rodada)</h2>     
      * Método cujo qual tem a função de exibir a mensagem do usuário vitorioso para os demais conectados ao Servidor.
      * @param o é o valor correspondente a mensagem em questão que deverá ser passada ao Servidor para os usuários conectados.
      */
    public void comunicar(Object o) {
        if (o instanceof HashMap) {
            HashMap mapa = (HashMap) o;

            if (mapa.containsKey(1)) {
                ArrayList<Integer> numerosRecebidos = (ArrayList) mapa.get(1);
                if (numerosRecebidos.size() == 24 && this.numerosDoServidor.containsAll(numerosRecebidos)) {
                    Usuario ganhador = (Usuario) mapa.get(2);
                    this.escreverParaTodos("O jogador " + ganhador.getEmail() + " ganhou o jogo");

                    UsuarioDAO mgrUsuario = new UsuarioDAO();

                    Calendar c = Calendar.getInstance();
                    c.setTime(ganhador.getPrimeiraData());

                    if (c.get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH)) {
                        ganhador.setQtdVitoria(ganhador.getQtdVitoria() + 1);
                    } else {
                        ganhador.setQtdVitoria(1);
                        ganhador.setPrimeiraData(Calendar.getInstance().getTime());
                    }

                    UsuarioDAO dao = new UsuarioDAO();
                    dao.atualiza(ganhador);

                    this.timerPartida.cancel();
                    jogoAndamento = false;
                } else {
                    Usuario ganhador = (Usuario) mapa.get(2);
                    this.escreverParaTodos("O jogador " + ganhador.getEmail() + " tentou bingo");
                }
            }
        }
    }
}
