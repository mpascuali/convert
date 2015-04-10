package br.com.convert.util;

import java.sql.Connection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class FacesContextUtil {
	private static final Logger logger = Logger.getLogger(FacesContextUtil.class);
	private static final String CONNECTION_SESSION = "connection_session";

	public static void setRequestSession(Connection session){
		infoLog("void setRequestSession(Session session) - START");
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(CONNECTION_SESSION, session);
		infoLog("void setRequestSession(Session session) - END");
	}

	public static Connection getRequestSession(){
		infoLog("Session getRequestSession() - START");
		infoLog("Session getRequestSession() - END");
		return (Connection) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(CONNECTION_SESSION);
	}

	public static void setMensagemErro(String mensagem) {
		infoLog("void setMensagemErro - START");
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_FATAL, mensagem, mensagem);
		FacesContext.getCurrentInstance().addMessage(null,fm);
		infoLog("void setMensagemErro - END");
	}

	public static void setMensagemInfo(String mensagem) {
		infoLog("void setMensagemErro - START");
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		FacesContext.getCurrentInstance().addMessage(null, fm);
		infoLog("void setMensagemErro - END");
	}

	public static Object getSessionAttribute(String nomeAtributo) {
		infoLog("Object getSessionAttribute - START");
		infoLog("Object getSessionAttribute - END");
		return ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute(nomeAtributo);
	}

	public static void setNavegacao(String outCome) {
		infoLog("void setNavegacao(String outCome) - START");
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(),null, outCome);
		infoLog("void setNavegacao(String outCome) - END");
	}

	private static void infoLog(String msg){
		if (logger.isDebugEnabled()) {
			logger.debug(msg);
		}
	}
}