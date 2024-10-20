package com.controllers;

import com.entity.Card;
import com.entity.Character;
import com.entity.Gun;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet( urlPatterns = {"/quest/welcome"} )

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException
    {
        HttpSession session = req.getSession(true);

        Character.getInstance().setName(req.getParameter("characterName"));
        session.setAttribute("characterName", Character.getInstance().getName());
        session.setAttribute("characterHP", Character.getInstance().getHp());
        session.setAttribute("characterArmor", Character.getInstance().getArmor());
        Gun.gunsInit();
        Card.cardsInit();
        String redirectUrl = resp.encodeRedirectURL("/quest");
        resp.sendRedirect(redirectUrl);

    }
}

