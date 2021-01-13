/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ALL_Frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ranvi
 */
public class SP extends javax.swing.JFrame {

    public static String userid;
    public static String userps;
    byte[] EIMG = null;

    DefaultTableModel dm1;
     DefaultTableModel dm;
int x,y;
    public SP() {
        initComponents();

        int id=Integer.parseInt(userid);
        Connection con;
        Statement stmt = null;
        ResultSet rs;
        String currentDir=System.getProperty("user.dir");
        try
   {  Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); 
      con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
      stmt=(Statement) con.createStatement();
       String qry="SELECT * FROM MAINDATA.EMPLOG WHERE EID= "+id;
       rs= stmt.executeQuery(qry);
      if (rs.next())
      {  String a=(rs.getString("EPS"));
          sh1.setText(rs.getString("EID"));
         sh2.setText(rs.getString("ENAME"));
         sh4.setText(rs.getString("EID"));
         sh5.setText(rs.getString("ENAME"));
        //sh6.setText(rs.getString("EID"));
        per2.setText(rs.getString("ENAME"));
       per1.setText(rs.getString("EID"));
        per3.setText(rs.getString("ESAL"));
         per4.setText(rs.getString("EPHN"));
         per5.setText(rs.getString("EADR"));
        //sh7.setText(rs.getString("AID"));
        na.setText(rs.getString("EID"));
          nb.setText(rs.getString("ENAME"));
           a5.setText(rs.getString("EID"));
            a1.setText(rs.getString("EID"));
      } 
      }
catch(  SQLException | ArrayIndexOutOfBoundsException e1)
   {
       JOptionPane.showMessageDialog(null,e1.getMessage());
         
   }    catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        Show_Admin();
        Show_User();
        Show_Car();
        Show_SAdmin();
        Show_ActAdminTable();
        ShowDateTime();
        Show_PrgDel();

       
        this.s1.setVisible(true);
        this.s2.setVisible(false);
        this.s4.setVisible(false);
        this.s5.setVisible(false);
        this.s6.setVisible(false);
        this.s7.setVisible(false);


    }
     String photopath = null;
    public ImageIcon resizeImageEmp(String photopath, byte[] photo) {
        ImageIcon myPhoto = null;
        if (photopath != null) {
            myPhoto = new ImageIcon(photopath);
        } else {
            myPhoto = new ImageIcon(photo);
        }
        Image img = myPhoto.getImage();
        Image img1 = img.getScaledInstance(ims2.getWidth(), ims2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ph = new ImageIcon(img1);
        return ph;
    }

    public ImageIcon resizeImageIA(String photopath, byte[] photo) {
        ImageIcon myPhoto = null;
        if (photopath != null) {
            myPhoto = new ImageIcon(photopath);
        } else {
            myPhoto = new ImageIcon(photo);
        }
        Image img = myPhoto.getImage();
        Image img1 = img.getScaledInstance(ims1.getWidth(), ims1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ph = new ImageIcon(img1);
        return ph;
    }

    private void Show_User() {
        int c;
        String currentDir=System.getProperty("user.dir");
         try
   {  
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            PreparedStatement sql = con.prepareStatement("SELECT * FROM MAINDATA.EMPDETAILS");
            ResultSet rs = sql.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            c = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) T1.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= c; a++) {
                    v2.add(rs.getString("SSID"));
                    v2.add(rs.getString("SNAME"));
                    v2.add(rs.getString("SSEX"));
                    v2.add(rs.getString("SPHN"));
                    v2.add(rs.getString("SADR"));
                    v2.add(rs.getString("SIDPT"));
                    v2.add(rs.getString("SIDNO"));
                    v2.add(rs.getString("SSAL"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException e2) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void Show_Admin() {
        int c;
        String currentDir=System.getProperty("user.dir");
         try
   {  
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            PreparedStatement sql = con.prepareStatement("SELECT * FROM MAINDATA.ADMDETAILS");
            ResultSet rs = sql.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            c = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) AdminTable.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= c; a++) {
                    v2.add(rs.getString("AEID"));
                    v2.add(rs.getString("ANAME"));
                    v2.add(rs.getString("APHN"));
                    v2.add(rs.getString("ESEX"));
                    v2.add(rs.getString("EARD"));
                    v2.add(rs.getString("AIDPT"));
                    v2.add(rs.getString("AIDNO"));
                    v2.add(rs.getString("ASAL"));
                    // v2.add(rs.getBlob("AIMAGE"));   
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException e1) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void Show_SAdmin() {
        int c;
        String currentDir=System.getProperty("user.dir");
         try
   {  
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            PreparedStatement sql = con.prepareStatement("SELECT * FROM MAINDATA.EMPLOG");
            ResultSet rs = sql.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            c = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) T3.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= c; a++) {
                    v2.add(rs.getString("EID"));
                    v2.add(rs.getString("ENAME"));
                    v2.add(rs.getString("ESEX"));
                    v2.add(rs.getString("EPHN"));
                    v2.add(rs.getString("EADR"));
                    v2.add(rs.getString("ESAL"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException e1) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void Show_ActAdminTable() {
        int c;
        String currentDir=System.getProperty("user.dir");
         try
   {  
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            PreparedStatement sql = con.prepareStatement("SELECT * FROM MAINDATA.ADMLOG");
            ResultSet rs = sql.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            c = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) ActAdminTable.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= c; a++) {
                    v2.add(rs.getString("AID"));
                    v2.add(rs.getString("ANAME"));
                    v2.add(rs.getString("APHN"));
                    v2.add(rs.getString("ASEX"));
                    v2.add(rs.getString("AADR"));
                    v2.add(rs.getString("AIDPT"));
                    v2.add(rs.getString("AIDNO"));
                    v2.add(rs.getString("ASAL"));

                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException e1) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void Show_Car() {
        int c;
       String currentDir=System.getProperty("user.dir");
         try
   {  
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            PreparedStatement sql = con.prepareStatement("SELECT * FROM MAINDATA.CARDETAILS");
            ResultSet rs = sql.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            c = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) ct1.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v3 = new Vector();
                for (int a = 1; a <= c; a++) {
                    v3.add(rs.getString("ENO"));
                    v3.add(rs.getString("CNAME"));
                    v3.add(rs.getString("CCLR"));
                    v3.add(rs.getString("CMOD"));
                    v3.add(rs.getString("CSTS"));
                    v3.add(rs.getString("CMIL"));
                    v3.add(rs.getString("CETYPE"));
                    v3.add(rs.getString("CPRICE"));
                }
                df.addRow(v3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException e1) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void ShowDateTime() {
        Date d = new Date();
         Date d1 = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        Da.setText(s.format(d));
        SimpleDateFormat s1 = new SimpleDateFormat("hh:mm:ss a");
        Time.setText(s1.format(d1));
         SimpleDateFormat s2 = new SimpleDateFormat("dd-MM-yyyy");
        st1.setText(s2.format(d));
        SimpleDateFormat s3 = new SimpleDateFormat("hh:mm:ss");
        st2.setText(s3.format(d1));
    }
private void FilterCar(String query)
{
    TableRowSorter<DefaultTableModel> tr =new TableRowSorter<DefaultTableModel>(dm);
    ct1.setRowSorter(tr);
    tr.setRowFilter(RowFilter.regexFilter(query));
}


/*private void Show_PrgDel() {
    
        int c;
        int id=Integer.parseInt(userid);
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Ranvijay", "maindata", "1234");
            PreparedStatement sql = con.prepareStatement("SELECT * FROM BILLSYS WHERE SID="+id);
            // String qry="SELECT * FROM ADMLOG WHERE AID= "+id;
            ResultSet rs = sql.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            c = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) PrgT.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= c; a++) {
                    v2.add(rs.getString("CID"));
                    v2.add(rs.getString("CCMP"));
                    v2.add(rs.getString("CUID"));
                    v2.add(rs.getString("CUNAME"));
                    v2.add(rs.getString("PID"));
                    v2.add(rs.getString("PPM"));
                    v2.add(rs.getString("PTP"));   
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException e1) {

        }

    }*/

private void Show_PrgDel() {
        int c;
       String currentDir=System.getProperty("user.dir");
         try
   {  
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            PreparedStatement sql = con.prepareStatement("SELECT * FROM MAINDATA.BILLSYS");
            ResultSet rs = sql.executeQuery();
            //PrgT.setModel(DbUtils.resultSetToTableModel(rs));
            ResultSetMetaData rss = rs.getMetaData();
            c = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) PrgT.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= c; a++) {
                    v2.add(rs.getString("CID"));
                    v2.add(rs.getString("CCMP"));
                    v2.add(rs.getString("SID"));
                    v2.add(rs.getString("SNAME"));
                    v2.add(rs.getString("CUID"));
                    v2.add(rs.getString("CUNAME"));
                    v2.add(rs.getString("PID"));
                    v2.add(rs.getString("PPM"));
                    v2.add(rs.getString("PTP"));   
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException e1) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p1 = new javax.swing.JPanel();
        p2 = new javax.swing.JPanel();
        upp = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        minimise = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        sh1 = new javax.swing.JLabel();
        sh2 = new javax.swing.JLabel();
        sh3 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        buttenp = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        s1 = new javax.swing.JPanel();
        l1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        l2 = new javax.swing.JLabel();
        s2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        l4 = new javax.swing.JLabel();
        s4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        s5 = new javax.swing.JPanel();
        l5 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        l7 = new javax.swing.JLabel();
        s7 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        l9 = new javax.swing.JLabel();
        s6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        card = new javax.swing.JPanel();
        chome = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        homecs = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        homeemp = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        homeprg = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel178 = new javax.swing.JLabel();
        addcar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ct1 = new javax.swing.JTable();
        esearch2 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        c2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        c1 = new javax.swing.JTextField();
        c6 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        c7 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        c3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        c4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        c5 = new javax.swing.JTextField();
        c8 = new javax.swing.JTextField();
        jLabel182 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel179 = new javax.swing.JLabel();
        AdminPa = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel22 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        esearch3 = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        e2 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        e3 = new javax.swing.JTextField();
        e9 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        e1 = new javax.swing.JTextField();
        e8 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        e7 = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        e6 = new javax.swing.JTextArea();
        einsert1 = new javax.swing.JButton();
        eupdate1 = new javax.swing.JButton();
        edel1 = new javax.swing.JButton();
        e4 = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        ee1 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        ee3 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        ee2 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        ee4 = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        AdminTable = new javax.swing.JTable();
        ims1 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        ActAdminTable = new javax.swing.JTable();
        jLabel67 = new javax.swing.JLabel();
        SalesPpan = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel18 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        esearch = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        ename = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        epo = new javax.swing.JTextField();
        esal = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        eid = new javax.swing.JTextField();
        eidno = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        esex = new javax.swing.JComboBox<>();
        eidtype = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        eadr = new javax.swing.JTextArea();
        einsert = new javax.swing.JButton();
        eupdate = new javax.swing.JButton();
        edel = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        euid = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        epn = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        eps = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        T1 = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        T3 = new javax.swing.JTable();
        jLabel93 = new javax.swing.JLabel();
        ims2 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        progress = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        PrgT = new javax.swing.JTable();
        esearch1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        BillSys = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        B4 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        B6 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        B5 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        B2 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        B3 = new javax.swing.JTextField();
        B1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        sh5 = new javax.swing.JTextField();
        sh4 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        sa3 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        sa5 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        sa2 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        sa1 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        sa4 = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        pa5 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        pa2 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        pa1 = new javax.swing.JTextField();
        pa4 = new javax.swing.JComboBox<>();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        ProfilePan = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        per1 = new javax.swing.JTextField();
        per2 = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        per4 = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        per5 = new javax.swing.JTextArea();
        jButton19 = new javax.swing.JButton();
        per3 = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        SCard = new javax.swing.JPanel();
        ChangePassWord = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        a2 = new javax.swing.JTextField();
        a3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        a1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        a4 = new javax.swing.JPasswordField();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        pinchange = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        a6 = new javax.swing.JTextField();
        a7 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        a5 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        a8 = new javax.swing.JPasswordField();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        ims = new javax.swing.JLabel();
        GBill = new javax.swing.JPanel();
        G1 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        j26 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        logo1 = new javax.swing.JLabel();
        logo2 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        nb = new javax.swing.JTextField();
        na = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        fp9 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        fp11 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        fp8 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        fp7 = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        fp10 = new javax.swing.JTextArea();
        jPanel33 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        fp15 = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        fp13 = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        fp12 = new javax.swing.JTextField();
        fp14 = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        Da = new javax.swing.JTextField();
        Time = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        fp1 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        fp2 = new javax.swing.JTextField();
        fp6 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        fp5 = new javax.swing.JTextField();
        fp3 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        fp4 = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        st4 = new javax.swing.JTextField();
        st1 = new javax.swing.JTextField();
        st2 = new javax.swing.JTextField();
        st3 = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        About = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jPanel40 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        p1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p2.setBackground(new java.awt.Color(255, 255, 255));
        p2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        upp.setBackground(new java.awt.Color(102, 153, 255));
        upp.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                uppMouseDragged(evt);
            }
        });
        upp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uppMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                uppMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                uppMousePressed(evt);
            }
        });
        upp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setBackground(new java.awt.Color(255, 255, 255));
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AIcon/icons8_shutdown_48px.png"))); // NOI18N
        close.setText("jLabel1");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.setOpaque(true);
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });
        upp.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1109, 0, 50, -1));

        minimise.setBackground(new java.awt.Color(255, 255, 255));
        minimise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Minimize.png"))); // NOI18N
        minimise.setText("jLabel1");
        minimise.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimise.setOpaque(true);
        minimise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimiseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimiseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimiseMouseExited(evt);
            }
        });
        upp.add(minimise, new org.netbeans.lib.awtextra.AbsoluteConstraints(1052, 0, 50, -1));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("User");
        upp.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 45, 27));

        sh1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        sh1.setForeground(new java.awt.Color(255, 255, 51));
        sh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sh1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sh1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sh1MouseExited(evt);
            }
        });
        upp.add(sh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 0, 230, 50));

        sh2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        sh2.setForeground(new java.awt.Color(255, 51, 51));
        sh2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sh2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sh2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sh2MouseExited(evt);
            }
        });
        upp.add(sh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 240, 40));

        sh3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        sh3.setForeground(new java.awt.Color(255, 255, 255));
        upp.add(sh3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1016, 10, 30, 34));

        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setText("Welcome");
        upp.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 112, -1));

        jLabel181.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(255, 255, 255));
        jLabel181.setText("@ Sales_Persons @");
        upp.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 180, 30));

        p2.add(upp, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1160, 50));

        buttenp.setBackground(new java.awt.Color(0, 255, 255));
        buttenp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setAutoscrolls(true);
        jPanel5.setInheritsPopupMenu(true);
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        s1.setBackground(new java.awt.Color(255, 0, 0));
        s1.setAlignmentX(0.0F);
        s1.setAlignmentY(0.0F);

        javax.swing.GroupLayout s1Layout = new javax.swing.GroupLayout(s1);
        s1.setLayout(s1Layout);
        s1Layout.setHorizontalGroup(
            s1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        s1Layout.setVerticalGroup(
            s1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        l1.setBackground(new java.awt.Color(255, 255, 255));
        l1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 25)); // NOI18N
        l1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_home_64px.png"))); // NOI18N
        l1.setText("HOME");
        l1.setAlignmentY(0.0F);
        l1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        l1.setIconTextGap(15);
        l1.setOpaque(true);
        l1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l1MouseExited(evt);
            }
        });
        jPanel5.add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 290, 60));

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));
        jPanel7.setAutoscrolls(true);
        jPanel7.setInheritsPopupMenu(true);
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l2.setBackground(new java.awt.Color(0, 0, 0));
        l2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 25)); // NOI18N
        l2.setForeground(new java.awt.Color(255, 255, 255));
        l2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_car_64px.png"))); // NOI18N
        l2.setText("<html>CAR Store <h4> View Store/Choose Car</h4></html>");
        l2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        l2.setIconTextGap(15);
        l2.setOpaque(true);
        l2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l2MouseExited(evt);
            }
        });
        jPanel7.add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 290, 60));

        s2.setBackground(new java.awt.Color(255, 0, 51));
        s2.setAlignmentX(0.0F);
        s2.setAlignmentY(0.0F);

        javax.swing.GroupLayout s2Layout = new javax.swing.GroupLayout(s2);
        s2.setLayout(s2Layout);
        s2Layout.setHorizontalGroup(
            s2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        s2Layout.setVerticalGroup(
            s2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.add(s2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));
        jPanel9.setAutoscrolls(true);
        jPanel9.setInheritsPopupMenu(true);
        jPanel9.setOpaque(false);
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l4.setBackground(new java.awt.Color(0, 0, 0));
        l4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 25)); // NOI18N
        l4.setForeground(new java.awt.Color(255, 255, 255));
        l4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_business_report_48px.png"))); // NOI18N
        l4.setText("<html>Progress<h3>Car Sold By You </h3>  </html> ");
        l4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        l4.setIconTextGap(30);
        l4.setOpaque(true);
        l4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l4MouseExited(evt);
            }
        });
        jPanel9.add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 290, 60));

        s4.setBackground(new java.awt.Color(255, 0, 51));
        s4.setAlignmentX(0.0F);
        s4.setAlignmentY(0.0F);

        javax.swing.GroupLayout s4Layout = new javax.swing.GroupLayout(s4);
        s4.setLayout(s4Layout);
        s4Layout.setHorizontalGroup(
            s4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        s4Layout.setVerticalGroup(
            s4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.add(s4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        s5.setBackground(new java.awt.Color(255, 0, 51));
        s5.setAlignmentX(0.0F);
        s5.setAlignmentY(10.0F);

        javax.swing.GroupLayout s5Layout = new javax.swing.GroupLayout(s5);
        s5.setLayout(s5Layout);
        s5Layout.setHorizontalGroup(
            s5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        s5Layout.setVerticalGroup(
            s5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel6.add(s5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        l5.setBackground(new java.awt.Color(0, 0, 0));
        l5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 25)); // NOI18N
        l5.setForeground(new java.awt.Color(255, 255, 255));
        l5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_bill_64px.png"))); // NOI18N
        l5.setText("<html>Billing System<h3>Click To Sale A Car</h3></html>");
        l5.setAlignmentY(10.0F);
        l5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        l5.setIconTextGap(15);
        l5.setOpaque(true);
        l5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l5MouseExited(evt);
            }
        });
        jPanel6.add(l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 290, 60));

        jPanel15.setBackground(new java.awt.Color(102, 102, 102));
        jPanel15.setAutoscrolls(true);
        jPanel15.setInheritsPopupMenu(true);
        jPanel15.setOpaque(false);
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l7.setBackground(new java.awt.Color(0, 0, 0));
        l7.setFont(new java.awt.Font("Segoe UI Symbol", 1, 25)); // NOI18N
        l7.setForeground(new java.awt.Color(255, 255, 255));
        l7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AIcon/icons8_info_70px.png"))); // NOI18N
        l7.setText("About");
        l7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        l7.setIconTextGap(20);
        l7.setOpaque(true);
        l7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l7MouseExited(evt);
            }
        });
        jPanel15.add(l7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 290, 60));

        s7.setBackground(new java.awt.Color(255, 0, 51));
        s7.setAlignmentX(0.0F);
        s7.setAlignmentY(0.0F);

        javax.swing.GroupLayout s7Layout = new javax.swing.GroupLayout(s7);
        s7.setLayout(s7Layout);
        s7Layout.setHorizontalGroup(
            s7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        s7Layout.setVerticalGroup(
            s7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel15.add(s7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        logo.setBackground(new java.awt.Color(0, 102, 255));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO.png"))); // NOI18N
        logo.setOpaque(true);

        jPanel35.setBackground(new java.awt.Color(102, 102, 102));
        jPanel35.setAutoscrolls(true);
        jPanel35.setInheritsPopupMenu(true);
        jPanel35.setOpaque(false);
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l9.setBackground(new java.awt.Color(0, 0, 0));
        l9.setFont(new java.awt.Font("Segoe UI Symbol", 1, 25)); // NOI18N
        l9.setForeground(new java.awt.Color(255, 255, 255));
        l9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_private_account_male_70px.png"))); // NOI18N
        l9.setText("<html>Profile<h4>Security and More</h4></html>");
        l9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        l9.setIconTextGap(15);
        l9.setOpaque(true);
        l9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l9MouseExited(evt);
            }
        });
        jPanel35.add(l9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 290, 60));

        s6.setBackground(new java.awt.Color(255, 0, 51));
        s6.setAlignmentX(0.0F);
        s6.setAlignmentY(0.0F);

        javax.swing.GroupLayout s6Layout = new javax.swing.GroupLayout(s6);
        s6.setLayout(s6Layout);
        s6Layout.setHorizontalGroup(
            s6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        s6Layout.setVerticalGroup(
            s6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel35.add(s6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/download.png"))); // NOI18N
        jLabel30.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel30.setOpaque(true);
        jLabel30.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 90));

        jLabel31.setBackground(new java.awt.Color(0, 0, 0));
        jLabel31.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("LogOut");
        jLabel31.setOpaque(true);
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 89, 100, 30));

        javax.swing.GroupLayout buttenpLayout = new javax.swing.GroupLayout(buttenp);
        buttenp.setLayout(buttenpLayout);
        buttenpLayout.setHorizontalGroup(
            buttenpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(buttenpLayout.createSequentialGroup()
                .addGroup(buttenpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(buttenpLayout.createSequentialGroup()
                .addGroup(buttenpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttenpLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(buttenpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttenpLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttenpLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        buttenpLayout.setVerticalGroup(
            buttenpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttenpLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        p2.add(buttenp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 820));

        card.setLayout(new java.awt.CardLayout());

        chome.setBackground(new java.awt.Color(204, 204, 255));
        chome.setForeground(new java.awt.Color(0, 204, 204));
        chome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 0, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HOME");
        jLabel3.setOpaque(true);
        chome.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 160, 40));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(200, 200));

        homecs.setBackground(new java.awt.Color(255, 255, 255));
        homecs.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        homecs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homecs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/150.jpg"))); // NOI18N
        homecs.setText("<html>CAR Store <h3> View Store/Choose Car</h3></html>");
        homecs.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        homecs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homecs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        homecs.setOpaque(true);
        homecs.setPreferredSize(new java.awt.Dimension(200, 200));
        homecs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        homecs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                homecsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                homecsFocusLost(evt);
            }
        });
        homecs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homecsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homecsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homecsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homecs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homecs, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );

        chome.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 408, 270, 255));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(200, 200));

        homeemp.setBackground(new java.awt.Color(255, 255, 255));
        homeemp.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        homeemp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/18857332.jpg"))); // NOI18N
        homeemp.setText("<html>BillSystem   <h2>Click To Sale A Car</h2>   </html>");
        homeemp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        homeemp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeemp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        homeemp.setOpaque(true);
        homeemp.setPreferredSize(new java.awt.Dimension(200, 200));
        homeemp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        homeemp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                homeempFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                homeempFocusLost(evt);
            }
        });
        homeemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeempMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeempMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeempMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeemp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeemp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        chome.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 270, 250));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(200, 200));

        homeprg.setBackground(new java.awt.Color(255, 255, 255));
        homeprg.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        homeprg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeprg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/char.png"))); // NOI18N
        homeprg.setText("<html>  Progress   <h3>View Car Sold By You</h3>  </html> ");
        homeprg.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        homeprg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeprg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        homeprg.setOpaque(true);
        homeprg.setPreferredSize(new java.awt.Dimension(200, 200));
        homeprg.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        homeprg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                homeprgFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                homeprgFocusLost(evt);
            }
        });
        homeprg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeprgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeprgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeprgMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeprg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeprg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );

        chome.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 270, 255));

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setFont(new java.awt.Font("Jokerman", 3, 55)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 255, 255));
        jLabel78.setText("P");
        jPanel28.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 53, 50));

        jLabel79.setFont(new java.awt.Font("Jokerman", 3, 55)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 0, 51));
        jLabel79.setText("V");
        jPanel28.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 60));

        jLabel80.setFont(new java.awt.Font("Jokerman", 3, 55)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 255, 0));
        jLabel80.setText("R");
        jPanel28.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 59, 50));

        jLabel81.setFont(new java.awt.Font("Tahoma", 3, 55)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(51, 255, 51));
        jLabel81.setText("Auto");
        jPanel28.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 142, 50));

        jLabel82.setFont(new java.awt.Font("Tahoma", 3, 55)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 51, 51));
        jLabel82.setText("Show");
        jPanel28.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 162, 50));

        jLabel83.setBackground(new java.awt.Color(0, 0, 0));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_fiat_500_100px.png"))); // NOI18N
        jLabel83.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel83.setOpaque(true);
        jPanel28.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 120));

        jLabel84.setFont(new java.awt.Font("Tahoma", 3, 55)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 255, 255));
        jLabel84.setText("Room");
        jPanel28.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 169, 60));

        chome.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 80, -1, -1));

        jLabel117.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(0, 0, 255));
        jLabel117.setText("To Start Billing");
        chome.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 208, 260, 130));

        l6.setBackground(new java.awt.Color(0, 0, 0));
        l6.setFont(new java.awt.Font("Algerian", 1, 48)); // NOI18N
        l6.setForeground(new java.awt.Color(255, 255, 255));
        l6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_paper_plane_40px.png"))); // NOI18N
        l6.setText("Click Here");
        l6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        l6.setAlignmentY(10.0F);
        l6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        l6.setIconTextGap(15);
        l6.setOpaque(true);
        l6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l6MouseExited(evt);
            }
        });
        chome.add(l6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 460, -1));

        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel164.setBackground(new java.awt.Color(255, 255, 255));
        jLabel164.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel164.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_shutdown_100px_1.png"))); // NOI18N
        jLabel164.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel164.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel164.setOpaque(true);
        jLabel164.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel164.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel164MouseClicked(evt);
            }
        });
        jPanel39.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 90));

        jLabel165.setBackground(new java.awt.Color(0, 0, 0));
        jLabel165.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(255, 255, 255));
        jLabel165.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel165.setText("LogOut");
        jLabel165.setOpaque(true);
        jPanel39.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 89, 100, 30));

        chome.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 650, -1, 120));

        jLabel178.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AIcon/6 lamborghini.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel178, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel178, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        chome.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 770));

        card.add(chome, "card2");

        addcar.setBackground(new java.awt.Color(153, 153, 255));
        addcar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ct1.setAutoCreateRowSorter(true);
        ct1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ct1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CAR_ID", "Company_Name", "Color", "Model", "Availability", "Mileage", "Price", "EN_Type"
            }
        ));
        ct1.setAlignmentX(0.0F);
        ct1.setAlignmentY(0.0F);
        ct1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        ct1.setRowHeight(25);
        ct1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ct1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ct1);

        addcar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 720, 620));

        esearch2.setBackground(new java.awt.Color(102, 255, 255));
        esearch2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        esearch2.setText("Search By CAR Name");
        esearch2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                esearch2MouseClicked(evt);
            }
        });
        esearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esearch2ActionPerformed(evt);
            }
        });
        esearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                esearch2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                esearch2KeyReleased(evt);
            }
        });
        addcar.add(esearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 25, 651, 48));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_search_48px.png"))); // NOI18N
        addcar.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 25, 63, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        c2.setEditable(false);
        c2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        c2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c2.setBorder(null);

        jLabel16.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel16.setText("Price :-");

        c1.setEditable(false);
        c1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        c1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c1.setBorder(null);
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });

        c6.setEditable(false);
        c6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        c6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c6.setBorder(null);

        jLabel15.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel15.setText("Status :-");

        c7.setEditable(false);
        c7.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        c7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c7.setBorder(null);

        jLabel14.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel14.setText("Model :-");

        jLabel11.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel11.setText("CAR_ID  :-");

        c3.setEditable(false);
        c3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        c3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c3.setBorder(null);

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel12.setText("Company Name :-");

        jLabel21.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel21.setText("Mileage :-");

        c4.setEditable(false);
        c4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        c4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c4.setBorder(null);

        jLabel13.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel13.setText("Color :-");

        jLabel36.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel36.setText("Eng_Type :-");

        c5.setEditable(false);
        c5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        c5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c5.setBorder(null);

        c8.setEditable(false);
        c8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        c8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c8.setBorder(null);

        jLabel182.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel182.setForeground(new java.awt.Color(255, 0, 0));
        jLabel182.setText("* Please Select A CAR To sale it");

        jButton1.setBackground(new java.awt.Color(204, 204, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_sale_60px_1.png"))); // NOI18N
        jButton1.setText("Sale This Car");
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setIconTextGap(20);
        jButton1.setOpaque(true);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c8, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(c2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                        .addComponent(c3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(c4, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(c6, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(c1)
                                        .addComponent(c5, javax.swing.GroupLayout.Alignment.LEADING))))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel182, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(c2)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c5, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(c6)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(c8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel182)
                .addGap(4, 4, 4)
                .addComponent(jButton1)
                .addContainerGap())
        );

        addcar.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 410, 480));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_update_left_rotation_24px.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        addcar.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 460, 157, 47));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_delete_32px.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        addcar.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 458, 174, 50));

        jLabel179.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(255, 51, 51));
        jLabel179.setText("* Select A Car From List To Sale it");
        jLabel179.setOpaque(true);
        addcar.add(jLabel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 300, -1));

        card.add(addcar, "card5");

        AdminPa.setBackground(new java.awt.Color(255, 255, 255));
        AdminPa.setPreferredSize(new java.awt.Dimension(1160, 770));

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel22.setBackground(new java.awt.Color(255, 255, 153));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_search_48px.png"))); // NOI18N
        jPanel22.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 1, 55, -1));

        esearch3.setBackground(new java.awt.Color(102, 255, 255));
        esearch3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        esearch3.setText("Search By Employee Name");
        esearch3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                esearch3MouseClicked(evt);
            }
        });
        jPanel22.add(esearch3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 1, 560, 48));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 4, 2, 4, new java.awt.Color(0, 0, 255)), "Admin Basic Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Symbol", 3, 24))); // NOI18N

        jLabel57.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel57.setText("Salary :-");

        e2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        e2.setOpaque(false);

        jLabel58.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel58.setText("Phone :-");

        jLabel59.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel59.setText("Employee_id :-");

        e3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        e3.setOpaque(false);

        e9.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        e9.setOpaque(false);
        e9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e9ActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel60.setText("Gendre :-");

        jLabel61.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel61.setText("Address :-");
        jLabel61.setToolTipText("");

        jLabel62.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel62.setText("ID_Proof Type :-");

        e1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        e1.setOpaque(false);
        e1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                e1FocusGained(evt);
            }
        });
        e1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e1ActionPerformed(evt);
            }
        });
        e1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                e1KeyReleased(evt);
            }
        });

        e8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        e8.setOpaque(false);

        jLabel63.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel63.setText("ID_Proof_Number :-");

        jLabel64.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel64.setText("Full Name :-");

        e7.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        e7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aadhaar", "PAN", "Voter_Id", "Driving Licence" }));
        e7.setOpaque(false);

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        e6.setColumns(20);
        e6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        e6.setRows(5);
        jScrollPane9.setViewportView(e6);

        einsert1.setBackground(new java.awt.Color(153, 153, 255));
        einsert1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        einsert1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_add_30px.png"))); // NOI18N
        einsert1.setText("Insert");
        einsert1.setAlignmentY(0.0F);
        einsert1.setBorderPainted(false);
        einsert1.setContentAreaFilled(false);
        einsert1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        einsert1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        einsert1.setMargin(new java.awt.Insets(1, 10, 1, 10));
        einsert1.setOpaque(true);
        einsert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                einsert1ActionPerformed(evt);
            }
        });

        eupdate1.setBackground(new java.awt.Color(153, 255, 153));
        eupdate1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        eupdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_update_24px.png"))); // NOI18N
        eupdate1.setText("Update");
        eupdate1.setAlignmentY(0.0F);
        eupdate1.setBorderPainted(false);
        eupdate1.setContentAreaFilled(false);
        eupdate1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        eupdate1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        eupdate1.setMargin(new java.awt.Insets(1, 10, 1, 10));
        eupdate1.setOpaque(true);
        eupdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eupdate1ActionPerformed(evt);
            }
        });

        edel1.setBackground(new java.awt.Color(255, 204, 102));
        edel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        edel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_delete_trash_24px.png"))); // NOI18N
        edel1.setText("Delete");
        edel1.setAlignmentY(0.0F);
        edel1.setBorderPainted(false);
        edel1.setContentAreaFilled(false);
        edel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        edel1.setMargin(new java.awt.Insets(1, 10, 1, 10));
        edel1.setOpaque(true);
        edel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edel1ActionPerformed(evt);
            }
        });

        e4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        e4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        e4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e4ActionPerformed(evt);
            }
        });

        jLabel35.setForeground(new java.awt.Color(255, 51, 51));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("* Every Field IS Compulsary.. *");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(einsert1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eupdate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(e7, 0, 240, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(e8, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e9, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(e2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(e1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(e3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(e4, javax.swing.GroupLayout.Alignment.LEADING, 0, 240, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(e1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(e2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addGap(54, 54, 54)))
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(e9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(einsert1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eupdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, -1, 500));

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 4, 2, 4, new java.awt.Color(255, 0, 0)), "Admin Login Cradential", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 2, 24), new java.awt.Color(153, 0, 153))); // NOI18N

        jLabel66.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel66.setText("PIN :-");

        ee1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        ee1.setOpaque(false);
        ee1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ee1FocusGained(evt);
            }
        });
        ee1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ee1KeyReleased(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel68.setText("PassWord :-");

        ee3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        ee3.setOpaque(false);

        jLabel69.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel69.setText("User_ID :-");

        ee2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        ee2.setOpaque(false);

        jButton8.setBackground(new java.awt.Color(51, 51, 255));
        jButton8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Activate User");
        jButton8.setContentAreaFilled(false);
        jButton8.setOpaque(true);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 153, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("De Activate User");
        jButton9.setContentAreaFilled(false);
        jButton9.setOpaque(true);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        ee4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        ee4.setOpaque(false);

        jLabel111.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel111.setText("Security PIN :-");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ee4)
                            .addComponent(ee3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ee2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ee1))))
                .addGap(2, 2, 2))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ee1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ee2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ee3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ee4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel22.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, 250));

        AdminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMP_Id", "Name", "Phone", "Gender", "Address", "ID_Prf_Type", "ID_Prf_No", "Salary"
            }
        ));
        AdminTable.setRowHeight(25);
        AdminTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminTableMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(AdminTable);
        if (AdminTable.getColumnModel().getColumnCount() > 0) {
            AdminTable.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel22.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 56, 690, 360));

        ims1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel22.add(ims1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 340, 20, 40));

        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_pictures_folder_100px.png"))); // NOI18N
        jLabel65.setText("<html><h2>Choose Image </h2><h4>(  Of An Employee  )</h4></html>");
        jLabel65.setAlignmentY(0.0F);
        jLabel65.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel65.setDoubleBuffered(true);
        jLabel65.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel65.setIconTextGap(0);
        jLabel65.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel65MouseClicked(evt);
            }
        });
        jPanel22.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 340, 50, 40));

        ActAdminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMP_ID", "Name", "Phn No", "Gendar", "Address", "Id_P_Type", "ID_No.", "Salary"
            }
        ));
        ActAdminTable.setRowHeight(25);
        jScrollPane16.setViewportView(ActAdminTable);

        jPanel22.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 690, 290));

        jLabel67.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 0, 255));
        jLabel67.setText("Active ADMIN's List");
        jPanel22.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, 210, 30));

        jScrollPane7.setViewportView(jPanel22);

        javax.swing.GroupLayout AdminPaLayout = new javax.swing.GroupLayout(AdminPa);
        AdminPa.setLayout(AdminPaLayout);
        AdminPaLayout.setHorizontalGroup(
            AdminPaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
        );
        AdminPaLayout.setVerticalGroup(
            AdminPaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );

        card.add(AdminPa, "card5");

        SalesPpan.setBackground(new java.awt.Color(255, 255, 255));
        SalesPpan.setPreferredSize(new java.awt.Dimension(1160, 784));

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel18.setBackground(new java.awt.Color(204, 255, 204));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_search_48px.png"))); // NOI18N
        jPanel18.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 13, 55, -1));

        esearch.setBackground(new java.awt.Color(102, 255, 255));
        esearch.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        esearch.setText("Search By Employee Name");
        esearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                esearchMouseClicked(evt);
            }
        });
        jPanel18.add(esearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 13, 570, 48));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 4, 2, 4, new java.awt.Color(0, 0, 255)), "Sales_Person Basic Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Symbol", 3, 24), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel24.setText("Salary :-");

        ename.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        ename.setOpaque(false);

        jLabel20.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel20.setText("Phone :-");

        jLabel17.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel17.setText("Employee_id :-");

        epo.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        epo.setOpaque(false);

        esal.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        esal.setOpaque(false);
        esal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esalActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel28.setText("Gendre :-");

        jLabel19.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel19.setText("Address :-");
        jLabel19.setToolTipText("");

        jLabel22.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel22.setText("ID_Proof Type :-");

        eid.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        eid.setOpaque(false);
        eid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                eidFocusGained(evt);
            }
        });
        eid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eidActionPerformed(evt);
            }
        });
        eid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eidKeyReleased(evt);
            }
        });

        eidno.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        eidno.setOpaque(false);

        jLabel23.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel23.setText("ID_Proof_Number :-");

        jLabel18.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel18.setText("Full Name :-");

        esex.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        esex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        esex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esexActionPerformed(evt);
            }
        });

        eidtype.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        eidtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aadhaar", "PAN", "Voter_Id", "Driving Licence" }));
        eidtype.setOpaque(false);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        eadr.setColumns(20);
        eadr.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        eadr.setRows(5);
        jScrollPane4.setViewportView(eadr);

        einsert.setBackground(new java.awt.Color(153, 153, 255));
        einsert.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        einsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_add_30px.png"))); // NOI18N
        einsert.setText("Insert");
        einsert.setAlignmentY(0.0F);
        einsert.setBorderPainted(false);
        einsert.setContentAreaFilled(false);
        einsert.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        einsert.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        einsert.setMargin(new java.awt.Insets(1, 10, 1, 10));
        einsert.setOpaque(true);
        einsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                einsertActionPerformed(evt);
            }
        });

        eupdate.setBackground(new java.awt.Color(51, 255, 255));
        eupdate.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        eupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_update_30px.png"))); // NOI18N
        eupdate.setText("Update");
        eupdate.setAlignmentY(0.0F);
        eupdate.setBorderPainted(false);
        eupdate.setContentAreaFilled(false);
        eupdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        eupdate.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        eupdate.setMargin(new java.awt.Insets(1, 10, 1, 10));
        eupdate.setOpaque(true);
        eupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eupdateActionPerformed(evt);
            }
        });

        edel.setBackground(new java.awt.Color(255, 204, 102));
        edel.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        edel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_delete_trash_24px.png"))); // NOI18N
        edel.setText("Delete");
        edel.setAlignmentY(0.0F);
        edel.setBorderPainted(false);
        edel.setContentAreaFilled(false);
        edel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        edel.setMargin(new java.awt.Insets(1, 10, 1, 10));
        edel.setOpaque(true);
        edel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(epo))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ename, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eid, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(esex, 0, 240, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eidtype, 0, 240, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eidno, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(esal, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(einsert, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eid, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ename, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(esex, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(epo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eidtype, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eidno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(esal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(einsert, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel18.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 13, -1, 490));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 4, 2, 4, new java.awt.Color(255, 0, 0)), "Create New ADMINS Or Remove", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 2, 24), new java.awt.Color(153, 0, 153))); // NOI18N

        jLabel27.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel27.setText("PIN :-");

        euid.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        euid.setOpaque(false);
        euid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                euidKeyReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel26.setText("PassWord :-");

        epn.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        epn.setOpaque(false);

        jLabel25.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel25.setText("User_ID :-");

        eps.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        eps.setOpaque(false);

        jButton4.setBackground(new java.awt.Color(51, 51, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Activate User");
        jButton4.setContentAreaFilled(false);
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 153, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("De Activate User");
        jButton5.setContentAreaFilled(false);
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(epn))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eps)
                            .addComponent(euid)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                .addGap(7, 7, 7))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(euid, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eps, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(epn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, -1, 245));

        T1.setAutoCreateRowSorter(true);
        T1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        T1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMP_Id", "Name", "Gender", "Phone", "Address", "ID_Prf_Type", "ID_Prf_No", "Salary"
            }
        ));
        T1.setRowHeight(20);
        T1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T1MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(T1);
        if (T1.getColumnModel().getColumnCount() > 0) {
            T1.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel18.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 74, 690, 410));

        T3.setAutoCreateRowSorter(true);
        T3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp_ID", "Name", "Gender", "Phone", "Address", "Salary"
            }
        ));
        T3.setRowHeight(20);
        jScrollPane11.setViewportView(T3);

        jPanel18.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, 680, 240));

        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_pictures_folder_100px.png"))); // NOI18N
        jLabel93.setText("<html><h2>Choose Image </h2><h4>(  Of An Employee  )</h4></html>");
        jLabel93.setAlignmentY(0.0F);
        jLabel93.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel93.setDoubleBuffered(true);
        jLabel93.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel93.setIconTextGap(0);
        jLabel93.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel93MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel93MouseEntered(evt);
            }
        });
        jPanel18.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, 147, 29));

        ims2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel18.add(ims2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 380, 75, 29));

        jLabel116.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(0, 0, 255));
        jLabel116.setText("Active Sales_Persons List");
        jPanel18.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 250, 30));

        jScrollPane6.setViewportView(jPanel18);

        javax.swing.GroupLayout SalesPpanLayout = new javax.swing.GroupLayout(SalesPpan);
        SalesPpan.setLayout(SalesPpanLayout);
        SalesPpanLayout.setHorizontalGroup(
            SalesPpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
        );
        SalesPpanLayout.setVerticalGroup(
            SalesPpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalesPpanLayout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        card.add(SalesPpan, "card5");

        progress.setBackground(new java.awt.Color(153, 153, 255));
        progress.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PrgT.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        PrgT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Car_ID", "Cmp_Name", "Sales P_ID", "Sales p_Name", "Cust_ID", "Cust_Name", "Pay _ID", "Pay_Mode", "Total_Amt."
            }
        ));
        PrgT.setRowHeight(25);
        jScrollPane3.setViewportView(PrgT);

        progress.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1120, 620));

        esearch1.setBackground(new java.awt.Color(102, 255, 255));
        esearch1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        esearch1.setText("Search By Car Name");
        esearch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                esearch1MouseClicked(evt);
            }
        });
        esearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esearch1ActionPerformed(evt);
            }
        });
        esearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                esearch1KeyPressed(evt);
            }
        });
        progress.add(esearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 900, 48));

        jLabel32.setBackground(new java.awt.Color(0, 0, 153));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_search_48px.png"))); // NOI18N
        jLabel32.setOpaque(true);
        progress.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 55, -1));

        jLabel180.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel180.setForeground(new java.awt.Color(255, 0, 0));
        jLabel180.setText("Total Cars Sold Till Today");
        progress.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 240, -1));

        card.add(progress, "card6");

        BillSys.setBackground(new java.awt.Color(255, 255, 255));
        BillSys.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(0, 0, 0)), "Billing System", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Symbol", 1, 36))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(0, 0, 204)), "CAR Details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Symbol", 1, 30), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel38.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel38.setText("Price :-");

        B4.setEditable(false);
        B4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        B4.setOpaque(false);
        B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel39.setText("Model :-");

        B6.setEditable(false);
        B6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        B6.setOpaque(false);
        B6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B6ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel40.setText("CAR_Company :-");

        B5.setEditable(false);
        B5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        B5.setOpaque(false);
        B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel41.setText("Eng_Type :-");

        B2.setEditable(false);
        B2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        B2.setOpaque(false);
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel42.setText("CAR_ID :-");

        B3.setEditable(false);
        B3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        B3.setOpaque(false);
        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });

        B1.setEditable(false);
        B1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        B1.setOpaque(false);
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel43.setText("Color :-");

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Choose Another Car");
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setOpaque(true);
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B2))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B1)))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B5))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B6))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(74, 74, 74))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 1020, 250));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(0, 0, 255)), "Sales_Man Details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Symbol", 1, 30), new java.awt.Color(153, 0, 153))); // NOI18N

        jLabel44.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel44.setText("Name :-");

        jLabel45.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel45.setText("Seller_ID :-");

        sh5.setEditable(false);
        sh5.setBackground(new java.awt.Color(255, 255, 255));
        sh5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        sh5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sh5ActionPerformed(evt);
            }
        });

        sh4.setEditable(false);
        sh4.setBackground(new java.awt.Color(255, 255, 255));
        sh4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        sh4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sh4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sh4, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sh5, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sh5, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sh4))
                .addContainerGap())
        );

        jPanel10.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 1022, 114));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(0, 0, 204)), "Customer Details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Symbol", 1, 30))); // NOI18N

        jLabel46.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel46.setText("ID_Proof No :-");

        sa3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        sa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sa3ActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel47.setText("Phone :-");

        sa5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        sa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sa5ActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel48.setText("Name :-");

        jLabel49.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel49.setText("Address :-");

        sa2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        sa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sa2ActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel50.setText("Customer_ID :-");

        sa1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        sa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sa1ActionPerformed(evt);
            }
        });
        sa1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sa1KeyPressed(evt);
            }
        });

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        sa4.setColumns(20);
        sa4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        sa4.setRows(5);
        jScrollPane5.setViewportView(sa4);

        jButton11.setBackground(new java.awt.Color(0, 0, 255));
        jButton11.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Save Customer Details");
        jButton11.setContentAreaFilled(false);
        jButton11.setOpaque(true);
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton11MouseExited(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(102, 102, 102));
        jButton12.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Clear");
        jButton12.setContentAreaFilled(false);
        jButton12.setOpaque(true);
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton12MouseExited(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sa3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sa1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4))))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sa2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sa5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sa5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(sa1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sa2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sa3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel10.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 1020, 280));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(0, 0, 255)), "Payment Details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Symbol", 1, 30))); // NOI18N

        jLabel51.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel51.setText("Total Price :-");

        jLabel52.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel52.setText("Payment Mode :-");

        pa5.setEditable(false);
        pa5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        pa5.setForeground(new java.awt.Color(255, 0, 51));
        pa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pa5ActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel53.setText("Customer_ID :-");

        pa2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        pa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pa2ActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel55.setText("Payment_ID :-");

        pa1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        pa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pa1ActionPerformed(evt);
            }
        });

        pa4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        pa4.setForeground(new java.awt.Color(51, 51, 51));
        pa4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Card", "Cheque" }));

        jButton13.setBackground(new java.awt.Color(0, 0, 255));
        jButton13.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Save Payment Details");
        jButton13.setContentAreaFilled(false);
        jButton13.setOpaque(true);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(102, 102, 102));
        jButton14.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Clear");
        jButton14.setContentAreaFilled(false);
        jButton14.setOpaque(true);
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton14MouseExited(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pa2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pa1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pa5, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(pa4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(65, 65, 65))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pa1)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pa2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pa4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pa5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 720, 1020, 250));

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Cancel");
        jButton6.setContentAreaFilled(false);
        jButton6.setOpaque(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 980, 236, 58));

        jButton7.setBackground(new java.awt.Color(255, 102, 102));
        jButton7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Generate Bill");
        jButton7.setContentAreaFilled(false);
        jButton7.setOpaque(true);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 980, 304, 58));

        jLabel112.setForeground(new java.awt.Color(255, 51, 51));
        jLabel112.setText("* All Fields Are Compulsary.. *");
        jPanel10.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 190, 20));

        jLabel113.setForeground(new java.awt.Color(255, 51, 51));
        jLabel113.setText("* Fill ALL The Fields With Valid Input..*");
        jPanel10.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 270, 20));

        jScrollPane2.setViewportView(jPanel10);

        BillSys.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 770));

        card.add(BillSys, "card5");

        ProfilePan.setBackground(new java.awt.Color(204, 204, 255));
        ProfilePan.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 51, 51)), "Your Profile", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Symbol", 1, 48))); // NOI18N
        ProfilePan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 255), 3, true), "Personal Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Algerian", 1, 36))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel5.setText("Your Name :-");

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel1.setText("Your ID Number :-");

        per1.setEditable(false);
        per1.setBackground(new java.awt.Color(255, 255, 255));
        per1.setFont(new java.awt.Font("Algerian", 1, 20)); // NOI18N
        per1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        per1.setBorder(null);
        per1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                per1ActionPerformed(evt);
            }
        });

        per2.setEditable(false);
        per2.setBackground(new java.awt.Color(255, 255, 255));
        per2.setFont(new java.awt.Font("Algerian", 1, 20)); // NOI18N
        per2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        per2.setBorder(null);
        per2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                per2ActionPerformed(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel88.setText("Salary :-");

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel6.setText("Phone No :-");

        jLabel7.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel7.setText("Address :-");

        per4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        per4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                per4ActionPerformed(evt);
            }
        });

        per5.setColumns(20);
        per5.setRows(5);
        jScrollPane13.setViewportView(per5);

        jButton19.setBackground(new java.awt.Color(0, 0, 255));
        jButton19.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("Update Your ( Phone/Address )");
        jButton19.setContentAreaFilled(false);
        jButton19.setOpaque(true);
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton19MouseExited(evt);
            }
        });
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        per3.setEditable(false);
        per3.setBackground(new java.awt.Color(255, 255, 255));
        per3.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        per3.setForeground(new java.awt.Color(255, 0, 51));
        per3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        per3.setBorder(null);
        per3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                per3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(per1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(per4))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(per2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(per3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(per1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(per4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(per3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(per2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1090, 340));

        jPanel31.setBackground(new java.awt.Color(204, 255, 255));
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 4, true), "Security", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 3, 36), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel89.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel89.setText("To Change your Password :-");

        jLabel90.setBackground(new java.awt.Color(0, 0, 255));
        jLabel90.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("Click Here...");
        jLabel90.setOpaque(true);
        jLabel90.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel90MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel90MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel90MouseExited(evt);
            }
        });

        jLabel91.setBackground(new java.awt.Color(0, 0, 255));
        jLabel91.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("Click Here...");
        jLabel91.setOpaque(true);
        jLabel91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel91MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel91MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel91MouseExited(evt);
            }
        });

        jLabel92.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel92.setText("To Change your PIN :-");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(822, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 1090, 300));

        ProfilePan.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 66, 1110, 740));

        SCard.setLayout(new java.awt.CardLayout());

        ChangePassWord.setBackground(new java.awt.Color(204, 204, 255));
        ChangePassWord.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 255)), "Change PassWord", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Symbol", 1, 36))); // NOI18N
        ChangePassWord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Current Password");
        ChangePassWord.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 167, 323, -1));

        a2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        a2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a2.setText("Enter Your Current PassWord");
        a2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                a2FocusGained(evt);
            }
        });
        a2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a2MouseClicked(evt);
            }
        });
        a2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a2ActionPerformed(evt);
            }
        });
        ChangePassWord.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 194, 323, 48));

        a3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        a3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a3.setText("Enter New PassWord");
        a3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                a3FocusGained(evt);
            }
        });
        a3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a3MouseClicked(evt);
            }
        });
        a3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a3ActionPerformed(evt);
            }
        });
        ChangePassWord.add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 295, 323, 48));

        jLabel9.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("New Password");
        ChangePassWord.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 268, 323, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Confirm Password");
        ChangePassWord.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 371, 323, -1));

        a1.setEditable(false);
        a1.setBackground(new java.awt.Color(255, 255, 255));
        a1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        a1.setForeground(new java.awt.Color(51, 255, 51));
        a1.setBorder(null);
        a1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                a1FocusGained(evt);
            }
        });
        a1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a1ActionPerformed(evt);
            }
        });
        ChangePassWord.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 101, 323, 48));

        jLabel29.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Your Employee ID No.");
        ChangePassWord.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 74, 323, -1));

        a4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 15)); // NOI18N
        a4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a4.setText("Password");
        a4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                a4FocusGained(evt);
            }
        });
        a4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a4MouseClicked(evt);
            }
        });
        ChangePassWord.add(a4, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 398, 323, 46));

        jButton15.setBackground(new java.awt.Color(0, 51, 255));
        jButton15.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Submit");
        jButton15.setContentAreaFilled(false);
        jButton15.setOpaque(true);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        ChangePassWord.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 470, 177, 44));

        jButton16.setBackground(new java.awt.Color(255, 255, 102));
        jButton16.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 0, 51));
        jButton16.setText("Cancel");
        jButton16.setContentAreaFilled(false);
        jButton16.setOpaque(true);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        ChangePassWord.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 470, 177, 44));

        SCard.add(ChangePassWord, "card2");

        pinchange.setBackground(new java.awt.Color(255, 153, 255));
        pinchange.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 0)), "Change PIN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Symbol", 1, 36), new java.awt.Color(0, 0, 255))); // NOI18N
        pinchange.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Current Password");
        pinchange.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 167, 323, -1));

        a6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        a6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a6.setText("Enter Your Current PassWord");
        a6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                a6FocusGained(evt);
            }
        });
        a6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a6MouseClicked(evt);
            }
        });
        a6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a6ActionPerformed(evt);
            }
        });
        pinchange.add(a6, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 194, 323, 48));

        a7.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        a7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a7.setText("Enter New PassWord");
        a7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                a7FocusGained(evt);
            }
        });
        a7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a7MouseClicked(evt);
            }
        });
        a7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a7ActionPerformed(evt);
            }
        });
        pinchange.add(a7, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 295, 323, 48));

        jLabel85.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("New PIN");
        pinchange.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 268, 323, -1));

        jLabel86.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("Confirm PIN");
        pinchange.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 371, 323, -1));

        a5.setEditable(false);
        a5.setBackground(new java.awt.Color(255, 255, 255));
        a5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        a5.setForeground(new java.awt.Color(51, 255, 51));
        a5.setBorder(null);
        a5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                a5FocusGained(evt);
            }
        });
        a5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a5ActionPerformed(evt);
            }
        });
        pinchange.add(a5, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 101, 323, 48));

        jLabel87.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("Your Employee ID No.");
        pinchange.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 74, 323, -1));

        a8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 15)); // NOI18N
        a8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a8.setText("Password");
        a8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                a8FocusGained(evt);
            }
        });
        a8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a8MouseClicked(evt);
            }
        });
        pinchange.add(a8, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 398, 323, 46));

        jButton17.setBackground(new java.awt.Color(0, 51, 255));
        jButton17.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Submit");
        jButton17.setContentAreaFilled(false);
        jButton17.setOpaque(true);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        pinchange.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 177, 44));

        jButton18.setBackground(new java.awt.Color(255, 255, 102));
        jButton18.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 0, 51));
        jButton18.setText("Cancel");
        jButton18.setContentAreaFilled(false);
        jButton18.setOpaque(true);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        pinchange.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 177, 44));

        SCard.add(pinchange, "card2");

        ProfilePan.add(SCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 172, 411, 540));

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_pictures_folder_100px.png"))); // NOI18N
        jLabel37.setText("<html><h2>Choose Image </h2><h4>(  Of An Employee  )</h4></html>");
        jLabel37.setAlignmentY(0.0F);
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel37.setDoubleBuffered(true);
        jLabel37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel37.setIconTextGap(0);
        jLabel37.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });

        ims.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ims, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1032, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ims, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ProfilePan.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 810, 1120, 10));

        card.add(ProfilePan, "card8");

        GBill.setBackground(new java.awt.Color(255, 255, 255));

        G1.setBackground(new java.awt.Color(255, 255, 255));
        G1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        j26.setBackground(new java.awt.Color(255, 255, 255));
        j26.setForeground(new java.awt.Color(153, 0, 153));
        j26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel94.setFont(new java.awt.Font("Jokerman", 3, 55)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 255, 255));
        jLabel94.setText("P");
        jPanel29.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 53, 50));

        jLabel95.setFont(new java.awt.Font("Jokerman", 3, 55)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 0, 51));
        jLabel95.setText("V");
        jPanel29.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 50, 60));

        jLabel96.setFont(new java.awt.Font("Jokerman", 3, 55)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 255, 0));
        jLabel96.setText("R");
        jPanel29.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 50, 50));

        jLabel97.setFont(new java.awt.Font("Tahoma", 3, 55)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 51, 204));
        jLabel97.setText("Auto");
        jPanel29.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 142, 50));

        jLabel98.setFont(new java.awt.Font("Tahoma", 3, 55)); // NOI18N
        jLabel98.setText("Show");
        jPanel29.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 162, 50));

        jLabel99.setBackground(new java.awt.Color(0, 0, 0));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icons8_fiat_500_100px.png"))); // NOI18N
        jLabel99.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel99.setOpaque(true);
        jPanel29.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 120));

        jLabel100.setFont(new java.awt.Font("Tahoma", 3, 55)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 0, 51));
        jLabel100.setText("Room");
        jPanel29.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 169, 50));

        jTextField42.setEditable(false);
        jTextField42.setBackground(new java.awt.Color(102, 255, 102));
        jTextField42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField42.setForeground(new java.awt.Color(51, 51, 0));
        jTextField42.setText("*****************");
        jTextField42.setBorder(null);
        jTextField42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField42ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextField42, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 90, 20));

        jTextField43.setEditable(false);
        jTextField43.setBackground(new java.awt.Color(51, 255, 255));
        jTextField43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField43.setForeground(new java.awt.Color(51, 51, 0));
        jTextField43.setText("*****************************");
        jTextField43.setBorder(null);
        jTextField43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField43ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextField43, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 200, 20));

        jTextField44.setEditable(false);
        jTextField44.setBackground(new java.awt.Color(255, 0, 51));
        jTextField44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField44.setForeground(new java.awt.Color(51, 51, 0));
        jTextField44.setText("*****************");
        jTextField44.setBorder(null);
        jTextField44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField44ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextField44, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 190, 20));

        jTextField45.setEditable(false);
        jTextField45.setBackground(new java.awt.Color(255, 0, 0));
        jTextField45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField45.setForeground(new java.awt.Color(255, 255, 255));
        jTextField45.setText("*****************");
        jTextField45.setBorder(null);
        jTextField45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField45ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextField45, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 180, 20));

        jTextField46.setEditable(false);
        jTextField46.setBackground(new java.awt.Color(102, 255, 102));
        jTextField46.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField46.setForeground(new java.awt.Color(51, 51, 0));
        jTextField46.setText("*****************");
        jTextField46.setBorder(null);
        jTextField46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField46ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextField46, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 90, 20));

        jTextField47.setEditable(false);
        jTextField47.setBackground(new java.awt.Color(0, 0, 0));
        jTextField47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField47.setForeground(new java.awt.Color(255, 255, 255));
        jTextField47.setText("*****************");
        jTextField47.setBorder(null);
        jTextField47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField47ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextField47, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 110, 20));

        jTextField48.setEditable(false);
        jTextField48.setBackground(new java.awt.Color(51, 255, 255));
        jTextField48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField48.setForeground(new java.awt.Color(51, 51, 0));
        jTextField48.setText("*****************************");
        jTextField48.setBorder(null);
        jTextField48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField48ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextField48, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 220, 20));

        jLabel54.setBackground(new java.awt.Color(255, 255, 255));
        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(51, 51, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("........Best In Town Since 1992......");
        jPanel29.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 500, 25));

        j26.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        logo1.setBackground(new java.awt.Color(255, 255, 255));
        logo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO.png"))); // NOI18N
        logo1.setOpaque(true);
        j26.add(logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 230, 155));

        logo2.setBackground(new java.awt.Color(255, 255, 255));
        logo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO.png"))); // NOI18N
        logo2.setOpaque(true);
        j26.add(logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 100, 230, 155));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true), "Sailor Details :-", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Symbol", 1, 30), new java.awt.Color(204, 0, 255))); // NOI18N

        jLabel76.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel76.setText("Name :-");

        jLabel77.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel77.setText("Seller_ID :-");

        nb.setEditable(false);
        nb.setBackground(new java.awt.Color(255, 255, 255));
        nb.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        nb.setBorder(null);
        nb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nbActionPerformed(evt);
            }
        });

        na.setEditable(false);
        na.setBackground(new java.awt.Color(255, 255, 255));
        na.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        na.setBorder(null);
        na.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(na, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nb, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nb, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                            .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(na)))
        );

        j26.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, 960, -1));

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true), "Customer Details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Symbol", 1, 30), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel101.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel101.setText("ID_Proof No :-");

        fp9.setEditable(false);
        fp9.setBackground(new java.awt.Color(255, 255, 255));
        fp9.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        fp9.setBorder(null);
        fp9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fp9ActionPerformed(evt);
            }
        });

        jLabel102.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel102.setText("Phone :-");

        fp11.setEditable(false);
        fp11.setBackground(new java.awt.Color(255, 255, 255));
        fp11.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        fp11.setBorder(null);
        fp11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fp11ActionPerformed(evt);
            }
        });

        jLabel103.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel103.setText("Name :-");

        jLabel104.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel104.setText("Address :-");

        fp8.setEditable(false);
        fp8.setBackground(new java.awt.Color(255, 255, 255));
        fp8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        fp8.setBorder(null);
        fp8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fp8ActionPerformed(evt);
            }
        });

        jLabel105.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel105.setText("Customer_ID :-");

        fp7.setEditable(false);
        fp7.setBackground(new java.awt.Color(255, 255, 255));
        fp7.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        fp7.setBorder(null);
        fp7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fp7ActionPerformed(evt);
            }
        });

        jScrollPane14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane14.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        fp10.setEditable(false);
        fp10.setColumns(20);
        fp10.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        fp10.setRows(5);
        fp10.setBorder(null);
        jScrollPane14.setViewportView(fp10);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fp9, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fp7, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel104, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel101, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fp8, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(fp11))
                .addGap(53, 53, 53))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fp11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fp7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fp8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fp9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        j26.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 680, 960, -1));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Payment Details :-", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Symbol", 1, 30), new java.awt.Color(204, 0, 204))); // NOI18N

        jLabel106.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel106.setText("Total Price :-");

        jLabel107.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel107.setText("Payment Mode :-");

        fp15.setEditable(false);
        fp15.setBackground(new java.awt.Color(255, 255, 255));
        fp15.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        fp15.setForeground(new java.awt.Color(255, 0, 51));
        fp15.setBorder(null);
        fp15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fp15ActionPerformed(evt);
            }
        });

        jLabel108.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel108.setText("Customer_ID :-");

        fp13.setEditable(false);
        fp13.setBackground(new java.awt.Color(255, 255, 255));
        fp13.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        fp13.setBorder(null);
        fp13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fp13ActionPerformed(evt);
            }
        });

        jLabel110.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel110.setText("Payment_ID :-");

        fp12.setEditable(false);
        fp12.setBackground(new java.awt.Color(255, 255, 255));
        fp12.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        fp12.setBorder(null);
        fp12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fp12ActionPerformed(evt);
            }
        });

        fp14.setEditable(false);
        fp14.setBackground(new java.awt.Color(255, 255, 255));
        fp14.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        fp14.setBorder(null);
        fp14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fp14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fp14))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fp12, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fp15, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(fp13))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fp13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fp14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fp12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fp15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        j26.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 890, 960, -1));

        jPanel36.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        j26.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 1030, -1));

        jPanel37.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        j26.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 1020, 20));

        Da.setEditable(false);
        Da.setBackground(new java.awt.Color(255, 255, 255));
        Da.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        Da.setForeground(new java.awt.Color(255, 0, 51));
        Da.setBorder(null);
        Da.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DaActionPerformed(evt);
            }
        });
        j26.add(Da, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 170, -1));

        Time.setEditable(false);
        Time.setBackground(new java.awt.Color(255, 255, 255));
        Time.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 0, 51));
        Time.setBorder(null);
        j26.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 170, 30));

        jLabel114.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel114.setText("DATE :-");
        j26.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 104, 31));

        jLabel118.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel118.setText("TIME :-");
        j26.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, 104, 44));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 51), 1, true), "CAR Details :-", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Symbol", 1, 30), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel72.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel72.setText("Car_Company :-");

        fp1.setEditable(false);
        fp1.setBackground(new java.awt.Color(255, 255, 255));
        fp1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        fp1.setBorder(null);
        fp1.setOpaque(false);
        fp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fp1ActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel74.setText("Car_ID :-");

        fp2.setEditable(false);
        fp2.setBackground(new java.awt.Color(255, 255, 255));
        fp2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        fp2.setBorder(null);
        fp2.setOpaque(false);
        fp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fp2ActionPerformed(evt);
            }
        });

        fp6.setEditable(false);
        fp6.setBackground(new java.awt.Color(255, 255, 255));
        fp6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        fp6.setBorder(null);
        fp6.setOpaque(false);
        fp6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fp6ActionPerformed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel73.setText("Eng_Type :-");

        jLabel71.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel71.setText("Model :-");

        jLabel70.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel70.setText("Price :-");

        fp5.setEditable(false);
        fp5.setBackground(new java.awt.Color(255, 255, 255));
        fp5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        fp5.setBorder(null);
        fp5.setOpaque(false);
        fp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fp5ActionPerformed(evt);
            }
        });

        fp3.setEditable(false);
        fp3.setBackground(new java.awt.Color(255, 255, 255));
        fp3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        fp3.setBorder(null);
        fp3.setOpaque(false);
        fp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fp3ActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel75.setText("Color :-");

        fp4.setEditable(false);
        fp4.setBackground(new java.awt.Color(255, 255, 255));
        fp4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        fp4.setBorder(null);
        fp4.setOpaque(false);
        fp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fp4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fp3))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fp2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fp1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fp6))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fp5))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fp4, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fp4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fp5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fp6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fp1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fp2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fp3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        j26.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 960, -1));

        jLabel109.setBackground(new java.awt.Color(255, 255, 255));
        jLabel109.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(51, 51, 255));
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setText("........PVR Auto ShowRoom......");
        j26.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 500, 25));

        jLabel119.setFont(new java.awt.Font("Algerian", 3, 48)); // NOI18N
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("CAR BILL");
        j26.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 440, 80));

        jLabel120.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel120.setText("5600444");
        j26.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 120, 30));

        jLabel121.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel121.setText("Place :- Bangalore");
        j26.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 230, 30));

        jLabel122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/QR_1.png"))); // NOI18N
        j26.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 1420, 940, 130));

        st4.setEditable(false);
        st4.setBackground(new java.awt.Color(255, 255, 255));
        st4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        st4.setForeground(new java.awt.Color(255, 0, 0));
        st4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        st4.setBorder(null);
        st4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                st4ActionPerformed(evt);
            }
        });
        j26.add(st4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 1550, 200, 40));

        st1.setEditable(false);
        st1.setBackground(new java.awt.Color(255, 255, 255));
        st1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        st1.setForeground(new java.awt.Color(255, 0, 0));
        st1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        st1.setBorder(null);
        st1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                st1ActionPerformed(evt);
            }
        });
        j26.add(st1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 1550, 140, 40));

        st2.setEditable(false);
        st2.setBackground(new java.awt.Color(255, 255, 255));
        st2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        st2.setForeground(new java.awt.Color(255, 0, 0));
        st2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        st2.setBorder(null);
        st2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                st2ActionPerformed(evt);
            }
        });
        j26.add(st2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 1550, 140, 40));

        st3.setEditable(false);
        st3.setBackground(new java.awt.Color(255, 255, 255));
        st3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        st3.setForeground(new java.awt.Color(255, 0, 0));
        st3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        st3.setBorder(null);
        st3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                st3ActionPerformed(evt);
            }
        });
        j26.add(st3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 1550, 180, 40));

        jPanel26.setBackground(new java.awt.Color(51, 51, 51));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel123.setBackground(new java.awt.Color(0, 0, 0));
        jLabel123.setFont(new java.awt.Font("Algerian", 1, 100)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setText("I");
        jPanel26.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 173, 130, 104));

        jLabel124.setBackground(new java.awt.Color(0, 0, 0));
        jLabel124.setFont(new java.awt.Font("Algerian", 1, 100)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 255, 255));
        jLabel124.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel124.setText("N");
        jPanel26.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 284, 130, 104));

        jLabel125.setBackground(new java.awt.Color(0, 0, 0));
        jLabel125.setFont(new java.awt.Font("Algerian", 1, 100)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 255, 255));
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel125.setText("V");
        jPanel26.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 395, 130, 104));

        jLabel126.setBackground(new java.awt.Color(0, 0, 0));
        jLabel126.setFont(new java.awt.Font("Algerian", 1, 100)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(255, 255, 255));
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel126.setText("O");
        jPanel26.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 506, 130, 104));

        jLabel127.setBackground(new java.awt.Color(0, 0, 0));
        jLabel127.setFont(new java.awt.Font("Algerian", 1, 100)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(255, 255, 255));
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel127.setText("I");
        jPanel26.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 617, 130, 104));

        jLabel128.setBackground(new java.awt.Color(0, 0, 0));
        jLabel128.setFont(new java.awt.Font("Algerian", 1, 100)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(255, 255, 255));
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setText("C");
        jPanel26.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 728, 130, 104));

        jLabel129.setBackground(new java.awt.Color(0, 0, 0));
        jLabel129.setFont(new java.awt.Font("Algerian", 1, 100)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(255, 255, 255));
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel129.setText("E");
        jPanel26.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 839, 130, 104));

        j26.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 1150));

        jPanel38.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1530, Short.MAX_VALUE)
        );

        j26.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 350, 50, 1530));

        jLabel166.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel166.setText("Bidhrahli, Bangalore");
        j26.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 220, 30));

        jLabel167.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel167.setText("Address:-");
        j26.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 100, 30));

        jLabel168.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel168.setText("East Point Collage Of Eng & Tech...");
        j26.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 230, 30));

        jLabel169.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel169.setText("5600399");
        j26.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 100, 30));

        jLabel170.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel170.setText("959542125332");
        j26.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 320, 160, 20));

        jLabel171.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel171.setText("Contect :-");
        j26.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 300, 70, 20));

        jLabel172.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel172.setText("080-26262662");
        j26.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 300, 160, 20));

        jLabel173.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel173.setText("We (PVR) Accepts That This Bill Is Inclusive All The VAT And all Charges");
        j26.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1070, 950, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        j26.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 1340, 340, 10));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        j26.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1340, 340, 10));

        jLabel174.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel174.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel174.setText("Signature Of Customer");
        j26.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 1350, 320, 30));

        jLabel175.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel175.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel175.setText("Signature Of Sales_Person");
        j26.add(jLabel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 1350, 320, 30));

        jLabel176.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AIcon/sa2.png"))); // NOI18N
        j26.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 1150, 360, 180));

        jLabel177.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AIcon/sa1.png"))); // NOI18N
        j26.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1150, 360, 180));

        jScrollPane12.setViewportView(j26);

        G1.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 710));

        jButton20.setBackground(new java.awt.Color(0, 0, 204));
        jButton20.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Print Bill");
        jButton20.setContentAreaFilled(false);
        jButton20.setOpaque(true);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        G1.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 720, 710, 40));

        javax.swing.GroupLayout GBillLayout = new javax.swing.GroupLayout(GBill);
        GBill.setLayout(GBillLayout);
        GBillLayout.setHorizontalGroup(
            GBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(G1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        GBillLayout.setVerticalGroup(
            GBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GBillLayout.createSequentialGroup()
                .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        card.add(GBill, "card9");

        About.setBackground(new java.awt.Color(255, 255, 255));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel130.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel130.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel130.setText("MY Car ShowRoom");
        jPanel40.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 0, 389, 49));

        jLabel131.setForeground(new java.awt.Color(255, 0, 51));
        jLabel131.setText("@About Page");
        jPanel40.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 185, 30));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel152.setBackground(new java.awt.Color(255, 255, 255));
        jLabel152.setFont(new java.awt.Font("Yu Gothic UI Semilight", 3, 24)); // NOI18N
        jLabel152.setText("PVR Auto SHowRoom is A Car ShowRoom System.");
        jPanel41.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 2, 1058, 41));

        jLabel153.setBackground(new java.awt.Color(255, 255, 255));
        jLabel153.setFont(new java.awt.Font("Yu Gothic UI Semilight", 3, 24)); // NOI18N
        jLabel153.setText("Admin Act As The Magager Of The Store And Manages The Sales Person And The Car Store.");
        jPanel41.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 1058, 41));

        jLabel154.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(255, 102, 102));
        jLabel154.setText("*");
        jPanel41.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 40, 50));

        jLabel155.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(255, 102, 102));
        jLabel155.setText("*");
        jPanel41.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));

        jLabel156.setBackground(new java.awt.Color(255, 255, 255));
        jLabel156.setFont(new java.awt.Font("Yu Gothic UI Semilight", 3, 24)); // NOI18N
        jLabel156.setText("It Is a Offline Store To generate the Bills For The cars Being Sold.");
        jPanel41.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 1058, 41));

        jLabel157.setBackground(new java.awt.Color(255, 255, 255));
        jLabel157.setFont(new java.awt.Font("Yu Gothic UI Semilight", 3, 24)); // NOI18N
        jLabel157.setText("It Has Two Face     1. Admin    And    2. Sales_person . ");
        jPanel41.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 1058, 41));

        jLabel158.setBackground(new java.awt.Color(255, 255, 255));
        jLabel158.setFont(new java.awt.Font("Yu Gothic UI Semilight", 3, 24)); // NOI18N
        jLabel158.setText("Finally The Generated Bill IS Printed And ALL The Required Datas Are Stored InTo DataBase.");
        jPanel41.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 1058, 41));

        jLabel159.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(255, 102, 102));
        jLabel159.setText("*");
        jPanel41.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 40, 40));

        jLabel160.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(255, 102, 102));
        jLabel160.setText("*");
        jPanel41.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 40, 50));

        jLabel161.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(255, 102, 102));
        jLabel161.setText("*");
        jPanel41.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 40, 50));

        jLabel162.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(255, 102, 102));
        jLabel162.setText("*");
        jPanel41.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 40, 50));

        jLabel163.setBackground(new java.awt.Color(255, 255, 255));
        jLabel163.setFont(new java.awt.Font("Yu Gothic UI Semilight", 3, 24)); // NOI18N
        jLabel163.setText("Sales_person Act AS The Agent To Sale The Cars To Customers.");
        jPanel41.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 1058, 41));

        jPanel40.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1130, 240));

        jLabel151.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(153, 0, 153));
        jLabel151.setText("About Project");
        jPanel40.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 231, 30));

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));

        jSeparator1.setBackground(new java.awt.Color(255, 0, 51));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel133.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel133.setText("Santosh E");

        jLabel134.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel134.setText("1EP17CS076");

        jLabel135.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel135.setText("1EP17CS068");

        jLabel136.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel136.setText("Ranvijay Kumar Singh H");

        jLabel137.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel137.setText("Name :-");

        jLabel138.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel138.setText("USN :-");

        jLabel139.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel139.setText("Name :-");

        jLabel140.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel140.setText("USN :-");

        jLabel141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/download_2.jpg"))); // NOI18N

        jLabel142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/download_2.jpg"))); // NOI18N

        jLabel143.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel143.setText("Branch:-");

        jLabel144.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel144.setText("CSE");

        jLabel145.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel145.setText("5th");

        jLabel146.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel146.setText("SEM :-");

        jLabel147.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel147.setText("Branch:-");

        jLabel148.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel148.setText("CSE");

        jLabel149.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel149.setText("5th");

        jLabel150.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel150.setText("SEM :-");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel143)
                    .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jLabel141)
                .addGap(40, 40, 40)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel142)
                .addGap(24, 24, 24)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel147)
                    .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel141)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel142))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
        );

        jPanel40.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 1130, 210));

        jLabel132.setFont(new java.awt.Font("Algerian", 3, 24)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(0, 51, 255));
        jLabel132.setText("Project Done By :-");
        jPanel40.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 280, 40));

        jScrollPane15.setViewportView(jPanel40);

        javax.swing.GroupLayout AboutLayout = new javax.swing.GroupLayout(About);
        About.setLayout(AboutLayout);
        AboutLayout.setHorizontalGroup(
            AboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
        );
        AboutLayout.setVerticalGroup(
            AboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15)
        );

        card.add(About, "card10");

        p2.add(card, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 1160, 770));

        p1.add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, 820));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 /*{ @override
         public void action Perfomed(Action Event e)
         Date d=new Date();
         SimpleDateFormat s=new SimpleDateFormat("hh:mm:ss  ,a");
         Time.setText(s.format(d));
     }*/

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_closeMouseClicked

    private void minimiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimiseMouseClicked

        setState(JFrame.ICONIFIED);
