
package view;

import database.DatabaseConnectivity;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;


public class Login extends javax.swing.JFrame {
    private Connection conn;
    
    
    public Login() {
        initComponents();
        conn = DatabaseConnectivity.getconnection();
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtuserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("User Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 50, 64, 20);

        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 90, 79, 20);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 150, 72, 20);
        getContentPane().add(txtuserName);
        txtuserName.setBounds(70, 50, 90, 20);
        getContentPane().add(txtPassword);
        txtPassword.setBounds(70, 90, 90, 20);

        jLabel3.setText("Login");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 10, 50, 25);

        jButton2.setText("Cancel");
        getContentPane().add(jButton2);
        jButton2.setBounds(90, 150, 72, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          try {
    Connection conn = DatabaseConnectivity.getconnection();

    // Check if the username and password match the table
    PreparedStatement ps = conn.prepareStatement(
            "SELECT * FROM Login WHERE username = ? AND password = ?");
    ps.setString(1, txtuserName.getText());
    ps.setString(2, txtPassword.getText());

    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        // Valid credentials
        JOptionPane.showMessageDialog(null, "Login successful!");
    } else {
        // Invalid credentials
        JOptionPane.showMessageDialog(null, "Invalid username or password");
    }

    // Close the ResultSet and PreparedStatement
    rs.close();
    ps.close();

} catch (Exception ee) {
    JOptionPane.showMessageDialog(null, ee.toString());
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtuserName;
    // End of variables declaration//GEN-END:variables
}
