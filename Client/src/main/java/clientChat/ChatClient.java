
package clientChat;


import java.awt.FlowLayout;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ChatClient extends javax.swing.JFrame implements Runnable{
    
    private Scanner fromConnection;
    private PrintWriter toConnection;
    private GlobalChatThread gct;
    private ArrayList<MessageBox> messages;
    
    public ChatClient(Scanner fc, PrintWriter tc) {
        initComponents();
        areaMessage.setLayout(new BoxLayout(areaMessage, BoxLayout.Y_AXIS));

        this.fromConnection = fc;
        this.toConnection = tc;
        gct = new GlobalChatThread(this.getTxtPanel(),fc);
        
        Thread t = new Thread(gct);
        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnQuit = new javax.swing.JButton();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaMessage = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Easy SMS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 2, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Easy SMS");

        btnQuit.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        btnQuit.setForeground(new java.awt.Color(255, 0, 51));
        btnQuit.setText("ABBANDONA");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        txtMessage.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N

        btnSend.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        btnSend.setText("Invia");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        areaMessage.setAutoscrolls(true);
        areaMessage.setMaximumSize(new java.awt.Dimension(1000000000, 1000000000));
        areaMessage.setPreferredSize(new java.awt.Dimension(315, 395));

        javax.swing.GroupLayout areaMessageLayout = new javax.swing.GroupLayout(areaMessage);
        areaMessage.setLayout(areaMessageLayout);
        areaMessageLayout.setHorizontalGroup(
            areaMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );
        areaMessageLayout.setVerticalGroup(
            areaMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(areaMessage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSend)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
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
        userQuit();
    }//GEN-LAST:event_btnQuitActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        String msg = txtMessage.getText();
        String time = getCurrentTime();
        if(!(msg.equals(""))){
            addMessage(msg , time);
            toConnection.println(msg);
            txtMessage.setText("");
        }else{
            JOptionPane.showMessageDialog(this, "Non puoi mandare un messaggio vuoto");
        }
        
    }//GEN-LAST:event_btnSendActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        userQuit();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaMessage;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void run() {
       
    }
    
    private void userQuit(){
        int choice = JOptionPane.showConfirmDialog(null, "Sei sicuro di abbandonare la chat?", "Abbandona chat", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            this.toConnection.println("exit");
            this.dispose();
            System.exit(0);
        }
    }
    
    public JPanel getTxtPanel(){
        return this.areaMessage;
    }
    
    public void addMessage(String message, String time){
        MessageBox msgBox = new MessageBox("Tu", message, time);
        
        JPanel alignPanel = new JPanel();
        alignPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,5,5));
        alignPanel.add(msgBox);
        
        areaMessage.add(alignPanel);
        areaMessage.revalidate();
        areaMessage.repaint();
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getMaximum());
        });
    }
    
    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formatter);
    }
}
