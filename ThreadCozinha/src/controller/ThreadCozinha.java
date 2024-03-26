package controller;

import java.util.Random;

public class ThreadCozinha extends Thread {

	private int prato;
	private int tipo;
	private double tempo;
	private double tempoDecorrido;
	private int porcentagem = 0;
	
	//CONTROLLER
	public ThreadCozinha(int prato, int tipo, double tempo, double tempoDecorrido, int porcentagem) {
		this.prato = prato;
		this.tipo = tipo;
		this.tempo = tempo;
		this.tempoDecorrido = tempoDecorrido;
		this.porcentagem = porcentagem;
	}

	@Override
	public void run() {
		//processos rodam aqui...
		selecao(prato, tipo, tempo, tempoDecorrido, porcentagem);
	}
	
	public void selecao(int prato, int tipo, double tempo, double tempoDecorrido, int porcentagem) {
		
		Random r = new Random();
		switch(tipo) {
		case 0: //se for par, lasanha
			tempo = (int) ((r.nextDouble(1.2) + 0.6));
			try {
				System.out.println("prato "+ prato +" iniciou o prato de lasanha  [" + porcentagem + "%]");
				while (tempoDecorrido < tempo) {
					Thread.sleep(100); //DORMIR POR 0.1 SEGUNDOS
					tempoDecorrido = System.currentTimeMillis() - tempo;
					porcentagem = (int) (((double) tempoDecorrido / tempo) * 100);
					System.out.println("prato "+ prato +" = prato de lasanha  [" + porcentagem + "%]");
				}
				System.out.println("prato " + prato + " de lasanha esta pronto");
				Thread.sleep(500);
				System.out.println("prato " + prato + " de lasanha foi entregue");
			} catch (Exception e){
				e.printStackTrace();
			}

		case 1: //se for impar, sopa de cebola
			tempo = (int) ((r.nextDouble(0.8) + 0.5));
			try {
				System.out.println("prato "+ prato +" iniciou o prato de sopa de cebola  [" + porcentagem + "%]");
				while (tempoDecorrido < tempo) {
					Thread.sleep(100); //DORMIR POR 0.1 SEGUNDOS
					tempoDecorrido = System.currentTimeMillis() - tempo;
					porcentagem = (int) (((double) tempoDecorrido / tempo) * 100);
					System.out.println("prato "+ prato +" = prato de sopa de cebola  [" + porcentagem + "%]");
				}
				System.out.println("prato " + prato + " de sopa de cebola esta pronto");
				Thread.sleep(500);
				System.out.println("prato " + prato + " de sopa de cebola foi entregue");
			} catch (Exception e){
				e.printStackTrace();
			}

		}
	}
}
