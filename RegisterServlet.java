package net.javaguides.register.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.register.service.RegisterService;
import net.javaguides.model.User;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = new User(username , password);
        boolean result;
       

        try {
        	if(user.getPassword()!="") {
        		RegisterService registerService = new RegisterService();
        		result = registerService.register(user);
        	}
        	else {
        		result=false;
        	}
		   		 if(result==true){
		   			response.sendRedirect("registersuccess.jsp");
				 }
		   		 else{
					 response.sendRedirect("registerfail.jsp");
				 }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}