/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import koneksi_db.koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.*;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
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
public class formlaporan extends javax.swing.JPanel {
    private final Connection conn = new koneksi().connect();
    DefaultTableModel tabmode;
    
    JasperReport JasperReport;
    JasperDesign JasperDesign;
    JasperPrint JasperPrint;
    Map<String, Object> param = new HashMap<>();
    /**
     * Creates new form formlaporan
     */
    public formlaporan() {
        initComponents();
        
        table_container1.setVisible(false);
        table_container2.setVisible(false);
        table_container3.setVisible(false);
        table_container4.setVisible(false);
        
        btn_panel_denda.setVisible(false);
        btn_panel_pengunjung.setVisible(false);
        btn_panel_pengembalian.setVisible(false);
        btn_panel_peminjaman.setVisible(false);
        
        peminjaman_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pengembalian_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pengunjung_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        denda_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        print_pengunjung.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        print_peminjaman.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        print_pengembalian.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        print_denda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
    }
    
    public void printAll(String url) {
        Connection koneksi;
        try {
            String path = url;
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
            File file = new File(path);
            JasperDesign = JRXmlLoader.load(file);
            JasperReport = JasperCompileManager.compileReport(JasperDesign);
            JasperPrint = JasperFillManager.fillReport(JasperReport, param, koneksi);
            JasperViewer.viewReport(JasperPrint, false);
            System.out.println("Print All");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
//    public void printPeminjamanAll() {
//        Connection koneksi;
//        try {
//            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
//            File file = new File("src/lapor/reportpeminjaman/reportpeminjaman.jrxml");
//            JasperDesign = JRXmlLoader.load(file);
//            JasperReport = JasperCompileManager.compileReport(JasperDesign);
//            JasperPrint = JasperFillManager.fillReport(JasperReport, param, koneksi);
//            JasperViewer.viewReport(JasperPrint, false);
//            System.out.println("Print All");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
    
    public void printByFilter(String u, String name,String paraName , String url) {
        try {
            Connection koneksi;
            try {
                String path = url;
                koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
                HashMap hash = new HashMap();

                hash.put("category_age", u);
                hash.put(paraName, name);
//                hash.put("tgl", filterDate.getSelectedItem().toString());
                
                JasperReport rpt = JasperCompileManager.compileReport(url);
                JasperPrint print = JasperFillManager.fillReport(rpt, hash, koneksi);

                JasperViewer.viewReport(print, false);
                
                System.out.println("data berhasil di filter!");
//            
//                System.out.println(filterDate.getSelectedItem().toString());
            } catch (Exception e) {
                System.out.println("Cannot Print the Report! " + e);
            }
        } catch (Exception e) {
        }
    }
    
     public void printByDate(String tgl_filter, String url) {
        try {
            Connection koneksi;
            try {
                String path = url;
                koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
                
                HashMap hash = new HashMap();
                hash.put("tanggal_filter", tgl_filter);
                
                JasperReport rpt = JasperCompileManager.compileReport(path);
                JasperPrint print = JasperFillManager.fillReport(rpt, hash, koneksi);

                JasperViewer.viewReport(print, false);
                
                System.out.println("data berhasil di filter sesuai tanggal!");
            
            } catch (Exception e) {
                System.out.println("Cannot Print the Report! " + e.getMessage());
                System.out.println( filterDate.getSelectedItem().toString());
            }
        } catch (Exception e) {
        }
    }
    
    static String searchInput(String text) {
        String inputSearch = text;
        
        return inputSearch;
    }    

    static String dateInput(String tgl_input) {
        String di = tgl_input;
        
        return di;
    } 
    
    public void resetPengunjung() {
        pilih_pengunjung.setSelectedIndex(0);
        filterDate.setSelectedIndex(0);
        search_pengunjung.setText("Search Pengunjung");
    }
    
    public void resetPengembalian() {
        filterDatePengembalian.setSelectedIndex(0);
        search_pengembalian.setText("Search Pengembalian");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_panel = new javax.swing.JPanel();
        btn_panel_pengunjung = new javax.swing.JPanel();
        search_pengunjung = new javax.swing.JTextField();
        print_pengunjung = new custom.CustomRoundedButton();
        filterDate = new javax.swing.JComboBox<>();
        pilih_pengunjung = new javax.swing.JComboBox<>();
        btn_panel_peminjaman = new javax.swing.JPanel();
        search_peminjaman = new javax.swing.JTextField();
        print_peminjaman = new custom.CustomRoundedButton();
        filterDatePeminjaman = new javax.swing.JComboBox<>();
        btn_panel_pengembalian = new javax.swing.JPanel();
        search_pengembalian = new javax.swing.JTextField();
        print_pengembalian = new custom.CustomRoundedButton();
        filterDatePengembalian = new javax.swing.JComboBox<>();
        btn_panel_denda = new javax.swing.JPanel();
        search_denda = new javax.swing.JTextField();
        print_denda = new custom.CustomRoundedButton();
        pilih_denda = new javax.swing.JComboBox<>();
        date_denda = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        table_container1 = new javax.swing.JScrollPane();
        table_pengunjung = new custom.CustomRoundedTable();
        table_container2 = new javax.swing.JScrollPane();
        table_peminjaman = new custom.CustomRoundedTable();
        table_container3 = new javax.swing.JScrollPane();
        table_pengembalian = new custom.CustomRoundedTable();
        table_container4 = new javax.swing.JScrollPane();
        table_denda = new custom.CustomRoundedTable();
        jPanel4 = new javax.swing.JPanel();
        pengunjung_btn = new custom.CustomRoundedButton();
        denda_btn = new custom.CustomRoundedButton();
        peminjaman_btn = new custom.CustomRoundedButton();
        pengembalian_btn = new custom.CustomRoundedButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(996, 701));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(23, 48, 82));
        jLabel1.setFont(new java.awt.Font("Lexend Deca", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 48, 82));
        jLabel1.setText("FORM LAPORAN");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btn_panel.setBackground(new java.awt.Color(255, 255, 255));

        btn_panel_pengunjung.setBackground(new java.awt.Color(255, 255, 255));

        search_pengunjung.setText("Search pengunjung");
        search_pengunjung.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search_pengunjungFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                search_pengunjungFocusLost(evt);
            }
        });
        search_pengunjung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_pengunjungMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                search_pengunjungMouseEntered(evt);
            }
        });
        search_pengunjung.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_pengunjungKeyTyped(evt);
            }
        });

        print_pengunjung.setBackground(new java.awt.Color(64, 142, 249));
        print_pengunjung.setForeground(new java.awt.Color(255, 255, 255));
        print_pengunjung.setText("PRINT");
        print_pengunjung.setFont(new java.awt.Font("Lexend Deca SemiBold", 0, 12)); // NOI18N
        print_pengunjung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_pengunjungActionPerformed(evt);
            }
        });

        filterDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- by tanggal --", "Hari ini", "Kemarin", "3 Hari lalu", "1 Minggu lalu", "1 Bulan lalu" }));
        filterDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterDateActionPerformed(evt);
            }
        });

        pilih_pengunjung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Category age --", "dewasa", "remaja", "anak-anak" }));
        pilih_pengunjung.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pilih_pengunjung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilih_pengunjungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btn_panel_pengunjungLayout = new javax.swing.GroupLayout(btn_panel_pengunjung);
        btn_panel_pengunjung.setLayout(btn_panel_pengunjungLayout);
        btn_panel_pengunjungLayout.setHorizontalGroup(
            btn_panel_pengunjungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_panel_pengunjungLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search_pengunjung, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print_pengunjung, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pilih_pengunjung, 0, 149, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(filterDate, 0, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        btn_panel_pengunjungLayout.setVerticalGroup(
            btn_panel_pengunjungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_panel_pengunjungLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_panel_pengunjungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filterDate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(btn_panel_pengunjungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(search_pengunjung)
                        .addComponent(print_pengunjung, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(pilih_pengunjung, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_panel_peminjaman.setBackground(new java.awt.Color(255, 255, 255));
        btn_panel_peminjaman.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                btn_panel_peminjamanAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        search_peminjaman.setText("Search peminjaman");
        search_peminjaman.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search_peminjamanFocusGained(evt);
            }
        });
        search_peminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_peminjamanActionPerformed(evt);
            }
        });
        search_peminjaman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_peminjamanKeyTyped(evt);
            }
        });

        print_peminjaman.setBackground(new java.awt.Color(64, 142, 249));
        print_peminjaman.setForeground(new java.awt.Color(255, 255, 255));
        print_peminjaman.setText("PRINT");
        print_peminjaman.setFont(new java.awt.Font("Lexend Deca SemiBold", 0, 12)); // NOI18N
        print_peminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_peminjamanActionPerformed(evt);
            }
        });

        filterDatePeminjaman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- by tanggal --", "Hari ini", "Kemarin", "3 Hari lalu", "1 Minggu lalu", "1 Bulan lalu" }));
        filterDatePeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterDatePeminjamanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btn_panel_peminjamanLayout = new javax.swing.GroupLayout(btn_panel_peminjaman);
        btn_panel_peminjaman.setLayout(btn_panel_peminjamanLayout);
        btn_panel_peminjamanLayout.setHorizontalGroup(
            btn_panel_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_panel_peminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search_peminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print_peminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterDatePeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btn_panel_peminjamanLayout.setVerticalGroup(
            btn_panel_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_panel_peminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_panel_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search_peminjaman)
                    .addComponent(filterDatePeminjaman)
                    .addComponent(print_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_panel_pengembalian.setBackground(new java.awt.Color(255, 255, 255));

        search_pengembalian.setText("Search Pengembalian");
        search_pengembalian.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search_pengembalianFocusGained(evt);
            }
        });
        search_pengembalian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_pengembalianKeyTyped(evt);
            }
        });

        print_pengembalian.setBackground(new java.awt.Color(64, 142, 249));
        print_pengembalian.setForeground(new java.awt.Color(255, 255, 255));
        print_pengembalian.setText("PRINT");
        print_pengembalian.setFont(new java.awt.Font("Lexend Deca SemiBold", 0, 12)); // NOI18N
        print_pengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_pengembalianActionPerformed(evt);
            }
        });

        filterDatePengembalian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- by tanggal --", "Hari ini", "Kemarin", "3 Hari lalu", "1 Minggu lalu", "1 Bulan lalu" }));
        filterDatePengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterDatePengembalianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btn_panel_pengembalianLayout = new javax.swing.GroupLayout(btn_panel_pengembalian);
        btn_panel_pengembalian.setLayout(btn_panel_pengembalianLayout);
        btn_panel_pengembalianLayout.setHorizontalGroup(
            btn_panel_pengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_panel_pengembalianLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search_pengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print_pengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterDatePengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btn_panel_pengembalianLayout.setVerticalGroup(
            btn_panel_pengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_panel_pengembalianLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_panel_pengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search_pengembalian)
                    .addComponent(filterDatePengembalian)
                    .addComponent(print_pengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_panel_denda.setBackground(new java.awt.Color(255, 255, 255));

        search_denda.setText("Search Denda");

        print_denda.setBackground(new java.awt.Color(64, 142, 249));
        print_denda.setForeground(new java.awt.Color(255, 255, 255));
        print_denda.setText("PRINT");
        print_denda.setFont(new java.awt.Font("Lexend Deca SemiBold", 0, 12)); // NOI18N
        print_denda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_dendaActionPerformed(evt);
            }
        });

        pilih_denda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout btn_panel_dendaLayout = new javax.swing.GroupLayout(btn_panel_denda);
        btn_panel_denda.setLayout(btn_panel_dendaLayout);
        btn_panel_dendaLayout.setHorizontalGroup(
            btn_panel_dendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_panel_dendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search_denda, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print_denda, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pilih_denda, 0, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(date_denda, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );
        btn_panel_dendaLayout.setVerticalGroup(
            btn_panel_dendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_panel_dendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_panel_dendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search_denda)
                    .addComponent(date_denda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pilih_denda)
                    .addComponent(print_denda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout btn_panelLayout = new javax.swing.GroupLayout(btn_panel);
        btn_panel.setLayout(btn_panelLayout);
        btn_panelLayout.setHorizontalGroup(
            btn_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(btn_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btn_panelLayout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addGroup(btn_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_panel_pengunjung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_panel_peminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_panel_pengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_panel_denda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(12, 12, 12)))
        );
        btn_panelLayout.setVerticalGroup(
            btn_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(btn_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btn_panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btn_panel_pengunjung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btn_panel_pengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btn_panel_denda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btn_panel_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        table_pengunjung.setModel(new javax.swing.table.DefaultTableModel(
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
        table_pengunjung.setFont(new java.awt.Font("Lexend Deca Medium", 0, 14)); // NOI18N
        table_pengunjung.setGridColor(new java.awt.Color(255, 255, 255));
        table_pengunjung.setHeaderAlignment(2);
        table_pengunjung.setHeaderBackgroundColor(new java.awt.Color(23, 48, 82));
        table_pengunjung.setHeaderForegroundColor(new java.awt.Color(255, 255, 255));
        table_container1.setViewportView(table_pengunjung);

        table_peminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        table_peminjaman.setFont(new java.awt.Font("Lexend Deca Medium", 0, 14)); // NOI18N
        table_peminjaman.setGridColor(new java.awt.Color(255, 255, 255));
        table_peminjaman.setHeaderAlignment(2);
        table_peminjaman.setHeaderBackgroundColor(new java.awt.Color(23, 48, 82));
        table_peminjaman.setHeaderForegroundColor(new java.awt.Color(255, 255, 255));
        table_container2.setViewportView(table_peminjaman);

        table_pengembalian.setModel(new javax.swing.table.DefaultTableModel(
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
        table_pengembalian.setFont(new java.awt.Font("Lexend Deca Medium", 0, 14)); // NOI18N
        table_pengembalian.setGridColor(new java.awt.Color(255, 255, 255));
        table_pengembalian.setHeaderAlignment(2);
        table_pengembalian.setHeaderBackgroundColor(new java.awt.Color(23, 48, 82));
        table_pengembalian.setHeaderForegroundColor(new java.awt.Color(255, 255, 255));
        table_container3.setViewportView(table_pengembalian);

        table_denda.setModel(new javax.swing.table.DefaultTableModel(
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
        table_denda.setFont(new java.awt.Font("Lexend Deca Medium", 0, 14)); // NOI18N
        table_denda.setGridColor(new java.awt.Color(255, 255, 255));
        table_denda.setHeaderAlignment(2);
        table_denda.setHeaderBackgroundColor(new java.awt.Color(23, 48, 82));
        table_denda.setHeaderForegroundColor(new java.awt.Color(255, 255, 255));
        table_container4.setViewportView(table_denda);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(table_container1)
                    .addComponent(table_container2, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
                    .addComponent(table_container3)
                    .addComponent(table_container4))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(table_container1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table_container2, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table_container3, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table_container4, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        pengunjung_btn.setBackground(new java.awt.Color(64, 142, 249));
        pengunjung_btn.setForeground(new java.awt.Color(255, 255, 255));
        pengunjung_btn.setText("Laporan Pengunjung");
        pengunjung_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengunjung_btnActionPerformed(evt);
            }
        });

        denda_btn.setBackground(new java.awt.Color(64, 142, 249));
        denda_btn.setForeground(new java.awt.Color(255, 255, 255));
        denda_btn.setText("Laporan Denda");
        denda_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denda_btnActionPerformed(evt);
            }
        });

        peminjaman_btn.setBackground(new java.awt.Color(64, 142, 249));
        peminjaman_btn.setForeground(new java.awt.Color(255, 255, 255));
        peminjaman_btn.setText("Laporan Peminjaman");
        peminjaman_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peminjaman_btnActionPerformed(evt);
            }
        });

        pengembalian_btn.setBackground(new java.awt.Color(64, 142, 249));
        pengembalian_btn.setForeground(new java.awt.Color(255, 255, 255));
        pengembalian_btn.setText("Laporan Pengembalian");
        pengembalian_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengembalian_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pengunjung_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(peminjaman_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(denda_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pengembalian_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pengunjung_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(peminjaman_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pengembalian_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(denda_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pengunjung_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengunjung_btnActionPerformed
        // TODO add your handling code here:
        Object[] Baris ={"ID Pengunjung","Nama Pengunjung","Usia","Kategori Usia",
            "Alamat","No Telepon","Tanggal Input"};
        tabmode = new DefaultTableModel(null, Baris);
        table_pengunjung.setModel(tabmode);  
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
        }catch (Exception e) {
        } 
        
        btn_panel_denda.setVisible(false);
        btn_panel_pengunjung.setVisible(true);
        btn_panel_pengembalian.setVisible(false);
        btn_panel_peminjaman.setVisible(false);
                
        
        table_container1.setVisible(true);
        table_container2.setVisible(false);
        table_container3.setVisible(false);
        table_container4.setVisible(false);
        
    }//GEN-LAST:event_pengunjung_btnActionPerformed

    private void peminjaman_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peminjaman_btnActionPerformed
        // TODO add your handling code here:
        Object[] Baris ={"ID",
                        "ID Buku",
                        "Judul Buku",
                        "Id Pengunjung",
                        "Nama pengunjung",
                        "Id Pustakawan",
                        "Tanggal pinjam",
                        "Tanggal pengembalian"};
        tabmode = new DefaultTableModel(null, Baris);
        table_peminjaman.setModel(tabmode);
        String sql = "select * from datapeminjaman";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("id");
                String b = hasil.getString("id_buku");
                String c = hasil.getString("judul");
                String d = hasil.getString("id_pengunjung");
                String e = hasil.getString("Nama_pengunjung");
                String f = hasil.getString("id_pustakawan");
                String g = hasil.getString("tanggal_pinjam");
                String h = hasil.getString("tanggal_pengembalian");
                
                
                String[] data={a,b,c,d,e,f,g,h};
                tabmode.addRow(data);
            }
        } catch (Exception e){
        }
        
        
        btn_panel_denda.setVisible(false);
        btn_panel_pengunjung.setVisible(false);
        btn_panel_pengembalian.setVisible(false);
        btn_panel_peminjaman.setVisible(true);
                
        
        table_container1.setVisible(false);
        table_container2.setVisible(true);
        table_container3.setVisible(false);
        table_container4.setVisible(false);
        
        
    }//GEN-LAST:event_peminjaman_btnActionPerformed

    private void pengembalian_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengembalian_btnActionPerformed
        // TODO add your handling code here:
        Object[] Baris ={"ID peminjaman",
                        "Nama Pengunjung",
                        "Judul Buku",
                        "Tanggal peminjaman",
                        "Tanggal pengembalian"};
        tabmode = new DefaultTableModel(null, Baris);
        table_pengembalian.setModel(tabmode);
        String sql = "select * from datapengembalian";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("id_peminjaman");
                String b = hasil.getString("nama_pengunjung");
                String c = hasil.getString("judul_buku");
                String d = hasil.getString("tanggal_peminjaman");
                String e = hasil.getString("tanggal_pengembaliann");
             
                
                
                String[] data={a,b,c,d,e};
                tabmode.addRow(data);
            }
        } catch (Exception e){
        }
        
        btn_panel_denda.setVisible(false);
        btn_panel_pengunjung.setVisible(false);
        btn_panel_pengembalian.setVisible(true);
        btn_panel_peminjaman.setVisible(false);
                
        
        table_container1.setVisible(false);
        table_container2.setVisible(false);
        table_container3.setVisible(true);
        table_container4.setVisible(false);
    }//GEN-LAST:event_pengembalian_btnActionPerformed

    private void denda_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denda_btnActionPerformed
        // TODO add your handling code here:
        Object[] Baris ={"Id Denda",
                        "Nama Pengunjung",
                        "Nama Pegawai",
                        "Tanggal Pengembalian",
                        "Telat Pengembalian",
                        "Harga Denda",
                        "Judul Buku",
                        "Waktu Tgl Pinjam",
                        "Waktu Tgl Kembali"};
        tabmode = new DefaultTableModel(null, Baris);
        table_denda.setModel(tabmode);
        String sql = "select * from datadenda";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("id_denda");
                String b = hasil.getString("nama_pengunjung");
                String c = hasil.getString("nama_pegawai");
                String d = hasil.getString("tgl_pengembalian");
                String e = hasil.getString("telat_pengembalian");
                String f = hasil.getString("harga_denda");
                String g = hasil.getString("judul_buku");
                String h = hasil.getString("tglpinjam_sblmnya");
                String i = hasil.getString("tglkembali_sblmnya");
             
                
                
                String[] data={a,b,c,d,e,f,g,h,i};
                tabmode.addRow(data);
            }
        } catch (Exception e){
        }
         btn_panel_denda.setVisible(true);
        btn_panel_pengunjung.setVisible(false);
        btn_panel_pengembalian.setVisible(false);
        btn_panel_peminjaman.setVisible(false);
                
        
        table_container1.setVisible(false);
        table_container2.setVisible(false);
        table_container3.setVisible(false);
        table_container4.setVisible(true);
    }//GEN-LAST:event_denda_btnActionPerformed

    private void print_pengunjungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_pengunjungActionPerformed
        // TODO add your handling code here:
        
        
        String choose = "-- Category age --";
        String tgl = "-- by tanggal --";
        String search = "Search Pengunjung";
        
        String url = "src/lapor/reportpengunjung/reportpeng.jrxml";
        String urlDate = "src/lapor/reportpengunjung/reportpeng-date.jrxml";
        String urlAll = "src/lapor/reportpengunjung/reportpeng-all.jrxml";
            
        if ( pilih_pengunjung.getSelectedItem().toString() != choose ) {
            printByFilter(pilih_pengunjung.getSelectedItem().toString(), search_pengunjung.getText(),"search_pengunjung", url);
        } else if (filterDate.getSelectedItem().toString() != tgl  ) {
            printByDate(filterDate.getSelectedItem().toString(), urlDate);
        }
        else if ( (!search_pengunjung.equals("Search Pengunjung") && !search_pengunjung.equals("") )) {
            printByFilter(pilih_pengunjung.getSelectedItem().toString(), search_pengunjung.getText(),"search_pengunjung", url);
        }else  {
            printAll(urlAll); 
        }
        
        resetPengunjung();

    }//GEN-LAST:event_print_pengunjungActionPerformed

    private void print_peminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_peminjamanActionPerformed
        // TODO add your handling code here:
        String tgl = "-- by tanggal --";
        
        String url = "src/lapor/reportpeminjaman/reportpeminjaman.jrxml";
