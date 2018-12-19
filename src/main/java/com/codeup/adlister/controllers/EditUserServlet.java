package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditUserServlet", urlPatterns = "/profile/edit")
public class EditUserServlet extends HttpServlet {
//    DOGET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/edit_user.jsp").forward(request, response);
    }

//================================================
//================================================

//    DOPOST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Grabbing params from form
        String new_username = request.getParameter("new_username");
        //Getting current user from session
        User currentUser = (User) request.getSession().getAttribute("user");


        String new_password = "";
        //Checking to see if the new passwords entered match....
        if(request.getParameter("new_password").equals(request.getParameter("confirm_new_password"))){
            //...and if so, assigning the value to a variable
            new_password = request.getParameter("new_password");
            request.getSession().setAttribute("passwords_match", true);
        } else {
            request.getSession().setAttribute("passwords_match", false);
        }

        User updated_user = null;
        //Checking to see if any of the input is null and making the new user object accordingly...
        if(new_password.isEmpty() && new_username.isEmpty()){
            request.getSession().setAttribute("empty", true);
        } else if(new_username.isEmpty()){
            DaoFactory.getUsersDao().updatePassword(new_password, currentUser);
            response.sendRedirect("/profile");
        } else if (new_password.isEmpty()){
            DaoFactory.getUsersDao().updateUsername(new_username, currentUser);
            response.sendRedirect("/profile");
        } else {
            DaoFactory.getUsersDao().updatePassword(new_password, currentUser);
            DaoFactory.getUsersDao().updateUsername(new_username, currentUser);
            response.sendRedirect("/profile");
        }
    }
}
