package ev.koslov.db.entity;

import javax.persistence.*;

/**
 * Contact POJO class
 * Annotations are used in this class enabling XML serialization and ORM access
 */

@Entity
@Table(name = "contacts")

public class Contact {

    @Id
    @GeneratedValue
    long id;

    @ManyToOne(targetEntity = Account.class)
    Account owner;

    @Column(nullable = false)
    String surname;

    @Column(nullable = false)
    String name;

    @Column(nullable = false, name = "second_name")
    String secondName;

    @Column(nullable = false, name = "cell_phone")
    String cellPhone;

    @Column(nullable = false)
    String phone;

    @Column
    String address;

    @Column
    String email;

    public Contact() {
    }

    public Contact(String surname, String name, String secondName, String cellPhone) {
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.cellPhone = cellPhone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
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
}
