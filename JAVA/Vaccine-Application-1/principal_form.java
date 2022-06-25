package cork_vaccine_application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class principal_form extends JFrame {

    /**
     * Creates new form principal_form
     */
 
    public principal_form() 
    {
        try
        {
            //LOAD THE DATA OF THE FILE
            File file = new File("Data_client.dat");
            if(file.exists()) 
            {
                ArrayList<Client> clientlist=Cork_Vaccine_Application.objClientCollection.load_data();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate startdate=null, nextdate=null;
                for(int i = 0; i < clientlist.size(); i++) 
                {
                    startdate=LocalDate.parse(clientlist.get(i).get_vac().get_startDoseDate().toString(), formatter);
                    nextdate=LocalDate.parse(clientlist.get(i).get_vac().get_next_dose_date().toString(), formatter);
                    Vaccination objvaccine=new Vaccination(clientlist.get(i).get_vac().get_name(),clientlist.get(i).get_vac().get_efficacy(),startdate,nextdate);
                    Name objname=new Name(clientlist.get(i).get_firstName(),clientlist.get(i).get_lastName());
                    Client objClient=new Client(clientlist.get(i).get_idClient(),clientlist.get(i).get_phoneClient(), objname, objvaccine);  
                    Cork_Vaccine_Application.objClientCollection.add_client(objClient);
                }
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error loading the data. The file doesn't exists.");
            ex.printStackTrace();
        }
        initComponents();  
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frmMDI = new JDesktopPane();
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        saveMenuItem = new JMenuItem();
        exitMenuItem = new JMenuItem();
        clientsMenu = new JMenu();
        addMenuItem = new JMenuItem();
        removeMenuItem = new JMenuItem();
        searchMenuItem = new JMenuItem();
        displayMenu = new JMenu();
        byvaccineMenuItem = new JMenuItem();
        byIdMenuItem = new JMenuItem();
        saveMenu = new JMenu();
	this.setSize(100,100);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        saveMenuItem.setText("Save information");
        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        clientsMenu.setMnemonic('e');
        clientsMenu.setText("Clients");

        addMenuItem.setMnemonic('t');
        addMenuItem.setText("Add new client");
        addMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addMenuItemActionPerformed(evt);
            }
        });
        clientsMenu.add(addMenuItem);

        removeMenuItem.setMnemonic('y');
        removeMenuItem.setText("Remove client");
        removeMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                removeMenuItemActionPerformed(evt);
            }
        });
        clientsMenu.add(removeMenuItem);

        searchMenuItem.setMnemonic('p');
        searchMenuItem.setText("Search client");
        searchMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchMenuItemActionPerformed(evt);
            }
        });
        clientsMenu.add(searchMenuItem);

        menuBar.add(clientsMenu);

        displayMenu.setMnemonic('h');
        displayMenu.setText("Display");

        byvaccineMenuItem.setMnemonic('c');
        byvaccineMenuItem.setText("Display clients by vaccine");
        byvaccineMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                byvaccineMenuItemActionPerformed(evt);
            }
        });
        displayMenu.add(byvaccineMenuItem);

        byIdMenuItem.setMnemonic('a');
        byIdMenuItem.setText("Display clients by ID");
        byIdMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                byIdMenuItemActionPerformed(evt);
            }
        });
        displayMenu.add(byIdMenuItem);

        menuBar.add(displayMenu);
        menuBar.add(saveMenu);

        setJMenuBar(menuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(frmMDI, GroupLayout.PREFERRED_SIZE, 793, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(frmMDI, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
       //CLOSE THE APP
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void addMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addMenuItemActionPerformed
           // SHOW THE FORM
        add_client frmadd=new add_client();
        frmadd.setSize(300, 300);
        this.setContentPane(frmadd);
        frmadd.setVisible(true);
    }//GEN-LAST:event_addMenuItemActionPerformed

    private void removeMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_removeMenuItemActionPerformed
        // TODO add your handling code here:
        remove_client frmremove=new remove_client();
        this.setContentPane(frmremove);
        frmremove.setVisible(true);
    }//GEN-LAST:event_removeMenuItemActionPerformed

    private void searchMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_searchMenuItemActionPerformed
            // SHOW THE FORM
        search_client frmsearch=new search_client();
        this.setContentPane(frmsearch);
        frmsearch.setVisible(true);
    }//GEN-LAST:event_searchMenuItemActionPerformed

    private void byvaccineMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_byvaccineMenuItemActionPerformed
        // SHOW THE FORM
        show_client frmshow=new show_client();
        this.setContentPane(frmshow);
        frmshow.setVisible(true);
        
    }//GEN-LAST:event_byvaccineMenuItemActionPerformed

    private void saveMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
            // SHOW THE FORM
        Cork_Vaccine_Application.objClientCollection.save_data();
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void byIdMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_byIdMenuItemActionPerformed
            // SHOW THE FORM
         show_client_id frmshow_id=new show_client_id();
        this.setContentPane(frmshow_id);
        frmshow_id.setVisible(true);
    }//GEN-LAST:event_byIdMenuItemActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JMenuItem addMenuItem;
    private JMenuItem byIdMenuItem;
    private JMenuItem byvaccineMenuItem;
    private JMenu clientsMenu;
    private JMenu displayMenu;
    private JMenuItem exitMenuItem;
    private JMenu fileMenu;
    private JDesktopPane frmMDI;
    private JMenuBar menuBar;
    private JMenuItem removeMenuItem;
    private JMenu saveMenu;
    private JMenuItem saveMenuItem;
    private JMenuItem searchMenuItem;
    // End of variables declaration//GEN-END:variables

}
