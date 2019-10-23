package com.harold.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/first/httpServlet")
public class FirstHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Hello from First Http Servlet</h1>");
        resp.getWriter().println("<h2>URL Parameters</h2>");
        for (Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
            resp.getWriter().printf("<p>%s = %s</p>", entry.getKey(), String.join(" ,", entry.getValue()));
        }
    }
}
