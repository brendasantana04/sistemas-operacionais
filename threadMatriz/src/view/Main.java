package view;

import controller.threadMatriz;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		//Fazer uma aplicação que insira números aleatórios em uma matriz 3 x 5 e tenha 3
		//chamadas de Threads, onde cada uma calcula a soma dos valores de cada linha,
		//imprimindo a identificação da linha e o resultado da soma.
		
		//criando variaveis
		int m [ ][ ] = new int [3] [5];
		int x, y, soma = 0, idThread;
		
		//instancia de classe
		Random random = new Random();
		
		//adicionando valores a matriz
		for (x = 0; x < 3; x ++) {
			for (y = 0; y < 5; y ++) {
				m[x][y] = random.nextInt(101);
			}
		}
		
		//mostrando os valores da matriz
		System.out.println("Exibindo a matriz");
		for (x = 0; x < 3; x ++) {
			System.out.print("Linha "+ x +" ->\t");
			for (y = 0; y < 5; y ++) {
				System.out.print(m[x][y] + "\t");			
			}
			System.out.println();
		}
		
		System.out.println();
		
		//usando as threads
        for (idThread = 0; idThread < 3; idThread ++) {
        	Thread threadM = new threadMatriz (idThread);
            for (y = 0; y < 5; y++) {
            	soma = soma + m[idThread][y];
            }
            threadM.start();
            System.out.println("Thread " + idThread + ".... Soma da linha = " + soma);      
    	}
            
    }
}

