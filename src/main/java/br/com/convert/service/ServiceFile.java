package br.com.convert.service;

import java.util.List;

import br.com.convert.bean.FileBean;
import br.com.convert.dao.FileDao;

public class ServiceFile {

	public List<FileBean> listFiles(){
		FileDao dao = new FileDao();
		return dao.listFiles();
	}

	public void saveFileName(String fileName) {
		FileDao dao = new FileDao();
		dao.saveFileName(fileName);
	}
}
