package CavaleiroController;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class CavaleiroController extends Thread {
	
	private int corredorTamanho = 2000;
	private int distanciaPercorrida;
	private int velocidade;
	private int meta;
	private int idCavaleiro;
	private static Semaphore semaforo;
	private static boolean tochaSelec = false;
	private static boolean pedraSelec = false;
	private static boolean chave = false;
	
	//construtor
	public CavaleiroController(int corredorTamanho, int velocidade, int meta, int distanciaPercorrida, int idCavaleiro, Semaphore semaforo) {
		this.corredorTamanho = corredorTamanho;
		this.velocidade = velocidade;
		this.distanciaPercorrida = distanciaPercorrida;
		this.meta = meta;
		this.idCavaleiro = idCavaleiro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		//metodos que irao rodar
		System.out.println("Início da corrida");
		caminhada(0, 2100, 0, idCavaleiro);
	}
	
	static Random r = new Random();
	
	public static void caminhada(int distanciaPercorrida, int meta, int velocidade, int idCavaleiro) {
		//loop para correr
	    for (int i = 0; i < meta; i += velocidade) {
	        velocidade = r.nextInt(4) + 2;
	        try {
	            Thread.sleep(5);
	            distanciaPercorrida += velocidade;
	            if (distanciaPercorrida % 100 == 0) {
	            	System.out.println("Distancia percorrida por cavaleiro [" + idCavaleiro + "] = " + distanciaPercorrida);
	            }
	            //quando chegar na meta, para
	            //pegar a tocha
	            if (distanciaPercorrida == 500) {
	            	try {
            		// === MOMENTO CRITICO ===
	        			semaforo.acquire();
	        			tocha(distanciaPercorrida, velocidade, idCavaleiro, meta);
	        		} catch (InterruptedException e) {
	        			e.printStackTrace();
	        		}
	            }
	            //pegar a pedra
	            else if (distanciaPercorrida == 1500) {
	            	try {
	            	// === MOMENTO CRITICO === 
	        			semaforo.acquire();
	        			pedra(distanciaPercorrida, velocidade, idCavaleiro, meta);
	        		} catch (InterruptedException e) {
	        			e.printStackTrace();
	        		}	            
	            }
	            //pegar a porta
	            else if (distanciaPercorrida == 2000) {
	            	// === MOMENTO CRITICO === 
	            	try {
	        			semaforo.acquire();
	        			porta(distanciaPercorrida, velocidade, idCavaleiro, meta);
	        		} catch (InterruptedException e) {
	        			e.printStackTrace();
	        		}	            
	                break;
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	//metodos que serão percorridos
	public static void tocha(int distanciaPercorrida, int velocidade, int idCavaleiro, int meta) {
	    if (!tochaSelec) {
	        tochaSelec = true;
	        velocidade += 2;
	        System.out.println("O cavaleiro " + idCavaleiro + " pegou a tocha e ganhou +2 de velocidade!");
	    }
	}

	public static void pedra(int distanciaPercorrida, int velocidade, int idCavaleiro, int meta) {
	    if (!pedraSelec) {
	        pedraSelec = true;
	        velocidade += 2;
	        System.out.println("O cavaleiro " + idCavaleiro + " pegou a pedra e ganhou +2 de velocidade!");
	    }
	}

	public static void porta(int distanciaPercorrida, int velocidade, int idCavaleiro, int meta) {
	    if (!chave) {
	    	chave = true;
	        System.out.println("O cavaleiro " + idCavaleiro + " venceu!");
	    } else {
	        System.out.println("O cavaleiro " + idCavaleiro + " morreu!");
	    }
	}

}
