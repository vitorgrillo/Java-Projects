// situa em qual package ou “pacote” está a classe 
package factory;
// faz as importações de classes necessárias para o funcionamento do programa 
import java.sql.Connection; 
// conexão SQL para Java 
import java.sql.DriverManager; 
// driver de conexão SQL para Java 
import java.sql.SQLException; 
// classe para tratamento de exceções 

/**
 * <h1>CLASSE CONNECTION FACTORY </h1>
 * Classe ConnectionFactory é responsável por realizar a conexão entre a base de dados Mysql com a Interface,
 * sem esta classe seria impossivel salvar os dados dos usuários cadastrados no sistema e nem realizar as validações de rankings ou logins de email. 
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */
public class ConnectionFactory {
     public Connection getConnection() {
		 try {
			return DriverManager.getConnection("jdbc:mysql://esparta:3306/bdac18","bdac18","Btbjv8");
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
     }
}
