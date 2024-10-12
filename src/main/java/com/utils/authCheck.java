package com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class authCheck {
    private String password;
    private String username;

    public authCheck(String username, String password) {
        this.username = username;
        this.password = password;
        credCheck(username,password);
    }

    public boolean resultOfAuth()
    {
        boolean result = credCheck(username,password);
        if (result) {
            return true;
        }
        else return false;
    }
    private static boolean credCheck(String username, String password) {
        try (BufferedReader reader = Files.newBufferedReader((Path) authCheck.class.getResourceAsStream("resources/credentials.txt"))) {
            String tempLine;
            while ((tempLine = reader.readLine()) != null) {
                if (tempLine.contains("username:" + username)) {
                    if (reader.readLine().equals("password:" + password)) return true;

                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}