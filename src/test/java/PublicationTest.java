import com.polytech.persistance.InMemoryRepository;
import com.polytech.persistance.StoryRepository;
import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.web.FeedControler;
import com.polytech.services.Story;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PublicationTest {

    private FeedControler feedControler;

    @Before
    public void setUp(){
        StoryRepository storyRepository = new InMemoryRepository() ;
        PublicationService publicationService = new PublicationService(storyRepository);
        FeedService feedService = new FeedService(storyRepository);
        feedControler = new FeedControler(publicationService,feedService);
    }
    @Test
    public void should_post_story(){


        //GIVEN
        String story = "hi INFO4";


        //WHEN
        feedControler.post(story);

        //THEN
        List<Story> postedStories = feedControler.feed();
        Assert.assertEquals(Arrays.asList(new Story("hi INFO4")),postedStories);
    }
}
