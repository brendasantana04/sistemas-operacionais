package view;
import java.util.concurrent.Semaphore;
import CavaleiroController.CavaleiroController;

public class Main {

	public static void main(String[] args) {
//		4 cavaleiros caminham por um corredor, simultaneamente, de 2 a 4 m por 50 ms. O corredor é
//		escuro, tem 2 km e em 500 m, há uma única tocha. O cavaleiro que pegar a tocha, aumenta sua
//		velocidade, somando mais 2 m por 50 ms ao valor que já fazia. Em 1,5 km, existe uma pedra
//		brilhante. O cavaleiro que pegar a pedra, aumenta sua velocidade, somando mais 2 m por 50 ms
//		ao valor que já fazia. Ao final dos 2 km, abrem uma porta randômica km, os cavaleiros se separam
//		com 4 portas e, um por vez pega uma porta aleatória (que não pode repetir) e entra nela. Apenas
//		uma porta leva à saída. As outras 3 tem monstros que os devoram.

		//permissão
		int permissao = 3;
		Semaphore semaforo = new Semaphore(permissao);
		
		//4 cavaleiros
		for (int idCavaleiro = 1; idCavaleiro <= 4; idCavaleiro ++) {
			Thread ThreadCavaleiro = new CavaleiroController(2000, 0, 0, 0, idCavaleiro, semaforo);
			ThreadCavaleiro.start();
		}
	}

}
