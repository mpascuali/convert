package br.com.convert.util.convert;

public interface ConversaoParaPDF {
	
	public byte[] converterDocumento(byte[] documentoParaConverter) throws ImpossivelConverterDocumentoException;
	
}