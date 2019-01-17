package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "AdPageServlet", urlPatterns = "/ad/page")
public class AdPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title_of_ad");
        Ad this_ad = DaoFactory.getAdsDao().findAdsByTitle(title);
        User user = DaoFactory.getUsersDao().findById((int) this_ad.getUserId());
        User currentUser = (User) request.getSession().getAttribute("user");
        if(this_ad.getUserId() == currentUser.getId()){
            request.getSession().setAttribute("sameUser", true);
        } else {
            request.getSession().setAttribute("sameUser", false);
        }
        request.setAttribute("ads_user", user);
        request.getSession().setAttribute("this_ad", this_ad);
        request.getRequestDispatcher("/WEB-INF/ads/ad_page.jsp").forward(request, response);

    }

}
