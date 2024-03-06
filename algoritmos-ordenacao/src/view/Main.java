package view;
import controller.exercicio01;

public class Main {

	public static void main(String[] args) {

//		1. Considere o seguinte vetor:
//		74 20 74 87 81 16 25 99 44 58
//		a) O teste de mesa para a aplicação de ordenação por Bubble Sort, apresentando quantas rodadas são
//		necessárias para que o vetor fique ordenado;
//		b) O teste de mesa para a aplicação de ordenação por Merge Sort, detalhando as divisões e as operações
//		com os vetores auxiliares;

		
		//variaveis
		int v [ ] = {44, 43, 42, 41, 40, 39, 38}; //vetor a ser ordenado
		int v2 [ ] = {44, 43, 42, 41, 40, 39, 38}; //vetor a ser ordenado exibição 2
		
		//instancia
		exercicio01 ex01 = new exercicio01();
		
		//mostrando resultado mergesort
		System.out.println("=== Ordenando o valor por mergesort ====");
		
		System.out.println();
		System.out.println("Vetor Original");
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i]);
			System.out.print(" ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("===== Organizando o vetor ===== TESTE DE MESA =====");
		//mergesort
		ex01.mergeSort(v); //resultado mergesort
		
		System.out.println();
		System.out.println("Vetor Organizado");
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i]);
			System.out.print(" ");
		}
		
		System.out.println();
		System.out.println();
		//mostrando resultado bubblesort
		System.out.println("=== Ordenando o valor por bubblesort ====");
		
		System.out.println();
		System.out.println("Vetor Original");
		for (int i = 0; i < v2.length; i++) {
			System.out.print(v2[i]);
			System.out.print(" ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("===== Organizando o vetor ===== TESTE DE MESA =====");
		//bubblesort
		int resultado [ ] = ex01.bubbleSort(v, 0, 0, 0);
		
		System.out.println();
		System.out.println("Vetor Organizado");
		for (int i = 0; i < resultado.length; i++) {
			System.out.print(resultado[i]);
			System.out.print(" ");
		}

	}
}