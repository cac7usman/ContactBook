package gui;

import logic.Person;
import logic.Phone;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    List<Phone> phoneList;

    public PersonPhoneDialog()
    {
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

        txt_id = new JTextField();
        txt_id.setBounds(60, 10, 100, 20);
        add(txt_id);

        txt_fname = new JTextField();
        txt_fname.setBounds(60, 40, 100, 20);
        add(txt_fname);

        txt_lname = new JTextField();
        txt_lname.setBounds(60, 70, 100, 20);
        add(txt_lname);

        txt_age = new JTextField();
        txt_age.setBounds(60, 100, 100, 20);
        add(txt_age);

        // --------------Table Model Phones ----------------

        JScrollPane jScrollPane1;
        Object[] columnNames = { "Number", "Type" };
        Object[][] data = { { "", "" }, { "", "" } };

        TableModel model = new DefaultTableModel(data, columnNames);
        tblPhone = new JTable(model);
        tblPhone.getColumnModel().getColumn(1).setPreferredWidth(20);
        jScrollPane1 = new JScrollPane(tblPhone);
        jScrollPane1.setBounds(10, 160, 160, 100);
        getContentPane().add(jScrollPane1);
        tmPhone = (DefaultTableModel) tblPhone.getModel();

        // --------------Buttons ----------------

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

    public void setPerson(Person p) {

        txt_id.setText("" + p.id);
        txt_fname.setText("" + p.fname);
        txt_lname.setText("" + p.lname);
        txt_age.setText("" + p.age);

        phoneList = p.phoneList;

        ((DefaultTableModel) tmPhone).setRowCount(0);
        for (Phone ph : phoneList) {
            ((DefaultTableModel) tmPhone).addRow(new String[] { ph.num, ph.type });
        }

    }
}
