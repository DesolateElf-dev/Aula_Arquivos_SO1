package controller;

import java.io.IOException;

public interface IRelatorioController {

	public void createFile(String path, String name, String name2) throws IOException;
	
	public void readFile(String path, String name) throws IOException;
	
	public void openFile(String path, String name) throws IOException;

}
