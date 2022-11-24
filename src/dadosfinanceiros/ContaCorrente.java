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

	private Dinheiro saldo;
	private String agencia;
	private String numeroconta;
	private Cliente titular;
	
	/**Construtor padrão
	 * 
	 * @param cliente REcebe o cliente dono da conta
	 */
	public ContaCorrente(Cliente cliente) {
		this.saldo = new Dinheiro();
		this.agencia = "";
		this.numeroconta ="";
		this.titular = cliente;
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
		this.agencia = agencia;
		this.numeroconta = numeroconta;
		this.titular = cliente;
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
		this.agencia = agencia;
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
		this.numeroconta = numeroconta;
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
}
