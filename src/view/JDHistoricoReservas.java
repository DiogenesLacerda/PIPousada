/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Reserva;
import repositorio.RepReserva;
import utils.Utils;

/**
 *
 * @author Usuario
 */
public class JDHistoricoReservas extends javax.swing.JDialog {
  RepReserva repReserva = new RepReserva();
  List<Reserva> reservas;
  Utils util = new Utils();
    /**
     * Creates new form JDHistoricoReservas
     */
    public JDHistoricoReservas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        reservas = repReserva.retornar();
        preencherJTable(reservas);
        jTextFieldPesquisa.requestFocus();
    }
    
    public void preencherJTable( List<Reserva> reservas){
        
        DefaultTableModel modelo = (DefaultTableModel) jTableLista.getModel();
        modelo.setNumRows(0);
           
        
        for(Reserva c : reservas){
            modelo.addRow(new Object[]{
                //aqui vao ficar as colunas
                c.getId(),
                c.getNumquarto(),
                c.getCliente(),
                c.getCliente_cpf(),
                util.formatarMoeda(c.getValor()),
                c.getFpag(),
                c.getObservacoes(),
                c.getStatus()

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLista = new javax.swing.JTable();
        jRadioButtonNumero = new javax.swing.JRadioButton();
        jRadioButtonClientes = new javax.swing.JRadioButton();
        jRadioButtonStatus = new javax.swing.JRadioButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonFpag = new javax.swing.JRadioButton();
        jButtonLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableLista.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NÚMERO", "QUARTO", "CLIENTE", "CPF CLIENTE", "VALOR", "FPAG", "OBS", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableLista);

        buttonGroup1.add(jRadioButtonNumero);
        jRadioButtonNumero.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jRadioButtonNumero.setText("Número");

        buttonGroup1.add(jRadioButtonClientes);
        jRadioButtonClientes.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jRadioButtonClientes.setText("Cliente");

        buttonGroup1.add(jRadioButtonStatus);
        jRadioButtonStatus.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jRadioButtonStatus.setText("Status");

        jTextFieldPesquisa.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setText("Pesquisar:");

        buttonGroup1.add(jRadioButtonFpag);
        jRadioButtonFpag.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jRadioButtonFpag.setText("F.Pag");

        jButtonLimpar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButtonLimpar.setText("LIMPAR");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonFpag, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonLimpar)
                        .addGap(44, 44, 44))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonNumero)
                    .addComponent(jRadioButtonClientes)
                    .addComponent(jRadioButtonStatus)
                    .addComponent(jRadioButtonFpag)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(jRadioButtonNumero.isSelected()){
            reservas = repReserva.pesquisar(jTextFieldPesquisa.getText(), "numero");
            }else if(jRadioButtonClientes.isSelected()){
            reservas = repReserva.pesquisar(jTextFieldPesquisa.getText(), "cliente");
            }else if(jRadioButtonFpag.isSelected()){
            reservas = repReserva.pesquisar(jTextFieldPesquisa.getText(), "fpag");
            }else if(jRadioButtonStatus.isSelected()){
            reservas = repReserva.pesquisar(jTextFieldPesquisa.getText(), "status"); 
            }
            
            preencherJTable(reservas);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisaKeyPressed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
       reservas = repReserva.retornar();
       preencherJTable(reservas);
       jTextFieldPesquisa.setText("");
       jTextFieldPesquisa.requestFocus();  

// TODO add your handling code here:
    }//GEN-LAST:event_jButtonLimparActionPerformed

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
            java.util.logging.Logger.getLogger(JDHistoricoReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDHistoricoReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDHistoricoReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDHistoricoReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDHistoricoReservas dialog = new JDHistoricoReservas(new javax.swing.JFrame(), true);
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
    private javax.swing.JRadioButton jRadioButtonClientes;
    private javax.swing.JRadioButton jRadioButtonFpag;
    private javax.swing.JRadioButton jRadioButtonNumero;
    private javax.swing.JRadioButton jRadioButtonStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLista;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
