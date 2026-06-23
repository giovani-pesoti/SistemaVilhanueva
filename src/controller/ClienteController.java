/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.MpvCliente;
import dao.DaoMpvCliente;
import java.util.List;

/**
 *
 * @author Giovani
 */
public class ClienteController {

    private final DaoMpvCliente dao = new DaoMpvCliente();

    public boolean inserir(MpvCliente cliente) {
        return dao.insert(cliente);
    }

    public void alterar(MpvCliente cliente) {
        dao.update(cliente);
    }

    public void excluir(MpvCliente cliente) {
        dao.delete(cliente);
    }

    public MpvCliente pesquisar(int id) {
        return (MpvCliente) dao.list(id);
    }

    @SuppressWarnings("unchecked")
    public List<MpvCliente> listar() {
        return (List<MpvCliente>) dao.listAll();
    }
}
