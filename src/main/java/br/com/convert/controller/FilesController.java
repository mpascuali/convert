package br.com.convert.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.convert.model.Files;

@ManagedBean
@ViewScoped
public class FilesController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Files> listFiles;
	private ServiceFile service;
	
	public FilesController() {
		listFiles = new ArrayList<Files>();
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
	
	public List<Files> getListFiles() {
		return listFiles;
	}
	public void setListFiles(List<Files> listFiles) {
		this.listFiles = listFiles;
	}
}
