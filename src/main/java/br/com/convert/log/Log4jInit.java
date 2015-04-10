package br.com.convert.log;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class Log4jInit extends HttpServlet {
	private static final long serialVersionUID = -8885882095329168441L;

	@Override
	public void init() {
		String prefix = getServletContext().getRealPath("/");
		String file = getInitParameter("log4j-init-file");
		if (file != null) {
			PropertyConfigurator.configure(prefix + file);
		} else {
			BasicConfigurator.configure();
		}
	}
}