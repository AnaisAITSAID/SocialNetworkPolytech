package com.polytech.services;

import com.polytech.persistance.StoryRepository;

import java.util.ArrayList;
import java.util.List;

public class FeedService {


    StoryRepository storyRepository;

    public FeedService(StoryRepository storyRepository){
        this.storyRepository = storyRepository;
    }
    public List<Story> findAll() {
        return storyRepository.find();

    }
}
