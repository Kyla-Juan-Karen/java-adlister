import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    Connection connection;

    public MySQLAdsDao(Config config) {
        try{
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        String query = "SELECT * FROM ads";
        List<Ad> ads = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                ads.add(createAdFromResults(rs));
            }

            return ads;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Ad createAdFromResults(ResultSet rs){
        try{

            return new Ad(
                    rs.getLong("user_id"),
                    rs.getString("title"),
                    rs.getString("description")
            );

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Long insert(Ad ad) {
        String query = "INSERT INTO ads (user_id, title, description) VALUES (?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

                stmt.setLong(1, ad.getUserId());
                stmt.setString(2, ad.getTitle());
                stmt.setString(3, ad.getDescription());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong("id");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
