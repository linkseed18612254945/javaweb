package com.iie.lkserverlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求来了");
        PrintWriter out = response.getWriter();
        out.println(request.getRequestURI());
        out.println(request.getMethod());
        out.println("User: " + request.getParameter("user"));
        out.println("Password: " + request.getParameter("password"));
        out.println("Interest: ");
        for (String interest: request.getParameterValues("interest")){
            out.print(interest + " ");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Get 来了");
        PrintWriter out = response.getWriter();
        Map<String, String[]> requestParameterMap = request.getParameterMap();
        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()){
            System.out.println(names.nextElement());
        }
        System.out.println(names);
        for (Map.Entry<String, String[]> parameter: requestParameterMap.entrySet()){
            out.println(parameter.getKey() + " : " + Arrays.toString(parameter.getValue()));
        }
    }
}
