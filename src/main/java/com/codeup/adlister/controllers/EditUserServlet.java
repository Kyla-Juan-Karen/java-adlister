package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
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

        String new_password = "";
        //Checking to see if the new passwords entered match....
        if(request.getParameter("new_password").equals(request.getParameter("confirm_new_password"))){
            //...and if so, assigning the value to a variable
            new_password = request.getParameter("new_password");
        } else {
            //TODO: alert user the passwords need to match
        }

        User updated_user = null;
        //Checking to see if any of the input is null and making the new user object accordingly...
        if(new_username.isEmpty() && !new_password.isEmpty()){
            //TODO: Update Password
        } else if (new_password.isEmpty()){
            //TODO: Update username
        } else{
           //TODO: Inform the user there's no point submitting the page unless they want to change something (and redirect to the edit page)
        }

        //TODO: Redirect to UPDATED profile page!!!!!!!
    }
}
