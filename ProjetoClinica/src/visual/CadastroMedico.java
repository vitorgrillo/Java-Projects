/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloConection.ConexaoBD;
import modeloDAO.DAOMedico;
import modeloBeans.BeansMedico;
import modeloBeans.ModeloTabela;



/**
 *
 * @author Fabio
 */
public class CadastroMedico extends javax.swing.JFrame {

    BeansMedico mod = new BeansMedico();
    DAOMedico control = new DAOMedico();
    ConexaoBD conex = new ConexaoBD();
    int flag = 0;

    public CadastroMedico() {
        initComponents();
        preencherTabela("select *from medicos order by nome_medico");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextFieldCRM = new javax.swing.JFormattedTextField();
        jTextFieldCadMedNome = new javax.swing.JTextField();
        jComboBoxCadMedProfissao = new javax.swing.JComboBox();
        jComboBoxCadMedEspecialidade = new javax.swing.JComboBox();
        jButtonCadMedIncluir = new javax.swing.JButton();
        jButtonCadMedExcluir = new javax.swing.JButton();
        jButtonCadMedAlterar = new javax.swing.JButton();
        jButtonCadMedSalvar = new javax.swing.JButton();
        jButtonCadMedCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCadMedPesquisa = new javax.swing.JTable();
        jLabelCadMedPesquisa = new javax.swing.JLabel();
        jButtonCadMedBuscar = new javax.swing.JButton();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jLabelCdMedID = new javax.swing.JLabel();
        jTextFieldCadMedID = new javax.swing.JTextField();
        jLabelCadMedicos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome");

        jLabel2.setText("CRM");

        jLabel3.setText("Profissão");

        jLabel4.setText("Especialidade");

        jFormattedTextFieldCRM.setEnabled(false);
        jFormattedTextFieldCRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldCRMActionPerformed(evt);
            }
        });

        jTextFieldCadMedNome.setEnabled(false);
        jTextFieldCadMedNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCadMedNomeActionPerformed(evt);
            }
        });

        jComboBoxCadMedProfissao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Médico", "Fisioterapeuta", "Fonoaudiólogo", "Psicólogo", "Terapeuta", "Dentista", "Nutricionista" }));
        jComboBoxCadMedProfissao.setEnabled(false);

        jComboBoxCadMedEspecialidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCadMedEspecialidade.setEnabled(false);
        jComboBoxCadMedEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCadMedEspecialidadeActionPerformed(evt);
            }
        });

        jButtonCadMedIncluir.setText("Novo");
        jButtonCadMedIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadMedIncluirActionPerformed(evt);
            }
        });

        jButtonCadMedExcluir.setText("Excluir");
        jButtonCadMedExcluir.setEnabled(false);
        jButtonCadMedExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadMedExcluirActionPerformed(evt);
            }
        });

        jButtonCadMedAlterar.setText("Alterar");
        jButtonCadMedAlterar.setEnabled(false);
        jButtonCadMedAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadMedAlterarActionPerformed(evt);
            }
        });

        jButtonCadMedSalvar.setText("Salvar");
        jButtonCadMedSalvar.setEnabled(false);
        jButtonCadMedSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadMedSalvarActionPerformed(evt);
            }
        });

        jButtonCadMedCancelar.setText("Cancelar");
        jButtonCadMedCancelar.setEnabled(false);
        jButtonCadMedCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadMedCancelarActionPerformed(evt);
            }
        });

        jTableCadMedPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableCadMedPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadMedPesquisaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCadMedPesquisa);

        jLabelCadMedPesquisa.setText("Pesquisa");

        jButtonCadMedBuscar.setText("Buscar");
        jButtonCadMedBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadMedBuscarActionPerformed(evt);
            }
        });

        jTextFieldPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisarActionPerformed(evt);
            }
        });

        jLabelCdMedID.setText("ID");

        jTextFieldCadMedID.setEnabled(false);
        jTextFieldCadMedID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCadMedIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCadMedExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadMedCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadMedAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadMedIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadMedSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelCadMedPesquisa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCadMedBuscar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCadMedProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCadMedEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCadMedNome, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldCRM, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelCdMedID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCadMedID, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCadMedID, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCadMedIncluir)
                        .addComponent(jLabelCdMedID)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCadMedSalvar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldCadMedNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jFormattedTextFieldCRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonCadMedExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCadMedAlterar)
                            .addComponent(jLabelCadMedPesquisa)
                            .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCadMedBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonCadMedCancelar)
                                .addGap(0, 210, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxCadMedProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBoxCadMedEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabelCadMedicos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCadMedicos.setText("Cadastro de Médicos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jLabelCadMedicos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCadMedicos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(667, 459));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCadMedNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCadMedNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCadMedNomeActionPerformed

    private void jComboBoxCadMedEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCadMedEspecialidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCadMedEspecialidadeActionPerformed

    private void jButtonCadMedIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadMedIncluirActionPerformed

        flag = 1;
        jButtonCadMedSalvar.setEnabled(true);
        jTextFieldCadMedNome.setEnabled(true);
        jFormattedTextFieldCRM.setEnabled(true);
        jComboBoxCadMedEspecialidade.setEnabled(true);
        jComboBoxCadMedProfissao.setEnabled(true);
        jButtonCadMedCancelar.setEnabled(true);
        jTextFieldCadMedID.setText("");
        jTextFieldCadMedNome.setText("");
        jFormattedTextFieldCRM.setText("");
        jTextFieldPesquisar.setText("");
        jButtonCadMedAlterar.setEnabled(false);
        jButtonCadMedExcluir.setEnabled(false);
        jTextFieldPesquisar.setEnabled(false);
        jButtonCadMedBuscar.setEnabled(false);
    }//GEN-LAST:event_jButtonCadMedIncluirActionPerformed

    private void jButtonCadMedSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadMedSalvarActionPerformed

        if(jTextFieldCadMedNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o nome do médico");
            jTextFieldCadMedNome.requestFocus();
        }else if(jFormattedTextFieldCRM.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Preencha o CRM do médico"); 
           jFormattedTextFieldCRM.requestFocus();
        }else
        
        if (flag == 1) {
            mod.setNome(jTextFieldCadMedNome.getText());
            mod.setCrm(Integer.parseInt(jFormattedTextFieldCRM.getText()));
            mod.setProfissao((String) jComboBoxCadMedProfissao.getSelectedItem());
            mod.setEspecialidade((String) jComboBoxCadMedEspecialidade.getSelectedItem());
            control.Salvar(mod);
            jTextFieldCadMedNome.setText("");
            jFormattedTextFieldCRM.setText("");
            jTextFieldCadMedNome.setEnabled(false);
            jFormattedTextFieldCRM.setEnabled(false);
            jComboBoxCadMedEspecialidade.setEnabled(false);
            jComboBoxCadMedProfissao.setEnabled(false);
            jButtonCadMedSalvar.setEnabled(false);
            preencherTabela("select *from medicos order by nome_medico");
        } else {
            mod.setCodigo((Integer.parseInt(jTextFieldCadMedID.getText())));
            mod.setNome(jTextFieldCadMedNome.getText());
            mod.setCrm(Integer.parseInt(jFormattedTextFieldCRM.getText()));
            mod.setProfissao((String) jComboBoxCadMedProfissao.getSelectedItem());
            mod.setEspecialidade((String) jComboBoxCadMedEspecialidade.getSelectedItem());
            control.Editar(mod);
            jTextFieldCadMedID.setText("");
            jTextFieldCadMedNome.setText("");
            jFormattedTextFieldCRM.setText("");
            jTextFieldPesquisar.setText("");
            jTextFieldCadMedNome.setEnabled(false);
            jFormattedTextFieldCRM.setEnabled(false);
            jComboBoxCadMedEspecialidade.setEnabled(false);
            jComboBoxCadMedProfissao.setEnabled(false);
            jButtonCadMedSalvar.setEnabled(false);
            jButtonCadMedIncluir.setEnabled(true);
            jButtonCadMedCancelar.setEnabled(false);
            preencherTabela("select *from medicos order by nome_medico");
        }

    }//GEN-LAST:event_jButtonCadMedSalvarActionPerformed

    private void jButtonCadMedBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadMedBuscarActionPerformed
        mod.setPesquisa(jTextFieldPesquisar.getText());
        BeansMedico model = control.buscaMedico(mod);
        jTextFieldCadMedID.setText(String.valueOf(model.getCodigo()));
        jTextFieldCadMedNome.setText(model.getNome());
        jFormattedTextFieldCRM.setText(String.valueOf(model.getCrm()));
        jComboBoxCadMedProfissao.setSelectedItem(model.getProfissao());
        jComboBoxCadMedEspecialidade.setSelectedItem(model.getEspecialidade());
        preencherTabela("select * from medicos where nome_medico like '%"+mod.getPesquisa()+"%'");
        
        /*jTextFieldCadMedID.setText("");
        jTextFieldCadMedNome.setText("");
        jFormattedTextFieldCRM.setText("");
        jTextFieldPesquisar.setText("");*/
    }//GEN-LAST:event_jButtonCadMedBuscarActionPerformed

    private void jButtonCadMedCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadMedCancelarActionPerformed
        jButtonCadMedSalvar.setEnabled(!true);
        jTextFieldCadMedNome.setEnabled(!true);
        jFormattedTextFieldCRM.setEnabled(!true);
        jComboBoxCadMedEspecialidade.setEnabled(!true);
        jComboBoxCadMedProfissao.setEnabled(!true);
        jButtonCadMedCancelar.setEnabled(!true);
        jButtonCadMedIncluir.setEnabled(true);
        jButtonCadMedExcluir.setEnabled(false);
        jButtonCadMedAlterar.setEnabled(false);
        jTextFieldCadMedID.setText("");
        jTextFieldCadMedNome.setText("");
        jFormattedTextFieldCRM.setText("");
        jTextFieldPesquisar.setText("");
        jTextFieldPesquisar.setEnabled(true);
        jButtonCadMedBuscar.setEnabled(true);
    }//GEN-LAST:event_jButtonCadMedCancelarActionPerformed

    private void jButtonCadMedAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadMedAlterarActionPerformed
        flag = 2;
        jButtonCadMedSalvar.setEnabled(true);
        jTextFieldCadMedNome.setEnabled(true);
        jFormattedTextFieldCRM.setEnabled(true);
        jComboBoxCadMedEspecialidade.setEnabled(true);
        jComboBoxCadMedProfissao.setEnabled(true);
        jButtonCadMedCancelar.setEnabled(true);
        jButtonCadMedAlterar.setEnabled(false);
        jButtonCadMedIncluir.setEnabled(false);
        jButtonCadMedExcluir.setEnabled(false);
    }//GEN-LAST:event_jButtonCadMedAlterarActionPerformed

    private void jTextFieldPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisarActionPerformed

    private void jFormattedTextFieldCRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldCRMActionPerformed

    private void jTextFieldCadMedIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCadMedIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCadMedIDActionPerformed

    private void jTableCadMedPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadMedPesquisaMouseClicked
    String nome_medico =""+ jTableCadMedPesquisa.getValueAt(jTableCadMedPesquisa.getSelectedRow(), 1);
    conex.conexao();
    conex.executaSql("select *from medicos where nome_medico = '"+nome_medico+"'");
        try {
            conex.rs.first();
            
            jTextFieldCadMedID.setText(String.valueOf(conex.rs.getInt("cod_medico")));
            jTextFieldCadMedNome.setText(conex.rs.getString("nome_medico"));
            jFormattedTextFieldCRM.setText(conex.rs.getString("crm_medico"));
            jComboBoxCadMedProfissao.setSelectedItem(conex.rs.getString("profissao_medico"));
            jComboBoxCadMedProfissao.setSelectedItem(conex.rs.getString("especialidade_medico"));
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar os dados");
        }
    
    conex.desconectar();
    jButtonCadMedAlterar.setEnabled(true);
    jButtonCadMedExcluir.setEnabled(true);
    
    }//GEN-LAST:event_jTableCadMedPesquisaMouseClicked

    private void jButtonCadMedExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadMedExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCadMedExcluirActionPerformed

    public void preencherTabela(String Sql) {
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"ID", "Nome", "CRM", "Profissao", "Especialidade"};
        conex.conexao();
        conex.executaSql(Sql);

        try {
            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getInt("cod_medico"), conex.rs.getString("nome_medico"), conex.rs.getInt("crm_medico"), conex.rs.getString("profissao_medico"), conex.rs.getString("especialidade_medico")});
            } while (conex.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Médico não encontrado");
        }

        ModeloTabela modelo = new ModeloTabela(dados, colunas);

        jTableCadMedPesquisa.setModel(modelo);
        jTableCadMedPesquisa.getColumnModel().getColumn(0).setPreferredWidth(43);
        jTableCadMedPesquisa.getColumnModel().getColumn(0).setResizable(false);
        jTableCadMedPesquisa.getColumnModel().getColumn(1).setPreferredWidth(190);
        jTableCadMedPesquisa.getColumnModel().getColumn(1).setResizable(false);
        jTableCadMedPesquisa.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTableCadMedPesquisa.getColumnModel().getColumn(2).setResizable(false);
        jTableCadMedPesquisa.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTableCadMedPesquisa.getColumnModel().getColumn(3).setResizable(false);
        jTableCadMedPesquisa.getColumnModel().getColumn(4).setPreferredWidth(130);
        jTableCadMedPesquisa.getColumnModel().getColumn(4).setResizable(false);
        jTableCadMedPesquisa.getTableHeader().setReorderingAllowed(false);
        jTableCadMedPesquisa.setAutoResizeMode(jTableCadMedPesquisa.AUTO_RESIZE_OFF);
        jTableCadMedPesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conex.desconectar();

    }

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
            java.util.logging.Logger.getLogger(CadastroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadMedAlterar;
    private javax.swing.JButton jButtonCadMedBuscar;
    private javax.swing.JButton jButtonCadMedCancelar;
    private javax.swing.JButton jButtonCadMedExcluir;
    private javax.swing.JButton jButtonCadMedIncluir;
    private javax.swing.JButton jButtonCadMedSalvar;
    private javax.swing.JComboBox jComboBoxCadMedEspecialidade;
    private javax.swing.JComboBox jComboBoxCadMedProfissao;
    private javax.swing.JFormattedTextField jFormattedTextFieldCRM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCadMedPesquisa;
    private javax.swing.JLabel jLabelCadMedicos;
    private javax.swing.JLabel jLabelCdMedID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCadMedPesquisa;
    private javax.swing.JTextField jTextFieldCadMedID;
    private javax.swing.JTextField jTextFieldCadMedNome;
    private javax.swing.JTextField jTextFieldPesquisar;
    // End of variables declaration//GEN-END:variables
}
