/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.MpvProduto;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Giovani
 */
public class DaoMpvProduto extends DaoAbstract {

    Connection cnt;

    public DaoMpvProduto() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db_atividade_mvc?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";            String user = "root";
            String password = "";
            cnt = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoMpvProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean insert(Object object) {
        MpvProduto produto = (MpvProduto) object;
        String sql = "INSERT INTO mpv_produtos (descricao, tipo, unidade, preco) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setString(1, produto.getDescricao());
            pst.setString(2, produto.getTipo());
            pst.setString(3, produto.getUnidade());
            pst.setBigDecimal(4, produto.getPreco());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvProduto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void update(Object object) {
        MpvProduto produto = (MpvProduto) object;
        String sql = "UPDATE mpv_produtos SET descricao=?, tipo=?, unidade=?, preco=? WHERE id_produtos=?";
        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setString(1, produto.getDescricao());
            pst.setString(2, produto.getTipo());
            pst.setString(3, produto.getUnidade());
            pst.setBigDecimal(4, produto.getPreco());
            pst.setInt(5, produto.getIdProdutos());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        MpvProduto produto = (MpvProduto) object;
        String sql = "DELETE FROM mpv_produtos WHERE id_produtos=?";
        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, produto.getIdProdutos());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        MpvProduto produto = null;
        String sql = "SELECT * FROM mpv_produtos WHERE id_produtos=?";
        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                produto = montarProduto(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    @Override
    public Object listAll() {
        List<MpvProduto> lista = new ArrayList<>();
        String sql = "SELECT * FROM mpv_produtos ORDER BY descricao";
        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                lista.add(montarProduto(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private MpvProduto montarProduto(ResultSet rs) throws SQLException {
        MpvProduto produto = new MpvProduto();
        produto.setIdProdutos(rs.getInt("id_produtos"));
        produto.setDescricao(rs.getString("descricao"));
        produto.setTipo(rs.getString("tipo"));
        produto.setUnidade(rs.getString("unidade"));
        produto.setPreco(rs.getBigDecimal("preco"));
        return produto;
    }
}
