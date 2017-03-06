package ev.koslov.db.dao_impl;

import ev.koslov.db.AccountDAO;
import ev.koslov.db.entity.Account;
import ev.koslov.db.repository.AccountJpaRepository;

import javax.annotation.Resource;

/**
 * Account DAO implementation for Jpa database
 */
public class JpaAccountDAO implements AccountDAO {

    @Resource
    private AccountJpaRepository accountJpaRepository;


    public boolean exists(String login) {
        return accountJpaRepository.exists(login);
    }

    public Account create(Account account) {
        return accountJpaRepository.saveAndFlush(account);
    }

    public Account read(String login) {
        return accountJpaRepository.findOne(login);
    }

    @Override
    public Account update(Account account) {
        return accountJpaRepository.exists(account.getLogin())
                ? accountJpaRepository.saveAndFlush(account)
                : null;
    }

    @Override
    public void delete(String login) {
        accountJpaRepository.delete(login);
    }
}
