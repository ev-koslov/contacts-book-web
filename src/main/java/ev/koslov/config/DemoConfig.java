package ev.koslov.config;

import ev.koslov.db.AccountDAO;
import ev.koslov.db.ContactDAO;
import ev.koslov.db.entity.Account;
import ev.koslov.db.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("demo")
public class DemoConfig {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private ContactDAO contactDAO;

    @PostConstruct
    public void addAdmin(){
        Account admin = new Account();
        admin.setLogin("admin");
        admin.setPassword("admin");
        admin.setName("admin");
        accountDAO.create(admin);

        Contact contact = new Contact("Админ", "Админ", "Админ", "+380669966999");
        contact.setOwner(admin);
        contact.setAddress("Somewhere in Kyiv.");
        contact.setPhone("+380558855888");
        contact.setEmail("admin@demo.local");

        contactDAO.create(contact);
    }
}
