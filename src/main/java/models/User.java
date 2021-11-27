package models;

import java.util.Objects;

public class User {

    private String name;
    private String pass;
    private String mail;
    private String mailpass;

    public User(String name, String pass, String mail, String mailpass) {
        this.name = name;
        this.pass = pass;
        this.mail = mail;
        this.mailpass = mailpass;
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMailpass() {
        return mailpass;
    }

    public void setMailpass(String mailpass) {
        this.mailpass = mailpass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(pass, user.pass) && Objects.equals(mail, user.mail) && Objects.equals(mailpass, user.mailpass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pass, mail, mailpass);
    }

    @Override
    public String toString() {
        return String.format("User name is: %s\nUser pass is: %s\nUser mail is: %s\nUser mail pass is: %s", name, pass, mail, mailpass);
    }
}
