package view;
import controller.Exercicio01;

public class Main {
	
	public static void main (String [ ] args) {
	    //criando variáveis que serão testados os tempos
		
		//mil espaços
		int [] v1= new int [1000];
		//10 mil espaços
		int [] v2= new int [10000];
		//100 mil espaços
		int [] v3= new int [100000];
		
		//instanciando a classe com a funcao que realizará os cálculos
		Exercicio01 calcular = new Exercicio01();
		
		//realizando os cálculos
		double r1 = calcular.percorrerPreencherCalcular(v1);
		double r2 = calcular.percorrerPreencherCalcular(v2);
		double r3 = calcular.percorrerPreencherCalcular(v3);
		
		//mostrando os resultados no console
		System.out.println("O tempo gasto para percorrer um vetor de 1000 espaços é de "+ r1 +" segundos");
		System.out.println("O tempo gasto para percorrer um vetor de 10000 espaços é de "+ r2 +" segundos");
		System.out.println("O tempo gasto para percorrer um vetor de 100000 espaços é de "+ r3 +" segundos");
	}	
}
