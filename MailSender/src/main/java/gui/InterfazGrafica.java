
package gui;

import javax.swing.JOptionPane;
import subsistema.ConectorMailSender;
import subsistema.SubsistemaMailSender;

/**
 *
 * @author Ryzen 5
 */
public class InterfazGrafica extends javax.swing.JFrame {

    public Usuario usuario;
    public boolean listo;
    SubsistemaMailSender mailSender=new ConectorMailSender();
    
    public InterfazGrafica(Usuario usuario) {
        initComponents();
        this.usuario=usuario;
        this.txjEmisor.setText(usuario.getUsername());
        jLabel6.setVisible(false);
    }
    
    public void enviar(){
        if(!listo){
             JOptionPane.showMessageDialog(this, "Seleccione un metodo de envio", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        String protocol="";
        String server="";
        String host="";
        String encryption="";
        String password;
        int port=-1;
        
        if (this.rdSendgrid.isSelected()){
            protocol="Sengrid";
            password=usuario.SengridPassword;
        }else{
            
            protocol="SMTP";
            
            if (this.rdJava.isSelected()){
                server="java.mail.Api";
            }else{
                server="Apache.Commnos.Mail";
            }

            if (this.rdGmail.isSelected()) {
                host = "smtp.gmail.com";
                password = usuario.GmailPassword;

                if (this.rdSSL.isSelected()) {
                    encryption = "mail.smtp.ssl.enable";
                    port = 465;
                } else {
                    encryption = "mail.smtp.starttls.enable";
                    port = 587;
                }
            } else {
                host = "smtp.office365.com";
                password = usuario.OutlookPassword;
                encryption = "mail.smtp.starttls.enable";
                port = 587;
            }

        }
        
        JOptionPane.showMessageDialog(this, "Enviando mensaje, por favor espere", "Esperando", JOptionPane.INFORMATION_MESSAGE);
        
        if(mailSender.enviarCorreo(this.txjEmisor.getText(), this.txjDestinatario.getText(), this.txjAsunto.getText(),
                this.txjMensaje.getText(), protocol, server, host, encryption, password, port)){
            JOptionPane.showMessageDialog(this, "Correo enviado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "No se pudo enviar el correo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txjEmisor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txjDestinatario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txjMensaje = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        txjAsunto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        rdSMTP = new javax.swing.JRadioButton();
        rdSendgrid = new javax.swing.JRadioButton();
        rdJava = new javax.swing.JRadioButton();
        rdApache = new javax.swing.JRadioButton();
        rdGmail = new javax.swing.JRadioButton();
        rdOutlook = new javax.swing.JRadioButton();
        rdSSL = new javax.swing.JRadioButton();
        rdStar = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(38, 61, 105));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 500));

        txjEmisor.setEditable(false);
        txjEmisor.setBackground(new java.awt.Color(204, 204, 204));
        txjEmisor.setText("pruebapatrones@gmail.com");
        txjEmisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txjEmisorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Emisor");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Destinatario");

        txjDestinatario.setText("pruebapatrones@gmail.com");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mensaje");

        txjMensaje.setColumns(20);
        txjMensaje.setRows(5);
        txjMensaje.setText("Hola mundo");
        jScrollPane1.setViewportView(txjMensaje);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        txjAsunto.setText("Probando");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Asunto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txjEmisor, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                            .addComponent(txjDestinatario)
                            .addComponent(txjAsunto)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnviar)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txjEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txjDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txjAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnviar)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 500));

        jLabel4.setText("Configuracion:");

        buttonGroup1.add(rdSMTP);
        rdSMTP.setText("SMTP");
        rdSMTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSMTPActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdSendgrid);
        rdSendgrid.setText("SendGrid");
        rdSendgrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSendgridActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdJava);
        rdJava.setText("Java");
        rdJava.setEnabled(false);
        rdJava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdJavaActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdApache);
        rdApache.setText("Apache");
        rdApache.setEnabled(false);
        rdApache.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdApacheActionPerformed(evt);
            }
        });

        buttonGroup3.add(rdGmail);
        rdGmail.setText("Gmail");
        rdGmail.setEnabled(false);
        rdGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdGmailActionPerformed(evt);
            }
        });

        buttonGroup3.add(rdOutlook);
        rdOutlook.setText("Outlook");
        rdOutlook.setEnabled(false);
        rdOutlook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdOutlookActionPerformed(evt);
            }
        });

        buttonGroup4.add(rdSSL);
        rdSSL.setText("SSL/TLS");
        rdSSL.setEnabled(false);
        rdSSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSSLActionPerformed(evt);
            }
        });

        buttonGroup4.add(rdStar);
        rdStar.setText("StartTLS");
        rdStar.setEnabled(false);
        rdStar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdStarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 255, 153));
        jLabel6.setText("Configuracion Seleccionada");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 208, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(rdSSL)
                        .addGap(38, 38, 38)
                        .addComponent(rdStar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(rdGmail)
                        .addGap(52, 52, 52)
                        .addComponent(rdOutlook))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(rdJava)
                        .addGap(59, 59, 59)
                        .addComponent(rdApache))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(rdSMTP)
                        .addGap(54, 54, 54)
                        .addComponent(rdSendgrid)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdSMTP)
                    .addComponent(rdSendgrid))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdJava)
                    .addComponent(rdApache))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdGmail)
                    .addComponent(rdOutlook))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdStar)
                    .addComponent(rdSSL, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txjEmisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txjEmisorActionPerformed

    }//GEN-LAST:event_txjEmisorActionPerformed

    private void rdGmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdGmailActionPerformed

        if(rdGmail.isSelected())
            {
                rdSSL.setEnabled(true);
                rdStar.setEnabled(true);
            }
    }//GEN-LAST:event_rdGmailActionPerformed

    private void rdSMTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSMTPActionPerformed

            if(rdSMTP.isSelected())
            {
                jLabel6.setVisible(false);
                rdJava.setEnabled(true);
                rdApache.setEnabled(true);
            }
    }//GEN-LAST:event_rdSMTPActionPerformed

    private void rdJavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdJavaActionPerformed
 
        if(rdJava.isSelected())
            {
                rdGmail.setEnabled(true);
                rdOutlook.setEnabled(true);
            }
    }//GEN-LAST:event_rdJavaActionPerformed

    private void rdSendgridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSendgridActionPerformed
  
        if(rdSendgrid.isSelected())
            {
                buttonGroup2.clearSelection();
                buttonGroup3.clearSelection();
                buttonGroup4.clearSelection();
                rdJava.setEnabled(false);
                rdApache.setEnabled(false);
                rdGmail.setEnabled(false);
                rdOutlook.setEnabled(false);
                rdSSL.setEnabled(false);
                rdStar.setEnabled(false);
                
                jLabel6.setVisible(true);
                listo=true;
            }
    }//GEN-LAST:event_rdSendgridActionPerformed

    private void rdApacheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdApacheActionPerformed

        if(rdApache.isSelected())
            {
                rdGmail.setEnabled(true);
                rdOutlook.setEnabled(true);
            }
    }//GEN-LAST:event_rdApacheActionPerformed

    private void rdOutlookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdOutlookActionPerformed

        if(rdOutlook.isSelected())
        {
            rdSSL.setEnabled(true);
            rdStar.setEnabled(true);
        }
    }//GEN-LAST:event_rdOutlookActionPerformed

    private void rdSSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSSLActionPerformed
        jLabel6.setVisible(true);
        listo=true;
    }//GEN-LAST:event_rdSSLActionPerformed

    private void rdStarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdStarActionPerformed

        jLabel6.setVisible(true);
        listo=true;
    }//GEN-LAST:event_rdStarActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        enviar();
    }//GEN-LAST:event_btnEnviarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JRadioButton rdApache;
    private javax.swing.JRadioButton rdGmail;
    private javax.swing.JRadioButton rdJava;
    private javax.swing.JRadioButton rdOutlook;
    private javax.swing.JRadioButton rdSMTP;
    private javax.swing.JRadioButton rdSSL;
    private javax.swing.JRadioButton rdSendgrid;
    private javax.swing.JRadioButton rdStar;
    private javax.swing.JTextField txjAsunto;
    private javax.swing.JTextField txjDestinatario;
    private javax.swing.JTextField txjEmisor;
    private javax.swing.JTextArea txjMensaje;
    // End of variables declaration//GEN-END:variables
}
