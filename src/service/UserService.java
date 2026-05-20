package service;

import repository.UserRepository;

public class UserService {
    private final UserRepository repo = new UserRepository();

    public String getAllUsersJson() {
        return repo.getAllUsersJson();
    }
}
