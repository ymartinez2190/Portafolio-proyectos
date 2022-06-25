package cork_vaccine_application;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class add_client extends JInternalFrame {

    /**
     * Creates new form add_client
     */
    LocalDate startdate=null;
    LocalDate nextdose=null;
    public add_client() 
    {
        
        initComponents();
        startdate=LocalDate.now();
        txtdate.setText(startdate.toString());
        this.setSize(200, 200);
    }

 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new JButton();
        jPanel1 = new JPanel();
        txtdate = new JTextField();
        btnadd = new JButton();
        jLabel1 = new JLabel();
        cbovaccine = new JComboBox<>();
        txtfirstname = new JTextField();
        jLabel5 = new JLabel();
        jLabel2 = new JLabel();
        btnclose = new JButton();
        txtlastname = new JTextField();
        jLabel7 = new JLabel();
        txtid = new JTextField();
        txtfinal = new JTextField();
        jLabel3 = new JLabel();
        jLabel8 = new JLabel();
        jLabel4 = new JLabel();
        txtefficacy = new JTextField();
        txtphone = new JTextField();
        jLabel9 = new JLabel();
        jLabel6 = new JLabel();
        txtdoses = new JTextField();

        jButton1.setText("jButton1");

        setClosable(true);
        setTitle("Add new client info");
        setMaximumSize(new java.awt.Dimension(88, 34));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(200, 200));

        btnadd.setText("Add client");
        btnadd.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        jLabel1.setText("Firstname:");
        jLabel1.setToolTipText("");

        cbovaccine.setModel(new DefaultComboBoxModel<>(new String[] { "Pfizer", "AstraZeneca", "Moderna", "Johnson & Johnson" }));
        cbovaccine.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbovaccineActionPerformed(evt);
            }
        });

        txtfirstname.setName("txt_firstname"); // NOI18N

        jLabel5.setText("Vaccine selected:");

        jLabel2.setText("Lastname:");

        btnclose.setText("Close");
        btnclose.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        jLabel7.setText("Final dose date:");

        jLabel3.setText("Identification Nº:");

        jLabel8.setText("Efficacy (in %):");

        jLabel4.setText("Phone:");

        jLabel9.setText("Doses:");

        jLabel6.setText("Start dose date:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfirstname, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtlastname, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtphone, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbovaccine, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(7, 7, 7)
                                .addComponent(txtdoses, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtdate, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfinal, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtefficacy, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnclose, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnadd, GroupLayout.Alignment.TRAILING))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtfirstname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlastname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtphone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbovaccine, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtfinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnadd))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtdoses, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtefficacy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclose))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // ADD A NEW CLIENT TO COLLECTION
        try
        {
            Vaccination objvaccine=new Vaccination(cbovaccine.getSelectedItem().toString(),Integer.parseInt(txtefficacy.getText()),startdate,nextdose);
            Name objname=new Name(txtfirstname.getText(),txtlastname.getText());
            Client objClient=new Client(txtid.getText(),txtphone.getText(), objname, objvaccine);
            Cork_Vaccine_Application.objClientCollection.add_client(objClient);
            JOptionPane.showMessageDialog(null,"New client was added");
            this.cleartext();
        }
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, "Error adding the client.");
            ex.printStackTrace();
        }
    
       
    }//GEN-LAST:event_btnaddActionPerformed

    private void btncloseActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        this.dispose();       // CLOSE THE FORM
      
    }//GEN-LAST:event_btncloseActionPerformed

    private void cleartext()
    {
        txtfirstname.setText("");
        txtlastname.setText("");
        txtid.setText("");
        txtphone.setText("");
        txtdate.setText("");
        txtfinal.setText("");
        txtdoses.setText("");
        txtefficacy.setText("");
    }
    private void cbovaccineActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cbovaccineActionPerformed
        //SET THE INFO TO CALCULARTE THE DATA OF SECOND DOSE AND EFFICACY
        switch(cbovaccine.getSelectedIndex())
        {
            case 0:
                nextdose=startdate.plusWeeks(4);
                txtfinal.setText(nextdose.toString());
                txtdoses.setText("2");
                txtefficacy.setText("95");
                break;
            case 1:
                nextdose=startdate.plusWeeks(8);
                txtfinal.setText(nextdose.toString());
                txtdoses.setText("2");
                txtefficacy.setText("95");
                break;
            case 2:
               nextdose=startdate.plusWeeks(4);
               txtfinal.setText(nextdose.toString());
               txtdoses.setText("2");
               txtefficacy.setText("94");
               break;
            case 3:
               txtfinal.setText("-");
               
               txtdoses.setText("-");
               txtefficacy.setText("72");
               break;     
        }   
    }//GEN-LAST:event_cbovaccineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnadd;
    private JButton btnclose;
    private JComboBox<String> cbovaccine;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JTextField txtdate;
    private JTextField txtdoses;
    private JTextField txtefficacy;
    private JTextField txtfinal;
    private JTextField txtfirstname;
    private JTextField txtid;
    private JTextField txtlastname;
    private JTextField txtphone;
    // End of variables declaration//GEN-END:variables
}
