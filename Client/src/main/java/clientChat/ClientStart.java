package clientChat;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientStart extends javax.swing.JFrame {

    private String serverIP;
    private int serverPort;
    Socket connection;
    
    public ClientStart() {
        InetAddress serverAddress;
        initComponents();
    }
    
    private void play(NameClient c){
        c.setVisible(true);
        this.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblClientChat = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPorta = new javax.swing.JTextField();
        btnConnection = new javax.swing.JToggleButton();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy SMS");
        setSize(new java.awt.Dimension(320, 330));

        lblClientChat.setBackground(new java.awt.Color(204, 204, 255));
        lblClientChat.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        lblClientChat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClientChat.setText("Easy SMS");

        jLabel2.setBackground(new java.awt.Color(153, 153, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("IP:");

        txtIp.setBackground(new java.awt.Color(204, 255, 204));
        txtIp.setText("127.0.0.1");
        txtIp.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(153, 153, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Porta:");

        txtPorta.setBackground(new java.awt.Color(204, 255, 204));
        txtPorta.setText("8080");
        txtPorta.setCaretColor(new java.awt.Color(255, 255, 255));

        btnConnection.setBackground(new java.awt.Color(204, 255, 204));
        btnConnection.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        btnConnection.setText("COLLEGATI ALLA CHAT");
        btnConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectionActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnConnection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPorta, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))))
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblClientChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClientChat, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btnConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtIp.getAccessibleContext().setAccessibleName("IpClient");
        txtPorta.getAccessibleContext().setAccessibleName("PortClient");
        btnConnection.getAccessibleContext().setAccessibleName("ConnettiB1");
        lblError.getAccessibleContext().setAccessibleName("ErrorLabel1");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectionActionPerformed
        this.serverIP = txtIp.getText();
        
        if(serverIP.equals("") || txtPorta.getText().equals("")){
            lblError.setText("Inserisci dei dati validi!");
        }
        else{
            
            if(serverIP.length()>15 || serverIP.length()<7){
                lblError.setText("Inserisci un'indirizzo ip valido!!");
            }
            else{
                try{
                    this.serverPort = Integer.parseInt(txtPorta.getText()); 
                }
                catch(Exception e){
                    lblError.setText("Inserisci una porta valida!!");
                }
            }
            
            try{
                InetAddress serverAddress = InetAddress.getLocalHost();
                Socket connection = new Socket(serverAddress, this.serverPort);
            
                Scanner fromConnection = new Scanner(connection.getInputStream());
                PrintWriter toConnection = new PrintWriter(connection.getOutputStream(),true);
                
                
                NameClient c = new NameClient();
                c.setConnections(fromConnection, toConnection);
                play(c);
                
                
            }
            catch(Exception e){
                e.printStackTrace();
                lblError.setText("C'è stato un errore durante l'accesso al server");
            }
            
            
        }
        
    }//GEN-LAST:event_btnConnectionActionPerformed

    public void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientStart().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnConnection;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblClientChat;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextField txtIp;
    private javax.swing.JTextField txtPorta;
    // End of variables declaration//GEN-END:variables
}
