package com.iie.lkserverlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init Hello.......");
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        ServletContext sc = config.getServletContext();
        System.out.println("You get me!");
        System.out.println(sc.getInitParameter("driver"));
        System.out.println(config.getInitParameter("user"));
        System.out.println(config.getInitParameter("password"));
        System.out.println(sc.getInitParameter("jdbc-url"));
        System.out.println(sc.getRealPath("/index.jsp"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/msword");
        response.sendRedirect("hospital.doc");
    }

    @Override
    public void destroy() {
        System.out.println("I am destroying ...");
        super.destroy();
    }
}
