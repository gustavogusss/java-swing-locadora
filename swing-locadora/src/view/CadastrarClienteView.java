package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.EstadoController;
import model.Cliente;
import model.Data;
import model.Endereco;
import model.Estado;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe responsável por criar interface gráfica do cadastro de Clientes
 * 
 * @author Gustavo Metzler Pontes
 * @since 4 de mar. de 2021
 * 
 */
public class CadastrarClienteView {
	// Declarando atributos / componentes
	private JFrame janela;
	private JPanel painelPrincipal;
	private JPanel painelDadosCadastrais;
	private JPanel painelEndereco;
	private JLabel lbEndereco;
	private JLabel lbCodigoCliente;
	private JLabel lbNome;
	private JLabel lbCpf;
	private JLabel lbRg;
	private JLabel lbIdade;
	private JLabel lbDataNascimento;
	private JLabel lbSexo;
	private JLabel lbTelefone;
	private JLabel lbCelular;
	private JLabel lbEmail;
	private JLabel lbLogradouro;
	private JLabel lbNumero;
	private JLabel lbComplemento;
	private JLabel lbBairro;
	private JLabel lbCidade;
	private JLabel lbEstado;
	private JLabel lbCep;
	private JTextField tfCodigoCliente;
	private JTextField tfLogradouro;
	private JTextField tfNome;
	private JTextField tfIdade;
	private JTextField tfEmail;
	private JTextField tfNomeEndereco;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JComboBox cbxEstados;
	private JFormattedTextField tfCpf;
	private JFormattedTextField tfRg;
	private JFormattedTextField tfTelefone;
	private JFormattedTextField tfCelular;
	private JFormattedTextField tfCep;
	private JFormattedTextField tfDataNascimento;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private ButtonGroup grpSexo;
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo = new JButton("Novo");
	private JButton btSair = new JButton("Sair");
	private MaskFormatter fmtCpf;
	private MaskFormatter fmtRg;
	private MaskFormatter fmtTelefone;
	private MaskFormatter fmtCelular;
	private MaskFormatter fmtCep;
	private MaskFormatter fmtDataNascimento;

