package crud.service.comparators.human;

import crud.bean.Human;

import java.util.Comparator;

public class HumanSurnameComparator implements Comparator<Human> {
@Override
public int compare(Human human, Human t1) {
        return human.getSurname().compareToIgnoreCase(t1.getSurname());
        }
}
