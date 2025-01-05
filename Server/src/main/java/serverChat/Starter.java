package serverChat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Starter extends javax.swing.JFrame{

    ControllerServer C;
    public Starter() {
        try {
            initComponents();

            // Prendiamo l'indirizzo locale del pc
            InetAddress localHost = InetAddress.getLocalHost();
            String ipAddress = localHost.getHostAddress();
            // System.out.println("");

            // Prendiamo l'indirizzo del pc riferito alla rete a cui è connesso
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface networkInterface = networkInterfaces.nextElement();

                    // Ignorare le interfacce che non sono attive o sono di loopback
                    if (!networkInterface.isUp() || networkInterface.isLoopback()) {
                        continue;
                    }

                    Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = inetAddresses.nextElement();

                        if (!(inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isMulticastAddress() )) {//|| inetAddress.getHostAddress().equals(ipAddress)
                            System.out.println("Interfaccia: " + networkInterface.getName());
                            System.out.println("Indirizzo IP: " + inetAddress.getHostAddress());
                            txtIp.setText(inetAddress.getHostAddress());
                            break;
                        }
                    }
                }
                if(txtIp.equals("")){
                    txtIp.setText(ipAddress);
                }
            } catch (Exception e) {
                System.err.println("Errore durante il recupero degli indirizzi IP: " + e.getMessage());
            }

        } 
        catch (UnknownHostException ex) {
            txtIp.setText("127.0.0.1");
        }
    }

    
    private void play(String ip, int port){
        C = new ControllerServer(ip, port);
        Thread t = new Thread(C);
        t.start();
        C.setVisible(true);
        this.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPorta = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server Easy SMS");
        setIconImages(null);
        setResizable(false);
        setSize(new java.awt.Dimension(330, 500));

        jLabel1.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Easy SMS Server");

        jLabel2.setBackground(new java.awt.Color(153, 153, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("IP:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        txtIp.setEditable(false);
        txtIp.setBackground(new java.awt.Color(204, 255, 204));
        txtIp.setToolTipText("");
        txtIp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtIp.setCaretColor(new java.awt.Color(255, 255, 255));
        txtIp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIpMouseClicked(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(153, 153, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        jLabel3.setText("Porta:");
        jLabel3.setFocusable(false);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        txtPorta.setBackground(new java.awt.Color(204, 255, 204));
        txtPorta.setText("8080");
        txtPorta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPorta.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPorta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPortaMouseClicked(evt);
            }
        });

        jToggleButton1.setBackground(new java.awt.Color(204, 255, 204));
        jToggleButton1.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        jToggleButton1.setText("LANCIA SERVER");
        jToggleButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setToolTipText("");
        lblError.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.getAccessibleContext().setAccessibleName("IP");
        txtIp.getAccessibleContext().setAccessibleName("ipJTF");
        jLabel3.getAccessibleContext().setAccessibleName("Porta");
        txtPorta.getAccessibleContext().setAccessibleName("portaJTF");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        String ip = txtIp.getText();
        
        // Verifichiamo che l'utente abbia inserito dei valori 
        if(ip.equals("") || txtPorta.getText().equals("")){
            lblError.setText("Inserisci dei valori!!");
        }
        else{
            // Verifichiamo che i valori siano validi
            if(ip.length()>15 || ip.length()<7){
                lblError.setText("Inserisci un'indirizzo ip valido!!");
            }
            else{
                try{
                    int port = Integer.parseInt(txtPorta.getText());
                    
                    try{
                        if(port<=1023 || port>=65535){
                            lblError.setText("Inserisci una porta valida!!");
                        }else if(!isAvailable(port)){
                             lblError.setText("Usa un'altra porta, questa è già in uso!");
                        }else{
                            play(ip, port);
                            lblError.setText("Tentativo di connessione...");
                        }
                    }
                    catch(Exception err){
                        lblError.setText("Impossibile lanciare il server,\ninserisci dei dati validi");
                    }
                    
                }
                catch(Exception e){
                    lblError.setText("Inserisci una porta valida!!");
                }
            }
        }
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void txtIpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIpMouseClicked
        lblError.setText("");
    }//GEN-LAST:event_txtIpMouseClicked

    private void txtPortaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPortaMouseClicked
        lblError.setText("");
    }//GEN-LAST:event_txtPortaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextField txtIp;
    private javax.swing.JTextField txtPorta;
    // End of variables declaration//GEN-END:variables

    
    public static boolean isAvailable(int portNr) {
        boolean portFree;
        try (var ignored = new ServerSocket(portNr)) {
            portFree = true;
        } catch (IOException e) {
            portFree = false;
        }
        return portFree;
    }
    
    
}
