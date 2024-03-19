package view;

import controller.ThreadSapo;

public class Main {

	public static void main(String[] args) {
	//		Fazer uma aplicação de uma corrida de sapos, com 5 Threads, cada Thread
	//		controlando 1 sapo. Deve haver um tamanho máximo para cada pulo do sapo (em
	//		metros) e a distância máxima para que os sapos percorram. A cada salto, um sapo pode
	//		dar um salto de 0 até o tamanho máximo do salto (valor aleatório). Após dar um salto, a
	//		Thread, para cada sapo, deve mostrar no console, qual foi o tamanho do salto e quanto
	//		o sapo percorreu. Assim que o sapo percorrer a distância máxima, a Thread deve
	//		apresentar que o sapo chegou e qual sua colocação.
	//		Dica: O exercício deve ser resolvido todo em console, ou seja, como se estivesse sendo
	//		narrado. Atenção para a forma de definir a ordem de chegada.
		
		//vetoress
		int distanciaTotal = 100; // distancia total
        int passo = 10; // tamanho do passo

		System.out.println("Iniciando Corrida!!");
		//criando 5 sapinhos
		for (int i = 0; i < 5; i ++) {
			Thread sapinho = new ThreadSapo(i + 1, distanciaTotal, passo);
			sapinho.start();
		}

	}

}
