package logic;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alex-Notebook on 17.10.2016.
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "phone")

public class Phone implements Serializable
{
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "num")
    public String num;

    @Column (name = "type")
    public String type;

    @Access(AccessType.PROPERTY)
    @ManyToOne
    @JoinColumn (name = "person_id")
    public Person person;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Person getPerson() {
        return person;
    }

   public void setPerson(Person person) {
        this.person = person;
    }

    public Phone()
    {
        //
    }

    public Phone(String num, String type, Person p)
    {
        init(num, type, p);
    }

    public Phone (int id, String num, String type)
    {
        init(id, num, type);
    }

    public void init(int id, String num, String type)
    {
        this.id = id;
        this.num = num;
        this.type = type;

    }

    public void init(String num, String type, Person p) {
        this.person = p;
        this.num = num;
        this.type = type;
    }



}
