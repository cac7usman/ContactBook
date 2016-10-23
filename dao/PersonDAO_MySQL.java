package dao;

import logic.Person;
import logic.Phone;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Alex-Notebook on 19.10.2016.
 */
public class PersonDAO_MySQL implements PersonDAO
{
    String dbURL = "jdbc:mysql://localhost:3306/test";
    String username = "root";
    String password = "";

    @Override
    public void create(Person p) {
        String sql = "INSERT INTO PERSON (id, fname, lname, age) VALUES ('" + p.id + "', '" + p.fname + "', '" + p.lname
                + "', '" + p.age + "')";

        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<Person> read() {
        String sql = "SELECT * FROM PERSON";

        ArrayList<Person> pp = new ArrayList<Person>();

        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Person p = new Person(result.getInt(1), result.getString("fname"), result.getString(3),
                        result.getInt("age"));
                for (Phone ph : addPhone(result.getInt(1))) {
                    p.addPhone(ph);
                }
                pp.add(p);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pp;
    }

    @Override
    public void update(Person p) {
        String sql = "UPDATE PERSON SET fname='" + p.fname + "', lname='" + p.lname + "', age=" + p.age + " WHERE id="
                + p.id;

        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void delete(Person p) {
        //String sql_phone = "DELETE FROM PHONE WHERE phone_id=" + p.id;
        String sql = "DELETE FROM PERSON WHERE id=" + p.id;
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
            //PreparedStatement statement_phone = conn.prepareStatement(sql_phone);
            //statement_phone.executeUpdate();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }



    @Override
    public void createPhone(Phone ph)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement st = connection.createStatement();
            String sql_phone = "INSERT INTO Phone (num, type, person_id) VALUES ('" + ph.num + "', '" + ph.type
                    + "', " + ph.person.id + ")";
            st.execute(sql_phone);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePhone(Phone ph) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement st = connection.createStatement();
            String sql_phone = "DELETE FROM Phone WHERE num = '" + ph.num + "'";
            st.execute(sql_phone);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePhone(Phone ph) {

    }

    public void createPhone(Phone ph, Person p) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement st = connection.createStatement();
            String sql_phone = "INSERT INTO Phone (num, type, person_id) VALUES ('" + ph.num + "', '" + ph.type
                    + "', " + p.id + ")";
            st.execute(sql_phone);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePhone(Phone ph, Person p) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            Statement st = connection.createStatement();
            String sql_phone = "DELETE FROM Phone WHERE num = '" + ph.num + "' AND person_id=" + p.id;
            st.execute(sql_phone);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePhone(Phone ph, int i) {

    }

    public ArrayList<Phone> addPhone(int id)
    {
        ArrayList<Phone> phoneList = new ArrayList<Phone>();
        String sql = "SELECT * FROM PHONE WHERE PERSON_ID = " + id;

        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                phoneList.add(new Phone(result.getString(2), result.getString(3), new Person(id, "", "", 0)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phoneList;

    }
}
