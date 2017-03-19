package tutorial.rest.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tutorial.core.entries.BlogEntry;
import tutorial.core.services.BlogEntryService;
import tutorial.rest.resource.BlogEntryResource;
import tutorial.rest.resource.asm.BlogEntryResourceAsm;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("rest/blog-entries")
public class BlogEntryController {

    private BlogEntryService service;

    public BlogEntryController(BlogEntryService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{blogEntryId}", method = GET)
    public ResponseEntity<BlogEntryResource> getBlogEntry(@PathVariable Long blogEntryId) {
        BlogEntry entry = service.find(blogEntryId);
        if (entry != null) {
            BlogEntryResource res = new BlogEntryResourceAsm().toResource(entry);
            return new ResponseEntity<BlogEntryResource>(res, OK);
        } else {
            return new ResponseEntity<BlogEntryResource>(NOT_FOUND);
        }


    /*@RequestMapping(value = "/test", method= RequestMethod.POST)
    public @ResponseBody BlogEntry test(@RequestBody BlogEntry entry){

        return entry;
    }*/

    /*@RequestMapping("/test")
    public @ResponseBody BlogEntry test(){
        BlogEntry entry = new BlogEntry();
        entry.setTitle("Test Blog Entry");
        return entry;
    }*/


    /*@RequestMapping("/test")
    public ResponseEntity<Object> test(){
        BlogEntry entry = new BlogEntry();
        entry.setTitle("Test Blog Entry");
        return new ResponseEntity<Object>(entry, HttpStatus.OK);
    }*/

    }
}
