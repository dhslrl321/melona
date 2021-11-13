import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPRequest {
    private HttpURLConnection http;

    public InputStream get() {
        try {
            URL url = new URL("http://localhost:8080/music");
            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            InputStream inputStream = http.getInputStream();
            return inputStream;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public InputStream getString() {
        try {
            URL url = new URL("http://localhost:8080/music");
            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            return http.getInputStream();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
