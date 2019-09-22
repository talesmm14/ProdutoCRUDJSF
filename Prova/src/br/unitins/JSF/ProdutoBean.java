package br.unitins.JSF;

import java.io.Serializable;

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
}
