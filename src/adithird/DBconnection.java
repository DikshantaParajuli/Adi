
package adithird;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBconnection {
    
 private final String dbURL = "jdbc:mysql://localhost:3306/adi";
    private final String userName = "root";
    private final String password = "";
    public static Connection con = null;

    public DBconnection() {
        if (con == null) {
            getConnection();
        }
    }

    private void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "Please add the driver library!");
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Connected SUCCESSFULLY!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Check your db credentials!");
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
