package br.unitins.JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.PedidoEJB;
import br.unitins.EJB.ProdutoEJB;
import br.unitins.model.Pedido;
import br.unitins.model.Produto;

@Named
@SessionScoped
public class PedidoBean implements Serializable {
	@EJB
	private PedidoEJB pedidoEJB;
	
	@EJB
	private ProdutoEJB produtoEJB;

	private Pedido pedido;

	private List<Pedido> pedidos;

	private List<Produto> produtos;

	@PostConstruct
	public void init() {
		pedidos = pedidoEJB.findAll();
	}

	public String inserir() {
		pedidoEJB.insert(pedido);
		return null;
	}

	public String alterar() {
		pedidoEJB.update(pedido);
		return null;
	}

	public String apagar() {
		pedidoEJB.delete(pedido);
		return null;
	}

	public String novo() {
		pedido = new Pedido();
		return null;
	}

	public String cadastrarProdutos(int id) {
		produtos.add(produtoEJB.load(id));
		pedido.setProdutos(produtos);
		return null;
	}

	public Pedido getPedido() {
		if (pedido == null)
			pedido = new Pedido();
		return pedido;
	}

	public List<Pedido> getPedidos() {
		if (pedidos == null)
			pedidos = new ArrayList<>();
		pedidos = pedidoEJB.findAll();
		return pedidos;
	}

	public List<Produto> getProdutos() {
		if (produtos == null)
			produtos = new ArrayList<>();
		produtos = produtoEJB.findAll();
		return produtos;
	}
}
