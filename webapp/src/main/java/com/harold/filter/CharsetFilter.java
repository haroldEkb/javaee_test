package com.harold.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class CharsetFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setCharacterEncoding("UTF-8");
        String path = "http://localhost:8080" + servletRequest.getServletContext().getContextPath()+"/";
        servletResponse.getWriter().println("<html><body><ul>\n" +
                "   <li>\n" +
                "       <a href=\"" + path + "main\">Main</a>\n" +
                "   </li>\n" +
                "   <li>\n" +
                "       <a href=\"" + path + "catalog\">Catalog</a>\n" +
                "   </li>\n" +
                "   <li>\n" +
                "       <a href=\"" + path + "product\">Product</a>\n" +
                "   </li>\n" +
                "   <li>\n" +
                "       <a href=\"" + path + "order\">Order</a>\n" +
                "   </li>\n" +
                "   <li>\n" +
                "       <a href=\"" + path + "cart\">Cart</a>\n" +
                "   </li>\n" +
                "</ul>");
        filterChain.doFilter(servletRequest,servletResponse);
        servletResponse.getWriter().println("</body></html>");
    }

    @Override
    public void destroy() {

    }
}
