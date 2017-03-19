package tutorial.rest.resource.asm;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tutorial.core.entries.BlogEntry;
import tutorial.rest.mvc.BlogEntryController;
import tutorial.rest.resource.BlogEntryResource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by Jacek on 2017-03-19.
 */
public class BlogEntryResourceAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {
    public BlogEntryResourceAsm() {
        super(BlogEntryController.class, BlogEntryResource.class);
    }

    @Override
    public BlogEntryResource toResource(BlogEntry blogEntry) {
        BlogEntryResource res = new BlogEntryResource();
        res.setTitle(blogEntry.getTitle());
//        Link link = linkTo(methodOn(BlogEntryController.class).getBlogEntry(blogEntry.getId())).withSelfRel();
        Link link = linkTo(BlogEntryController.class).slash(blogEntry.getId()).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}
