/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DataAccesObject.BancoDAO;
import Models.Banco;
//import Views.JFrameExcluirBanco;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author berna
 */
public class JFrameBuscarBanco extends javax.swing.JFrame {

    /**
     * Creates new form JFrameBuscarBanco
     */
    public JFrameBuscarBanco() {
        initComponents();
        listarBancosTodos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonExcluir = new javax.swing.JButton();
        jTxtBanco = new javax.swing.JTextField();
        jButtonSair = new javax.swing.JButton();
        jLabelBanco = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBanco = new javax.swing.JTable();
        jButtonAlterar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jTxtBanco.setText("pesquisar pela razao social");
        jTxtBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtBancoActionPerformed(evt);
            }
        });
        jTxtBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtBancoKeyPressed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabelBanco.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelBanco.setText("Dados do Banco");

        jTableBanco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Razão Social", "Cnpj", "Endereço", "Numero", "Bairro", "Cidade", "Estado", "Telefone "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableBanco);

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTxtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelBanco)
                .addGap(287, 287, 287))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabelBanco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTxtBanco, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonExcluir)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        
        if (jTableBanco.getSelectedRow() >= 0) {
        int codigo = (int) jTableBanco.getValueAt(jTableBanco.getSelectedRow(), 0);
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "ALERTA", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            BancoDAO banco = new BancoDAO();
            banco.excluirBanco(codigo);
            JOptionPane.showMessageDialog(null, "Banco excluído com sucesso");
        } else if (resposta == JOptionPane.NO_OPTION) {
        } 
        }else {
            JOptionPane.showMessageDialog(null, "Selecione um banco e tente novamente");
        }//Usuário clicou em não. Executar o código correspondente.
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTxtBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtBancoActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jTxtBancoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtBancoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtBancoKeyPressed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        //table = (JTable)JTable.getModel();  
        //table.setNumRows(0);
        try {
            BancoDAO banco = new BancoDAO();
            ArrayList<Banco> bancos = banco.listarBanco(jTxtBanco.getText());
            DefaultTableModel limpar = (DefaultTableModel) jTableBanco.getModel();
            limpar.setNumRows(0);
            for (Banco b : bancos) {
                DefaultTableModel model = (DefaultTableModel) jTableBanco.getModel();
                Object linha[] = new Object[]{b.getCodigo(), b.getRazaoSocial(), b.getCnpj(), b.getEndereco(), b.getNumero(), b.getBairro(), b.getCidade(), b.getEstado(), b.getTelefone()};
                model.addRow(linha);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir bancos.");
        }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        
          if (jTableBanco.getSelectedRow() >= 0) {
        int codigo = (int) jTableBanco.getValueAt(jTableBanco.getSelectedRow(), 0);
        
        //jTableBanco.getSelectedRow();
        //JOptionPane.showConfirmDialog(null, codigo);
        Banco b = new Banco();
        BancoDAO banco = new BancoDAO();
        JFrameAlterarBanco alterarBanco1 = new JFrameAlterarBanco(banco.bancoBuscarBanco(codigo));
        alterarBanco1.show();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um banco e tente novamente");
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void listarBancosTodos() {
        try {
            BancoDAO banco = new BancoDAO();
            ArrayList<Banco> bancos = banco.listarBancoTodos();
            DefaultTableModel limpar = (DefaultTableModel) jTableBanco.getModel();
            limpar.setNumRows(0);
            for (Banco b : bancos) {
                DefaultTableModel model = (DefaultTableModel) jTableBanco.getModel();
                Object linha[] = new Object[]{b.getCodigo(), b.getRazaoSocial(), b.getCnpj(), b.getEndereco(), b.getNumero(), b.getBairro(), b.getCidade(), b.getEstado(), b.getTelefone()};
                model.addRow(linha);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir bancos.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelBanco;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBanco;
    private javax.swing.JTextField jTxtBanco;
    // End of variables declaration//GEN-END:variables
}