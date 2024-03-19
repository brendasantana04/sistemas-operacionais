package view;
import controller.ThreadPing;

public class Main {
	 public static void main(String[] args) {
	        // verificando se e linux
	        String osName = System.getProperty("os.name");
	        if (!osName.contains("nux")) {
	            System.out.println("Precisa ser um sistema operacional LINUX!!!");
	            return;
	        }

	        //criando as threads pra cada site
	        ThreadPing uolThread = new ThreadPing("www.uol.com.br");
	        ThreadPing terraThread = new ThreadPing("www.terra.com.br");
	        ThreadPing googleThread = new ThreadPing("www.google.com.br");
	        
	        //inicializando
	        uolThread.start();
	        terraThread.start();
	        googleThread.start();

	        //threads aguardando ate o fim da execucao
	        try {
	            uolThread.join();
	            terraThread.join();
	            googleThread.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        //calculando tempo medio utilizando get
	        double tempoUOL = uolThread.getTempoTotal() / 10;
	        double tempoTerra = terraThread.getTempoTotal() / 10;
	        double tempoGoogle = googleThread.getTempoTotal() / 10;

	        //resposta
	        System.out.println("tempo medio de ping para UOL: " + tempoUOL + " ms");
	        System.out.println("tempo medio de ping para TERRA: " + tempoTerra + " ms");
	        System.out.println("tempo medio de ping para GOOGLE: " + tempoGoogle + " ms");
	    }
}
