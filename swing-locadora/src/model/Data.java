package model;

/**
 * Classe respons�vel por armazenar os atributos e m�todos da classe Data
 * 
 * @author Gustavo Metzler Pontes
 * @since 4 de mar. de 2021
 * 
 */
public class Data {
	// Declarando os atributos
	private int dia;
	private int mes;
	private int ano;
	
	// M�todo construtor vazio
	public Data() {
		// TODO Auto-generated constructor stub
	}
	
	// Sobrescrevendo m�todo toString
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return dia + "/" + mes + "/" + ano;
	}

	
	// Getters and setters
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
}
