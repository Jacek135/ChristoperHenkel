package tutorial.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

public class BlogListResource extends ResourceSupport {
    private List<tutorial.rest.resources.BlogResource> blogs = new ArrayList<tutorial.rest.resources.BlogResource>();

    public List<tutorial.rest.resources.BlogResource> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<tutorial.rest.resources.BlogResource> blogs) {
        this.blogs = blogs;
    }
}