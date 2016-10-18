package gui;

import logic.TableModelPerson;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex-Notebook on 18.10.2016.
 */
@SuppressWarnings("serial")
public class TPanel extends JPanel
{
    public static JTable tblPerson;

    public TPanel() {
        setLayout(null);

        TableModelPerson tmPerson = new TableModelPerson();
        tblPerson = new JTable(tmPerson);
        tblPerson.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblPerson.getColumnModel().getColumn(3).setPreferredWidth(20);
        tblPerson.getColumnModel().getColumn(4).setPreferredWidth(90);
        JScrollPane scr = new JScrollPane(tblPerson);
        scr.setBounds(10, 10, 500, 300);
        add(scr);
        tblPerson.addMouseListener(tmPerson.aSelect);

        JButton btnCreate = new JButton("Create");
        btnCreate.setBounds(520, 10, 120, 20);
        add(btnCreate);
        btnCreate.addActionListener(tmPerson.aCreate);

        tblPerson.addKeyListener(tmPerson.aDelete);

        JButton btn_add_phone = new JButton("Add Phone");
        btn_add_phone.setBounds(520, 40, 120, 20);
        add(btn_add_phone);
        btn_add_phone.addActionListener(tmPerson.aAddPhone);

        JButton btn_del_phone = new JButton("Del Phone");
        btn_del_phone.setBounds(520, 70, 120, 20);
        add(btn_del_phone);
        btn_del_phone.addActionListener(tmPerson.aDelPhone);

    }
}
