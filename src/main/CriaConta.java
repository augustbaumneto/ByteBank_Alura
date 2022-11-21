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
		
		conta1.saldo = valor;
		System.out.println(conta1.saldo.retornaemDouble());
	}

}
