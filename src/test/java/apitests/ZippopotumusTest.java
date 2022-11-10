package apitests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(DataProviderRunner.class)
public class ZippopotumusTest {
    String baseUrl = "http://zippopotam.us/";
    String endPoint = "us/90210";

    @DataProvider
    public static Object[][] zipCodesAndPlaces(){
        return new Object[][] {
                {"ZA","0002","Pretoria"},
                {"US","00210","Portsmouth"},
                {"TH","10100","Samphanthawong"}};
    }

    @Test
    public void getMethod(){
         var response = given().when().get(baseUrl+endPoint);
         response.then().
                 assertThat().body("places[0].'place name'",equalTo("Beverly Hills"));
    }

    @Test
    @UseDataProvider("zipCodesAndPlaces")
    public void statusCodeTest(String countryCode, String zipCode,String placeName){
        var response = given().
                pathParams("countryCode",countryCode).
                pathParams("zipCode",zipCode).
                when().get("http://zippopotam.us/"+"{countryCode}/{zipCode}");
        response.then().
                assertThat().assertThat().body("places[0].'place name'",equalTo(placeName));
    }

    @Test
    public void contentTypeTest(){
        var response = given().when().get(baseUrl+endPoint);
        response.then().
                assertThat().contentType(ContentType.JSON);

    }

    @Test
    public void logRequestAndOutPutDetails(){
       given().
       when().
               log().all().
       when().
       get(baseUrl+endPoint).
       then().
               log().body();
    }
}
