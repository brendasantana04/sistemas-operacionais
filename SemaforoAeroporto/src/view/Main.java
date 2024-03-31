package view;
import java.util.concurrent.Semaphore;
import controller.AeroportoController;

public class Main {

	public static void main(String[] args) {
		//permissao do semaforo
		int permissao = 4;
		Semaphore semaforo = new Semaphore(permissao);
		
		double tempo = 0;

		//criando 12 aviões
		for (int idAviao = 0; idAviao <= 12; idAviao ++) {
			Thread ThreadAeroporto = new AeroportoController(idAviao, semaforo, tempo);
			ThreadAeroporto.start();
		}
	}

}
