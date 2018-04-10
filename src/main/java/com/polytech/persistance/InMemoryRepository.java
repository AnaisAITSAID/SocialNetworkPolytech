package com.polytech.persistance;

import com.polytech.services.Story;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository implements StoryRepository{

    private static List<Story> postedStories = new ArrayList<Story>();
    @Override
    public void save(Story story) {
        postedStories.add(story);
    }

    @Override
    public List<Story> find() {
        return postedStories;
    }
}
