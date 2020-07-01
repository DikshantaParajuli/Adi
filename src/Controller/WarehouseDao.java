
package Controller;



import Modal.WarehouseService;
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

public class WarehouseDao extends DBconnection{
    
    public boolean InsertWarehouse(WarehouseService ws){
    
        boolean result=true;
        int generatedkey=0;
       String query="INSERT into warehouse(MID,Wdate) values(?,?)";
       
       PreparedStatement ps;
        try {
             ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1,ws.getMID());
            ps.setDate(2,ws.getWarhdate());
            ps.execute();
              ps.execute();
             result = true;
             ResultSet rs=ps.getGeneratedKeys();
            
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<WarehouseService> getalllist(){
    List<WarehouseService> slist=new ArrayList<>();
    String query="SELECT * FROM warehouse w, menifestdetail m WHERE w.mid = m.id";
    
    
        try {
            Statement stm=con.createStatement();
            
//           ResultSet rs = null;
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
              WarehouseService ws=new WarehouseService();
              ws.setWID(rs.getInt("WID"));
              ws.setMID(rs.getInt("MID"));
                
                System.out.println(rs.getInt("WID"));
//                System.out.println("Id : "+rs.getInt("WID"));
               
                 System.out.println("Id : "+rs.getInt("MID"));
                ws.setWarhdate(rs.getDate("Wdate"));
                 System.out.println(rs.getInt("Wdate"));
                ws.setMenifestname(rs.getString("MenifestName"));
                ws.setReceivefrom(rs.getString("ReceiveFrom"));
                ws.setDestination(rs.getString("Destination"));
                ws.setQuantity(rs.getString("Quantity"));
                ws.setCompanytoreceive(rs.getString("CompanyToReceive"));
                slist.add(ws);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(WarehouseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
return  slist;
}
}
   