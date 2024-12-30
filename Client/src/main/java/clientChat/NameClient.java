
package clientChat;

import java.io.PrintWriter;
import java.util.Scanner;

public class NameClient extends javax.swing.JFrame {
    
    private Scanner fromConnection;
    private PrintWriter toConnection;
    
    public NameClient() {
        initComponents();
    }

    private void play(ChatClient C){
        C.setVisible(true);
        Thread t = new Thread(C);
        t.start();
        this.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitle = new javax.swing.JLabel();
        btnConnect = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy SMS");
        setMaximumSize(new java.awt.Dimension(350, 420));
        setPreferredSize(new java.awt.Dimension(330, 390));
        setSize(new java.awt.Dimension(320, 325));

        txtTitle.setBackground(new java.awt.Color(204, 204, 255));
        txtTitle.setFont(new java.awt.Font("Verdana", 2, 18)); // NOI18N
        txtTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitle.setText("Easy SMS");

        btnConnect.setBackground(new java.awt.Color(204, 255, 204));
        btnConnect.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        btnConnect.setText("ACCEDI ALLA CHAT");
        btnConnect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnConnect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConnect.setMaximumSize(new java.awt.Dimension(160, 140));
        btnConnect.setMinimumSize(new java.awt.Dimension(160, 40));
        btnConnect.setPreferredSize(new java.awt.Dimension(160, 40));
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 255, 204));
        jLabel2.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Per accedere  alla chat inserisci il tuo nickname");

        txtName.setBackground(new java.awt.Color(204, 255, 204));
        txtName.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.setText("Nickname");
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNameMouseClicked(evt);
            }
        });

        lblError.setBackground(new java.awt.Color(204, 255, 204));
        lblError.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 80, Short.MAX_VALUE)
                .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnConnect.getAccessibleContext().setAccessibleName("ConnetiB2");
        txtName.getAccessibleContext().setAccessibleName("NomeCTF");
        lblError.getAccessibleContext().setAccessibleName("ErrorLabel2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        
        if(txtName.getText().equals("")){
            lblError.setText("Inserisci un nome!");
        }
        else{
            toConnection.println("nameinserting");
            toConnection.println(txtName.getText());
            if(fromConnection.nextLine().equals("no")){
                lblError.setText("Nickname già in uso, scegline un altro");
            }
            else{
                ChatClient chatClient = new ChatClient(fromConnection, toConnection);
                play(chatClient);
            }
            
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void txtNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMouseClicked
        txtName.setText("");
    }//GEN-LAST:event_txtNameMouseClicked

    public void setConnections(Scanner fc, PrintWriter tc){
        this.fromConnection=fc;
        this.toConnection=tc;
    }
    
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
                new NameClient().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnConnect;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextField txtName;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
