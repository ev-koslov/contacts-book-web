package ev.koslov.web.validators;

import ev.koslov.web.dto.RegisterForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;


@Component
public class RegisterFormValidator extends LoginFormValidator {

    @Override
    public boolean supports(Class<?> aClass) {
        return RegisterForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        validateFields(o, errors);

        if (errors.hasErrors()) {
            return;
        }

        if (accountService.getAccountByLogin(((RegisterForm) o).getLogin()) != null) {
            errors.rejectValue("login", "error.account.login.already_exists");
        }
    }

    @Override
    protected void validateFields(Object o, Errors errors) {
        super.validateFields(o, errors);

        if (errors.hasErrors()) {
            return;
        }

        RegisterForm registerForm = (RegisterForm) o;

        if (!registerForm.getPassword().equals(registerForm.getPasswordConfirmation())) {
            errors.rejectValue("passwordConfirmation", "error.account.password.passwords_not_equals");
        }

        if (!registerForm.getName().matches("(.{5,})")) {
            errors.rejectValue("name", "error.account.name.wrong_format");
        }
    }

}
