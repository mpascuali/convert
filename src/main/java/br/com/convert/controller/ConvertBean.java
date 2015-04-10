package br.com.convert.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import br.com.convert.util.convert.ConverteTodosParaUm;
import br.com.convert.util.convert.ConverteUmParaUm;


@ManagedBean
@ViewScoped
public class ConvertBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<FileUploadEvent> listaDeArquivos = new ArrayList<FileUploadEvent>();
	private List<String> nome = new ArrayList<String>();
	private int teste = 0;
	private ConverteUmParaUm conversor;
	private ConverteTodosParaUm conversao;
	
	public ConvertBean() {
		conversor = new ConverteUmParaUm();
		conversao = new ConverteTodosParaUm();
	}
	
	/**
	 * Recebe os arquivos da p�gina home.xhtml
	 * @param event
	 * @throws IOException
	 */
	public void receberArquivos(FileUploadEvent event) throws IOException {
		listaDeArquivos.add(event);
		nome.add(event.getFile().getFileName());
		System.out.println(event.getFile().getFileName());
	}
	
	/**
	 * Converte os arquivos selecionados anteriormente.
	 * @throws IOException
	 */
	public void converte() throws IOException{
		if(listaDeArquivos.size() == 0){
			FacesMessage message = new FacesMessage("Nenhum arquivo selecionado", " Para converter selecione um arquivo ou mais");
	        FacesContext.getCurrentInstance().addMessage(null, message);
	        //return "";
		} else {
			
			List<String> listaCaminho = conversor.converte(listaDeArquivos);
			
    		conversao.converteTodos(listaCaminho);
    		
    		//TODO listar arquivos
    		//new ArquivoMb().listarArquivos();
			listaDeArquivos.clear();
			nome.clear();
			new ConvertBean();
		}
		//return "home?faces-redirect=true";
	}
    

    //GETTERS AND SETTERS
	public List<String> getNome() {
		return nome;
	}
	public void setNome(List<String> nome) {
		this.nome = nome;
	}
	public List<FileUploadEvent> getListaDeArquivos() {
		return listaDeArquivos;
	}
	public void setListaDeArquivos(List<FileUploadEvent> listaDeArquivos) {
		this.listaDeArquivos = listaDeArquivos;
	}
	public int getTeste() {
		return teste;
	}
	public void setTeste(int teste) {
		this.teste = teste;
	}
	
}
