package br.com.flach.dao;

import java.util.List;

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
	
	public void update(Item item) {
		this.em.merge(item);
	}
	
	public void remove(Item item) {
		item = this.em.merge(item);
		this.em.remove(item);
	}
	
	public Item selectById(Long id) {
		return em.find(Item.class, id);
	}
	
	public List<Item> listAll() {
		String jpql = "SELECT p FROM Item p";
		return em.createQuery(jpql, Item.class).getResultList();
	}
}

