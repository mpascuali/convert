package br.com.convert.util.convert;

import br.com.convert.util.convert.img.ConversaoAPartirDeImagem;
import br.com.convert.util.convert.office.ConversaoAPartirDePlaniliaOffice;
import br.com.convert.util.convert.office.ConversaoAPartirDeTextoOffice;
import br.com.convert.util.convert.txt.ConversaoAPartirDeTexto;

public class FabricaDeAlgoritmosDeConversao {
	
	private ConversaoParaPDF conversaoPronta = new ConversaoPronta();
	private ConversaoParaPDF conversaoImagem = new ConversaoAPartirDeImagem();
	private ConversaoParaPDF conversaoTexto = new ConversaoAPartirDeTexto();
	private ConversaoParaPDF conversaoTextoOffice = new ConversaoAPartirDeTextoOffice();
	private ConversaoParaPDF conversaoPlaniliaOffice = new ConversaoAPartirDePlaniliaOffice();
	
	public ConversaoParaPDF getAlgoritmoDeConversao(String extensao) {
	    return this.getAlgoritmoDeConversao(TipoDeDocumento.getTipoDeDocumento(extensao));
	}
	
	public ConversaoParaPDF getAlgoritmoDeConversao(TipoDeDocumento documento) {
		if (TipoDeDocumento.PDF.equals(documento)) {
			return conversaoPronta;
		}
		if (TipoDeDocumento.TXT.equals(documento)) {
			return conversaoTexto;
		}
		if (TipoDeDocumento.DOC.equals(documento) || TipoDeDocumento.RTF.equals(documento) ||
		    TipoDeDocumento.ODT.equals(documento)) {
			return conversaoTextoOffice;
		}
		if (TipoDeDocumento.XLS.equals(documento) || TipoDeDocumento.ODS.equals(documento)) {
		    return conversaoPlaniliaOffice;
		}
		if (TipoDeDocumento.PNG.equals(documento) || TipoDeDocumento.TIFF.equals(documento) ||
			TipoDeDocumento.JPG.equals(documento) || TipoDeDocumento.GIF.equals(documento)) {
			return conversaoImagem;	
		}
		return null;
	}

}
