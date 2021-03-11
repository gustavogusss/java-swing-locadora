package model;

/**
 * Classe respons�vel por armazenar os atributos e m�todos da classe Estado
 * 
 * @author Gustavo Metzler Pontes
 * @since 4 de mar. de 2021
 * 
 */
public class Estado {
	// Declarando atributos
	private String uf;
	private String nome;
	
	
	// M�todo construtor vazio
	public Estado() {
	}

	public Estado(String uf, String nome) {
		this.uf = uf;
		this.nome = nome;
		
	}



	// Getters and setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
