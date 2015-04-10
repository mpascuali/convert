/**
 * 
 */
package br.com.convert.model;

/**
 * @author dchagas
 *
 */
public class BeanSession {
	private String nameCorp;
	private Long idClient;
	private Long idUsers;
	private String mail;
	private String fileName;
	private Long idDepartment;
	private String nameUser;
	private Boolean isOpenField;
	private Long idTypeClient;
	private String profile;
	
	
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public Long getIdClient() {
		return this.idClient;
	}

	public void setIdUsers(Long idUsers) {
		this.idUsers = idUsers;
	}

	public Long getIdUsers() {
		return this.idUsers;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMail() {
		return this.mail;
	}

	public void setNameCorp(String nameCorp) {
		this.nameCorp = nameCorp;
	}

	public String getNameCorp() {
		return this.nameCorp;
	}

	public void setIdDepartment(Long idDepartment) {
		this.idDepartment = idDepartment;
	}

	public Long getIdDepartment() {
		return this.idDepartment;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getNameUser() {
		return this.nameUser;
	}

	public void setIsOpenField(Boolean isOpenField) {
		this.isOpenField = isOpenField;
	}

	public Boolean getIsOpenField() {
		return isOpenField;
	}

	public Long getIdTypeClient() {
		return idTypeClient;
	}

	public void setIdTypeClient(Long idTypeClient) {
		this.idTypeClient = idTypeClient;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getProfile() {
		return profile;
	}

}
