package br.unitins.JSF;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.TipoPagamentoEJB;
import br.unitins.model.TipoPagamento;

@Named
@SessionScoped
public class TipoPagamentoBean implements Serializable{
	@EJB
	private TipoPagamentoEJB TipoPagamentoEJB;
	
	private TipoPagamento TipoPagamento;
	
	public String inserir() {
		TipoPagamentoEJB.insert(TipoPagamento);
		return null;
	}
	
	public String alterar() {
		TipoPagamentoEJB.update(TipoPagamento);
		return null;
	}
	
	public String apagar() {
		TipoPagamentoEJB.delete(TipoPagamento);
		return null;
	}
	
	public String novo() {
		TipoPagamento = new TipoPagamento();
		return null;
	}
	
	public TipoPagamento getTipoPagamento() {
		if (TipoPagamento == null)
			TipoPagamento = new TipoPagamento();
		return TipoPagamento;
	}
}
