package ev.koslov.db.dao_impl;

import ev.koslov.db.ContactDAO;
import ev.koslov.db.entity.Contact;
import ev.koslov.db.repository.ContactJpaRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Contact DAO implementation for Jpa database
 */
public class JpaContactDAO implements ContactDAO {

    @Resource
    private ContactJpaRepository contactJpaRepository;


    public Contact create(Contact contact) {
        return contactJpaRepository.saveAndFlush(contact);
    }

    public Contact update(Contact contact) {
        return (contactJpaRepository.exists(contact.getId()))
                ? (contactJpaRepository.saveAndFlush(contact))
                : null;
    }

    public Contact read(long contactId) {
        return contactJpaRepository.findOne(contactId);
    }

    public List<Contact> getContacts(String userLogin) {
        return contactJpaRepository.getAllUserContacts(userLogin);
    }

    public List<Contact> getFilteredContacts(String userLogin, String criteria) {
        return contactJpaRepository.getFilteredUserContacts(userLogin, criteria);
    }

    public void delete(long contactId) {
        contactJpaRepository.delete(contactId);
    }
}
