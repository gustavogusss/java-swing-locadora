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

import model.Cliente;
import model.Data;
import model.Endereco;
import model.Vendedor;
import util.Mensagem;
import util.Titulo;
import util.Util;

/**
 * Classe responsável por gerir o controller do cliente
 * 
 * @author Gustavo Metzler Pontes
 * @since 9 de mar. de 2021
 * 
 */
public class ClienteController {
	private String arquivo = "cliente.txt";

	public void gravarTxtCliente(Cliente cliente) {
		// Classe auxiliar para carregar um arquivo existente ou criar um novo arquivo
		File file = new File(arquivo);

		try {
			// Classe auxiliar para gerara um objeto de memória para gravação de arquivo
			FileOutputStream arquivoOutPut = new FileOutputStream(file, true);

			// Classe auxiliar para gerara um objeto de memória para gravação de conteúdo
			PrintStream gravador = new PrintStream(arquivoOutPut);

			// Gravando o conteúdo do arquivo
			//0
			gravador.print(cliente.getCodigo());
			gravador.print(";");
			//1
			gravador.print(cliente.getNome());
			gravador.print(";");
			//2
			gravador.print(cliente.getEndereco().getLogradouro());
			gravador.print(";");
			//3
			gravador.print(cliente.getEndereco().getEndereco());
			gravador.print(";");
			//4
			gravador.print(cliente.getEndereco().getNumero());
			gravador.print(";");
			//5
			gravador.print(cliente.getEndereco().getComplemento());
			gravador.print(";");
			//6
			gravador.print(cliente.getEndereco().getBairro());
			gravador.print(";");
			//7
			gravador.print(cliente.getEndereco().getCidade());
			gravador.print(";");
			//8
			gravador.print(cliente.getEndereco().getEstado());
			gravador.print(";");
			//9
			gravador.print(cliente.getEndereco().getCep());
			gravador.print(";");
			//10
			gravador.print(cliente.getCpf());
			gravador.print(";");
			//11
			gravador.print(cliente.getRg());
			gravador.print(";");
			//12
			gravador.print(cliente.getDataNascimento());
			gravador.print(";");
			//13
			gravador.print(cliente.getIdade());
			gravador.print(";");
			//14
			gravador.print(cliente.getSexo());
			gravador.print(";");
			//15
			gravador.print(cliente.getTelefone());
			gravador.print(";");
			//16
			gravador.print(cliente.getCelular());
			gravador.print(";");
			//17
			gravador.print(cliente.getEmail());
			gravador.print("\n");

			// Fechando o processo de gravação
			gravador.close();
			arquivoOutPut.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoVendedor, Titulo.cadastroCliente, 0);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoVendedor, Titulo.cadastroCliente, 0);
			e.printStackTrace();
		}
	}

	public ArrayList<Cliente> getClientes() {
		ArrayList<Cliente> clientes = buscarTodos();
		
		return clientes;
	}

	private ArrayList<Cliente> buscarTodos() {
		// Lista auxiliar
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		try {
			// Classe Scanner auxiliar para ler o arquivo de vendedor
			Scanner leitor = new Scanner(new FileReader(arquivo));

			// laço de repetição para ler as linhas do arquivo
			while (leitor.hasNext()) {

				// objeto auxiliar para retornar no método
				Cliente cliente = getCliente(leitor.nextLine());
				// Atribuindo o objeto vendedor na lista d retorno
				clientes.add(cliente);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Retornando a lista de vendedores
		return clientes;
	}

	private Cliente getCliente(String args) {
		// Objeto auxiliar para retornar no método
		Cliente cliente = new Cliente();
		
		Data data = new Data();
		Endereco endereco = new Endereco();
		
		/*
		 * VERIFICAR ENDEREÇO E FORMA DE MELHORIA
		 */
		
		// Variavel aux para quebrar o registro do arquivo
		String aux[] = args.split(";");
		String[] dataCheia = aux[12].split("/");
		int dia = Integer.parseInt(dataCheia[0]);
		int mes = Integer.parseInt(dataCheia[1]);
		int ano = Integer.parseInt(dataCheia[2]);
		
		
		
		/*
		 * Endereco
		 */
		endereco.setCodigo(Util.getInt(aux[0]));
		endereco.setLogradouro(aux[2]);
		endereco.setEndereco(aux[3]);
		endereco.setNumero(Util.getInt(aux[4]));
		endereco.setComplemento(aux[5]);
		endereco.setBairro(aux[6]); 
		endereco.setCidade(aux[7]); 
		endereco.setEstado(aux[8]); 
		endereco.setCep(aux[9]);
		data.setDia(dia);
		data.setMes(mes);
		data.setAno(ano);
		// Valorizando o objeto vendedor
		cliente.setCodigo(Util.getInt(aux[0]));
		cliente.setNome(aux[1]);
		cliente.setEndereco(endereco);
		cliente.setCpf(aux[10]);
		cliente.setRg(aux[11]);
		cliente.setDataNascimento(data);
		cliente.setIdade(Util.getInt(aux[13]));
		cliente.setSexo(aux[14].charAt(0));
		cliente.setTelefone(aux[15]);
		cliente.setCelular(aux[16]);
		cliente.setEmail(aux[17]);
		// Retornando valores
		return cliente;
	}
}
