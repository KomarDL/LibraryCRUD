package crud.bean;

import java.util.Date;

abstract public class Human implements Comparable<Human> {
    private String name;
    private String surname;
    private String patronymic;
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
}
