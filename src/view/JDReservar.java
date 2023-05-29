/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Fpag;
import model.Quarto;
import model.Reserva;
import repositorio.RepCliente;
import repositorio.RepFpag;
import repositorio.RepQuarto;
import repositorio.RepReserva;
import utils.Utils;

/**
 *
 * @author dioge
 */
public class JDReservar extends javax.swing.JDialog {

    RepReserva repReserva = new RepReserva();
    RepCliente repCliente = new RepCliente();
    Cliente cliente = new Cliente();
    RepQuarto repQuarto = new RepQuarto();
    RepFpag repFpag = new RepFpag();
    List<Quarto> quartos;
    List<Fpag> pags;
    Utils util = new Utils();
    private int qcod = 0, fpags = 0,cod = 0 ;
    private LocalDateTime ini, fim;
    private double total = 0, dia = 0;

    /**
     * Creates new form JDReservar
     */
    public JDReservar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        habilitarCampos(false);

    }

    private void habilitarCampos(Boolean valor) {

        jFormattedTextFieldCPF.setEnabled(valor);
        jFormattedTextFieldDataEntrada.setEnabled(valor);
        jFormattedTextFieldDataSaida.setEnabled(valor);
        jTextAreaOBSV.setEnabled(valor);
        jTableFpag.setEnabled(valor);
        jTableLista.setEnabled(valor);
        jButtonCalcular.setEnabled(valor);
        jButtonPesquisar.setEnabled(valor);
        jButtonReservar.setEnabled(valor);
        jButtonCancelar.setEnabled(valor);
        jButtonNova.setEnabled(!valor);

    }

    private void limparCampos() {
        jLabelDia.setText("");
        jLabelNome.setText("");
        jLabelCPF.setText("");
        jLabelValor.setText("");
        jLabelTotal.setText("");
        jLabelRG.setText("");
        jLabelQuarto.setText("");
        jLabelreserva.setText("");
        jFormattedTextFieldDataSaida.setText("");
        jFormattedTextFieldDataEntrada.setText("");
        jFormattedTextFieldCPF.setText("");
        jTextAreaOBSV.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jFormattedTextFieldDataFinal = new javax.swing.JFormattedTextField();
        jTextFieldTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldDiferença = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaOBS = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldQuarto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldCPF = new javax.swing.JTextField();
        jTextFieldCodQ = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextFieldDataini = new javax.swing.JFormattedTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonCancelar = new javax.swing.JButton();
        jButtonReservar = new javax.swing.JButton();
        jButtonNova = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLista = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabelreserva = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jFormattedTextFieldDataSaida = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaOBSV = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jFormattedTextFieldDataEntrada = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableFpag = new javax.swing.JTable();
        jButtonCalcular = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jLabelCPF = new javax.swing.JLabel();
        jLabelRG = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelQuarto = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelDia = new javax.swing.JLabel();

        jLabel7.setText("Total:");

        try {
            jFormattedTextFieldDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setText("Forma PAG:");

        jLabel4.setText("Cliente:");

        jLabel9.setText("OBS:");

        jTextAreaOBS.setColumns(20);
        jTextAreaOBS.setRows(5);
        jScrollPane2.setViewportView(jTextAreaOBS);

        jLabel5.setText("Entrada:");

        jLabel6.setText("Quarto Nº:");

        jLabel11.setText("CPF:");

        jLabel10.setText("Saída:");

        jLabel12.setText("COD:");

        try {
            jFormattedTextFieldDataini.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonCancelar.setText("CANCELAR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonReservar.setText("RESERVAR");
        jButtonReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReservarActionPerformed(evt);
            }
        });

        jButtonNova.setText("NOVA");
        jButtonNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaActionPerformed(evt);
            }
        });

        jTableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NÚMERO", "VALOR", "COD."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        jScrollPane1.setViewportView(jTableLista);

        jLabel1.setText("Reserva número:");

        jLabel3.setText("Quartos disponíveis");

        jLabel13.setText("Total da reserva:");

        try {
            jFormattedTextFieldDataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel14.setText("Forma PAG:");

        jLabel16.setText("OBS:");

        jTextAreaOBSV.setColumns(20);
        jTextAreaOBSV.setRows(5);
        jScrollPane3.setViewportView(jTextAreaOBSV);

        jLabel17.setText("Entrada:");

        jLabel18.setText("Quarto Nº:");

        jLabel20.setText("Saída:");

        try {
            jFormattedTextFieldDataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel15.setText("Digite o CPF do Cliente:");

        jLabel19.setText("Nome:");

        jLabel21.setText("CPF:");

        jLabel22.setText("RG:");

        jTableFpag.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "COD.", "DESCRICAO"
            }
        ));
        jTableFpag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFpagMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableFpag);

        jButtonCalcular.setText("CALCULAR");
        jButtonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularActionPerformed(evt);
            }
        });

        jButtonPesquisar.setText("OK");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldCPFKeyPressed(evt);
            }
        });

        jLabelTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel23.setText("Valor:");

        jLabel2.setText("Diárias:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(jButtonCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonReservar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonNova, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jFormattedTextFieldDataSaida, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonCalcular)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(86, 86, 86))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonPesquisar))
                                    .addComponent(jLabelreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel23))
                                            .addComponent(jLabelRG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(163, 163, 163)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jButtonPesquisar)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelRG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jLabel23)
                        .addComponent(jLabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jButtonCalcular)
                    .addComponent(jLabel2)
                    .addComponent(jLabelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel14))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel16)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNova)
                    .addComponent(jButtonReservar)
                    .addComponent(jButtonCancelar))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed

        try{
            cliente = repCliente.pesquisarreservar(jFormattedTextFieldCPF.getText());
            if(cliente.getCpf().equals(jFormattedTextFieldCPF.getText())){
            jLabelCPF.setText(cliente.getCpf());
            jLabelNome.setText(cliente.getNome());
            jLabelRG.setText(cliente.getRg());
            jFormattedTextFieldCPF.setText("");
            cod = cliente.getId();
            jButtonPesquisar.setEnabled(false);
            jFormattedTextFieldCPF.setEnabled(false);
            }else{
                jFormattedTextFieldCPF.setText("");
               JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
               jFormattedTextFieldCPF.requestFocus();
            }
        }catch(Exception ex){
            jFormattedTextFieldCPF.setText("");
            JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
            jFormattedTextFieldCPF.requestFocus();
        }
        
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jFormattedTextFieldCPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCPFKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try{
            cliente = repCliente.pesquisarreservar(jFormattedTextFieldCPF.getText());
            if(cliente.getCpf().equals(jFormattedTextFieldCPF.getText())){
            jLabelCPF.setText(cliente.getCpf());
            jLabelNome.setText(cliente.getNome());
            jLabelRG.setText(cliente.getRg());
            jFormattedTextFieldCPF.setText("");
            cod = cliente.getId();
            jButtonPesquisar.setEnabled(false);
            jFormattedTextFieldCPF.setEnabled(false);
            }else{
            jFormattedTextFieldCPF.setText("");
            JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
            jFormattedTextFieldCPF.requestFocus();
              
            }
        }catch(Exception ex){
            jFormattedTextFieldCPF.setText("");
            JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
            jFormattedTextFieldCPF.requestFocus();
        }
        }
    }//GEN-LAST:event_jFormattedTextFieldCPFKeyPressed

    private void jButtonNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaActionPerformed
        habilitarCampos(true);
        quartos = repQuarto.disponiveisparareservar();
        preencherJTable(quartos);
        pags = repFpag.retornar();
        preencherJTableFpag(pags);
        jLabelreserva.setText(String.valueOf(""+(repReserva.retornarvenda()+1)+""));
        jFormattedTextFieldCPF.requestFocus();
    }//GEN-LAST:event_jButtonNovaActionPerformed

    private void jButtonReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReservarActionPerformed
        if (jLabelQuarto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Escolha o quarto");
        } else if (jLabelCPF.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Insira o cliente");
            jFormattedTextFieldCPF.requestFocus();
        } else if (fpags == 0) {
            JOptionPane.showMessageDialog(null, "Selecione a forma de pagamento");
        } else if (jLabelTotal.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Calcule o valor da reserva");
        } else {
            Reserva reserva = new Reserva();

            reserva.setClientid(cod);
            reserva.setDtentrada(util.tolocaldate(jFormattedTextFieldDataEntrada.getText()));
            reserva.setDtsaida(util.tolocaldate(jFormattedTextFieldDataSaida.getText()));
            reserva.setValor(total);
            reserva.setFpagid(fpags);
            reserva.setQuartoid(qcod);
            reserva.setStatus("Reservada");
            reserva.setObservacoes(jTextAreaOBSV.getText());
            if (repReserva.inserir(reserva) == true) {
                JOptionPane.showMessageDialog(null, "Reservada com sucesso!");
                habilitarCampos(false);
                limparCampos();
                zerar();
                repQuarto.atulaizarativo();
                repQuarto.atulaizardesativoauto();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao reservar.");
            }
        }

    }//GEN-LAST:event_jButtonReservarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        habilitarCampos(false);
        limparCampos();
        zerar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTableFpagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFpagMouseClicked
        if (jTableLista.getSelectedRow() != - 1) {
            fpags = Integer.parseInt(jTableFpag.getValueAt(jTableFpag.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTableFpagMouseClicked

    private void jTableListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaMouseClicked

        if (jTableLista.getSelectedRow() != - 1) {
            jLabelQuarto.setText(jTableLista.getValueAt(jTableLista.getSelectedRow(), 0).toString());
            jLabelValor.setText(jTableLista.getValueAt(jTableLista.getSelectedRow(), 1).toString());
            qcod = Integer.parseInt(jTableLista.getValueAt(jTableLista.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_jTableListaMouseClicked

    private void jButtonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularActionPerformed
        if (jFormattedTextFieldDataEntrada.getText().equals("") || jFormattedTextFieldDataSaida.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite as datas de entrada e saída");
            jFormattedTextFieldDataEntrada.requestFocus();
        } else if (jLabelQuarto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Escolha o quarto");
        } else {
            try {
                ini = util.tolocaldate(jFormattedTextFieldDataEntrada.getText());
                fim = util.tolocaldate(jFormattedTextFieldDataSaida.getText());
                Duration dias = Duration.between(ini, fim);            
                dia = dias.toDays();
                total = dia * Double.parseDouble(jLabelValor.getText().replace(",", "."));
                jLabelDia.setText(String.format("%.0f", dia));
                jLabelTotal.setText("R$ " + util.formatarMoeda(total));
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Digite datas válidas");
            }        
        
        }
        

    }//GEN-LAST:event_jButtonCalcularActionPerformed

    public void preencherJTable(List<Quarto> quartos) {

        DefaultTableModel modelo = (DefaultTableModel) jTableLista.getModel();
        modelo.setNumRows(0);

        for (Quarto c : quartos) {
            modelo.addRow(new Object[]{
                c.getNumero(),
                util.formatarMoeda(c.getValor()),
                c.getId()

            });
        }
    }

    public void zerar() {
        dia = 0;
        total = 0;
        qcod = 0;
        fpags = 0;
        cod = 0;
    }

    public void preencherJTableFpag(List<Fpag> fpag) {

        DefaultTableModel modelo = (DefaultTableModel) jTableFpag.getModel();
        modelo.setNumRows(0);

        for (Fpag f : fpag) {
            modelo.addRow(new Object[]{
                f.getId(),
                f.getDescricao()

            });
        }
    }

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
            java.util.logging.Logger.getLogger(JDReservar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDReservar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDReservar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDReservar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDReservar dialog = new JDReservar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonCalcular;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonNova;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonReservar;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataEntrada;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataFinal;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataSaida;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelDia;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelQuarto;
    private javax.swing.JLabel jLabelRG;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JLabel jLabelreserva;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableFpag;
    private javax.swing.JTable jTableLista;
    private javax.swing.JTextArea jTextAreaOBS;
    private javax.swing.JTextArea jTextAreaOBSV;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldCliente;
    private javax.swing.JTextField jTextFieldCodQ;
    private javax.swing.JTextField jTextFieldDiferença;
    private javax.swing.JTextField jTextFieldQuarto;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
}