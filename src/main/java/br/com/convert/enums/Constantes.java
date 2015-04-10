package br.com.convert.enums;

public enum Constantes {
	FORMAT_DATE_NUMBER_TASK("ddMMyyyyHHmmss"),
	FORMAT_COMMONS_DATE("dd/MM/yyyy"),
	FORMAT_COMMONS_DATETIME("dd/MM/yyyy HH:mm:ss"),
	FORMAT_DATE_SQL("yyyy-MM-dd"),
	FORMAT_DATETIME_SQL("yyyy-MM-dd HH:mm:ss"),
	CURRENT_YEAR("yyyy"),
	CURRENT_DATE("EEEE, dd 'de' MMMM 'de' yyyy"),
	CURRENT_MONTH_EXTENSE("MMMM 'de' yyyy"),
	CURRENT_HOUR("HH:mm:ss");
	
	private String dataType;
	
	private Constantes(String dataType) {
		this.setDataType(dataType);
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataType() {
		return dataType;
	}
}
