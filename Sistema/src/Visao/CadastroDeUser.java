/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.UserControle;
import Modelo.User;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor Grillo
 */
public class CadastroDeUser extends javax.swing.JFrame {

    /**
     * Creates new form CadastroDeUser2
     */
    public CadastroDeUser() {
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtEndereco = new javax.swing.JTextField();
        L_Endereco = new javax.swing.JLabel();
        L_Telefone = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtsexo = new javax.swing.JComboBox();
        L_Nome = new javax.swing.JLabel();
        b_limpar = new javax.swing.JButton();
        txtCpf = new javax.swing.JTextField();
        b_cadastro = new javax.swing.JButton();
        L_Cpf = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        L_Email = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        L_Sexo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        Sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro de Usuário");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar Novo Usuário"));

        L_Endereco.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        L_Endereco.setText("ENDEREÇO:");

        L_Telefone.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        L_Telefone.setText("TELEFONE:");

        txtsexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

        L_Nome.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        L_Nome.setText("NOME:");

        b_limpar.setText("Limpar");
        b_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_limparActionPerformed(evt);
            }
        });

        b_cadastro.setText("Cadastrar");
        b_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cadastroActionPerformed(evt);
            }
        });

        L_Cpf.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        L_Cpf.setText("CPF:");

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        L_Email.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        L_Email.setText("EMAIL:");

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        L_Sexo.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        L_Sexo.setText("SEXO:");

        jLabel2.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        jLabel2.setText("VALOR:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(b_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(L_Telefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelefone))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(L_Endereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndereco))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(L_Email)
                                    .addComponent(L_Sexo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtEmail)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(L_Cpf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCpf))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(L_Nome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Nome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Cpf)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Email)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Sexo)
                    .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Telefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Endereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cadastro)
                    .addComponent(b_limpar))
                .addContainerGap())
        );

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Sair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_limparActionPerformed
        // TODO add your handling code here:
        txtNome.setText("");
        txtCpf.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");
    }//GEN-LAST:event_b_limparActionPerformed

    private void b_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cadastroActionPerformed
        // TODO add your handling code here:
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String email = txtEmail.getText();
        String sexo = (String) txtsexo.getSelectedItem();
        String telefone = txtTelefone.getText();
        String endereco = txtEndereco.getText();
        float valor = (float) Double.parseDouble(txtValor.getText());

        if(nome.isEmpty()){
            JOptionPane.showMessageDialog(null,"Campo nome está vázio", "Erro de validação",JOptionPane.ERROR_MESSAGE);
        }
        if(cpf.isEmpty()){
            JOptionPane.showMessageDialog(null,"Campo cpf está vázio", "Erro de validação",JOptionPane.ERROR_MESSAGE);
        }
        else{
               
        }
        
        if(email.isEmpty()){
            JOptionPane.showMessageDialog(null,"Campo email está vázio", "Erro de validação",JOptionPane.ERROR_MESSAGE);
        }
      
        else if ((txtEmail.getText().contains("@")) && 
            (txtEmail.getText().contains(".")) && 
            (!txtEmail.getText().contains(" "))) {

            String usuario = new String(txtEmail.getText().substring(0, 
                                        txtEmail.getText().lastIndexOf('@')));

           String dominio = new String(txtEmail.getText().substring(txtEmail.getText().lastIndexOf
                             ('@') + 1, txtEmail.getText().length()));
         
        if ((usuario.length() >=1) && (!usuario.contains("@")) && 
                (dominio.contains(".")) && (!dominio.contains("@")) && (dominio.indexOf(".") >= 
                1) && (dominio.lastIndexOf(".") < dominio.length() - 1)) {
            }    
        else{
               JOptionPane.showMessageDialog(null,"Campo email Inválido!","Erro de validação",JOptionPane.ERROR_MESSAGE);
                txtEmail.requestFocus();
            }
        }     
                   
        if(telefone.isEmpty()){
            JOptionPane.showMessageDialog(null,"Campo telefone está vázio", "Erro de validação",JOptionPane.ERROR_MESSAGE);
        }
        if(endereco.isEmpty()){
            JOptionPane.showMessageDialog(null,"Campo endereco está vázio", "Erro de validação",JOptionPane.ERROR_MESSAGE);
        }
        if(txtValor == null){
            JOptionPane.showMessageDialog(null,"Campo valor está vázio", "Erro de validação",JOptionPane.ERROR_MESSAGE);
        }
        else{
            User U = new User();
            U.setNome(nome);
            U.setCpf(cpf);
            U.setEmail(email);
            U.setSexo(sexo);
            U.setTelefone(telefone);
            U.setEndereco(endereco);
            U.setValor(valor);

            try{
                UserControle uc = new UserControle();
                uc.cadastrarUser(U);
            }catch(SQLException se){
                JOptionPane.showMessageDialog(null,"O Seguinte erro ocorreu: "+ se.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
            }catch(Exception ex){ 
                JOptionPane.showMessageDialog(null,"O Seguinte erro ocorreu: "+ ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_b_cadastroActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        new Sistema().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_SairActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtEmailFocusLost

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
            java.util.logging.Logger.getLogger(CadastroDeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroDeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroDeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroDeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroDeUser().setVisible(true);
            }
        });
    }
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L_Cpf;
    private javax.swing.JLabel L_Email;
    private javax.swing.JLabel L_Endereco;
    private javax.swing.JLabel L_Nome;
    private javax.swing.JLabel L_Sexo;
    private javax.swing.JLabel L_Telefone;
    private javax.swing.JButton Sair;
    private javax.swing.JButton b_cadastro;
    private javax.swing.JButton b_limpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtValor;
    private javax.swing.JComboBox txtsexo;
    // End of variables declaration//GEN-END:variables
}
