package crud.service.comparators.human;

import crud.bean.Human;

import java.util.Comparator;

public class HumanBirthdayComparator implements Comparator<Human> {
    @Override
    public int compare(Human human, Human t1) {
        return human.getBirthday().compareTo(t1.getBirthday());
    }
}
