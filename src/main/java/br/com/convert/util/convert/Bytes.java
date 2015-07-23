package br.com.convert.util.convert;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.io.IOUtils;

import br.com.convert.managedbean.ConvertMB;

public class Bytes implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public byte[] obterArquivosEmBytes(String arquivo) throws IOException {
		return IOUtils.toByteArray(ConvertMB.class.getResourceAsStream(arquivo));
	}

	public void escreverArquivosEmBytes(byte[] arquivo, String nome) throws IOException {
		FileOutputStream file = new FileOutputStream(nome);
		IOUtils.write(arquivo, file);
		IOUtils.closeQuietly(file);
		file.close();
	}

}
