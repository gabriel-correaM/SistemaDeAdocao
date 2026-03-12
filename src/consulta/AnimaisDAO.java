package consulta;

import conexao.Conexao;
import consulta.Animais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnimaisDAO {

    public ArrayList<Animais> listar() {

    ArrayList<Animais> lista = new ArrayList<>();

    String sql = "SELECT id, nome, raca, abrigo, adotado, adotante_id FROM animais";

    try (
        Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()
    ) {

        while (rs.next()) {
            Animais a = new Animais();

            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setRaca(rs.getString("raca"));
            a.setAbrigo(rs.getString("abrigo"));
            a.setAdotado(rs.getString("adotado"));
            a.setAdotante_id(rs.getInt("adotante_id"));
            

            lista.add(a);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}
    
    public void excluir(int id) {

    String sql = "DELETE FROM animais WHERE id = ?";

    try (
        Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {
        ps.setInt(1, id);
        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
    
}

    public void adotar(int idAnimal) {

    String sql =
        "UPDATE animais SET adotado = 'Adotado' WHERE id = ?";

    try (
        Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {
        ps.setInt(1, idAnimal);
        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public void atualizarAdocao(Animais a) {

    String sql = "UPDATE animais SET adotado = ?, adotante_id = ? WHERE id = ?";

    try (
        Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {

        ps.setString(1, a.getAdotado());
        ps.setInt(2, a.getAdotante_id());
        ps.setInt(3, a.getId());

        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}


