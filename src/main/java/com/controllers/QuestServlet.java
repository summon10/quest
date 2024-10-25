package com.controllers;

import com.entity.Quest;
import com.services.QuestProcessor;
import com.services.Serializer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet( urlPatterns = {"/quest"} )

public class QuestServlet extends HttpServlet {


    boolean firstQuestion;

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        Quest.getInstance();
        HttpSession session = req.getSession(true);
        Serializer ser = new Serializer();
        ser.Deserilization();

        if (firstQuestion)
        {
            session.setAttribute("question", Quest.getInstance().questions.get(0));
            QuestProcessor.answersCompletion(session);
            firstQuestion=false;
            String redirectUrl = resp.encodeRedirectURL("/quest/quest_fight.jsp");
            resp.sendRedirect(redirectUrl);

        }
        else QuestProcessor.QuestAnswersGetter(session, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getParameter("Answer"));

        String redirectUrl = resp.encodeRedirectURL("/quest");
          resp.sendRedirect(redirectUrl);



    }



}

