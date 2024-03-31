package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class AeroportoController extends Thread {
	
	//variaveis
	static Random r = new Random();
	private int idAviao;
	private double tempo = 0;
	private static String pista; 
	private static Semaphore semaforo;
	private static boolean norte = true; //pista esta vazia, false esta ocupada
	private static boolean sul = true;
	
	//construtor
	public AeroportoController(int idAviao, Semaphore semaforo, double tempo) {
		this.idAviao = idAviao;
		this.semaforo = semaforo;
		this.tempo = tempo;
	}
	
	@Override
	public void run() {
		//metodo que irão rodar
		area(idAviao, tempo, pista);
	}
	
	
	//onde será controlada a saida dos avioes
	public static void area(int idAviao, double tempo, String pista) {
		///aqui serao feitos dois momentos criticos, para acessar a pista norte e sul
		try {
			//momento critico em que duas threads terao que acessar aqui
			semaforo.acquire();
			
			if (norte == true) {
				pista = "Pista Norte";
				try {
					norte = false;
					semaforo.acquire();
					decolagem(idAviao, tempo, pista);
					semaforo.release();
					norte = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if (!norte && sul == true){
				pista = "Pista Sul";
				try {
					sul = false;
					semaforo.acquire();
					decolagem(idAviao, tempo, pista);
					semaforo.release();
					sul = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			semaforo.release();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//onde a decolagem sera performada
	public static void decolagem(int idAviao, double tempo, String pista) {
		////////////////manobra
		System.out.println("===== Iniciando a manobra ===== \n"
				+ " Avião [" + idAviao + "] realizou a manobra na pista " + pista + "!!!");
		tempo = r.nextInt(700) + 300;
		System.out.println();
		try {
			Thread.sleep((long) tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		////////////////taxiar
		System.out.println("===== Iniciando o taxiar ===== \n"
				+ " Avião [" + idAviao + "] realizou o taxiar na pista " + pista + "!!!");
		tempo = r.nextInt(1000) + 500;
		System.out.println();
		try {
			Thread.sleep((long) tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		////////////////decolagem
		System.out.println("===== Iniciando a decolagem ===== \n"
				+ " Avião [" + idAviao + "] realizou a decolagem na pista " + pista + "!!!");
		tempo = r.nextInt(1000) + 500;
		System.out.println();
		try {
			Thread.sleep((long) tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		////////////////afastamento
		System.out.println("===== Iniciando o afastamento ===== \n"
				+ " Avião [" + idAviao + "] realizou o afastamento na pista " + pista + "!!!");
		tempo = r.nextInt(800) + 300;
		System.out.println();
		try {
			Thread.sleep((long) tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}
