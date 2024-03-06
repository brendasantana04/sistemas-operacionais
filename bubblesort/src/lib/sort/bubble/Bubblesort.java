package lib.sort.bubble;

public class Bubblesort {

	public Bubblesort() {
		super();
	}
	
//	===== algoritmo de ordenação - BubbleSort ====== 
	
	public int[ ] bubbleSort(int v[ ], int i, int j, int aux) {
		for (i = 0; i < v.length; i++){
			for (j = 0; j < v.length - 1; j++) {
				if (v[i] < v[j]) {
					aux = v[j];
					v[j] = v[i];
					v[i] = aux; 
				}
			}
		mostrarRodada(v);
		}
		return v;
	}
	
	private void mostrarRodada(int[] v) {
        for (int i = 0; i <= v.length - 1; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

}
