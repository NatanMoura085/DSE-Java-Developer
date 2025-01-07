package org.example.domain.service;


import org.example.domain.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    public boolean addUser(User user) {
        for (User u : users) {
            if (u.getEmail().equals(user.getEmail())) {
                return false; // E-mail já existe
            }
        }
        users.add(user);
        return true;
    }

    public boolean deleteUser(String email, boolean isAdmin) {
        if (isAdmin) {
            users.removeIf(u -> u.getEmail().equals(email));
            return true;
        }
        return false;
    }

    public List<User> getAllUsers() {
        return users;
    }
}


