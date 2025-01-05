package serverChat;

import java.util.ArrayList;


public class Utente extends javax.swing.JPanel {

    int userIndex;
    private int userReports;
    private String userName="";
    private String userIP="";
    private boolean Expelled=false;
    private ConnectionThread user;
    
    public Utente(int userIndex, String userName, String userIP, ConnectionThread ct, int reports) {
        initComponents();
        this.userReports = reports;
        this.userIndex = userIndex;
        this.userName = userName;
        this.userIP = userIP;
        user = ct;
        if(userName.equals("")){
            //nomeJL.setText(userIndex +": N/A");
            nomeJL.setText("N/A");
        }else{
            //nomeJL.setText(userIndex +": " +userName);
            nomeJL.setText(userName);
        }
        ipJL.setText(userIP);
        lblReport.setText("Report: "+userReports);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeJL = new javax.swing.JLabel();
        ipJL = new javax.swing.JLabel();
        lblReport = new javax.swing.JLabel();
        KickJB = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.GridLayout());

        nomeJL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nomeJL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeJL.setText("nome");
        add(nomeJL);

        ipJL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ipJL.setText("Ip");
        add(ipJL);

        lblReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReport.setText("Report:");
        add(lblReport);

        KickJB.setBackground(new java.awt.Color(255, 204, 204));
        KickJB.setForeground(new java.awt.Color(153, 0, 0));
        KickJB.setText("X");
        KickJB.setToolTipText("Banna l'utente");
        KickJB.setMaximumSize(new java.awt.Dimension(30, 35));
        KickJB.setMinimumSize(new java.awt.Dimension(30, 35));
        KickJB.setPreferredSize(new java.awt.Dimension(30, 35));
        KickJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KickJBActionPerformed(evt);
            }
        });
        add(KickJB);
    }// </editor-fold>//GEN-END:initComponents

    private void KickJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KickJBActionPerformed
        System.out.println("pulsante numero: " + userIndex);
        user.kickUser();
    }//GEN-LAST:event_KickJBActionPerformed

   
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KickJB;
    private javax.swing.JLabel ipJL;
    private javax.swing.JLabel lblReport;
    private javax.swing.JLabel nomeJL;
    // End of variables declaration//GEN-END:variables
}
