package cork_vaccine_application;

import java.util.Comparator;


//ORDER THE DATA BY VACCINE
public class sort_vaccine implements Comparator<Client>
{
    public int compare(Client a, Client b) 
    {
        return a.get_vac().get_name().compareTo(b.get_vac().get_name());
    }  
}

