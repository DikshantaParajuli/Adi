

package Controller;

import Modal.MenifestService;
import adithird.DBconnection;
import static adithird.DBconnection.con;
import Modal.WarehouseService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MenifestDao extends DBconnection{

    public boolean insertUser(MenifestService menifestservice){
        boolean result=false;
        int generatedkey=0;
        String query="INSERT into menifestdetail(MenifestName,ReceiveFrom,Destination,Quantity,"
                + "CompanyToReceive) VALUES (?,?,?,?,?)";
        
         try {
             PreparedStatement ps;
             System.out.println("Data xa");
            ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, menifestservice.getMenifestname());
            ps.setString(2, menifestservice.getFrom());
            ps.setString(3, menifestservice.getDestination());
            ps.setString(4, menifestservice.getQuantity());
            ps.setString(5, menifestservice.getCompanytoreceive());
            
          
            ps.execute();
        
             result = true;
             ResultSet rs=ps.getGeneratedKeys();
             MenifestService ms=new MenifestService();
       if(rs.next()){
           generatedkey=rs.getInt(1); 
           
              System.out.println("Generate key : "+generatedkey);
            ms.setID(generatedkey);
            WarehouseService ws=new WarehouseService();
            java.sql.Date intwardate= new java.sql.Date(Calendar.getInstance().getTime().getTime());
//            ws.setWID(generatedkey);
            ws.setMID(generatedkey);
            System.out.println("manfid : "+generatedkey);
            ws.setWarhdate(intwardate);
            System.out.println("Date ho yo yo yo : "+intwardate);
            WarehouseDao wd=new WarehouseDao();
            wd.InsertWarehouse(ws);
           
       }
           
         
            
        } catch (SQLException ex) {
            Logger.getLogger(MenifestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }
 public int Updatemenifest(MenifestService menifestservice){
     int result = 0;
     int ID=menifestservice.getID();
     String MenifestName=menifestservice.getMenifestname();
      String ReceiveFrom=menifestservice.getFrom();
       String Destination=menifestservice.getDestination();
        String Quantity=menifestservice.getQuantity();
         String CompanyToReceive=menifestservice.getCompanytoreceive();
         
         try{
      String sql="update menifestdetail set MenifestName=?,ReceiveFrom=?,Destination=?,Quantity=?,"
              + "CompanyToReceive=? where ID=?";
             PreparedStatement pst;
              pst = con.prepareStatement(sql);
             
                 pst.setString(1, menifestservice.getMenifestname());
            pst.setString(2, menifestservice.getFrom());
            pst.setString(3, menifestservice.getDestination());
            pst.setString(4, menifestservice.getQuantity());
            pst.setString(5, menifestservice.getCompanytoreceive());
            pst.setInt(6, menifestservice.getID());

              
            result = pst.executeUpdate();
            System.out.println(result);
         }catch(SQLException ex) {
           Logger.getLogger(MenifestDao.class.getName()).log(Level.SEVERE, null, ex);
             
         }
        return result;
 }
  public int DeleteManifest(MenifestService m) {
        int result = 0;
        
        try {
             String  sql = "Delete from menifestdetail where CompanyToReceive=?";
              PreparedStatement pst = con.prepareStatement(sql);
              pst.setString(1, m.getCompanytoreceive());
              result = pst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return result;
    }

    
    public List<MenifestService> getalllist(){
    List<MenifestService> slist=new ArrayList<>();
    String query="Select * from menifestdetail ";
    
    
        try {
            Statement stm=con.createStatement();
           
       
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
                MenifestService ws=new MenifestService();
                ws.setID(rs.getInt("ID"));               
                ws.setMenifestname(rs.getString("MenifestName"));
                ws.setFrom(rs.getString("ReceiveFrom"));
                ws.setDestination(rs.getString("Destination"));
                ws.setQuantity(rs.getString("Quantity"));
                ws.setCompanytoreceive(rs.getString("CompanyToReceive"));
                slist.add(ws);
                
    }
        }catch(SQLException ex){
            
        }
       return  slist;
    }
      public boolean deleteMenfest(int id) {
     
   String sql="delete from menifestdetail where ID='" +id+"'";
        try {
            Statement stm = con.createStatement();
           
//             stmt.executeQuery(sql);
             stm.execute(sql);
             
             return true;
        } catch (SQLException ex) {
            Logger.getLogger(MenifestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    return false;   
    }


}
    

  
