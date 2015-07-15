package br.com.convert.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.convert.util.convert.ConverteTodosParaUm;
import br.com.convert.util.convert.ConverteUmParaUm;

@ManagedBean
@ViewScoped
public class ConvertBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<UploadedFile> listaDeArquivos = new ArrayList<UploadedFile>();
	private List<String> nome = new ArrayList<String>();
	private ConverteUmParaUm conversor;
	private ConverteTodosParaUm conversao;
	private Map<String, byte[]> mapFiles;
	private UploadedFile file;
	private ServiceFile service;

	public ConvertBean() {
		conversor = new ConverteUmParaUm();
		conversao = new ConverteTodosParaUm();
		mapFiles = new HashMap<String, byte[]>();
		service = new ServiceFile();
	}

	/**
	 * Recebe os arquivos da p�gina home.xhtml
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void receberArquivos(FileUploadEvent event) throws IOException {
		file = event.getFile();
		byte[] b = IOUtils.toByteArray(file.getInputstream());
		mapFiles.put(file.getFileName(), b);
		listaDeArquivos.add(event.getFile());
		nome.add(event.getFile().getFileName());
		System.out.println(event.getFile().getFileName());
	}

	/**
	 * Converte os arquivos selecionados anteriormente.
	 * 
	 * @throws IOException
	 */
	public void converte() throws IOException {
		if (listaDeArquivos.isEmpty()) {
			FacesMessage message = new FacesMessage("Nenhum arquivo selecionado"," Para converter selecione um arquivo ou mais");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {

			List<String> listaCaminho = conversor.converteUp(listaDeArquivos);

			conversao.converteTodos(listaCaminho);

			service.listFiles();
			listaDeArquivos.clear();
			nome.clear();
			new ConvertBean();
		}
	}

	
	// GETTERS AND SETTERS
	public List<String> getNome() {
		return nome;
	}

	public void setNome(List<String> nome) {
		this.nome = nome;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public List<UploadedFile> getListaDeArquivos() {
		return listaDeArquivos;
	}

	public void setListaDeArquivos(List<UploadedFile> listaDeArquivos) {
		this.listaDeArquivos = listaDeArquivos;
	}
}
