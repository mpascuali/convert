package br.com.convert.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
/**
 * @author dchagas
 *
 * L  as variaveis do arquivo .properties
 */
public class PropertiesLoader extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(PropertiesLoader.class);
	private static String path = "";
	private static String realPath;
	private static String pathQueued = "";
	
	@Override
	public void init() throws ServletException {
		String prefix = getServletContext().getRealPath("/");
		setRealPath(prefix);
		String file = getInitParameter("pathProperties");
		path = prefix+file;
		pathQueued = prefix + getInitParameter("pathPropertiesQueue");
	}
	
	 private static String getKey(String pathProperties, String key){
    	 infoLog("String getKey(String pathProperties, String key) - START");
		 Properties props = new Properties();
    	 InputStream file;
        try {
            file = new FileInputStream(pathProperties);
            props.load(file);
            file.close();
            infoLog("String getKey(String pathProperties, String key) - END");
            return props.getProperty(key);
        }catch (FileNotFoundException ex) {
        	logger.error("ERRO NO ARQUIVO PROPERTIES: " + ex.getClass().getCanonicalName(), ex);
        	return ex.getMessage();
        }catch (IOException ex) {
        	logger.error("ERRO NO ARQUIVO PROPERTIES: " + ex.getClass().getCanonicalName(), ex);
        	return ex.getMessage();
        }
     }
	 
	 public static String pathFilesQueued(){
		 return pathQueued;
	 }

	 /**
	  * @author dchagas
	  * @param pathFile
	  * @param chave
	  * @return valor da chave
	  */

     public static String getValor(String chave){
    	 return getKey(path,chave);
     }

     private static void infoLog(String msg){
 		if (logger.isDebugEnabled()) {
 			logger.debug(msg);
 		}
 	}

	public static void setRealPath(String realPath) {
		PropertiesLoader.realPath = realPath;
	}

	public static String getRealPath() {
		return realPath;
	}
}
