package serverChat;


public class Utente extends javax.swing.JPanel {

    int userIndex;
    private String userName="";
    private String userIP="";
    
    public Utente(int userIndex, String userName, String userIP) {
        initComponents();
        this.userIndex = userIndex;
        this.userName = userName;
        this.userIP = userIP;
        if(userName.equals("")){
            nomeJL.setText(userIndex +": N/A");
        }else{
            nomeJL.setText(userIndex +": " +userName);
        }
        
        ipJL.setText(userIP);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeJL = new javax.swing.JLabel();
        KickJB = new javax.swing.JButton();
        ipJL = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        nomeJL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeJL.setText("nome");

        KickJB.setBackground(new java.awt.Color(255, 204, 204));
        KickJB.setForeground(new java.awt.Color(153, 0, 0));
        KickJB.setText("X");
        KickJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KickJBActionPerformed(evt);
            }
        });

        ipJL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ipJL.setText("Ip");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(nomeJL, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ipJL, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KickJB, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KickJB, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
            .addComponent(nomeJL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ipJL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void KickJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KickJBActionPerformed
        System.out.println("pulsante numero: " + userIndex);
    }//GEN-LAST:event_KickJBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KickJB;
    private javax.swing.JLabel ipJL;
    private javax.swing.JLabel nomeJL;
    // End of variables declaration//GEN-END:variables
}
