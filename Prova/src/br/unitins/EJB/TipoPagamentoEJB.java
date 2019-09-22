package br.unitins.EJB;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.TipoPagamento;

@Stateful
public class TipoPagamentoEJB {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(TipoPagamento tipoPagamento) {
		em.persist(tipoPagamento);
	}

	public void update(TipoPagamento tipoPagamento) {
       em.merge(tipoPagamento);
	}

	public void delete(TipoPagamento tipoPagamento) {
		System.out.println("Objeto: " + tipoPagamento.getId());
		tipoPagamento = load(tipoPagamento.getId());
		em.remove(tipoPagamento);
	}

	public TipoPagamento load(Integer id) {
		return em.find(TipoPagamento.class, id);
	}
}
