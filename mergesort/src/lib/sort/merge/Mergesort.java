package lib.sort.merge;

public class Mergesort {
	
	public Mergesort() {
		super();
	}
	
//	===== algoritmo de ordenação - MergeSort ======
	
	public void mergeSort(int [] v) {
		
		int t = v.length; //adquirindo tamanho do vetor
		if (t <= 1) return; //caso o tamanho for menor que um, retornar 
		
		//declaração de variáveis
		int meio = t / 2;
		int [ ] esquerdaVetor = new int [meio]; //tamanho do vetor é metade
		int [ ] direitaVetor = new int [t - meio]; //tamanho do vetor é o total - metade
		int i = 0; //esquerda 
		int j = 0; //direita
		
		//fazendo a divisão de forma recursiva
		
		for (i = 0; i < t; i++) {
			if (i < meio) {
				esquerdaVetor[i] = v[i];  
				//enquanto i não chegar a metade, metade do vetor original será armazenado
				//na esquerdavetor
			} else {
				direitaVetor[j] = v[i];
				//após a primeira metade ser preenchida, a segunda começará a ser também
				j++; //contador da segunda parte do vetor
			}
		}
		
		//chamando as funcoes recursivamente
		mergeSort(esquerdaVetor);
		mergeSort(direitaVetor);
		merge(esquerdaVetor, direitaVetor, v); //função de suporte
		mostrarRodada(v); //mostrando o passo a passo do sorting
		
	}
	
	private static void merge(int [ ] esquerdaVetor, int [ ] direitaVetor, int [ ] v) {
		
		int esquerda = v.length / 2; //tamanho da esquerda é metade do vetor
		int direita = v.length - esquerda; //tamanho da direita é o total - esquerda
		int i = 0; //indice do vetor
		int e = 0; //indice da esquerda
		int d = 0; //indice da direita
		
		//fazendo a junção
		//enquanto o contador da esquerda e direita não chegarem aos respectivos
		//valores totais dos vetores, juntar os valores no vetor original
		while (e < esquerda && d < direita) {
			if (esquerdaVetor[e] < direitaVetor[d]) {
				v[i] = esquerdaVetor[e];
				i++;
				e++;
			}else {
				v[i] = direitaVetor[d];
				i++;
				d++;
			}
		}
		
		//verificador para ultimo numero restante
		while (e < esquerda) {
			v[i] = esquerdaVetor[e];
			i++;
			e++; 
		}
		while (d < direita) {
			v[i] = direitaVetor[d];
			i++;
			d++; 
		}
	}
	
	private void mostrarRodada(int[] v) {
        for (int i = 0; i <= v.length - 1; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }
}
