package clientChat;

import java.awt.Color;
import java.awt.FlowLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GlobalChatThread implements Runnable{

    private JPanel areaMessage;
    private JScrollPane scrollPane;
    private Scanner fromConnection;
    private String message;
    private String time;
    
    public GlobalChatThread(JPanel pnl, Scanner fc, JScrollPane jsp){
        areaMessage = new JPanel();
        areaMessage = pnl;
        scrollPane = new JScrollPane();
        scrollPane = jsp;
        fromConnection = fc;
        
    }
    
    @Override
    public void run() {
        while(true){
            try{
                message = fromConnection.nextLine();
            
                time = getCurrentTime();
                addMessage(message, time);
            }
            catch(Exception e){
                break;
            }
            
        }
    }
    
    public void addMessage(String message, String time){
        
        // Riconoscimento autore messaggio
        int msgLength = message.length();
        char messageToArray[] = new char[msgLength];
        messageToArray = message.toCharArray();
        
        String messageAuthor = "";
        String messageContent = "";
        
        boolean authorPassed = false;
        
        for(int i=0; i<msgLength;i++){
            if(!authorPassed){
                if(messageToArray[i]=='-'){
                    authorPassed=true;
                }
                else{
                    messageAuthor+=messageToArray[i];
                }
            }
            else{
                messageContent+=messageToArray[i];
            }
        }
        
        
        MessageBox msgBox = new MessageBox(messageAuthor,messageContent, time);
        msgBox.setColor(Color.lightGray);
        
        JPanel alignPanel = new JPanel();
        alignPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        alignPanel.add(msgBox);
        
        areaMessage.add(alignPanel);
        areaMessage.revalidate();
        areaMessage.repaint();
        
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            this.scrollPane.getVerticalScrollBar().setValue(this.scrollPane.getVerticalScrollBar().getMaximum());
        });
        
    }
    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formatter);
    }
}
