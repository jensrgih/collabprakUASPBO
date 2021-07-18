import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ASUS ROG
 */
public class formPasien extends javax.swing.JFrame {
private Connection con;
private Statement st;
private ResultSet RsPasien;
private String sql="";

private String kode, jeniskel, nama, nohp, kk, alamat;
    /**
     * Creates new form 
     */
    public formPasien() {
        initComponents();
        koneksitabel();
        tampildata("SELECT * FROM tabel_pasien");
    }
    private void form_awal(){
        form_disable();
        form_clear(); 
        Btn_Simpan.setText("Simpan");
        Btn_Tambah.requestFocus(true);
        Btn_Tambah.setEnabled(true);
        Btn_Simpan.setEnabled(false);
        Btn_Batal.setEnabled(false);
        Btn_Hapus.setEnabled(false);
        Btn_Ubah.setEnabled(false);
        
    }
  private void form_disable(){
        Txt_kodepasien.setEnabled(false);
        Txt_namapasien.setEnabled(false);
        Txt_alamatpasien.setEnabled(false);
        Txt_kk.setEnabled(false);
       Txt_nohp.setEnabled(false);
        Cmb_jeniskelamin.setEnabled(false);
  }
  private void form_enable(){
      Txt_alamatpasien.setEnabled(true);
        Txt_kk.setEnabled(true);
        Txt_kodepasien.setEnabled(true);
        Txt_namapasien.setEnabled(true);
       Txt_nohp.setEnabled(true);
        Cmb_jeniskelamin.setEnabled(true);
  }
      private void form_clear(){
       Txt_kodepasien.setText("");
       Txt_alamatpasien.setText("");
       Txt_kk.setText("");
         Txt_namapasien.setText("");
         Txt_nohp.setText("");
         Cmb_jeniskelamin.setSelectedItem("Pilih");
      }
        private void aksi_tambah(){
        form_enable();
        Btn_Tambah.setEnabled(true);
        Btn_Simpan.setEnabled(true);
        Btn_Ubah.setEnabled(true);
        Btn_Batal.setEnabled(true);
        Btn_Hapus.setEnabled(false);
        
        Txt_kodepasien.requestFocus(true);
        }
    private void koneksitabel (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql:"
                    + "//localhost:3306/db_rumahsakit", "root", "");
            System.out.println("KONEKSI BERHASIL");
            
        } catch (Exception e) {
            System.out.println("KONEKSI GAGAL \n"+e);
        }
    }
    private void tampildata(String sql){
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("No");
        datalist.addColumn("Kode Pasien");
        datalist.addColumn("Nama Pasien");
        datalist.addColumn("Alamat Pasien");
        datalist.addColumn("Tanggal Lahir");
        datalist.addColumn("Jenis Kelamin");
        datalist.addColumn("Kepala Keluarga");
        datalist.addColumn("Handphone");
        try {
            int i = 1;
            st=con.createStatement();
            RsPasien=st.executeQuery("SELECT * FROM tabel_pasien");
            while (RsPasien.next()){
                datalist.addRow(new Object[]{
                    (""+i++),RsPasien.getString(1), RsPasien.getString(2), 
                    RsPasien.getString(3), RsPasien.getString(4), RsPasien.getString(5), 
                    RsPasien.getString(6), RsPasien.getString(7)
                });
                Gridpasien.setModel(datalist);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "GAGAL TAMPIL \n"+e.getMessage());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Txt_kodepasien = new javax.swing.JTextField();
        Txt_namapasien = new javax.swing.JTextField();
        Txt_nohp = new javax.swing.JTextField();
        Cmb_jeniskelamin = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Gridpasien = new javax.swing.JTable();
        Btn_Simpan = new javax.swing.JButton();
        Btn_Ubah = new javax.swing.JButton();
        Btn_Hapus = new javax.swing.JButton();
        Btn_Batal = new javax.swing.JButton();
        Btn_lanjut = new javax.swing.JButton();
        Btn_Tambah = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        Txt_kk = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Txt_alamatpasien = new javax.swing.JTextField();
        Tanggal_lahir = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon0/&System&Library&CoreServices&CoreTypes 67.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 120));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon0/Help 1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 8, 120, 120));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setText("RS. Syafira");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 510, 40));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Siap Melayani Anda 24 Jam");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 176, 12));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Jalan Farel Subagiyo No.28");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, 20));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Call Center  0998-878780");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 170, 20));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 980, 10));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Kode Pasien");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Nama Pasien");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Tanggal Lahir");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Jenis Kelamin");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("No Handphone");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        Txt_kodepasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txt_kodepasienKeyPressed(evt);
            }
        });
        jPanel1.add(Txt_kodepasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 160, 120, -1));
        jPanel1.add(Txt_namapasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 190, 120, -1));
        jPanel1.add(Txt_nohp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 120, -1));

        Cmb_jeniskelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Laki-laki", "Perempuan" }));
        jPanel1.add(Cmb_jeniskelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 120, -1));

        Gridpasien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Gridpasien);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 160, 710, 180));

        Btn_Simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/export-16x16.png"))); // NOI18N
        Btn_Simpan.setText("SIMPAN");
        Btn_Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SimpanActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, -1, -1));

        Btn_Ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/cut-16x16.png"))); // NOI18N
        Btn_Ubah.setText("UBAH");
        Btn_Ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_UbahActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, -1, -1));

        Btn_Hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/cancel-16x16.png"))); // NOI18N
        Btn_Hapus.setText("HAPUS");
        Btn_Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_HapusActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, -1, -1));

        Btn_Batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/refresh-16x16.png"))); // NOI18N
        Btn_Batal.setText("BATAL");
        Btn_Batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BatalActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, 90, -1));

        Btn_lanjut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/forward-16x16.png"))); // NOI18N
        Btn_lanjut.setText("NEXT");
        Btn_lanjut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_lanjutActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_lanjut, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 350, 90, -1));

        Btn_Tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/add-16x16.png"))); // NOI18N
        Btn_Tambah.setText("TAMBAH");
        Btn_Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_TambahActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Kepala Keluarga");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));
        jPanel1.add(Txt_kk, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 120, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Alamat Pasien");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        jPanel1.add(Txt_alamatpasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 120, -1));
        jPanel1.add(Tanggal_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 120, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/print-16x16.png"))); // NOI18N
        jButton1.setText("CETAK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 980, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_BatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BatalActionPerformed
        // TODO add your handling code here:
        form_clear();
        Btn_Tambah.setEnabled(true);
        Btn_Simpan.setEnabled(true);
        Txt_kodepasien.requestFocus();
        Btn_Hapus.setEnabled(true);
        Txt_kodepasien.setEnabled(true);
       
    }//GEN-LAST:event_Btn_BatalActionPerformed

    private void Btn_lanjutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_lanjutActionPerformed
        // TODO add your handling code here:
        formPeriksa ad = new formPeriksa();
        ad.setVisible(true);
 
    }//GEN-LAST:event_Btn_lanjutActionPerformed

    private void Btn_SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SimpanActionPerformed
        // TODO add your handling code here:
       String Tanggal;
       
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
    Tanggal=format.format(Tanggal_lahir.getDate());
    kode=String.valueOf(Txt_kodepasien.getText());
    nama=String.valueOf(Txt_namapasien.getText());
    nohp=String.valueOf(Txt_nohp.getText());
    jeniskel=Cmb_jeniskelamin.getItemAt(Cmb_jeniskelamin.getSelectedIndex()).toString();
    kk=String.valueOf(Txt_kk.getText());
    alamat=String.valueOf(Txt_alamatpasien.getText());

        try {
            sql="INSERT INTO tabel_pasien(kode_pasien, "
                    + "nama_pasien, "
                    + "alamat_pasien, "
                    + "tanggal_lahir, "
                    + "jenis_kelamin, "
                    + "kepala_keluarga, "
                    + "handphone)VALUES"                   
                    + "('"+ kode +"',"
                    + "'"+ nama +"',"
                    + "'"+ alamat +"',"
                    + "'"+ Tanggal +"',"
                    + "'"+ jeniskel +"',"
                    + "'"+ kk +"',"
                    + "'"+ nohp +"')";
           st=con.createStatement();
            st.execute(sql);
            tampildata("Select * from tabel_pasien");
            form_awal();
            JOptionPane.showMessageDialog(null, 
                    "Data Tersimpan");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n"+e.getMessage());
        }
    }//GEN-LAST:event_Btn_SimpanActionPerformed

    private void Btn_UbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_UbahActionPerformed
        // TODO add your handling code here:
          String Tanggal;
       
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
    Tanggal=format.format(Tanggal_lahir.getDate());
    kode=String.valueOf(Txt_kodepasien.getText());
    nama=String.valueOf(Txt_namapasien.getText());
    nohp=String.valueOf(Txt_nohp.getText());
    jeniskel=Cmb_jeniskelamin.getItemAt(Cmb_jeniskelamin.getSelectedIndex()).toString();
    kk=String.valueOf(Txt_kk.getText());
    alamat=String.valueOf(Txt_alamatpasien.getText());
    try {
          sql ="UPDATE tabel_pasien set nama_pasien= '"+nama+"', "
                        + "alamat_pasien = '"+alamat+"', tanggal_lahir = '"+Tanggal+"', "
                        + "kepala_keluarga = '"+kk+"', handphone = '"+nohp+"' "
                        + "where kode_pasien ='"+kode+"'";
            st=con.createStatement();
            st.execute(sql);
            tampildata("Select * from tabel_pasien");
            form_awal();
            JOptionPane.showMessageDialog(null, 
                    "Data Berhasil Diubah");
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah \n"+e.getMessage());
        }
    }//GEN-LAST:event_Btn_UbahActionPerformed

    private void Txt_kodepasienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_kodepasienKeyPressed
        // TODO add your handling code here:
        kode=Txt_kodepasien.getText();
        int tekanenter=evt.getKeyCode();
        if (tekanenter==10){
            try {
                sql="Select * from tabel_pasien "
                        + "where kode_pasien='"+ kode +"'";
                st=con.createStatement();
                RsPasien=st.executeQuery(sql);
                while (RsPasien.next()) {
                   Txt_namapasien.setText(RsPasien.getString("nama_pasien"));
                   Txt_alamatpasien.setText(RsPasien.getString("alamat_pasien"));
                   Tanggal_lahir.setDate(RsPasien.getDate("tanggal_lahir"));
                   Cmb_jeniskelamin.setSelectedItem(RsPasien.getString("jenis_kelamin"));
                   Txt_kk.setText(RsPasien.getString("kepala_keluarga"));
                   Txt_nohp.setText(RsPasien.getString("handphone"));
                   JOptionPane.showMessageDialog(null,
                           "Data Ditemukan");
                   Btn_Tambah.setEnabled(false);
                   Btn_Simpan.setEnabled(false);
                   Btn_Hapus.setEnabled(true);
                   Txt_kodepasien.setEnabled(false);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan \n"+e.getMessage());
                Txt_kodepasien.requestFocus();
            }
        }
    }//GEN-LAST:event_Txt_kodepasienKeyPressed

    private void Btn_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_TambahActionPerformed
        // TODO add your handling code here:
        aksi_tambah();
    }//GEN-LAST:event_Btn_TambahActionPerformed

    private void Btn_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_HapusActionPerformed
        // TODO add your handling code here:
        kode=String.valueOf(Txt_kodepasien.getText());
      
        try {
            sql= "DELETE from tabel_pasien where kode_pasien = '"+kode+"'";
            st=con.createStatement();
            st.execute(sql);
            tampildata("Select * from tabel_pasien");
           form_awal();
            JOptionPane.showMessageDialog(null, 
                    "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n"+e.getMessage());
        }
    }//GEN-LAST:event_Btn_HapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try {
           InputStream is = paneldata.class.getResourceAsStream("/laporan/dataPasien.jasper");
           JasperPrint jsPrint = JasperFillManager.fillReport(is, null, config.configDB());
           JasperViewer.viewReport(jsPrint, false);
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "gagal mencetak laporan karena :"
              + e.getMessage(), "cetak laporan", JOptionPane.ERROR_MESSAGE);
       }
                   
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(formPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Batal;
    private javax.swing.JButton Btn_Hapus;
    private javax.swing.JButton Btn_Simpan;
    private javax.swing.JButton Btn_Tambah;
    private javax.swing.JButton Btn_Ubah;
    private javax.swing.JButton Btn_lanjut;
    private javax.swing.JComboBox<String> Cmb_jeniskelamin;
    private javax.swing.JTable Gridpasien;
    private com.toedter.calendar.JDateChooser Tanggal_lahir;
    private javax.swing.JTextField Txt_alamatpasien;
    private javax.swing.JTextField Txt_kk;
    private javax.swing.JTextField Txt_kodepasien;
    private javax.swing.JTextField Txt_namapasien;
    private javax.swing.JTextField Txt_nohp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
