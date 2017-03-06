package ev.koslov.web.dto;


public class LoginForm<T> implements IForm<T> {

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public T toEntityObject() {
        throw new UnsupportedOperationException("LoginForm has no entity object.");
    }
}
