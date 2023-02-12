package stellarburgers.api.data;

public class UserResponse {
    private String accessToken;


    public String getToken() {
        return accessToken;
    }

    public void setToken(String token) {
        this.accessToken = token;
    }
}