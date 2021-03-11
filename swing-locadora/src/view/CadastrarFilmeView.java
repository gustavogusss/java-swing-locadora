package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.FilmeController;
import model.Filme;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe responsável por criar interface gráfica do cadastro de filmes
 * 
 * @author Gustavo Metzler Pontes
 * @since 4 de mar. de 2021
 * 
 */
public class CadastrarFilmeView {
	// Declarando atributos / componentes
	private JFrame janela;
	private JPanel painel;
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbValor;
	private JLabel lbDisponivel;
	private JLabel lbPromocao;
	private JLabel lbValorPromocao;
	private JLabel lbGenero;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfValor;
	private JTextField tfValorPromocao;
	private JRadioButton rbDisponivelSim;
	private JRadioButton rbDisponivelNao;
	private JRadioButton rbPromocaoSim;
	private JRadioButton rbPromocaoNao;
	private ButtonGroup grpDisponivel;
	private ButtonGroup grpPromocao;
	private JCheckBox cbAcao;
	private JCheckBox cbFiccao;
	private JCheckBox cbTerror;
	private JCheckBox cbComedia;
	private JCheckBox cbOutro;
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo = new JButton("Novo");
	private JButton btSair = new JButton("Sair");

	/*
	 * Método para iniciar a GUI
	 */

