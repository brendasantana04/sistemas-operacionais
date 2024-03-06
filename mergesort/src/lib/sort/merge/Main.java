package lib.sort.merge;

public class Main {
	
	public static void main (String [ ] args) {
		//variaveis
				int v [ ] = {44, 43, 42, 41, 40, 39, 38}; //vetor a ser ordenado
				
				//instancia
				Mergesort ms = new Mergesort();
				
				//mostrando resultado mergesort
				System.out.println("=== Ordenando o valor com Mergesort ====");
				
				System.out.println();
				System.out.println("Vetor Original");
				for (int i = 0; i < v.length; i++) {
					System.out.print(v[i]);
					System.out.print(" ");
				}
				
				System.out.println();
				System.out.println();
				System.out.println("===== Organizando o vetor =====");
				
				//mergesort
				ms.mergeSort(v); //resultado mergesort
				
				System.out.println();
				System.out.println("Vetor Organizado");
				for (int i = 0; i < v.length; i++) {
					System.out.print(v[i]);
					System.out.print(" ");
				}
	}
}
