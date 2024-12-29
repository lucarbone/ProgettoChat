
package clientChat;

import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ChatClient extends javax.swing.JFrame implements Runnable{
    
    private Scanner fromConnection;
    private PrintWriter toConnection;
    private GlobalChatThread gct;
    
    public ChatClient(Scanner fc, PrintWriter tc) {
        initComponents();
        this.fromConnection = fc;
        this.toConnection = tc;
        gct = new GlobalChatThread(this.getTxtArea(),fc);
        
        Thread t = new Thread(gct);
        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaMessage = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnQuit = new javax.swing.JButton();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("La Chat");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                DisconnectU(evt);
            }
        });

        areaMessage.setColumns(20);
        areaMessage.setRows(5);
        jScrollPane1.setViewportView(areaMessage);
        areaMessage.getAccessibleContext().setAccessibleName("ChatTFA");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Easy SMS");

        btnQuit.setForeground(new java.awt.Color(255, 0, 51));
        btnQuit.setText("ABBANDONA");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        btnSend.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSend.setText("Invia");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMessage)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnQuit.getAccessibleContext().setAccessibleName("AbbandonaB");
        txtMessage.getAccessibleContext().setAccessibleName("MessaggioTF");
        btnSend.getAccessibleContext().setAccessibleName("SendB");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    // L'utente abbandona la chat
    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        /*
        Se l'utente chiude la pagina senza abbandonare la chat, 
        il server lo considera ancora come attivo e lo mostra come tale. 
        Per evitare questo comportamento, prima della chiusura della finestra, 
        viene inviato un messaggio al server per notificare la disconnessione dell'utente.
        */
        UserQuit();
    }//GEN-LAST:event_btnQuitActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        String msg = txtMessage.getText();
        if(!(msg.equals(""))){
            areaMessage.append("Tu: "+msg + "\n");
            toConnection.println(msg);
            txtMessage.setText("");
        }else{
            JOptionPane.showMessageDialog(this, "Non puoi mandare un messaggio vuoto");
        }
        
    }//GEN-LAST:event_btnSendActionPerformed

    private void DisconnectU(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_DisconnectU
        /*
        Se l'utente chiude la pagina senza abbandonare la chat, 
        il server lo considera ancora come attivo e lo mostra come tale. 
        Per evitare questo comportamento, prima della chiusura della finestra, 
        viene inviato un messaggio al server per notificare la disconnessione dell'utente.
        */
        UserQuit();
    }//GEN-LAST:event_DisconnectU


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaMessage;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void run() {
       
    }
    
    public JTextArea getTxtArea(){
        return this.areaMessage;
    }
    private void UserQuit(){
        int choice = JOptionPane.showConfirmDialog(null, "Sei sicuro di abbandonare la chat?", "Abbandona chat", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            this.toConnection.println("exit");
            this.dispose();
            System.exit(0);
        }
    }
    
}
