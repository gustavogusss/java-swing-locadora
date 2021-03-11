package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsável por criar interface gráfica do cadastro de locações
 * 
 * @author Gustavo Metzler Pontes
 * @since 4 de mar. de 2021
 * 
 */
public class CadastrarLocacaoView {
	// Declarando atributos / componentes
	private JFrame janela;
	private JPanel painel;
	private JLabel lbNomeVendedor;
	private JLabel lbNomeFilme;
	private JLabel lbFormaPagamento;
	private JLabel lbValorTotal;
	private JLabel lbValorPago;
	private JLabel lbTroco;
	private JTextField tfValorTotal;
	private JTextField tfValorPago;
	private JTextField tfTroco;
	private JComboBox cbxVendedores;
	private JComboBox cbxFilmes;
	private JButton btIncluir;
	private JButton btSalvar;
	private JButton btCancelar;
	private JRadioButton rbDinheiro;
	private JRadioButton rbCheque;
	private JRadioButton rbDebito;
	private JRadioButton rbCredito;
	private ButtonGroup grpPagamento;
	private JTable tabela;
	private JScrollPane scroll;

	// Vetor auxiliar com alguns nomes de funcionários fictícios
	private String funcionarios[] = { "-Selecione um Vendedor-", "Gustavo", "Renato", "Diego", "Nathi" };
	// Vetor auxiliar com alguns nomes de filmes fictícios
	private String filmes[] = { "-Selecione um Filme-", "O clube da luta", "Beleza Americana", "Cidade de Deus",
			"Laranja Mecânica" };
	// Vetor auxiliar de colunas para inserir na tabela
	private String colunas[] = { "Código", "Nome", "Valor", "Disponível", "Promoção", "Valor Promocional" };
	// Vetor auxiliar de linhas para inserir na tabela
	private String linhas[][];

	/*
	 * Método para iniciar a GUI
	 */
	public void iniciaGui() {
		/*
		 * Configurando JFrame
		 */
		janela = new JFrame();
		janela.setTitle("LOCAÇÃO DE FILME");
		janela.setSize(650, 500);
		janela.setLocationRelativeTo(null);

		/*
		 * Configurando label Nome Vendedor + ccomboBox
		 */
		lbNomeVendedor = new JLabel();
		lbNomeVendedor.setText("Nome do vendedor:");
		lbNomeVendedor.setBounds(40, 20, 120, 30);

		// Configurando comboBox
		cbxVendedores = new JComboBox(funcionarios);
		cbxVendedores.setBounds(170, 20, 400, 30);

		/*
		 * Configurando label nome do filme + combo box + btn incluir
		 */
		lbNomeFilme = new JLabel();
		lbNomeFilme.setText("Nome do Filme:");
		lbNomeFilme.setBounds(40, 60, 120, 30);

		// Combo box filmes
		cbxFilmes = new JComboBox(filmes);
		cbxFilmes.setBounds(170, 60, 300, 30);

		// Botão incluir
		btIncluir = new JButton();
		btIncluir.setText("Incluir");
		btIncluir.setBounds(470, 60, 100, 30);

		/*
		 * Configurando tabela
		 */
		DefaultTableModel modelo = new DefaultTableModel(linhas, colunas);
		tabela = new JTable(modelo);
		tabela.setBounds(5, 100, 625, 200);
		tabela.setEnabled(true);

		// Colocando tabela no scroll
		scroll = new JScrollPane(tabela);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(5, 100, 625, 200);

		/*
		 * Configurando label Forma de pagamento + Radio buttons
		 */
		lbFormaPagamento = new JLabel();
		lbFormaPagamento.setText("Forma de Pagamento:");
		lbFormaPagamento.setBounds(40, 300, 150, 30);

		// Incluindo Radio Buttons
		// Dinheiro
		rbDinheiro = new JRadioButton();
		rbDinheiro.setText("Dinheiro");
		rbDinheiro.setBounds(170, 300, 100, 30);

		// Cheque
		rbCheque = new JRadioButton();
		rbCheque.setText("Cheque");
		rbCheque.setBounds(170, 325, 100, 30);

		// Débito
		rbDebito = new JRadioButton();
		rbDebito.setText("Débito");
		rbDebito.setBounds(170, 350, 100, 30);

		// Crédito
		rbCredito = new JRadioButton();
		rbCredito.setText("Crédito");
		rbCredito.setBounds(170, 375, 100, 30);

		// Groupbutton
		grpPagamento = new ButtonGroup();
		grpPagamento.add(rbCheque);
		grpPagamento.add(rbDebito);
		grpPagamento.add(rbDinheiro);
		grpPagamento.add(rbCredito);

		/*
		 * Configurando label valor total + textfield
		 */
		lbValorTotal = new JLabel();
		lbValorTotal.setText("Valor Total:");
		lbValorTotal.setBounds(325, 300, 120, 30);

		// Texfield
		tfValorTotal = new JTextField();
		tfValorTotal.setBounds(410, 300, 200, 30);

		/*
		 * Configurando label valor pago + textfield
		 */
		lbValorPago = new JLabel();
		lbValorPago.setText("Valor Pago:");
		lbValorPago.setBounds(325, 330, 120, 30);

		// Texfield
		tfValorPago = new JTextField();
		tfValorPago.setBounds(410, 330, 200, 30);

		/*
		 * Configurando label troco + textfield
		 */
		lbTroco = new JLabel();
		lbTroco.setText("Troco:");
		lbTroco.setBounds(325, 360, 120, 30);

		// Texfield
		tfTroco = new JTextField();
		tfTroco.setBounds(410, 360, 200, 30);

		/*
		 * Configurando botões salvar + cancelar
		 */
		// Salvar
		btSalvar = new JButton();
		btSalvar.setText("Salvar");
		btSalvar.setBounds(175, 425, 150, 30);

		// Cancelar
		btCancelar = new JButton();
		btCancelar.setText("Cancelar");
		btCancelar.setBounds(325, 425, 150, 30);
		
		/*
		 * Actions dos btns
		 */
		btCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				janela.dispose();
			}
		});

		/*
		 * Configurando o painel principal
		 */
		painel = (JPanel) janela.getContentPane();
		painel.setLayout(null);
		painel.add(lbNomeVendedor);
		painel.add(cbxVendedores);
		painel.add(lbNomeFilme);
		painel.add(cbxFilmes);
		painel.add(btIncluir);
		painel.add(scroll);
		painel.add(lbFormaPagamento);
		painel.add(rbDinheiro);
		painel.add(rbCheque);
		painel.add(rbDebito);
		painel.add(rbCredito);
		painel.add(lbValorTotal);
		painel.add(tfValorTotal);
		painel.add(lbValorPago);
		painel.add(tfValorPago);
		painel.add(lbTroco);
		painel.add(tfTroco);
		painel.add(btSalvar);
		painel.add(btCancelar);

		// Visibilidade janela TRUE
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setVisible(true);
	}

}
