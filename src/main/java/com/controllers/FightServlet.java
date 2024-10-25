package com.controllers;

import com.entity.Monster;
import com.services.Fight;
import com.utils.getRandomNumberFromInterval;
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
        Integer characterArmor = (Integer) session.getAttribute("characterArmor");

        Monster monst = new Monster(getRandomNumberFromInterval.GetRandomNumber(140), getRandomNumberFromInterval.GetRandomNumber(90));

        characterHP = Fight.fightExecutor(gun,characterHP, monst);
        characterArmor = characterArmor - 50;
        session.setAttribute("characterArmor", characterArmor);
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
