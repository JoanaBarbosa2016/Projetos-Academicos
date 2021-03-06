/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DataAccesObject.LoginDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class JFrameLogin extends javax.swing.JFrame
{

    /**
     * Creates new form JFrameLogin
     */
    public JFrameLogin()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContainer = new javax.swing.JPanel();
        jLabelSistemaCorretor = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jButtonLogar = new javax.swing.JButton();
        jPasswordFieldSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        jPanelContainer.setBackground(new java.awt.Color(0, 102, 102));
        jPanelContainer.setForeground(new java.awt.Color(0, 102, 102));

        jLabelSistemaCorretor.setFont(new java.awt.Font("Meiryo UI", 1, 36)); // NOI18N
        jLabelSistemaCorretor.setText("SISTEMA IMOBILIÁRIO");

        jTextFieldLogin.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTextFieldLogin.setForeground(new java.awt.Color(36, 53, 79));
        jTextFieldLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldLogin.setText("USUÁRIO");
        jTextFieldLogin.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextFieldLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldLoginMouseClicked(evt);
            }
        });
        jTextFieldLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLoginActionPerformed(evt);
            }
        });

        jButtonLogar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonLogar.setText("Login");
        jButtonLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogarActionPerformed(evt);
            }
        });

        jPasswordFieldSenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPasswordFieldSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordFieldSenha.setText("jPasswordField1");
        jPasswordFieldSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordFieldSenhaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelContainerLayout = new javax.swing.GroupLayout(jPanelContainer);
        jPanelContainer.setLayout(jPanelContainerLayout);
        jPanelContainerLayout.setHorizontalGroup(
            jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContainerLayout.createSequentialGroup()
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContainerLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabelSistemaCorretor))
                    .addGroup(jPanelContainerLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelContainerLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jButtonLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanelContainerLayout.setVerticalGroup(
            jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContainerLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabelSistemaCorretor, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButtonLogar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextFieldLoginActionPerformed
    {//GEN-HEADEREND:event_jTextFieldLoginActionPerformed

    }//GEN-LAST:event_jTextFieldLoginActionPerformed

    private void jButtonLogarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonLogarActionPerformed
    {//GEN-HEADEREND:event_jButtonLogarActionPerformed
      LoginDAO logar = new LoginDAO();
        
       if(logar.login(jTextFieldLogin.getText(),jPasswordFieldSenha.getText()))
       {
          JFrameMenu menu = new JFrameMenu(logar.getCPFUsuarioLogado(), logar.getTipoUsuarioLogado());
          menu.show();
          this.dispose();
       }
       else
       {
           JOptionPane.showMessageDialog(null, "LOGIN OU SENHA INCORRETO(s)", "Erro no login", JOptionPane.ERROR_MESSAGE);
           jTextFieldLogin.setText("");
           jPasswordFieldSenha.setText("");
           
       }
    }//GEN-LAST:event_jButtonLogarActionPerformed

    private void jTextFieldLoginMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTextFieldLoginMouseClicked
    {//GEN-HEADEREND:event_jTextFieldLoginMouseClicked
        jTextFieldLogin.setText("");
    }//GEN-LAST:event_jTextFieldLoginMouseClicked

    private void jPasswordFieldSenhaMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jPasswordFieldSenhaMouseClicked
    {//GEN-HEADEREND:event_jPasswordFieldSenhaMouseClicked
        jPasswordFieldSenha.setText("");
    }//GEN-LAST:event_jPasswordFieldSenhaMouseClicked

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogar;
    private javax.swing.JLabel jLabelSistemaCorretor;
    private javax.swing.JPanel jPanelContainer;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldLogin;
    // End of variables declaration//GEN-END:variables
}
