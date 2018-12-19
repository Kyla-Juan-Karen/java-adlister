package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().getAttribute("sticky1");
        request.getSession().getAttribute("sticky2");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
            user.getId(),
            request.getParameter("title"),
            request.getParameter("description")
        );

        if (!ad.getTitle().isEmpty() && !ad.getDescription().isEmpty()) {
            DaoFactory.getAdsDao().insert(ad);
            response.sendRedirect("/ads");
        } else {
            //Redirect to create ad and Alert user they can't have an empty ad
            request.getSession().setAttribute("failedAd", true);
            String first = request.getParameter("title");
            request.getSession().setAttribute("sticky1", first);
            String second = request.getParameter("description");
            request.getSession().setAttribute("sticky2", second);
            response.sendRedirect("/ads/create");
            //trying to have input stays there after resubmit//
        }
    }
}
