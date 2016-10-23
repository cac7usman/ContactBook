package dao;

import logic.Person;
import logic.Phone;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Alex-Notebook on 17.10.2016.
 */
public class PersonDAO_Mock implements PersonDAO
{
    public ArrayList<Person> pp = null;

    public PersonDAO_Mock()
    {
        pp = new ArrayList<Person>();

        Person p = new Person (1, "Alejandro", "Gonzales", 26);
        Person p1 = new Person (2, "Marjan", "Burjan", 24);
        Person p2 = new Person (3, "Honza", "Sikovny", 22);

        p.addPhone(new Phone(1, "050 123 45 67", "home"));
        p.addPhone(new Phone(2, "050 890 10 11", "office"));


        pp.add(p);

        p1.addPhone(new Phone(5, "050 121 31 41", "c"));

        pp.add(p1);
        pp.add(p2);
    }
    @Override
    public void create(Person p) {
        pp.add(p);
    }

    @Override
    public ArrayList<Person> read() {
        return pp;
    }

    @Override
    public void update(Person p) {
        for (int i = 0; i < pp.size(); i++) {
            Person tmp = pp.get(i);
            if (tmp.id == p.id) {
                tmp.init(p.id, p.fname, p.lname, p.age);
            }
        }
    }

    @Override
    public void delete(Person p) {
        for (int i = 0; i < pp.size(); i++) {
            Person tmp = pp.get(i);
            if (tmp.id == p.id) {
                pp.remove(i);
            }
        }
    }

    @Override
    public void createPhone(Phone ph)
    {
       ph.person.phoneList.add(ph);
    }
    @Override
    public void updatePhone(Phone ph) {

    }

    @Override
    public void updatePhone(Phone ph, int i)
    {
    ph.person.phoneList.set(i, ph);

    }

    @Override
    public void createPhone(Phone ph, Person p) {
        p.phoneList.add(ph);
    }

    @Override
    public void deletePhone(Phone ph, Person p) {

        for (Iterator<Phone> iterator = p.phoneList.iterator(); iterator.hasNext();)
        {
           Phone c1 = iterator.next();
            {
                if (c1.num.equals(ph.num))
                {
                    iterator.remove();
                }
            }
        }

    }

    @Override
    public void deletePhone(Phone ph) {
    // not used in Mock
    // consider about delete from other realizations
    }
}
