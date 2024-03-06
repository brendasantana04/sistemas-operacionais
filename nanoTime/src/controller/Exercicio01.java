package controller;

public class Exercicio01 {
	 
	public Exercicio01(){
		super();
	}
	
	public double percorrerPreencherCalcular (int [] v){
		
		//preenchendo o vetor
        for (int i = 0; i < v.length; i++) {
            v[i] = 0;
        }
        
        //realizando o calculo de tempo
    
        long temI = System.nanoTime(); //tempo inicial
        //percorrendo o vetor, sem realizar cálculos
        for (int i = 0; i < v.length; i++) {
            int percorre = v[i]; //tempo final
        }
        long temF = System.nanoTime();
        
        //calculando o tempo gasto em segundos
        double temG = (temF - temI) / Math.pow(10, 9);
        
        return temG;
	}
}