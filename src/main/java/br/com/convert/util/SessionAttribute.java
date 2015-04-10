package br.com.convert.util;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import br.com.convert.enums.Session;
import br.com.convert.model.BeanSession;

public class SessionAttribute implements Serializable{
	private static final long serialVersionUID = -7717012124434345222L;
	private static final Logger logger = Logger.getLogger(SessionAttribute.class);

	public static void setAttributeSession(Session attrib,String valueAttrib) {
		infoLog("void setAttributeSession(String aliasAttrib, String valueAttrib) - START");
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute(attrib.getAttribute(), valueAttrib);
		infoLog("void setAttributeSession(String aliasAttrib, String valueAttrib) - END");
	}

	public static BeanSession getSession() {
		infoLog("BeanSession getSession() - START");
		BeanSession beanSession = new BeanSession();
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

		if (session.getAttribute(Session.ID_USER.getAttribute()) != null) {
	    	beanSession.setIdUsers(new Long(session.getAttribute(Session.ID_USER.getAttribute()).toString()));
	    }

	    if (session.getAttribute(Session.MAIL_USER.getAttribute()) != null) {
	    	beanSession.setMail(session.getAttribute(Session.MAIL_USER.getAttribute()).toString());
	    }

	    if (session.getAttribute(Session.NAME_USER.getAttribute()) != null) {
	    	beanSession.setNameUser(session.getAttribute(Session.NAME_USER.getAttribute()).toString());
	    }

	    if (session.getAttribute(Session.PROFILE_USER.getAttribute()) != null) {
	    	beanSession.setProfile(session.getAttribute(Session.PROFILE_USER.getAttribute()).toString());
	    }
	    
	   
	    infoLog("BeanSession getSession() - END");
	    return beanSession;

	}

	private static void infoLog(String msg) {
		if (logger.isDebugEnabled()) {
			logger.debug(msg);
		}
	}
}