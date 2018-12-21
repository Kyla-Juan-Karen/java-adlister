package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateAdServlet", urlPatterns = "/edit")
public class EditAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("edit_this_ad");
        Ad this_ad = DaoFactory.getAdsDao().findAdsByTitle(title);
//        DaoFactory.getAdsDao().editAd(this_ad); //TODO: put this in post);
        request.getSession().setAttribute("ad", this_ad);
        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String title = request.getParameter("edit_this_ad");
//        Ad this_ad = DaoFactory.getAdsDao().findAdsByTitle(title);
//        DaoFactory.getAdsDao().editAd(this_ad);
//        response.sendRedirect("/edit");
    }
}
