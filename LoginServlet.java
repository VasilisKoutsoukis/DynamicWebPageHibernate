package net.javaguides.login.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.login.service.LoginService;
import net.javaguides.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginService loginService = new LoginService();
        boolean result = loginService.authenticateUser(username, password);
        
        User user = loginService.getUserByUsername(username);
        
        
        if(result == true){
	   		 request.getSession().setAttribute("user", user);		
	   		 response.sendRedirect("loginsuccess.jsp");
	   	 }
	   	 else{
	   		 response.sendRedirect("loginfail.jsp");
	   	 }
    }
}