/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.MpvProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Giovani
 */
public class ProdutoTableModel extends AbstractTableModel {

    private List<MpvProduto> lista;

    public List<MpvProduto> getLista() {
        return lista;
    }

    public void setLista(List<MpvProduto> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Código";
            case 1: return "Descrição";
            case 2: return "Tipo";
            case 3: return "Unidade";
            case 4: return "Preço";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MpvProduto produto = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return produto.getIdProdutos();
            case 1: return produto.getDescricao();
            case 2: return produto.getTipo();
            case 3: return produto.getUnidade();
            case 4: return produto.getPreco();
            default: return "";
        }
    }
}
