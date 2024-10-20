package com.controllers;

import com.entity.Quest;
import com.services.ColorExecutor;
import com.utils.getRandomNumberFromInterval;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet( urlPatterns = {"/quest"} )

public class QuestServlet extends HttpServlet {
    int QuestionNumber=0;
    String redirectUrl;
    boolean firstQuestion;
    String doorColor;
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        Quest.getInstance();
        HttpSession session = req.getSession(true);

        if (firstQuestion)
        {
            session.setAttribute("question", Quest.getInstance().questions.get(0));
            answersCompletion(session);
            firstQuestion=false;
            String redirectUrl = resp.encodeRedirectURL("/quest/quest_fight.jsp");
            resp.sendRedirect(redirectUrl);

        }
        else {
            QuestionNumber = getRandomNumberFromInterval.GetRandomNumber(Quest.questions.size());
            session.setAttribute("question", Quest.getInstance().questions.get(QuestionNumber));
            answersCompletion(session);
            switch (QuestionNumber)
            {
                case 0:
                {
                    redirectUrl = resp.encodeRedirectURL("/quest/quest_fight.jsp");
                    answersCompletion(session);
                    resp.sendRedirect(redirectUrl);
                    break;
                }
                case 1:
                {
                    redirectUrl = resp.encodeRedirectURL("/quest/quest_1answer.jsp");
                    answersCompletion(session);
                    Integer characterHP = (Integer) session.getAttribute("characterHP");
                    characterHP = characterHP + 10;
                    session.setAttribute("characterHP", characterHP);
                    resp.sendRedirect(redirectUrl);
                    break;
                }
                case 2:
                {
                    redirectUrl = resp.encodeRedirectURL("/quest/quest_1answer.jsp");
                    answersCompletion(session);
                    resp.sendRedirect(redirectUrl);
                    break;
                }
                case 3,4,5:
                {
                    redirectUrl = resp.encodeRedirectURL("/quest/quest_2answer.jsp");
                    answersCompletion(session);
                    doorColor = ColorExecutor.ColorGetter(QuestionNumber);
                    if (session.getAttribute(doorColor) == null) session.setAttribute("alert", 1);
                    resp.sendRedirect(redirectUrl);
                    break;
                }
                case 6,7,8:
                {
                    redirectUrl = resp.encodeRedirectURL("/quest/quest_1answer.jsp");
                    String color = ColorExecutor.ColorGetter(QuestionNumber);

                    session.setAttribute(color, true);
                    answersCompletion(session);
                    resp.sendRedirect(redirectUrl);
                    break;
                }
            }

      }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getParameter("Answer"));

        String redirectUrl = resp.encodeRedirectURL("/quest");
          resp.sendRedirect(redirectUrl);



    }

    void answersCompletion(HttpSession session)
        {
            for (int i = 0; i < Quest.answers.get(QuestionNumber).length ; i++) {
                session.setAttribute("answer"+i, Quest.answers.get(QuestionNumber)[i]);
            }
        }

}

