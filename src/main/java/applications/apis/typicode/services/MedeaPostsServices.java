package applications.apis.typicode.services;

import applications.apis.typicode.models.SocialMedeaPosts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class MedeaPostsServices {
        String baseUrl;
        String endPoint = "posts";
        ObjectMapper mapper = new ObjectMapper();
        public MedeaPostsServices(String baseUrl){
            this.baseUrl = baseUrl;
        }

        public SocialMedeaPosts[] get() throws JsonProcessingException {
            Response response = given().when().get(baseUrl+endPoint);
            response.then().statusCode(200);
            SocialMedeaPosts[] socialMedeaPosts = mapper.readValue(response.body().asString(),SocialMedeaPosts[].class);
            return socialMedeaPosts;
        }
        public SocialMedeaPosts post(SocialMedeaPosts smPosts) throws JsonProcessingException {
            var body = mapper.writeValueAsString(smPosts);
            var request = given().body(body).contentType("application/json").when();
            var response = request.post(baseUrl+endPoint);
            response.then().statusCode(201);
            return mapper.readValue(response.body().asString(),SocialMedeaPosts.class);
        }
    }

