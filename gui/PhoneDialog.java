package gui;

import logic.Person;
import logic.Phone;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex-Notebook on 17.10.2016.
 */
@SuppressWarnings("serial")
public class PhoneDialog extends JDialog
{
    JTextField txt_id = null;
    JTextField txt_num = null;
    JTextField txt_type = null;
    Person p;
    public boolean flag = false;

    public PhoneDialog(Person p)
    {
        this.p = p;
        setTitle("Phone");
        setLayout(null);
        setModal(true);
        setBounds(300, 300, 220, 200);

        JLabel lbl_id = new JLabel("Person ID:");
        lbl_id.setBounds(10, 10, 60, 20);
        add(lbl_id);

        txt_id = new JTextField();
        txt_id.setBounds(80, 10, 100, 20);
        add(txt_id);
        txt_id.setEditable(false);

        JLabel lbl_num = new JLabel("Number: ");
        lbl_num.setBounds(10, 40, 60, 20);
        add(lbl_num);

        txt_num = new JTextField();
        txt_num.setBounds(80, 40, 100, 20);
        add(txt_num);

        JLabel lbl_type = new JLabel("Type: ");
        lbl_type.setBounds(10, 70, 60, 20);
        add(lbl_type);

        txt_type = new JTextField();
        txt_type.setBounds(80, 70, 100, 20);
        add(txt_type);

        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(10, 130, 75, 20);
        add(btnOk);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = true;
                setVisible(false);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(95, 130, 75, 20);
        add(btnCancel);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = false;
                setVisible(false);
            }
        });

    }

    public void setId(int id) {
        txt_id.setText("" + id);
    }

    public Phone getPhone() {
        String num = txt_num.getText();
        String type = txt_type.getText();
        Phone phone = new Phone(num, type, p);
        return phone;
    }

}
