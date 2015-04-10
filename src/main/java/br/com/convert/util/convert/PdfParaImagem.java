package br.com.convert.util.convert;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Vector;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PdfParaImagem {
	
	@SuppressWarnings("unchecked")
	public Vector<BufferedImage> convert(String caminho){  
        try {  
            Vector<BufferedImage> paginas = new Vector<BufferedImage>();  
            PDDocument document = PDDocument.load(caminho);  
            List<PDPage> pages = document.getDocumentCatalog().getAllPages();  
            for (int i = 0; i < pages.size(); i++) {  
                PDPage singlePage = pages.get(i);  
                BufferedImage buffImage = singlePage.convertToImage();  
                paginas.add(buffImage);  
            }  
            return paginas;  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            return null;  
        }
        
	}
	
}
