package br.com.convert.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.convert.dao.LoginDao;
import br.com.convert.enums.Constantes;
import br.com.convert.enums.Session;
import br.com.convert.model.User;
import br.com.convert.util.FormatData;
import br.com.convert.util.SessionAttribute;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 24902660665520012L;
	private User user = new User();
	private Boolean isValidLogin = false;
	private String currentDate;
	private String currentYear;
	private String currentPage;
	private String currentPageName;


	
	public LoginBean() {
		getCurrentDate();
		getCurrentYear();
		getCurrentPage();
	}

	public String verificarLogin() {
	
		LoginDao dao = new LoginDao();
		String ret = "login";
		if (getuser().getLogin().trim().length() < 1) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("username", new FacesMessage("* Informe o user de acesso!"));
			ret = "login";
		}else if (getuser().getPassword().trim().length() < 1) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("username", new FacesMessage("* Informe a Senha de acesso!"));
			ret = "login";
		}else{
			this.isValidLogin = dao.login(getuser());
			if (this.isValidLogin) {
				getuser().setName(SessionAttribute.getSession().getNameUser());
				SessionAttribute.setAttributeSession(Session.PROFILE_USER,  SessionAttribute.getSession().getProfile());
				
				 
				 
				ret = "home?faces-redirect=true";
			}else if (!this.isValidLogin) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("username", new FacesMessage("* Usu�rio e/ou Senha Inv�lido(s)"));
				ret = "login";
			}
		}
		return ret;
	}

	public String sair() {
		this.isValidLogin = false;
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage("username", new FacesMessage("* Entre com o user e Senha novamente!"));
		return "login";
	}
	
 
	public User getuser() {
		return this.user;
	}

	public void setuser(User user) {
		this.user = user;
	}


	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public String getCurrentDate() {
		this.currentDate = FormatData.showDateView(Constantes.CURRENT_DATE);
		return this.currentDate;
	}

	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}

	public String getCurrentYear() {
		this.currentYear = FormatData.dateFormatedToString(
				Constantes.CURRENT_YEAR, new Date());
		return this.currentYear;
	}

	public String getCurrentPage() {
		this.currentPage = "Acesso Administrativo :: Kewangan�";
		return this.currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public void setCurrentPageName(String currentPageName) {
		this.currentPageName = currentPageName;
	}

	public String getCurrentPageName() {
		return this.currentPageName;
	}

	public Boolean getIsValidLogin() {
		return isValidLogin;
	}

	public void setIsValidLogin(Boolean isValidLogin) {
		this.isValidLogin = isValidLogin;
	}
}
