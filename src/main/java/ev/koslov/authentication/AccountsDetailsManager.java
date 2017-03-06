package ev.koslov.authentication;

import ev.koslov.db.entity.Account;
import ev.koslov.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AccountsDetailsManager implements UserDetailsService {
    private AccountService accountService;

    @Autowired
    public AccountsDetailsManager(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public AccountDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account account = accountService.getAccountByLogin(s);

        if (account == null) {
            throw new UsernameNotFoundException("User " + s + " not found.");
        }

        return new AccountDetails(account);
    }
}
