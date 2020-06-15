package controller;
//teste
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class RelatorioController implements IRelatorioController {

	public RelatorioController() {
		super();
	}

	@Override
	public void createFile(String path, String name, String name2) throws IOException {
		File dir = new File(path); //diretório a ser utilizado
		File arq = new File(path, name2); //arquivo que será criado com o nome 'name' no diretório 'path'
		if (dir.exists() && dir.isDirectory()) { //verifica se o caminho existe e se é um diretório
			boolean existe = false;
			if (arq.exists() && arq.isFile()) { //verifica se o arquivo existe e se é um arquivo
				existe = true;
			}
			String conteudo = lerArquivo(path, name);
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
		}
	}

	private String lerArquivo(String path, String name) throws IOException {
		File arq = new File(path, name);
		StringBuffer conteudo = new StringBuffer();
		
		//lê o conteudo do .txt
		if (arq.exists() && arq.isFile()) { //verifica se o arquivo existe e se é um arquivo
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			String linha2 = "";
			while (linha != null) {			
				char[] letras = linha.toCharArray(); //converte a linha num vetor de char
				
				//substitui os espaços vazios por ';'
				for(int i =0; i< letras.length; i++) {
					if (letras[i]==' ') {
						letras[i] = ';';
					}
				}
				
				//concatena o vetor de char em uma string novamente
				linha2 = ""; //limpa string
				for(int i=0 ; i<letras.length ; i++) {
					linha2 = linha2+letras[i];
				}
				linha = buffer.readLine();
				conteudo.append(linha2+"\r\n"); //adiciona a linha para o StringBuffer
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo Inválido");
		}
		//retorna o conteudo do .txt
		return conteudo.toString();
	}

	@Override
	public void readFile(String path, String name) throws IOException {
		File arq = new File(path, name);
		if (arq.exists() && arq.isFile()) { //verifica se existe e verifica se é um diretório
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			//faz as operações
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} else {
			throw new IOException("Arquivo inválido");
		}
	}

	@Override
	public void openFile(String path, String name) throws IOException {
		File arq = new File(path, name);
		if (arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}
	
	
}
