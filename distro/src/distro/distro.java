package distro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class distro {
	
	public distro() {
		super();
	}
	
	String os = System.getProperty("os.name");
	String process = "cat /etc/os-release";
	
	//metodo para exibir distro
	public String exibeDistro(String os) {
		String distro = "";
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
		    
		    // verificando se a linha possui IPv4
		    if (linha.contains("PRETTY_NAME:")) {
		    	distro = linha;
		    }
		    
		}
		catch(IOException e){
	    	e.printStackTrace();
		}
		
		return distro;
		
	}
}
