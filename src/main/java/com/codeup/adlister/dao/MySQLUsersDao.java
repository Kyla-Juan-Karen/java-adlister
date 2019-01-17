package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import com.mysql.cj.jdbc.Driver;
import com.codeup.adlister.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<User> allUsers (){
        List<User> users = new ArrayList<>();
        String query = "Select * from users";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getBoolean("isAdmin")
                );
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }


//  Updating Table Methods=====================================================================================================================
    @Override
    public User updatePassword(String password, User user){
        String query = "UPDATE users SET password = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            password = passObj.hash(password);
            stmt.setString(1, password);
            stmt.setLong(2, user.getId());
            int user_id = stmt.executeUpdate();
            return findById(user_id);

        } catch (SQLException e) {
           throw new RuntimeException("Issue updating password");
        }
    }

    @Override
    public User updateUsername (String username, User user){
        String query = "UPDATE users SET username = ? WHERE id = ?";
        return update(query, username, user);

    }

    @Override
    public User updateEmail (String email, User user) {
        String query = "UPDATE users SET email = ? WHERE id = ?";
        return update(query, email, user);
    }

    private User update(String query, String info_to_update, User user){
        try {
            PreparedStatement stmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, info_to_update);
            stmt.setLong(2, user.getId());
            stmt.executeUpdate();
           return findById((int) user.getId());

        } catch (SQLException e) {
           throw new RuntimeException("Issue updating user information.");
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

    public User findById(int Id){
        String query = "Select * from users where id = ? Limit 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, Id);
            ResultSet rs = stmt.executeQuery();
            return extractUser(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Problem identifying the user");
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password, isAdmin) VALUES (?, ?, ?, false )";
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
            rs.getString("password"),
            rs.getBoolean("isAdmin")
        );
    }

}
