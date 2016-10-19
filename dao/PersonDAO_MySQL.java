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
                /*for (Phone ph : addPhone(result.getInt(1))) {
                    p.addPhone(ph);
                }*/
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
    public void delete(int id) {

        String sql = "DELETE FROM PERSON WHERE id=" + id;
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void createPhone(Phone ph) {

    }

    @Override
    public void deletePhone(Phone ph) {

    }

    @Override
    public void updatePhone(Phone ph) {

    }

    @Override
    public void createPhone(Phone ph, Person p) {

    }

    @Override
    public void deletePhone(Phone ph, Person p) {

    }

    @Override
    public void updatePhone(Phone ph, int i) {

    }
}
