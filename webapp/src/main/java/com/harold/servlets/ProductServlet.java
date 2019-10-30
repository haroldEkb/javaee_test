package com.harold.servlets;

import com.harold.persist.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(CatalogServlet.class);

    @Inject
    private ProductRepository repository;


//    @Override
//    public void init() throws ServletException {
//        this.repository = (ProductRepository) getServletContext().getAttribute(PROD_REPO);
//
//        if (this.repository == null) {
//            throw new ServletException("ProductRepository is not initialized");
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            req.setAttribute("product", repository.findById(id));
        } catch (Exception e) {
            logger.error("", e);
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/templates/product.jsp").forward(req, resp);
    }
}
