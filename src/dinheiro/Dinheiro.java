/**
 *   Classe que representa dinheiro
 */
package dinheiro;

//import java.math.*;

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
		return this.centavos;
	}
	
	public int getReal() {
		return this.real;
	}
	
	public double getRestos() {
		return this.restos;
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
		return (this.real*1.0)+this.centavos/100.0;
		
	}
	
	/*
	 *  Verifica se centavos esta entre 0 e 100
	 */
	private void checacentavos(int valor) {
		int modulo = Math.abs(valor);
		
		//Se valor estiver fora quebra o código
		if (modulo>=100) {
			IllegalArgumentException errocentavos = new IllegalArgumentException();
			System.out.println("Centavos acima de 99 ou menos de 0");
			throw errocentavos;
		}	
	}
	
	
}
