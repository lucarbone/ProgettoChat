package serverChat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionThread implements Runnable{

    private Socket connection;
    private boolean run;
    private Scanner fromConnection;
    private PrintWriter toConnection;
    
    public ConnectionThread(Socket c){
        this.connection = c;
        this.run = true;
        try {
            this.fromConnection = new Scanner(connection.getInputStream());
            this.toConnection = new PrintWriter(connection.getOutputStream(),true); // questo true quando facciamo il println dorza l'invio
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        while(this.run){}
    }
    
    // Quando il server decide di bannare un client
    public void kickUser(){run=false;}
}
