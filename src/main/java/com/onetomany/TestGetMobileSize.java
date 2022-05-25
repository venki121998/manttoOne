package com.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetMobileSize {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Mobile mobile = entityManager.find(Mobile.class, 5);
		if(mobile!=null){
		System.out.println("Mobile name is" + mobile.getName());
		System.out.println("Mobile cost is" + mobile.getCost());

		List<Sim> sims = mobile.getSims();
		
			for (Sim sim : sims) {

				System.out.println("sim id is" + sim.getId());
				System.out.println("sim provider" + sim.getProvider());
				System.out.println("sim type" + sim.getType());
				System.out.println("=============================");
			}
		}
		else
		{
			System.out.println("no mobile is found for this id");
		}
		

	}

}
