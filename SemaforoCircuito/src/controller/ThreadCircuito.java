package controller;
import java.util.concurrent.Semaphore;
import java.util.Arrays;
import java.util.Random;

public class ThreadCircuito extends Thread {
	//variaveis
	private int idAtletas;
	private static Semaphore semaforo;
	private static long tempo;
	private int distancia;
	private static int[] score;
	private static int pontosTiro;
	private static boolean circuitoConcluido = false;
	static Random r = new Random();
	
	//construtor
	public ThreadCircuito(int idAtletas, Semaphore semaforo, int[] score) {
		this.idAtletas = idAtletas;
		this.semaforo = semaforo;
		this.score = score;
	}
	
	@Override
	public void run() {
		//metodos que irão rodar...
		circuito(idAtletas, distancia);
		
	}
	
	//metodo com o circuito completo
	public static void circuito(int idAtletas, int distancia) {
		System.out.println("Início do circuito!!\n ");
		corrida(idAtletas, 0);
		tiro(idAtletas, tempo, pontosTiro);
		ciclismo(idAtletas, 3000);
	    ranking(idAtletas, score);
	}
	
	//corrida
	public static void corrida(int idAtletas, int distancia) {
		//inicio da corrida
		while (distancia <= 3000) {
			if (distancia % 100 == 0) {
				System.out.println("O atleta ["+ idAtletas +"] correu "+ distancia +" metros!\n ");
			}
			distancia += r.nextInt(25) + 20;
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//ciclismo
	public static void ciclismo(int idAtletas, int distancia) {
		//inicio do ciclismo
	    while (distancia <= 5000){
			if (distancia % 100 == 0) {
				System.out.println("O atleta ["+ idAtletas +"] andou de bicicleta por "+ distancia +" metros!\n ");
			}
			distancia += r.nextInt(40) + 30;
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//tiro ao alvo
	public static void tiro(int idAtletas, long tempo, int pontosTiro) {
		//apenas 5 atletas podem ficar no stand de tiro, e cada tiro leva de 0.3 a 0.5 ms
		int total = 0;
		int exec = 0;
		while (exec <= 3) {
			try {
				//momento critico
				semaforo.acquire();
				pontosTiro += r.nextInt(10) + 0;
				total += pontosTiro;
				score[idAtletas] = total;
				System.out.println("O atleta ["+ idAtletas +"] fez um tiro que vale "+ pontosTiro +" pontos !\n total de pontos = " + total +"\n ");
				double dormir = (r.nextDouble(0.5) + 0.3);
				try {
					Thread.sleep((long)dormir);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				semaforo.release();
				exec++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//metodo com o ranking
	public static void ranking(int idAtletas, int [ ]score) {
		for (idAtletas = 0; idAtletas < score.length; idAtletas++) {
		    score [idAtletas] = score[idAtletas] + (idAtletas + 1) * 10;
		}
		Arrays.sort(score);
		for (idAtletas = 0; idAtletas < score.length; idAtletas++) {
            System.out.println("Posição " + (idAtletas + 1) + ": Atleta " + idAtletas + " - Pontuação: " + score[idAtletas]);
        }
	}
}
