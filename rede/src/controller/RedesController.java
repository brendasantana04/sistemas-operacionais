package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	//construtor
	public RedesController() {
		super();	
	}
	
	//métodos
	private static String os() {
		//identificar nome do sistema operacional
		String OS = System.getProperty("os.name");
		return OS;
	}
	//habilitando o metodo privado para poder ser instanciado
	public String retornarOs() {
		return os();
	}
	//usando o sistema operacional e rodando o processo de verificação de ip
	public String ip(String OS) {
		String process = "";
		//chama as configurações de ip
		if (OS.contains("Win")){
			process = "IPCONFIG";
		}else if(OS.contains("nux")) {
			process = "ip addr";
		}else if(OS.contains("nix")) {
			process = "ifconfig";
		}
		return lerProcesso(process);
	}
	//metodo de chamada de ping
	public String ping(String OS) {
		String process = "";
		//chama as configurações de ip
		if (OS.contains("Win")){
			process = "ping -4 -n 10 www.google.com.br";
		}else {
			process = "ping -4 -c 10 www.google.com.br";
	}
		return chamaProcesso(process);
	}
	
	public String chamaProcesso(String process) {
		try {
			//rodando o processo
			Process p = Runtime.getRuntime().exec(process);
			
			//fazer a leitura dos dados de uma variavel
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);	
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			//lendo a variavel linha enquanto ela nao for nula ou vazia
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
			//fechando os processos
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		return process;
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
	    
	    // extraindo o adaptador de rede e o IPv4 com operação split
	    String[] saidaSplit = sb.toString().split("\n");
	    String adaptadorRede = "";
	    String ipv4 = "";
	    for (String linhaSplit : saidaSplit) {
	      // verificando se a linha possui nome do adaptador de rede
	      if (linhaSplit.contains("Ethernet") || linhaSplit.contains("Wi-Fi")) {
	        adaptadorRede = linhaSplit;
	      }
	      // verificando se a linha possui IPv4
	      if (linhaSplit.contains("IPv4")) {
	        ipv4 = linhaSplit;
	      }
	    }
	    
	    // resposta da consulta
	    String saida = adaptadorRede + "\n" + ipv4;
	    return saida;
	  } catch (IOException e) {
	    e.printStackTrace();
	    return "erro";
	  }
	}
}
