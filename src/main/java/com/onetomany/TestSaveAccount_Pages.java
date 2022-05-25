package com.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveAccount_Pages {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		UsetAccount useraccount = new UsetAccount();
		useraccount.setName("venki");
		useraccount.setEmail("vkvenki");
		useraccount.setMobile("Apple");
		useraccount.setPassword(123456);

		Pages pages = new Pages();
		pages.setDescription("good to use");
		pages.setName("venki");
		pages.setTitle("reels");

		Pages pages1 = new Pages();
		pages1.setDescription("good to use");
		pages1.setName("venki");
		pages1.setTitle("reels");
		List<Pages> pages2 = new ArrayList<Pages>();
		pages2.add(pages);
		pages2.add(pages1);
		useraccount.setPages(pages2);

		entityTransaction.begin();
		entityManager.persist(pages);
		entityManager.persist(pages1);
		entityManager.persist(useraccount);
		entityTransaction.commit();

	}

}
