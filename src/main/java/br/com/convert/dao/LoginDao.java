package br.com.convert.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.convert.model.User;
import br.com.convert.util.JPAUtil;

public class LoginDao implements Serializable {

	private static final long serialVersionUID = 1L;

	public LoginDao() {
	}

	public Boolean login(User user) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Boolean isValidLogin = false;

		Query query = manager.createQuery("select u from User u where u.login = :pLogin and u.password = :pPass").setParameter("pLogin", user.getLogin())
				.setParameter("pPass", user.getPassword());

		isValidLogin = !query.getResultList().isEmpty();

		return isValidLogin;
	}
}
