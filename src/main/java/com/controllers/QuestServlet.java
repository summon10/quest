package com.controllers;

import com.entity.Character;
import com.entity.Gun;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet( urlPatterns = {"/quest/"} )

public class QuestServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        Character.getInstance().name = "Duke";
        HttpSession session = req.getSession(true);
        session.setAttribute("character", Character.getInstance().name);
        session.setAttribute("guns", Gun.getInstance());
        //session.setAttribute("cards", Character.getInstance());
        System.out.println(Character.getInstance().name);
        String redirectUrl = resp.encodeRedirectURL("/quest/quest.jsp");
        resp.sendRedirect(redirectUrl);

    }



    }