	public void iniciaGui() {
		/*
		 * Configurando JFrame Janela
		 */
		janela = new JFrame();
		janela.setTitle("CADASTRO DE FILME");
		janela.setSize(650, 350);
		janela.setLocationRelativeTo(null);

		/*
		 * Configurando JLabel Código + textfield referente
		 */
		lbCodigo = new JLabel();
		lbCodigo.setText("Código:");
		lbCodigo.setBounds(40, 20, 120, 30);

		// Configurando TextField do nome
		tfCodigo = new JTextField();
		tfCodigo.setBounds(170, 20, 400, 30);

		/*
		 * Configurando JLabel Nome + textfield referente
		 */

		lbNome = new JLabel();
		lbNome.setText("Nome:");
		lbNome.setBounds(40, 50, 120, 30);

		// Configurando TextField do nome
		tfNome = new JTextField();
		tfNome.setBounds(170, 50, 400, 30);

		/*
		 * Configurando JLabel valor + textfield referente
		 */

		lbValor = new JLabel();
		lbValor.setText("Valor:");
		lbValor.setBounds(40, 80, 120, 30);

		// Configurando TextField do nome
		tfValor = new JTextField();
		tfValor.setBounds(170, 80, 400, 30);

		/*
		 * Configurando JLabel disponível + radioButtons referentes
		 */
		lbDisponivel = new JLabel();
		lbDisponivel.setText("Disponível:");
		lbDisponivel.setBounds(40, 110, 120, 30);

		// Criando os Radio Buttons + Group Buttons para inserir os botões
		// Disponível - sim
		rbDisponivelSim = new JRadioButton();
		rbDisponivelSim.setText("Sim");
		rbDisponivelSim.setBounds(170, 110, 60, 30);

		// Disponível - não
		rbDisponivelNao = new JRadioButton();
		rbDisponivelNao.setText("Não");
		rbDisponivelNao.setBounds(230, 110, 60, 30);

		// Groupbutton
		grpDisponivel = new ButtonGroup();
		grpDisponivel.add(rbDisponivelSim);
		grpDisponivel.add(rbDisponivelNao);

		/*
		 * Configurando JLabel promoção + radioButtons referentes
		 */
		lbPromocao = new JLabel();
		lbPromocao.setText("Promoção:");
		lbPromocao.setBounds(40, 140, 120, 30);

		// Criando os Radio Buttons + Group Buttons para inserir os botões
		// Disponível - sim
		rbPromocaoSim = new JRadioButton();
		rbPromocaoSim.setText("Sim");
		rbPromocaoSim.setBounds(170, 140, 60, 30);

		// Disponível - não
		rbPromocaoNao = new JRadioButton();
		rbPromocaoNao.setText("Não");
		rbPromocaoNao.setBounds(230, 140, 60, 30);

		// Groupbutton
		grpPromocao = new ButtonGroup();
		grpPromocao.add(rbPromocaoSim);
		grpPromocao.add(rbPromocaoNao);

		/*
		 * Configurando Jlabel valor promoção + Jtextfield
		 */
		lbValorPromocao = new JLabel();
		lbValorPromocao.setText("Valor Promoção:");
		lbValorPromocao.setBounds(40, 170, 120, 30);

		// Configurando TextField do nome
		tfValorPromocao = new JTextField();
		tfValorPromocao.setBounds(170, 170, 400, 30);

		/*
		 * Configurando Jlabel gênero + Checkbox
		 */
		lbGenero = new JLabel();
		lbGenero.setText("Gênero:");
		lbGenero.setBounds(40, 200, 120, 30);

		// Configurando os checkbox ação
		cbAcao = new JCheckBox();
		cbAcao.setText("Ação");
		cbAcao.setBounds(170, 200, 80, 30);

		// Configurando os checkbox
		cbFiccao = new JCheckBox();
		cbFiccao.setText("Ficção");
		cbFiccao.setBounds(250, 200, 80, 30);

		// Configurando os checkbox
		cbTerror = new JCheckBox();
		cbTerror.setText("Terror");
		cbTerror.setBounds(330, 200, 80, 30);

		// Configurando os checkbox
		cbComedia = new JCheckBox();
		cbComedia.setText("Comédia");
		cbComedia.setBounds(410, 200, 80, 30);

		// Configurando os checkbox
		cbOutro = new JCheckBox();
		cbOutro.setText("Outro");
		cbOutro.setBounds(490, 200, 80, 30);

		/*
		 * Configurando JButons
		 */
		// Salvar
		btSalvar = new JButton();
		btSalvar.setText("Salvar");
		btSalvar.setBounds(170, 240, 180, 40);
		btNovo.setBounds(170, 240, 180, 40);
		// Cancelar
		btCancelar = new JButton();
		btCancelar.setText("Cancelar");
		btCancelar.setBounds(380, 240, 180, 40);
		btSair.setBounds(380, 240, 180, 40);

		btSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				salvar();
			}
		});

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
				bloquearTela();

				limparTela();
			}
		});

		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				janela.dispose();
			}
		});

		/*
		 * Configurando painel principal e inserindo componentes
		 */
		painel = (JPanel) janela.getContentPane();
		painel.add(lbCodigo);
		painel.add(tfCodigo);
		painel.add(lbNome);
		painel.add(tfNome);
		painel.add(lbValor);
		painel.add(tfValor);
		painel.add(lbDisponivel);
		painel.add(rbDisponivelSim);
		painel.add(rbDisponivelNao);
		painel.add(lbPromocao);
		painel.add(rbPromocaoSim);
		painel.add(rbPromocaoNao);
		painel.add(lbValorPromocao);
		painel.add(tfValorPromocao);
		painel.add(lbGenero);
		painel.add(cbAcao);
		painel.add(cbFiccao);
		painel.add(cbTerror);
		painel.add(cbComedia);
		painel.add(cbOutro);
		painel.add(btSalvar);
		painel.add(btCancelar);
		painel.add(btNovo);
		painel.add(btSair);
		painel.setLayout(null);

		bloquearTela();
		// Configurando visibilidade do JFrame
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setVisible(true);
	}

	private void bloquearTela() {
		tfCodigo.setEditable(false);
		tfNome.setEditable(false);
		tfValor.setEditable(false);
		tfValorPromocao.setEditable(false);
		rbDisponivelNao.setEnabled(false);
		rbDisponivelSim.setEnabled(false);
		rbPromocaoNao.setEnabled(false);
		rbPromocaoSim.setEnabled(false);
		cbAcao.setEnabled(false);
		cbComedia.setEnabled(false);
		cbFiccao.setEnabled(false);
		cbOutro.setEnabled(false);
		cbTerror.setEnabled(false);

		btSalvar.setVisible(false);
		btCancelar.setVisible(false);
		btNovo.setVisible(true);
		btSair.setVisible(true);
	}

	private void liberarTela() {
		tfCodigo.setEditable(true);
		tfNome.setEditable(true);
		tfValor.setEditable(true);
		tfValorPromocao.setEditable(true);
		rbDisponivelNao.setEnabled(true);
		rbDisponivelSim.setEnabled(true);
		rbPromocaoNao.setEnabled(true);
		rbPromocaoSim.setEnabled(true);
		cbAcao.setEnabled(true);
		cbComedia.setEnabled(true);
		cbFiccao.setEnabled(true);
		cbOutro.setEnabled(true);
		cbTerror.setEnabled(true);

		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		btNovo.setVisible(false);
		btSair.setVisible(false);
		tfCodigo.grabFocus();
	}

	private void limparTela() {
		tfCodigo.setText(null);
		tfNome.setText(null);
		tfValor.setText(null);
		tfValorPromocao.setText(null);
		grpDisponivel.clearSelection();
		grpPromocao.clearSelection();
		cbAcao.setSelected(false);
		cbComedia.setSelected(false);
		cbFiccao.setSelected(false);
		cbOutro.setSelected(false);
		cbTerror.setSelected(false);
	}

	/*
	 * Salvar
	 */
	public void salvar() {
		if (validar()) {

			Filme filme = getFilme();
			new FilmeController().gravarTxtFilme(filme);

			// limpar a tela preenchida
			limparTela();
			// bloquear a tela
			bloquearTela();
			// Exibindo mensagem de sucesso para o usuário
			JOptionPane.showMessageDialog(null, Mensagem.filmeGravado, Titulo.cadastroFilme, 1);
		}
	}

	/*
	 * Validar
	 */
	private boolean validar() {
		if (Valida.isEmptyOrNull(tfCodigo.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Titulo.cadastroFilme, 0);
			tfCodigo.grabFocus();
			return false;
		} else if (!Valida.isInteger(tfCodigo.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Titulo.cadastroFilme, 0);
			tfCodigo.grabFocus();
			return false;
		}

		if (Valida.isEmptyOrNull(tfNome.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Titulo.cadastroFilme, 0);
			tfNome.grabFocus();
			return false;
		}

		if (Valida.isEmptyOrNull(tfValor.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.valorVazio, Titulo.cadastroFilme, 0);
			tfValor.grabFocus();
			return false;
		} else if (!Valida.isDouble(tfValor.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.valorInvalido, Titulo.cadastroFilme, 0);
			tfValor.grabFocus();
			return false;
		}

		if (!rbDisponivelNao.isSelected()) {
			if (!rbDisponivelSim.isSelected()) {
				JOptionPane.showMessageDialog(null, Mensagem.disponivelVazio, Titulo.cadastroFilme, 0);
				return false;
			}
		}

		if (!rbPromocaoNao.isSelected()) {
			if (!rbPromocaoSim.isSelected()) {
				JOptionPane.showMessageDialog(null, Mensagem.promocaoVazio, Titulo.cadastroFilme, 0);
				return false;
			}
		}

		if (Valida.isEmptyOrNull(tfValorPromocao.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.valorPromocionalVazio, Titulo.cadastroFilme, 0);
			tfValorPromocao.grabFocus();
			return false;
		} else if (!Valida.isDouble(tfValorPromocao.getText())) {
			JOptionPane.showMessageDialog(null, Mensagem.valorInvalido, Titulo.cadastroFilme, 0);
			tfValorPromocao.grabFocus();
			return false;
		}

		if (!cbAcao.isSelected() && !cbComedia.isSelected() && !cbFiccao.isSelected() && !cbOutro.isSelected()
				&& !cbTerror.isSelected()) {
			JOptionPane.showMessageDialog(null, Mensagem.generoVazio, Titulo.cadastroFilme, 0);
			return false;
		}

		return true;
	}

	private Filme getFilme() {
		Filme filme = new Filme();
		filme.setCodigo(Util.getInt(tfCodigo.getText()));
		filme.setNome(tfNome.getText());
		filme.setValor(Util.getDouble(tfValor.getText()));
		filme.setDisponivel((rbDisponivelSim.isSelected()) ? true : false);
		filme.setPromocao((rbPromocaoSim.isSelected()) ? true : false);
		filme.setValorPromocao(Util.getDouble(tfValorPromocao.getText()));
		filme.setGenero(getGenero());

		return filme;
	}

	private String getGenero() {
		String mensagem = "";
		if (cbAcao.isSelected()) {
			mensagem += "Ação;";
		}

		if (cbComedia.isSelected()) {
			mensagem += "Comédia;";
		}

		if (cbFiccao.isSelected()) {
			mensagem += "Ficcção;";
		}

		if (cbOutro.isSelected()) {
			mensagem += "Outro;";
		}

		if (cbTerror.isSelected()) {
			mensagem += "Terror;";
		}

		return mensagem;
	}
}
