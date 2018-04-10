import com.polytech.web.FeedControler;
import com.polytech.services.Story;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PublicationTest {

    @Test
    public void should_post_story(){


        //GIVEN
        String story = "hi INFO4";
        FeedControler feedControler = new FeedControler();

        //WHEN
        feedControler.post(story);

        //THEN
        List<Story> postedStories = feedControler.feed();
        Assert.assertEquals(Arrays.asList(new Story("hi info4")),postedStories);
    }
}
