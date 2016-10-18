package gui;

import logic.Person;
import logic.Phone;
import logic.TableModelPhone;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Alex-Notebook on 17.10.2016.
 */
@SuppressWarnings("serial")
public class PersonPhoneDialog extends JDialog
{
    JTextField txt_id = null;
    JTextField txt_fname = null;
    JTextField txt_lname = null;
    JTextField txt_age = null;
    TableModel tmPhone;
    JTable tblPhone;
    public boolean flag = false;
    public Person p;

    public PersonPhoneDialog(Person p)
    {
        this.p = p;
        setTitle("Person");
        setLayout(null);
        setModal(true);
        setBounds(300, 400, 200, 350);

        // --------------Labels ----------------

        JLabel lbl_id = new JLabel("id");
        lbl_id.setBounds(10, 10, 50, 20);
        add(lbl_id);

        JLabel lbl_fname = new JLabel("fname");
        lbl_fname.setBounds(10, 40, 50, 20);
        add(lbl_fname);

        JLabel lbl_lname = new JLabel("lname");
        lbl_lname.setBounds(10, 70, 50, 20);
        add(lbl_lname);

        JLabel lbl_age = new JLabel("age");
        lbl_age.setBounds(10, 100, 50, 20);
        add(lbl_age);

        // --------------Text Fields ----------------

        txt_id = new JTextField("" + p.id);
        txt_id.setBounds(60, 10, 100, 20);
        add(txt_id);

        txt_fname = new JTextField("" + p.fname);
        txt_fname.setBounds(60, 40, 100, 20);
        add(txt_fname);

        txt_lname = new JTextField("" + p.lname);
        txt_lname.setBounds(60, 70, 100, 20);
        add(txt_lname);

        txt_age = new JTextField("" + p.age);
        txt_age.setBounds(60, 100, 100, 20);
        add(txt_age);

        // --------------Table Model Phones ----------------

        TableModelPhone tmPhone = new TableModelPhone(p);
        JTable tblPhone = new JTable(tmPhone);

        JScrollPane jScrollPane = new JScrollPane(tblPhone);
        jScrollPane.setBounds(10, 160, 160, 100);
        add(jScrollPane);
        tblPhone.addMouseListener(tmPhone.aSelect);



        // --------------Buttons ----------------

        JButton btnAddPhone = new JButton("Add Phone");
        btnAddPhone.setBounds(95, 290, 75, 20);
        add(btnAddPhone);
        btnAddPhone.addActionListener(tmPhone.aCreate);

        JButton btnDelPhone = new JButton("Del Phone");
        btnDelPhone.setBounds(95, 320, 75, 20);
        add(btnDelPhone);
        btnDelPhone.addActionListener(tmPhone.aDelete);

        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(10, 270, 75, 20);
        add(btnOk);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = true;
                setVisible(false);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(95, 270, 75, 20);
        add(btnCancel);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = false;
                setVisible(false);
            }
        });
    }

    public Person getPerson() {
        int id = Integer.parseInt(txt_id.getText());
        String fname = txt_fname.getText();
        String lname = txt_lname.getText();
        int age = Integer.parseInt(txt_age.getText());

        Person p = new Person(id, fname, lname, age);
        return p;

    }





}
