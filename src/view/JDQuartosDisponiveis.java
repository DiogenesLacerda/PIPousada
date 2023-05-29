/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Quarto;
import repositorio.RepQuarto;
import utils.Utils;

/**
 *
 * @author Usuario
 */
public class JDQuartosDisponiveis extends javax.swing.JDialog {
    RepQuarto repQuarto = new RepQuarto();
    List<Quarto> quartos;
    List<Quarto> quartos2;
    Utils util = new Utils();
    /**
     * Creates new form JDQuartosDisponiveis
     */
    public JDQuartosDisponiveis(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        repQuarto.atulaizarativo();
        repQuarto.atulaizardesativoauto();
        quartos2 = repQuarto.disponiveis();
        quartos = repQuarto.disponiveisreservados();
        preencherJTable(quartos);
        preencherJTable2(quartos2);
        jTextFieldPesquisa.requestFocus();
        
    }
    
    public void preencherJTable2( List<Quarto> quartos){
        
        DefaultTableModel modelo = (DefaultTableModel) jTableLista1.getModel();
        modelo.setNumRows(0);
           
        
        for(Quarto c : quartos){
            modelo.addRow(new Object[]{
                //aqui vao ficar as colunas
                c.getNumero(),
                c.getTipo(),
                c.getDescricao(),
                util.formatarMoeda(c.getValor())

            });
        }
    }

    
    public void preencherJTable( List<Quarto> quartos){
        
        DefaultTableModel modelo = (DefaultTableModel) jTableLista.getModel();
        modelo.setNumRows(0);
           
        
        for(Quarto c : quartos){
            modelo.addRow(new Object[]{
                //aqui vao ficar as colunas
                c.getNumero(),
                c.getTipo(),
                c.getDescricao(),
                util.formatarMoeda(c.getValor())

            });
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButtonTipo = new javax.swing.JRadioButton();
        jRadioButtonNumero = new javax.swing.JRadioButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableLista = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableLista1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonGroup1.add(jRadioButtonTipo);
        jRadioButtonTipo.setText("Tipo");

        buttonGroup1.add(jRadioButtonNumero);
        jRadioButtonNumero.setText("Número");

        jTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaKeyPressed(evt);
            }
        });

        jLabel1.setText("Pesquisar:");

        jTableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NÚMERO", "TIPO", "DESCRIÇÃO", "VALOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableLista);

        jTableLista1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NÚMERO", "TIPO", "DESCRIÇÃO", "VALOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLista1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLista1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableLista1);

        jLabel3.setText("COM RESERVAS FUTURAS");

        jLabel4.setText("SEM RESERVAS");

        jLabel2.setText("Descricao:");

        jButtonLimpar.setText("LIMPAR");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jRadioButtonTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonLimpar)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(356, 356, 356))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(388, 388, 388))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonTipo)
                    .addComponent(jRadioButtonNumero)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonLimpar))
                .addGap(29, 29, 29)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(70, 70, 70))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaKeyPressed
           if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(jRadioButtonTipo.isSelected()){
            quartos = repQuarto.pesquisardisponiveisr(jTextFieldPesquisa.getText(), "tipo");
            quartos2 = repQuarto.pesquisardisponiveis(jTextFieldPesquisa.getText(), "tipo");
            }else{
            quartos = repQuarto.pesquisardisponiveisr(jTextFieldPesquisa.getText(), "numero");
            quartos2 = repQuarto.pesquisardisponiveis(jTextFieldPesquisa.getText(), "numero");
            }
            
            preencherJTable(quartos);
            preencherJTable2(quartos2);
        }         

     // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisaKeyPressed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        quartos2 = repQuarto.disponiveis();
        quartos = repQuarto.disponiveisreservados();
        preencherJTable(quartos);
        preencherJTable2(quartos2);
        jTextFieldPesquisa.setText("");
        jTextFieldPesquisa.requestFocus();
        jTextAreaDescricao.setText("");
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jTableListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaMouseClicked
        if(jTableLista.getSelectedRow() != - 1){
            jTextAreaDescricao.setText(jTableLista.getValueAt(jTableLista.getSelectedRow(), 2).toString());
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jTableListaMouseClicked

    private void jTableLista1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLista1MouseClicked
        if(jTableLista1.getSelectedRow() != - 1){
            jTextAreaDescricao.setText(jTableLista1.getValueAt(jTableLista1.getSelectedRow(), 2).toString());
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jTableLista1MouseClicked

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
            java.util.logging.Logger.getLogger(JDQuartosDisponiveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDQuartosDisponiveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDQuartosDisponiveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDQuartosDisponiveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDQuartosDisponiveis dialog = new JDQuartosDisponiveis(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButtonNumero;
    private javax.swing.JRadioButton jRadioButtonTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableLista;
    private javax.swing.JTable jTableLista1;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}