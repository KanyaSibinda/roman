package applications.webui.swaglabs.models;

public class Credentials {
    String username;
    String password;

    public Credentials(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

}
