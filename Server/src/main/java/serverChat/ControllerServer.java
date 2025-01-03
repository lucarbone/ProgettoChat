package serverChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ControllerServer extends javax.swing.JFrame implements Runnable{

    private String ip;
    private int port;
    private ArrayList<ConnectionThread> usersConnected;
    private ArrayList<Utente> utenti;
    private ConnectionThread ct;
    private ConnectionsList cl;
    
    public ControllerServer(String ip, int port) {
        initComponents();
        this.ip = ip;
        this.port = port;
        lblIp.setText("Ip: "+ip);
        lblPorta.setText("Porta: "+port);
        ct = new ConnectionThread();
        cl = new ConnectionsList(ct, this.getPanel(),this.getNUsersLabel());
        
        
        // Da sistemare implementazione lasciar commentato
        Thread connectionListThread = new Thread(cl);
        connectionListThread.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NUsers = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        lblIp = new javax.swing.JLabel();
        lblPorta = new javax.swing.JLabel();
        JSP = new javax.swing.JScrollPane();
        UJP = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Server Easy SMS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Server Della Chat");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Server Online ");

        NUsers.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        NUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NUsers.setText("Utenti Connessi: 0");
        NUsers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnClose.setBackground(new java.awt.Color(255, 204, 204));
        btnClose.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        btnClose.setText("CHIUDI SERVER");
        btnClose.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblIp.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblIp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIp.setText("Ip:");

        lblPorta.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblPorta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorta.setText("Porta:");

        JSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JSP.setPreferredSize(new java.awt.Dimension(321, 1002));

        UJP.setMaximumSize(new java.awt.Dimension(320, 2000));
        UJP.setMinimumSize(new java.awt.Dimension(320, 150));
        UJP.setPreferredSize(new java.awt.Dimension(319, 150));
        UJP.setRequestFocusEnabled(false);

        javax.swing.GroupLayout UJPLayout = new javax.swing.GroupLayout(UJP);
        UJP.setLayout(UJPLayout);
        UJPLayout.setHorizontalGroup(
            UJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        UJPLayout.setVerticalGroup(
            UJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );

        JSP.setViewportView(UJP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(JSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 3, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPorta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(NUsers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(lblIp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(lblIp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPorta)
                        .addGap(37, 37, 37)
                        .addComponent(NUsers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSP, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        closeServer();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeServer();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSP;
    private javax.swing.JLabel NUsers;
    private javax.swing.JPanel UJP;
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblIp;
    private javax.swing.JLabel lblPorta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            ServerSocket myServer = new ServerSocket(this.port);
            System.out.println("Server online");

            while(true){
                
                Socket connection = myServer.accept();
                System.out.println("Connessione stabilita");

                // informazioni del client connesso
                String clientIP = connection.getInetAddress().getHostAddress();
                int clientPort = connection.getPort();
                System.out.println("IP: "+clientIP+ " port: "+clientPort+"\n");

                /*
                 * Parte il thread che gestisce la connessione
                 */
                ConnectionThread connectionThread = new ConnectionThread(connection, cl);
                cl.updateConnections(connectionThread);
                Thread t = new Thread(connectionThread);
                t.start();
                connectionThread.setupdate(cl);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Funzione richiamata quando l'user chiude il server
    private void closeServer(){
        int choice = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler chiudere il server?\nTutti gli utenti collegati verranno disconnessi.", "Chiusura server", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            this.dispose();
            System.exit(0);
        }
    }
    
    public JPanel getPanel(){
        return this.UJP;
    }
    public JLabel getNUsersLabel(){
        return this.NUsers;
    }
    
    
    
    
    
}
