package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.sql.*;

public class MySQLCategoriesDao implements Categories {
    private Connection connection;

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

    private Category extractCategory(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new Category (
                rs.getLong("id"),
                rs.getString("category")
        );
    }
}
