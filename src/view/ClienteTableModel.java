/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.MpvCliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel {

    private List<MpvCliente> lista;

    public List<MpvCliente> getLista() {
        return lista;
    }

    public void setLista(List<MpvCliente> lista) {
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
            case 1: return "Nome";
            case 2: return "CPF";
            case 3: return "Email";
            case 4: return "Telefone";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MpvCliente cliente = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getIdCliente();
            case 1: return cliente.getNome();
            case 2: return cliente.getCpf();
            case 3: return cliente.getEmail();
            case 4: return cliente.getTelefone();
            default: return "";
        }
    }
}