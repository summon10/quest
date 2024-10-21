package com.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter",
        urlPatterns = {"/quest/*"})

public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String path = req.getRequestURI();
        if (path.startsWith("/choosingQuest")) filterChain.doFilter(servletRequest, servletResponse);

        if (session.getAttribute("Authorized") == (Boolean) true)
                filterChain.doFilter(servletRequest, servletResponse);
        else {
                String redirectUrl = resp.encodeRedirectURL("/notauthorized.jsp");
                resp.sendRedirect(redirectUrl);
            }

    }
}
