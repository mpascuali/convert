package br.com.convert.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.convert.model.Files;
import br.com.convert.util.JPAUtil;


public class FileDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<Files> listFiles(){
			EntityManager manager = new JPAUtil().getEntityManager();
			
			List<Files> list = new ArrayList<Files>();

			Query query = manager.createQuery("select u from Files u order by u.date desc");

			list = query.getResultList();

			return list;
	}

	public void saveFileName(Files file) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(file);
		
		manager.getTransaction().commit();
		manager.close();
	}
}
