/**
 *   Classe conta corrente
 */

package dadosfinanceiros;

import dinheiro.*;

/**
 * @author August Neto
 *
 */


public class ContaCorrente {

	public Dinheiro saldo; //ajustar depois
	String agencia;
	String numeroconta;
	String titular;
	
	//Construtor padrão
	public ContaCorrente() {
		this.saldo = new Dinheiro();
		this.agencia = "";
		this.numeroconta ="";
		this.titular = "";
	}
	
	
	//Deposita o valor recebido na conta
	public void deposita(Dinheiro valor) {

		//Soma o valor ao saldo da conta
		OperacaoDinheiro soma = new OperacaoDinheiro();
		
		this.saldo = soma.soma(this.saldo, valor);
		
	}
	
}
