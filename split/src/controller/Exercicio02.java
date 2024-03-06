package controller;

public class Exercicio02 {

		public Exercicio02 () {
			super();
		}
		
		public int dividir(String txt) {
			
			//separando o txt em partes e colocando em um vetor
			String [ ] palavras = txt.split(";");
			
			//contando quantas partes o texto tem
			
			int partes = palavras.length;
			
			return partes;
		}
}
