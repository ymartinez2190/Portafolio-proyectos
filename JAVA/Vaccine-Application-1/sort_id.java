//ORDER THE DATA BY CLIENT ID
package cork_vaccine_application;
import java.util.Comparator;
public class sort_id implements Comparator<Client>
{
    
    public int compare(Client a, Client b) {
        return a.get_idClient().compareTo(b.get_idClient());
    }
    
}
