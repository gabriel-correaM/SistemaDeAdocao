package consulta;

import conexao.Conexao;
import consulta.Animais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaConsulta {

    public static List<Animais> Listar() {

        List<Animais> lista = new ArrayList<>();

        String sql = "SELECT id, nome, raca, abrigo, adotado FROM animais";

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
                lista.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static void Adicionar(Animais a) {

        String sql =
            "INSERT INTO animais (nome, raca, abrigo, adotado) "
          + "VALUES (?, ?, ?, ?)";

        try (
            Connection conn = Conexao.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, a.getNome());
            ps.setString(2, a.getRaca());
            ps.setString(3, a.getAbrigo());
            ps.setString(4, a.getAdotado());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void excluir(int id) {
    AnimaisDAO dao = new AnimaisDAO();
    dao.excluir(id);
}
    
    public static void adotar(int idAnimal) {
    AnimaisDAO dao = new AnimaisDAO();
    dao.adotar(idAnimal);
}

}


