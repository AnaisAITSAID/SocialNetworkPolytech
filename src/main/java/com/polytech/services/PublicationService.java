package com.polytech.services;


import com.polytech.persistance.StoryRepository;


public class PublicationService {

    private StoryRepository storyRepository;

    public PublicationService (StoryRepository storyRepository){
        this.storyRepository = storyRepository;
    }
    public void share(Story story) {

        storyRepository.save(story);
    }
}
