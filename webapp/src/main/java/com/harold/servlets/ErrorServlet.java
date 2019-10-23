package com.harold.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/error")
public class ErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        Integer code = (Integer) req.getAttribute(
                "javax.servlet.error.status_code");
        writer.printf("status_code: %s%n", code);

        String errorMessage = (String) req.getAttribute(
                "javax.servlet.error.message");
        writer.printf("message: %s%n", errorMessage);
    }
}
