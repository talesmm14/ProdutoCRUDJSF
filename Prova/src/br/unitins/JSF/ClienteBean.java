package br.unitins.JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.ClienteEJB;
import br.unitins.model.Cliente;

@Named
@SessionScoped
public class ClienteBean implements Serializable{
	@EJB
	private ClienteEJB clienteEJB;
	
	private Cliente cliente;
	
	private List<Cliente> clientes;
	private Boolean alterar = false;
	
	@PostConstruct 
	public void init() {
		clientes = clienteEJB.findAll();
	}
	
	public String inserir() {
		clienteEJB.insert(cliente);
		novo();
		return null;
	}
	
	public String alterar(Cliente cli) {
		cliente = cli;
		alterar = true;
		return "cadastroCliente.xhtml?faces-redirect=true";
	}
	
	public String voltar() {
		clienteEJB.update(cliente);
		alterar = false;
		return "cliente.xhtml?faces-redirect=true";
	}
	
	public String apagar(Cliente cli) {
		cliente = cli;
		clienteEJB.delete(cliente);
		return null;
	}
	
	public String novo() {
		cliente = new Cliente();
		return null;
	}
	
	public Cliente getCliente() {
		if (cliente == null)
			cliente = new Cliente();
		return cliente;
	}

	public List<Cliente> getClientes() {
		if (clientes == null)
			clientes = new ArrayList<>();
		clientes = clienteEJB.findAll();
		return clientes;
	}

	public Boolean getAlterar() {
		return alterar;
	}

	public void setAlterar(Boolean alterar) {
		this.alterar = alterar;
	}
}
