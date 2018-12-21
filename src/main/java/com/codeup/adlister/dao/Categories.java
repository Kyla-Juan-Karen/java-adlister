package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {

    Category getCategorybyID (long Id);
    long getIdofCategory (String category);
    List<Category> allCats();

}
