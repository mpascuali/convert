package br.com.convert.main;

import java.io.File;
import java.io.FileNotFoundException;

public class TesteMain {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("C:\\Users\\Marcio Pascuali\\Desktop\\harmonia.txt");
		System.out.println(f.getName());
	}
	
}
