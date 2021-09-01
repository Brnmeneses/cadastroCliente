/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetoposjava.crud;

import br.projetoposjava.entity.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brnme
 */
public class CrudClientes {
    private static List<Cliente> listaClientes = new ArrayList<>();

    public CrudClientes() {
    }
    
    public List<Cliente> getAllClientes() {
        return listaClientes;
    }
    
    public Cliente getCliente(int id) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCodigo() == id) {
                return cliente;
            }
        }
        return null;
    }
    
    public void salvar(Cliente cliente) {
        for (Cliente c : listaClientes) {
            if (c.getCodigo() == cliente.getCodigo()) {
                listaClientes.remove(c);
            }
        }
        listaClientes.add(cliente);
    }
    
    public void deletar(int codigo) {
        Cliente cliente = getCliente(codigo);
        listaClientes.remove(cliente);
    }
    
    public Cliente editar(Cliente cliente) {
        return getCliente(cliente.getCodigo());
    }
    
    public void deletarTodos() {
        listaClientes = new ArrayList<>();
    }
}
