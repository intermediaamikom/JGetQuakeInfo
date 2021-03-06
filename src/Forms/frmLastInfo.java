/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dwi Candra Permana
 */
public class frmLastInfo extends javax.swing.JFrame {
private frmDebug frmDebug;
    /**
     * Creates new form frmInfo
     */
    public frmLastInfo() {
        frmDebug = new frmDebug();
        initComponents();
        //loadInfo();
    }
    
    private void loadInfo() {
        try {
            File f = new File("src/Prefer/LastInfo.properties");
            FileReader in = new FileReader(f);
            Properties prop = new Properties();
            prop.load(in);
            
            String tgljam = prop.getProperty("DateTime");
            String kuat = prop.getProperty("Strength");
            String dalam = prop.getProperty("Depth");
            String geotag = prop.getProperty("Geo_Pos");
            String wil = prop.getProperty("Area");
            String potensi = prop.getProperty("Tsunami");
            String gifimg = prop.getProperty("GIF");
            
            datetime.setText(tgljam);
            strength.setText(kuat);
            depth.setText(dalam);
            geo.setText(geotag);
            area.setText(wil);
            tsunami.setText(potensi);
            
            datetime.setToolTipText(tgljam);
            strength.setToolTipText(kuat);
            depth.setToolTipText(dalam);
            geo.setToolTipText(geotag);
            area.setToolTipText(wil);
            tsunami.setToolTipText(potensi);
            
            in.close();
            prop.clear();
        } catch (IOException ex) {
                    String errTit = ex.getMessage();
                    JOptionPane.showMessageDialog(this, ex.getStackTrace(), errTit, JOptionPane.ERROR_MESSAGE);
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    ex.printStackTrace(w);
                    w.close();
                    String trace = cw.toString();
                    
                    frmDebug.setVisible(true);
                    frmDebug.log.setText(trace + "\n" + String.valueOf(System.getProperties()));
                    Logger.getLogger(frmConfig.class.getName()).log(Level.SEVERE, null, ex);
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

        gif = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tsunami = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        datetime = new javax.swing.JLabel();
        strength = new javax.swing.JLabel();
        depth = new javax.swing.JLabel();
        geo = new javax.swing.JLabel();
        area = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Last Information");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(523, 230));
        setResizable(false);
        setSize(new java.awt.Dimension(523, 230));
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(null);

        gif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/earthquake-128.png"))); // NOI18N
        getContentPane().add(gif);
        gif.setBounds(10, 20, 130, 128);

        jLabel2.setBackground(new java.awt.Color(255, 102, 102));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("JGetQuakeInfo - Ver. 1.1-alpha");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 10, 360, 20);

        tsunami.setBackground(new java.awt.Color(255, 255, 51));
        tsunami.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tsunami.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tsunami.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tsunami.setOpaque(true);
        getContentPane().add(tsunami);
        tsunami.setBounds(260, 130, 250, 20);

        jLabel4.setBackground(new java.awt.Color(0, 0, 153));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tanggal & Waktu");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(150, 30, 110, 20);

        jLabel5.setBackground(new java.awt.Color(0, 0, 153));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kekuatan");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(150, 50, 110, 20);

        jLabel6.setBackground(new java.awt.Color(0, 0, 153));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kedalaman");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(150, 70, 110, 20);

        jLabel7.setBackground(new java.awt.Color(0, 0, 153));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Letak Geografis");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(150, 90, 110, 20);

        jLabel8.setBackground(new java.awt.Color(0, 0, 153));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dirasakan");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(150, 110, 110, 20);

        jLabel9.setBackground(new java.awt.Color(0, 0, 153));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Keterangan");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(150, 130, 110, 20);

        datetime.setBackground(new java.awt.Color(255, 255, 51));
        datetime.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        datetime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datetime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        datetime.setOpaque(true);
        getContentPane().add(datetime);
        datetime.setBounds(260, 30, 250, 20);

        strength.setBackground(new java.awt.Color(255, 255, 51));
        strength.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        strength.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        strength.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        strength.setOpaque(true);
        getContentPane().add(strength);
        strength.setBounds(260, 50, 250, 20);

        depth.setBackground(new java.awt.Color(255, 255, 51));
        depth.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        depth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        depth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        depth.setOpaque(true);
        getContentPane().add(depth);
        depth.setBounds(260, 70, 250, 20);

        geo.setBackground(new java.awt.Color(255, 255, 51));
        geo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        geo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        geo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        geo.setOpaque(true);
        getContentPane().add(geo);
        geo.setBounds(260, 90, 250, 20);

        area.setBackground(new java.awt.Color(255, 255, 51));
        area.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        area.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        area.setOpaque(true);
        getContentPane().add(area);
        area.setBounds(260, 110, 250, 20);

        jLabel15.setText("(c) 2017. Dwi Candra Permana");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 180, 180, 14);

        jButton1.setText("Tutup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(431, 170, 80, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
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
            java.util.logging.Logger.getLogger(frmLastInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLastInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLastInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLastInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLastInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel area;
    public javax.swing.JLabel datetime;
    public javax.swing.JLabel depth;
    public javax.swing.JLabel geo;
    private javax.swing.JLabel gif;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel strength;
    public javax.swing.JLabel tsunami;
    // End of variables declaration//GEN-END:variables
}
