package tutorial.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tutorial.core.entries.Blog;
import tutorial.rest.mvc.AccountController;
import tutorial.rest.mvc.BlogController;
import tutorial.rest.resources.BlogResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class BlogResourceAsm extends ResourceAssemblerSupport<Blog, BlogResource> {
    public BlogResourceAsm() {
        super(BlogController.class, tutorial.rest.resources.BlogResource.class);
    }

    @Override
    public tutorial.rest.resources.BlogResource toResource(Blog blog) {
        tutorial.rest.resources.BlogResource resource = new tutorial.rest.resources.BlogResource();
        resource.setTitle(blog.getTitle());
        resource.add(linkTo(BlogController.class).slash(blog.getId()).withSelfRel());
        resource.add(linkTo(BlogController.class).slash(blog.getId()).slash("entries").withRel("entries"));
        if (blog.getOwner() != null)
            resource.add(linkTo(AccountController.class).slash(blog.getOwner().getId()).withRel("owner"));
        return resource;
    }
}