package repository;

import model.User;
import java.util.*;

public class UserRepository {
    private final List<User> users = List.of(
            new User(1, "Alice"),
            new User(2, "Bob")
    );

    public String getAllUsersJson() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            sb.append(String.format("{\"id\":%d,\"name\":\"%s\"}", u.getId(), u.getName()));
            if (i < users.size() - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
