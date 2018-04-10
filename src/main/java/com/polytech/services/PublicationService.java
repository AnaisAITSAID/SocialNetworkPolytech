package com.polytech.services;


import com.polytech.persistance.StoryRepository;



public class PublicationService {

    private StoryRepository storyRepository= new StoryRepository();
    public void share(Story story) {

        storyRepository.save(story);
    }
}
