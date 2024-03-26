package controller;
import java.util.*;

public class ThreadTransacao extends Thread {

	private int idThread;
	private int tipo;
	private double calculo;
	private double transacao;
	
	//construtor
	public ThreadTransacao(int idThread, int tipo, double calculo, double transacao) {
		this.idThread = idThread;
		this.tipo = tipo;
		this.calculo = calculo;
		this.transacao = transacao;
	}
	
	
	@Override
	public void run() {
		//processos rodam aqui...
		selecao(tipo, idThread);
	}
	
	Random r = new Random();
	
	public void selecao(int tipo, int threadId) {
		switch(tipo) {
		case 0:
			for (int i = 0; i <= 3; i ++) {
				calculo = r.nextInt(2) + 1;
				long tempo = (long)calculo * 1000;
				try {
					System.out.println("Thread " + idThread + " do tipo " + tipo + ": Inicio do Calculo");
					Thread.sleep(tempo * 1000);
					System.out.println("Thread " + idThread + " do tipo " + tipo + ": Fim do Calculo");
				} catch (Exception e){
					e.printStackTrace();
				}
				transacao = 1;
				tempo = (long)transacao * 1000;
				try {
					System.out.println("Thread " + idThread + " do tipo " + tipo + ": Inicio da transacao");
					Thread.sleep(tempo * 1000);
					System.out.println("Thread " + idThread + " do tipo " + tipo + ": Fim da transacao");
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		case 1:
			for (int i = 0; i <= 2; i ++) {
				calculo = r.nextDouble(1) + 0.2;
				long tempo = (long)calculo * 1000;
				try {
					System.out.println("Thread " + idThread + " do tipo " + tipo + ": Inicio do Calculo");
					Thread.sleep(tempo * 1000);
					System.out.println("Thread " + idThread + " do tipo " + tipo + ": Fim do Calculo");
				} catch (Exception e){
					e.printStackTrace();
				}
				transacao = 1.5;
				tempo = (long)transacao * 1000;
				try {
					System.out.println("Thread " + idThread + " do tipo " + tipo + ": Inicio da transacao");
					Thread.sleep(tempo * 1000);
					System.out.println("Thread " + idThread + " do tipo " + tipo + ": Fim da transacao");
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		case 2:
			for (int i = 0; i <= 3; i ++) {
				calculo = r.nextDouble(1.5) + 0.5;
				long tempo = (long)calculo * 1000;
				try {
					System.out.println("Thread " + idThread + " do tipo " + tipo + ": Inicio do Calculo");
					Thread.sleep(tempo * 1000);
					System.out.println("Thread " + idThread + " do tipo " + tipo + ": Fim do Calculo");
				} catch (Exception e){
					e.printStackTrace();
				}
				transacao = 1.5;
				tempo = (long)transacao * 1000;
				try {
					System.out.println("Thread " + idThread + " do tipo " + tipo + ": Inicio da transacao");
					Thread.sleep(tempo * 1000);
					System.out.println("Thread " + idThread + " do tipo " + tipo + ": Fim da transacao");
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
}
