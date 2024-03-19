package controller;
import java.util.concurrent.TimeUnit;

public class ThreadVetor extends Thread {
	
    private int valor;
    private int[] vetor;
    
    //construtor
    public ThreadVetor(int valor, int[] vetor) {
        this.valor = valor;
        this.vetor = vetor;
    }
    
    @Override
    public void run() {
    	//o que está dentro será executado
    	
    	//inicio
        long inicio = System.nanoTime();
        
        //se valor for par, utilizar for
        if (valor % 2 == 0) {
        	System.out.println("Percorrendo o vetor com for");
            for (int i = 0; i < vetor.length; i++) {
               int aux = vetor[i];
            }
        //se for impar, usar foreach
        } else {
        	System.out.println("Percorrendo o vetor com foreach");
            for (int n : vetor) {
                int aux = n;
            }
        }
        
        //fim
        long fim = System.nanoTime();
        long total = fim - inicio;
        
        //calculando o tempo em segundos
        double segundos = TimeUnit.NANOSECONDS.toSeconds(total);
        System.out.println("Tempo para percorrer o vetor: " + total + "nanosegundos");
        System.out.println("Tempo para percorrer o vetor: " + segundos + "segundos");
    }
}

