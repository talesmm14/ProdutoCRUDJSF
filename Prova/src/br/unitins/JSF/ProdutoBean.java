package br.unitins.JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.unitins.EJB.ProdutoEJB;
import br.unitins.model.Cliente;
import br.unitins.model.Produto;

@Named
@SessionScoped
public class ProdutoBean implements Serializable {
	@EJB
	private ProdutoEJB produtoEJB;

	private Produto produto;
	private Boolean alterar = false;
	
	private List<Produto> produtos;
	
	@PostConstruct 
	public void init() {
		produtos = produtoEJB.findAll();
	}

	public String inserir() {
		produtoEJB.insert(produto);
		novo();
		return null;
	}
	
	@Transactional
	public String alterar(Produto prod) {
		produto = prod;
		setAlterar(true);
		return "cadastroProduto.xhtml?faces-redirect=true";
	}
	
	public String voltar() {
		produtoEJB.update(produto);
		setAlterar(false);
		return "produto.xhtml?faces-redirect=true";
	}

	public String apagar(Produto prod) {
		produtoEJB.delete(prod);
		return null;
	}

	public String novo() {
        produto = new Produto();
		return null;
	}
	
	public Produto getProduto() {
		if (produto == null) 
			produto = new Produto();
		return produto;
	}

	public List<Produto> getProdutos() {
		if (produtos == null)
			produtos = new ArrayList<>();
		produtos = produtoEJB.findAll();
		return produtos;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Boolean getAlterar() {
		return alterar;
	}

	public void setAlterar(Boolean alterar) {
		this.alterar = alterar;
	}
	
	
}
