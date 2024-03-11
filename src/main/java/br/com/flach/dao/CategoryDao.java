package br.com.flach.dao;

import javax.persistence.EntityManager;

import br.com.flach.store.model.Category;

public class CategoryDao {
	private EntityManager em;

	public CategoryDao(EntityManager em) {
		super();
		this.em = em;
	}

	public void register(Category category) {
		this.em.persist(category);
	}
}