package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import model.Cliente;

/**
 * Classe responsável por criar interface gráfica da consulta de clientes
 * 
 * @author Gustavo Metzler Pontes
 * @since 5 de mar. de 2021
 * 
 */
public class ConsultarClienteView {
	// Declarando atributos / componentes
	private JFrame janela;
	private JPanel painel;
	private JTable tabela;
	private JScrollPane scroll;
	private JButton btSair;

	// Vetor auxiliar para armazenar as colunas da tabela
	private String colunas[] = { "Nome", "Sexo", "Idade", "Cidade", "Celular" };
	// Vetor auxiliar para armazenar as linhas da tabela
	private String linhas[][];

	/*
	 * Método para apresentar GUI
	 */
	public void iniciaGui() {
		/*
		 * Configurando JFrame
		 */
		janela = new JFrame();
		janela.setTitle("CONSULTA DE CLIENTES CADASTRADOS");
		janela.setSize(725, 400);
		janela.setLocationRelativeTo(null);

		/*
		 * Configurando Tabela
		 */
		DefaultTableModel modelo = new DefaultTableModel(linhas, colunas);
		tabela = new JTable(modelo);
		tabela.setBounds(5, 5, 695, 295);
		tabela.setEnabled(true);
		// Scroll
		scroll = new JScrollPane(tabela);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(5, 5, 695, 295);

		/*
		 * Configurando Botão
		 */
		btSair = new JButton();
		btSair.setText("Sair");
		btSair.setBounds(212, 310, 300, 30);
		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				janela.dispose();
			}
		});

		/*
		 * Configurando painel
		 */
		painel = (JPanel) janela.getContentPane();
		painel.setLayout(null);
		painel.add(scroll);
		painel.add(btSair);
		
		carregarTabela();

		// Set visible true janela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setVisible(true);
	}

	public void carregarTabela() {

		// obtendo o modelo da tabela criada
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

		// laço de repetição para preencher as linhas da tabela
		for (Cliente cliente : new ClienteController().getClientes()) {
			// adicionando a linha na tabela
			modelo.addRow(new String[] { cliente.getNome(), cliente.getSexo() + "", cliente.getIdade() + "",
					cliente.getEndereco().getCidade(), cliente.getCelular() });
		}

	}

}