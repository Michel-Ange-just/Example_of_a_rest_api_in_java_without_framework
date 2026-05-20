package server;

public class HttpResponse {
    private final int status;
    private final String contentType;
    private final String body;


    public HttpResponse(int status, String contentType, String body) {
        this.status = status;
        this.contentType = contentType;
        this.body = body;
    }

    public byte[] toBytes(){
        String response = "HTTP/1.1 " + status + " \r\n" +
                "Content-Type: " + this.contentType + "\r\n" +
                "Content-Length: " + this.body.length() + "\r\n\r\n" +
                body;
        return response.getBytes();
    }
}
