
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * PersonalRecord Frame to show the agent the record of one customer only (his offers and bookings)
 * @author User
 */
public class PersonalRecord extends javax.swing.JFrame {

  private Agence agence;
  private Agent agent;
  private Buyer buyer;
  private ArrayList<JLabel> arraylistLabelBooks = new ArrayList<>();
  private ArrayList<JButton> arraylistButton = new ArrayList<>();   
  private ArrayList<Booking> myBookingList = new ArrayList<>();
  private ArrayList<JLabel> arraylistLabelOffers = new ArrayList<>();
  private ArrayList<Offer> myOfferList = new ArrayList<>();
    
    /**
     * Constructor without arguments
     */
    public PersonalRecord() {
       
    }
    
    /**
     * Constructor with the customer we want to see the data of, the connected agent and agence to get all the data
     * @param agence
     * @param agent
     * @param buyer
     */
    public PersonalRecord(Agence agence, Agent agent, Buyer buyer) {
        initComponents();
        this.agence = agence;
        this.buyer = buyer;
        this.agent = agent;
        
        jLabel1.setText(agent.getNom()+ " " + agent.getPrenom());
        String id = String.valueOf(agent.getID());
        jLabel2.setText("ID : " + id);
        jLabel3.setText( buyer.getNom() + " " +buyer.getPrenom()  +"'s record");
        
        arraylistLabelBooks.add(jLabel4);
        arraylistLabelBooks.add(jLabel5);
        arraylistLabelBooks.add(jLabel6);
        arraylistLabelBooks.add(jLabel7);
        arraylistLabelBooks.add(jLabel8);
        arraylistLabelBooks.add(jLabel9);
        arraylistLabelBooks.add(jLabel10);
        arraylistLabelBooks.add(jLabel11);
        arraylistLabelBooks.add(jLabel12);
        
        
        //to see the different bookings of a client
        for(int i = 0; i < agence.getArraylistBooking().size(); ++i){
            if(agence.getArraylistBooking().get(i).getBuyer().getID() == buyer.getID()){
                myBookingList.add(new Booking(agence.getArraylistBooking().get(i).getDate(), agence, agence.getArraylistBooking().get(i).getBuyer(), agence.getArraylistBooking().get(i).getProperty()));
            }
        }
        
        
        for(int j = 0; j < myBookingList.size(); ++j){
            arraylistLabelBooks.get(j).setText("<html> Booking " + (j+1) + "<br>" + "date : " + myBookingList.get(j).getDate()
                    + "<br>" + "Buyer : " + myBookingList.get(j).getBuyer().getNom() + " " + myBookingList.get(j).getBuyer().getPrenom() 
                    + "<br>" + "Adress : " + myBookingList.get(j).getProperty().getAdress()
                    + "<br>" + "Property ID : " + myBookingList.get(j).getProperty().getID());
            arraylistLabelBooks.get(j).setVisible(true);
            //arraylistButton.get(j).setVisible(true);            
        }
        
        for(int k = myBookingList.size(); k < arraylistLabelBooks.size(); ++k){
            arraylistLabelBooks.get(k).setVisible(false);
            //arraylistButton.get(k).setVisible(false);
        }
        
        
        //to see the different offers of a client
        
        arraylistLabelOffers.add(jLabel13);
        arraylistLabelOffers.add(jLabel14);
        arraylistLabelOffers.add(jLabel15);
        arraylistLabelOffers.add(jLabel16);
        arraylistLabelOffers.add(jLabel17);
        arraylistLabelOffers.add(jLabel18);
     
       
      for(int i = 0; i < agence.getArraylistOffer().size(); ++i){
            if(agence.getArraylistOffer().get(i).getBuyer().getID() == buyer.getID()){
                myOfferList.add(new Offer(agence.getArraylistOffer().get(i).getProperty(),agence.getArraylistOffer().get(i).getBuyer(), agence, agence.getArraylistOffer().get(i).getBuyerOffer()));
            }
        }
        
        for(int j = 0; j < myOfferList.size(); ++j){
            arraylistLabelOffers.get(j).setText("<html> Offer " + (j+1) 
                    + "<br>" + "Value of the offer : " + myOfferList.get(j).getBuyerOffer()
                    + "<br>" + "Regular price of the house : " + myOfferList.get(j).getProperty().getPrice()
                    + "<br>" + "Buyer : " + myOfferList.get(j).getBuyer().getNom() + " " + myOfferList.get(j).getBuyer().getPrenom() 
                    + "<br>" + "Adress of the property : " + myOfferList.get(j).getProperty().getAdress()
                    + "<br>" + "Property ID : " + myOfferList.get(j).getProperty().getID());
            arraylistLabelOffers.get(j).setVisible(true);
                       
        }
      
        
        for(int k = myOfferList.size(); k < arraylistLabelOffers.size(); ++k){
            arraylistLabelOffers.get(k).setVisible(false);
            //arraylistButton.get(k).setVisible(false);
        }
        
        
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        jLabel16.setText("jLabel16");

        jLabel17.setText("jLabel17");

        jLabel18.setText("jLabel18");

        jButton1.setText("Go back to customer record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(180, 180, 180)
                                .addComponent(jLabel3))
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(215, 215, 215)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13))
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addComponent(jLabel14)
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addGap(24, 24, 24)
                .addComponent(jLabel15)
                .addGap(1, 1, 1)
                .addComponent(jLabel7)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel16))
                .addGap(45, 45, 45)
                .addComponent(jLabel9)
                .addGap(7, 7, 7)
                .addComponent(jLabel17)
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addGap(25, 25, 25)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(45, 45, 45)
                .addComponent(jLabel12)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CustomerRecord customerRecord = new CustomerRecord(agence, agent);
        customerRecord.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PersonalRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonalRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonalRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonalRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonalRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
