package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


/**
 * Classe responsável por criar interface gráfica do menu principal
 * @author Gustavo Metzler Pontes
 * @since 4 de mar. de 2021
 * 
 */
public class MenuPrincipalView {
	// Declarando componentes / atributos
	private JFrame janela;
	private JMenuBar barraMenu;
	private JMenu menuCadastro;
	private JMenu menuConsulta;
	private JMenu menuSair;
	private JMenuItem cadastroCliente;
	private JMenuItem cadastroVendedor;
	private JMenuItem cadastroFilme;
	private JMenuItem cadastroLocacao;
	private JMenuItem consultaVendedor;
	private JMenuItem consultaCliente;
	private JMenuItem consultaFilmes;
	private JMenuItem sair;

	/*
	 * Método para iniciar GUI
	 */
	public void iniciaGui() {
		/*
		 * Criando as instâncias dos objetos
		 */
		janela = new JFrame();
		janela.setTitle("LOCADORA");
		barraMenu = new JMenuBar();

		menuCadastro = new JMenu();
		// Atribuindo nome ao menu CADASTRO
		menuCadastro.setText("CADASTRO");
		menuConsulta = new JMenu();
		// Atribuindo nome ao menu CONSULTA
		menuConsulta.setText("CONSULTA");
		menuSair = new JMenu();
		// Atribuindo nome ao menu SAIR
		menuSair.setText("SAIR");

		/*
		 * Inserindo opções no menu cadastro
		 */
		cadastroCliente = new JMenuItem();
		cadastroVendedor = new JMenuItem();
		cadastroFilme = new JMenuItem();
		cadastroLocacao = new JMenuItem();
		cadastroCliente.setText("Cliente");
		cadastroVendedor.setText("Vendedor");
		cadastroFilme.setText("Filme");
		cadastroLocacao.setText("Locação");

		menuCadastro.add(cadastroCliente);
		menuCadastro.add(cadastroVendedor);
		menuCadastro.add(cadastroFilme);
		menuCadastro.add(cadastroLocacao);

		/*
		 * Inserindo opções no menu consulta
		 */

		consultaVendedor = new JMenuItem();
		consultaFilmes = new JMenuItem();
		consultaCliente = new JMenuItem();
		consultaVendedor.setText("Vendedor");
		consultaFilmes.setText("Filmes");
		consultaCliente.setText("Clientes");
		menuConsulta.add(consultaVendedor);
		menuConsulta.add(consultaFilmes);
		menuConsulta.add(consultaCliente);

		sair = new JMenuItem();
		sair.setText("Sair");
		menuSair.add(sair);

		/*
		 * Adicionando comportamnto ao botão sair
		 */
		sair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int codigo = JOptionPane.showConfirmDialog(null, "Encerrar programa?", "Atenção",
						JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);
				if (codigo == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		cadastroCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new CadastrarClienteView().iniciaGui();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		cadastroFilme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CadastrarFilmeView().iniciaGui();
			}
		});
		
		cadastroVendedor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CadastrarVendedorView().inciaGui();
			}
		});
		cadastroLocacao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CadastrarLocacaoView().iniciaGui();
			}
		});
		
		consultaCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ConsultarClienteView().iniciaGui();
			}
		});
		
		consultaFilmes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ConsultarFilmeView().iniciaGui();
			}
		});
		
		consultaVendedor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ConsultarVendedorView().iniciaGui();
			}
		});

		// Adicionando menus ao menuBar
		barraMenu.add(menuCadastro);
		barraMenu.add(menuConsulta);
		barraMenu.add(menuSair);

		janela.setJMenuBar(barraMenu);
		janela.setLocationRelativeTo(null);
		// Configurando o tamanho maximizado
		janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// Visibilidade da janela para true
		janela.setVisible(true);

	}

}
