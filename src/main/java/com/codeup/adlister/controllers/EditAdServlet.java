package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateAdServlet", urlPatterns = "/edit")
public class EditAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ad edit_ad = (Ad) request.getSession().getAttribute("this_ad");
        request.setAttribute("edit_ad", edit_ad);
        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ad edit_ad = (Ad) request.getSession().getAttribute("this_ad");

        User user = DaoFactory.getUsersDao().findById((int) edit_ad.getUserId());

        //For the updated ad
        long ad_id = edit_ad.getId();
        long user_id = user.getId();
        String newTitle = request.getParameter("new_title");
        String newDesc = request.getParameter("new_description");


        //Making new Ad
        Ad updated_ad  = new Ad(
                ad_id,
                user_id,
                newTitle,
                newDesc
        );

        //pass the ad into the edit method
        DaoFactory.getAdsDao().editAd(updated_ad);

        //redirect to profile
        response.sendRedirect("/profile");
    }
}
