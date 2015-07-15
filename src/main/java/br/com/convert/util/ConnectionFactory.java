package br.com.convert.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");

		return (Connection) DriverManager
				.getConnection("jdbc:mysql://localhost:3306/conversor","root", "root");
	}

}
