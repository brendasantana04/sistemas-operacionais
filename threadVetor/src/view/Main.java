package view;
import java.util.*;
import controller.ThreadVetor;

public class Main {

	public static void main(String[] args) {
	//	3) Criar em java um projeto com uma Thread chamada ThreadVetor, que receba um
	//	valor numérico e vetor como parâmetros. Caso o valor numérico seja par, a thread deve
	//	percorrer o vetor utilizando uma estrutura for (int i = 0 ; i < vet.length; i++) e contar o
	//	tempo para percorrer o vetor. Caso o valor numérico seja ímpar, a thread deve percorrer
	//	o vetor utilizando uma estrutura foreach e contar o tempo para percorrer o vetor. No
	//	final, ambas as possibilidades devem apresentar o tempo em segundos.
	//	A operação main deve gerar um vetor de 1000 posições com valores aleatórios de 1 a
	//	100. Deve iniciar 2 ThreadVetor e para uma passar o número 1 e o vetor e para a outra,
	//	passar o número 2 e o mesmo vetor.
		
		//inicializando variaveis
		int[] vetor = new int[1000];
	    Random random = new Random();
	    
	    //preenchendo o valor com valor ate 100
	    for (int i = 0; i < vetor.length; i++) {
	        vetor[i] = random.nextInt(100) + 1;
	    }
	    
	    // fazendo as duas threads se iniciarem, com for e foreach
	   
	    Thread thread1 = new ThreadVetor(1, vetor);
	    thread1.start();
	    
	    System.out.println();
	    
	    Thread thread2 = new ThreadVetor(2, vetor);
	    thread2.start();

	}

}
