package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class HttpServer {
    private final int port;
    private final Router router;
    public HttpServer(int i, Router router) {
        this.port = i;
        this.router = router;
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port " + port);
        while(true){
            Socket client = server.accept();
            new Thread(() -> {
                try {
                    handleClient(client);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private void handleClient(Socket client) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        OutputStream out = client.getOutputStream();

        HttpRequest request = new HttpRequest(in);
        HttpResponse response = router.route(request);
        out.write(response.toBytes());
        out.flush();
        client.close();
    }

}
