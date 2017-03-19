package tutorial.core.services;

import tutorial.core.entries.BlogEntry;

/**
 * Created by Jacek on 2017-03-19.
 */
public interface BlogEntryService {
    public BlogEntry find(Long id);
}
