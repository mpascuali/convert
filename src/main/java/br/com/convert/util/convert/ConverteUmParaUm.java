package br.com.convert.util.convert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.convert.util.convert.img.ConversaoAPartirDeImagem;
import br.com.convert.util.convert.office.ConversaoAPartirDePlaniliaOffice;
import br.com.convert.util.convert.office.ConversaoAPartirDeTextoOffice;
import br.com.convert.util.convert.txt.ConversaoAPartirDeTexto;

public class ConverteUmParaUm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<String> converte(List<FileUploadEvent> listaDeArquivos) {

		List<String> listaDeCaminho = new ArrayList<String>();

		for (int i = 0; i < listaDeArquivos.size(); i++) {

			ConversaoParaPDF algoritmo = null;
			String nomeArquivo = listaDeArquivos.get(i).getFile().getFileName();
			String extensao = nomeArquivo.substring(nomeArquivo.length() - 3);

			if (extensao.equalsIgnoreCase("txt")) {

				algoritmo = new ConversaoAPartirDeTexto();

			} else if (extensao.equalsIgnoreCase("doc")) {

				algoritmo = new ConversaoAPartirDeTextoOffice();

			} else if (extensao.equalsIgnoreCase("xls")) {

				algoritmo = new ConversaoAPartirDePlaniliaOffice();

			} else if (extensao.equalsIgnoreCase("jpg") || extensao.equalsIgnoreCase("jpeg") || extensao.equalsIgnoreCase("png")) {

				algoritmo = new ConversaoAPartirDeImagem();

			}

			try {
				byte[] arquivo = listaDeArquivos.get(i).getFile().getContents();
				byte[] pdf = algoritmo.converterDocumento(arquivo);
				String caminhoPdf = "C:/Users/Marcio Pascuali/Desktop/Arquivos/ConvertidosPdf/" + nomeArquivo + ".pdf";
				listaDeCaminho.add(caminhoPdf);
				new Bytes().escreverArquivosEmBytes(pdf, caminhoPdf);

				// TODO salvar nome no BD

				// service.salvarArquivo(nomeArquivo);

				FacesMessage message = new FacesMessage("Sucesso", listaDeArquivos.get(i).getFile().getFileName() + " foi convertido para PDF");
				FacesContext.getCurrentInstance().addMessage(null, message);

				PretoBranco pb = new PretoBranco();
				pb.convertePretoBranco(caminhoPdf);

				System.out.println(caminhoPdf);

			} catch (Exception e) {
				System.out.println("OpenOffice desabilitado, contate o Administrator");
				FacesMessage message = new FacesMessage("Falha ao converter " + listaDeArquivos.get(i).getFile().getFileName(), "Motivo: OpenOffice desabilitado, por favor contate o Administrator");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}

		return listaDeCaminho;
	}

	public List<String> converteUp(List<UploadedFile> listaDeArquivos) {

		List<String> listaDeCaminho = new ArrayList<String>();

		for (UploadedFile uploadedFile : listaDeArquivos) {
			
		

			ConversaoParaPDF algoritmo = null;
			String nomeArquivo = uploadedFile.getFileName();
			String extensao = nomeArquivo.substring(nomeArquivo.length() - 3);

			if (extensao.equalsIgnoreCase("txt")) {

				algoritmo = new ConversaoAPartirDeTexto();

			} else if (extensao.equalsIgnoreCase("doc")) {

				algoritmo = new ConversaoAPartirDeTextoOffice();

			} else if (extensao.equalsIgnoreCase("xls")) {

				algoritmo = new ConversaoAPartirDePlaniliaOffice();

			} else if (extensao.equalsIgnoreCase("jpg") || extensao.equalsIgnoreCase("jpeg") || extensao.equalsIgnoreCase("png")) {

				algoritmo = new ConversaoAPartirDeImagem();

			}

			try {
				byte[] arquivo = IOUtils.toByteArray(uploadedFile.getInputstream());
				byte[] pdf = algoritmo.converterDocumento(arquivo);
				String caminhoPdf = "C:/Users/Marcio Pascuali/Desktop/Arquivos/ConvertidosPdf/" + nomeArquivo + ".pdf";
				listaDeCaminho.add(caminhoPdf);
				new Bytes().escreverArquivosEmBytes(pdf, caminhoPdf);

				// TODO salvar nome no BD

				// service.salvarArquivo(nomeArquivo);

				FacesMessage message = new FacesMessage("Sucesso", uploadedFile.getFileName() + " foi convertido para PDF");
				FacesContext.getCurrentInstance().addMessage(null, message);

				PretoBranco pb = new PretoBranco();
				pb.convertePretoBranco(caminhoPdf);

				System.out.println(caminhoPdf);

			} catch (Exception e) {
				System.out.println("OpenOffice desabilitado, contate o Administrator");
				FacesMessage message = new FacesMessage("Falha ao converter " + uploadedFile.getFileName(), "Motivo: OpenOffice desabilitado, por favor contate o Administrator");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}

		return listaDeCaminho;
	}
}
