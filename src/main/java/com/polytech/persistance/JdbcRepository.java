package com.polytech.persistance;

import com.polytech.services.Story;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcRepository implements StoryRepository {

    private Connection connection;

    public JdbcRepository(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void save(Story story) {
        //on va utiliser un id auto incrémenté par la BD
        String query = "INSERT INTO STORY VALUES(null,'" + story.getContent() +"')";
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Story> find() {
        String query = "SELECT * FROM STORY";
        List<Story> postedStories = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while(resultSet.next()){

                String content = resultSet.getString("CONTENT");
                postedStories.add(new Story(content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postedStories;
    }
}
