/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetoposjava.controller;

import br.projetoposjava.crud.CrudClientes;
import br.projetoposjava.entity.Cliente;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author brnme
 */
@Path("cliente")
public class ClienteController {
    
    @Context
    private UriInfo context;
    
    private CrudClientes crudClientes;

    public ClienteController() {
        this.crudClientes = new CrudClientes();
    }
    
    @GET
    public List<Cliente> getAllClientes() {
        return crudClientes.getAllClientes();
    }
        
    @GET
    public Cliente getCliente(int id) {
        return crudClientes.getCliente(id);
    }
    
    @POST
    public void salvar(Cliente cliente) {
        crudClientes.salvar(cliente);
    }
    
    @DELETE
    public void deletar(int codigo) {
        crudClientes.deletar(codigo);
    }
    
    @DELETE
    public void deletarTodos() {
        crudClientes.deletarTodos();
    }
    
    @PUT
    public Cliente editar(int codigo) {
        return crudClientes.getCliente(codigo);
    }
    
}
