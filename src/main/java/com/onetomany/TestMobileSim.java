package com.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMobileSim {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Mobile mobile = new Mobile();
		mobile.setName("apple");
		mobile.setCost(500000);
		Mobile mobile1 = new Mobile();
		mobile1.setName("samsung");
		mobile1.setCost(4000000);

		Sim sim1 = new Sim();
		sim1.setProvider("Airtel");
		sim1.setType("3g");

		Sim sim2 = new Sim();
		sim2.setProvider("Airtel");
		sim2.setType("4g");
		Sim sim3 = new Sim();
		sim3.setProvider("jio");
		sim3.setType("4g");
		Sim sim4 = new Sim();
		sim4.setProvider("bsnl");
		sim4.setType("4g");

		List<Sim> sims = new ArrayList<Sim>();
		sims.add(sim1);
		sims.add(sim2);
		mobile.setSims(sims);

		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityManager.persist(sim3);
		entityManager.persist(sim4);
		entityTransaction.commit();

	}

}
