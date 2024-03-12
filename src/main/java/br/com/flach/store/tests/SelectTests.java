package br.com.flach.store.tests;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.flach.dao.CategoryDao;
import br.com.flach.dao.ItemDao;
import br.com.flach.store.model.Category;
import br.com.flach.store.model.Item;
import br.com.flach.util.JPAUtil;

public class SelectTests {
	public static void main(String[] args) {
		insertItem();
		
		EntityManager em = JPAUtil.getEntityManager();
		ItemDao itemDao = new ItemDao(em);
		
		Item p = itemDao.selectById(1l);
		System.out.println(p.getPrice());
		
		List<Item> items = itemDao.listAll();
		items.forEach(x -> System.out.println(x.getName()));
		
		items = itemDao.selectByName("Iphone X");
		items.forEach(x -> System.out.println(x.getName()));
		
		items = itemDao.selectByCategory("CELLPHONE");
		items.forEach(x -> System.out.println(x.getName()));
		
	}

	private static void insertItem() {
		Category cellphoneCategory = new Category("CELLPHONE");

		Item cellphone = new Item("Iphone X", "Pretty cool", new BigDecimal("4500"), cellphoneCategory);

		EntityManager em = JPAUtil.getEntityManager();
		ItemDao itemDao = new ItemDao(em);
		CategoryDao categoryDao = new CategoryDao(em);

		em.getTransaction().begin();
		categoryDao.register(cellphoneCategory);
		itemDao.register(cellphone);
		em.getTransaction().commit();
		em.close();
	}
}
