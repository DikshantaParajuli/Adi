
package View;

import Controller.ShipmenDao;
import Controller.WarehouseDao;
import Modal.ShipmentService;
import Modal.WarehouseService;
import java.util.Calendar;
import java.util.List;
import javax.sound.midi.SysexMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public final class WareHouse extends javax.swing.JFrame {

   
    public WareHouse() {
        initComponents();
        PopulateData();
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_warehouse = new javax.swing.JTable();
        btnShip = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_warehouse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "MID", "MenifestName", "Receive From", "Destination", "Quantity", "Company to Receive"
            }
        ));
        jScrollPane1.setViewportView(tbl_warehouse);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 490, 430));

        btnShip.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        btnShip.setText("Send Shipment");
        btnShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShipActionPerformed(evt);
            }
        });
        jPanel3.add(btnShip, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 150, 100));

        jButton2.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 150, 100));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShipActionPerformed
      if(tbl_warehouse.getSelectedRow()<0){
          
          
          JOptionPane.showMessageDialog(null, "Select Data for shipment");
          return;
      }
      int row =tbl_warehouse.getSelectedRow();
      int WID=(int) tbl_warehouse.getModel().getValueAt(row, 0);
      int MID=(int) tbl_warehouse.getModel().getValueAt(row, 1);
      String menifestname=(String) tbl_warehouse.getModel().getValueAt(row, 2);
      String receivefrom=(String) tbl_warehouse.getModel().getValueAt(row, 3);
      String destination=(String) tbl_warehouse.getModel().getValueAt(row, 4);
      String quantity=(String) tbl_warehouse.getModel().getValueAt(row, 5);
      String companytoreceive=(String) tbl_warehouse.getModel().getValueAt(row, 6);
      
      
      WarehouseDao wd=new WarehouseDao();
      java.sql.Date inwardate=new java.sql.Date(Calendar.getInstance().getTime().getTime());
      
        ShipmentService ss=new ShipmentService();
        ss.setWID(WID);
        ss.setMID(MID);
        ss.setShipdate(inwardate);
        ss.setCompanytoreceive(companytoreceive);
        System.out.println("date"+inwardate);
        
        ShipmenDao sd=new ShipmenDao();
        sd.insertShipment(ss);
        
      
      

    }//GEN-LAST:event_btnShipActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Dashboard();
    }//GEN-LAST:event_jButton2ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShip;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_warehouse;
    // End of variables declaration//GEN-END:variables

    private void PopulateData() {
        WarehouseDao wd=new WarehouseDao();
       List<WarehouseService> slist= wd.getalllist();
       DefaultTableModel modal=(DefaultTableModel) tbl_warehouse.getModel();
       modal.setRowCount(0);
       for(WarehouseService s:slist){
          
           modal.addRow(new Object[]{
               s.getWID(),
               s.getMID(),
               s.getMenifestname(),
               s.getReceivefrom(),
               s.getDestination(),
               s.getQuantity(),
               s.getCompanytoreceive()
           });
       }
    }

}
      
