package com.controllers;

import com.utils.authCheck;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet( urlPatterns = {"/choosingQuest"} )
public class chooseQuestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String username = req.getParameter("username");
        String password = req.getParameter("password");
        authCheck auth = new authCheck(username,password);
        if (auth.resultOfAuth())
        {
            HttpSession session = req.getSession();
            session.setAttribute("Authorized", true);
            String redirectUrl = resp.encodeRedirectURL("/choosingQuest.jsp");
            resp.sendRedirect(redirectUrl);



        }
        else
        {
            String redirectUrl = resp.encodeRedirectURL("notauthorized.jsp");
            resp.sendRedirect(redirectUrl);
        }

    }
}

