
package cork_vaccine_application;

import java.io.Serializable;

public class Name implements Serializable
{
     private String firstName, lastName;

    /*****************CLASS CONSTRUCTOR*****************/
    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /***************** GETTERS *****************/

    public String get_firstName(){
        return firstName;
    }

    public String get_lastName(){
        return lastName;
    }

    /***************** SETTERS *****************/

    public void set_firstName(String firstName){
        this.firstName=firstName;
    }

    public void set_lastName(String lastName){
        this.lastName=lastName;
    }

    /***************** TOSTRING METHOD. RETURNS CLASS ATTRIBUTES. LASTNAME AND FIRSTNAME *****************/
    public String toString(){
        return lastName+" "+firstName;
    }
}
