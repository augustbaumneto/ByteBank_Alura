/**
 *   Classe que representa dinheiro
 */
package dinheiro;

/**
 * @author August Neto
 *
 */
public class Dinheiro {

	private int real;
	private int centavos;
	private double restos;
	
	/*
	 * Construtor padrão
	 */
	
	public Dinheiro() {
		this.real = 0;
		this.centavos = 0;
		this.restos = 0.0;
	}
	
	/*
	 * Construtor com valores
	 */
	
	public Dinheiro(int real, int centavos, double restos) {
		//Verifica se o valor é válido
		checacentavos(centavos);
				
		this.real = real;
		this.centavos = centavos;
		this.restos = restos;
	}
	
	/*
	 * Construtor com valores e resto zerado
	 */
	
	public Dinheiro(int real, int centavos) {
		//Verifica se o valor é válido
		checacentavos(centavos);
		this.real = real;
		this.centavos = centavos;
		this.restos = 0.0;
	}
	
	/*
	 * Construtor com entidade dinheiro
	 */
	
	public Dinheiro(Dinheiro valor) {
		//Verifica se o valor é válido
		checacentavos(valor.getCentavos());
		
		this.real = valor.getReal();
		this.centavos = valor.getCentavos();
		this.restos = valor.getRestos();
	}
	
	
	/*
	 * Métodos Get
	 */
	
	public int getCentavos() {
		return centavos;
	}
	
	public int getReal() {
		return real;
	}
	
	public double getRestos() {
		return restos;
	}
	
	/*
	 * Métodos set
	 */
	
	public void setCentavos(int centavos) {
		
		//Verifica se o valor é válido
		checacentavos(centavos);
		this.centavos = centavos;
		
	}
	
	public void setReal(int real) {
		this.real = real;
	}
	
	public void setRestos(double restos) {
		this.restos = restos;
	}
	
	/*
	 * Retorna o valor do dinheiro em double para cálculos
	 */
	
	public double retornaemDouble() {
		return (real*1.0)+centavos/100.0;
		
	}
	
	/*
	 *  Verifica se centavos esta entre 0 e 100
	 */
	private boolean checacentavos(int valor) {
		//TODO tratamento de erro se não for entre 99 e 0
		
		
		return(valor<100&&valor>=0);
		
	}
}
