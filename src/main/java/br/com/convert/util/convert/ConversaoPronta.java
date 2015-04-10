package br.com.convert.util.convert;

public class ConversaoPronta implements ConversaoParaPDF {

	public byte[] converterDocumento(byte[] documento) throws ImpossivelConverterDocumentoException {
		return documento;
	}

}
