package serverChat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ConnectionThread implements Runnable{

    private Socket connection;
    private boolean run;
    private Scanner fromConnection;
    private PrintWriter toConnection;
    private static ArrayList<ConnectionThread> connectionsList = new ArrayList<>(); // Lista delle connessioni
    private ConnectionsList cl;
    private String userName; //  Nickname del client connesso
    private String userMSG; // Messaggio in arrivo dal client connesso
    private boolean Redraw = false; // Utilizzato per riferire al connection list che bisogna ridisegnare il panello,
                             //dato che è stato inserito un nuovo nome
    
    public ConnectionThread(Socket c, ConnectionsList cl){
        this.connection = c;
        this.run = true;
        this.userName = "";
        this.cl = cl;
        try {
            this.fromConnection = new Scanner(connection.getInputStream());
            this.toConnection = new PrintWriter(connection.getOutputStream(),true); // questo true quando facciamo il println dorza l'invio
            this.connectionsList.add(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ConnectionThread(){}
    
    // Ciclo principale dove il server riceve i messaggi del client
    @Override
    public void run() {
        while(this.run){
            
            userMSG = this.fromConnection.nextLine();
            switch(userMSG){
                
                case ("data"):{
                    Date d = new Date();
                    toConnection.println("server: "+d);
                    break;
                }
                case ("exit"):{
                    System.out.println("Connessione chiusa");
                    this.connectionsList.remove(this);
                    this.run = false;
                    cl.RedrawPannel();
                    break;
                }
                
                // All'utente viene assegnato l'username, se è già stato utilizzato viene bloccato
                case ("nameinserting"):{
                    System.out.println("richiesta nome");
                    userMSG = this.fromConnection.nextLine();
                    System.out.println("nome ricevuto");
                    boolean userAvailable = true;
                    for(ConnectionThread ct : connectionsList){
                        if(ct.getUsername().equals(userMSG)){
                           userAvailable=false;
                           break;
                        }
                    }
                    
                    if(userAvailable){
                        this.userName=userMSG;
                        toConnection.println("y");
                        cl.RedrawPannel();
                    }
                    else{
                        toConnection.println("no");
                    }
                    break;
                }
                default:{
                    
                    break;
                }

            }
           
        }
        this.connectionsList.remove(this);
    }
    
    // Quando il server decide di bannare un client
    public void kickUser(){
        run=false;
        //toConnection.print("expulsed!");
    }
    
    public String getUsername(){return this.userName;}
    public String getAddress(){return (this.connection.getInetAddress()+"");}
    
    
    public ConnectionsList getupdate(){
        return cl;
    }
    public void setupdate(ConnectionsList cl){
        this.cl = cl;
    }
    
    public int getConnectionsListSize(){return this.connectionsList.size();}
    public ArrayList<ConnectionThread> getConnectionsList(){return this.connectionsList;}
}
