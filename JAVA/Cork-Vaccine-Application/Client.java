package cork_vaccine_application;
import java.io.Serializable;
import java.time.LocalDate;

public class Client implements Serializable
{
    private String idClient, phoneClient;
    private Name name;
    private Vaccination vac;
    
    /********** CONSTRUCTOR**********/
    public Client(String idClient, String phoneClient, Name name, Vaccination vac)
    {
        this.idClient=idClient;
        this.phoneClient=phoneClient;
        this.name=name;
        this.vac=vac;
    }
    /********** GETTERS **********/

    public String get_idClient()
    {
        return idClient;
    }

    public String get_phoneClient()
    {
        return phoneClient;
    }

    public Name get_name()
    {
        return name;
    }

    public String get_firstName()
    {
        return name.get_firstName();
    }

    public String get_lastName()
    {
        return name.get_lastName();
    }

    public Vaccination get_vac()
    {
        return vac;
    }
  /********** SETTERS **********/

    public void set_idClient(String idClient){
        this.idClient=idClient;
    }

    public void set_phoneClient(String phoneClient){
        this.phoneClient=phoneClient;
    }

    public void set_name(String firstName, String lastName){
        this.name.set_firstName(firstName);
        this.name.set_lastName(lastName);
    }

    public void set_vac(String name, int efficacy, LocalDate startDoseDate){
        this.vac.set_name(name);
        this.vac.set_efficacy(efficacy);
        this.vac.set_startDoseDate(startDoseDate);
        
    }
    public String toString(){
        //WHEN VACCINATED, VACCINE ATTRIBUTES ARE SHOWEN
        if(vac!=null){
                return name+","+get_idClient()+","+get_phoneClient()+","+vac;           
        }
        //ELSE ONLY BASIC CLIENT ATTRIBUTES ARE SHOWEN
        else{
            return name+","+get_idClient()+","+get_phoneClient()+", -";
        }
    }

}
