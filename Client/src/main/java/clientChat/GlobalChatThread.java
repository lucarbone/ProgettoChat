package clientChat;

import java.awt.FlowLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GlobalChatThread implements Runnable{

    private JPanel areaMessage = new JPanel();
    private Scanner fromConnection;
    private String message;
    private String time;
    
    public GlobalChatThread(JPanel pnl, Scanner fc){
        areaMessage = new JPanel();
        areaMessage = pnl;
        fromConnection = fc;
    }
    
    @Override
    public void run() {
        while(true){
            message = fromConnection.nextLine();
            time = getCurrentTime();
            addMessage(message, time);
        }
    }
    
    public void addMessage(String message, String time){
        
        MessageBox msgBox = new MessageBox(".",message, time);
        
        JPanel alignPanel = new JPanel();
        alignPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        alignPanel.add(msgBox);
        
        areaMessage.add(alignPanel);
        areaMessage.revalidate();
        areaMessage.repaint();
        
        
    }
    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formatter);
    }
}