// TODO add your handling code here:
    }//GEN-LAST:event_minimiseMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        close.setBackground(new Color(255, 0, 0));// TODO add your handling code here:
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        close.setBackground(new Color(255,255,255)); // TODO add your handling code here:
    }//GEN-LAST:event_closeMouseExited

    private void minimiseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimiseMouseEntered
        minimise.setBackground(new Color(255, 255,102)); // TODO add your handling code here:
    }//GEN-LAST:event_minimiseMouseEntered

    private void minimiseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimiseMouseExited
        minimise.setBackground(new Color(255,255,255)); // TODO add your handling code here:
    }//GEN-LAST:event_minimiseMouseExited

    private void l7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l7MouseExited
       l7.setBorder(new LineBorder(new Color(0,0,0),0));
    }//GEN-LAST:event_l7MouseExited

    private void l7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l7MouseEntered
        l7.setBorder(new LineBorder(new Color(0,0,0),2));
    }//GEN-LAST:event_l7MouseEntered

    private void l7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l7MouseClicked
        card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(About);
        card.repaint();
        card.revalidate();
        l7.setBackground(new Color(255, 255, 255));
        l7.setForeground(new Color(0, 0, 0));
        l2.setBackground(new Color(0,0,0));
        l2.setForeground(new Color(255,255,255));
        l4.setBackground(new Color(0,0,0));
        l4.setForeground(new Color(255,255,255));
        l5.setBackground(new Color(0,0,0));
        l5.setForeground(new Color(255,255,255));
        l9.setBackground(new Color(0,0,0));
        l9.setForeground(new Color(255,255,255));
        l1.setBackground(new Color(0,0,0));
        l1.setForeground(new Color(255,255,255));
        s7.setBackground(new Color(255, 0, 0));
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s7.setVisible(true);
        s4.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(false);
        s2.setVisible(false);
    }//GEN-LAST:event_l7MouseClicked

    private void l4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4MouseExited
        l4.setBorder(new LineBorder(new Color(0,0,0),0));
    }//GEN-LAST:event_l4MouseExited

    private void l4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4MouseEntered
       l4.setBorder(new LineBorder(new Color(0,0,0),2));
    }//GEN-LAST:event_l4MouseEntered

    private void l4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4MouseClicked
        Show_PrgDel();
        card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(progress);
        card.repaint();
        card.revalidate();
        l4.setBackground(new Color(255, 255, 255));
        l4.setForeground(new Color(0, 0, 0));
        l2.setBackground(new Color(0,0,0));
        l2.setForeground(new Color(255,255,255));
        l1.setBackground(new Color(0,0,0));
        l1.setForeground(new Color(255,255,255));
        l5.setBackground(new Color(0,0,0));
        l5.setForeground(new Color(255,255,255));
        l9.setBackground(new Color(0,0,0));
        l9.setForeground(new Color(255,255,255));
        l7.setBackground(new Color(0,0,0));
        l7.setForeground(new Color(255,255,255));

        //l4.setBackground(new Color(255,255,255));
        s4.setBackground(new Color(255, 0, 0));
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s4.setVisible(true);
        s2.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(false);
        s7.setVisible(false);
       
    }//GEN-LAST:event_l4MouseClicked

    private void l2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l2MouseExited
        l2.setBorder(new LineBorder(new Color(0,0,0),0));
    }//GEN-LAST:event_l2MouseExited

    private void l2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l2MouseEntered
       l2.setBorder(new LineBorder(new Color(0,0,0),2));
    }//GEN-LAST:event_l2MouseEntered

    private void l2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l2MouseClicked
         Show_Car();
         card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(addcar);
        card.repaint();
        card.revalidate();
        l2.setBackground(new Color(255, 255, 255));
        l2.setForeground(new Color(0, 0, 0));
        l1.setBackground(new Color(0,0,0));
        l1.setForeground(new Color(255,255,255));
        l4.setBackground(new Color(0,0,0));
        l4.setForeground(new Color(255,255,255));
        l5.setBackground(new Color(0,0,0));
        l5.setForeground(new Color(255,255,255));
        l9.setBackground(new Color(0,0,0));
        l9.setForeground(new Color(255,255,255));
        l7.setBackground(new Color(0,0,0));
        l7.setForeground(new Color(255,255,255));

        s2.setBackground(new Color(255, 0, 0));
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s2.setVisible(true);
        s4.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(false);
        s7.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_l2MouseClicked

    private void l1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseExited
       l1.setBorder(new LineBorder(new Color(0,0,0),0));
    }//GEN-LAST:event_l1MouseExited

    private void l1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseEntered
        l1.setBorder(new LineBorder(new Color(0,0,0),2));
    }//GEN-LAST:event_l1MouseEntered

    private void l1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseClicked
        card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(chome);
        card.repaint();
        card.revalidate();
        
        l1.setBackground(new Color(255, 255, 255));
        l1.setForeground(new Color(0, 0, 0));
        l2.setBackground(new Color(0,0,0));
        l2.setForeground(new Color(255,255,255));
        l4.setBackground(new Color(0,0,0));
        l4.setForeground(new Color(255,255,255));
        l5.setBackground(new Color(0,0,0));
        l5.setForeground(new Color(255,255,255));
        l9.setBackground(new Color(0,0,0));
        l9.setForeground(new Color(255,255,255));
        l7.setBackground(new Color(0,0,0));
        l7.setForeground(new Color(255,255,255));

        s1.setBackground(new Color(255, 0, 0));

        s1.setVisible(true);
        s2.setVisible(false);
        s4.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(false);
        s7.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_l1MouseClicked

    private void l5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l5MouseClicked
        // TODO add your handling code here:
        card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(BillSys);
        card.repaint();
        card.revalidate();
        
        l5.setBackground(new Color(255, 255, 255));
        l5.setForeground(new Color(0, 0, 0));
        l2.setBackground(new Color(0,0,0));
        l2.setForeground(new Color(255,255,255));
        l4.setBackground(new Color(0,0,0));
        l4.setForeground(new Color(255,255,255));
        l1.setBackground(new Color(0,0,0));
        l1.setForeground(new Color(255,255,255));
        l9.setBackground(new Color(0,0,0));
        l9.setForeground(new Color(255,255,255));
        l7.setBackground(new Color(0,0,0));
        l7.setForeground(new Color(255,255,255));

        s5.setBackground(new Color(255, 0, 0));
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s2.setVisible(false);
        s4.setVisible(false);
        s5.setVisible(true);
        s6.setVisible(false);
        s7.setVisible(false);
    }//GEN-LAST:event_l5MouseClicked

    private void l5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l5MouseEntered
        l5.setBorder(new LineBorder(new Color(0,0,0),2));
    }//GEN-LAST:event_l5MouseEntered

    private void l5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l5MouseExited
        l5.setBorder(new LineBorder(new Color(0,0,0),0));
    }//GEN-LAST:event_l5MouseExited

    private void einsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_einsertActionPerformed
        //ps.setString(2,jTextField2_name.getText().toString());
        //ps.setInt(1,Integer.parseInt(jTextField1_id.getText().toString()));
        /* try    
            {
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Ranvijay", "maindata","1234");
                String sql="INSERT INTO EMPDETAILS(SSID,SNAME,SSEX,SPHN,SADR,SIDPT,SIDNO,SSAL,EIMG) VALUES(?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst= con.prepareStatement(sql);
                pst.setInt(1,Integer.parseInt(eid.getText().toString()));
                pst.setString(2,ename.getText().toString());
                String sex;
                pst.setString(3, epo.getText().toString());
                pst.setString(4,sex=esex.getSelectedItem().toString());
                pst.setString(5,eadr.getText().toString());
                String IDT;
                pst.setString(6,IDT= eidtype.getSelectedItem().toString());
                pst.setString(7,eidno.getText().toString());
                pst.setString(8,esal.getText().toString());
                //InputStream j=new FileInputStream(new File (photopath));
                pst.setBytes(9, EIMG);
                Show_User();
                pst.close();
                JOptionPane.showMessageDialog(null, "Submitted Succesfully");
            }
            catch (SQLException ex)
            {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE,null,ex);
            }
            catch(Exception e1)
            {
                e1.printStackTrace();
            }*/

        String a = eid.getText();
        String b = ename.getText();
        String sex;
        sex = esex.getSelectedItem().toString();
        String c = epo.getText();
        String d = eadr.getText();
        String IDT;
        IDT = eidtype.getSelectedItem().toString();
        String e = eidno.getText();
        String i = esal.getText();
        String j = ims2.getText();
        // byte[] EIMG;
        // EIMG=image.replace("\\","\\\\");

       String currentDir=System.getProperty("user.dir");
         try
   {  
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            String sql = "INSERT INTO MAINDATA.EMPDETAILS(SSID,SNAME,SSEX,SPHN,SADR,SIDPT,SIDNO,SSAL) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, a);
            pst.setString(2, b);
            pst.setString(3, sex);
            pst.setString(4, c);
            pst.setString(5, d);
            pst.setString(6, IDT);
            pst.setString(7, e);
            pst.setString(8, i);
            //InputStream is=new FileInputStream(new File(photopath));
            // pst.setString(9, j);
            //pst.setBinaryStream(9,(InputStream)fin,(int)imgfile.length());
            pst.executeUpdate();
            Show_User();
            pst.close();
        } catch (SQLTransactionRollbackException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_einsertActionPerformed
    private void esalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esalActionPerformed

    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c1ActionPerformed

    private void eidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eidActionPerformed

    private void homecsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homecsMouseClicked

        s2.setBackground(new Color(255, 0, 0));
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s2.setVisible(true);
        s4.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(false);
        s7.setVisible(false);

        card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(addcar);
        card.repaint();
        card.revalidate();
        l1.setBackground(new Color(255, 255, 255));
        l1.setForeground(new Color(0, 0, 0));
        l2.setBackground(new Color(0,0,0));
        l2.setForeground(new Color(255,255,255));
        l4.setBackground(new Color(0,0,0));
        l4.setForeground(new Color(255,255,255));
        l5.setBackground(new Color(0,0,0));
        l5.setForeground(new Color(255,255,255));
        l9.setBackground(new Color(0,0,0));
        l9.setForeground(new Color(255,255,255));
        l7.setBackground(new Color(0,0,0));
        l7.setForeground(new Color(255,255,255));

// TODO add your handling code here:
    }//GEN-LAST:event_homecsMouseClicked

    private void homeempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeempMouseClicked

       
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s2.setVisible(false);
        s4.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(false);
        s7.setVisible(false);

        card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(SalesPpan);
        card.repaint();
        card.revalidate();
        l5.setBackground(new Color(255, 255, 255));
        l5.setForeground(new Color(0, 0, 0));
        l2.setBackground(new Color(0,0,0));
        l2.setForeground(new Color(255,255,255));
        l4.setBackground(new Color(0,0,0));
        l4.setForeground(new Color(255,255,255));
        l1.setBackground(new Color(0,0,0));
        l1.setForeground(new Color(255,255,255));
        l9.setBackground(new Color(0,0,0));
        l9.setForeground(new Color(255,255,255));
        l7.setBackground(new Color(0,0,0));
        l7.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_homeempMouseClicked

    private void homeprgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeprgMouseClicked

        s4.setBackground(new Color(255, 0, 0));
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s4.setVisible(true);
        s2.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(false);
        s7.setVisible(false);

        card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(progress);
        card.repaint();
        card.revalidate();
       l4.setBackground(new Color(255, 255, 255));
        l4.setForeground(new Color(0, 0, 0));
        l2.setBackground(new Color(0,0,0));
        l2.setForeground(new Color(255,255,255));
        l1.setBackground(new Color(0,0,0));
        l1.setForeground(new Color(255,255,255));
        l5.setBackground(new Color(0,0,0));
        l5.setForeground(new Color(255,255,255));
        l9.setBackground(new Color(0,0,0));
        l9.setForeground(new Color(255,255,255));
        l7.setBackground(new Color(0,0,0));
        l7.setForeground(new Color(255,255,255));

    }//GEN-LAST:event_homeprgMouseClicked

    private void euidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_euidKeyReleased
        String a = euid.getText();
        eps.setText(a);
        epn.setText(a);// TODO add your handling code here:
    }//GEN-LAST:event_euidKeyReleased

    private void homecsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_homecsFocusGained
        homecs.setBorder(new LineBorder(new Color(0, 255, 255), 1));
    }//GEN-LAST:event_homecsFocusGained

    private void homecsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_homecsFocusLost
        homecs.setBorder(new LineBorder(new Color(255, 255, 255), 1));
    }//GEN-LAST:event_homecsFocusLost

    private void homeempFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_homeempFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_homeempFocusGained

    private void homeempFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_homeempFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_homeempFocusLost

    private void homeprgFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_homeprgFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_homeprgFocusGained

    private void homeprgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_homeprgFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_homeprgFocusLost

    private void homecsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homecsMouseEntered
        homecs.setBorder(new LineBorder(new Color(255, 255, 255), 5));
    }//GEN-LAST:event_homecsMouseEntered

    private void homecsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homecsMouseExited
        homecs.setBorder(new LineBorder(new Color(255, 255, 255)));
    }//GEN-LAST:event_homecsMouseExited

    private void homeempMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeempMouseEntered
        homeemp.setBorder(new LineBorder(new Color(255, 255, 255), 5));
    }//GEN-LAST:event_homeempMouseEntered

    private void homeempMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeempMouseExited
        homeemp.setBorder(new LineBorder(new Color(255, 255, 255, 0)));
    }//GEN-LAST:event_homeempMouseExited

    private void homeprgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeprgMouseEntered
        homeprg.setBorder(new LineBorder(new Color(255, 255, 255), 5));
    }//GEN-LAST:event_homeprgMouseEntered

    private void homeprgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeprgMouseExited
        homeprg.setBorder(new LineBorder(new Color(255, 255, 255, 0)));
    }//GEN-LAST:event_homeprgMouseExited

    private void esearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_esearchMouseClicked
        esearch.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_esearchMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        DefaultTableModel df = (DefaultTableModel) ct1.getModel();
        int selectedIndex = ct1.getSelectedRow();
        String currentDir=System.getProperty("user.dir");
        try {
            int ENO = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To DELETE the Selected Record", "warning", JOptionPane.YES_NO_CANCEL_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION);
{
    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
                String sql = ("DELETE FROM MAINDATA.CARDETAILS WHERE ENO=? ");
                PreparedStatement pst = con.prepareStatement(sql);

                pst.setInt(1, ENO);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Submitted Succesfully");
                Show_Car();
                pst.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException | NumberFormatException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void edelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edelActionPerformed
        DefaultTableModel df = (DefaultTableModel) T1.getModel();
        int selectedIndex = T1.getSelectedRow();
        String currentDir=System.getProperty("user.dir");
        try {
            int SSID = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To DELETE the Selected Record", "warning", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION)

            {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
                String sql = ("DELETE FROM MAINDATA.EMPDETAILS WHERE SSID=? ");
                PreparedStatement pst = con.prepareStatement(sql);

                pst.setInt(1, SSID);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Submitted Succesfully");
                Show_User();
                pst.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException | NumberFormatException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_edelActionPerformed

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        A_Login_Page ap = new A_Login_Page();

        ap.setVisible(true);
        ap.pack();
        ap.setLocationRelativeTo(null);
        ap.setDefaultCloseOperation(A_Login_Page.EXIT_ON_CLOSE);
        this.dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

    private void esearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_esearch1MouseClicked
       esearch1.setText("");
    }//GEN-LAST:event_esearch1MouseClicked

    private void esearch2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_esearch2MouseClicked
       esearch2.setText("");
    }//GEN-LAST:event_esearch2MouseClicked

    private void esearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esearch2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esearch2ActionPerformed

    private void esexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esexActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String a = euid.getText();
        String b = eps.getText();

        String c = epn.getText();
        String d = ename.getText();
        String sex;
        sex = esex.getSelectedItem().toString();

        String e = epo.getText();
        String f = eadr.getText();
        String i = esal.getText();
         String currentDir=System.getProperty("user.dir");
        try
   {  
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            String sql = "INSERT INTO MAINDATA.EMPLOG(EID,EPS,EPIN,ENAME,ESEX,EPHN,EADR,ESAL) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, a);
            pst.setString(2, b);

            pst.setString(3, c);
            pst.setString(4, d);
            pst.setString(5, sex);
            pst.setString(6, e);
            pst.setString(7, f);
            pst.setString(8, i);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "New SAILOE CREATED Succesfully");
            Show_SAdmin();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void eupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eupdateActionPerformed
        DefaultTableModel df = (DefaultTableModel) T1.getModel();
        int selectedIndex = T1.getSelectedRow();
        String currentDir=System.getProperty("user.dir");
        try {
            int SSID = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            String a = eid.getText();
            String b = ename.getText();
            String sex;
            sex = esex.getSelectedItem().toString();
            String c = epo.getText();
            String d = eadr.getText();
            String IDT;
            IDT = eidtype.getSelectedItem().toString();
            String e = eidno.getText();
            String i = esal.getText();
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            String sql = "UPDATE MAINDATA.EMPDETAILS SET SNAME=?,SSEX=?,SPHN=?,SADR=?,SIDPT=?,SIDNO=?,SSAL=? WHERE SSID=? ";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, b);
                pst.setString(2, sex);
                pst.setString(3, c);
                pst.setString(4, d);
                pst.setString(5, IDT);
                pst.setString(6, e);
                pst.setString(7, i);
                pst.setString(8, a);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Submitted Succesfully");
                Show_User();
                pst.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException | NumberFormatException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_eupdateActionPerformed

    private void eidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eidKeyReleased
        String a = eid.getText();
        euid.setText(a);
        eps.setText(a);
        epn.setText(a);

    }//GEN-LAST:event_eidKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String a = c1.getText();B1.setText(a);fp1.setText(a);
        String b = c2.getText();B2.setText(b);fp2.setText(b);
        String c = c3.getText();B5.setText(c);fp5.setText(c);
        String d = c4.getText();B3.setText(d);fp4.setText(d);
       String ETYPE = c8.getText();B4.setText(ETYPE);fp6.setText(ETYPE);fp15.setText(ETYPE);
        String f = c7.getText();B6.setText(f);pa5.setText(ETYPE);fp3.setText(f);
         card.removeAll();
          if(a==null)
       {
           JOptionPane.showMessageDialog(null, "Please Select A Car From List To Sale");
       }
        card.repaint();
        card.revalidate();
        card.add(BillSys);
        card.repaint();
        card.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ct1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ct1MouseClicked
        DefaultTableModel df = (DefaultTableModel) ct1.getModel();
        int selectedIndex = ct1.getSelectedRow();
        c1.setText(df.getValueAt(selectedIndex, 0).toString());
        c2.setText(df.getValueAt(selectedIndex, 1).toString());
        c3.setText(df.getValueAt(selectedIndex, 2).toString());
        c4.setText(df.getValueAt(selectedIndex, 3).toString());
        c5.setText(df.getValueAt(selectedIndex, 4).toString());
        c6.setText(df.getValueAt(selectedIndex, 5).toString());
        c8.setText(df.getValueAt(selectedIndex, 6).toString());
        c7.setText(df.getValueAt(selectedIndex, 7).toString());

    }//GEN-LAST:event_ct1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       /* DefaultTableModel df = (DefaultTableModel) ct1.getModel();
        int selectedIndex = ct1.getSelectedRow();
        try {
            int ENO = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());

            String a = c1.getText();
            String b = c2.getText();
            String c = c3.getText();
            String d = c4.getText();
            
            String STS = c5..getText();
            String e = c6.getText();
            String ETYPE;
            String f = c7.getText();
            ETYPE = c8.getSelectedItem().toString();
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Ranvijay", "maindata", "1234");
            String sql = "UPDATE CARDETAILS SET CNAME=?,CCLR=?,CMOD=?,CSTS=?,CMIL=?,CETYPE=?,CPRICE=? WHERE ENO=? ";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, b);
                pst.setString(2, c);
                pst.setString(3, d);
                pst.setString(4, STS);
                pst.setString(5, e);
                pst.setString(6, ETYPE);
                pst.setString(7, f);
                pst.setString(8, a);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Submitted Succesfully");
                Show_Car();
                pst.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e1) {
            e1.printStackTrace();
        }*/

    }//GEN-LAST:event_jButton2ActionPerformed

    private void B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B4ActionPerformed

    private void B6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B6ActionPerformed

    private void B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B5ActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B2ActionPerformed

    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B3ActionPerformed

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B1ActionPerformed

    private void sh5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sh5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sh5ActionPerformed

    private void sh4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sh4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sh4ActionPerformed

    private void sa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sa3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sa3ActionPerformed

    private void sa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sa5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sa5ActionPerformed

    private void sa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sa2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sa2ActionPerformed

    private void sa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sa1ActionPerformed

    private void pa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pa5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pa5ActionPerformed

    private void pa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pa2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pa2ActionPerformed

    private void pa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pa1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*.images", "jpg", "png");
        chooser.addChoosableFileFilter(fnef);
        int ans = chooser.showSaveDialog(null);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File selectedPhoto = chooser.getSelectedFile();
            String path = selectedPhoto.getAbsolutePath();
            //ims.setIcon(resizeImageI(path, null));
            //this.photopath=path;
        } else {
            System.out.println("Photo Not Selected ....");
        }
    }//GEN-LAST:event_jLabel37MouseClicked

    private void T1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T1MouseClicked
        DefaultTableModel df = (DefaultTableModel) T1.getModel();
        int selectedIndex = T1.getSelectedRow();
        eid.setText(df.getValueAt(selectedIndex, 0).toString());
        ename.setText(df.getValueAt(selectedIndex, 1).toString());
        String gen = df.getValueAt(selectedIndex, 2).toString();
        switch (gen) {
            case "Male":
                esex.setSelectedIndex(0);
                break;
            case "Female":
                esex.setSelectedIndex(1);
                break;
        }

        epo.setText(df.getValueAt(selectedIndex, 3).toString());
        eadr.setText(df.getValueAt(selectedIndex, 4).toString());
        String sts = df.getValueAt(selectedIndex, 5).toString();
        switch (sts) {
            case "Aadhaar":
                eidtype.setSelectedIndex(0);
                break;
            case "PAN":
                eidtype.setSelectedIndex(1);
                break;
            case "Voter_Id":
                eidtype.setSelectedIndex(2);
                break;
            case "Driving Licence":
                eidtype.setSelectedIndex(3);
                break;
        }
        eidno.setText(df.getValueAt(selectedIndex, 6).toString());
        esal.setText(df.getValueAt(selectedIndex, 7).toString());
        euid.setText(df.getValueAt(selectedIndex, 0).toString());


    }//GEN-LAST:event_T1MouseClicked

    private void AdminTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminTableMouseClicked
        DefaultTableModel df = (DefaultTableModel) AdminTable.getModel();
        int selectedIndex = AdminTable.getSelectedRow();
        e1.setText(df.getValueAt(selectedIndex, 0).toString());
        e2.setText(df.getValueAt(selectedIndex, 1).toString());
        e3.setText(df.getValueAt(selectedIndex, 2).toString());
        String gen = df.getValueAt(selectedIndex, 3).toString();
        switch (gen) {
            case "Male":
                e4.setSelectedIndex(0);
                break;
            case "Female":
                e4.setSelectedIndex(1);
                break;
        }
        e6.setText(df.getValueAt(selectedIndex, 4).toString());
        String sts = df.getValueAt(selectedIndex, 4).toString();
        switch (sts) {
            case "Aadhaar":
                e7.setSelectedIndex(0);
                break;
            case "PAN":
                e7.setSelectedIndex(1);
                break;
            case "Voter_Id":
                e7.setSelectedIndex(2);
                break;
            case "Driving Licence":
                e7.setSelectedIndex(3);
                break;
        }
        e8.setText(df.getValueAt(selectedIndex, 6).toString());
        e9.setText(df.getValueAt(selectedIndex, 7).toString());
        ee1.setText(df.getValueAt(selectedIndex, 0).toString());

    }//GEN-LAST:event_AdminTableMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String j = ee1.getText();
        String k = ee2.getText();
        String l = ee3.getText();
        String m = ee4.getText();
        String b = e2.getText();
        String c = e3.getText();
        String sex;
        sex = e4.getSelectedItem().toString();
        String d = e6.getText();
        String IDT;
        IDT = e7.getSelectedItem().toString();
        String e = e8.getText();
        String f = e9.getText();
        //String j=ims2.getText();
        // byte[] EIMG;
        // EIMG=image.replace("\\","\\\\");

         String currentDir=System.getProperty("user.dir");
        try
   {  
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            String sql = "INSERT INTO MAINDATA.ADMLOG(AID,APS,AAPIN,ASRC,ANAME,APHN,ASEX,AADR,AIDPT,AIDNO,ASAL) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, j);
            pst.setString(2, k);
            pst.setString(3, l);
            pst.setString(4, m);
            pst.setString(5, b);
            pst.setString(6, c);
            pst.setString(7, sex);
            pst.setString(8, d);
            pst.setString(9, IDT);
            pst.setString(10, e);
            pst.setString(11, f);
            //InputStream is=new FileInputStream(new File(photopath));
            // pst.setString(9, j);
            //pst.setBinaryStream(9,(InputStream)fin,(int)imgfile.length());
            pst.executeUpdate();
            Show_ActAdminTable();
            pst.close();
            JOptionPane.showMessageDialog(null, "Submitted Succesfully");
        } catch (SQLTransactionRollbackException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void ee1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ee1KeyReleased
        String a = ee1.getText();
        ee2.setText(a);
        ee3.setText(a);
        ee4.setText(a);
    }//GEN-LAST:event_ee1KeyReleased

    private void e4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e4ActionPerformed

    private void jLabel65MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel65MouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*.images", "jpg", "png");
        chooser.addChoosableFileFilter(fnef);
        int ans = chooser.showSaveDialog(null);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File selectedPhoto = chooser.getSelectedFile();
            String path = selectedPhoto.getAbsolutePath();
            //ims.setIcon(resizeImageI(path, null));
            //this.photopath=path;
        } else {
            System.out.println("Photo Not Selected ....");
        }
    }//GEN-LAST:event_jLabel65MouseClicked

    private void edel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edel1ActionPerformed
        DefaultTableModel df = (DefaultTableModel) AdminTable.getModel();
        int selectedIndex = AdminTable.getSelectedRow();
         String currentDir=System.getProperty("user.dir");
        try {
            int SSID = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To DELETE the Selected Record", "warning", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION)

            { 
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
                String sql = ("DELETE FROM MAINDATA.ADMDETAILS WHERE AEID=? ");
                PreparedStatement pst = con.prepareStatement(sql);

                pst.setInt(1, SSID);

                pst.executeUpdate();
                Show_Admin();
                pst.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException | NumberFormatException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_edel1ActionPerformed

    private void eupdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eupdate1ActionPerformed
        DefaultTableModel df = (DefaultTableModel) AdminTable.getModel();
        int selectedIndex = AdminTable.getSelectedRow();
         String currentDir=System.getProperty("user.dir");
        try {
            int AEID = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            String a = e1.getText();
            String b = e2.getText();
            String c = e3.getText();
            String d;
            d = e4.getSelectedItem().toString();
            String e = e6.getText();
            String f;
            f = e7.getSelectedItem().toString();
            String g = e8.getText();
            String h = e9.getText();
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            String sql = "UPDATE MAINDATA.ADMDETAILS SET ANAME=?,APHN=?,ESEX=?,EARD=?,AIDPT=?,AIDNO=?,ASAL=? WHERE AEID=?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, b);
                pst.setString(2, c);
                pst.setString(3, d);
                pst.setString(4, e);
                pst.setString(5, f);
                pst.setString(6, g);
                pst.setString(7, h);
                pst.setString(8, a);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Submitted Succesfully");
                Show_Admin();
                pst.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException | NumberFormatException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_eupdate1ActionPerformed

    private void einsert1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_einsert1ActionPerformed
        String a = e1.getText();
        String b = e2.getText();
        String sex;
        sex = e4.getSelectedItem().toString();
        String c = e3.getText();
        String d = e6.getText();
        String IDT;
        IDT = e7.getSelectedItem().toString();
        String e = e8.getText();
        String i = e9.getText();
        //String j=ims2.getText();
        // byte[] EIMG;
        // EIMG=image.replace("\\","\\\\");
String currentDir=System.getProperty("user.dir");
        try
   {  
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            String sql = "INSERT INTO MAINDATA.ADMDETAILS(AEID,ANAME,APHN,ESEX,EARD,AIDPT,AIDNO,ASAL) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, a);
            pst.setString(2, b);
            pst.setString(3, c);
            pst.setString(4, sex);
            pst.setString(5, d);
            pst.setString(6, IDT);
            pst.setString(7, e);
            pst.setString(8, i);
            //InputStream is=new FileInputStream(new File(photopath));
            // pst.setString(9, j);
            //pst.setBinaryStream(9,(InputStream)fin,(int)imgfile.length());
            pst.executeUpdate();
            Show_Admin();
            pst.close();
            JOptionPane.showMessageDialog(null, "Submitted Succesfully");
        } catch (SQLTransactionRollbackException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*String a= eid2.getText();
        String b= ename1.getText();
        String sex;
        sex=esex1.getSelectedItem().toString();
        String c= epo1.getText();
        String d=eadr1.getText();
        String IDT;
        IDT= eidtype1.getSelectedItem().toString();
        String e=eidno1.getText();
        String i= esal1.getText();
        InputStream j=new FileInputStram(new File (Photopath));
        /*String a= eid2.getText();
        String b= ename1.getText();
        String sex;
        sex=esex1.getSelectedItem().toString();
        String c= epo1.getText();
        String d=eadr1.getText();
        String IDT;
        IDT= eidtype1.getSelectedItem().toString();
        String e=eidno1.getText();
        String i= esal1.getText();
        InputStream j=new FileInputStram(new File (Photopath));
        Blob j= ims1.getText();*/

    }//GEN-LAST:event_einsert1ActionPerformed

    private void e1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e1KeyReleased
        String a = e1.getText();
        ee1.setText(a);
        ee2.setText(a);
        ee3.setText(a);
        ee4.setText(a);
    }//GEN-LAST:event_e1KeyReleased

    private void e1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e1ActionPerformed

    private void e9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e9ActionPerformed

    private void esearch3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_esearch3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_esearch3MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel df = (DefaultTableModel) T1.getModel();
        int selectedIndex = T1.getSelectedRow();
        String currentDir=System.getProperty("user.dir");
        try {
            int SSID = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To DELETE the Selected Record", "warning", JOptionPane.YES_NO_CANCEL_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION)

            {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
                String sql = ("DELETE FROM MAINDATA.EMPLOG WHERE EID=? ");
                PreparedStatement pst = con.prepareStatement(sql);

                pst.setInt(1, SSID);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Submitted Succesfully");
                Show_SAdmin();
                pst.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void per1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_per1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_per1ActionPerformed

    private void per2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_per2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_per2ActionPerformed

    private void a2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a2ActionPerformed

    private void a3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a3ActionPerformed

    private void a1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a1ActionPerformed

    private void a6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a6ActionPerformed

    private void a7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a7ActionPerformed

    private void a5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a5ActionPerformed

    private void per4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_per4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_per4ActionPerformed

    private void per3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_per3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_per3ActionPerformed

    private void jButton19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseEntered
        jButton19.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_jButton19MouseEntered

    private void jButton19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseExited
        jButton19.setBackground(new Color(0, 0, 255));
    }//GEN-LAST:event_jButton19MouseExited

    private void jLabel90MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel90MouseClicked
        SCard.removeAll();
        SCard.repaint();
        SCard.revalidate();
        SCard.add(ChangePassWord);
        SCard.repaint();
        SCard.revalidate();

    }//GEN-LAST:event_jLabel90MouseClicked

    private void jLabel90MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel90MouseEntered
        jLabel90.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel90MouseEntered

    private void jLabel90MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel90MouseExited
        jLabel90.setBackground(new Color(0, 0, 255));
    }//GEN-LAST:event_jLabel90MouseExited

    private void jLabel91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseClicked
        SCard.removeAll();
        SCard.repaint();
        SCard.revalidate();
        SCard.add(pinchange);
        SCard.repaint();
        SCard.revalidate();
    }//GEN-LAST:event_jLabel91MouseClicked

    private void jLabel91MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseEntered
        jLabel91.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_jLabel91MouseEntered

    private void jLabel91MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseExited
        jLabel91.setBackground(new Color(0, 0, 255));
    }//GEN-LAST:event_jLabel91MouseExited

    private void jLabel93MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel93MouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        Image getAbsolutePath = null;
        ImageIcon icon = new ImageIcon(filename);
        Image img = icon.getImage().getScaledInstance(ims2.getWidth(), ims2.getHeight(), Image.SCALE_SMOOTH);
        ims2.setIcon(icon);

        /*JFileChooser chooser=new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fnef=new FileNameExtensionFilter("*.images", "jpg","png");
        chooser.addChoosableFileFilter(fnef);
        int ans=chooser.showSaveDialog(null);
        if (ans==JFileChooser.APPROVE_OPTION) {
            File selectedPhoto=chooser.getSelectedFile();
            String path=selectedPhoto.getAbsolutePath();
            ims2.setIcon(resizeImageEmp(path, null));
            this.photopath=path;
        }
       // EIMG=bos.toByteArray();
        else{
            System.out.println("Photo Not Selected ....");
        }*/
    }//GEN-LAST:event_jLabel93MouseClicked

    private void fp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fp3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fp3ActionPerformed

    private void fp6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fp6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fp6ActionPerformed

    private void fp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fp5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fp5ActionPerformed

    private void fp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fp2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fp2ActionPerformed

    private void fp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fp4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fp4ActionPerformed

    private void fp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fp1ActionPerformed

    private void nbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nbActionPerformed

    private void naActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_naActionPerformed

    private void fp9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fp9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fp9ActionPerformed

    private void fp11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fp11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fp11ActionPerformed

    private void fp8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fp8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fp8ActionPerformed

    private void fp7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fp7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fp7ActionPerformed

    private void fp15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fp15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fp15ActionPerformed

    private void fp13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fp13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fp13ActionPerformed

    private void fp12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fp12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fp12ActionPerformed

    private void fp14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fp14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fp14ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        printRecord(j26);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jTextField42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField42ActionPerformed

    private void jTextField43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField43ActionPerformed

    private void jTextField44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField44ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField44ActionPerformed

    private void jTextField45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField45ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField45ActionPerformed

    private void jTextField46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField46ActionPerformed

    private void jTextField47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField47ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField47ActionPerformed

    private void jTextField48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField48ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField48ActionPerformed

    private void jLabel93MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel93MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel93MouseEntered

    private void l9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l9MouseClicked
        card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(ProfilePan);
        card.repaint();
        card.revalidate();
        l9.setBackground(new Color(255, 255, 255));
        l9.setForeground(new Color(0, 0, 0));
        l2.setBackground(new Color(0,0,0));
        l2.setForeground(new Color(255,255,255));
        l4.setBackground(new Color(0,0,0));
        l4.setForeground(new Color(255,255,255));
        l5.setBackground(new Color(0,0,0));
        l5.setForeground(new Color(255,255,255));
        l1.setBackground(new Color(0,0,0));
        l1.setForeground(new Color(255,255,255));
        l7.setBackground(new Color(0,0,0));
        l7.setForeground(new Color(255,255,255));

        s6.setBackground(new Color(255, 0, 0));
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s2.setVisible(false);
        s4.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(true);
        s7.setVisible(false);
    }//GEN-LAST:event_l9MouseClicked

    private void l9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l9MouseEntered
          l9.setBorder(new LineBorder(new Color(0,0,0),2));
    }//GEN-LAST:event_l9MouseEntered

    private void l9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l9MouseExited
           l9.setBorder(new LineBorder(new Color(0,0,0),0));
    }//GEN-LAST:event_l9MouseExited

    private void eidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_eidFocusGained
        String a = eid.getText();
        euid.setText(a);
        eps.setText(a);
        epn.setText(a);
    }//GEN-LAST:event_eidFocusGained

    private void e1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e1FocusGained
        String a = e1.getText();
        ee1.setText(a);
        ee2.setText(a);
        ee3.setText(a);
        ee4.setText(a);
    }//GEN-LAST:event_e1FocusGained

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        DefaultTableModel df = (DefaultTableModel) ActAdminTable.getModel();
        int selectedIndex = ActAdminTable.getSelectedRow();
        String currentDir=System.getProperty("user.dir");
        try {
            int AEID = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To DELETE the Selected Record", "warning", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION)
                
            {
               Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
                String sql = ("DELETE FROM MAINDATA.ADMLOG WHERE AID=? ");
                PreparedStatement pst = con.prepareStatement(sql);

                pst.setInt(1, AEID);

                pst.executeUpdate();
                Show_ActAdminTable();
                pst.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException | NumberFormatException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void ee1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ee1FocusGained
        String a = ee1.getText();
        ee2.setText(a);
        ee3.setText(a);
        ee4.setText(a);
    }//GEN-LAST:event_ee1FocusGained

    private void DaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DaActionPerformed

    private void esearch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_esearch2KeyReleased
      //String query=esearch2.getText().toString();
      //FilterCar(query);
      
      /* ArrayList<CARbin> al=null;
                al=new ArrayList<CARbin>();
       String val=esearch2.getText().toString();
        try {
           Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Ranvijay", "maindata", "1234");
            //String qry="select * from student where (name like '%"+val+"%' or id like %"+Integer.parseInt(val)+"%)";
            String qry="select * from CARDETAILS where CNAME like '%"+val+"%'";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(qry);
            CARbin CARDETAILS;
            while (rs.next()) {
                //CARDETAILS =new CARbin(rs.getInt(1),rs.getString("CNAME"),rs.getString(3"CCLR"),rs.getString(4));                
                //al.add(CARDETAILS);
              }
        DefaultTableModel model=(DefaultTableModel)ct1.getModel();
        model.setRowCount(0); // Empty/clear the table
        Object[] row=new Object[4];
        for (int i = 0; i < al.size(); i++) {
            row[0]=al.get(i).getENO();
            row[1]=al.get(i).getCNAME();
            row[2]=al.get(i).getCCLR();
            row[3]=al.get(i).getCMOD();
            row[4]=al.get(i).getCSTS();
            row[5]=al.get(i).getCMIL(); 
            row[6]=al.get(i).getCETYPE();
            row[7]=al.get(i).getCPRICE();
              
             
            model.addRow(row);
        }
           
        } catch (Exception e) {
            System.out.println(e);
        }*/
       
    }//GEN-LAST:event_esearch2KeyReleased

    private void l6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l6MouseClicked
       Show_Car();
         card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(addcar);
        card.repaint();
        card.revalidate();
        l2.setBackground(new Color(255, 255, 255));
        l2.setForeground(new Color(0, 0, 0));
        l1.setBackground(new Color(0,0,0));
        l1.setForeground(new Color(255,255,255));
        l4.setBackground(new Color(0,0,0));
        l4.setForeground(new Color(255,255,255));
        l5.setBackground(new Color(0,0,0));
        l5.setForeground(new Color(255,255,255));
        l9.setBackground(new Color(0,0,0));
        l9.setForeground(new Color(255,255,255));
        l7.setBackground(new Color(0,0,0));
        l7.setForeground(new Color(255,255,255));

        s2.setBackground(new Color(255, 0, 0));
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s2.setVisible(true);
        s4.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(false);
        s7.setVisible(false);
    }//GEN-LAST:event_l6MouseClicked

    private void l6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l6MouseEntered
       l6.setBackground(new Color(255,255,255));l6.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_l6MouseEntered

    private void l6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l6MouseExited
        l6.setBackground(new Color(0,0,0));l6.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_l6MouseExited

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       String a = B1.getText();
        String b = B2.getText();
        String c = B3.getText();
        String d = B6.getText();
       String e;
        e= B5.getText();
        String f = B4.getText();
        String g=sh4.getText();
        String h=sh5.getText();
        String i=sa1.getText();
        String j=sa2.getText();
        String k=sa3.getText();
        String l=sa4.getText();
        String m=sa5.getText();
        String n=pa1.getText();
        String o;
        o=pa4.getSelectedItem().toString();
        String p=pa5.getText();
        String currentDir=System.getProperty("user.dir");
        try
   {  
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            String sql = "INSERT INTO MAINDATA.BILLSYS(CID,CCMP,CMO,CENT,CCLR,CPR,SID,SNAME,CUID,CUNAME,CUPH,CUADR,CUIDPN,PID,PPM,PTP) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, a);
            pst.setString(2, b);
            pst.setString(3, c);
            pst.setString(4, d);
            pst.setString(5, e);
            pst.setString(6, f);
            pst.setString(7, g);
            pst.setString(8, h);
            pst.setString(9, i);st3.setText(i);
            pst.setString(10, j);
            pst.setString(11, k);
            pst.setString(12, l);
            pst.setString(13, m);
            pst.setString(14, n);st4.setText(n);
            pst.setString(15, o);
            pst.setString(16, p);
            Show_PrgDel();
            pst.executeUpdate();
            pst.close();
            card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(GBill);
        card.repaint();
        card.revalidate();
        ShowDateTime();
            JOptionPane.showMessageDialog(null, "Bill IS Generated Succesfully.. \n Click Ok To View");
        } catch (SQLTransactionRollbackException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void esearch2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_esearch2KeyPressed
                                       
     DefaultTableModel model = (DefaultTableModel)ct1.getModel();
     TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
     ct1.setRowSorter(tr);
      tr.setRowFilter(RowFilter.regexFilter(esearch2.getText().trim()));// TODO add your handling code here:
    
    }//GEN-LAST:event_esearch2KeyPressed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(addcar);
        card.repaint();
        card.revalidate();

        s2.setBackground(new Color(255, 0, 0));
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s2.setVisible(true);
        s4.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(false);
        s7.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       sa1.setText("");
       sa2.setText("");
       sa3.setText("");
       sa4.setText("");
       sa5.setText("");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
       pa1.setText("");
       pa2.setText("");
        pa5.setText("");
      
    }//GEN-LAST:event_jButton14ActionPerformed

    private void sa1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sa1KeyPressed
       String a = sa1.getText();
        pa2.setText(a);
        ee2.setText(a);
        ee3.setText(a);
        ee4.setText(a);
    }//GEN-LAST:event_sa1KeyPressed

    private void st4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_st4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_st4ActionPerformed

    private void st1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_st1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_st1ActionPerformed

    private void st2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_st2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_st2ActionPerformed

    private void st3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_st3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_st3ActionPerformed

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
       jButton10.setBackground(new Color (255,255,255)); jButton10.setForeground(new Color (0,0,0));
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
      jButton10.setForeground(new Color (255,255,255)); jButton10.setBackground(new Color (0,0,0));
    }//GEN-LAST:event_jButton10MouseExited

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
      jButton12.setBackground(new Color(0,0,0));
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
      jButton12.setBackground(new Color (102,102,102));
    }//GEN-LAST:event_jButton12MouseExited

    private void jButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseEntered
       jButton11.setBackground(new Color(0,0,0));
    }//GEN-LAST:event_jButton11MouseEntered

    private void jButton11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseExited
        jButton11.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_jButton11MouseExited

    private void jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseEntered
       jButton12.setBackground(new Color (0,0,0));
    }//GEN-LAST:event_jButton14MouseEntered

    private void jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseExited
       jButton10.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jButton14MouseExited

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       String a = sa1.getText();fp7.setText(a);
        String b = sa2.getText();fp8.setText(b);
     String c = sa3.getText();fp9.setText(c);
        String d = sa4.getText();fp10.setText(d);
        String e = sa5.getText();fp11.setText(e);
        String f = B1.getText();
        String g = B2.getText();
        String h = B4.getText();
        String currentDir=System.getProperty("user.dir");
        try
   {  
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            String sql = "INSERT INTO MAINDATA.CSTDTL(CUID,CUNAME,CUPH,CUADR,CUIDPN,CRID,CRNAME,CRAMT) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, a);
            pst.setString(2, b);
            pst.setString(3, c);
            pst.setString(4, d);
            pst.setString(5, e);
            pst.setString(6, f);
            pst.setString(7, g);
            pst.setString(8, h);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "New CusTomer Details Saved Succesfully");
             pst.close();
        } catch (SQLTransactionRollbackException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        String a = pa1.getText();fp11.setText(a);
        String b = pa2.getText();fp12.setText(b);
        String c;
        c = pa4.getSelectedItem().toString();fp13.setText(c);
        String d = pa5.getText();fp14.setText(d);
          String currentDir=System.getProperty("user.dir");
        try
   {  
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            String sql = "INSERT INTO MAINDATA.PAYMENT(PID,CUID,PPM,PTP) VALUES(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, a);
            pst.setString(2, b);
            pst.setString(3, c);
            pst.setString(4, d);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Payment Details Stored Succesfully");
            pst.close();
        } catch (SQLTransactionRollbackException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void a2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseClicked
       a2.setText("");
    }//GEN-LAST:event_a2MouseClicked

    private void a3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a3MouseClicked
       a3.setText("");
    }//GEN-LAST:event_a3MouseClicked

    private void a4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseClicked
       a4.setText("");
    }//GEN-LAST:event_a4MouseClicked

    private void a6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a6MouseClicked
         a6.setText("");
    }//GEN-LAST:event_a6MouseClicked

    private void a7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a7MouseClicked
        a7.setText("");
    }//GEN-LAST:event_a7MouseClicked

    private void a8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a8MouseClicked
       a8.setText("");
    }//GEN-LAST:event_a8MouseClicked

    private void jLabel164MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel164MouseClicked
         A_Login_Page ap = new A_Login_Page();
        ap.setVisible(true);
        ap.pack();
        ap.setLocationRelativeTo(null);
        ap.setDefaultCloseOperation(A_Login_Page.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel164MouseClicked

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // DefaultTableModel df = (DefaultTableModel) AdminTable.getModel();
        //int selectedIndex = AdminTable.getSelectedRow();
       String currentDir=System.getProperty("user.dir");
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //int AEID = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            String a = per1.getText();
            String b = per4.getText();
            String c = per5.getText();
           
            Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            String sql = "UPDATE MAINDATA.EMPLOG SET EPHN=?,EADR=?, WHERE EID=?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, b);
                pst.setString(2, c);
               pst.setString(3, a);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Submitted Succesfully\n PLEASE Login Again TO See the Channges");
               // Show_Admin();
                pst.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeadlessException | NumberFormatException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void esearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esearch1ActionPerformed

    private void esearch1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_esearch1KeyPressed
       DefaultTableModel model = (DefaultTableModel)PrgT.getModel();
     TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
     PrgT.setRowSorter(tr);
      tr.setRowFilter(RowFilter.regexFilter(esearch1.getText().trim()));
      
      
    }//GEN-LAST:event_esearch1KeyPressed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String id=a1.getText();
        String pin=a2.getText(); 
        String nps=a3.getText(); 
        String cps=a4.getText(); 
        if(!nps.equals(cps))
        {
          JOptionPane.showMessageDialog(null, "PassWord Dosn'T Match\n Please Try Again");  
        }
        else if (id==null)
        {
          JOptionPane.showMessageDialog(null, "Please Enter Your Valid Employee ID Number"); 
        }
        else if (pin==null)
        {
            JOptionPane.showMessageDialog(null, "Please Enter Your Valid PIN"); 
        }
        else if(nps==null&&cps==null)
        {
            JOptionPane.showMessageDialog(null, "Please Enter A Valid New PassWord AND New PassWord ");  
        }
        else if(nps == null ? cps == null : nps.equals(cps)){
             String currentDir=System.getProperty("user.dir");
        try
   {  
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            String sql = "UPDATE MAINDATA.EMPLOG SET EPS=? WHERE EID=? ";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, nps);
                pst.setString(2, id);
                pst.executeUpdate();
                pst.close();
                JOptionPane.showMessageDialog(null, "Your PASSWORD Changed Succesfully.");
               JOptionPane.showMessageDialog(null, "You Should Login Again To Update The Changes .\n\n PRESS Ok To Login To System.");
                A_Login_Page ap = new A_Login_Page();
            ap.setVisible(true);
            ap.pack();
            ap.setLocationRelativeTo(null);
            ap.setDefaultCloseOperation(A_Login_Page.EXIT_ON_CLOSE);
            this.dispose();
            
            }
         }    catch (SQLException ex) {
             Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
         }   catch (Exception e1) {
             e1.printStackTrace();
         }
         }
    else {
                JOptionPane.showMessageDialog(null, "Employee ID Dosn't Exist\n PLEASE Try Again");
                }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
       String id=a5.getText();
        String pin=a6.getText(); 
        String nps=a7.getText(); 
        String cps=a8.getText(); 
        if(!nps.equals(cps))
        {
          JOptionPane.showMessageDialog(null, "PassWord Dosn'T Match\n Please Try Again");  
        }
               else if (pin==null)
        {
            JOptionPane.showMessageDialog(null, "Please Enter Your Valid PIN"); 
        }
        else if(nps==null&&cps==null)
        {
            JOptionPane.showMessageDialog(null, "Please Enter A Valid New PassWord AND New PassWord ");  
        }
        else if(nps == null ? cps == null : nps.equals(cps)){
             String currentDir=System.getProperty("user.dir");
        try
   {  
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      Connection con= DriverManager.getConnection("jdbc:derby:"+currentDir+"\\Ranvijay", "maindata","1234");
            String sql = "UPDATE MAINDATA.EMPLOG SET EPIN=? WHERE EID=? ";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, nps);
                pst.setString(2, id);
                pst.executeUpdate();
                 pst.close();
                JOptionPane.showMessageDialog(null, "Your PIN Changed Succesfully.");
                JOptionPane.showMessageDialog(null, "You Should Login Again To Update The Changes .\n\n PRESS Ok To Login To System.");
                A_Login_Page ap = new A_Login_Page();
            ap.setVisible(true);
            ap.pack();
            ap.setLocationRelativeTo(null);
            ap.setDefaultCloseOperation(A_Login_Page.EXIT_ON_CLOSE);
            this.dispose();
           
            }
         }    catch (SQLException ex) {
             Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
         }   catch (HeadlessException e1) {
             e1.printStackTrace();
         } catch (ClassNotFoundException ex) {
               Logger.getLogger(SP.class.getName()).log(Level.SEVERE, null, ex);
           }
         }
    else {
                JOptionPane.showMessageDialog(null, "Employee ID Dosn't Exist\n PLEASE Try Again");
                }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void a5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_a5FocusGained
        a5.setText("");
    }//GEN-LAST:event_a5FocusGained

    private void a6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_a6FocusGained
      a6.setText("");
    }//GEN-LAST:event_a6FocusGained

    private void a7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_a7FocusGained
        a7.setText("");
    }//GEN-LAST:event_a7FocusGained

    private void a8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_a8FocusGained
      a8.setText("");
    }//GEN-LAST:event_a8FocusGained

    private void a1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_a1FocusGained
       a1.setText("");
    }//GEN-LAST:event_a1FocusGained

    private void a2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_a2FocusGained
       a2.setText("");
    }//GEN-LAST:event_a2FocusGained

    private void a3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_a3FocusGained
        a3.setText("");
    }//GEN-LAST:event_a3FocusGained

    private void a4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_a4FocusGained
       a4.setText("");
    }//GEN-LAST:event_a4FocusGained

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
       card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(ProfilePan);
        card.repaint();
        card.revalidate();
        l9.setBackground(new Color(255, 255, 255));
        l9.setForeground(new Color(0, 0, 0));
        l2.setBackground(new Color(0,0,0));
        l2.setForeground(new Color(255,255,255));
        l4.setBackground(new Color(0,0,0));
        l4.setForeground(new Color(255,255,255));
        l5.setBackground(new Color(0,0,0));
        l5.setForeground(new Color(255,255,255));
        l1.setBackground(new Color(0,0,0));
        l1.setForeground(new Color(255,255,255));
        l7.setBackground(new Color(0,0,0));
        l7.setForeground(new Color(255,255,255));

        s6.setBackground(new Color(255, 0, 0));
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s2.setVisible(false);
        s4.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(true);
        s7.setVisible(false);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(ProfilePan);
        card.repaint();
        card.revalidate();
        l9.setBackground(new Color(255, 255, 255));
        l9.setForeground(new Color(0, 0, 0));
        l2.setBackground(new Color(0,0,0));
        l2.setForeground(new Color(255,255,255));
        l4.setBackground(new Color(0,0,0));
        l4.setForeground(new Color(255,255,255));
        l5.setBackground(new Color(0,0,0));
        l5.setForeground(new Color(255,255,255));
        l1.setBackground(new Color(0,0,0));
        l1.setForeground(new Color(255,255,255));
        l7.setBackground(new Color(0,0,0));
        l7.setForeground(new Color(255,255,255));

        s6.setBackground(new Color(255, 0, 0));
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s2.setVisible(false);
        s4.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(true);
        s7.setVisible(false);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
      
       card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(BillSys);
        card.repaint();
        card.revalidate();
        
        l5.setBackground(new Color(255, 255, 255));
        l5.setForeground(new Color(0, 0, 0));
        l2.setBackground(new Color(0,0,0));
        l2.setForeground(new Color(255,255,255));
        l4.setBackground(new Color(0,0,0));
        l4.setForeground(new Color(255,255,255));
        l1.setBackground(new Color(0,0,0));
        l1.setForeground(new Color(255,255,255));
        l9.setBackground(new Color(0,0,0));
        l9.setForeground(new Color(255,255,255));
        l7.setBackground(new Color(0,0,0));
        l7.setForeground(new Color(255,255,255));

        s5.setBackground(new Color(255, 0, 0));
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s2.setVisible(false);
        s4.setVisible(false);
        s5.setVisible(true);
        s6.setVisible(false);
        s7.setVisible(false);
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void uppMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uppMouseClicked
         x=evt.getX();
