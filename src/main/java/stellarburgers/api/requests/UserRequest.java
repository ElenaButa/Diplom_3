package stellarburgers.api.requests;

import stellarburgers.api.data.User;
import stellarburgers.api.data.UserResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;

public class UserRequest {
    public static UserResponse loginUser(User user) {
        Response response = given().log().all()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("/api/auth/login");
        return response.as(UserResponse.class);
    }

    public static void deleteUser(UserResponse userResponse) {
        given().log().all()
                .header("Content-type", "application/json")
                .header("authorization", userResponse.getToken())
                .when()
                .delete("/api/auth/user")
                .then()
                .statusCode(SC_ACCEPTED);

    }

}