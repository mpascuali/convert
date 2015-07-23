package br.com.convert.managedbean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@ViewScoped
public class FileDownloadMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StreamedContent file;

	public FileDownloadMB() {
    	try{
	    	InputStream stream = new FileInputStream("C:/Users/Marcio Pascuali/Desktop/Arquivos/ConvertidosPdf/saida/saida.pdf");
	        file = new DefaultStreamedContent(stream, "application/txt", "saida.pdf");
    	} catch(FileNotFoundException e){
    		FacesMessage message = new FacesMessage("Falha no download ","Motivo: N�o h� arquivo para download");
			FacesContext.getCurrentInstance().addMessage(null, message);
    		e.printStackTrace();
    	}
    }

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}
}
