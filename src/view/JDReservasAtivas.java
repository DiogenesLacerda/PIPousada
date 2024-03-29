/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Reserva;
import repositorio.RepQuarto;
import repositorio.RepReserva;

/**
 *
 * @author Usuario
 */
public class JDReservasAtivas extends javax.swing.JDialog {
RepQuarto repQuarto = new RepQuarto();
RepReserva repReserva = new RepReserva();
List<Reserva> reservas;


    /**
     * Creates new form JDReservasEmAndamento
     */
    public JDReservasAtivas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();     
        reservas = repReserva.reservasativa();
        preencherJTable(reservas);
    }
    
    public void preencherJTable( List<Reserva> reservas){
        
        DefaultTableModel modelo = (DefaultTableModel) jTableLista.getModel();
        modelo.setNumRows(0);
           
        
        for(Reserva c : reservas){
            modelo.addRow(new Object[]{
                //aqui vao ficar as colunas
                c.getId(),
                c.dataentradaTostring(),
                c.datasaidaTostring(),
                c.getCliente(),
                c.getNumquarto(),
                c.getQuartoid(),
                c.getObservacoes(),

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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableLista = new javax.swing.JTable();
        jButtonFinalizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelReserva = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nº", "ENTRADA", "SAÍDA", "CLIENTE", "QUARTO", "COD Q", "OBS:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        jButtonFinalizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonFinalizar.setText("FINALIZAR RESERVA");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setText("Reserva selecioanda:");

        jLabelReserva.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(387, 387, 387)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonFinalizar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(jLabelReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(268, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jButtonFinalizar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaMouseClicked
        if(jTableLista.getSelectedRow() != - 1){
            jLabelReserva.setText(jTableLista.getValueAt(jTableLista.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTableListaMouseClicked

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        if(!jLabelReserva.getText().equals("")){
            if(JOptionPane.showConfirmDialog(null, "Confirma finalizar a reserva "+jLabelReserva.getText()+" ?") == JOptionPane.YES_OPTION){
                repReserva.finalizar(Integer.parseInt(jLabelReserva.getText()));
            reservas = repReserva.reservasativa();
            preencherJTable(reservas);
            jLabelReserva.setText("");
            repQuarto.atulaizarativo();
            repQuarto.atulaizardesativoauto();
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Selcione a reserva");
        }
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

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
            java.util.logging.Logger.getLogger(JDReservasAtivas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDReservasAtivas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDReservasAtivas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDReservasAtivas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDReservasAtivas dialog = new JDReservasAtivas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelReserva;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableLista;
    // End of variables declaration//GEN-END:variables
}
