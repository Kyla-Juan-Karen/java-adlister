package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import com.mysql.cj.jdbc.Driver;
import com.codeup.adlister.Config;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;
    private Password passObj;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


//  Updating Table Methods=====================================================================================================================
    @Override
    public void updatePassword(String password, User user){
        String query = "UPDATE users SET password = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            password = passObj.hash(password);
            stmt.setString(1, password);
            stmt.setLong(2, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUsername (String username, User user){
        String query = "UPDATE users SET username = ? WHERE id = ?";
        update(query, username, user);

    }

    @Override
    public void updateEmail (String email, User user){
        String query = "UPDATE users SET email = ? WHERE id = ?";
        update(query, email, user);
    }

    private void update(String query, String info_to_update, User user){
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, info_to_update);
            stmt.setLong(2, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//=====================================================================================================================

    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }

}
