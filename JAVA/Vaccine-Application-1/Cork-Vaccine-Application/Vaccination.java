package cork_vaccine_application;
import java.io.Serializable;
import java.time.LocalDate;

public class Vaccination implements Serializable
{
    private String name;
    private int efficacy;
    private LocalDate startDoseDate;
    private LocalDate nextVacinationDate;
    //CONSTRUCTOR
    public Vaccination(String name, int efficacy, LocalDate startDoseDate, LocalDate nextVacinationDate)
    {
        this.name=name;
        this.efficacy=efficacy;
        this.startDoseDate=startDoseDate;
        this.nextVacinationDate=nextVacinationDate;
    }
    
    //GETTERS
    public LocalDate get_next_dose_date()
{
        return nextVacinationDate;
    }
     public String get_name()
    {
        return name;
    }
     
      public int get_efficacy()
    {
        return efficacy;
    }
       public LocalDate get_startDoseDate()
    {
        return startDoseDate;
    }
    
       //SETTERS
    public void set_name(String name)
    {
        this.name=name;
    }
    
    public void set_efficacy(int efficacy)
    {
        this.efficacy=efficacy;
    }
    
    public void set_startDoseDate(LocalDate startDoseDate)
    {
        this.startDoseDate=startDoseDate;
    }
     public void set_next_dose_date(LocalDate nextVacinationDate)
    {
        this.nextVacinationDate=nextVacinationDate;
    }
     public String toString(){
        return name +","+efficacy+","+startDoseDate+ ","+nextVacinationDate;
    }
}
