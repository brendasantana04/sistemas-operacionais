package view;
import controller.threadID;

public class Main {
	
	public static void main(String[] args) {
		
		int idThread;
		
		//criando 5 threads e executando elas
        for (idThread = 0; idThread < 5; idThread ++) {
            Thread threadId = new threadID(idThread);
            // adquirindo o TID da thread
            long iD = threadId.getId();
            threadId.start();
            System.out.println("Thread = " + iD + ".... ID = " + idThread);
        }
        
		//criando uma instancia de threadID
		threadID thread = new threadID(idThread); 
        thread.run();
	}

}
