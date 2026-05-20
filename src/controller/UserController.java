package controller;

import server.HttpResponse;
import service.UserService;

public class UserController {
    private final UserService userService = new UserService();

    public HttpResponse getAllUsers() {
        String json = userService.getAllUsersJson();
        return new HttpResponse(200, "application/json", json);
    }
}
