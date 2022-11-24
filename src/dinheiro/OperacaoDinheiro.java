/**
 *  Classe para os métodos envolvendo dinheiro
 */
package dinheiro;

/**
 * @author August Neto
 *
 */
public class OperacaoDinheiro {

	//Construtor básico
	/**
	 * Construtor apenas para criar o objeto
	 * 
	 */
	public OperacaoDinheiro() {
		
	}
	
	
	/**
	 * Soma dos valores de Dinheiro
	 * 
	 * @param fator1  	O primeiro fator
	 * @param fator2  	O primeiro fator
	 * @return Dinheiro	O resultado da soma
	 */
	public Dinheiro soma(Dinheiro fator1, Dinheiro fator2) {
		Dinheiro resultado;
		
		//Verifica se tem mesmo sinal
		if (fator1.getSinal()==fator2.getSinal()) {
			resultado = mesmoSinal(fator1, fator2);
			
			
		} else {
			Dinheiro invfator;
			//Verifica qual o positivo
			if (fator1.getSinal()) {
				//Inverte para fazer a diferença
				invfator = new Dinheiro(fator2.getReal()*-1, fator2.getCentavos()*-1, fator2.getRestos()*-1);				
				resultado = sinalDiferente(fator1, invfator);				
				
			}else {
				//Inverte para fazer a diferença
				invfator = new Dinheiro(fator1.getReal()*-1, fator1.getCentavos()*-1, fator1.getRestos()*-1);
				resultado = sinalDiferente(fator2, invfator);
			}
			
		}
		
		return resultado;
	}
		
	
	/**
	 * Calcula a diferença do valor
	 * 
	 * @param fator1	O Valor atual
	 * @param fator2	O valor a ser subtraido
	 * @return Dinheiro	O resultado 
	 */
	public Dinheiro subtracao(Dinheiro fator1, Dinheiro fator2) {
		Dinheiro resultado;
		//Verifica se tem mesmo sinal
		if (fator1.getSinal()==fator2.getSinal()) {
			resultado = sinalDiferente(fator1, fator2);
			
			
		} else {
		
			Dinheiro invfator;
			//Iverte para fazer a diferença
			invfator = new Dinheiro(fator2.getReal()*-1, fator2.getCentavos()*-1, fator2.getRestos()*-1);				
			resultado = mesmoSinal(fator1, invfator);				
		}
			
		
		return resultado;
	}	
	
	
	/**
	 * Soma dos objetos do tipo dinheiro com o mesmo sinal calculando os limites para não extrapolar centavos e nem resto
	 * 
	 * @param fator1		o primeiro fator da soma
	 * @param fator2		o segundo fator da soma
	 * @return Dinheiro		o resultado da soma
	 */
	private Dinheiro mesmoSinal(Dinheiro fator1, Dinheiro fator2) {
		Dinheiro resultado;
		
		//Somatório dos valores
		double somarestos= fator1.getRestos()+fator2.getRestos();
		int somacentavos = fator1.getCentavos()+fator2.getCentavos();
		int somareais=fator1.getReal()+fator2.getReal();
		
		//Se maior ou igual a um, soma um nos centavos
		if (somarestos>=1) {
			somacentavos=somacentavos+1;
			somarestos = somarestos-1;
		} else {
			//Se menor ou igual a um, subtrai um nos centavos
			if (somarestos<=-1) {
					somacentavos=somacentavos-1;
					somarestos = somarestos+1;
			}
		}
		
		//Se maior ou igual a 100, soma um nos reais
		if (somacentavos>=100) {
			somacentavos=somacentavos-100;
			somareais = somareais+1;
		} else {
			//Se menor ou igual a 100, subtrai um nos reais
			if (somacentavos<=-100) {
				somacentavos=somacentavos+100;
				somareais = somareais-1;
			}
		}
		//Prepara a saída
		resultado = new Dinheiro(somareais, somacentavos, somarestos);
		
		return resultado;
		
	}
	
	
/**
 * 
 * Soma os objetos do tipo dinheiro com sinais diferentes verificando e tratando a troca de sinais
 * 
 * @param fator1 		O valor atual
 * @param fator2		O valor a ser subtraido
 * @return	Dinheiro	O resultado em Dinheiro	
 */
private Dinheiro sinalDiferente (Dinheiro fator1, Dinheiro fator2) {
		
		Dinheiro resultado;
		
		//Faz todas as subtrações de cada item
		double subtrairestos= fator1.getRestos()-fator2.getRestos();
		int subtraicentavos = fator1.getCentavos()-fator2.getCentavos();
		int subtraireais=fator1.getReal()-fator2.getReal();
	
		//Verifica se o resultado é negativo
		if (subtraireais<0) {
		
			//Verifica se o resto é positivo e transforma em negativo
			if (subtrairestos>0) {
				subtrairestos=subtrairestos-1.0;
				subtraicentavos = subtraicentavos+1;
			}
		
			//Verifica se o centavos é positivo e transforma em negativo
			if (subtraicentavos>0) {
				subtraireais=subtraireais+1;
				subtraicentavos = subtraicentavos-100;
			}
			
		}else {
			//Verifica se o resultado é positivo
			if (subtraireais>0) {	
				
				//Verifica se o resto é negativo e transforma em positivo
				if (subtrairestos<0) {
					subtrairestos=subtrairestos+1.0;
					subtraicentavos = subtraicentavos-1;
				}
			
				//Verifica se centavos é negativo e transforma em positivo
				if (subtraicentavos<0) {
					subtraireais=subtraireais-1;
					subtraicentavos = subtraicentavos+100;
				}
			} else {
				//Se for zerado reais, checa se o sinal de centavos e restos estão diferentes
				//Se centavos positivo e resto negativo, acerta o resto
				if (subtrairestos<0 && subtraicentavos>0) {
					subtrairestos=subtrairestos+1.0;
					subtraicentavos = subtraicentavos-1;
				} 
				
				//Se centavos negativo e resto positivo, acerta o resto
				if (subtrairestos>0 && subtraicentavos<0) {
					subtrairestos=subtrairestos-1.0;
					subtraicentavos = subtraicentavos+1;
				} 
				
			}
			
		}
		//Prepara a saída
		resultado = new Dinheiro(subtraireais, subtraicentavos, subtrairestos);		
		return resultado;
	}
	
}
