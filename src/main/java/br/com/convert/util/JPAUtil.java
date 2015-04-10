package br.com.convert.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("convert");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close(EntityManager manager) {
		manager.close();
	}

}
