package com.harold.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = {"", "/"})
public class MainServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(MainServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("PathInfo: {}", req.getPathInfo());
        logger.info("ServletPath: {}", req.getServletPath());
        logger.info("ResourceURL: {}", getServletContext().getResource("/WEB-INF/templates/index.jsp"));

        getServletContext().getRequestDispatcher("/WEB-INF/templates/index.jsp").forward(req, resp);

    }
}
