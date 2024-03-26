package view;

import controller.ThreadTransacao;

public class Main {

	public static void main(String[] args) {
		
		//criando 21 threads
		for (int i = 1; i <= 21; i++) {
			int t = (i % 3);
			Thread processo = new ThreadTransacao(i, t, 1, 1);
			processo.start();
		}
	}

}
