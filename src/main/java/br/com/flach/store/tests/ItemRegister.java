package br.com.flach.store.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.flach.dao.ItemDao;
import br.com.flach.store.model.Category;
import br.com.flach.store.model.Item;
import br.com.flach.util.JPAUtil;

public class ItemRegister {
	public static void main(String[] args) {
		Item cellphone = new Item("Iphone X", "Pretty cool", new BigDecimal("4500"), Category.CELLPHONE);
		
		EntityManager em = JPAUtil.getEntityManager();
		ItemDao dao = new ItemDao(em);
		
		em.getTransaction().begin();
		dao.register(cellphone);
		em.getTransaction().commit();
		em.close();
	}
}
