package br.com.convert.controller;

import java.util.List;

import br.com.convert.dao.FileDao;
import br.com.convert.model.Files;

public class ServiceFile {

	public List<Files> listFiles(){
		FileDao dao = new FileDao();
		return dao.listFiles();
	}
}
