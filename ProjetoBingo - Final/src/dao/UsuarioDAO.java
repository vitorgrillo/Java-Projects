package dao;

import factory.ConnectionFactory;
import modelo.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>CLASSE USUARIO DAO (Data Access Object) </h1>
 * Classe UsuarioDao é responsável por realizar o intermédio entre a base de dados Mysql com a Interface,
 * sem esta classe seria impossivel salvar os dados dos usuários cadastrados no sistema e nem realizar as validações de rankings ou logins de email. 
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class UsuarioDAO { 
    private Connection connection;
    String email;
    String senha;
    int qtd_vitoria;
    Calendar primeira_data = Calendar.getInstance ();
    SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdfOut = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    
    /**
    * <h2>Método Construtor da Classe </h2>
    * Método UsuarioDao é responsável por realizar a conexão com a base de dados Mysql utilizando o Connector mysql-connector-java-5.1.42-bin.jar 
    * com o intuito final de realizar as interações com a base Mysql da Universidade.
    */
    public UsuarioDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    
    /**
    * <h2>Método Validação Login </h2>
    * Método valida_login é responsável por verificar se o usuario em questão está cadastrado na base e possui um login válido, 
    * descriptografado utilizando a técnica de desencriptação do Mysql AES_DECRYPT.
    * @param  username é o valor correspondente ao nome do usuario cadastrado na tabela bg_user da base de dados.
    * @param password  é o valor correspondente a senha descriptografada do usuario cadastrado na tabela bg_user da base de dados.
    * @return usr Retorna os dados do usuario selecionado na base dentro da tabela bg_users.
    */
    public Usuario valida_login(String username,String password) {
           String sql = "SELECT email,qtd_vitoria_mes, CAST(AES_DECRYPT(senha,'bingo') AS CHAR) FROM bg_users WHERE email = ? and senha = AES_ENCRYPT(?,'bingo')";
           try{
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setString(1, username); 
                    stmt.setString(2, password);
                    ResultSet rs = stmt.executeQuery();                        
                    if(rs.first()){
                        Usuario usr = new Usuario();
                        usr.setEmail(rs.getString(1));
                        usr.setQtdVitoria(rs.getInt(2));
                        return usr;
                    }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
           return null;
    }
    
     /**
    * <h2>Método Atualiza </h2>
    * Método atualiza é responsável por atualizar os dados de vitórias na tabela de Ranking para os usuarios cadastrados no sistema.
    * @param usuario é o objeto correspondente as informações preenchidas pelo usuario.
    */
    public void atualiza(Usuario usuario) {
        String sql = "UPDATE bg_users SET qtd_vitoria_mes = ? WHERE email = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(2, usuario.getEmail());
            stmt.setInt(1, usuario.getQtdVitoria());
            stmt.executeUpdate();
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     /**
    * <h2>Método ranking (Tabela Ranking)</h2>
    * Método ranking é responsável por retornar os dados de vitórias na tabela de Ranking dos três melhores jogadores cadastrados no sistema.
    *  @throws Exception alguns dos valores são inválidos ou não correspondem ao esperado pela função.
    * @return Retorna os dados dos 3 melhores vitoriosos do jogo.
    */
     public List<Usuario> ranking() throws Exception{
           ResultSet rs = null;
           List<Usuario> jogadores = new ArrayList<Usuario>();
           String sql = "SELECT * FROM BG_USERS";
           try {
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    rs = stmt.executeQuery();     
                    while(rs.next()){
                        Usuario usr = new Usuario();
                        usr.setEmail(rs.getString("nome"));
                        usr.setQtdVitoria(rs.getInt("qtd_vitoria_mes"));
                        jogadores.add(usr);
                    }
                    
                    Collections.sort(jogadores, new Comparator<Usuario>() {
                        @Override
                        public int compare(Usuario o1, Usuario o2) {
                            return Integer.valueOf(o1.getQtdVitoria()).compareTo(o2.getQtdVitoria())*-1;
                        }
                    });

          } catch(Exception e) {
             e.printStackTrace();
          }
           
           if(jogadores.size() > 3){
               return jogadores.subList(0, 3);
           }
           return jogadores;
    }

     /**
    * <h2>Método adiciona </h2>
    * Método adiciona é responsável por realizar o processo de cadastrado no sistema, salvando as informações na Base de dados Mysql.
    * @param usuario é o objeto correspondente as informações preenchidas pelo usuario.
    */
    public void adiciona(Usuario usuario) {
        String sql = "INSERT INTO bg_users VALUES (?,?, AES_ENCRYPT(?,'bingo'), ?, ?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2,usuario.getNome());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, sdfIn.format(usuario.getPrimeiraData()));
            stmt.setInt(5, usuario.getQtdVitoria());
            stmt.executeUpdate();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
    }
    
}