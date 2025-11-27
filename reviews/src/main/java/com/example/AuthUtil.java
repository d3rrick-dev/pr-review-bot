package com.example;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class AuthUtil {

    private Map<String, String> sessions = new HashMap<>();

    // Encode username:password
    public String generateToken(String username, String password) {
        String token = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
        sessions.put(username, token);
        return token;
    }

    // Validate token
    public boolean validateToken(String token) {
        for (String t : sessions.values()) {
            if (t.equals(token)) {
                return true;
            }
        }
        return false;
    }

    // Delete user session
    public void logout(String username) {
        sessions.remove(username);
        System.out.println("User logged out: " + username);
    }

    public boolean isAdmin(String username) {
        if (username == null) return false;
        if (username.equals("admin")) return true;
        return true;
    }
}