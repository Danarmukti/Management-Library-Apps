/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi_db.koneksi;

/**
 *
 * @author Lenovo
 */
public class formeditdatapengunjung extends javax.swing.JPanel {
     private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * 
     */
    public formeditdatapengunjung() {
        initComponents();
        
        backbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clearbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        dataPengunjung();
    }
    
    protected void aktif() {
        idfield.setEnabled(true);
        namafield.setEnabled(true);
        alamatfield.setEnabled(true);
        telpfield.setEnabled(true);
        idfield.requestFocus();
    }
    
    protected void kosong(){
        
        idfield.setText("");
        namafield.setText("");
        alamatfield.setText("");
        telpfield.setText("");
    }

   protected void dataPengunjung() {
       //memanggil data yang ada pada database 
        Object[] Baris ={"ID Pengunjung","Nama Pengunjung","Alamat","No Telepon"}; // mengganti judul pada header di tabel
        tabmode = new DefaultTableModel(null, Baris);
        tabelpengunjung.setModel(tabmode);
        String sql = "select * from datapengunjung"; // memilih tabel yang ada pada database
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()) {
                String a = hasil.getString("id");
                String b = hasil.getString("nama");
                String c = hasil.getString("alamat");
                String d = hasil.getString("phone");
            
                String[] data={a,b,c,d};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
        }
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
        idfield = new custom.CustomRoundedTextField();
        telpfield = new custom.CustomRoundedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatfield = new custom.CustomRoundedTextArea();
        editbtn = new custom.CustomRoundedButton();
        clearbtn = new custom.CustomRoundedButton();
        backbtn = new custom.CustomRoundedButton();
        jLabel5 = new javax.swing.JLabel();
        namafield = new custom.CustomRoundedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelpengunjung = new custom.CustomRoundedTable();

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));
        mainpanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lexend Deca", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 48, 82));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit Data Pengunjung");

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
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Lexend Deca Medium", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(23, 48, 82));
        jLabel3.setText("Alamat");

        jLabel4.setFont(new java.awt.Font("Lexend Deca Medium", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(23, 48, 82));
        jLabel4.setText("No Telp");

        idfield.setFocusedBorderColor(new java.awt.Color(23, 48, 82));
        idfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idfieldActionPerformed(evt);
            }
        });

        telpfield.setFocusedBorderColor(new java.awt.Color(23, 48, 82));
        telpfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telpfieldKeyTyped(evt);
            }
        });

        alamatfield.setColumns(20);
        alamatfield.setRows(5);
        alamatfield.setToolTipText("");
        alamatfield.setFocusedBorderColor(new java.awt.Color(23, 48, 82));
        alamatfield.setSelectionColor(new java.awt.Color(23, 48, 82));
        alamatfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                alamatfieldFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(alamatfield);

        editbtn.setBackground(new java.awt.Color(23, 48, 82));
        editbtn.setForeground(new java.awt.Color(255, 255, 255));
        editbtn.setText("Edit");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
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
        jLabel5.setText("Nama");

        namafield.setFocusedBorderColor(new java.awt.Color(23, 48, 82));
        namafield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namafieldActionPerformed(evt);
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
                            .addComponent(jLabel5))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idfield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(telpfield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namafield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(idfield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namafield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(telpfield, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(198, 198, 198))
        );

        tabelpengunjung.setForeground(new java.awt.Color(23, 48, 82));
        tabelpengunjung.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelpengunjung.setBorderColor(new java.awt.Color(23, 48, 82));
        tabelpengunjung.setFont(new java.awt.Font("Lexend Deca Medium", 0, 14)); // NOI18N
        tabelpengunjung.setGridColor(new java.awt.Color(255, 255, 255));
        tabelpengunjung.setHeaderAlignment(2);
        tabelpengunjung.setHeaderBackgroundColor(new java.awt.Color(23, 48, 82));
        tabelpengunjung.setHeaderForegroundColor(new java.awt.Color(255, 255, 255));
        tabelpengunjung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpengunjungMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelpengunjung);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
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

    private void idfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idfieldActionPerformed

    private void telpfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telpfieldKeyTyped
        
        // agar inputan hanya number
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){ //agar di inputan no telp hanya bisa memasukan angka
            evt.consume();
        }
        // agar inputan hanya number
    }//GEN-LAST:event_telpfieldKeyTyped

    private void alamatfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alamatfieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatfieldFocusGained

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_backbtnActionPerformed

    private void backbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbtnMouseClicked
        
        mainpanel.removeAll();
        mainpanel.add(new datapengunjung());
        mainpanel.repaint();
        mainpanel.revalidate();
    }//GEN-LAST:event_backbtnMouseClicked

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        
        try {
            //validasi ketika inputan kosong maka update atau edit tidak berjalan
            if (namafield.getText().equals("") || alamatfield.getText().equals("") || telpfield.getText().equals("") || idfield.equals("")) {
                
            JOptionPane.showMessageDialog(null, "form tidak boleh kosong!");
                
            } else { //validasi ketika semua sudah terisi maka update atau edit baru bisa berjalan
            String sql = "update datapengunjung set nama=?,alamat=?,phone=? where id=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namafield.getText());
            stat.setString(2, alamatfield.getText());
            stat.setString(3, telpfield.getText());
            stat.setString(4, idfield.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil di ubah");

            kosong();
            idfield.requestFocus();
            dataPengunjung();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal di "+e);
        }              
    }//GEN-LAST:event_editbtnActionPerformed

    private void namafieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namafieldActionPerformed
      
    }//GEN-LAST:event_namafieldActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
       
        kosong();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void tabelpengunjungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpengunjungMouseClicked

        int bar = tabelpengunjung.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
      
        
        idfield.setText(a);
        namafield.setText(b);
        alamatfield.setText(c);
        telpfield.setText(d);
  
    }//GEN-LAST:event_tabelpengunjungMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.CustomRoundedTextArea alamatfield;
    private custom.CustomRoundedButton backbtn;
    private custom.CustomRoundedButton clearbtn;
    private custom.CustomRoundedButton editbtn;
    private custom.CustomRoundedTextField idfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainpanel;
    private custom.CustomRoundedTextField namafield;
    private custom.RoundedPanel roundedPanel1;
    private custom.CustomRoundedTable tabelpengunjung;
    private custom.CustomRoundedTextField telpfield;
    // End of variables declaration//GEN-END:variables
}
