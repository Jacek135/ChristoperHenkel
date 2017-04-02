package tutorial.core.services;

import tutorial.core.entries.Blog;
import tutorial.core.entries.BlogEntry;
import tutorial.core.services.util.BlogEntryList;
import tutorial.core.services.util.BlogList;

public interface BlogService {

    /**
     * @param blogId the id of the blog to add this BlogEntry to
     * @param data   the BlogEntry containing the data to be used for ...
     * @return the created BlogEntry with a generated ID
     * @throws tutorial.core.services.exceptions.BlogNotFoundException
     */

    public BlogEntry createBlogEntry(Long blogId, BlogEntry data);

    public BlogList findAllBlogs();

    public BlogEntryList findAllBlogEntries(Long blogId);

    public Blog findBlog(Long id);

}