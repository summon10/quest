package com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

        try (InputStream fileReader = authCheck.class.getResourceAsStream("/credentials.txt");
             InputStreamReader isr = new InputStreamReader(fileReader);
             BufferedReader bf = new BufferedReader(isr);
             )
        {
            String tempLine;
            while ((tempLine = bf.readLine()) != null) {
                if (tempLine.contains("username:" + username)) {
                    if (bf.readLine().equals("password:" + password)) return true;

                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}