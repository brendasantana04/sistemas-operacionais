package view;
import controller.RedesController;

public class Main {
	
	public static void main(String[] args) {
		
		//instancia
		RedesController rc = new RedesController();
		
		//lendo sistema operacional
		String os = rc.retornarOs();
		System.out.println(os);
		
		//descobrindo ip passando o sistema operacional
		String ip = rc.ip(os);
		System.out.println(ip);
		
		
		//fazendo ping chamada de ping com 10 iterações
		String ping = rc.ping(os);
		System.out.println(ping);
	}
}
