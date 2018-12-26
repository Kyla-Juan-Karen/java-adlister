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
        String new_email = request.getParameter("new_email");
        //Getting current user from session
        User currentUser = (User) request.getSession().getAttribute("user");


        String new_password = "";
        //Checking to see if the new passwords entered match....
        if(request.getParameter("new_password").equals(request.getParameter("confirm_new_password"))){
            //...and if so, assigning the value to a variable
            new_password = request.getParameter("new_password");
        }

        //Format: If NotEmpty, do the thing with the update and whatnot
        if (!new_username.isEmpty()){
            currentUser = DaoFactory.getUsersDao().updateUsername(new_username, currentUser);
        }
        if (!new_password.isEmpty()){
            currentUser = DaoFactory.getUsersDao().updatePassword(new_password, currentUser);
        }
        if (!new_email.isEmpty()){
            currentUser = DaoFactory.getUsersDao().updateEmail(new_email, currentUser);
        }
        if (new_email.isEmpty() && new_password.isEmpty() && new_username.isEmpty()){
            response.sendRedirect("/profile/edit");
        } else {
            request.getSession().setAttribute("user", currentUser);
            response.sendRedirect("/profile");
        }
    }
}
