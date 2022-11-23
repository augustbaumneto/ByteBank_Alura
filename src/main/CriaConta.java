/**
 *   Classe main
 */

package main;

import dadosfinanceiros.*;
import dinheiro.*;

/**
 * @author August Neto
 *
 */

public class CriaConta {

	public static void main(String[] args) {
		
		ContaCorrente conta1 = new ContaCorrente();
		
		
		Dinheiro valor = new Dinheiro(200, 50);
		Dinheiro valor2 = new Dinheiro(50,40);
		//Dinheiro resultado = new Dinheiro();
		//Dinheiro resultado2 = new Dinheiro();
		//OperacaoDinheiro operador = new OperacaoDinheiro();
		
		//resultado = operador.subtracao(valor, valor2);
		//resultado2 = operador.soma(valor, valor2);
		conta1.saldo = valor;
		
		System.out.println(conta1.saldo.retornaemDouble());
		
		//System.out.println(resultado.retornaemDouble());
		//System.out.println(resultado2.retornaemDouble());
		
		ContaCorrente conta2 = new ContaCorrente();
		
		conta2.deposita(valor2);
		
		System.out.println(conta2.saldo.retornaemDouble());
	}

}
