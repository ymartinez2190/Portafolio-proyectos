package cork_vaccine_application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class show_client extends JInternalFrame {

    /**
     * Creates new form show_client
     */
    public show_client() 
    {
        initComponents();
        //LOAD DATA IF FILE EXIST
        try
        {
            File file = new File("Data_client.dat");
            if(file.exists()) 
            {
                if(!Cork_Vaccine_Application.objClientCollection.load_data_by_vaccine().isEmpty())
                {
                    List<Client> clientlist=new ArrayList();
                    clientlist=Cork_Vaccine_Application.objClientCollection.load_data_by_vaccine();
                    DefaultTableModel model = (DefaultTableModel) jtblregister.getModel();
                    for(Client client:clientlist)
                    {
                        model.addRow(new Object[]{client.get_idClient(),client.get_name(),client.get_phoneClient(),client.get_vac().get_name(),client.get_vac().get_efficacy(),client.get_vac().get_startDoseDate(),client.get_vac().get_next_dose_date()});
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jtblregister = new JTable();
        jLabel1 = new JLabel();
        btnClose = new JButton();

        setTitle("Display all clients");

        jtblregister.setModel(new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Identification", "Complete name", "Phone number", "Vaccine name","Efficacy","First dose date","Second dose name"
            }
        ));
        jScrollPane1.setViewportView(jtblregister);

        jLabel1.setText("Clients registered in the system:");

        btnClose.setText("Close");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnClose)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
    //CLOSE THE FORM
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed


    // VARIABLES DECLARATION - do not modify//GEN-BEGIN:variables
    private JButton btnClose;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable jtblregister;
    // End of variables declaration//GEN-END:variables
}
