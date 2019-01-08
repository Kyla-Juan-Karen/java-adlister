package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories {
    private Connection connection;

    public MySQLCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    public List<Category> allCats(){
        String query = "Select * from category";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("problem getting categories");
        }

    }


    //Getting Cats~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ (=0-0=) ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Category getCategorybyID (long Id) {
        String query = "SELECT * from category WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, Id);
            ResultSet rs = stmt.executeQuery();
            return extractCategory(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Problem getting the category");
        }
    }

    public long getIdofCategory (String category){
        String query = "SELECT * from category WHERE category = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, category);
            int Id = stmt.executeUpdate();
            return (long) Id;
        } catch (SQLException e) {
            throw new RuntimeException("Problem getting the category id");
        }
    }

    //Private Methods ====================================================================================================

    private Category extractCategory(ResultSet rs){
        try {
            return new Category (
                    rs.getLong("id"),
                    rs.getString("category")
            );
        } catch (SQLException e) {
            throw new RuntimeException("Problem within the server");
        }
    }

    private List<Category> createCategoriesFromResults(ResultSet rs){
        try {
            List<Category> cats = new ArrayList<>();
            while (rs.next()) {
                cats.add(extractCategory(rs));
            }
            return cats;
        } catch (SQLException e) {
            throw new RuntimeException("Problem within the server");
        }
    }

}
