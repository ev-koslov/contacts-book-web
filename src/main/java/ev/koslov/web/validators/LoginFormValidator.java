package ev.koslov.web.validators;

import ev.koslov.db.entity.Account;
import ev.koslov.services.AccountService;
import ev.koslov.web.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginFormValidator implements Validator {

    @Autowired
    protected AccountService accountService;

    public boolean supports(Class<?> aClass) {
        return LoginForm.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        validateFields(o, errors);

        if (errors.hasErrors()){
            return;
        }

        validateCredentials(o, errors);
    }

    protected void validateFields(Object o, Errors errors) {
        LoginForm loginForm = (LoginForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "error.account.login.is_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.account.password.is_empty");

        if (!loginForm.getLogin().matches("([A-Za-z]{3,})")) {
            errors.rejectValue("login", "error.account.login.wrong_format");
        }

        if (!loginForm.getPassword().matches("(.{5,})")) {
            errors.rejectValue("password", "error.account.password.wrong_format");
        }
    }

    private void validateCredentials(Object o, Errors errors) {
        LoginForm loginForm = (LoginForm) o;

        Account account = accountService.getAccountByLogin(loginForm.getLogin());

        if (account == null) {
            errors.rejectValue("login", "error.account.login.not_exist");
            return;
        }

        if (!account.getPassword().equals(loginForm.getPassword())) {
            errors.rejectValue("password", "error.account.password.wrong_password");
        }
    }
}
