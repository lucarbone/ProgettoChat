package serverChat;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ConnectionsList implements Runnable{

    private ArrayList<Utente> utenti;
    private ConnectionThread currentCT;
    private ConnectionThread updatedCT;
    private JPanel connectionsPanel;
    private JLabel numberUsersLabel;
    private ArrayList<ConnectionThread> usersList = new ArrayList<>();
    
    
    public ConnectionsList(ConnectionThread ct, JPanel pnl, JLabel lbl){
        this.currentCT = ct;
        this.updatedCT = ct;
        this.connectionsPanel = pnl;
        this.numberUsersLabel = lbl;
        utenti = new ArrayList<>();
        this.usersList = ct.getConnectionsList();
    }
    
    
    @Override
    public void run() {
        while(true){
            //System.out.println("run");
            
        }//fine while
    }//fine run
    
    public void updateConnections(ConnectionThread ct){
        this.updatedCT = ct;
        RedrawPannel();
    }
    
    public void RedrawPannel(){
        this.currentCT = this.updatedCT;
        connectionsPanel.setPreferredSize(new Dimension(320,((this.currentCT.getConnectionsListSize()*45))));    
        connectionsPanel.removeAll(); // Rimuove tutti i componenti dal pannello
        connectionsPanel.revalidate(); // Aggiorna il layout
        connectionsPanel.repaint();
        utenti.clear();

        numberUsersLabel.setText("Utenti Connessi: "+this.currentCT.getConnectionsListSize());
            
        for(int i = 0;i<this.currentCT.getConnectionsListSize();i++){
                Utente u = new Utente(i,usersList.get(i).getUsername(),usersList.get(i).getAddress(), usersList.get(i));
                utenti.add(u);
                utenti.get(i).setBounds(10,(((i)*40)+10),285,35);
                connectionsPanel.add(utenti.get(i));
        }
        
    }
    
}
