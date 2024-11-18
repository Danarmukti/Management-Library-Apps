/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import koneksi_db.koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lenovo
 */
public class datapengunjung extends javax.swing.JPanel {
    
    private final Connection conn = new koneksi().connect();
    DefaultTableModel tabmode;
    String idtabel,namatabel,alamattabel,phonetabel;
    
    private DefaultTableModel data;
   
    Statement stm;
    ResultSet rs;
    
    JasperReport JasperReport;
    JasperDesign JasperDesign;
    JasperPrint JasperPrint;
    Map<String, Object> param = new HashMap<>();
    /**
     * Creates new form 
     */
    
   public String getNamatabel(String namatabel) {
        return namatabel;
    }

    public void setNamatabel(String namatabel) {
        this.namatabel = namatabel;
    }
    
    public datapengunjung() {
        initComponents();
        fordeleteid.setVisible(false);
        
        // hover to btn changes cursor pointer into hand cursor
        searchbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deletebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        dataPengunjung();
    }
    
    protected void dataPengunjung() {
           Object[] Baris ={"ID Pengunjung","Nama Pengunjung","Usia","Kategori Usia",
            "Alamat","No Telepon","Tanggal Input"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelpengunjung.setModel(tabmode);
        String sql = "select * from datapengunjung";
        try {
            java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()) {
                    String a = hasil.getString("id");
                    String b = hasil.getString("nama");
                    String c = hasil.getString("usia");
                    String d = hasil.getString("category_age");
                    String e = hasil.getString("alamat");
                    String f = hasil.getString("phone");
                    String g = hasil.getString("tanggal");

                    String[] data={a,b,c,d,e,f,g};
                    tabmode.addRow(data);
            }
        } catch (Exception e) {
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fordeleteid = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        mainpanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchpanel = new custom.CustomRoundedTextField();
        searchbtn = new custom.CustomRoundedButton();
        addbtn = new custom.CustomRoundedButton();
        editbtn = new custom.CustomRoundedButton();
        deletebtn = new custom.CustomRoundedButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpengunjung = new custom.CustomRoundedTable();
        databtn2 = new custom.CustomRoundedButton();

        fordeleteid.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setRequestFocusEnabled(false);

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));
        mainpanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainpanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(23, 48, 82));
        jLabel1.setFont(new java.awt.Font("Lexend Deca", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 48, 82));
        jLabel1.setText("DATA PENGUNJUNG");

        searchpanel.setFocusedBorderColor(new java.awt.Color(23, 48, 82));
        searchpanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchpanelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchpanelKeyTyped(evt);
            }
        });

        searchbtn.setBackground(new java.awt.Color(23, 48, 82));
        searchbtn.setForeground(new java.awt.Color(255, 255, 255));
        searchbtn.setText("Search");
        searchbtn.setFont(new java.awt.Font("Lexend Deca Medium", 0, 11)); // NOI18N

        addbtn.setBackground(new java.awt.Color(23, 48, 82));
        addbtn.setForeground(new java.awt.Color(255, 255, 255));
        addbtn.setText("Add");
        addbtn.setFont(new java.awt.Font("Lexend Deca Medium", 0, 11)); // NOI18N
        addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbtnMouseClicked(evt);
            }
        });
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        editbtn.setBackground(new java.awt.Color(23, 48, 82));
        editbtn.setForeground(new java.awt.Color(255, 255, 255));
        editbtn.setText("Edit");
        editbtn.setFont(new java.awt.Font("Lexend Deca Medium", 0, 11)); // NOI18N
        editbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editbtnMouseClicked(evt);
            }
        });

        deletebtn.setBackground(new java.awt.Color(23, 48, 82));
        deletebtn.setForeground(new java.awt.Color(255, 255, 255));
        deletebtn.setText("Delete");
        deletebtn.setFont(new java.awt.Font("Lexend Deca Medium", 0, 11)); // NOI18N
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tabelpengunjung);

        databtn2.setBackground(new java.awt.Color(23, 48, 82));
        databtn2.setForeground(new java.awt.Color(255, 255, 255));
        databtn2.setText("Print");
        databtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databtn2ActionPerformed(evt);
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
                        .addComponent(searchpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(databtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(97, 97, 97)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(databtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainpanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbtnMouseClicked
        // TODO add your handling code here:
        mainpanel.removeAll();
        mainpanel.add(new formdatapengunjung());
        mainpanel.repaint();
        mainpanel.revalidate();
    }//GEN-LAST:event_addbtnMouseClicked

    private void tabelpengunjungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpengunjungMouseClicked
        // TODO add your handling code here:
//        int bar = tabelpengunjung.getSelectedRow();
//        String a = tabmode.getValueAt(bar, 0).toString();
//        String b = tabmode.getValueAt(bar, 1).toString();
//        String c = tabmode.getValueAt(bar, 2).toString();
//        String d = tabmode.getValueAt(bar, 3).toString();
//        
//        setNamatabel(a);
        
        int bar = tabelpengunjung.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
      
        fordeleteid.setText(a);
       

//        namatabel = b;
//        alamattabel = c;
//        phonetabel= d;
    }//GEN-LAST:event_tabelpengunjungMouseClicked

    private void editbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbtnMouseClicked
        // TODO add your handling code here:
        mainpanel.removeAll();
        mainpanel.add(new formeditdatapengunjung());
        mainpanel.repaint();
        mainpanel.revalidate();
    }//GEN-LAST:event_editbtnMouseClicked

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0) {
            if (fordeleteid.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "pilih yang ingin dihapus");
            } else {
                String sql ="delete from datapengunjung where id='"+fordeleteid.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                dataPengunjung();
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            }
            }
        } 
      
    }//GEN-LAST:event_deletebtnActionPerformed

    private void searchpanelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchpanelKeyTyped
        // TODO add your handling code here:
