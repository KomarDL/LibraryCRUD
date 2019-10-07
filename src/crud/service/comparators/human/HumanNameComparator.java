package crud.service.comparators.human;

import crud.bean.Human;

import java.util.Comparator;

public class HumanNameComparator implements Comparator<Human> {
    @Override
    public int compare(Human human, Human t1) {
        return human.getName().compareToIgnoreCase(t1.getName());
    }
}
