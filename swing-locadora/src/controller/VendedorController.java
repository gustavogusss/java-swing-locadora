package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Vendedor;
import util.Mensagem;
import util.Titulo;
import util.Util;

/**
 * Classe responsável por controlar a gravação e leitura do arquivo TXT
 * 
 * @author Gustavo Metzler Pontes
 * @since 9 de mar. de 2021
 * @version 1.0
 */
public class VendedorController {
	// Declarar o nome do arquivo txt
	private String arquivo = "vendedor.txt";

	/*
	 * método para gravar registros no arquivo txt
	 */
	public void gravarTxtVendedor(Vendedor vendedor) {
		// Classe auxiliar para carregar um arquivo existente ou criar um novo arquivo
		File file = new File(arquivo);

		try {
			// Classe auxiliar para gerara um objeto de memória para gravação de arquivo
			FileOutputStream arquivoOutPut = new FileOutputStream(file, true);

			// Classe auxiliar para gerara um objeto de memória para gravação de conteúdo
			PrintStream gravador = new PrintStream(arquivoOutPut);

			// Gravando o conteúdo do arquivo
			gravador.print(vendedor.getCodigo());
			gravador.print(";");
			gravador.print(vendedor.getNome());
			gravador.print(";");
			gravador.print(vendedor.getAreaVenda());
			gravador.print(";");
			gravador.print(vendedor.getCidade());
			gravador.print(";");
			gravador.print(vendedor.getEstado());
			gravador.print(";");
			gravador.print(vendedor.getSexo());
			gravador.print(";");
			gravador.print(vendedor.getIdade());
			gravador.print(";");
			gravador.print(vendedor.getSalario());
			gravador.print("\n");

			// Fechando o processo de gravação
			gravador.close();
			arquivoOutPut.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoVendedor, Titulo.cadastroVendedor, 0);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoVendedor, Titulo.cadastroVendedor, 0);
			e.printStackTrace();
		}
	}

	/*
	 * Método para retornar uma lista de vendedores
	 */
	public ArrayList<Vendedor> getVendedores() {
		// Objeto de lista para retornar no método
		ArrayList<Vendedor> vendedores = buscarTodos();

		return vendedores;
	}

	/*
	 * Método para ler o arquivo txt de vendedor
	 */
	private ArrayList<Vendedor> buscarTodos() {
		// Lista auxiliar
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

		try {
			// Classe Scanner auxiliar para ler o arquivo de vendedor
			Scanner leitor = new Scanner(new FileReader(arquivo));

			// laço de repetição para ler as linhas do arquivo
			while (leitor.hasNext()) {

				// objeto auxiliar para retornar no método
				Vendedor vendedor = getVendedor(leitor.nextLine());
				// Atribuindo o objeto vendedor na lista d retorno
				vendedores.add(vendedor);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Retornando a lista de vendedores
		return vendedores;
	}

	/*
	 * Método para retornar um objeto do tipo vendedor
	 */
	private Vendedor getVendedor(String args) {
		// Objeto auxiliar para retornar no método
		Vendedor vendedor = new Vendedor();
		// Variavel aux para quebrar o registro do arquivo
		String aux[] = args.split(";");

		// Valorizando o objeto vendedor
		vendedor.setCodigo(Util.getInt(aux[0]));
		vendedor.setNome(aux[1]);
		vendedor.setAreaVenda(aux[2]);
		vendedor.setCidade(aux[3]);
		vendedor.setEstado(aux[4]);
		vendedor.setSexo(aux[5].charAt(0));
		vendedor.setIdade(Util.getInt(aux[6]));
		vendedor.setSalario(Util.getDouble(aux[7]));

		// Retornando valores
		return vendedor;
	}
}
