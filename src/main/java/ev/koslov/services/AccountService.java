package ev.koslov.services;

import ev.koslov.db.AccountDAO;
import ev.koslov.db.entity.Account;
import ev.koslov.web.dto.RegisterForm;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Account service.
 * Processes requests from account controller, performs register, login and logoff operations
 */

@Service
public class AccountService {

    @Resource
    private AccountDAO accountDAO;

    public Account createAccount(RegisterForm registerForm) {
        return accountDAO.create(registerForm.toEntityObject());
    }
    public Account getAccountByLogin(String login) {
        return accountDAO.read(login);
    }

    @PostConstruct
    public void addAdmin(){
        Account admin = new Account();
        admin.setLogin("admin");
        admin.setPassword("admin");
        admin.setName("admin");
        accountDAO.create(admin);
    }
}
