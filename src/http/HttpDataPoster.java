package http;

import org.icefaces.ace.json.JSONException;
import org.openfaces.org.json.JSONObject;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HttpDataPoster implements Runnable {
    private  String url;
    private String data;
    private JsonObject sendData;

    public HttpDataPoster(String url, JsonObject sendData){
        this.url = url;
        this.sendData = sendData;
    }
    @Override
    public void run() {
        try{
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty(
                    "Content-Type", "application/x-www-from-urlencoded; charset=utf-8"
            );
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            System.out.println("sendData|||||||||||||||: " + sendData);

            os.write(sendData.toString().getBytes(StandardCharsets.UTF_8));
            os.close();

            InputStream response = con.getInputStream();
            Scanner s = new Scanner(response).useDelimiter("\\A");
            data = s.hasNext() ? s.next() : "";
        }
        catch (Exception e){
            data = e.getMessage();
        }
    }

    public String getData(){
        Thread thread = new Thread(this);
        thread.start();
        try{
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return data;
    }
}
