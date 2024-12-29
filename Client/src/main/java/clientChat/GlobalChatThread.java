package clientChat;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GlobalChatThread implements Runnable{

    private JPanel areaTesto = new JPanel();
    private Scanner fromConnection;
    
    public GlobalChatThread(JPanel f, Scanner fc){
        areaTesto = new JPanel();
        areaTesto = f;
        fromConnection = fc;
    }
    
    @Override
    public void run() {
        while(true){
            //sareaTesto.append(fromConnection.nextLine());
        }
    }
    
}
