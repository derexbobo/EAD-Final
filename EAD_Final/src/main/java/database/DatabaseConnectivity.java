package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnectivity {
    private static Connection conn;

    public static Connection getconnection() {
       if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MelinaDB?useSSL=false", "root", "Thisara18101999*");
                return conn;
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error loading JDBC driver. Check logs for details.");
            } catch (SQLException se) {
                se.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error connecting to the database. Check logs for details.");
            }
        }
        return conn;
    }
}
