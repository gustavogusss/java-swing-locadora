package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import controller.VendedorController;
import model.Vendedor;

/**
 * Classe respons?vel por criar interface gr?fica de consulta de vendedor
 * 
 * @author Gustavo Metzler Pontes
 * @since 4 de mar. de 2021
 * 
 */
public class ConsultarVendedorView {
	// Declarando atributos / componentes
	private JFrame janela;
	private JPanel painel;
	private JTable tabela;
	private JScrollPane scroll;
	private JButton btSair;

	// Vetor auxiliar para armazenar as colunas da tabela
	private String colunas[] = { "Nome", "?rea de Vendas", "Cidade", "Estado", "Sexo", "Idade", "Sal?rio" };
	// Vetor auxiliar para armazenar as linhas da tabela
	private String linhas[][] = {};

	/*
	 * M?todo para apresentar GUI
	 */
	public void iniciaGui() {
		/*
		 * Configurando JFrame
		 */
		janela = new JFrame();
		janela.setTitle("CONSULTA DE VENDEDOR");
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
		 * Configurando Bot?o
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
		
		// carregar tabela
		carregarTabela();

		// Set visible true janela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setVisible(true);
	}

	/*
	 * M?todo para carregar a tabela com os vendedores cadastrados
	 */

	public void carregarTabela() {

		// obtendo o modelo da tabela criada
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		// Limpando os dados da tabela
		//modelo.removeRow(0);

		// la?o de repeti??o para preencher as linhas da tabela
		for (Vendedor vendedor : new VendedorController().getVendedores()) {
			// adicionando a linha na tabela
			modelo.addRow(new String[] { vendedor.getNome(), vendedor.getAreaVenda(), vendedor.getCidade(),
					vendedor.getEstado(), vendedor.getSexo() + "", vendedor.getIdade() + "",
					vendedor.getSalario() + "" });
		}
		
		
	}
}