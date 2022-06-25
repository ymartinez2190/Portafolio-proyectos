package cork_vaccine_application;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;


public class show_client_id extends JInternalFrame {

    /**
     * Creates new form show_client_id
     */
    private List<Client> clientlist;
    public show_client_id() {
        initComponents();
         clientlist=new ArrayList();
        try
        {
            //LOAD THE DATA ORDER BY ID
            if(!Cork_Vaccine_Application.objClientCollection.load_data_by_id().isEmpty())
            {
                List<Client> clientlist=new ArrayList();
                clientlist=Cork_Vaccine_Application.objClientCollection.load_data_by_id();
                DefaultTableModel model = (DefaultTableModel) jtbvaccine.getModel();
                for(Client client:clientlist)
                {
                    model.addRow(new Object[]{client.get_idClient(),client.get_name(),client.get_phoneClient(),client.get_vac().get_name(),client.get_vac().get_efficacy(),client.get_vac().get_startDoseDate(),client.get_vac().get_next_dose_date()});
                }  
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jtbvaccine = new JTable();
        btnClose = new JButton();

        setTitle("Show clients by id");

        jLabel1.setText("Client list ordered by id:");

        jtbvaccine.setModel(new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Identification", "Complete name", "Phone number", "Vaccine name","Efficacy","First dose date","Second dose name"
            }
        ));
        jScrollPane1.setViewportView(jtbvaccine);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
            // CLOSE THE FORM
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnClose;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable jtbvaccine;
    // End of variables declaration//GEN-END:variables
}
