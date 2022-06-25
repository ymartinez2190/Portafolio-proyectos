package cork_vaccine_application;

import java.util.ArrayList;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class search_client extends JInternalFrame {

    /**
     * Creates new form search_client
     */
    private List<Client> clientlist;
    public search_client() {
        initComponents();
        //LOAD THE DATA TO THE FORM
        clientlist=new ArrayList();
        clientlist=Cork_Vaccine_Application.objClientCollection.show_all_clients();
        DefaultTableModel model = (DefaultTableModel) jtbsearch.getModel();
         for(Client client:clientlist)
         {
            model.addRow(new Object[]{client.get_idClient(),client.get_name(),client.get_phoneClient(),client.get_vac().get_name(),client.get_vac().get_efficacy(),client.get_vac().get_startDoseDate()});
         }     
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new JLabel();
        txtsearch = new JTextField();
        jScrollPane1 = new JScrollPane();
        jtbsearch = new JTable();
        btnfind = new JButton();
        btnclose = new JButton();

        setTitle("Search client");

        jLabel1.setText("Write the client id to search:");

        jtbsearch.setModel(new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Identification", "Complete name", "Phone number", "Vaccine name","Efficacy","First dose date","Second dose name"
            }
        ));
        jScrollPane1.setViewportView(jtbsearch);

        btnfind.setText("Find");
        btnfind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });

        btnclose.setText("close");
        btnclose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btnclose)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtsearch, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnfind))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtsearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfind))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnclose)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnfindActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
        // SEARCH THE INFO BY ID
        String search=txtsearch.getText();
        DefaultTableModel dm = (DefaultTableModel) jtbsearch.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtbsearch.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_btnfindActionPerformed

    private void btncloseActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // CLOSE THE FORM
        this.dispose();
    }//GEN-LAST:event_btncloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnclose;
    private JButton btnfind;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable jtbsearch;
    private JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
