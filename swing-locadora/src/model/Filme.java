package model;

/**
 * Classe responsável por armazenar os atributos e métodos da classe Filme
 * @author Gustavo Metzler Pontes
 * @since 4 de mar. de 2021
 * 
 */
public class Filme {
	// Declarando atributos
	private int codigo;
	private String nome;
	private double valor;
	private boolean disponivel;
	private boolean promocao;
	private double valorPromocao;
	private String genero;
	
	// Método construtor
	public Filme() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean isPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public double getValorPromocao() {
		return valorPromocao;
	}

	public void setValorPromocao(double valorPromocao) {
		this.valorPromocao = valorPromocao;
	}
	
	
}
