package view;
import controller.Exercicio02;

public class Main {

	public static void main(String[] args) {
		
		//criando variaveis com os textos que serão separados
		String txt1 = "abóbora;abobrinha;alcachofra;aspargos;batata-doce;berinjela;beterraba"; // 7 palavras
		String txt2 = "abacate;ameixa;amora;banana;cajá;figo;maçã;melancia;uva;seriguela"; // 10 palavras
		String txt3 = "acelga;alface;alho-poró;coentro;endívia;escarola;repolho;rúcula"; // 8 palavras
		
		//instanciando a classe com a funcao
		Exercicio02 calcular = new Exercicio02();

		
		//dividindo o texto e calculando quantas partes ele tem
		int div1 =  calcular.dividir(txt1);
		int div2 =  calcular.dividir(txt2);
		int div3 =  calcular.dividir(txt3);
		
		//mostrando o resultado
		System.out.println("O texto 1 possui " + div1 +" partes");
		System.out.println("O texto 2 possui " + div2 +" partes");
		System.out.println("O texto 3 possui " + div3 +" partes");
	}

}
