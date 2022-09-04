package com.mandiri.repositories;

import com.mandiri.config.DBConnection;

import javax.xml.ws.Response;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerformerRepository {
    //Get All Performers
    public List<String> getAllPerformer() throws SQLException {
        Statement statement = DBConnection.getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM mst_actors");
        List<String> performers = new ArrayList<>();
        while (rs.next()){
            performers.add(rs.getString("name") + "      | " + rs.getString("birth_date"));
        }

        statement.close();
        DBConnection.closes();

        return performers;
    }

    //Get All Performers By Gender And Nationality
    public List<String> getAllPerformerByGenderAndNationality(String gender, String nationality) throws SQLException {
        String query = "SELECT * FROM mst_actors WHERE gender=? AND nationality=? ";
        PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, gender);
        preparedStatement.setString(2, nationality);

        ResultSet rs = preparedStatement.executeQuery();
        List<String> performers = new ArrayList<>();
        while (rs.next()){
            performers.add(rs.getString("name") + "      | " + rs.getString("birth_date"));
        };
        DBConnection.closes();
        return performers;
    }
    public void addPerformer(String name, String birthdate, String nationality, String gender) throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        String text = "INSERT INTO mst_actors(name, birth_date, nationality, gender) VALUES ('%s', '%s', '%s', '%s')";
        //statement.executeUpdate("INSERT INTO mst_actors(name, birth_date, nationality, gender");
        statement.executeUpdate(String.format(text, name, birthdate,nationality, gender));
    }
}
