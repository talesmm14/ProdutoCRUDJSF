package br.unitins.EJB;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Pedido;

@Stateful
public class PedidoEJB {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Pedido pedido) {
		em.persist(pedido);
	}

	public void update(Pedido pedido) {
       em.merge(pedido);
	}

	public void delete(Pedido pedido) {
		System.out.println("Objeto: " + pedido.getId());
		pedido = load(pedido.getId());
		em.remove(pedido);
	}

	public Pedido load(Integer id) {
		return em.find(Pedido.class, id);
	}
	public List<Pedido> findAll() {
		return em.createQuery("select p from Pedido p", Pedido.class).getResultList();
	}
}
