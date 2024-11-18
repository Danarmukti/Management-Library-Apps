/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi_db.koneksi;

/**
 *
 * @author Lenovo
 */
public class formdatapengunjung extends javax.swing.JPanel {
     private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * 
     */
    public formdatapengunjung() {
        initComponents();
        
        backbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clearbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        simpanbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
    protected void aktif() {
        namafield.setEnabled(true);
        alamatfield.setEnabled(true);
        ufield.setEnabled(true);
        namafield.requestFocus();
    }
    
    protected void kosong(){
        namafield.setText("");
        alamatfield.setText("");
        category.setText("");
        ufield.setText("");
        telp.setText("");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        roundedPanel1 = new custom.RoundedPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namafield = new custom.CustomRoundedTextField();
        ufield = new custom.CustomRoundedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatfield = new custom.CustomRoundedTextArea();
        simpanbtn = new custom.CustomRoundedButton();
        clearbtn = new custom.CustomRoundedButton();
        backbtn = new custom.CustomRoundedButton();
        jLabel5 = new javax.swing.JLabel();
        category = new custom.CustomRoundedTextField();
        jLabel6 = new javax.swing.JLabel();
        telp = new custom.CustomRoundedTextField();

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));
        mainpanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lexend Deca", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 48, 82));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Form Data Pengunjung");

        roundedPanel1.setBackground(new java.awt.Color(23, 48, 82));
        roundedPanel1.setBackgroundColor(new java.awt.Color(23, 48, 82));
        roundedPanel1.setBorderThickness(0);
        roundedPanel1.setBottomLeftRadius(10);
        roundedPanel1.setBottomRightRadius(10);
        roundedPanel1.setPreferredSize(new java.awt.Dimension(100, 10));
        roundedPanel1.setTopLeftRadius(10);
        roundedPanel1.setTopRightRadius(10);

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Lexend Deca Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(23, 48, 82));
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Lexend Deca Medium", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(23, 48, 82));
        jLabel3.setText("Alamat");

        jLabel4.setFont(new java.awt.Font("Lexend Deca Medium", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(23, 48, 82));
        jLabel4.setText("Usia");

        namafield.setFocusedBorderColor(new java.awt.Color(23, 48, 82));
        namafield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namafieldActionPerformed(evt);
            }
        });

        ufield.setFocusedBorderColor(new java.awt.Color(23, 48, 82));
        ufield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ufieldKeyTyped(evt);
            }
        });

        alamatfield.setColumns(20);
        alamatfield.setRows(5);
        alamatfield.setFocusedBorderColor(new java.awt.Color(23, 48, 82));
        alamatfield.setSelectionColor(new java.awt.Color(23, 48, 82));
        alamatfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                alamatfieldFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(alamatfield);

        simpanbtn.setBackground(new java.awt.Color(23, 48, 82));
        simpanbtn.setForeground(new java.awt.Color(255, 255, 255));
        simpanbtn.setText("Simpan");
        simpanbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanbtnActionPerformed(evt);
            }
        });

        clearbtn.setBackground(new java.awt.Color(23, 48, 82));
        clearbtn.setForeground(new java.awt.Color(255, 255, 255));
        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        backbtn.setBackground(new java.awt.Color(23, 48, 82));
        backbtn.setForeground(new java.awt.Color(255, 255, 255));
        backbtn.setText("Back");
        backbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backbtnMouseClicked(evt);
            }
        });
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lexend Deca Medium", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(23, 48, 82));
        jLabel5.setText("Kategori");

        category.setFocusedBorderColor(new java.awt.Color(23, 48, 82));
        category.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                categoryKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lexend Deca Medium", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(23, 48, 82));
        jLabel6.setText("No Telpon");

        telp.setFocusedBorderColor(new java.awt.Color(23, 48, 82));
        telp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telpKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namafield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ufield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                            .addComponent(category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(telp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(simpanbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namafield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(ufield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(telp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1))
                .addGap(67, 67, 67)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(265, 265, 265))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainpanel.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void namafieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namafieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namafieldActionPerformed

    private void ufieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ufieldKeyTyped
        
        // agar inputan hanya number
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
        // agar inputan hanya number
    }//GEN-LAST:event_ufieldKeyTyped

    private void alamatfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alamatfieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatfieldFocusGained

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_backbtnActionPerformed

    private void backbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbtnMouseClicked
        // TODO add your handling code here:
        mainpanel.removeAll();
        mainpanel.add(new datapengunjung());
        mainpanel.repaint();
        mainpanel.revalidate();
    }//GEN-LAST:event_backbtnMouseClicked

    private void simpanbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanbtnActionPerformed
        // TODO add your handling code here:
        String sql = "insert into datapengunjung values ("+null+",?,?,?,?,?,"+null+")";
        try {
            if (namafield.getText().equals("") || ufield.getText().equals("") || category.getText().equals("") 
                    || alamatfield.getText().equals("") || telp.getText().equals("")) {
                
            JOptionPane.showMessageDialog(null, "lengkapi form!");
                
            } else {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namafield.getText());
            stat.setString(2, ufield.getText());
            stat.setString(3, category.getText());
            stat.setString(4, alamatfield.getText());
            stat.setString(5, telp.getText());
      
            
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            kosong();
            namafield.requestFocus();
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);   
        }               
    }//GEN-LAST:event_simpanbtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void categoryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoryKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryKeyTyped

    private void telpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telpKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_telpKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.CustomRoundedTextArea alamatfield;
    private custom.CustomRoundedButton backbtn;
    private custom.CustomRoundedTextField category;
    private custom.CustomRoundedButton clearbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    private custom.CustomRoundedTextField namafield;
    private custom.RoundedPanel roundedPanel1;
    private custom.CustomRoundedButton simpanbtn;
    private custom.CustomRoundedTextField telp;
    private custom.CustomRoundedTextField ufield;
    // End of variables declaration//GEN-END:variables
}
