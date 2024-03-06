package view;

import controller.Sort;

public class Main {

	public static void main(String[] args) {
		//exercicio 1
		int [ ] v = {74, 20, 74, 87, 81, 16, 25, 99, 44, 58};
		//exercicio 2
		int [ ] v2 = {44, 43, 42, 41, 40, 39, 38}; 
		
		System.out.println("Exercicio 1");
		Sort.ordenar(v);
		
		System.out.println();
		
		System.out.println("Exercicio 2");
		Sort.ordenar(v2);
	}

}
