package controller;
import java.util.Random;

public class ThreadSapo extends Thread {

	private int id;
    private int distanciaTotal;
    private int passo;
    private int distanciaPercorrida;
    	
	//construtor
	public ThreadSapo(int id, int distanciaTotal, int passo) {
		this.id = id;
        this.distanciaTotal = distanciaTotal;
        this.passo = passo;
        this.distanciaPercorrida = 0;
	}
	
	
	@Override
	public void run() {
		//vai ser executado

		//inicializando random
        Random random = new Random();
		
		//criando corrida
		while (distanciaPercorrida < distanciaTotal) {
            int pulo = random.nextInt(passo + 1); //fazendo um pulo
            distanciaPercorrida += pulo; 

            // verificando se a distancia percorrida esta correta, se passar de 100 o sapinho vences
            if (distanciaPercorrida > distanciaTotal) {
                distanciaPercorrida = distanciaTotal;
            }

            System.out.println("Sapo " + id + " pulou " + pulo + " metros e percorreu " + distanciaPercorrida + " metros.");

            try {
            	//fazendo simulação de pulos
                Thread.sleep(200); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("<=====> sapo " + id + " chegou no final <=====>");	
	}
}
