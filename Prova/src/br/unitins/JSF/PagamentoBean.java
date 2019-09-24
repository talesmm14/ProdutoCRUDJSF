package br.unitins.JSF;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.PagamentoEJB;
import br.unitins.EJB.PedidoEJB;
import br.unitins.model.Pagamento;

@Named
@SessionScoped
public class PagamentoBean implements Serializable {
	@EJB
	private PagamentoEJB pagamentoEJB;
	
	@EJB
	private PedidoEJB pedidoEJB;

	private Pagamento pagamento;

	private List<Pagamento> pagamentos;

	@PostConstruct
	public void init() {
		pagamentos = pagamentoEJB.findAll();
	}

	public String inserir() {
		pagamentoEJB.insert(pagamento);
		
		return null;
	}

	public String alterar() {
		pagamentoEJB.update(pagamento);
		return null;
	}

	public String apagar() {
		pagamentoEJB.delete(pagamento);
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
}
