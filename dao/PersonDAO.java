package dao;

import logic.Person;
import logic.Phone;

import java.util.ArrayList;

/**
 * Created by Alex-Notebook on 17.10.2016.
 */
public interface PersonDAO
{
    void create (Person p);
    ArrayList<Person> read();
    void update(Person p);
    void delete(Person p);
    void createPhone(Phone ph);
    void deletePhone(Phone ph);
    void updatePhone(Phone ph);
    void delete(int id);

    void createPhone(Phone ph, Person p);
    void deletePhone(Phone ph, Person p);
}
