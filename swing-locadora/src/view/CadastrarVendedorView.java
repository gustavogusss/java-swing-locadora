package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.EstadoController;
import controller.VendedorController;
import model.Estado;
import model.Vendedor;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe respons�vel por criar interface gr�fica do cadastro de vendedores
 * 
 * @author Gustavo Metzler Pontes
 * @since 4 de mar. de 2021
 * 
 */
public class CadastrarVendedorView {
	// Declarando atributos / componentes
	private JFrame janela;
	private JPanel painel;
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbAreaVenda;
	private JLabel lbCidade;
	private JLabel lbEstado;
	private JLabel lbSexo;
	private JLabel lbIdade;
	private JLabel lbSalario;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfAreaVenda;
	private JTextField tfCidade;
	private JTextField tfIdade;
	private JTextField tfSalario;
	private JComboBox cbxEstados;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private ButtonGroup grpSexo;
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo = new JButton("Novo");
	private JButton btSair = new JButton("Sair");

	// Vetor auxiliar com os estados dispon�veis para consulta no JCombobox
	private String estados[] = {};

	/*
	 * M�todo para iniciar a GUI
	 */
	public void inciaGui() {
		/*
		 * Iniciando JFrame
		 */
		janela = new JFrame();
		janela.setTitle("CADASTRO DE VENDEDOR");
		janela.setSize(670, 440);
		janela.setLocationRelativeTo(null);

		/*
		 * Configurando a label c�digo + textfield
		 */
		lbCodigo = new JLabel();
		lbCodigo.setText("C�digo:");
		lbCodigo.setBounds(40, 20, 120, 30);

		// Configurando textfield

		tfCodigo = new JTextField();
		tfCodigo.setBounds(170, 20, 400, 30);

		/*
		 * Configurando a label nome + textfield
		 */
		lbNome = new JLabel();
		lbNome.setText("Nome:");
		lbNome.setBounds(40, 60, 120, 30);

		// Configurando textfield

		tfNome = new JTextField();
		tfNome.setBounds(170, 60, 400, 30);

		/*
		 * Configurando a label �rea de venda + textfield
		 */
		lbAreaVenda = new JLabel();
		lbAreaVenda.setText("�rea de Venda:");
		lbAreaVenda.setBounds(40, 100, 120, 30);

		// Configurando textfield

		tfAreaVenda = new JTextField();
		tfAreaVenda.setBounds(170, 100, 400, 30);

		/*
		 * Configurando a label cidade + textfield
		 */
		lbCidade = new JLabel();
		lbCidade.setText("Cidade:");
		lbCidade.setBounds(40, 140, 120, 30);

		// Configurando textfield

		tfCidade = new JTextField();
		tfCidade.setBounds(170, 140, 400, 30);

		/*
		 * Configurando label estados + combo box de estados
		 */
		lbEstado = new JLabel();
		lbEstado.setText("Estado:");
		lbEstado.setBounds(40, 180, 120, 30);

		// Configurando combobox
		cbxEstados = new JComboBox(estados);
		cbxEstados.setBounds(170, 180, 300, 30);

		/*
		 * Configurando label sexo + radio buttons
		 */
		lbSexo = new JLabel();
		lbSexo.setText("Sexo:");
		lbSexo.setBounds(40, 220, 120, 30);

		// Configurando radio buttons
		// Masculino
		rbMasculino = new JRadioButton();
		rbMasculino.setText("Masculino");
		rbMasculino.setBounds(170, 220, 80, 30);

		// Configurando radio buttons
		// Masculino
		rbFeminino = new JRadioButton();
		rbFeminino.setText("Feminino");
		rbFeminino.setBounds(260, 220, 80, 30);

		// Adicionando os radio buttos no mesmo button group
		grpSexo = new ButtonGroup();
		grpSexo.add(rbMasculino);
		grpSexo.add(rbFeminino);

		/*
		 * Configurando a label idade + textfield
		 */
		lbIdade = new JLabel();
		lbIdade.setText("Idade:");
		lbIdade.setBounds(40, 260, 120, 30);

		// Configurando textfield

		tfIdade = new JTextField();
		tfIdade.setBounds(170, 260, 400, 30);

		/*
		 * Configurando a label salario + textfield
		 */
		lbSalario = new JLabel();
		lbSalario.setText("Sal�rio:");
		lbSalario.setBounds(40, 300, 120, 30);

		// Configurando textfield

		tfSalario = new JTextField();
		tfSalario.setBounds(170, 300, 400, 30);

		/*
		 * Configurando os dois bot�es salvar e excluir
		 */
		// Salvar
		btSalvar = new JButton();
		btSalvar.setText("Salvar");
		btSalvar.setBounds(170, 340, 180, 40);
		btNovo.setBounds(170, 340, 180, 40);

		// Cancelar
		btCancelar = new JButton();
		btCancelar.setText("Cancelar");
		btCancelar.setBounds(380, 340, 180, 40);
		btSair.setBounds(380, 340, 180, 40);

		// A��es dos bot�es
		btSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});

		btCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// M�tyodo para limpar os campos da tela
				limparTela();
				// Bloquear os campos da tela
				bloquearTela();
			}
		});

		btNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// M�todo para desbloquear a tela
				liberarTela();
			}
		});

		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Fecha a janela e mant�m o menu aberto
				janela.dispose();
			}
		});

		/*
		 * Configurando o painel principal e adicionando componentes
		 */
		painel = (JPanel) janela.getContentPane();
		painel.setLayout(null);
		painel.add(lbCodigo);
		painel.add(tfCodigo);
		painel.add(lbNome);
		painel.add(tfNome);
		painel.add(lbAreaVenda);
		painel.add(tfAreaVenda);
		painel.add(lbCidade);
		painel.add(tfCidade);
		painel.add(lbEstado);
		painel.add(cbxEstados);
		painel.add(lbSexo);
		painel.add(rbMasculino);
		painel.add(rbFeminino);
		painel.add(lbIdade);
		painel.add(tfIdade);
		painel.add(lbSalario);
		painel.add(tfSalario);
		painel.add(btSalvar);
		painel.add(btCancelar);
		painel.add(btNovo);
		painel.add(btSair);

		// Chamando o m�todo para carregar o combo de estados
		carregarComboEstados();

		// Bloqueando a tela ao iniciar
		bloquearTela();

		// Visibilidade da janela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setVisible(true);
	}

	/*
	 * M�todo para bloquear a tela de cadastro
	 * 
	 */
	private void bloquearTela() {
		tfCodigo.setEditable(false);
		tfNome.setEditable(false);
		tfAreaVenda.setEditable(false);
		tfCidade.setEditable(false);
		cbxEstados.setEnabled(false);
		rbFeminino.setEnabled(false);
		rbMasculino.setEnabled(false);
		tfIdade.setEditable(false);
		tfSalario.setEditable(false);
		btSalvar.setVisible(false);
		btCancelar.setVisible(false);
		btNovo.setVisible(true);
		btSair.setVisible(true);
	}

	/*
	 * M�todo para liberar os campos da tela de cadastro
	 */
	private void liberarTela() {
		tfCodigo.setEditable(true);
		tfNome.setEditable(true);
		tfAreaVenda.setEditable(true);
		tfCidade.setEditable(true);
		rbFeminino.setEnabled(true);
		rbMasculino.setEnabled(true);
		cbxEstados.setEnabled(true);
		tfIdade.setEditable(true);
		tfSalario.setEditable(true);
		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		btNovo.setVisible(false);
		btSair.setVisible(false);
	}

	/*
	 * M�todo para limpar todos os campos da tela de cadastro
	 */
	private void limparTela() {
		tfCodigo.setText(null);
		tfNome.setText(null);
		tfAreaVenda.setText(null);
		tfCidade.setText(null);
		cbxEstados.setSelectedIndex(0);
		tfIdade.setText(null);
		tfSalario.setText(null);
		grpSexo.clearSelection();
	}

	// M�todo para preencher a combro de estados
	private void carregarComboEstados() {
		// Valor inicial da bomco
		cbxEstados.addItem("-Selecione Estado-");

		// La�o de repeti��o para carregar a combo de estados
		for (Estado estado : new EstadoController().getEstados()) {
			cbxEstados.addItem(estado.getNome());
		}
	}

	/*
	 * M�todo para receber a��o do click salvar
	 */
	public void salvar() {
		// salvar o vendedor apenas se estiverem v�lidos todos os campos
		if (validar()) {
			/*
			 * Procedimentos de grava��o do objet ovendedor no arquivo vendedor
			 */
			Vendedor vendedor = getVendedor();
			// Chamando o m�todo respons�vel por gravar o arquivo txt
			new VendedorController().gravarTxtVendedor(vendedor);
			// limpar a tela preenchida
			limparTela();
			//bloquear a tela
			bloquearTela();
			// Exibindo mensagem de sucesso para o usu�rio 
			JOptionPane.showMessageDialog(null, Mensagem.vendedorGravado, Titulo.cadastroVendedor, 1);
		}
	}

	/*
	 * M�todo para validar os campos da tela
	 */
	private boolean validar() {
		// valida��o do campo c�digo
		if (Valida.isEmptyOrNull(tfCodigo.getText())) {
			// Informando o usu�rio que o c�digo n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Titulo.cadastroVendedor, 0);

			// Colocando foco no campo com erro
			tfCodigo.grabFocus();

			// Retornando false para o m�todo
			return false;
		} else if (!Valida.isInteger(tfCodigo.getText())) {
			// Informando que o c�digo � inv�lido
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Titulo.cadastroVendedor, 0);
			
			// Colocando foco no camp
			tfCodigo.grabFocus();
			
			// Retornando false para o m�todo
			return false;
		}
		// valida��o do campo nome
		if (Valida.isEmptyOrNull(tfNome.getText())) {
			// Informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Titulo.cadastroVendedor, 0);

			// Colocando foco no campo com erro
			tfNome.grabFocus();
			// Retornando false para o m�todo
			return false;
		}

		// valida��o do campo area de venda
		if (Valida.isEmptyOrNull(tfAreaVenda.getText())) {
			// Informando o usu�rio que o area de venda n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.areaVendaVazio, Titulo.cadastroVendedor, 0);
			// Colocando foco no campo com erro
			tfAreaVenda.grabFocus();
			// Retornando false para o m�todo
			return false;
		}

		// valida��o do campo cidade
		if (Valida.isEmptyOrNull(tfCidade.getText())) {
			// Informando o usu�rio que a cidade n�o est� preenchida
			JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio, Titulo.cadastroVendedor, 0);
			// Colocando foco no campo com erro
			tfCidade.grabFocus();
			// Retornando false para o m�todo
			return false;
		}

		// Validando a combo de estado
		if (cbxEstados.getSelectedIndex() == 0) {
			// Informando o usu�rio que o estqado n�o foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Titulo.cadastroVendedor, 0);
			// Colocando foco no campo com erro
			cbxEstados.grabFocus();
			return false;
		}

		// Validando radio buttons
		if (!rbMasculino.isSelected()) {
			if (!rbFeminino.isSelected()) {
				// Infrmando o usu�rio que o sexo n�o foi selecionado
				JOptionPane.showMessageDialog(null, Mensagem.sexoVazio, Titulo.cadastroVendedor, 0);
				// Retornar false para o m�todo
				return false;
			}
		}

		// valida��o do campo idade
		if (Valida.isEmptyOrNull(tfIdade.getText())) {
			// Informando o usu�rio que a idade n�o est� preenchida
			JOptionPane.showMessageDialog(null, Mensagem.idadeVazio, Titulo.cadastroVendedor, 0);
			// Colocando foco no campo com erro
			tfIdade.grabFocus();
			// Retornando false para o m�todo
			return false;
		} else if (!Valida.isInteger(tfIdade.getText())) {
			// Informando que o idade � inv�lido
			JOptionPane.showMessageDialog(null, Mensagem.idadeInvalido, Titulo.cadastroVendedor, 0);
			
			// Colocando foco no camp
			tfIdade.grabFocus();
			
			// Retornando false para o m�todo
			return false;
		}

		// valida��o do campo sal�rio
		if (Valida.isEmptyOrNull(tfSalario.getText())) {
			// Informando o usu�rio que a cidade n�o est� preenchida
			JOptionPane.showMessageDialog(null, Mensagem.salarioVazio, Titulo.cadastroVendedor, 0);
			// Colocando foco no campo com erro
			tfSalario.grabFocus();
			// Retornando false para o m�todo
			return false;
		} else if (!Valida.isDouble(tfSalario.getText())) {
			// Informando que o c�digo � inv�lido
			JOptionPane.showMessageDialog(null, Mensagem.salarioInvalido, Titulo.cadastroVendedor, 0);
			
			// Colocando foco no camp
			tfSalario.grabFocus();
			
			// Retornando false para o m�todo
			return false;
		}

		// Devolvendo true caso esteja tudo v�lido
		return true;
	}
	
	/*
	 * m�todo para valorizar um objeto vendedor utilizando os campos da tela
	 */
	private Vendedor getVendedor() {
		// Instanciando objeto vendedor para retorno do m�todo
		Vendedor vendedor = new Vendedor();
		
		// Valorizando vendedor
		vendedor.setCodigo(Util.getInt(tfCodigo.getText()));
		vendedor.setNome(tfNome.getText());
		vendedor.setAreaVenda(tfAreaVenda.getText());
		vendedor.setCidade(tfCidade.getText());
		vendedor.setEstado(cbxEstados.getSelectedItem() + "");
		// Condicional tern�ria
		vendedor.setSexo((rbMasculino.isSelected()) ? 'M' : 'F');
		vendedor.setIdade(Util.getInt(tfIdade.getText()));
		vendedor.setSalario(Util.getDouble(tfSalario.getText()));
		
		return vendedor;
	}
}
