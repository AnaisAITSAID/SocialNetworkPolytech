package com.polytech.web;

import com.polytech.persistance.InMemoryRepository;
import com.polytech.persistance.StoryRepository;
import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.services.Story;

import java.util.List;

public class FeedControler {

    PublicationService publicationService;
    FeedService feedService;

    public FeedControler(PublicationService publicationService, FeedService feedService){
        this.publicationService = publicationService;
        this.feedService = feedService;
    }
    public void post(String story) {
        publicationService.share(new Story(story));

    }

    public List<Story> feed() {
        return feedService.findAll();
    }
}
