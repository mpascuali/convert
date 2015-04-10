package br.com.convert.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.convert.util.FacesContextUtil;
import br.com.peopleway.util.DBUtilMySQL;
import br.com.peopleway.util.ExceptionDB;

public class ListenerFases implements PhaseListener {
	private static final long serialVersionUID = -6543643158133918342L;

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	public void afterPhase(PhaseEvent fase) {
		if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
			Connection session = FacesContextUtil.getRequestSession();
			try {
				session.commit();
			} catch (Exception e) {
				if (session != null) {
					try {
						session.rollback();
					} catch (SQLException e1) {
						
					}
				}
				try {
					session.close();
				} catch (SQLException e2) {
					
				}
			} finally {
				try {
					session.close();
				} catch (SQLException e) {
					
				}
			}
		}
	}

	public void beforePhase(PhaseEvent fase) {
		if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
			LoginBean loginBean = (LoginBean) FacesContextUtil.getSessionAttribute("loginBean");
			
			if ((loginBean == null) || (!loginBean.getIsValidLogin())) {
				FacesContextUtil.setNavegacao("login");
			}
		}
		if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
			try {
				Connection session = DBUtilMySQL.getPooledConnection();
				session.setAutoCommit(false);
				FacesContextUtil.setRequestSession(session);
			} catch (SQLException e) {
				
			} catch (ExceptionDB e) {
				
			}
		}
	}
}