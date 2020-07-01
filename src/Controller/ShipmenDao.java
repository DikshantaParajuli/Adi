
package Controller;

import adithird.DBconnection;
import Modal.ShipmentService;
import static adithird.DBconnection.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShipmenDao extends DBconnection{
       boolean result=false;
    public boolean insertShipment(ShipmentService sm){
        
        String query="INSERT into shipment(WID,MID,Sdate) values (?,?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(query);
            
            ps.setInt(1,sm.getWID());
             ps.setInt(2,sm.getMID());
            ps.setDate(3,sm.getShipdate());
            ps.executeUpdate();
            result=true;
//                        JOptionPane.showMessageDialog(null, "Data added successfully");

//            ResultSet rs=ps.getGeneratedKeys();
            ShipmentService ss=new ShipmentService();
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      public List<ShipmentService> getalllist(){
    List<ShipmentService> slist=new ArrayList<>();
    String query="SELECT \n" +
"*\n" +
"FROM shipment s, menifestdetail m, warehouse w\n" +
"WHERE s.MID = m.ID AND s.WID = w.WID;";
    
    
        try {
            Statement stm=con.createStatement();
            
//           ResultSet rs = null;
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            ShipmentService sm=new ShipmentService();
              sm.setWID(rs.getInt("WID"));
              System.out.print("is it WID"+rs.getInt("WID"));
              sm.setSID(rs.getInt("SID"));
              sm.setShipdate(rs.getDate("Sdate"));
              sm.setMenifestname(rs.getString("MenifestName"));
              sm.setCompanytoreceive(rs.getString("CompanyToReceive"));
               slist.add(sm);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
return  slist;

    }
  public List<ShipmentService> getalllistbyReceive(){
    List<ShipmentService> slist=new ArrayList<>();
    String query="SELECT \n" +
"*\n" +
"FROM shipment s, menifestdetail m, warehouse w\n" +
"WHERE s.MID = m.ID AND s.WID = w.WID and s.Deliver=\"Receive\"";
    
    
        try {
            Statement stm=con.createStatement();
            
//           ResultSet rs = null;
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            ShipmentService sm=new ShipmentService();
              sm.setWID(rs.getInt("WID"));
              System.out.print("is it WID"+rs.getInt("WID"));
              sm.setSID(rs.getInt("SID"));
              sm.setShipdate(rs.getDate("Sdate"));
              sm.setMenifestname(rs.getString("MenifestName"));
              sm.setCompanytoreceive(rs.getString("CompanyToReceive"));
              sm.setReceive("Receive");
              sm.setCostcleint(rs.getInt("costclient"));
                sm.setCostotal(rs.getInt("totalcost"));
         sm.setCostcompany(rs.getInt("costcompany"));

               slist.add(sm);
               System.out.print("Receive wala aayo");
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
return  slist;

  }
  public boolean UpdateShipment(ShipmentService sm){
        
        String query="Update shipment set Deliver=?,costcompany=?,dayshs=?,costclient=?,totalcost=? where SID=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(query);
            
            ps.setString(1,"Receive");
            ps.setInt(2, sm.getCostcompany());
           ps.setInt(3, sm.getDaysrs());
        ps.setInt(4, sm.getCostcleint());
       ps.setInt(5, sm.getCostotal());


            ps.setInt(6,sm.getSID());
            System.out.println(" Ship[ment update wala ho naga ");
            
            ps.executeUpdate();
            result=true;
//                        JOptionPane.showMessageDialog(null, "Data added successfully");

//            ResultSet rs=ps.getGeneratedKeys();
            ShipmentService ss=new ShipmentService();
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
