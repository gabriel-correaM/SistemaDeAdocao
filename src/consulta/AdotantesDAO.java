/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consulta;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gab
 */
public class AdotantesDAO {
    
    public int salvar(String nome, String senha, String telefone, String email) {

    String sql = "INSERT INTO adotantes (nome, senha, telefone, email) VALUES (?, ?, ?, ?)";

    try (
        Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(
            sql, PreparedStatement.RETURN_GENERATED_KEYS
        )
    ) {

        ps.setString(1, nome);
        ps.setString(2, senha);
        ps.setString(3, telefone);
        ps.setString(4, email);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1); 
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return -1; // erro
}
    
    public Adotantes buscarPorId(int id) {

    Adotantes a = null;

    String sql = "SELECT * FROM adotantes WHERE id = ?";

    try (
        Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            a = new Adotantes();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setEmail(rs.getString("email"));
            a.setTelefone(rs.getString("telefone"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return a;
}
    
    
    
}
