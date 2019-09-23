package br.unitins.JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.ProdutoEJB;
import br.unitins.model.Produto;

@Named
@SessionScoped
public class ProdutoBean implements Serializable {
	@EJB
	private ProdutoEJB produtoEJB;

	private Produto produto;
	
	private List<Produto> produtos;
	
	@PostConstruct 
	public void init() {
		produtos = produtoEJB.findAll();
	}

	public String inserir() {
		produtoEJB.insert(produto);
		return null;
	}
	
	public String alterar() {
		produtoEJB.update( produto);
		return null;
	}

	public String apagar() {
		produtoEJB.delete(produto);
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
		return produtos;
	}
}
