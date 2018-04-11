package com.polytech.web;

import com.polytech.persistance.InMemoryRepository;
import com.polytech.persistance.StoryRepository;
import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.services.Story;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class FeedControler {

    PublicationService publicationService;
    FeedService feedService;

    public FeedControler(PublicationService publicationService, FeedService feedService){
        this.publicationService = publicationService;
        this.feedService = feedService;
    }
    @RequestMapping(value="/share", method=RequestMethod.POST)
    public String post(String content) {
        publicationService.share(new Story(content));
        return  "redirect:/feed";
    }

    @RequestMapping(value="/feed",method = RequestMethod.GET)
    public String feed(Model model) {
        List<Story> postedStories = feedService.findAll();
        model.addAttribute("postedStories",postedStories);
        return "feed";
    }
}
