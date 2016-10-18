package gui;

import logic.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex-Notebook on 17.10.2016.
 */
@SuppressWarnings("serial")
public class PersonDialog extends JDialog
{
    JTextField txt_id = null;
    JTextField txt_fname = null;
    JTextField txt_lname = null;
    JTextField txt_age = null;

    public boolean flag = false;

    public PersonDialog()
    {
        setLayout(null);
        setModal(true);
        setBounds(300, 300, 210, 250);

        // ----------------TEXTFIELDS----------------------------

        txt_id = new JTextField();
        txt_id.setBounds(80, 10, 100, 20);
        add(txt_id);

        txt_fname = new JTextField();
        txt_fname.setBounds(80, 40, 100, 20);
        add(txt_fname);

        txt_lname = new JTextField();
        txt_lname.setBounds(80, 70, 100, 20);
        add(txt_lname);

        txt_age = new JTextField();
        txt_age.setBounds(80, 100, 100, 20);
        add(txt_age);

        // ----------------LABELS----------------------------

        JLabel l1 = new JLabel("ID:");
        l1.setBounds(10, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("First Name:");
        l2.setBounds(10, 40, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Last Name:");
        l3.setBounds(10, 70, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Age:");
        l4.setBounds(10, 100, 100, 20);
        add(l4);

        // ----------------BUTTONS----------------------------

        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(10, 140, 80, 20);
        add(btnOk);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = true;
                setVisible(false);

            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(100, 140, 80, 20);
        add(btnCancel);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = false;
                setVisible(false);
            }
        });
    }

    public Person getPerson()
    {
        int id = Integer.parseInt(txt_id.getText());
        String fname = txt_fname.getText();
        String lname = txt_lname.getText();
        int age = Integer.parseInt(txt_age.getText());
        Person p = new Person (id, fname, lname, age);

        return p;
    }

    public void setPerson (Person p)
    {
        txt_id.setText("" + p.id);
        txt_fname.setText("" + p.fname);
        txt_lname.setText("" + p.lname);
        txt_age.setText("" + p.age);
    }

    public int getId()
    {
        int id = Integer.parseInt(txt_id.getText());
        return id;
    }
}