//        String urlDate = "src/lapor/reportpengunjung/reportpeng-date.jrxml";
        
        if (filterDatePeminjaman.getSelectedItem().toString() != tgl  ) 
        {
            printByDate(filterDatePeminjaman.getSelectedItem().toString(), url);
        } 
        else if  ( (!search_peminjaman.equals("Search Peminjaman") && !search_peminjaman.equals("") ))
        {
            printByFilter(null, search_peminjaman.getText(),"name",url);
        }
        else  {
            printAll(url); 
        }
        resetPeminjaman();
        
    }//GEN-LAST:event_print_peminjamanActionPerformed

    public void resetPeminjaman() {
        search_peminjaman.setText("Search Peminjaman");
        filterDatePeminjaman.setSelectedIndex(0);
    }
    
    private void print_pengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_pengembalianActionPerformed
        // TODO add your handling code here:
        String tgl = "-- by tanggal --";
        
        String url = "src/lapor/reportpengembalian/reportpengembalian.jrxml";
//        String urlDate = "src/lapor/reportpengunjung/reportpeng-date.jrxml";
        
            if (filterDatePengembalian.getSelectedItem().toString() != tgl  ) 
                {
                    printByDate(filterDatePengembalian.getSelectedItem().toString(), url);
                } 
            else if  ( (!search_pengembalian.equals("Search Pengembalian") && !search_pengembalian.equals("") ))
                {
                    printByFilter(null, search_pengembalian.getText(),"name",url);
                }
            else  {
                printAll(url); 
            }
        resetPengembalian();  
    }//GEN-LAST:event_print_pengembalianActionPerformed

    private void print_dendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_dendaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_print_dendaActionPerformed

    private void btn_panel_peminjamanAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btn_panel_peminjamanAncestorAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_panel_peminjamanAncestorAdded

    private void search_pengunjungKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_pengunjungKeyTyped
        // TODO add your handling code here:
        Object[] Baris ={"ID Pengunjung","Nama Pengunjung","Usia","Kategori Usia",
            "Alamat","No Telepon","Tanggal Input"};
        
        tabmode = new DefaultTableModel(null, Baris);
        table_pengunjung.setModel(tabmode); 
        String sql = "select * from datapengunjung where nama like '%"+search_pengunjung.getText()+
                "%' OR id like '%"+search_pengunjung.getText()+"%'";
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
            }catch (Exception e) {
            } 
    }//GEN-LAST:event_search_pengunjungKeyTyped

    private void pilih_pengunjungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilih_pengunjungActionPerformed
        // TODO add your handling code here:
        String choose = "-- Category age --";
        
        if ( (pilih_pengunjung.getSelectedItem().toString() == choose) || (search_pengunjung.getText() == "")) {
            Object[] Baris ={"ID Pengunjung","Nama Pengunjung","Alamat","Usia","Kategori Usia","No Telepon","Tanggal Input"};
        tabmode = new DefaultTableModel(null, Baris);
        table_pengunjung.setModel(tabmode);  
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
            }catch (Exception e) {
            } 
        }  else if (pilih_pengunjung.getSelectedItem().toString() != choose) {
            Object[] Baris ={"ID Pengunjung","Nama Pengunjung","Alamat",
                "Usia","Kategori Usia","No Telepon","Tanggal Input"};
            
            tabmode = new DefaultTableModel(null, Baris);
            table_pengunjung.setModel(tabmode);  
            String sql = "select * from datapengunjung where category_age = '"
                    + ""+pilih_pengunjung.getSelectedItem().toString()+"'";
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
            }catch (Exception e) {
            } 
        }
        
        
    }//GEN-LAST:event_pilih_pengunjungActionPerformed

    private void search_pengunjungMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_pengunjungMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_search_pengunjungMouseEntered

    private void search_pengunjungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_pengunjungMouseClicked
        // TODO add your handling code here:
