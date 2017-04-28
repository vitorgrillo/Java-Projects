/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.LoginControle;
import Modelo.Login;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author VitorEmanuel
 */ 
public class Inicial extends javax.swing.JFrame {

    /**
     * Creates new form Inicial
     */
    public Inicial() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        b_login = new javax.swing.JButton();
        b_limpar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        b_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Vani", 1, 24)); // NOI18N
        jLabel1.setText("Login:");

        jLabel2.setFont(new java.awt.Font("Vani", 1, 24)); // NOI18N
        jLabel2.setText("Senha:");

        b_login.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        b_login.setText("Logar");
        b_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_loginActionPerformed(evt);
            }
        });

        b_limpar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        b_limpar.setText("Limpar");
        b_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_limparActionPerformed(evt);
            }
        });

        b_sair.setText("Sair");
        b_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(92, 92, 92)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(b_login)
                            .addGap(18, 18, 18)
                            .addComponent(b_limpar))))
                .addGap(0, 102, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_sair)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_login)
                    .addComponent(b_limpar))
                .addGap(18, 18, 18)
                .addComponent(b_sair)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_limparActionPerformed
        // TODO add your handling code here:
        txtLogin.setText("");
        txtSenha.setText("");
    }//GEN-LAST:event_b_limparActionPerformed

    private void b_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_loginActionPerformed
        // TODO add your handling code here:
        String login = txtLogin.getText();
        String senha = txtSenha.getText();
        try{
            LoginControle lc = new LoginControle();
            ArrayList<Login> LC = lc.buscarLoginSenha();
            for(Login l:LC){
                if(l.getLogin().equalsIgnoreCase(login) && l.getSenha().equalsIgnoreCase(senha)){
                    this.dispose();
                    Sistema s = new Sistema();
                    s.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Usuario ou senha inválidos","Erro",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"O seguinte erro ocorrreu: " + e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_b_loginActionPerformed

    private void b_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_sairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_b_sairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_limpar;
    private javax.swing.JButton b_login;
    private javax.swing.JButton b_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
