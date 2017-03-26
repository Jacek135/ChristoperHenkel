package tutorial.core.repositories;


import tutorial.core.entries.Account;
import tutorial.core.entries.Blog;

public interface AccountRepo {
    Account findAccount(Long id);
    Account createAccount(Account data);
    Blog createBlog(Long accountId, Blog data);

}
