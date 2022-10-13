package apitests;

import applications.apis.typicode.models.SocialMedeaPosts;
import applications.apis.typicode.services.MedeaPostsServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TypicodeTest {
    String baseUrl = "https://jsonplaceholder.typicode.com/";

    @Test
    public void SocialMedeaPostsTest() throws JsonProcessingException {
        MedeaPostsServices medeaPostsServices = new MedeaPostsServices(baseUrl);
        var posts = medeaPostsServices.get();
        Assertions.assertEquals(posts[0].getId(),1);
    }

    @Test
    public void postTest() throws JsonProcessingException {
        MedeaPostsServices medeaPostsServices = new MedeaPostsServices(baseUrl);
        SocialMedeaPosts postToSend = new SocialMedeaPosts(1,"some","some");
        var returnedPost = medeaPostsServices.post(postToSend);

        Assertions.assertEquals(postToSend.getUserId(),returnedPost.getUserId());
        Assertions.assertEquals(postToSend.getBody(),returnedPost.getBody());
        Assertions.assertEquals(postToSend.getTitle(),returnedPost.getTitle());
    }
}
