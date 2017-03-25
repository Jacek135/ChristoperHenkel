package tutorial.core.services;

import tutorial.core.entries.Account;
import tutorial.core.entries.Blog;

public interface AccountService {

    Account findAccount(Long id);
    Account createAccount(Account data);
    Blog createBlog(Long accountId, Blog data);
}