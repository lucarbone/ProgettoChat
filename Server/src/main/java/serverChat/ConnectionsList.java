package serverChat;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
            
            try {
                numberUsersLabel.setText(""+this.currentCT.getConnectionsListSize());
                
                for(int i = 0;i<this.currentCT.getConnectionsListSize();i++){
                    Utente u = new Utente(i,"","");
                    utenti.add(u);
                    utenti.get(i).setBounds(10,(((i)*40)+10),285,35);
                    connectionsPanel.add(utenti.get(i));
                    i++;
                }
                
                Thread.sleep(2000);
                this.currentCT = this.updatedCT;
                connectionsPanel.removeAll(); // Rimuove tutti i componenti dal pannello
                connectionsPanel.revalidate(); // Aggiorna il layout
                connectionsPanel.repaint();
                utenti.clear();
            } catch (InterruptedException ex) {
                Logger.getLogger(ConnectionsList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void updateConnections(ConnectionThread ct){
        this.updatedCT = ct;
    }
    
}
