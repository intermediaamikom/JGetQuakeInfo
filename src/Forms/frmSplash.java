/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;
import Modules.*;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modules.sysTray;
import java.io.FileOutputStream;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Dwi Candra Permanaa
 */
public class frmSplash extends javax.swing.JFrame {
private static String ui;
private frmMain frmMain;
private sysTray sysTray;
private static frmDebug frmDebug;
private TakeXML TakeXML;
private LockFile LockFile;
    /**
     * Creates new form frmSplash
     */
    public frmSplash() {
        frmMain = new frmMain();
        frmDebug = new frmDebug();
        sysTray = new sysTray();
        TakeXML = new TakeXML();
        LockFile = new LockFile();
        Timer timer = new Timer();
        ImageIcon img = new ImageIcon("src/Resources/iconTray/main.png");
        initComponents();
        this.setIconImage(img.getImage());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
              // Your database code here
              Load();
            }
        }, 5*60*10);
        
    }
    
    private void Load() {
        // Load System Tray
        pg.setString("Lock");
        boolean ba = LockFile.lockInstance("lock.JGetQuakeInfo");
        if (ba == false) {
            JOptionPane.showMessageDialog(this, "Aplikasi telah dijalankan sebelumnya. Periksa SystemTray Anda!\n\nJika tidak ada, End Process yang berkaitan dengan JAVA atau JGetQuakeInfo, lalu hapus file bernama lock.JGetQuakeInfo!", "Already Running", JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        
        pg.setString("System Tray");
        boolean b = sysTray.openSystemTray();
        String os = System.getProperty("os.name");
        if (b == false) {
            JOptionPane.showMessageDialog(this, "System Tray tidak support oleh sistem operasi Anda!", "Not Supported", JOptionPane.WARNING_MESSAGE);
            frmMain.setVisible(true);
            frmMain.lbStatus.setText("Status: Your operating system don't supported the System Tray icon.");
            //this.dispose();
        } else {
            FileReader in = null;
            try {
                //frmMain.setVisible(true);
                frmMain.lbStatus.setText("Status: Your operating system is supported the System Tray icon.");
                File f = new File("src/Prefer/JGQI_Config.properties");
                in = new FileReader(f);
                Properties prop = new Properties();
                prop.load(in);
                
                String trayS = prop.getProperty("tray");
                boolean trayStat = Boolean.parseBoolean(trayS);
                if (trayS.equals("")) {
                    int a = JOptionPane.showConfirmDialog(this, "Apakah Anda dapat melihat ikon Tray dan dapat mengkliknya?", "Did You See?", JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.NO_OPTION) {
                        frmMain.setVisible(true);
                        prop.setProperty("tray", "false");
                    } else {
                        prop.setProperty("tray", "true");
                    }
                    prop.store(new FileOutputStream("src/Prefer/JGQI_Config.properties"), " JGetQuakeInfo ver 1.1-alpha\n JGQI_Config.properties\n This is configuration data of JGetQuakeInfo. \n Please don't modify this file, except you know what should you do.");
                } else {
                    frmMain.setVisible(!trayStat);
                }
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(frmSplash.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pg.setString("AutoGetInfo");
        TakeXML.TakeInfoAutomatically();
        pg.setString("Complete");
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pg = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("JGetQuakeInfo ver. 1.1-alpha");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        setMinimumSize(new java.awt.Dimension(519, 331));
        setUndecorated(true);
        getContentPane().setLayout(null);

        pg.setToolTipText("");
        pg.setIndeterminate(true);
        pg.setOpaque(true);
        pg.setString("");
        pg.setStringPainted(true);
        getContentPane().add(pg);
        pg.setBounds(340, 300, 170, 20);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/X.PNG"))); // NOI18N
        jButton1.setToolTipText("Close");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(480, 0, 40, 20);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Min.PNG"))); // NOI18N
        jButton2.setToolTipText("Minimize");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(450, 0, 30, 20);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("(c) 2017. Dwi Candra Permana.");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 300, 320, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Version 1.1-alpha");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 190, 520, 20);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Globe_104px.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 40, 520, 104);

        jLabel3.setFont(new java.awt.Font("Bleeding Cowboys", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("JGetQuakeInfo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 150, 520, 43);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/bg_frmSplash.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 790, 360);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(frmSplash.ICONIFIED);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
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
        FileReader in = null;
            try {
                File f = new File("src/Prefer/JGQI_Config.properties");
                in = new FileReader(f);
                Properties prop = new Properties();
                prop.load(in);
                ui = prop.getProperty("ui");
                in.close();
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if (ui.equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception ex) {
                    String errTit = ex.getMessage();
                    //JOptionPane.showMessageDialog(this, ex.getStackTrace(), errTit, JOptionPane.ERROR_MESSAGE);
                    CharArrayWriter cw = new CharArrayWriter();
                    PrintWriter w = new PrintWriter(cw);
                    ex.printStackTrace(w);
                    w.close();
                    String trace = cw.toString();
                    
                    frmDebug.setVisible(true);
                    frmDebug.log.setText(trace + "\n" + String.valueOf(System.getProperties()));
                    Logger.getLogger(frmConfig.class.getName()).log(Level.SEVERE, null, ex);
                }
        //</editor-fold>
        
        /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new frmSplash().setVisible(true);
                    }
                });
            } catch (FileNotFoundException ex) {
                String errTit = ex.getMessage();
                //JOptionPane.showMessageDialog(this, ex.getStackTrace(), errTit, JOptionPane.ERROR_MESSAGE);
                CharArrayWriter cw = new CharArrayWriter();
                PrintWriter w = new PrintWriter(cw);
                ex.printStackTrace(w);
                w.close();
                String trace = cw.toString();

                frmDebug.setVisible(true);
                frmDebug.log.setText(trace + "\n" + String.valueOf(System.getProperties()));
                Logger.getLogger(frmConfig.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                String errTit = ex.getMessage();
                //JOptionPane.showMessageDialog(this, ex.getStackTrace(), errTit, JOptionPane.ERROR_MESSAGE);
                CharArrayWriter cw = new CharArrayWriter();
                PrintWriter w = new PrintWriter(cw);
                ex.printStackTrace(w);
                w.close();
                String trace = cw.toString();

                frmDebug.setVisible(true);
                frmDebug.log.setText(trace + "\n" + String.valueOf(System.getProperties()));
                Logger.getLogger(frmConfig.class.getName()).log(Level.SEVERE, null, ex);
            } 
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JProgressBar pg;
    // End of variables declaration//GEN-END:variables
}
