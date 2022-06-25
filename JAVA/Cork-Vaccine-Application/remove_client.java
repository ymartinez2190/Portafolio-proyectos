package cork_vaccine_application;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class remove_client extends JInternalFrame {

    /**
     * Creates new form remove_client
     */
    public remove_client() 
    {   //LOAD THE DATA TO FORM
        initComponents();
        try
        {
            List<Client> clientlist=new ArrayList<Client>();
            clientlist=Cork_Vaccine_Application.objClientCollection.show_all_clients();
            DefaultTableModel model = (DefaultTableModel) jtbremove.getModel();
            for(Client client:clientlist)
            {
                model.addRow(new Object[]{client.get_idClient(),client.get_name(),client.get_phoneClient(),client.get_vac().get_name(),client.get_vac().get_efficacy(),client.get_vac().get_startDoseDate()});
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }     
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbremove = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btndelete = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();

        setTitle("Delete client");

        jtbremove.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtbremove);

        jLabel1.setText("Select the record you want to delete: ");

        btndelete.setText("Delete record");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(475, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnclose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndelete))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndelete)
                    .addComponent(btnclose))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndeleteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // DELETE THE DATA
        
        if(JOptionPane.showConfirmDialog(null,"You are about to delete a record. Do you wish to continue?","Information",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        {
            Cork_Vaccine_Application.objClientCollection.remove_client(String.valueOf(jtbremove.getValueAt(jtbremove.getSelectedRow(),jtbremove.getSelectedColumn())));
            if(jtbremove.getValueAt(jtbremove.getSelectedRow(),jtbremove.getSelectedColumn())!=null && (jtbremove.getColumnName(jtbremove.getSelectedColumn())=="Identification"))
            {
                DefaultTableModel model = (DefaultTableModel) jtbremove.getModel();

                model.removeRow(jtbremove.getSelectedRow());
                JOptionPane.showMessageDialog(null,"Deleted information");
            }
        }
        
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // CLOSE THE FORM
        this.dispose();
    }//GEN-LAST:event_btncloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btndelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbremove;
    // End of variables declaration//GEN-END:variables
}
