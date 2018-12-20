package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    List<Ad> search(String search);
//    DELETE AD
    void deleteAd (Ad ad);
//    UPDATE AD
    void editAd (Ad ad);
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    List<Ad> findAdsByUserId(User user);
    Ad findAdsByTitle(String title);
}