y=evt.getY();
    }//GEN-LAST:event_uppMouseClicked

    private void uppMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uppMouseDragged
       this.setLocation(this.getLocation().x+evt.getX()-x,this.getLocation().y+evt.getY()-y);
    }//GEN-LAST:event_uppMouseDragged

    private void uppMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uppMouseEntered
        x=evt.getX();
y=evt.getY();
    }//GEN-LAST:event_uppMouseEntered

    private void uppMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uppMousePressed
        x=evt.getX();
y=evt.getY();
    }//GEN-LAST:event_uppMousePressed

    private void sh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sh1MouseClicked
        card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(ProfilePan);
        card.repaint();
        card.revalidate();
        l9.setBackground(new Color(255, 255, 255));
        l9.setForeground(new Color(0, 0, 0));
        l2.setBackground(new Color(0,0,0));
        l2.setForeground(new Color(255,255,255));
        l4.setBackground(new Color(0,0,0));
        l4.setForeground(new Color(255,255,255));
        l5.setBackground(new Color(0,0,0));
        l5.setForeground(new Color(255,255,255));
        l1.setBackground(new Color(0,0,0));
        l1.setForeground(new Color(255,255,255));
        l7.setBackground(new Color(0,0,0));
        l7.setForeground(new Color(255,255,255));

        s6.setBackground(new Color(255, 0, 0));
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s2.setVisible(false);
        s4.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(true);
        s7.setVisible(false);
    }//GEN-LAST:event_sh1MouseClicked

    private void sh2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sh2MouseClicked
        card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(ProfilePan);
        card.repaint();
        card.revalidate();
        l9.setBackground(new Color(255, 255, 255));
        l9.setForeground(new Color(0, 0, 0));
        l2.setBackground(new Color(0,0,0));
        l2.setForeground(new Color(255,255,255));
        l4.setBackground(new Color(0,0,0));
        l4.setForeground(new Color(255,255,255));
        l5.setBackground(new Color(0,0,0));
        l5.setForeground(new Color(255,255,255));
        l1.setBackground(new Color(0,0,0));
        l1.setForeground(new Color(255,255,255));
        l7.setBackground(new Color(0,0,0));
        l7.setForeground(new Color(255,255,255));

        s6.setBackground(new Color(255, 0, 0));
        s1.setBackground(new Color(0, 0, 0));
        s1.setVisible(false);
        s2.setVisible(false);
        s4.setVisible(false);
        s5.setVisible(false);
        s6.setVisible(true);
        s7.setVisible(false);
    }//GEN-LAST:event_sh2MouseClicked

    private void sh1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sh1MouseEntered
       sh1.setForeground(new Color(255,51,51));
    }//GEN-LAST:event_sh1MouseEntered

    private void sh1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sh1MouseExited
          sh1.setForeground(new Color(255,255,53));
    }//GEN-LAST:event_sh1MouseExited

    private void sh2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sh2MouseEntered
        sh2.setForeground(new Color(255,255,0));
    }//GEN-LAST:event_sh2MouseEntered

    private void sh2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sh2MouseExited
       sh2.setForeground(new Color(255,51,51));
    }//GEN-LAST:event_sh2MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        userid = args[0];
        //userps = args[1];
        java.awt.EventQueue.invokeLater(() -> {
            new SP().setVisible(true);
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel About;
    private javax.swing.JTable ActAdminTable;
    private javax.swing.JPanel AdminPa;
    private javax.swing.JTable AdminTable;
    private javax.swing.JTextField B1;
    private javax.swing.JTextField B2;
    private javax.swing.JTextField B3;
    private javax.swing.JTextField B4;
    private javax.swing.JTextField B5;
    private javax.swing.JTextField B6;
    private javax.swing.JPanel BillSys;
    private javax.swing.JPanel ChangePassWord;
    private javax.swing.JTextField Da;
    private javax.swing.JPanel G1;
    private javax.swing.JPanel GBill;
    private javax.swing.JTable PrgT;
    private javax.swing.JPanel ProfilePan;
    private javax.swing.JPanel SCard;
    private javax.swing.JPanel SalesPpan;
    private javax.swing.JTable T1;
    private javax.swing.JTable T3;
    private javax.swing.JTextField Time;
    private javax.swing.JTextField a1;
    private javax.swing.JTextField a2;
    private javax.swing.JTextField a3;
    private javax.swing.JPasswordField a4;
    private javax.swing.JTextField a5;
    private javax.swing.JTextField a6;
    private javax.swing.JTextField a7;
    private javax.swing.JPasswordField a8;
    private javax.swing.JPanel addcar;
    private javax.swing.JPanel buttenp;
    private javax.swing.JTextField c1;
    private javax.swing.JTextField c2;
    private javax.swing.JTextField c3;
    private javax.swing.JTextField c4;
    private javax.swing.JTextField c5;
    private javax.swing.JTextField c6;
    private javax.swing.JTextField c7;
    private javax.swing.JTextField c8;
    private javax.swing.JPanel card;
    private javax.swing.JPanel chome;
    private javax.swing.JLabel close;
    private javax.swing.JTable ct1;
    private javax.swing.JTextField e1;
    private javax.swing.JTextField e2;
    private javax.swing.JTextField e3;
    private javax.swing.JComboBox<String> e4;
    private javax.swing.JTextArea e6;
    private javax.swing.JComboBox<String> e7;
    private javax.swing.JTextField e8;
    private javax.swing.JTextField e9;
    private javax.swing.JTextArea eadr;
    private javax.swing.JButton edel;
    private javax.swing.JButton edel1;
    private javax.swing.JTextField ee1;
    private javax.swing.JTextField ee2;
    private javax.swing.JTextField ee3;
    private javax.swing.JTextField ee4;
    private javax.swing.JTextField eid;
    private javax.swing.JTextField eidno;
    private javax.swing.JComboBox<String> eidtype;
    private javax.swing.JButton einsert;
    private javax.swing.JButton einsert1;
    private javax.swing.JTextField ename;
    private javax.swing.JTextField epn;
    private javax.swing.JTextField epo;
    private javax.swing.JTextField eps;
    private javax.swing.JTextField esal;
    private javax.swing.JTextField esearch;
    private javax.swing.JTextField esearch1;
    private javax.swing.JTextField esearch2;
    private javax.swing.JTextField esearch3;
    private javax.swing.JComboBox<String> esex;
    private javax.swing.JTextField euid;
    private javax.swing.JButton eupdate;
    private javax.swing.JButton eupdate1;
    private javax.swing.JTextField fp1;
    private javax.swing.JTextArea fp10;
    private javax.swing.JTextField fp11;
    private javax.swing.JTextField fp12;
    private javax.swing.JTextField fp13;
    private javax.swing.JTextField fp14;
    private javax.swing.JTextField fp15;
    private javax.swing.JTextField fp2;
    private javax.swing.JTextField fp3;
    private javax.swing.JTextField fp4;
    private javax.swing.JTextField fp5;
    private javax.swing.JTextField fp6;
    private javax.swing.JTextField fp7;
    private javax.swing.JTextField fp8;
    private javax.swing.JTextField fp9;
    private javax.swing.JLabel homecs;
    private javax.swing.JLabel homeemp;
    private javax.swing.JLabel homeprg;
    private javax.swing.JLabel ims;
    private javax.swing.JLabel ims1;
    private javax.swing.JLabel ims2;
    private javax.swing.JPanel j26;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JLabel l9;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logo1;
    private javax.swing.JLabel logo2;
    private javax.swing.JLabel minimise;
    private javax.swing.JTextField na;
    private javax.swing.JTextField nb;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JTextField pa1;
    private javax.swing.JTextField pa2;
    private javax.swing.JComboBox<String> pa4;
    private javax.swing.JTextField pa5;
    private javax.swing.JTextField per1;
    private javax.swing.JTextField per2;
    private javax.swing.JTextField per3;
    private javax.swing.JTextField per4;
    private javax.swing.JTextArea per5;
    private javax.swing.JPanel pinchange;
    private javax.swing.JPanel progress;
    private javax.swing.JPanel s1;
    private javax.swing.JPanel s2;
    private javax.swing.JPanel s4;
    private javax.swing.JPanel s5;
    private javax.swing.JPanel s6;
    private javax.swing.JPanel s7;
    private javax.swing.JTextField sa1;
    private javax.swing.JTextField sa2;
    private javax.swing.JTextField sa3;
    private javax.swing.JTextArea sa4;
    private javax.swing.JTextField sa5;
    private javax.swing.JLabel sh1;
    private javax.swing.JLabel sh2;
    private javax.swing.JLabel sh3;
    private javax.swing.JTextField sh4;
    private javax.swing.JTextField sh5;
    private javax.swing.JTextField st1;
    private javax.swing.JTextField st2;
    private javax.swing.JTextField st3;
    private javax.swing.JTextField st4;
    private javax.swing.JPanel upp;
    // End of variables declaration//GEN-END:variables

    private static class reg {

        public reg() {
        }
    }

    private void printRecord(JPanel panel) {
        // Create PrinterJob Here
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        // Set Printer Job Name
        printerJob.setJobName("Print Record");
        // Set Printable
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                // Check If No Printable Content
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                // Make 2D Graphics to map content
                Graphics2D graphics2D = (Graphics2D) graphics;
                // Set Graphics Translations
                // A Little Correction here Multiplication was not working so I replaced with addition
                graphics2D.translate(pageFormat.getImageableX() + 15, pageFormat.getImageableY() + 15);
                // This is a page scale. Default should be 0.3 I am using 0.5
                graphics2D.scale(0.5, 0.5);

                // Now paint panel as graphics2D
                panel.paint(graphics2D);

                // return if page exists
                return Printable.PAGE_EXISTS;
            }
        });
        // Store printerDialog as boolean
        boolean returningResult = printerJob.printDialog();
        // check if dilog is showing
        if (returningResult) {
            // Use try catch exeption for failure
            try {
                // Now call print method inside printerJob to print
                printerJob.print();
            } catch (PrinterException printerException) {
                JOptionPane.showMessageDialog(this, "Print Error: " + printerException.getMessage());
            }
        }
    }
}
