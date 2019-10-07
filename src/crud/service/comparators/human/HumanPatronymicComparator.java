package crud.service.comparators.human;

import crud.bean.Human;

import java.util.Comparator;

public class HumanPatronymicComparator implements Comparator<Human> {
    @Override
    public int compare(Human human, Human t1) {
        return human.getPatronymic().compareToIgnoreCase(t1.getPatronymic());
    }
}
