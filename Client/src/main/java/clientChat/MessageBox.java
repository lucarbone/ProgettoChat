package clientChat;

import javax.swing.JLabel;


public class MessageBox extends javax.swing.JPanel {
    private JLabel messageLabel;
    private String message;
    private String user;
    private String time;

    public MessageBox(String user, String message, String time) {
        this.message = message;
        this.user = user;
        this.time = time;
        initComponents();
        lblNome.setText(user);
        txtMessage.setText(message);
        lblData.setText(time);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtTesto = new javax.swing.JTextArea();
        lblNome = new javax.swing.JLabel();
        lblTesto = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextPane();

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtTesto.setColumns(20);
        txtTesto.setRows(5);
        jScrollPane1.setViewportView(txtTesto);

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblNome.setText("Nome");

        lblData.setText("data");

        txtMessage.setEditable(false);
        txtMessage.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        txtMessage.setMaximumSize(new java.awt.Dimension(100, 300));
        txtMessage.setMinimumSize(new java.awt.Dimension(50, 10));
        jScrollPane2.setViewportView(txtMessage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTesto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblData))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTesto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblData)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTesto;
    private javax.swing.JTextPane txtMessage;
    private javax.swing.JTextArea txtTesto;
    // End of variables declaration//GEN-END:variables
}
