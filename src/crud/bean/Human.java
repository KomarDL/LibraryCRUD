package crud.bean;

import java.util.Date;
import java.util.Objects;

abstract public class Human implements Comparable<Human> {
    @FieldInfo(name = "Name", isRepresented = true)
    private String name;
    @FieldInfo(name = "Surname", isRepresented = true)
    private String surname;
    @FieldInfo(name = "Patronymic", isRepresented = true)
    private String patronymic;
    @FieldInfo(name = "Birthday in dd/MM/yy format", isRepresented = true)
    private Date birthday;

    public Human() {
    }

    public Human(String name, String surname, String patronymic, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Human human) {
        return surname.compareToIgnoreCase(human.surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (!Objects.equals(name, human.name)) return false;
        if (!Objects.equals(surname, human.surname)) return false;
        if (!Objects.equals(patronymic, human.patronymic)) return false;
        return Objects.equals(birthday, human.birthday);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + patronymic + " " + birthday ;
    }
}
