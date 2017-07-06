/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DataAccesObject.FiadorDAO;
import Models.Fiador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author berna
 */
public class JFrameBuscarFiador extends javax.swing.JFrame {

    /**
     * Creates new form JFrameBuscarBanco
     */
    public JFrameBuscarFiador() {
        initComponents();
        listarFiadorTodos();
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
        jTxtFiador = new javax.swing.JTextField();
        jButtonSair = new javax.swing.JButton();
        jLabelFiador = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFiador = new javax.swing.JTable();
        jButtonAlterar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jTxtFiador.setText("pesquisar pelo nome");
        jTxtFiador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtFiadorActionPerformed(evt);
            }
        });
        jTxtFiador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtFiadorKeyPressed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabelFiador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFiador.setText("Dados do Fiador");

        jTableFiador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Endereço", "Número", "Bairro", "Cidade", "Estado", "CPF", "Telefone "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableFiador);

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
                        .addComponent(jTxtFiador, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelFiador)
                .addGap(287, 287, 287))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabelFiador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTxtFiador, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
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
        int codigo = (int) jTableFiador.getValueAt(jTableFiador.getSelectedRow(), 0);
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "ALERTA", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            FiadorDAO fiador = new FiadorDAO();
            fiador.excluirFiador(codigo);
            JOptionPane.showMessageDialog(null, "Fiador excluído com sucesso");
        } else if (resposta == JOptionPane.NO_OPTION) {
            //Usuário clicou em não. Executar o código correspondente.
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTxtFiadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtFiadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtFiadorActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jTxtFiadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFiadorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtFiadorKeyPressed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        //table = (JTable)JTable.getModel();  
        //table.setNumRows(0);
        try {
            FiadorDAO fiador = new FiadorDAO();
            ArrayList<Fiador> fiadores = fiador.listarFiador(jTxtFiador.getText());
            DefaultTableModel limpar = (DefaultTableModel) jTableFiador.getModel();
            limpar.setNumRows(0);
            for (Fiador f : fiadores) {
                DefaultTableModel model = (DefaultTableModel) jTableFiador.getModel();
                Object linha[] = new Object[]{f.getCodigo(), f.getNome(), f.getEndereco(), f.getNumero(), f.getBairro(), f.getCidade(), f.getEstado(), f.getCpf(), f.getTelefone()};
                model.addRow(linha);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir bancos.");
        }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        int codigo = (int) jTableFiador.getValueAt(jTableFiador.getSelectedRow(), 0);
        
        //jTableBanco.getSelectedRow();
        //JOptionPane.showConfirmDialog(null, codigo);
        //Comprador c = new Comprador();
        FiadorDAO fiador = new FiadorDAO();
        JFrameAlterarFiador alterarFiador = new JFrameAlterarFiador(fiador.fiadorBuscarFiador(codigo));
        alterarFiador.show();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void listarFiadorTodos() {
        try {
            FiadorDAO fiador = new FiadorDAO();
            ArrayList<Fiador> fiadores = fiador.listarFiadorTodos();
            DefaultTableModel limpar = (DefaultTableModel) jTableFiador.getModel();
            limpar.setNumRows(0);
            for (Fiador f : fiadores) {
                DefaultTableModel model = (DefaultTableModel) jTableFiador.getModel();
                Object linha[] = new Object[]{f.getCodigo(), f.getNome(), f.getEndereco(), f.getNumero(), f.getBairro(), f.getCidade(), f.getEstado(), f.getCpf(), f.getTelefone()};
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
    private javax.swing.JLabel jLabelFiador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFiador;
    private javax.swing.JTextField jTxtFiador;
    // End of variables declaration//GEN-END:variables
}
