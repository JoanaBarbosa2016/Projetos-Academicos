/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DataAccesObject.CorretorDAO;
import Models.Corretor;
//import Views.JFrameExcluirBanco;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author berna
 */
public class JFrameBuscarCorretor extends javax.swing.JFrame {

    /**
     * Creates new form JFrameBuscarBanco
     */
    public JFrameBuscarCorretor() {
        initComponents();
        listarCorretorTodos();
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
        jTxtCorretor = new javax.swing.JTextField();
        jButtonSair = new javax.swing.JButton();
        jLabelBanco = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCorretor = new javax.swing.JTable();
        jButtonAlterar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jTxtCorretor.setText("pesquisar pelo nome");
        jTxtCorretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCorretorActionPerformed(evt);
            }
        });
        jTxtCorretor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtCorretorKeyPressed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabelBanco.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelBanco.setText("Dados do Corretor");

        jTableCorretor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "CPF", "Usuário", "Senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableCorretor);

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
                        .addComponent(jTxtCorretor, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(34, 34, 34)
                .addComponent(jLabelBanco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTxtCorretor, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
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
        int codigo = (int) jTableCorretor.getValueAt(jTableCorretor.getSelectedRow(), 0);
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "ALERTA", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            CorretorDAO corretor = new CorretorDAO();
            corretor.excluirCorretor(codigo);
            JOptionPane.showMessageDialog(null, "Corretor excluído com sucesso");
        } else if (resposta == JOptionPane.NO_OPTION) {
            //Usuário clicou em não. Executar o código correspondente.
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTxtCorretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCorretorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCorretorActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jTxtCorretorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtCorretorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCorretorKeyPressed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        //table = (JTable)JTable.getModel();  
        //table.setNumRows(0);
        try {
            CorretorDAO corretor = new CorretorDAO();
            ArrayList<Corretor> corretores = corretor.listarCorretor(jTxtCorretor.getText());
            DefaultTableModel limpar = (DefaultTableModel) jTableCorretor.getModel();
            limpar.setNumRows(0);
            for (Corretor c : corretores) {
                DefaultTableModel model = (DefaultTableModel) jTableCorretor.getModel();
                Object linha[] = new Object[]{c.getCodigo(), c.getNome(), c.getCpf(), c.getUsuario(), c.getSenha()};
                model.addRow(linha);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir bancos.");
        }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        int codigo = (int) jTableCorretor.getValueAt(jTableCorretor.getSelectedRow(), 0);
        
        //jTableBanco.getSelectedRow();
        //JOptionPane.showConfirmDialog(null, codigo);
        Corretor c = new Corretor();
        CorretorDAO corretor = new CorretorDAO();
        JFrameAlterarCorretor alterarCorretor = new JFrameAlterarCorretor(corretor.corretorBuscarCorretor(codigo));
        alterarCorretor.show();
        
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void listarCorretorTodos() {
        try {
            CorretorDAO corretor = new CorretorDAO();
            ArrayList<Corretor> corretores = corretor.listarCorretorTodos();
            DefaultTableModel limpar = (DefaultTableModel) jTableCorretor.getModel();
            limpar.setNumRows(0);
            for (Corretor c : corretores) {
                DefaultTableModel model = (DefaultTableModel) jTableCorretor.getModel();
                Object linha[] = new Object[]{c.getCodigo(), c.getNome(), c.getCpf(), c.getUsuario(), c.getSenha()};
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
    private javax.swing.JTable jTableCorretor;
    private javax.swing.JTextField jTxtCorretor;
    // End of variables declaration//GEN-END:variables
}