package com.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TextSavePersonbank {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=new Person();
		person.setName("venki");
		person.setAge(22);
		person.setMobile(3694454);
		
		List<Bank> banks= new ArrayList<Bank>();
		Bank bank= new Bank();
		bank.setName("karnataka bank");
		bank.setBranch("kollegala");
		bank.setIfsc("karb000123");
		person.setBanks(banks);
		Bank bank1= new Bank();
		bank1.setName("canara bank");
		bank1.setBranch("kollegala");
		bank1.setIfsc("carb000123");
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(bank);
		entityManager.persist(bank1);
		entityTransaction.commit();
	}
}