	/*
	 * Método para iniciar GUI
	 */
	public void iniciaGui() throws ParseException {
		/*
		 * Configurações dos campos de formatação
		 */
		fmtCpf = new MaskFormatter("###.###.###-##");
		fmtRg = new MaskFormatter("##.###.###-#");
		fmtCelular = new MaskFormatter("(##) #####-####");
		fmtTelefone = new MaskFormatter("(##) ####-####");
		fmtCep = new MaskFormatter("#####-###");
		fmtDataNascimento = new MaskFormatter("##/##/####");
		/*
		 * Iniciando JFrame
		 */
		janela = new JFrame();
		janela.setSize(575, 675);
		janela.setTitle("CADASTRO DE CLIENTE");
		janela.setLocationRelativeTo(null);

		/*
		 * Configurando painel de dados cadastrais
		 */
		painelDadosCadastrais = new JPanel();
		painelDadosCadastrais.setBounds(5, 5, 545, 275);
		painelDadosCadastrais.setBorder(new TitledBorder("Dados Cadastrais"));
		painelDadosCadastrais.setLayout(null);

		// Inserindo labels e textfields
		// Código cliente
		lbCodigoCliente = new JLabel();
		lbCodigoCliente.setText("Código:");
		lbCodigoCliente.setBounds(15, 25, 120, 30);

		tfCodigoCliente = new JTextField();
		tfCodigoCliente.setBounds(100, 25, 100, 30);

		// Data NAscimento
		lbDataNascimento = new JLabel();
		lbDataNascimento.setText("Data de nascimento");
		lbDataNascimento.setBounds(275, 25, 120, 30);

		tfDataNascimento = new JFormattedTextField(fmtDataNascimento);
		tfDataNascimento.setBounds(405, 25, 120, 30);

		// Nome
		lbNome = new JLabel();
		lbNome.setText("Nome:");
		lbNome.setBounds(15, 60, 120, 30);

		tfNome = new JTextField();
		tfNome.setBounds(100, 60, 425, 30);

		// CPF
		lbCpf = new JLabel();
		lbCpf.setText("CPF:");
		lbCpf.setBounds(15, 100, 120, 30);

		tfCpf = new JFormattedTextField(fmtCpf);
		tfCpf.setBounds(100, 100, 150, 30);

		// RG
		lbRg = new JLabel();
		lbRg.setText("RG:");
		lbRg.setBounds(275, 100, 120, 30);

		tfRg = new JFormattedTextField(fmtRg);
		tfRg.setBounds(325, 100, 200, 30);

		// Idade
		lbIdade = new JLabel();
		lbIdade.setText("Idade:");
		lbIdade.setBounds(15, 140, 120, 30);

		tfIdade = new JTextField();
		tfIdade.setBounds(100, 140, 150, 30);

		// Sexo
		lbSexo = new JLabel();
		lbSexo.setText("Sexo:");
		lbSexo.setBounds(275, 140, 120, 30);

		// Radio Buttons + Button Group
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();
		rbMasculino.setText("Masculino");
		rbFeminino.setText("Feminino");
		rbMasculino.setBounds(335, 140, 90, 30);
		rbFeminino.setBounds(425, 140, 90, 30);

		grpSexo = new ButtonGroup();
		grpSexo.add(rbFeminino);
		grpSexo.add(rbMasculino);

		// Telefone
		lbTelefone = new JLabel();
		lbTelefone.setText("Telefone:");
		lbTelefone.setBounds(15, 180, 120, 30);

		tfTelefone = new JFormattedTextField(fmtTelefone);
		tfTelefone.setBounds(100, 180, 150, 30);

		// Celular

		lbCelular = new JLabel();
		lbCelular.setText("Celular:");
		lbCelular.setBounds(275, 180, 120, 30);

		tfCelular = new JFormattedTextField(fmtCelular);
		tfCelular.setBounds(325, 180, 200, 30);

		// Email
		lbEmail = new JLabel();
		lbEmail.setText("E-mail:");
		lbEmail.setBounds(15, 220, 120, 30);

		tfEmail = new JTextField();
		tfEmail.setBounds(100, 220, 425, 30);

		// Adicionando elementos ao painel dados cadastrais
		painelDadosCadastrais.add(lbCodigoCliente);
		painelDadosCadastrais.add(tfCodigoCliente);
		painelDadosCadastrais.add(lbDataNascimento);
		painelDadosCadastrais.add(tfDataNascimento);
		painelDadosCadastrais.add(lbNome);
		painelDadosCadastrais.add(tfNome);
		painelDadosCadastrais.add(lbCpf);
		painelDadosCadastrais.add(tfCpf);
		painelDadosCadastrais.add(lbRg);
		painelDadosCadastrais.add(tfRg);
		painelDadosCadastrais.add(lbIdade);
		painelDadosCadastrais.add(tfIdade);
		painelDadosCadastrais.add(lbSexo);
		painelDadosCadastrais.add(rbMasculino);
		painelDadosCadastrais.add(rbFeminino);
		painelDadosCadastrais.add(lbTelefone);
		painelDadosCadastrais.add(tfTelefone);
		painelDadosCadastrais.add(lbCelular);
		painelDadosCadastrais.add(tfCelular);
		painelDadosCadastrais.add(lbEmail);
		painelDadosCadastrais.add(tfEmail);

		/*
		 * Configurando painel de Endereço (5, 5, 595, 275);
		 */
		painelEndereco = new JPanel();
		painelEndereco.setLayout(null);
		painelEndereco.setBounds(5, 300, 545, 250);
		painelEndereco.setBorder(new TitledBorder("Endereço"));

		// Inserindo labels e textfields

		// Logradouro
		lbLogradouro = new JLabel();
		lbLogradouro.setText("Logradouro:");
		lbLogradouro.setBounds(15, 25, 120, 30);

		tfLogradouro = new JTextField();
		tfLogradouro.setBounds(100, 25, 100, 30);

		// Endereço
		lbEndereco = new JLabel();
		lbEndereco.setText("Endereço:");
		lbEndereco.setBounds(210, 25, 120, 30);

		tfNomeEndereco = new JTextField();
		tfNomeEndereco.setBounds(275, 25, 250, 30);

		// Número
		lbNumero = new JLabel();
		lbNumero.setText("Número:");
		lbNumero.setBounds(15, 60, 120, 30);

		tfNumero = new JTextField();
		tfNumero.setBounds(100, 60, 100, 30);

		// Complemento
		lbComplemento = new JLabel();
		lbComplemento.setText("Complemento:");
		lbComplemento.setBounds(210, 60, 120, 30);

		tfComplemento = new JTextField();
		tfComplemento.setBounds(300, 60, 225, 30);

		// Cep
		lbCep = new JLabel();
		lbCep.setText("Cep:");
		lbCep.setBounds(15, 100, 120, 30);

		tfCep = new JFormattedTextField(fmtCep);
		tfCep.setBounds(100, 100, 100, 30);

		// Bairro
		lbBairro = new JLabel();
		lbBairro.setText("Bairro:");
		lbBairro.setBounds(213, 100, 120, 30);

		tfBairro = new JTextField();
		tfBairro.setBounds(275, 100, 250, 30);

		// Cidade
		lbCidade = new JLabel();
		lbCidade.setText("Cidade:");
		lbCidade.setBounds(15, 140, 120, 30);

		tfCidade = new JTextField();
		tfCidade.setBounds(100, 140, 425, 30);

		// Estado
		lbEstado = new JLabel();
		lbEstado.setText("Estado:");
		lbEstado.setBounds(15, 180, 120, 30);

		cbxEstados = new JComboBox();
		cbxEstados.setBounds(100, 180, 425, 30);

		// Adicionando ao painel
		painelEndereco.add(lbLogradouro);
		painelEndereco.add(tfLogradouro);
		painelEndereco.add(lbEndereco);
		painelEndereco.add(tfNomeEndereco);
		painelEndereco.add(lbNumero);
		painelEndereco.add(tfNumero);
		painelEndereco.add(lbComplemento);
		painelEndereco.add(tfComplemento);
		painelEndereco.add(lbBairro);
		painelEndereco.add(tfBairro);
		painelEndereco.add(lbCidade);
		painelEndereco.add(tfCidade);
		painelEndereco.add(lbEstado);
		painelEndereco.add(cbxEstados);
		painelEndereco.add(lbCep);
		painelEndereco.add(tfCep);

		/*
		 * Configurando botões salvar + cancelar
		 */

		btSalvar = new JButton();
		btCancelar = new JButton();
		btSalvar.setText("Salvar");
		btCancelar.setText("Cancelar");
		btSalvar.setBounds(60, 575, 200, 30);
		btNovo.setBounds(60, 575, 200, 30);
		btCancelar.setBounds(275, 575, 200, 30);
		btSair.setBounds(275, 575, 200, 30);

		/*
		 * Ações
		 */
		btNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				liberarTela();
			}
		});
		btCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				limparTela();

				bloquearTela();
			}
		});

		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				janela.dispose();
			}
		});

		btSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				salvar();
			}
		});

		/*
		 * Configurando painel principal
		 */
		painelPrincipal = (JPanel) janela.getContentPane();
		painelPrincipal.setLayout(null);
		painelPrincipal.add(painelDadosCadastrais);
		painelPrincipal.add(painelEndereco);
		painelPrincipal.add(btSalvar);
		painelPrincipal.add(btCancelar);
		painelPrincipal.add(btNovo);
		painelPrincipal.add(btSair);

		carregarComboEstados();

		bloquearTela();
		// Visibilidade
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setVisible(true);
	}

	private void bloquearTela() {
		tfBairro.setEnabled(false);
		tfCelular.setEnabled(false);
		tfCep.setEnabled(false);
		tfCidade.setEnabled(false);
		tfCodigoCliente.setEnabled(false);
		tfComplemento.setEnabled(false);
		tfCpf.setEnabled(false);
		tfDataNascimento.setEnabled(false);
		tfEmail.setEnabled(false);
		tfIdade.setEnabled(false);
		tfLogradouro.setEnabled(false);
		tfNome.setEnabled(false);
		tfNomeEndereco.setEnabled(false);
		tfNumero.setEnabled(false);
		tfRg.setEnabled(false);
		tfTelefone.setEnabled(false);
		rbFeminino.setEnabled(false);
		rbMasculino.setEnabled(false);
		cbxEstados.setEnabled(false);

		btSalvar.setVisible(false);
		btCancelar.setVisible(false);
		btNovo.setVisible(true);
		btSair.setVisible(true);
	}

	private void liberarTela() {
		tfBairro.setEnabled(true);
		tfCelular.setEnabled(true);
		tfCep.setEnabled(true);
		tfCidade.setEnabled(true);
		tfCodigoCliente.setEnabled(true);
		tfComplemento.setEnabled(true);
		tfCpf.setEnabled(true);
		tfDataNascimento.setEnabled(true);
		tfEmail.setEnabled(true);
		tfIdade.setEnabled(true);
		tfLogradouro.setEnabled(true);
		tfNome.setEnabled(true);
		tfNomeEndereco.setEnabled(true);
		tfNumero.setEnabled(true);
		tfRg.setEnabled(true);
		tfTelefone.setEnabled(true);
		rbFeminino.setEnabled(true);
		rbMasculino.setEnabled(true);
		cbxEstados.setEnabled(true);

		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		btNovo.setVisible(false);
		btSair.setVisible(false);
	}

	private void limparTela() {
		tfBairro.setText(null);
		tfCelular.setText(null);
		tfCep.setText(null);
		tfCidade.setText(null);
		tfCodigoCliente.setText(null);
		tfComplemento.setText(null);
		tfCpf.setText(null);
		tfDataNascimento.setText(null);
		tfEmail.setText(null);
		tfIdade.setText(null);
		tfLogradouro.setText(null);
		tfNome.setText(null);
		tfNomeEndereco.setText(null);
		tfNumero.setText(null);
		tfRg.setText(null);
		tfTelefone.setText(null);
		grpSexo.clearSelection();
		cbxEstados.setSelectedIndex(0);
	}

	private void carregarComboEstados() {
		// Valor inicial da bomco
		cbxEstados.addItem("-Selecione Estado-");

		// Laço de repetição para carregar a combo de estados
		for (Estado estado : new EstadoController().getEstados()) {
			cbxEstados.addItem(estado.getNome());
		}
	}

	public void salvar() {
		if (validar()) {

			// getCliente()
			Cliente cliente = getCliente();
			
			new ClienteController().gravarTxtCliente(cliente);

			// limpar a tela preenchida
			limparTela();
			// bloquear a tela
			bloquearTela();
			// Exibindo mensagem de sucesso para o usuário
			JOptionPane.showMessageDialog(null, Mensagem.clienteGravado, Titulo.cadastroCliente, 1);
		}
	}

	private boolean validar() {
		if (Valida.isEmptyOrNull(tfCodigoCliente.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Titulo.cadastroCliente, 0);
			tfCodigoCliente.grabFocus();
			return false;
		} else if (!Valida.isInteger(tfCodigoCliente.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Titulo.cadastroCliente, 0);
			tfCodigoCliente.grabFocus();
			return false;
		}
		/*
		 * A melhorar pela classe VALIDA.UTIL
		 */
		if (Valida.isEmptyOrNull(tfDataNascimento.getText().replace("/", ""))) {
			JOptionPane.showMessageDialog(null, Mensagem.dataVazio, Titulo.cadastroCliente, 0);
			tfDataNascimento.grabFocus();
			return false;
		}

		if (Valida.isEmptyOrNull(tfNome.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Titulo.cadastroCliente, 0);
			tfNome.grabFocus();
			return false;
		}

		if (Valida.isEmptyOrNull(tfCpf.getText().replace(".", "").replace("-", ""))) {
			JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Titulo.cadastroCliente, 0);
			tfCpf.grabFocus();
			return false;
		}

		if (Valida.isEmptyOrNull(tfRg.getText().replace(".", "").replace("-", ""))) {
			JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Titulo.cadastroCliente, 0);
			tfRg.grabFocus();
			return false;
		}

		if (Valida.isEmptyOrNull(tfIdade.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.idadeVazio, Titulo.cadastroCliente, 0);
			tfIdade.grabFocus();
			return false;
		} else if (!Valida.isInteger(tfIdade.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.idadeInvalido, Titulo.cadastroCliente, 0);
			tfIdade.grabFocus();
			return false;
		}

		if (!rbMasculino.isSelected()) {
			if (!rbFeminino.isSelected()) {
				JOptionPane.showMessageDialog(null, Mensagem.sexoVazio, Titulo.cadastroCliente, 0);
				return false;
			}
		}

		if (Valida.isEmptyOrNull(tfTelefone.getText().replace("(  )", "").replace("-", ""))) {
			JOptionPane.showMessageDialog(null, Mensagem.telefoneVazio, Titulo.cadastroCliente, 0);
			tfTelefone.grabFocus();
			return false;
		}

		if (Valida.isEmptyOrNull(tfCelular.getText().replace("(  )", "").replace("-", ""))) {
			JOptionPane.showMessageDialog(null, Mensagem.celularVazio, Titulo.cadastroCliente, 0);
			tfCelular.grabFocus();
			return false;
		}

		if (Valida.isEmptyOrNull(tfEmail.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.emailVazio, Titulo.cadastroCliente, 0);
			tfEmail.grabFocus();
			return false;
		}

		if (Valida.isEmptyOrNull(tfLogradouro.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.logradouroVazio, Titulo.cadastroCliente, 0);
			tfLogradouro.grabFocus();
			return false;
		}

		if (Valida.isEmptyOrNull(tfNomeEndereco.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.enderecoVazio, Titulo.cadastroCliente, 0);
			tfNomeEndereco.grabFocus();
			return false;
		}

		if (Valida.isEmptyOrNull(tfNumero.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.numeroVazio, Titulo.cadastroCliente, 0);
			tfNumero.grabFocus();
			return false;
		}

		

		if (Valida.isEmptyOrNull(tfCep.getText().replace("-", ""))) {
			JOptionPane.showMessageDialog(null, Mensagem.cepVazio, Titulo.cadastroCliente, 0);
			tfCep.grabFocus();
			return false;
		}

		if (Valida.isEmptyOrNull(tfBairro.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.bairroVazio, Titulo.cadastroCliente, 0);
			tfBairro.grabFocus();
			return false;
		}

		if (Valida.isEmptyOrNull(tfCidade.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio, Titulo.cadastroCliente, 0);
			tfCidade.grabFocus();
			return false;
		}

		if (cbxEstados.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Titulo.cadastroCliente, 0);
			cbxEstados.grabFocus();
			return false;
		}

		return true;
	}
	
	private Cliente getCliente() {
		Cliente cliente = new Cliente();
		
		cliente.setCodigo(Util.getInt(tfCodigoCliente.getText()));
		cliente.setNome(tfNome.getText());
		cliente.setCpf(tfCpf.getText());
		cliente.setRg(tfRg.getText());
		cliente.setIdade(Util.getInt(tfIdade.getText()));
		cliente.setSexo((rbFeminino.isSelected()) ? 'F' : 'M');
		cliente.setTelefone(tfTelefone.getText());
		cliente.setCelular(tfCelular.getText());
		cliente.setDataNascimento(getData());
		cliente.setEndereco(getEndereco());
		cliente.setEmail(tfEmail.getText());
		return cliente;
	}
	
	private Data getData() {
		Data data = new Data();
		String[] aux = tfDataNascimento.getText().split("/");
		int dia = Integer.parseInt(aux[0]);
		int mes = Integer.parseInt(aux[1]);
		int ano = Integer.parseInt(aux[2]);
		
		data.setDia(dia);
		data.setMes(mes);
		data.setAno(ano);
		
		
		return data;
	}
	
	private Endereco getEndereco() {
		Endereco endereco = new Endereco();
		
		endereco.setCodigo(Util.getInt(tfCodigoCliente.getText()));
		endereco.setLogradouro(tfLogradouro.getText());
		endereco.setEndereco(tfNomeEndereco.getText());
		endereco.setNumero(Util.getInt(tfNumero.getText()));
		endereco.setBairro(tfBairro.getText());
		endereco.setCidade(tfCidade.getText());
		endereco.setEstado(cbxEstados.getSelectedItem() + "");
		endereco.setCep(tfCep.getText());
		endereco.setComplemento(tfComplemento.getText());
		
		return endereco;
	}
}
