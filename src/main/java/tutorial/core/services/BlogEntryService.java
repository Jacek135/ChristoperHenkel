package tutorial.core.services;

import tutorial.core.entries.BlogEntry;

/**
 * Created by Jacek on 2017-03-19.
 */
public interface BlogEntryService {
    public BlogEntry findBlogEntry(Long id);

    public BlogEntry deleteBlogEntry(Long id);

    /**
     * @param id   the id of the BlogEntry to updateBlogEntry
     * @param data the BlogEntry containing the data to be used for the....
     * @return the updated BlogEntry or null if the BlogEntry with the
     */
    public BlogEntry updateBlogEntry(Long id, BlogEntry data);
}