package applications.apis.typicode.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialMedeaPosts {
    private int userId;
    private int id;
    private String title;
    private String body;

    public SocialMedeaPosts(int userId,String title,String body){
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
}
