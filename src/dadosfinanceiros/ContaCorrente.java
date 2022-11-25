/**
 *   Classe conta corrente
 */

package dadosfinanceiros;

import dadoscadastrais.*;
import dinheiro.*;

/**
 * @author August Neto
 *
 */



public class ContaCorrente {

	//Define o tamanho de digitos da conta e da agencia
	private static final int QTD_DIGITO_AGENCIA = 5;
	private static final int QTD_DIGITO_CONTA = 9;
	
	private Dinheiro saldo;
	private String agencia;
	private String numeroconta;
	private Cliente titular;
	//Soma a  quantidade de contas
	private static int total;
	
	/**Construtor padrão
	 * 
	 * @param cliente REcebe o cliente dono da conta
	 */
	public ContaCorrente(Cliente cliente) {
		this(cliente,"","");
		
	}

	/**
	 * Construtor completo
	 * 
	 * @param cliente 		Recebe o cliente dono da conta
	 * @param agencia		Recebe o numero da agencia da conta
	 * @param numeroconta 	Recebe o numero da conta 
	 */
	public ContaCorrente(Cliente cliente, String agencia, String numeroconta) {
		this.saldo = new Dinheiro();
		
		setAgencia(agencia);
		setNumeroconta(numeroconta);
		
		this.titular = cliente;
		ContaCorrente.total = ContaCorrente.total+1;
	}	
	
	
	/**Deposita o valor recebido na conta
	 * 
	 * @param valor  valor a ser depositado na conta
	 */
	public void deposita(Dinheiro valor) {

		//Soma o valor ao saldo da conta
		OperacaoDinheiro soma = new OperacaoDinheiro();
		
		this.saldo = soma.soma(this.saldo, valor);
		
	}
	
	/**
	 * 
	 *  Saca um valor da conta
	 * 
	 * @param valor  Valor a ser sacado.
	 * 
	 * @return boolean  True se deu certo
	 */
	public boolean sacar (Dinheiro valor) {
		
		//Se o valor é maior que o saldo da conta
		if (valor.retornaemDouble()>saldo.retornaemDouble()) {
			return false;
		} else {
			OperacaoDinheiro operador = new OperacaoDinheiro();
			this.saldo = operador.subtracao(this.saldo, valor);
			return true;
		}
		
	}
	/**
	 * 
	 * Transfere um valor da conta conta atual para a destino
	 * 
	 * @param valor		Valor a ser transferido
	 * @param destino	Conta que será depositada o valor
	 * @return boolean	True se deu certo
	 */
	
	
	public boolean transferir (Dinheiro valor, ContaCorrente destino) {
		//Se conta de origem possui valor
		if (this.saldo.retornaemDouble()<valor.retornaemDouble()) {
			return false;
		} else {
			
			//Deposita o valor da conta destino
			destino.deposita(valor);
			//Saca o valor da conta
			sacar(valor);
			return true;
		}
		
	}
	
	

	/** 
	 * Get do saldo
	 * 
	 * @return Dinheiro  O saldo da conta
	 */
	public Dinheiro getSaldo() {
		return this.saldo;
	}
	
	/**
	 * Set da agência
	 * 
	 * @param agencia	O numero da agencia
	 */
	public void setAgencia(String agencia) {

		checaAgencia(agencia);
		
		int zeros = QTD_DIGITO_AGENCIA - agencia.length();
		
		String acerto = "";
		
		for (int i=0; i < zeros; i=i+1) {
			acerto = "0"+acerto;
		}
		
		this.agencia = acerto+agencia;
	}
	
	/**
	 * 
	 * Get da agência
	 * 
	 * @return String   Retorna o numero da agência
	 */
	public String getAgencia() {
		return agencia;
	}
	
	/**
	 * set numero da conta
	 * 
	 * @param numeroconta	Defini o numero da conta
	 * 
	 */
	public void setNumeroconta(String numeroconta) {
		checaNumeroConta(numeroconta);
		
		int zeros = QTD_DIGITO_CONTA - numeroconta.length();
		
		String acerto = "";
		
		for (int i=0; i < zeros; i=i+1) {
			acerto = "0"+acerto;
		}
		
		this.numeroconta = acerto+numeroconta;

	}
	
	/**
	 * 
	 * get numero da conta
	 * 
	 * @return String	Devolve o numero da conta
	 */
	public String getNumeroconta() {
		return numeroconta;
	}
	
	/**
	 * Associa o titular a conta
	 * 
	 * @param titular	O Cliente da conta
	 * 
	 */
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	/**
	 * 
	 * Get do titular da conta
	 * 
	 * @return Cliente	o cliente da conta
	 * 
	 */
	public Cliente getTitular() {
		return titular;
	}
	
	/**
	 * 
	 * 
	 * @return int O Total de contas criadas
	 */
	public static int getTotal() {
		return total;
	}
	
	/**
	 * 
	 * Checa as regras da agencia
	 * 
	 * @param dado	string da agência
	 */
	private void checaAgencia(String dado) {
		int tamanho =  dado.length();
		//Agência possui mais de 5 digitos
		if (tamanho>QTD_DIGITO_CONTA) {
				IllegalArgumentException erroagencia = new IllegalArgumentException();
				System.out.println("Agencia com mais de 5 digitos");
				throw erroagencia;
		}	
		if (tamanho==1) {
			IllegalArgumentException erroagencia = new IllegalArgumentException();
			System.out.println("Agencia com apenas 1 digito");
			throw erroagencia;
		}
		
		
		if (!dado.equals("")) {
			//Verifica se os 4 primeiros digitos são numeros senão estora erro de formato
			String base = dado.substring(0,tamanho-1);
			Integer.parseInt(base);
		}
				
	}

	/**
	 * 
	 * Checa numero da conta
	 * 
	 * @param dado	string da agência
	 */
	private void checaNumeroConta(String dado) {
		int tamanho =  dado.length();
		//Numero possui mais de 8 digitos não possui 9 digitos
		if (tamanho>QTD_DIGITO_CONTA) {
				IllegalArgumentException erronumero = new IllegalArgumentException();
				System.out.println("Numero da conta com mais de 9 digitos");
				throw erronumero;
		}	
		if (tamanho==1) {
			IllegalArgumentException erronumero = new IllegalArgumentException();
			System.out.println("Numero da conta com apenas 1 digito");
			throw erronumero;
		}
		
		
		if (!dado.equals("")) {
			//Verifica se os 8 primeiros digitos são numeros senão estora erro de formato
			String base = dado.substring(0,tamanho-1);
			Integer.parseInt(base);
			System.out.println(base);
		}
				
	}	
	
}
