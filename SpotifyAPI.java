import okhttp3.*;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class SpotifyAPI {

    public static void main(String[] args) {
        getToken();
    }

    public static String getClientSecret() {
        File file = new File("secret.txt");
        try {
            Scanner sc = new Scanner(file);
            return sc.next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject getToken(){
        OkHttpClient client = new OkHttpClient();

        RequestBody body = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .add("client_secret", getClientSecret())
                .add("client_id", "b273f4e8f44d44168fe8c86492e95f86")
                .build();

        Request request = new Request.Builder()
                .url("https://accounts.spotify.com/api/token")
                .addHeader("Content-Type","application/x-www-form-urlencoded")
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());

            return new JSONObject(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
