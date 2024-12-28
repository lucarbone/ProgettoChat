package serverChat;

public class Starter extends javax.swing.JFrame {

    ControllerServer C;
    public Starter() {
        initComponents();
    }
    
    private void play(String ip, int port){
        C = new ControllerServer(ip, port);
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
        setTitle("Server");
        setSize(new java.awt.Dimension(330, 500));

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Easy SMS Server");

        jLabel2.setBackground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("IP:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        txtIp.setBackground(new java.awt.Color(204, 255, 204));
        txtIp.setToolTipText("");
        txtIp.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(153, 153, 255));
        jLabel3.setText("Porta:");
        jLabel3.setFocusable(false);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        txtPorta.setBackground(new java.awt.Color(204, 255, 204));
        txtPorta.setText("8080");
        txtPorta.setCaretColor(new java.awt.Color(255, 255, 255));

        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jToggleButton1.setText("LANCIA SERVER");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setToolTipText("");
        lblError.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(141, 141, 141)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addGap(34, 34, 34))
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
        
        // Verifichiuamo che l'utente abbia inserito dei valori 
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
                    play(ip, port);
                }
                catch(Exception e){
                    lblError.setText("Inserisci una porta valida!!");
                }
            }
        }
        
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextField txtIp;
    private javax.swing.JTextField txtPorta;
    // End of variables declaration//GEN-END:variables
}
