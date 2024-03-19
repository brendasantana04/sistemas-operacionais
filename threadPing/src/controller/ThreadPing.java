package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadPing extends Thread {
    private String servidor;
    private String process;
    private double tempoTotal;

    public ThreadPing(String servidor) {
        this.servidor = servidor;
        this.process = "ping -4 -c 10 " + servidor;
        this.tempoTotal = 0;
    }

    @Override
    public void run() {
        System.out.println("Iniciando ping para " + servidor + "...");
        try {
        	//iniciando processo de ping
            Process processo = Runtime.getRuntime().exec(process);
            BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            //fazendo leitura do console
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
                //verificando se acha o valor de tempo
                if (linha.contains("time=")) {
                    int inicio = linha.indexOf("time=") + 5;
                    int fim = linha.indexOf(" ms");
                    String tempoStr = linha.substring(inicio, fim);
                    double tempo = Double.parseDouble(tempoStr);
                    //somando o valor de tempo a variavel
                    tempoTotal += tempo;
                }
            }
            //aguardando o processo, pra thread nao correr
            processo.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double getTempoTotal() {
    	//enviando variavel pra classe principal
        return tempoTotal;
    }
}