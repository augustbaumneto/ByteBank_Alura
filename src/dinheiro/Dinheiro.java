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
	private boolean positivo;
	
	/**
	 * Construtor padrão
	 * 
	 */
	
	public Dinheiro() {
		this.real = 0;
		this.centavos = 0;
		this.restos = 0.0;
		this.positivo = true;
	}
	
	/**
	 * Construtor com valores
	 *
	 * @param real  	O valor inteiro de reais
	 * @param centavos	O valor inteiro de centavos menor que 100
	 * @param restos	O valor double de fração dos centavos
	 */
	public Dinheiro(int real, int centavos, double restos) {
		
		this.real = real;
		
		//Verifica se o valor é válido
		checacentavos(centavos);
		this.centavos = centavos;
		
		//Verifica se o valor é válido
		checaresto(restos);
		this.restos = restos;
		
		calculaSinal();
	}
	
	/**
	 * Construtor com valores e resto zerado
	 * 
	 * @param real  	O valor inteiro de reais
	 * @param centavos	O valor inteiro de centavos menor que 100
	 */
	
	public Dinheiro(int real, int centavos) {
		this.real = real;
		
		//Verifica se o valor é válido
		checacentavos(centavos);
		this.centavos = centavos;
		
		this.restos = 0.0;
		calculaSinal();
	}
	
	/**
	 * Construtor com entidade dinheiro
	 * 
	 * @param Dinheiro	O valor do tipo Dinheiro para associar
	 */
	
	public Dinheiro(Dinheiro valor) {
		
		this.real = valor.getReal();
		
		//Verifica se o valor é válido
		checacentavos(valor.getCentavos());
		this.centavos = valor.getCentavos();
		
		//Verifica se o valor é válido
		checaresto(valor.getRestos());
		this.restos = valor.getRestos();
		
		calculaSinal();
	}
	
	
	/**
	 * @return centavos o valor de centavos armazenados
	 */
	public int getCentavos() {
		return this.centavos;
	}
	
	/**
	 * @return real o valor em reais armazenados
	 */
	public int getReal() {
		return this.real;
	}
	
	/**
	 * @return restos o valor do resto armazenado
	 */
	public double getRestos() {
		return this.restos;
	}

	/**
	 * @return positivo o sinal do dinheiro
	 */
	public boolean getSinal() {
		return this.positivo;
	}
		
	/**
	 * Retorna o valor do dinheiro em double para cálculos
	 * 
	 * @return  Valor em double do tipo XX,YY, com reais e centavos (resto é desconsiderado)
	 */
	
	public double retornaemDouble() {
		return (this.real*1.0)+this.centavos/100.0;
		
	}
	
	/**
	 *  Verifica se centavos esta entre 0 e 100
	 *  
	 *  @param	valor	O valor para checar se é válido
	 */
	private void checacentavos(int valor) {
		int modulo = Math.abs(valor);
		
		//Se valor estiver fora quebra o código
		if (modulo>=100) {
			IllegalArgumentException errocentavos = new IllegalArgumentException();
			System.out.println("Centavos acima de 99");
			throw errocentavos;
		}	
		
		//Se valor estiver com sinal diferente de real 
		if ((valor>0 && this.real < 0) || (valor<0 && this.real>0) ) {
			IllegalArgumentException errocentavos = new IllegalArgumentException();
			System.out.println("Centavos com sinal incorreto");
			throw errocentavos;
		}
		
	}
	
	/**
	 *  Verifica se centavos esta entre 0 e 100
	 *  
	 *  @param	valor	O valor para checar se o resto é válido
	 */
	private void checaresto(double valor) {
		double modulo = Math.abs(valor);
		
		//Se valor estiver fora quebra o código
		if (modulo>=1) {
			IllegalArgumentException erroresto = new IllegalArgumentException();
			System.out.println("Resto acima de 1");
			throw erroresto;
		}	
		
		//Se valor estiver com sinal diferente de real 
		if ((valor>0 && this.real < 0) || (valor<0 && this.real>0) ) {
			IllegalArgumentException erroresto = new IllegalArgumentException();
			System.out.println("Resto com sinal incorreto");
			throw erroresto;
		}
		
	}
	
	/**
	 * 
	 * Calcula o sinal do dinheiro se positivo dinheiro é positivo.
	 * 
	 */
	
	private void calculaSinal(){
		// Se algum dos atibutos é maior que zero
		if(this.real>0 || this.centavos>0 || this.restos>0) {
			this.positivo = true;
		} else {
			// Se algum dos atributos é menor que zero
			if (this.real<0|| this.centavos<0 || this.restos<0) {
				this.positivo = false;
			} else {
				// Se é tudo zerado
				this.positivo = true;
			}
		}
		
	}
	
}
