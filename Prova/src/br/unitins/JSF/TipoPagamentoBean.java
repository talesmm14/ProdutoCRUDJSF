package br.unitins.JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.TipoPagamentoEJB;
import br.unitins.model.TipoPagamento;

@Named
@SessionScoped
public class TipoPagamentoBean implements Serializable{
	@EJB
	private TipoPagamentoEJB tipoPagamentoEJB;
	
	private TipoPagamento tipoPagamento;
	
	private List<TipoPagamento> tipoPagamentos;
	
	@PostConstruct 
	public void init() {
		tipoPagamentos = tipoPagamentoEJB.findAll();
	}
	
	public String inserir() {
		tipoPagamentoEJB.insert(tipoPagamento);
		return null;
	}
	
	public String alterar() {
		tipoPagamentoEJB.update(tipoPagamento);
		return null;
	}
	
	public String apagar() {
		tipoPagamentoEJB.delete(tipoPagamento);
		return null;
	}
	
	public String novo() {
		tipoPagamento = new TipoPagamento();
		return null;
	}
	
	public TipoPagamento getTipoPagamento() {
		if (tipoPagamento == null)
			tipoPagamento = new TipoPagamento();
		return tipoPagamento;
	}

	public List<TipoPagamento> getTipoPagamentos() {
		if (tipoPagamentos == null)
			tipoPagamentos = new ArrayList<>();
		return tipoPagamentos;
	}
}
