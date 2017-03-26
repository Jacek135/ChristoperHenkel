package tutorial.core.repositories.jpa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tutorial.core.entries.Account;
import tutorial.core.repositories.AccountRepo;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class AccountRepoTest {

    @Autowired
    private AccountRepo repo;
    private Account account;
    @Before
    @Transactional
    @Rollback(false)
    public void setup(){
        account = new Account();
        account.setName("name");
        account.setPassword("password");
        repo.createAccount(account);
    }

    @Test
    @Transactional
    public void test(){
        assertNotNull(repo.findAccount(account.getId()));



    }
}