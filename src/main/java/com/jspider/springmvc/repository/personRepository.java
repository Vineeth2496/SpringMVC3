package com.jspider.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspider.springmvc.pojo.personPojo;


@Repository
public class personRepository {
	private static EntityManager manager;
	private static EntityManagerFactory factory;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpql;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("mvc");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public personPojo addPerson(String name, String email) {
		openConnection();
		transaction.begin();
		personPojo pojo = new personPojo();
		pojo.setName(name);
		pojo.setEmail(email);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}
	public personPojo searchPerson(String name) {
		openConnection();
		transaction.begin();
		personPojo pojo=manager.find(personPojo.class, name);
		if(pojo != null) {
			transaction.commit();
			closeConnection();
			return pojo;
		}
		transaction.commit();
		closeConnection();
		return null;
	}
	public List<personPojo> allPersons() {
		openConnection();
		transaction.begin();
		jpql="from personPojo";
		query=manager.createQuery(jpql);
		List<personPojo> person= query.getResultList();
		transaction.commit();
		closeConnection();
		return person;
		
	}

}
