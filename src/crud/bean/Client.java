package crud.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Client extends Human implements Serializable, Comparable<Human> {
    @FieldInfo(name = "Registration data in dd/MM/yy format", isRepresented = true)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Client client = (Client) o;

        return Objects.equals(registrationDate, client.registrationDate);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " " + registrationDate;
    }
}
