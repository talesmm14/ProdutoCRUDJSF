package br.unitins.JSF;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.PagamentoEJB;
import br.unitins.model.Pagamento;

@Named
@SessionScoped
public class PagamentoBean implements Serializable{
	@EJB
	private PagamentoEJB pagamentoEJB;
	
	private Pagamento pagamento;
	
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
		return pagamento;
	}
}
