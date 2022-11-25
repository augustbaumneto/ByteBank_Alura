/**
 *   Classe main
 */

package main;

import dadoscadastrais.Cliente;
import dadosfinanceiros.*;
import dinheiro.*;

/**
 * @author August Neto
 *
 */

public class CriaConta {

	public static void main(String[] args) {
		
		Cliente tchompidas = new Cliente("Tchompidas Nulo", "jogador de esconde-esconde", "1-23");
		Cliente schevshenko = new Cliente("Andre Schevshenko", "jogador mutante", "4568-87");
		
		ContaCorrente conta1 = new ContaCorrente(tchompidas);
		
		
		Dinheiro valor = new Dinheiro(1000, 50);
		Dinheiro valor2 = new Dinheiro(50,60);
		Dinheiro resultado = new Dinheiro();
		Dinheiro resultado2 = new Dinheiro();
		OperacaoDinheiro operador = new OperacaoDinheiro();
		
		resultado = operador.subtracao(valor, valor2);
		resultado2 = operador.soma(valor, valor2);
		conta1.deposita(valor);
		conta1.sacar(valor2);
		
		System.out.println(conta1.getSaldo().retornaemDouble());
		
		System.out.println("subtracao   " + resultado.retornaemDouble());
		System.out.println("soma    " + resultado2.retornaemDouble());
		
		ContaCorrente conta2 = new ContaCorrente(schevshenko);
		
		conta1.transferir(valor2,conta2);
		
		
		System.out.println(conta2.getSaldo().retornaemDouble());
		System.out.println(conta1.getSaldo().retornaemDouble());
		System.out.println(ContaCorrente.getTotal());
		
		conta1.setAgencia("14562");
		System.out.println(conta1.getAgencia());
		
	}

}
