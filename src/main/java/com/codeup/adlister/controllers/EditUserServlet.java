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

    }

//================================================
//================================================

//    DOPOST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
