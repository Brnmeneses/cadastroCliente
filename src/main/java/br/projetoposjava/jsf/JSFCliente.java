/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetoposjava.jsf;

import br.projetoposjava.client.RestClienteClient;
import br.projetoposjava.controller.ClienteController;
import br.projetoposjava.entity.Cidade;
import br.projetoposjava.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author brnme
 */
@Named(value = "jSFCliente")
@RequestScoped
public class JSFCliente {

    private RestClienteClient rest;
    private ClienteController clienteController;
    private int codigo;
    private String nome;
    private String cidade;
    private String mensagem;
    private boolean exibirMensagem = false;
    private boolean editavel = false;
    private static List<Cidade> cidades = new ArrayList<>();

    /**
     * Creates a new instance of JSFCliente
     */
    public JSFCliente() {
        this.rest = new RestClienteClient();
        this.clienteController = new ClienteController();
        popularCidades();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isExibirMensagem() {
        return exibirMensagem;
    }

    public void setExibirMensagem(boolean exibirMensagem) {
        this.exibirMensagem = exibirMensagem;
    }

    public boolean isEditavel() {
        return editavel;
    }

    public void setEditavel(boolean editavel) {
        this.editavel = editavel;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }
    
    public List<Cliente> getAllClientes() {
        return clienteController.getAllClientes();
    }

    public void salvar() {
        this.editavel = false;
        if (this.codigo < 1) {
            this.exibirMensagem = true;
            this.mensagem = "Código deve ser maior que 0!";
            return;
        }

        Cliente clienteParaDeletar = null;
        for (Cliente cliente : getAllClientes()) {
            if (cliente.getCodigo() == this.codigo) {
                clienteParaDeletar = cliente;
            }
        }

        if (clienteParaDeletar != null) {
            clienteController.deletar(clienteParaDeletar.getCodigo());
        }
        
        Cliente cliente = new Cliente(this.codigo, this.nome, this.cidade);
        clienteController.salvar(cliente);

        this.exibirMensagem = true;
        this.mensagem = "Cliente salvo!";
    }

    public void editar(Cliente cliente) {
        Cliente c = clienteController.editar(cliente.getCodigo());
        this.codigo = c.getCodigo();
        this.nome = c.getNome();
        this.cidade = c.getCidade();
        this.editavel = true;
    }
    
    public void deletar(Cliente cliente) {
        clienteController.deletar(cliente.getCodigo());
        this.exibirMensagem = true;
        this.mensagem = "Cliente deletado!";
    }

    public void limpar() {
        this.codigo = 0;
        this.nome = "";
        this.cidade = "";

        this.exibirMensagem = true;
        this.mensagem = "Campos Limpos!";
    }

    public void deletarClientes() {
        clienteController.deletarTodos();

        this.exibirMensagem = true;
        this.mensagem = "Clientes deletados!";
    }

    private void popularCidades() {
        if (cidades.isEmpty()) {
            cidades = rest.getAll();
        }
    }

}
