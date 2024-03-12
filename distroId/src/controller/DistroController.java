package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {

	//controller
	public DistroController() {
		super();
	}
	
	//metodos 
	
	//adquirir tipo de sistema
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public String osPub() {
		return os();
	}
	
	//verificando distribuição linux
	public String exibeDistro(String os) {
		String process = "";
		if (os.contains("Win")) {
			return "Sistema Operacional " + os + ", não faz parte dos sistemas Linux";
		}
		else {
			process = "cat /etc/os-release";
		}
		return lerProcesso(process);
	}
	
	public String lerProcesso(String process) {
		  try {
		    // executando o processo
		    Process p = Runtime.getRuntime().exec(process);
		    
		    // lendo os dados do processo
		    InputStream fluxo = p.getInputStream();
		    InputStreamReader leitor = new InputStreamReader(fluxo);
		    BufferedReader buffer = new BufferedReader(leitor);

		    // armazenando a saída do processo como uma única string
		    StringBuilder sb = new StringBuilder();
		    String linha;
		    while ((linha = buffer.readLine()) != null) {
		      sb.append(linha).append("\n");
		    }
		    
		    // verificando distro
		    String[] saidaSplit = sb.toString().split("\n");
		    String distro = "";
		    for (String linhaSplit : saidaSplit) {
		      if (linhaSplit.contains("PRETTY_NAME=")) {
		        distro = linhaSplit;
		      }
		    }
		    
		    // resposta da consulta
		    String saida = distro;
		    return saida;
		  } catch (IOException e) {
		    e.printStackTrace();
		    return "erro";
		  }
		}


}
