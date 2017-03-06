package ev.koslov.web.validators;

import ev.koslov.web.dto.ContactForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ContactFormValidator implements Validator {

    private static final String EMAIL_PATTERN = "^([_A-Za-z0-9-\\.]+)@(([A-Za-z0-9-]+)\\.)+([A-Za-z]{2,})";
    private static final String PHONE_PATTERN = "\\+380([0-9]{2})([0-9]{7})";

    public boolean supports(Class<?> aClass) {
        return ContactForm.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        ContactForm contactForm = (ContactForm) o;

        if (contactForm.getSurname() == null || contactForm.getSurname().length() < 4){
            errors.rejectValue("surname", "error.contact.surname.empty_or_to_short");
        }
        if (contactForm.getName() == null || contactForm.getName().length() < 4){
            errors.rejectValue("name", "error.contact.name.empty_or_to_short");
        }
        if (contactForm.getSecondName() == null || contactForm.getSecondName().length() < 4){
            errors.rejectValue("secondName", "error.contact.second_name.empty_or_to_short");
        }
        if (contactForm.getCellPhone() == null || contactForm.getCellPhone().isEmpty()) {
            errors.rejectValue("cellPhone", "error.contact.cell_phone.empty_or_to_short");
        }

        if (errors.hasErrors()) {
            return;
        }

        if (!isPhoneValid(contactForm.getCellPhone())) {
            errors.rejectValue("cellPhone", "error.contact.phone.wrong_format");
        }

        if (contactForm.getPhone() != null && !contactForm.getPhone().isEmpty() && !isPhoneValid(contactForm.getPhone())) {
            errors.rejectValue("phone", "error.contact.phone.wrong_format");
        }

        if (contactForm.getEmail() != null && !contactForm.getEmail().isEmpty() && !isEmailValid(contactForm.getEmail())){
            errors.rejectValue("email", "error.contact.email.wrong_format");
        }
    }


    private boolean isPhoneValid(String phone) {
        return phone.matches(PHONE_PATTERN);
    }

    private boolean isEmailValid(String email) {
        return email.matches(EMAIL_PATTERN);
    }
}
