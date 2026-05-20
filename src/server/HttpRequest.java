package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HttpRequest {
    public final String method;
    public final String path;
    public String body = "";
    public final Map<String, String> headers = new HashMap<>();



    public HttpRequest(BufferedReader in)  throws IOException {
        int contentLength = 0;
        String line = in.readLine();
        if (line == null || line.isEmpty()) {
            method = "";
            path = "";
            return;
        }
        String[] parts = line.split(" ");
        this.method = parts[0];
        this.path = parts[1];

        while((line = in.readLine()).isEmpty()){
            if (line.startsWith("Content-Length:")) {
                contentLength = Integer.parseInt(line.split(":")[1].trim());
            }
            String[] headerParts = line.split(":");
            headers.put(headerParts[0],headerParts[1]);
        }

        String body = "";
        if(contentLength > 0 ){
            char[] chars = new char[contentLength];
            in.read(chars,0,contentLength);
            body = new String(chars);
        }
        this.body = body;

    }



    public String getMethod(){return this.method; }
    public String getPath(){return this.path;}
    public Map<String, String> getHeaders(){return this.headers;}
    public String getBody(){return this.body;}
}
