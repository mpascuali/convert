package br.com.convert.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.convert.bean.FileBean;

public interface InterfaceFile extends Serializable {
	
	public List<FileBean> listFiles();
	public void saveFileName(String fileName);

}
