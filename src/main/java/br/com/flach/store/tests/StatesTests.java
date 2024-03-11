package br.com.flach.store.tests;

import javax.persistence.EntityManager;

import br.com.flach.store.model.Category;
import br.com.flach.util.JPAUtil;

public class StatesTests {
	public static void main(String[] args) {
		
		Category cellphoneCategory = new Category("CELLPHONE");
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(cellphoneCategory);
		
		// This change will be commited:
		cellphoneCategory.setName("XPTO");
		
		em.getTransaction().commit();
		em.close();
		
		// This change will not be commited:
		cellphoneCategory.setName("XPTO");
	}
}
