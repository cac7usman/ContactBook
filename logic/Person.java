package logic;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Alex-Notebook on 16.10.2016.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "person")
public class Person implements Serializable
{
    private static final long serialVersionUID = 42L;

    @Id
    @Column(name = "id")
    public int id;

    @Column (name = "fname")
    public String fname;

    @Column (name = "lname")
    public String lname;

    @Column (name = "age")
    public int age;

    @ElementCollection (targetClass = Phone.class)
    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
    public List<Phone> phoneList;

    public List<Phone> getPhoneList()
    {
        return this.phoneList;
    }

    public void setPhoneList(ArrayList<Phone> phoneList)
    {
        this.phoneList = phoneList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person()
    {
        //
    }

    public Person(int id, String fname, String lname, int age)
    {
        init(id, fname, lname, age);
    }

    public void init(int id, String fname, String lname, int age)
    {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public void addPhone (Phone phone)
    {
        phone.setPerson(this);
        phoneList = new ArrayList<Phone>(); // this line for mockup working
        getPhoneList().add(phone);
    }

    public void removePhone (Phone phone)
    {
        Iterator<Phone> iterator = phoneList.iterator();
        while (iterator.hasNext())
        {
            Phone ph = iterator.next();

            if (ph.equals(phone))
            {
                iterator.remove();
            }
        }
    }

    public List<Phone> readPhone()
    {
        return phoneList;
    }

}
