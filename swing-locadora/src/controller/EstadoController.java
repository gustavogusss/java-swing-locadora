package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Estado;
import util.Mensagem;
import util.Titulo;

/**
 * Classe responsável por controlar os métodos do objeto estado
 * 
 * @author Gustavo Metzler Pontes
 * @since 8 de mar. de 2021
 * @version 1.0
 */
public class EstadoController {
	// Declarar o nome do arquivo txt utilizado
	private String arquivo = "estados.txt";
	
	
	/*
	 * Método responsável por retornar uma lista de estados
	 */
	public ArrayList<Estado> getEstados() {
		// Objeto para retornar o método
		ArrayList<Estado> estados = buscarTodos();		
		return estados;
	}
	// Método para ler o arquivo de estados
	private ArrayList<Estado> buscarTodos() {
		// Lista auxiliar para retornar o método
		ArrayList<Estado> estados = new ArrayList<Estado>();
		
		// Ler o arquivo de estados
		try {
			// Classe Scanner auxiliar para ler o arquivo de estados
			Scanner leitor = new Scanner(new FileReader(arquivo));
			
			// LAço de repetição para ler as linhas do arquivo
			while (leitor.hasNext()) {
				// Objeto auxiliar para retornar no método
				Estado estado = getEstado(leitor.nextLine());
				// Atribuindo o objeto estado na lista de retorno
				estados.add(estado);
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroLerArquivo, Titulo.cadastroVendedor, 0);
			e.printStackTrace();
		}
		
		return estados;
	}
	
	// Método para retornar um objeto do tipo estado
	private Estado getEstado(String linha) {
		// Variável auxiliar para converter a linha em objeto
		String aux[] = linha.split(";");
		return new Estado(aux[0], aux[1]);
	}
}
