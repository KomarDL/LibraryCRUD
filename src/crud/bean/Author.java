package crud.bean;

import java.util.Date;

public class Author extends Human {
    private String pseudonym;

    public Author() {
    }

    public Author(String name, String surname, String patronymic, Date birthday, String pseudonym) {
        super(name, surname, patronymic, birthday);
        this.pseudonym = pseudonym;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }
}
