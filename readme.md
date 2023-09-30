# Problem Domain Description
Our team will be looking into the media management domain.

# What kind of application we are planning to make
We plan to make an app to manage and share music across different streaming platforms, for example sharing a playlist from Apple Music to Spotify.
This will require the user to authenticate our app with multiple APIs for streaming services.

# Link to API documentation we could use
https://developer.spotify.com/documentation/web-api/tutorials/getting-started#create-an-app
https://developer.apple.com/documentation/applemusicapi/

# Hoppscotch screenshot of interacting with API
![image](https://github.com/TeenI126/week3project/assets/122706062/b69af69e-90f7-461a-a300-a5336d162974)

# Possible Issues
Accessing user data will require a redirect webpage during the authorization process to receive an access code. 
This may be beyond the scope of this project, and might require a workaround.

# Java code
  example of attempting to call API from code
```
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
```
  example output
```
{"access_token":"BQBSIOaPRkw8HOscKHiDDTSIOJNUeGSd8MmxuTCh53jBRmalfRRdM25SeiZXlk4QBfOf3XEecFaqVzwrODrpQeAEcgw-TWRHb06UZ9cZeEgHxnuHgQo","token_type":"Bearer","expires_in":3600}
```
