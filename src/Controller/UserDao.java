

package Controller;

import Modal.UserService;
import adithird.DBconnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao extends DBconnection{
  
    public boolean insertUser(UserService userservice){
        boolean result=false;
        String query="INSERT into user(Username,Password) VALUES (?,?)";
         try {
             PreparedStatement ps;
            ps = con.prepareStatement(query);
            ps.setString(1, userservice.getUserName());
            ps.setString(2, userservice.getPassword());
            
           int success=ps.executeUpdate();    
                if(success==1){
                    result=true;
            }
        } catch (SQLException ex) {
         Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
   public int loginUser(String UserName, String Password) {
String sql = "select * from user where UserName=? and Password=? ";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, UserName);
			stmt.setString(2, Password);

			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return rs.getInt("ID");

		} catch (SQLException e) {
		}

		return 0;
	}
}