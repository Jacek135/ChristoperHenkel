package tutorial.rest.resource;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Jacek on 2017-03-19.
 */
public class BlogEntryResource extends ResourceSupport{

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
