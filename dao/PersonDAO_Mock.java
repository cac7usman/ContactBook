package dao;

import logic.Person;
import logic.Phone;

import java.util.ArrayList;

/**
 * Created by Alex-Notebook on 17.10.2016.
 */
public class PersonDAO_Mock implements PersonDAO {
    @Override
    public void create(Person p) {

    }

    @Override
    public ArrayList<Person> read() {
        return null;
    }

    @Override
    public void update(Person p) {

    }

    @Override
    public void delete(Person p) {

    }

    @Override
    public void createPhone(Phone ph, Person p) {

    }

    @Override
    public void deletePhone(Phone ph, Person p) {

    }

    @Override
    public void delete(int id) {

    }
}
