package ev.koslov.services;

import ev.koslov.db.ContactDAO;
import ev.koslov.db.entity.Account;
import ev.koslov.db.entity.Contact;
import ev.koslov.web.dto.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Contact service.
 * Processes requests from contact controller, does database operations
 */

@Service
public class ContactService {

    private ContactDAO contactDAO;
    private AccountService accountService;
    private AuthenticationService authenticationService;

    @Autowired
    public ContactService(ContactDAO contactDAO,
                          AccountService accountService,
                          AuthenticationService authenticationService) {
        this.contactDAO = contactDAO;
        this.accountService = accountService;
        this.authenticationService = authenticationService;
    }

    public Contact createContact(ContactForm contactForm) {

        Account ownerAccount = accountService.getAccountByLogin(authenticationService.getAuthenticatedLogin());

        Contact contact = contactForm.toEntityObject();

        contact.setOwner(ownerAccount);

        return contactDAO.create(contact);
    }

    public Contact updateContact(ContactForm contactForm) {
        Account ownerAccount = accountService.getAccountByLogin(authenticationService.getAuthenticatedLogin());

        Contact contactFromForm = contactForm.toEntityObject();
        Contact contactFromDB = contactDAO.read(contactFromForm.getId());

        if (contactFromDB.getOwner().getLogin().equalsIgnoreCase(ownerAccount.getLogin())) {
            contactFromForm.setOwner(ownerAccount);
            return contactDAO.update(contactFromForm);
        } else {
            return null;
        }
    }

    public void deleteContact(long idToDelete) {
        String authenticatedUser = authenticationService.getAuthenticatedLogin();
        Contact contactFromDB = contactDAO.read(idToDelete);

        if (contactFromDB != null && contactFromDB.getOwner().getLogin().equalsIgnoreCase(authenticatedUser)) {
            contactDAO.delete(idToDelete);
        }
    }

    public Contact getContact(long id) {
        String authenticatedUserLogin = authenticationService.getAuthenticatedLogin();
        Contact requestedContact = contactDAO.read(id);

        if (requestedContact != null && requestedContact.getOwner().getLogin().equalsIgnoreCase(authenticatedUserLogin)) {
            return requestedContact;
        } else {
            return null;
        }
    }

    public List<Contact> getContacts() {
        return contactDAO.getContacts(authenticationService.getAuthenticatedLogin());
    }

    public List<Contact> getFilteredContacts(String criteria) {
        return contactDAO.getFilteredContacts(authenticationService.getAuthenticatedLogin(), criteria);
    }
}
