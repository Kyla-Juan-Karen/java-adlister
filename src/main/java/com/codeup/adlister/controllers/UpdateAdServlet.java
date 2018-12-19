package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateAdServlet")
public class UpdateAdServlet extends HttpServlet {

        Ads dao = DaoFactory.getAdsDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong("id");
        String title = request.getParameter("title");
        String desciption = request.getParameter("description");



        request.getRequestDispatcher("/create/ads").forward(request, response);
    }
}
