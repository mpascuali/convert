package br.com.convert.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.convert.bean.FileBean;
import br.com.convert.service.ServiceFile;

@ManagedBean
@ViewScoped
public class FilesMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<FileBean> listFiles;
	private ServiceFile service;
	
	public FilesMB() {
		listFiles = new ArrayList<FileBean>();
		service = new ServiceFile();
		files();
	}
	
	public void files(){
		listFiles = service.listFiles();
		
		/*if(!listFiles.isEmpty()){
			for (Files file : listFiles) {
				file.setDateFormated(FormatData.dateFormToString("dd/MM/yyyy HH:mm:ss", file.getDate()));
			}
		}*/
	}
	
	public List<FileBean> getListFiles() {
		return listFiles;
	}
	public void setListFiles(List<FileBean> listFiles) {
		this.listFiles = listFiles;
	}
}
