package controller;

import lib.sort.merge.*;
import lib.sort.bubble.*;

public class Sort {
	
	public Sort() {
		super();
	}
	
	public static void ordenar(int [ ] v) {
		Mergesort ms = new Mergesort();
		Bubblesort bs = new Bubblesort();
		
		System.out.println("Bubblesort");
		
		bs.bubbleSort(v, 0, 0, 0);
		System.out.println();
		
		System.out.println("Mergesort");
		ms.mergeSort(v);
	}
	
}
