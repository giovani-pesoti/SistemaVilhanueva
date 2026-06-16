/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import bean.MpvUsuarios;
import java.util.Date;

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
//            pst.setInt(1, mpvUsuarios.getMpvIdUsuarios());
            pst.setString(1, mpvUsuarios.getMpvNome());
            pst.setString(2, mpvUsuarios.getMpvApelido());
            pst.setString(3, mpvUsuarios.getMpvCpf());
            pst.setDate(4,null);// java.sql.Date.valueOf(mpvUsuarios.getMpvDataNascimento()));
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
        
        try{
            PreparedStatement smt = cnt.prepareStatement(sql);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (SQLException ex){
            return null;
        }
        return usuario;
    }

    @Override
    public Object listAll() {
        return null;
    }

}
