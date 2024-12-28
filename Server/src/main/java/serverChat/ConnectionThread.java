package serverChat;

import java.net.Socket;

public class ConnectionThread implements Runnable{

    private Socket connection;
    private boolean run = true;
    
    public ConnectionThread(Socket c){
        this.connection = c;
    }
    
    @Override
    public void run() {
        while(this.run){}
    }
    
    // Quando il server decide di bannare un client
    public void kickUser(){run=false;}
}
