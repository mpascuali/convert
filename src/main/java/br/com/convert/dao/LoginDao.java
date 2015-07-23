package br.com.convert.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import br.com.convert.enums.Session;
import br.com.convert.model.User;
import br.com.convert.util.SessionAttribute;
import br.com.peopleway.util.DBUtilMySQL;

public class LoginDao implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LoginDao.class);
	private Connection conn = null;

	public LoginDao() {
	}
	
	public Boolean login(User beanLogin) {
		Boolean ret = false;
		PreparedStatement prp = null;
		ResultSet rs = null;
		try {
			conn = DBUtilMySQL.getPooledConnection();
			prp = this.conn.prepareStatement("SELECT * FROM user u , user_profile up WHERE up.id = u.id_user_profile AND login = ? AND password =  ? AND active=1;");
			prp.setString(1, beanLogin.getLogin());
			prp.setString(2, beanLogin.getPassword());
			 
			rs = prp.executeQuery();
			if (rs.next()) {
				SessionAttribute.setAttributeSession(Session.ID_USER,String.valueOf(rs.getInt("id")));
				SessionAttribute.setAttributeSession(Session.NAME_USER,rs.getString("name"));
				SessionAttribute.setAttributeSession(Session.PROFILE_USER, rs.getString("id_user_profile"));
				ret = true;
			}

		} catch (Exception e) {
			logger.error("String login(BeanLogin beanAutenticado) - ERROR ", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (prp != null) {
					prp.close();
				}
			} catch (SQLException e) {
				logger.error("String login(BeanLogin beanAutenticado) - "+ getClass().getCanonicalName(), e);
			}
		}
		return ret;
	}

	
	/*public Boolean login(User user) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Boolean isValidLogin = false;

		Query query = manager.createQuery("select u from User u where u.login = :pLogin and u.password = :pPass").setParameter("pLogin", user.getLogin())
				.setParameter("pPass", user.getPassword());

		isValidLogin = !query.getResultList().isEmpty();

		return isValidLogin;
	}*/
}
