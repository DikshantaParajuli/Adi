

package Controller;

import Modal.CompanyService;
import adithird.DBconnection;
import static adithird.DBconnection.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CompanyDao extends DBconnection {
    
    public boolean insertCompany(CompanyService companyservice){
        boolean result=true;
        String query="Insert into company(CompanyName,CompanyAddress,Contact) values (?,?,?)";
        
    try {
             PreparedStatement ps;
             
            ps = con.prepareStatement(query);
            ps.setString(1, companyservice.getCompanyname());
            ps.setString(2, companyservice.getCompanyAddress());
             ps.setString(3, companyservice.getContact());
            
            
            
            int success=ps.executeUpdate();    
                if(success==1){
                    result=true;
            }
        } catch (SQLException ex) {
            
        }
        return result;
    }
    
    public int Updatecompany(CompanyService cs){
     int result = 0;
     int ID=cs.getID();
     String companyname=cs.getCompanyname();
     String address=cs.getCompanyAddress();
     String contact=cs.getContact();
       
         
         try{
      String sql="update company set CompanyName=?,CompanyAddress=?,Contact=? where ID=?";
             PreparedStatement pst;
              pst = con.prepareStatement(sql);
                pst.setString(1, cs.getCompanyname());
            pst.setString(2, cs.getCompanyAddress());
             pst.setString(3, cs.getContact());
             pst.setInt(4, cs.getID());
            result = pst.executeUpdate();
            System.out.println(result);
         }catch(SQLException ex) {
           Logger.getLogger(MenifestDao.class.getName()).log(Level.SEVERE, null, ex);
             
         }
        return result;
 }
     public List<CompanyService> getalllist(){
    List<CompanyService> slist=new ArrayList<>();
    String query="Select * from company";
    
    
        try {
            Statement stm=con.createStatement();
           
       
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
                CompanyService cs=new CompanyService();
                cs.setID(rs.getInt("ID"));               
                cs.setCompanyname(rs.getString("CompanyName"));
                cs.setCompanyAddress(rs.getString("CompanyAddress"));
                cs.setContact(rs.getString("Contact"));
              
                slist.add(cs);
                
    }
        }catch(SQLException ex){
            
        }
       return  slist;
    }
      public boolean deleteCompany(int id) {
     
   String sql="delete from company where ID='" +id+"'";
        try {
            Statement stm = con.createStatement();
           
//             stmt.executeQuery(sql);
             stm.execute(sql);
             
             return true;
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    return false;   
    }
      
      
       public CompanyService getById(int id) {
             CompanyService cs=new CompanyService();
   
        String sql="Select * from company where ID='"+id+"'";
        
         try {
             Statement stm=con.createStatement();
              ResultSet rs=stm.executeQuery(sql);
                     while(rs.next()){
        cs.setID(rs.getInt("ID"));               
                cs.setCompanyname(rs.getString("CompanyName"));
                cs.setCompanyAddress(rs.getString("CompanyAddress"));
                cs.setContact(rs.getString("Contact"));
                        
                     }
         } catch (SQLException ex) {
             Logger.getLogger(CompanyDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    return cs;
   
    }
   
}
