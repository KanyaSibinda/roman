package applications.webui.Luma.models;

public class UserDetails {
   public String firstname;
   public String lastname;
   public String email;
   public String password;

    public UserDetails(String firstname, String lastname, String email, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

}
