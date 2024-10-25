package com.services;

import com.entity.Quest;
import com.utils.getRandomNumberFromInterval;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class QuestProcessor {
    static String redirectUrl;
    static int QuestionNumber = 0;
    static String doorColor;
    public static void QuestAnswersGetter(HttpSession session, HttpServletResponse resp) throws IOException {
        {
            QuestionNumber = getRandomNumberFromInterval.GetRandomNumber(Quest.getInstance().questions.size());
            session.setAttribute("question", Quest.getInstance().questions.get(QuestionNumber));
            answersCompletion(session);
            switch (QuestionNumber) {
                case 0: {
                    redirectUrl = resp.encodeRedirectURL("/quest/quest_fight.jsp");
                    answersCompletion(session);
                    resp.sendRedirect(redirectUrl);
                    break;
                }
                case 1: {
                    redirectUrl = resp.encodeRedirectURL("/quest/quest_1answer.jsp");
                    answersCompletion(session);
                    Integer characterHP = (Integer) session.getAttribute("characterHP");
                    characterHP = characterHP + 10;
                    session.setAttribute("characterHP", characterHP);
                    resp.sendRedirect(redirectUrl);
                    break;
                }
                case 2: {
                    redirectUrl = resp.encodeRedirectURL("/quest/quest_1answer.jsp");
                    answersCompletion(session);
                    session.setAttribute("characterArmor", 100);
                    resp.sendRedirect(redirectUrl);
                    break;
                }
                case 3, 4, 5: {
                    redirectUrl = resp.encodeRedirectURL("/quest/quest_2answer.jsp");
                    answersCompletion(session);
                    doorColor = ColorExecutor.ColorGetter(QuestionNumber);
                    if (session.getAttribute(doorColor) == null) session.setAttribute("alert", 1);
                    resp.sendRedirect(redirectUrl);
                    break;
                }
                case 6, 7, 8: {
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

     public static void answersCompletion (HttpSession session) throws IOException {
            for (int i = 0; i < Quest.getInstance().answers.get(QuestionNumber).length; i++) {
                session.setAttribute("answer" + i, Quest.getInstance().answers.get(QuestionNumber)[i]);
            }
        }
    }


