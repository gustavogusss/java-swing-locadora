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

import model.Filme;
import model.Vendedor;
import util.Mensagem;
import util.Titulo;
import util.Util;

/**
 * Classe responsável por salvar registros de filmes em arquivo TXT
 * 
 * @author Gustavo Metzler Pontes
 * @since 9 de mar. de 2021
 * 
 */
public class FilmeController {
	// Arquivo 
	private String arquivo = "filme.txt";
	public void gravarTxtFilme(Filme filme) {
		// Classe auxiliar para carregar um arquivo existente ou criar um novo arquivo
				File file = new File(arquivo);

				try {
					// Classe auxiliar para gerara um objeto de memória para gravação de arquivo
					FileOutputStream arquivoOutPut = new FileOutputStream(file, true);

					// Classe auxiliar para gerara um objeto de memória para gravação de conteúdo
					PrintStream gravador = new PrintStream(arquivoOutPut);

					// Gravando o conteúdo do arquivo
					gravador.print(filme.getCodigo());
					gravador.print(";");
					gravador.print(filme.getNome());
					gravador.print(";");
					gravador.print(filme.getValor());
					gravador.print(";");
					gravador.print(filme.isDisponivel());
					gravador.print(";");
					gravador.print(filme.isPromocao());
					gravador.print(";");
					gravador.print(filme.getValorPromocao());
					gravador.print(";");
					gravador.print(filme.getGenero());
					gravador.print("\n");

					// Fechando o processo de gravação
					gravador.close();
					arquivoOutPut.close();

				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoVendedor, Titulo.cadastroFilme, 0);
					e.printStackTrace();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoVendedor, Titulo.cadastroFilme, 0);
					e.printStackTrace();
				}
	}
	
	/*
	 * Método para retornar uma lista de filmes
	 */
	public ArrayList<Filme> getFilmes() {
		// Objeto de lista para retornar no método
		ArrayList<Filme> filmes = buscarTodos();

		return filmes;
	}
	
	/*
	 * Método para ler o arquivo txt de vendedor
	 */
	private ArrayList<Filme> buscarTodos() {
		// Lista auxiliar
		ArrayList<Filme> filmes = new ArrayList<Filme>();

		try {
			// Classe Scanner auxiliar para ler o arquivo de vendedor
			Scanner leitor = new Scanner(new FileReader(arquivo));

			// laço de repetição para ler as linhas do arquivo
			while (leitor.hasNext()) {

				// objeto auxiliar para retornar no método
				Filme filme = getFilme(leitor.nextLine());
				// Atribuindo o objeto vendedor na lista d retorno
				filmes.add(filme);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Retornando a lista de vendedores
		return filmes;
	}
	
	/*
	 * Método para retornar um objeto do tipo filme
	 */
	private Filme getFilme(String args) {
		// Objeto auxiliar para retornar no método
		Filme filme = new Filme();
		// Variavel aux para quebrar o registro do arquivo
		String aux[] = args.split(";");

		// Valorizando o objeto vendedor
		filme.setCodigo(Util.getInt(aux[0]));
		filme.setNome(aux[1]);
		filme.setValor(Util.getDouble(aux[2]));
		filme.setDisponivel(Util.getBoolean(aux[3]));
		filme.setPromocao(Util.getBoolean(aux[4]));
		filme.setValorPromocao(Util.getDouble(aux[5]));
		filme.setGenero(aux[6]);
		

		// Retornando valores
		return filme;
	}
}
