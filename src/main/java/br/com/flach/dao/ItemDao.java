package br.com.flach.dao;

import javax.persistence.EntityManager;

import br.com.flach.store.model.Category;
import br.com.flach.store.model.Item;

public class ItemDao {
	private EntityManager em;

	public ItemDao(EntityManager em) {
		super();
		this.em = em;
	}

	public void register(Item item) {
		this.em.persist(item);
	}
	
	public void update(Item item) {
		this.em.merge(item);
	}
	
	public void remove(Item item) {
		this.em.remove(item);
	}
}