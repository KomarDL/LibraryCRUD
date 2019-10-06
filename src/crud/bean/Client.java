package crud.bean;

import java.io.Serializable;
import java.util.Date;

public class Client extends Human implements Serializable {
    private Date registrationDate;

    public Client() {
    }

    public Client(String name, String surname, String patronymic, Date birthday, Date registrationDate) {
        super(name, surname, patronymic, birthday);
        this.registrationDate = registrationDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }


}
