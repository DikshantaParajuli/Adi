
package Modal;

import java.sql.Date;

public class ShipmentService {
    private int SID;
    private String Shipmentname;
    private String ShipmentDestination;
    private String Quantity;
    private String Menifestname;
    private String Receive;
    private String Companytoreceive;
    private Date shipdate;
    private int WID;
   private int MID;
   
   
   
   private int costcompany;
   private int costcleint;
   private int daysrs;
   private  int costotal;
   

    public int getMID() {
        return MID;
    }

    public void setMID(int MID) {
        this.MID = MID;
    }

   

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

   
    public String getShipmentname() {
        return Shipmentname;
    }

    public void setShipmentname(String Shipmentname) {
        this.Shipmentname = Shipmentname;
    }

    public String getShipmentDestination() {
        return ShipmentDestination;
    }

    public void setShipmentDestination(String ShipmentDestination) {
        this.ShipmentDestination = ShipmentDestination;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public String getCompanytoreceive() {
        return Companytoreceive;
    }

    public void setCompanytoreceive(String Companytoreceive) {
        this.Companytoreceive = Companytoreceive;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

   
     public int getWID() {
        return WID;
    }

    public void setWID(int WID) {
        this.WID = WID;
    }
      public String getMenifestname() {
        return Menifestname;
    }

    public void setMenifestname(String Menifestname) {
        this.Menifestname = Menifestname;
    }

    public String getReceive() {
        return Receive;
    }

    public void setReceive(String Receive) {
        this.Receive = Receive;
    }

    /**
     * @return the costcompany
     */
    public int getCostcompany() {
        return costcompany;
    }

    /**
     * @param costcompany the costcompany to set
     */
    public void setCostcompany(int costcompany) {
        this.costcompany = costcompany;
    }

    public int getCostcleint() {
        return costcleint;
    }


    public void setCostcleint(int costcleint) {
        this.costcleint = costcleint;
    }

    public int getDaysrs() {
        return daysrs;
    }

    public void setDaysrs(int daysrs) {
        this.daysrs = daysrs;
    }

    public int getCostotal() {
        return costotal;
    }

    public void setCostotal(int costotal) {
        this.costotal = costotal;
    }

}
