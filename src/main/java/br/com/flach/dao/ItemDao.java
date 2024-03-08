package br.com.flach.dao;

import javax.persistence.EntityManager;

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
}