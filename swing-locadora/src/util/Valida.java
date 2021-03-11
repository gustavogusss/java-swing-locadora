/**
 * 
 */
package util;

import javax.swing.JOptionPane;

/**
 * Classe respons�vel por armazenar os m�todos de valida��o do projeto
 * 
 * @author Gustavo Metzler Pontes
 * @since 8 de mar. de 2021
 * 
 */
public class Valida {
	/*
	 * M�todo para verificar se o campo � diferente de vazio ou nulo
	 */
	public static boolean isEmptyOrNull(String args) {
		// Verificando se o argumento est� preenchido
		return (args.trim().equals("") || args == null);
	}
	
	/*
	 * M�todo para verificar se o campo � Integer
	 */
	public static boolean isInteger(String args) {
		try {
			Integer.parseInt(args);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/*
	 * M�todo para verificar se o campo � double
	 */
	public static boolean isDouble(String args) {
		try {
			Double.parseDouble(args);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

}
