package ev.koslov.db;


import ev.koslov.db.entity.Account;

/**
 * Interface represent account dao
 */
public interface AccountDAO {
    boolean exists(String login);
    Account create(Account account);
    Account read(String login);
    Account update(Account account);
    void delete(String login);
}
