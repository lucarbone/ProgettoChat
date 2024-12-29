package clientChat;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GlobalChatThread implements Runnable{

    private JTextArea areaTesto = new JTextArea();
    private Scanner fromConnection;
    
    public GlobalChatThread(JTextArea f, Scanner fc){
        areaTesto = new JTextArea();
        areaTesto = f;
        fromConnection = fc;
    }
    
    @Override
    public void run() {
        while(true){
            areaTesto.append(fromConnection.nextLine());
        }
    }
    
}
