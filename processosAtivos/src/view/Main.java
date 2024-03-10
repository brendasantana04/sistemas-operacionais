package view;

import controller.KillController;

public class Main {

	public static void main(String[] args) {

		//instancia
		KillController kc = new KillController();
		
		//lendo sistema operacional
		String os = kc.retornarOs();
		System.out.println(os);
		
		//listando processos ativos
		String processos = kc.listaProcessos(os);
		System.out.println(processos);
		
		//matando processo por pid
		String killpid = kc.mataPid(os);
		System.out.println(killpid);
		
		//matando processo por nome
		String killnome = kc.mataNome(os);
		System.out.println(killnome);
	}
}
