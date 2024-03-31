package view;
import controller.ThreadCircuito;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		
		//variaveis
		int idAtletas;
		int permissoes = 5;
		int [ ] score = new int [26];
		Semaphore semaforo = new Semaphore(permissoes);
		
		//criando 25 atletas
		for (idAtletas = 0; idAtletas <= 25; idAtletas ++) {
				Thread ThreadAtleta = new ThreadCircuito(idAtletas, semaforo, score);
				ThreadAtleta.start();
		}

	}

}
