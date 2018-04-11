package com.polytech.config;

import com.polytech.persistance.InMemoryRepository;
import com.polytech.persistance.JdbcRepository;
import com.polytech.persistance.StoryRepository;
import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.web.FeedControler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.SQLException;

@Configuration
public class AppConfig {

    @Bean
    public StoryRepository storyRepository(DataSource dataSource) throws SQLException {
        return new JdbcRepository(dataSource.getConnection());
    }

    @Bean
    public FeedService feedService(StoryRepository storyRepository){
        return new FeedService(storyRepository);
    }

    @Bean
    public PublicationService publicationService(StoryRepository storyRepository){
        return new PublicationService(storyRepository);
    }

    @Bean
    public FeedControler feedControler(PublicationService publicationService, FeedService feedService){
        return new FeedControler(publicationService,feedService);
    }

    @Bean
    public JdbcRepository jdbcRepository(DataSource dataSource) throws SQLException {
        return new JdbcRepository(dataSource.getConnection());
    }

    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
               //.addScripts("schema.sql")
                .build();
    }



}
