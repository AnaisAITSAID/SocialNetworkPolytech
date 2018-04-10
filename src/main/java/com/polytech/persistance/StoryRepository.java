package com.polytech.persistance;

import com.polytech.services.Story;

import java.util.ArrayList;
import java.util.List;

public class StoryRepository {

    public static List<Story> postedStories = new ArrayList<Story>();
    public void save(Story story) {
        postedStories.add(story);
    }

    public List<Story> find() {
        return postedStories;
    }
}
