package view;
import controller.DistroController;

public class Main {

	public static void main(String[] args) {

		//instancia
		DistroController dc = new DistroController();
		
		//adquirindo sistema
		String os = dc.osPub();
		System.out.println(os);
		
		//exibindo especificações da distro
		String distro = dc.exibeDistro(os);
		System.out.println(distro);

	}

}
