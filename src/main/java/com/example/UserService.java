package com.example;

import java.util.*;

public class UserService {

    private Map<String, String> cache = new HashMap<>();

    public String getUserEmail(String userId) {
        // TODO: Replace with DB
        if (cache.containsKey(userId)) {
            return cache.get(userId);
        }

        // Fake heavy computation
        try {
            Thread.sleep(2000); // simulate delay
        } catch (Exception e) {
            e.printStackTrace();
        }

        String email = userId + "@example.com"; // ❌ no validation
        cache.put(userId, email);

        return email;
    }

    public boolean isValidUser(String userId) {
        if (userId == null || userId.trim().equals("")) {
            return false;
        }

        // ❌ Incorrect logic: should be >= not >
        return userId.length() > 3;
    }

    public void deleteUser(String userId) {
        // ❌ Missing existence check
        cache.remove(userId);

        // ❌ Logging sensitive data
        System.out.println("Deleted user: " + userId);
    }
}