//        search_pengunjung.setText("");
    }//GEN-LAST:event_search_pengunjungMouseClicked

    private void search_pengunjungFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search_pengunjungFocusGained
        // TODO add your handling code here:
        search_pengunjung.setText("");
    }//GEN-LAST:event_search_pengunjungFocusGained

    private void search_pengunjungFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search_pengunjungFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_search_pengunjungFocusLost

    private void filterDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterDateActionPerformed
        // TODO add your handling code here:
        
        String choose = "-- by tanggal --";
        
        if ( (filterDate.getSelectedItem().toString() == choose)) {
            Object[] Baris ={"ID Pengunjung","Nama Pengunjung","Alamat","Usia","Kategori Usia","No Telepon","Tanggal Input"};
        tabmode = new DefaultTableModel(null, Baris);
        table_pengunjung.setModel(tabmode);  
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
            }catch (Exception e) {
            } 
        }  else if (filterDate.getSelectedItem().toString() != choose) {
            Object[] Baris ={"ID Pengunjung","Nama Pengunjung","Alamat",
                "Usia","Kategori Usia","No Telepon","Tanggal Input"};
            
            tabmode = new DefaultTableModel(null, Baris);
            table_pengunjung.setModel(tabmode);  
            String sql="";
            
            if (filterDate.getSelectedItem().toString()=="Hari ini") {
                sql = "SELECT * FROM datapengunjung WHERE DATE(tanggal) = CURDATE()";
            } else if (filterDate.getSelectedItem().toString()=="Kemarin") {
                sql = "SELECT * FROM datapengunjung WHERE DATE(tanggal) BETWEEN CURDATE() - INTERVAL 1 DAY AND CURDATE();";
            } else if (filterDate.getSelectedItem().toString()=="3 Hari lalu") {
                sql = "SELECT * FROM datapengunjung WHERE DATE(tanggal) BETWEEN CURDATE() - INTERVAL 3 DAY AND CURDATE();";
            } else if (filterDate.getSelectedItem().toString()=="1 Minggu lalu") {
                sql = "SELECT * FROM datapengunjung WHERE DATE(tanggal) BETWEEN CURDATE() - INTERVAL 7 DAY AND CURDATE();";
            } else if (filterDate.getSelectedItem().toString()=="1 Bulan lalu") {
                sql = "SELECT * FROM datapengunjung WHERE DATE(tanggal) BETWEEN CURDATE() - INTERVAL 1 MONTH AND CURDATE();";
            }
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
            }catch (Exception e) {
            }
        } 
    }//GEN-LAST:event_filterDateActionPerformed

    private void search_peminjamanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_peminjamanKeyTyped
        // TODO add your handling code here:
        Object[] Baris ={"ID",
                        "ID Buku",
                        "Judul Buku",
                        "Id Pengunjung",
                        "Nama pengunjung",
                        "Id Pustakawan",
                        "Tanggal pinjam",
                        "Tanggal pengembalian"};
        tabmode = new DefaultTableModel(null, Baris);
        table_peminjaman.setModel(tabmode);
        String sql = "select * from datapeminjaman WHERE Nama_pengunjung LIKE '%"+
                search_peminjaman.getText()+"%';";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("id");
                String b = hasil.getString("id_buku");
                String c = hasil.getString("judul");
                String d = hasil.getString("id_pengunjung");
                String e = hasil.getString("Nama_pengunjung");
                String f = hasil.getString("id_pustakawan");
                String g = hasil.getString("tanggal_pinjam");
                String h = hasil.getString("tanggal_pengembalian");
                
                
                String[] data={a,b,c,d,e,f,g,h};
                tabmode.addRow(data);
            }
        } catch (Exception e){
        }
    }//GEN-LAST:event_search_peminjamanKeyTyped

    private void search_peminjamanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search_peminjamanFocusGained
        // TODO add your handling code here:
        search_peminjaman.setText("");
    }//GEN-LAST:event_search_peminjamanFocusGained

    private void filterDatePeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterDatePeminjamanActionPerformed
        // TODO add your handling code here:
        String choose = "-- by tanggal --";
        
        if ( (filterDatePeminjaman.getSelectedItem().toString() == choose)) {
            Object[] Baris ={"ID",
                            "ID Buku",
                            "Judul Buku",
                            "Id Pengunjung",
                            "Nama pengunjung",
                            "Id Pustakawan",
                            "Tanggal pinjam",
                            "Tanggal pengembalian"};
            tabmode = new DefaultTableModel(null, Baris);
            table_peminjaman.setModel(tabmode);
            String sql = "select * from datapeminjaman";
            try {
                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    String a = hasil.getString("id");
                    String b = hasil.getString("id_buku");
                    String c = hasil.getString("judul");
                    String d = hasil.getString("id_pengunjung");
                    String e = hasil.getString("Nama_pengunjung");
                    String f = hasil.getString("id_pustakawan");
                    String g = hasil.getString("tanggal_pinjam");
                    String h = hasil.getString("tanggal_pengembalian");


                    String[] data={a,b,c,d,e,f,g,h};
                    tabmode.addRow(data);
                }
            } catch (Exception e){
            }
        } else if (filterDatePeminjaman.getSelectedItem().toString() != choose) {
            Object[] Baris ={"ID",
                            "ID Buku",
                            "Judul Buku",
                            "Id Pengunjung",
                            "Nama pengunjung",
                            "Id Pustakawan",
                            "Tanggal pinjam",
                            "Tanggal pengembalian"};
            tabmode = new DefaultTableModel(null, Baris);
            table_peminjaman.setModel(tabmode);
            String sql="";
            
            if (filterDatePeminjaman.getSelectedItem().toString()=="Hari ini") {
                sql = "select * from datapeminjaman WHERE DATE(tgl_input) = CURDATE()";
            } else if (filterDatePeminjaman.getSelectedItem().toString()=="Kemarin") {
                sql = "select * from datapeminjaman WHERE DATE(tgl_input) BETWEEN CURDATE() - INTERVAL 1 DAY AND CURDATE();";
            } else if (filterDatePeminjaman.getSelectedItem().toString()=="3 Hari lalu") {
                sql = "select * from datapeminjaman WHERE DATE(tgl_input) BETWEEN CURDATE() - INTERVAL 3 DAY AND CURDATE();";
            } else if (filterDatePeminjaman.getSelectedItem().toString()=="1 Minggu lalu") {
                sql = "select * from datapeminjaman WHERE DATE(tgl_input) BETWEEN CURDATE() - INTERVAL 7 DAY AND CURDATE();";
            } else if (filterDatePeminjaman.getSelectedItem().toString()=="1 Bulan lalu") {
                sql = "select * from datapeminjaman WHERE DATE(tgl_input) BETWEEN CURDATE() - INTERVAL 1 MONTH AND CURDATE();";
            }
            try {
                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    String a = hasil.getString("id");
                    String b = hasil.getString("id_buku");
                    String c = hasil.getString("judul");
                    String d = hasil.getString("id_pengunjung");
                    String e = hasil.getString("Nama_pengunjung");
                    String f = hasil.getString("id_pustakawan");
                    String g = hasil.getString("tanggal_pinjam");
                    String h = hasil.getString("tanggal_pengembalian");


                    String[] data={a,b,c,d,e,f,g,h};
                    tabmode.addRow(data);
                }
            } catch (Exception e){
            }
        }
    }//GEN-LAST:event_filterDatePeminjamanActionPerformed

    private void search_peminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_peminjamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_peminjamanActionPerformed

    private void search_pengembalianFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search_pengembalianFocusGained
        // TODO add your handling code here:
        search_pengembalian.setText("");
    }//GEN-LAST:event_search_pengembalianFocusGained

    private void filterDatePengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterDatePengembalianActionPerformed
        // TODO add your handling code here:
        String choose = "-- by tanggal --";
        
        if ( (filterDatePengembalian.getSelectedItem().toString() == choose)) {
            Object[] Baris ={"ID peminjaman",
                        "Nama Pengunjung",
                        "Judul Buku",
                        "Tanggal peminjaman",
                        "Tanggal pengembalian"};
            tabmode = new DefaultTableModel(null, Baris);
            table_pengembalian.setModel(tabmode);
            String sql = "select * from datapengembalian";
            try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    String a = hasil.getString("id_peminjaman");
                    String b = hasil.getString("nama_pengunjung");
                    String c = hasil.getString("judul_buku");
                    String d = hasil.getString("tanggal_peminjaman");
                    String e = hasil.getString("tanggal_pengembaliann");



                    String[] data={a,b,c,d,e};
                    tabmode.addRow(data);
                }
            } catch (Exception e){
            }
        } else if (filterDatePeminjaman.getSelectedItem().toString() != choose) {
            Object[] Baris ={"ID peminjaman",
                        "Nama Pengunjung",
                        "Judul Buku",
                        "Tanggal peminjaman",
                        "Tanggal pengembalian"};
            tabmode = new DefaultTableModel(null, Baris);
            table_pengembalian.setModel(tabmode);
            String sql="";
            if (filterDatePengembalian.getSelectedItem().toString()=="Hari ini") {
                sql = "select * from datapengembalian WHERE DATE(tgl_input) = CURDATE()";
            } else if (filterDatePengembalian.getSelectedItem().toString()=="Kemarin") {
                sql = "select * from datapengembalian WHERE DATE(tgl_input) BETWEEN CURDATE() - INTERVAL 1 DAY AND CURDATE();";
            } else if (filterDatePengembalian.getSelectedItem().toString()=="3 Hari lalu") {
                sql = "select * from datapengembalian WHERE DATE(tgl_input) BETWEEN CURDATE() - INTERVAL 3 DAY AND CURDATE();";
            } else if (filterDatePengembalian.getSelectedItem().toString()=="1 Minggu lalu") {
                sql = "select * from datapengembalian WHERE DATE(tgl_input) BETWEEN CURDATE() - INTERVAL 7 DAY AND CURDATE();";
            } else if (filterDatePengembalian.getSelectedItem().toString()=="1 Bulan lalu") {
                sql = "select * from datapengembalian WHERE DATE(tgl_input) BETWEEN CURDATE() - INTERVAL 1 MONTH AND CURDATE();";
            }
            try {
                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    
                String a = hasil.getString("id_peminjaman");
                String b = hasil.getString("nama_pengunjung");
                String c = hasil.getString("judul_buku");
                String d = hasil.getString("tanggal_peminjaman");
                String e = hasil.getString("tanggal_pengembaliann");
             
                
                
                String[] data={a,b,c,d,e};
                tabmode.addRow(data);
                }
            } catch (Exception e){
            }
        }
    }//GEN-LAST:event_filterDatePengembalianActionPerformed

    private void search_pengembalianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_pengembalianKeyTyped
        // TODO add your handling code here:
       Object[] Baris ={"ID peminjaman",
                        "Nama Pengunjung",
                        "Judul Buku",
                        "Tanggal peminjaman",
                        "Tanggal pengembalian"};
            tabmode = new DefaultTableModel(null, Baris);
            table_pengembalian.setModel(tabmode);
        String sql = "select * from datapengembalian WHERE nama_pengunjung LIKE '%"+
                search_pengembalian.getText()+"%';";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                 String a = hasil.getString("id_peminjaman");
                String b = hasil.getString("nama_pengunjung");
                String c = hasil.getString("judul_buku");
                String d = hasil.getString("tanggal_peminjaman");
                String e = hasil.getString("tanggal_pengembaliann");
                
                String[] data={a,b,c,d,e};
                tabmode.addRow(data);
            }
        } catch (Exception e){
        }
    }//GEN-LAST:event_search_pengembalianKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_panel;
    private javax.swing.JPanel btn_panel_denda;
    private javax.swing.JPanel btn_panel_peminjaman;
    private javax.swing.JPanel btn_panel_pengembalian;
    private javax.swing.JPanel btn_panel_pengunjung;
    private com.toedter.calendar.JDateChooser date_denda;
    private custom.CustomRoundedButton denda_btn;
    private javax.swing.JComboBox<String> filterDate;
    private javax.swing.JComboBox<String> filterDatePeminjaman;
    private javax.swing.JComboBox<String> filterDatePengembalian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private custom.CustomRoundedButton peminjaman_btn;
    private custom.CustomRoundedButton pengembalian_btn;
    private custom.CustomRoundedButton pengunjung_btn;
    private javax.swing.JComboBox<String> pilih_denda;
    private javax.swing.JComboBox<String> pilih_pengunjung;
    private custom.CustomRoundedButton print_denda;
    private custom.CustomRoundedButton print_peminjaman;
    private custom.CustomRoundedButton print_pengembalian;
    private custom.CustomRoundedButton print_pengunjung;
    private javax.swing.JTextField search_denda;
    private javax.swing.JTextField search_peminjaman;
    private javax.swing.JTextField search_pengembalian;
    private javax.swing.JTextField search_pengunjung;
    private javax.swing.JScrollPane table_container1;
    private javax.swing.JScrollPane table_container2;
    private javax.swing.JScrollPane table_container3;
    private javax.swing.JScrollPane table_container4;
    private custom.CustomRoundedTable table_denda;
    private custom.CustomRoundedTable table_peminjaman;
    private custom.CustomRoundedTable table_pengembalian;
    private custom.CustomRoundedTable table_pengunjung;
    // End of variables declaration//GEN-END:variables
}
