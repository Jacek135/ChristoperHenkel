package tutorial.rest.resources.asm;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tutorial.core.entries.BlogEntry;
import tutorial.rest.mvc.BlogController;
import tutorial.rest.mvc.BlogEntryController;
import tutorial.rest.resources.BlogEntryResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class BlogEntryResourceAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {

    public BlogEntryResourceAsm()
    {
        super(BlogEntryController.class, tutorial.rest.resources.BlogEntryResource.class);
    }

    @Override
    public tutorial.rest.resources.BlogEntryResource toResource(BlogEntry blogEntry) {
        tutorial.rest.resources.BlogEntryResource res = new tutorial.rest.resources.BlogEntryResource();
        res.setTitle(blogEntry.getTitle());
        Link self = linkTo(BlogEntryController.class).slash(blogEntry.getId()).withSelfRel();
        res.add(self);
        if(blogEntry.getBlog() != null)
        {
            res.add((linkTo(BlogController.class).slash(blogEntry.getBlog().getId()).withRel("blog")));
        }
        return res;
    }
}