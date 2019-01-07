package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAdsServlet", urlPatterns ="/delete")
public class DeleteAdsServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        FIRST ATTEMPT
//        String delete = request.getParameter("delete");
//        request.setAttribute("ads", DaoFactory.getAdsDao().delete(delete));
//        request.getRequestDispatcher("/WEB-INF/ads/delete.jsp").forward(request,response);

        String title = request.getParameter("delete_this_ad");
        Ad this_ad = DaoFactory.getAdsDao().findAdsByTitle(title);
        DaoFactory.getAdsDao().deleteAd(this_ad);
        response.sendRedirect("/profile");
    }
}

