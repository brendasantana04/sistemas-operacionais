package view;
import controller.ThreadCozinha;

public class Main {

	public static void main(String[] args) {
	//criando os pratos de comida
			for (int i = 1; i <= 5; i++) {
				int t = (i % 2);
				ThreadCozinha processo = new ThreadCozinha(i, t, 0, 0, 0);
				processo.start();
			}
		

	}

}
