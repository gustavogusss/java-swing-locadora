/**
 * 
 */
package util;

import javax.swing.JOptionPane;

/**
 * Classe responsável por armazenar os métodos de validação do projeto
 * 
 * @author Gustavo Metzler Pontes
 * @since 8 de mar. de 2021
 * 
 */
public class Valida {
	/*
	 * Método para verificar se o campo é diferente de vazio ou nulo
	 */
	public static boolean isEmptyOrNull(String args) {
		// Verificando se o argumento está preenchido
		return (args.trim().equals("") || args == null);
	}
	
	/*
	 * Método para verificar se o campo é Integer
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
	 * Método para verificar se o campo é double
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
