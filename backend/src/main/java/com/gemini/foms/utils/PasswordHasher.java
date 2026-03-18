package com.gemini.foms.utils;

public class PasswordHasher {
    private static String hash;

    public static String hashedPassword(String password){
        return hash+password;
    }
}
