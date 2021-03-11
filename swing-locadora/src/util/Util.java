package util;

/**
 * Classe respons�vel por armazenar m�todos de convers�o de dados
 * 
 * @author Gustavo Metzler Pontes
 * @since 9 de mar. de 2021
 * @version 1.0
 */
public class Util {
	/*
	 * M�todo para converter uma String em inteiro
	 */
	public static Integer getInt(String args) {
		return Integer.parseInt(args);
	}
	
	/*
	 * M�todo para converter uma String em Double
	 */
	public static Double getDouble(String args) {
		return Double.parseDouble(args);
	}
	
	/*
	 * Converte para boolean
	 */
	public static Boolean getBoolean(String args) {
		return Boolean.parseBoolean(args);
	}
	
}
