package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAdsServlet")
public class DeleteAdsServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String delete = request.getParameter("delete");
        request.setAttribute("ads", DaoFactory.getAdsDao().delete(delete));
        request.getRequestDispatcher("/WEB-INF/ads/delete.jsp").forward(request,response);








        //        Ad ad = new Ad();
//        ((MySQLAdsDao)DaoFactory.getAdsDao()).deleteAd();
//        response.sendRedirect("/ads");
    }
}