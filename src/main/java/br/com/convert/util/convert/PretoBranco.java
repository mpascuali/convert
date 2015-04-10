package br.com.convert.util.convert;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;

public class PretoBranco implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<BufferedImage> convertePretoBranco(String caminho) throws IOException {
		
		List<BufferedImage> imagens = new ArrayList<BufferedImage>();
		PdfParaImagem pdf = new PdfParaImagem();
		ImagemParaPretoeBranco pretoBranco = new ImagemParaPretoeBranco();
		
		System.out.println("Come�ando conversao PDF");
		
		Vector<BufferedImage> conversor = pdf.convert(caminho);
		
		for (int i = 0; i < conversor.size(); i++) {
			
			
			BufferedImage imagem = conversor.get(i);
			imagens.add(conversor.get(i));
			BufferedImage imagemPretoBranco = pretoBranco.converterPretoBranco(imagem);
			
			ImageIO.write(imagemPretoBranco, "JPG", new File("C:\\Users\\Marcio\\Desktop\\Arquivos\\ConvertidosPdf\\ImagensPretoBranco\\"+i+".jpg"));
			
			
		}
		
		System.out.println("Arquivo PDF terminado");
		return conversor;
		
	}
	

}
