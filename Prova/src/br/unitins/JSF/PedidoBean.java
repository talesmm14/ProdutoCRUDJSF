package br.unitins.JSF;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.PedidoEJB;
import br.unitins.model.Pedido;

@Named
@SessionScoped
public class PedidoBean implements Serializable{
	@EJB
	private PedidoEJB PedidoEJB;
	
	private Pedido Pedido;
	
	private List<Pedido> pedidos;
	
	public String inserir() {
		PedidoEJB.insert(Pedido);
		return null;
	}
	
	public String alterar() {
		PedidoEJB.update(Pedido);
		return null;
	}
	
	public String apagar() {
		PedidoEJB.delete(Pedido);
		return null;
	}
	
	public String novo() {
		Pedido = new Pedido();
		return null;
	}
	
	public Pedido getPedido() {
		if (Pedido == null)
			Pedido = new Pedido();
		return Pedido;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
