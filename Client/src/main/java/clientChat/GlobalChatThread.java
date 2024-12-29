package clientChat;

import java.awt.FlowLayout;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GlobalChatThread implements Runnable{

    private JPanel areaMessage = new JPanel();
    private Scanner fromConnection;
    String message;
    
    public GlobalChatThread(JPanel pnl, Scanner fc){
        areaMessage = new JPanel();
        areaMessage = pnl;
        fromConnection = fc;
    }
    
    @Override
    public void run() {
        while(true){
            message = fromConnection.nextLine();
            addMessage(message);
        }
    }
    
    public void addMessage(String message){
        
        MessageBox msgBox = new MessageBox(".",message);
        
        JPanel alignPanel = new JPanel();
        alignPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        alignPanel.add(msgBox);
        
        areaMessage.add(alignPanel);
        areaMessage.revalidate();
        areaMessage.repaint();
        
        
    }
}
