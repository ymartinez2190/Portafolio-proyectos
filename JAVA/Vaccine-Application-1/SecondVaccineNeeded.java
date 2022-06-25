package cork_vaccine_application;
import java.time.LocalDate;
public class SecondVaccineNeeded extends Vaccination
{
   //CREATE THE VACCINE SECOND DOSE INFO
   private String name;
    private int efficacy;
    private LocalDate startDoseDate;
    private LocalDate nextVacinationDate;
    public SecondVaccineNeeded(String name, int efficacy, LocalDate startDoseDate, LocalDate nextVacinationDate)
    {
        super(name,efficacy,startDoseDate,nextVacinationDate);
 
    }
}
