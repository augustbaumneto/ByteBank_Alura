package main;

import dadosfinanceiros.*;

public class CriaConta {

	public static void main(String[] args) {
		ContaCorrente conta1 = new ContaCorrente();
		conta1.saldo = 200.00;
		System.out.println(conta1.saldo);
	}

}
