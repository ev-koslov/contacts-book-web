package ev.koslov.db.entity;

import javax.persistence.*;

/**
 * Account POJO class
 *
 * Annotations are used in this class enabling XML serialization and ORM access
 */

@Entity
@Table(name = "accounts")

public class Account {

    @Id
    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    public Account() {

    }

    public Account(String login, String password, String name) {
        this();
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

}
