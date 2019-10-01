package br.unitins.JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.PagamentoEJB;
import br.unitins.EJB.PedidoEJB;
import br.unitins.model.Pagamento;
import br.unitins.model.Pedido;

@Named
@SessionScoped
public class PagamentoBean implements Serializable {
	@EJB
	private PagamentoEJB pagamentoEJB;

	@EJB
	private PedidoEJB pedidoEJB;

	private Integer idPedido;

	private Pagamento pagamento;

	private Pedido pedido;

	private List<Pagamento> pagamentos;

	@PostConstruct
	public void init() {
		pagamentos = pagamentoEJB.findAll();
	}

	public String inserir() {
		System.out.println("idPedido " + idPedido);
		pagamentoEJB.insert(pagamento);	
		pedido = pedidoEJB.load(idPedido);
		pedido.setPagamento(pagamento);
		pedidoEJB.update(pedido);
		novo();
		return null;
	}

	public String alterar() {
		pagamentoEJB.update(pagamento);
		return null;
	}

	public String apagar(Pagamento pag) {
		pagamentoEJB.delete(pag);
		return null;
	}

	public String novo() {
		pagamento = new Pagamento();
		return null;
	}

	public Pagamento getPagamento() {
		if (pagamento == null)
			pagamento = new Pagamento();
		pagamentos = pagamentoEJB.findAll();
		return pagamento;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public List<Pagamento> getPagamentos() {
		if (pagamentos == null)
			pagamentos = new ArrayList<>();
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
}