//        Object[] Baris ={"ID Pengunjung","Nama Pengunjung","Alamat","No Telepon"};
//        tabmode = new DefaultTableModel(null, Baris);
//        tabelpengunjung.setModel(tabmode); 
//        String sql = "select * from datapengunjung where nama like '%"+evt+"%'";
//        try {
//            java.sql.Statement stat = conn.createStatement();
//            ResultSet hasil = stat.executeQuery(sql);
//            while(hasil.next()) {
//                String a = hasil.getString("id");
//                String b = hasil.getString("nama");
//                String c = hasil.getString("alamat");
//                String d = hasil.getString("phone");
//            
//                String[] data={a,b,c,d};
//                tabmode.addRow(data);
//            }
//        }catch (Exception e) {
//        } 
    }//GEN-LAST:event_searchpanelKeyTyped

    private void searchpanelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchpanelKeyReleased
        // TODO add your handling code here:
        Object[] Baris ={"ID Pengunjung","Nama Pengunjung","Alamat","No Telepon"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelpengunjung.setModel(tabmode); 
        String sql = "select * from datapengunjung where nama like '%"+searchpanel.getText()+"%' OR id like '%"+searchpanel.getText()+"%'";
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
        }catch (Exception e) {
        } 
    }//GEN-LAST:event_searchpanelKeyReleased

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        // TODO add your handling code here:
//        try {
//            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/rumahsakit","root","");
//            File file = new File("src/Project1/report3.jrxml");
//            JasperDesign = JRXmlLoader.load(file);
//            JasperReport = JasperCompileManager.compileReport(JasperDesign);
//            JasperPrint = JasperFillManager.fillReport(JasperReport, param, koneksi);
//            JasperViewer.viewReport(JasperPrint, false);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
    }//GEN-LAST:event_addbtnActionPerformed

    private void databtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databtn2ActionPerformed
        // TODO add your handling code here:
        Connection koneksi;
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
            File file = new File("src/lapor/reportpeng.jrxml");
            JasperDesign = JRXmlLoader.load(file);
            JasperReport = JasperCompileManager.compileReport(JasperDesign);
            JasperPrint = JasperFillManager.fillReport(JasperReport, param, koneksi);
            JasperViewer.viewReport(JasperPrint, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_databtn2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.CustomRoundedButton addbtn;
    private custom.CustomRoundedButton databtn2;
    private custom.CustomRoundedButton deletebtn;
    private custom.CustomRoundedButton editbtn;
    private javax.swing.JTextField fordeleteid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    private custom.CustomRoundedButton searchbtn;
    private custom.CustomRoundedTextField searchpanel;
    private custom.CustomRoundedTable tabelpengunjung;
    // End of variables declaration//GEN-END:variables
}
