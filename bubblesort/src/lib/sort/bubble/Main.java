package lib.sort.bubble;

public class Main {

	public static void main(String[] args) {
		
	//variaveis
	int v [ ] = {44, 43, 42, 41, 40, 39, 38}; //vetor a ser ordenado

	Bubblesort bs = new Bubblesort();
	
	//mostrando resultado bubblesort
			System.out.println("==== Ordenando o valor por bubblesort ====");
			
			System.out.println();
			System.out.println("Vetor Original");
			for (int i = 0; i < v.length; i++) {
				System.out.print(v[i]);
				System.out.print(" ");
			}
			
			System.out.println();
			System.out.println();
			System.out.println("===== Organizando o vetor ===== TESTE DE MESA =====");
			//bubblesort
			int resultado [ ] = bs.bubbleSort(v, 0, 0, 0);
			
			System.out.println();
			System.out.println("Vetor Organizado");
			for (int i = 0; i < resultado.length; i++) {
				System.out.print(resultado[i]);
				System.out.print(" ");
			}
	}

}
