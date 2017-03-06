package ev.koslov.web.dto;

import ev.koslov.db.entity.Account;

public class RegisterForm extends LoginForm<Account> {

    private String passwordConfirmation;
    private String name;

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account toEntityObject() {
        return new Account(getLogin(), getPassword(), getName());
    }
}
