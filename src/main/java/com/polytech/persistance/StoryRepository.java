package com.polytech.persistance;

import com.polytech.services.Story;

import java.util.ArrayList;
import java.util.List;

public interface StoryRepository {


    void save(Story story);

    List<Story> find();
}
