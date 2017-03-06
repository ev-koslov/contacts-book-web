package ev.koslov.db;


import ev.koslov.db.entity.Contact;

import java.util.List;

/**
 *  Interface represent contact dao
 */
public interface ContactDAO {
    Contact create(Contact contact);
    Contact read(long contactId);
    Contact update(Contact contact);
    void delete(long contactId);

    List<Contact> getContacts(String userLogin);
    List<Contact> getFilteredContacts(String userLogin, String criteria);
}
