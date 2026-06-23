package dao;

import bean.MpvCliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoMpvCliente extends DaoAbstract {

    Connection cnt;

    public DaoMpvCliente() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db_atividade_mvc?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String user = "root";
            String password = "";
            cnt = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoMpvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean insert(Object object) {
        MpvCliente cliente = (MpvCliente) object;
        String sql = "INSERT INTO mpv_cliente (nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getTelefone());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void update(Object object) {
        MpvCliente cliente = (MpvCliente) object;
        String sql = "UPDATE mpv_cliente SET nome=?, cpf=?, email=?, telefone=? WHERE id_cliente=?";
        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getTelefone());
            pst.setInt(5, cliente.getIdCliente());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        MpvCliente cliente = (MpvCliente) object;
        String sql = "DELETE FROM mpv_cliente WHERE id_cliente=?";
        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, cliente.getIdCliente());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        MpvCliente cliente = null;
        String sql = "SELECT * FROM mpv_cliente WHERE id_cliente=?";
        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cliente = montarCliente(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    @Override
    public Object listAll() {
        List<MpvCliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM mpv_cliente ORDER BY nome";
        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                lista.add(montarCliente(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private MpvCliente montarCliente(ResultSet rs) throws SQLException {
        MpvCliente cliente = new MpvCliente();
        cliente.setIdCliente(rs.getInt("id_cliente"));
        cliente.setNome(rs.getString("nome"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setEmail(rs.getString("email"));
        cliente.setTelefone(rs.getString("telefone"));
        return cliente;
    }
}
