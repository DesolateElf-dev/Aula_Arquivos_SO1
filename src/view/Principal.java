package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.IRelatorioController;
import controller.RelatorioController;

//Pegar o arquivo relatório.txt, colocar em um diretório que o permita ser lido e:
//faça a leitura e coloque seu conteúdo em um arquivo CSV, para que seja lido pelo Excel.

public class Principal {

	public static void main(String[] args) {
		
		IRelatorioController arqCont = new RelatorioController();
		String path = "C:\\temp"; //diretório
		String name = "relatorio.txt"; //arquivo lido .txt
		String name2 = "relatorio.csv"; //arquivo criado .csv
		
		try {
			int opc=0;

			while(opc!=9) {
				opc = Integer.parseInt(JOptionPane.showInputDialog(
						"1- Lê arquivo"+
						"\n2- Cria relatorio.csv" +
						"\n3 - Abre arquivo no excel"+
						"\n9 - Finalizar"));
				switch (opc){
					case 1: {
		    			int opc2 = Integer.parseInt(JOptionPane.showInputDialog(null, "1- relatório.txt \n2- Relatório.csv",
		    					"Entrada de inteiro", JOptionPane.INFORMATION_MESSAGE));
		    			if (opc2 == 1) {
		    				arqCont.readFile(path, name);
		    			} else {
		    				if (opc2 ==2) {
		    					arqCont.readFile(path, name2);
		    				} else {
		    					JOptionPane.showMessageDialog(null,"Opção Inválida");
		    				}
		    			}
		    		}
						break;
		    		case 2: arqCont.createFile(path, name, name2);
		    			break;
		    		case 3: arqCont.openFile(path, name2);
		    			break;
		    		case 9: {
		    			System.out.println("Programa Finalizado");
		    			System.exit(0);
		    		}
		    		default: JOptionPane.showMessageDialog(null,"Inválido");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
