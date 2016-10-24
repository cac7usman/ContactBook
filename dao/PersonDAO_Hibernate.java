package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import logic.Person;
import logic.Phone;

public class PersonDAO_Hibernate implements PersonDAO {

    @Override
    public void create(Person p) {
        Session session = createSession();
        Transaction t = session.beginTransaction();
        session.persist(p);// persisting the object
        t.commit();// transaction is committed
        session.close();

        System.out.println("successfully saved");
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Person> read() {
        ArrayList<Person> pp = new ArrayList<Person>();

        Session session = createSession();
        List<Person> products = (List<Person>) session.createQuery("from Person").list();
        for (Person p : (List<Person>) products) {
            pp.add(p);
        }



        session.close();

        return pp;

    }

    @SuppressWarnings("unchecked")
    public ArrayList<Phone> readPhone()

    {
        ArrayList<Phone> phoneList = new ArrayList<Phone>();
        Session session = createSession();

        List<Phone> cont = (List<Phone>) session.createQuery("from Phone").list();
        for (Phone phone : (List<Phone>) cont) {
            phoneList.add(phone);
        }
        return phoneList;
    }

    @Override
    public void update(Person p) {
        Session session = createSession();
        Transaction t = session.beginTransaction();
        session.update(p);// persisting the object
        t.commit();// transaction is committed
        session.close();

        System.out.println("successfully saved");
    }

    @Override
    public void delete(Person p) {
        Session session = createSession();
        Transaction t = session.beginTransaction();
        session.delete(p);// persisting the object
        t.commit();// transaction is committed
        session.close();

        System.out.println("successfully saved");
    }

    @Override
    public void createPhone(Phone ph) {
        Session session = createSession();
        Transaction t = session.beginTransaction();
        session.persist(ph);// persisting the object
        t.commit();// transaction is committed
        session.close();
    }

    @Override
    public void deletePhone(Phone ph) {

    }

    @Override
    public void updatePhone(Phone ph) {

    }

    public Session createSession() {
        Session session;
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        session = factory.openSession();
        return session;
    }

    @Override
    public void createPhone(Phone phone, Person p) {
        Phone ph = new Phone(phone.num, phone.type, p);
        Session session = createSession();
        Transaction t = session.beginTransaction();
        session.persist(ph);// persisting the object
        t.commit();// transaction is committed
        session.close();

    }

    @Override
    public void deletePhone(Phone phone, Person p) {

        Phone ph = new Phone (phone.num, phone.type, p);
        Session session = createSession();
        Transaction t=session.beginTransaction();
        session.delete(ph);//persisting the object
        t.commit();//transaction is committed
        session.close();
        System.out.println("successfully deleted");

    }

    @Override
    public void updatePhone(Phone ph, int i) {

    }

}
