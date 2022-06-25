package cork_vaccine_application;
import java.io.Serializable;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class ClientCollection  implements Serializable
{
   private List<Client> clientlist;
   //CONSTRUCTOR
    public ClientCollection()
    {
      clientlist = new ArrayList<Client>();
    }
    //GET CLIENT LIST INFO
    public List<Client> get_clientlist()
    {
       return clientlist;
    }
    //ADD CLIENT TO THE LIST
    public void add_client(Client client)
    {
        
        try
        {
            clientlist.add(client);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }  
    }
    //FIND THE INDEX OF THE DATA
     public int find_clientIndex(String id)
     {
        int i=0, index=-1;

        //LOOP FOR SEARCHING A CLIENT IN CLIENTS LIST BY ID
        for(Client client : clientlist){
            if(id.equalsIgnoreCase(client.get_idClient())){
                //IF FINDED THE INDEX IS STORED
                index=i;
            }
            i++;
        }
        
        return index;
    }
     //REMOVE THE DATA BY THE INDEX
    public void remove_client(String id)
    {
        int index = find_clientIndex(id);
        
        //WHEN INDEX IS -1 MEANS THE ID IS INVALID OR DOES NOT EXIST IN CLIENTS LIST
        if(index!=-1){
            clientlist.remove(index);
            JOptionPane.showMessageDialog(null,"Client deleted!");
        }
        else{
           JOptionPane.showMessageDialog(null,"The given code doesnt exist for a valid client on this vaccine centre!");
        }
    }
    //RETURN THE CLIENTLIST VALUE TO LOAD THE INFO IN THE FORM
    public List<Client> show_all_clients()
     {
         
        return clientlist;
    }
    //SAVE THE DATA IN THE FILE
    public void save_data()
    {
        try 
        {
           ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("Data_client.dat"));
            escribiendoFichero.writeObject(clientlist);
            escribiendoFichero.close();
            JOptionPane.showMessageDialog(null,"Client list data saved");
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //LOAD THE DATA FROM THE FILE
    public ArrayList<Client> load_data()
    {
        
        ArrayList<Client> arrayList2=null;
        try 
        {
           ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream("Data_client.dat"));
            arrayList2 =(ArrayList<Client>)leyendoFichero.readObject();
            leyendoFichero.close();             
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList2;
    }
    //LOAD THE DATA BY ID
    public List<Client> load_data_by_id()
    {
        
       List<Client> arrayList2=null;
        try 
        {
            ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream("Data_client.dat"));
            arrayList2 =(ArrayList<Client>)leyendoFichero.readObject();
            leyendoFichero.close();  
            if(arrayList2.isEmpty() &&(!clientlist.isEmpty()))
            {
                arrayList2=clientlist;
                
            }
            //SORT THE DATA BY ID
           Collections.sort(arrayList2,new sort_id());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList2;
    }
    //LOAD THE DATA ORDER BY VACCINE NAME
    public ArrayList<Client> load_data_by_vaccine()
    {
        
        ArrayList<Client> arrayList2=null;
        try 
        {
           ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream("Data_client.dat"));
            arrayList2 =(ArrayList<Client>)leyendoFichero.readObject();
            leyendoFichero.close();  
            //SORT THE DATA BY VACCINE NAME
            Collections.sort(arrayList2,new sort_vaccine());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList2;
    }
    
}

