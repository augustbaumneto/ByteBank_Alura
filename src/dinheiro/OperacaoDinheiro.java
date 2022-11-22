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
	public OperacaoDinheiro() {
		
	}
	
	public Dinheiro soma(Dinheiro fator1, Dinheiro fator2) {
		
		double somarestos= fator1.getRestos()+fator2.getRestos();
		int somacentavos = 0;
		int somareais=0;
		
		//Se maior que um, soma um nos centavos
		if (somarestos>=1) {
			somacentavos=somacentavos+1;
			somarestos = somarestos-1;
		}
		
		somacentavos = somacentavos+fator1.getCentavos()+fator2.getCentavos();
		
		//Se maior que 100, soma um nos reais
		if (somacentavos>=100) {
			somacentavos=somacentavos-100;
			somareais = somareais+1;
		}
		
		somareais = somareais+fator1.getReal()+fator2.getReal();
		
		Dinheiro resultado = new Dinheiro();
		resultado.setReal(somareais);
		resultado.setCentavos(somacentavos);
		resultado.setRestos(somarestos);
		return resultado;
	}
	
	
public Dinheiro subtracao (Dinheiro fator1, Dinheiro fator2) {
		
		double subtrairestos= fator1.getRestos()-fator2.getRestos();
		int subtraicentavos = fator1.getCentavos()-fator2.getCentavos();
		int subtraireais=fator1.getReal()-fator2.getReal();
		
		if (subtraireais<0) {
			
			if (subtrairestos>0) {
				subtrairestos=subtrairestos-1.0;
				subtraicentavos = subtraicentavos+1;
			}
		
			
			if (subtraicentavos>0) {
				subtraireais=subtraireais+1;
				subtraicentavos = subtraicentavos-100;
			}
			
		}else {
			if (subtraireais>0) {	
				
				if (subtrairestos<0) {
					subtrairestos=subtrairestos+1.0;
					subtraicentavos = subtraicentavos-1;
				}
			
			
				if (subtraicentavos<0) {
					subtraireais=subtraireais-1;
					subtraicentavos = subtraicentavos+100;
				}
			} else {
				if (subtrairestos<0 && subtraicentavos>0) {
					subtrairestos=subtrairestos+1.0;
					subtraicentavos = subtraicentavos-1;
				} 
				
				if (subtrairestos>0 && subtraicentavos<0) {
					subtrairestos=subtrairestos-1.0;
					subtraicentavos = subtraicentavos+1;
				} 
				
			}
			
		}
		
		Dinheiro resultado = new Dinheiro();
		resultado.setReal(subtraireais);
		resultado.setCentavos(subtraicentavos);
		resultado.setRestos(subtrairestos);
		return resultado;
	}
	
}
