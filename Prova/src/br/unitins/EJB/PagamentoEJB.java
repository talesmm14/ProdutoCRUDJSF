package br.unitins.EJB;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Cliente;
import br.unitins.model.Pagamento;

@Stateful
public class PagamentoEJB {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Pagamento pagamento) {
		em.persist(pagamento);
	}

	public void update(Pagamento pagamento) {
       em.merge(pagamento);
	}

	public void delete(Pagamento pagamento) {
		System.out.println("Objeto: " + pagamento.getId());
		pagamento = load(pagamento.getId());
		em.remove(pagamento);
	}

	public Pagamento load(Integer id) {
		return em.find(Pagamento.class, id);
	}
	
	public List<Pagamento> findAll() {
		return em.createQuery("select p from Pagamento p", Pagamento.class).getResultList();
	}
}
