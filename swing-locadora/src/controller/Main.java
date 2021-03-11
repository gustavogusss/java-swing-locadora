package controller;

import javax.swing.UIManager;

import view.MenuPrincipalView;

/**
 * Classe principal para executar o projeto
 * 
 * @author Gustavo Metzler Pontes
 * @since 8 de mar. de 2021
 * @version 1.0
 */
public class Main {

	
	public static void main(String[] args) {
		/*
		 * Configurando o estilo inicial do projeto
		 */
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Iniciando o menu principal 
		new MenuPrincipalView().iniciaGui();
	}

}
