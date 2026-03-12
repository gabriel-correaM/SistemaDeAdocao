

package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    
    public static void criarTabelas() {

        String sqlUsuario =
            "CREATE TABLE IF NOT EXISTS adotantes ("
          + "id INT AUTO_INCREMENT PRIMARY KEY, "
          + "nome VARCHAR(50) NOT NULL , "
          + "senha VARCHAR(100) NOT NULL,"
          + "telefone VARCHAR(100) NOT NULL,"
          + "email VARCHAR(100) NOT NULL"
          + ")";

        try (
            Connection conn = Conexao.conectar();
            Statement stmt = conn.createStatement()
        ) {

            stmt.execute(sqlUsuario);
            System.out.println("Tabela 'ADOTANTES' verificada/criada.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String sqlAnimais =
            "CREATE TABLE IF NOT EXISTS animais ("
          + "id INT AUTO_INCREMENT PRIMARY KEY, "
          + "nome VARCHAR(100) NOT NULL, "   
          + "raca VARCHAR(20) NOT NULL , "
          + "abrigo VARCHAR(50) NOT NULL,"
          + "adotado VARCHAR(20) NOT NULL,"
          + "adotante_id INT,"
          + "FOREIGN KEY (adotante_id) REFERENCES adotantes(id)"
          + ")";

        try (
            Connection conn = Conexao.conectar();
            Statement stmt = conn.createStatement()
        ) {

            stmt.execute(sqlAnimais);
            System.out.println("Tabela 'ANIMAIS' verificada/criada.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static final String URL =
        "jdbc:mysql://localhost:3306/sistemadeadocao?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão", e);
        }
    }
}

