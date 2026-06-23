/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.MpvProduto;
import dao.DaoMpvProduto;
import java.util.List;
/**
 *
 * @author Giovani
 */
public class ProdutoController {
    private final DaoMpvProduto dao = new DaoMpvProduto();

    public boolean inserir(MpvProduto produto) {
        return dao.insert(produto);
    }

    public void alterar(MpvProduto produto) {
        dao.update(produto);
    }

    public void excluir(MpvProduto produto) {
        dao.delete(produto);
    }

    public MpvProduto pesquisar(int id) {
        return (MpvProduto) dao.list(id);
    }

    @SuppressWarnings("unchecked")
    public List<MpvProduto> listar() {
        return (List<MpvProduto>) dao.listAll();
    }
}
