package serverChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionThread implements Runnable{

    public Socket connection;
    private boolean run;
    public Scanner fromConnection;
    public PrintWriter toConnection;
    private static ArrayList<ConnectionThread> connectionsList = new ArrayList<>(); // Lista delle connessioni
    private ConnectionsList cl;
    private String userName; //  Nickname del client connesso
    private String userMSG; // Messaggio in arrivo dal client connesso
    private String userIP;
    private Boolean Ban = false; 
    
    
    public ConnectionThread(Socket c, ConnectionsList cl){
        this.userIP = "";
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
            
            if(!Ban){
                switch(userMSG){

                    case ("data"):{
                        Date d = new Date();
                        toConnection.println("Server-"+d);
                        break;
                    }
                    case ("utenti"):{
                        int nUsers = connectionsList.size()-1;
                        String str = "";
                        if(nUsers==0){
                            str = "In questo server sei connesso solamente tu :(";
                        }
                        else{
                            str = "In questo server sono connessi, oltre a te, "+nUsers+" utenti. Ecco i loro nickname: ";
                            for (ConnectionThread ct : connectionsList) {
                                if (ct.connection!=this.connection) {
                                        str+=ct.getUsername()+" ";
                                }
                            }
                        }
                        toConnection.println("Server-"+str);
                        break;
                    }
                    case ("exit"):{
                        for (ConnectionThread ct : connectionsList) {
                            try {
                                if (ct.connection!=this.connection) {
                                    this.toConnection = new PrintWriter(ct.connection.getOutputStream(),true);
                                    toConnection.println("Server-"+this.userName+" ha abbandonato la chat");
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                }
                            }
                        this.resetOutputStream();
                        this.connectionsList.remove(this);
                        this.run = false;
                        cl.RedrawPannel();
                        break;
                    }

                    // All'utente viene assegnato l'username, se è già stato utilizzato viene bloccato
                    case ("nameinserting"):{
                        
                        userMSG = this.fromConnection.nextLine();
                        
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
                            userIP = fromConnection.nextLine();
                            for (ConnectionThread ct : connectionsList) {
                                try {
                                    if (ct.connection!=this.connection) {
                                        this.toConnection = new PrintWriter(ct.connection.getOutputStream(),true);
                                        toConnection.println("Server-"+userMSG+" si e' connesso alla chat");
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            this.resetOutputStream();
                            cl.RedrawPannel();
                        }
                        else{
                            toConnection.println("no");
                        }
                        break;
                    }

                    // Viene inviato il messaggio a tutti i client
                    default:{
                        for (ConnectionThread ct : connectionsList) {
                            try {
                                if (ct.connection!=this.connection) {
                                    this.toConnection = new PrintWriter(ct.connection.getOutputStream(),true);
                                    toConnection.println(this.userName+"-"+userMSG);
                                }
                            } 
                            catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        this.resetOutputStream();
                        break;
                    }
                }
            }
        }
        this.connectionsList.remove(this);
        cl.RedrawPannel();
    }
    
    // Quando il server decide di bannare un client
    public void kickUser(){
        toConnection.println("Server-"+"Sei stato bannato dal server.");
        this.connectionsList.remove(this);
        
        for (ConnectionThread ct : connectionsList) {
            try {
                this.toConnection = new PrintWriter(ct.connection.getOutputStream(),true);
                toConnection.println("Server-"+this.userName+" e' stato bannato dalla chat.");
            } catch (IOException ex) {
            }
            this.resetOutputStream();
        }
                
        cl.RedrawPannel();
        this.run = false;
        Ban = true;
    }
    
    public void sendCloseMessage(){
        for (ConnectionThread ct : connectionsList) {
            try {
                this.toConnection = new PrintWriter(ct.connection.getOutputStream(),true);
                toConnection.println("Server-Il server è stato chiuso, tutti gli utenti sono stati disconnessi");
            } catch (IOException ex) {
            }
            this.resetOutputStream();
        }
    }
    
    public String getUsername(){return this.userName;}
    public String getAddress(){
        return userIP;
    }
    
    
    public ConnectionsList getupdate(){
        return cl;
    }
    public void setupdate(ConnectionsList cl){
        this.cl = cl;
    }
    
    public void resetOutputStream(){
        try {
            this.toConnection = new PrintWriter(this.connection.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int getConnectionsListSize(){return this.connectionsList.size();}
    public ArrayList<ConnectionThread> getConnectionsList(){return this.connectionsList;}
}
