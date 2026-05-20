package server;

import controller.UserController;

public class Router {
    private final UserController userController = new UserController();

    public HttpResponse route(HttpRequest req) {
        String path = req.getPath();
        System.out.println("Path reçu : " + req.getPath());
        return switch (path) {
            case "/" -> new HttpResponse(200, "text/html", "<h1>Accueil</h1>");
            case "/users" -> userController.getAllUsers();
            default -> new HttpResponse(404, "text/plain", "Not Found");
        };
    }
}
