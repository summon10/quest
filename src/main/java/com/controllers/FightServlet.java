package com.controllers;

import com.services.Fight;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet( urlPatterns = {"/quest/fight"} )
public class FightServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        Integer gun = Integer.valueOf(req.getParameter("Answer"));

        Integer characterHP = (Integer) session.getAttribute("characterHP");

        characterHP = Fight.fightExecutor(gun,characterHP);
        if (characterHP== -1)
        {
            String redirectUrl = resp.encodeRedirectURL("/quest/youdied.jsp");
            resp.sendRedirect(redirectUrl);
        }
        else
        {
            session.setAttribute("characterHP", characterHP);
            String redirectUrl = resp.encodeRedirectURL("/quest");
            resp.sendRedirect(redirectUrl);
        }


    }
}
