package dao;

import bean.MpvUsuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import teste.JdbcCrud;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoMpvUsuarios extends DaoAbstract {

    Connection cnt;

    public DaoMpvUsuarios() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
            user = "marcos_vilhanueva";
            password = "marcos_vilhanueva";
            cnt = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMpvUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean insert(Object object) {
        MpvUsuarios mpvUsuarios = (MpvUsuarios) object;
        try {
            String sql = "insert into mpv_usuarios(mpv_nome, mpv_apelido, mpv_cpf,"
                    + " mpv_dataNascimento, mpv_nivel, mpv_senha, mpv_ativo) "
                    + "values(?,?,?,?,?,?,?) ";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setString(1, mpvUsuarios.getMpvNome());
            pst.setString(2, mpvUsuarios.getMpvApelido());
            pst.setString(3, mpvUsuarios.getMpvCpf());
            pst.setDate(4, mpvUsuarios.getMpvDataNascimento() != null
                    ? new java.sql.Date(mpvUsuarios.getMpvDataNascimento().getTime()) : null);
            pst.setInt(5, mpvUsuarios.getMpvNivel() + 1);
            pst.setString(6, mpvUsuarios.getMpvSenha());
            pst.setString(7, mpvUsuarios.getMpvAtivo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public void update(Object object) {
        MpvUsuarios mpvUsuarios = (MpvUsuarios) object;
        String sql = "UPDATE mpv_usuarios SET mpv_nome=?, mpv_apelido=?, "
                + "mpv_cpf=?, mpv_dataNascimento=?, mpv_nivel=?, "
                + "mpv_senha=?, mpv_ativo=? WHERE mpv_idusuarios=?";

        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setString(1, mpvUsuarios.getMpvNome());
            pst.setString(2, mpvUsuarios.getMpvApelido());
            pst.setString(3, mpvUsuarios.getMpvCpf());
            pst.setDate(4, mpvUsuarios.getMpvDataNascimento() != null
                    ? new java.sql.Date(mpvUsuarios.getMpvDataNascimento().getTime()) : null);
            pst.setInt(5, mpvUsuarios.getMpvNivel());
            pst.setString(6, mpvUsuarios.getMpvSenha());
            pst.setString(7, mpvUsuarios.getMpvAtivo());
            pst.setInt(8, mpvUsuarios.getMpvIdUsuarios());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        MpvUsuarios usuario = (MpvUsuarios) object;
        String sql = "DELETE FROM mpv_usuarios WHERE mpv_idusuarios=?";

        try {
            PreparedStatement smt = cnt.prepareStatement(sql);
            smt.setInt(1, usuario.getMpvIdUsuarios());
            smt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir usuário: " + e.getMessage());
        }
    }

    @Override
    public Object list(int id) {

        MpvUsuarios usuario = null;
        String sql = "SELECT * FROM mpv_usuarios WHERE mpv_idusuarios=?";

        try {
            PreparedStatement smt = cnt.prepareStatement(sql);
            smt.setInt(1, id);
            ResultSet resp = smt.executeQuery();
            if (resp.next()) {
                usuario = new MpvUsuarios();

                usuario.setMpvIdUsuarios(resp.getInt("mpv_idusuarios"));
                usuario.setMpvNome(resp.getString("mpv_nome"));
                usuario.setMpvApelido(resp.getString("mpv_apelido"));
                usuario.setMpvCpf(resp.getString("mpv_cpf"));
                usuario.setMpvDataNascimento(resp.getDate("mpv_dataNascimento"));
                usuario.setMpvNivel(resp.getInt("mpv_nivel"));
                usuario.setMpvSenha(resp.getString("mpv_senha"));
                usuario.setMpvAtivo(resp.getString("mpv_ativo"));
            }
        } catch (SQLException ex) {
            return null;
        }
        return usuario;
    }

    @Override
    public Object listAll() {
        return null;
    }

}