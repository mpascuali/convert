package br.com.convert.util.convert;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImagemParaPretoeBranco {
	
public static void main(String[] args) throws IOException {
		
		
		
		BufferedImage imagem = ImageIO.read(new File("C:\\Users\\Administrador\\Desktop\\teste.jpg"));
		
		for(int i=0; i<imagem.getWidth(); i++){
			for(int j=0; j<imagem.getHeight();j++){
				
				Color c = new Color(imagem.getRGB(i, j));
				int tomCinza=(c.getRed()+c.getGreen()+c.getBlue())/3;
				c = new Color(tomCinza, tomCinza, tomCinza);
				imagem.setRGB(i, j, c.getRGB());
				
				
				
			}
		}
		
		ImageIO.write(imagem, "JPG", new File("C:\\Users\\Administrador\\Desktop\\testeCinza.jpg"));
		
		System.out.println("Arquivo pronto JPG");
		
		
	}
	
	public BufferedImage converterPretoBranco(BufferedImage imagem){
		
		for(int i=0; i<imagem.getWidth(); i++){
			for(int j=0; j<imagem.getHeight();j++){
				
				Color c = new Color(imagem.getRGB(i, j));
				int tomCinza=(c.getRed()+c.getGreen()+c.getBlue())/3;
				c = new Color(tomCinza, tomCinza, tomCinza);
				imagem.setRGB(i, j, c.getRGB());
				
				
				
			}
		}
		
		return imagem;
		
	}
}
