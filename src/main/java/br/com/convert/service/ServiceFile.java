package br.com.convert.service;

import java.util.List;

import br.com.convert.bean.FileBean;
import br.com.convert.dao.FileDao;
import br.com.convert.interfaces.InterfaceFile;

public class ServiceFile implements InterfaceFile{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<FileBean> listFiles() {
		FileDao dao = new FileDao();
		return dao.listFiles();
	}

	@Override
	public void saveFileName(String fileName) {
		FileDao dao = new FileDao();
		dao.saveFileName(fileName);
	}
	
	


}
