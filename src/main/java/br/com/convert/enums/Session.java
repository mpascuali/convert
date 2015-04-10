package br.com.convert.enums;

public enum Session {
	ID_USER("idUsers"),
	MAIL_USER("mail"),
	NAME_USER("nameUser"),
	PROFILE_USER("profile"),
	ID("id_cadastro_inicial"),
	NAME("name"),
	CPF("cpf"),
	EMAIL("email"),
	CELLPHONE("cellphone"),
	STREET("street"),
	NUMBER("number"),
	COMPLEMENT("complement"),
	NEIGHBORHOOD("neighborhood"),
	CITY("city"),
	STATE("state"),
	CEP("cep"),
	SHOPNAME("shopName"),
	NFCCO("nfCco"),
	CLIENTID("clientId"),
	HISTORY("history"),
	STATUS("status"),
	DATE("date"),
	USER("user"),
	URL("url"),
	NUMBERNF("numberNF"),
	RG("rg"),
	PHONE("phone"),
	CLUBSENSEO("clubSenseo"),
	DATECUPOM("dateCupom"),
	DATEINI("dateIni"),
	URLCALLCENTER("urlCallcenter"),
	QTD("qtd");
	
	
	private String attribute;
	
	private Session(String attribute) {
		this.setAttribute(attribute);
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getAttribute() {
		return attribute;
	}
}
