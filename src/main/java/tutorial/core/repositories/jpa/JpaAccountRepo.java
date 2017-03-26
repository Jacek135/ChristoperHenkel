package tutorial.core.repositories.jpa;

import org.springframework.stereotype.Repository;
import tutorial.core.entries.Account;
import tutorial.core.entries.Blog;
import tutorial.core.repositories.AccountRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaAccountRepo implements AccountRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Account findAccount(Long id) {
        return em.find(Account.class, id);
    }

    @Override
    public Account createAccount(Account data) {
        em.persist(data);
        return data;
    }

    @Override
    public Blog createBlog(Long accountId, Blog data) {
        return null;
    }
}