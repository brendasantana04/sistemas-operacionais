package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class KillController {

	//construtor
	public KillController() {
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
	
	//listando processos ativos
	public String listaProcessos(String OS) {
		String process = "";
		//verificando so e ativando processo
		if(OS.contains("Win")) {
			process = "TASKLIST /FO TABLE";
		} else  {
			process = "ps -ef";
		}
		return chamaProcesso(process);
	}
	
	//chamando um processo
	public String chamaProcesso(String process) {
		try {
			//chamando o processo
			Process p = Runtime.getRuntime().exec(process);
			
			//lendo a saida do processo
			InputStream saida = p.getInputStream();
			InputStreamReader saidaLer = new InputStreamReader(saida);
			//adicionando a saida lida no buffer
			BufferedReader buffer = new BufferedReader(saidaLer);
			//guardando na string linha
			String linha = buffer.readLine();
			
			//lendo variavel linha ate o final
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
			//fechando os processos abertos
			buffer.close();
			saidaLer.close();
			saida.close();
			
		} catch (IOException e){
			e.printStackTrace();
		}
		return process;
	}
	
	//metodo que fecha programa por ID
	public String mataPid(String OS) {
		String pid = JOptionPane.showInputDialog("Insira um valor de PID");
		String process = "";
		if (OS.contains("Win")) {
			process = "TASKKILL /PID " + pid;
		}else {
			process = "kill -9 " + pid;
		}
		return chamaProcesso(process);
	}
	
	//metodo que fecha programa por nome
		public String mataNome(String OS) {
			String nome = JOptionPane.showInputDialog("Insira o nome do programa que deseja finalizar");
			String process = "";
			if (OS.contains("Win")) {
				process = "TASKKILL /IM " + nome;
			}else {
				process = "pkill -f " + nome;
			}
			return chamaProcesso(process);
		}
	
}
