package tutorial.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tutorial.core.services.util.BlogEntryList;
import tutorial.rest.mvc.BlogController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


public class BlogEntryListResourceAsm extends ResourceAssemblerSupport<BlogEntryList, tutorial.rest.resources.BlogEntryListResource> {
    public BlogEntryListResourceAsm() {
        super(BlogController.class, tutorial.rest.resources.BlogEntryListResource.class);
    }

    @Override
    public tutorial.rest.resources.BlogEntryListResource toResource(BlogEntryList list) {
        List<tutorial.rest.resources.BlogEntryResource> resources = new tutorial.rest.resources.asm.BlogEntryResourceAsm().toResources(list.getEntries());
        tutorial.rest.resources.BlogEntryListResource listResource = new tutorial.rest.resources.BlogEntryListResource();
        listResource.setEntries(resources);
        listResource.add(linkTo(methodOn(BlogController.class).findAllBlogEntries(list.getBlogId())).withSelfRel());
        return listResource;
    }
}