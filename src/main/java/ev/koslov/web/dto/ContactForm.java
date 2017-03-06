package ev.koslov.web.dto;

import ev.koslov.db.entity.Contact;

public class ContactForm implements IForm<Contact> {
    private long id;
    private String surname;
    private String name;
    private String secondName;
    private String cellPhone;
    private String phone;
    private String address;
    private String email;


    public ContactForm() {
    }

    public ContactForm(Contact contact) {
        this.id = contact.getId();
        this.surname = contact.getSurname();
        this.name = contact.getName();
        this.secondName = contact.getSecondName();
        this.cellPhone = contact.getCellPhone();
        this.phone = contact.getPhone();
        this.address = contact.getAddress();
        this.email = contact.getEmail();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact toEntityObject() {
        Contact contact = new Contact(surname, name, secondName, cellPhone);
        contact.setId(id);
        contact.setPhone(phone);
        contact.setAddress(address);
        contact.setEmail(email);
        return contact;
    }
}
