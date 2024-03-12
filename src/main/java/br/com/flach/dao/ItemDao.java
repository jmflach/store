package br.com.flach.dao;

import java.math.BigDecimal;
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
	
	public List<Item> selectByName(String name) {
		String jpql = "SELECT p FROM Item p WHERE p.name = :n";
		return em.createQuery(jpql, Item.class)
				.setParameter("n", name)
				.getResultList();
	}
	
	public List<Item> selectByCategory(String category) {
		String jpql = "SELECT p FROM Item p WHERE p.category.name = :c";
		return em.createQuery(jpql, Item.class)
				.setParameter("c", category)
				.getResultList();
	}
	
	public BigDecimal selectPriceByName(String name) {
		String jpql = "SELECT p.price FROM Item p WHERE p.name = :n";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("n", name)
				.getSingleResult();
	}
}

