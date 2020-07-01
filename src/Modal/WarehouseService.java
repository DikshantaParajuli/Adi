
package Modal;

import java.sql.Date;

public class WarehouseService {
    private int WID;
    private String Menifestname;
    private String Receivefrom;
    private String Destination;
    private String Quantity;
    private String Companytoreceive;
    
    private Date warhdate;
    private int MID;


    public String getMenifestname() {
        return Menifestname;
    }

    public void setMenifestname(String Menifestname) {
        this.Menifestname = Menifestname;
    }

    public String getReceivefrom() {
        return Receivefrom;
    }

    public void setReceivefrom(String Receivefrom) {
        this.Receivefrom = Receivefrom;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
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

    public int getWID() {
        return WID;
    }

    public void setWID(int WID) {
        this.WID = WID;
    }

    public Date getWarhdate() {
        return warhdate;
    }

    public void setWarhdate(Date warhdate) {
        this.warhdate = warhdate;
    }

    public int getMID() {
        return MID;
    }

    public void setMID(int MID) {
        this.MID = MID;
    }
    
    
}
