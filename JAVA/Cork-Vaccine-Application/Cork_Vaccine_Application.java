package cork_vaccine_application;

public class Cork_Vaccine_Application 
{

    public static ClientCollection objClientCollection=new ClientCollection();
    
    public static void main(String[] args) {
        //SHOW THE FORM
        principal_form f=new principal_form();
        f.setSize(800,800);
        f.setVisible(true);
    }
    
}
