package logic;

import dao.PersonDAO;
import dao.PersonDAO_Mock;
import gui.PersonDialog;
import gui.PersonPhoneDialog;
import gui.PhoneDialog;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by Alex-Notebook on 17.10.2016.
 */
@SuppressWarnings("serial")
public class TableModelPerson extends AbstractTableModel
{
    ArrayList<Person> pp = null;
    PersonDAO pd = new PersonDAO_Mock();

    public int currentRow = 0;

    public ActionSelect aSelect = new ActionSelect();

    public ActionCreate aCreate = new ActionCreate();
    public ActionDelete aDelete = new ActionDelete();

    public ActionAddPhone aAddPhone = new ActionAddPhone();
    public ActionDelPhone aDelPhone = new ActionDelPhone();

    public TableModelPerson()
    {
        pp = pd.read();
    }

    @Override
    public int getRowCount() {
        return pp.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public String getColumnName(int col)
    {
        String[] m_colNames = {"id", "fname", "lname", "age", "phones"};
        return m_colNames[col];
    }

    @Override
    public Object getValueAt(int row, int col)
    {
        Person p = pp.get(row);
        Object ret = null;
        switch (col)
        {
            case 0:
                ret = p.id;
                break;
            case 1:
                ret = p.fname;
                break;
            case 2:
                ret = p.lname;
                break;
            case 3:
                ret = p.age;
                break;
            case 4:
                ret = getPhoneInfo(p);
                break;
        }
        return ret;
    }

    private String getPhoneInfo (Person p)
    {
        String str = "";

        if (p.phoneList == null)
        {
            return str = "-";
        }
        else if (p.phoneList.size() > 0)
        {
            str = p.phoneList.get(0).num;
            if (p.phoneList.size() >= 1)
            {
                str += "(+" + (p.phoneList.size() - 1) + ")";
            }
            return str;
        }

            return "";




    }

    public class ActionCreate implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            PersonDialog dia = new PersonDialog();
            dia.setVisible(true);
            if (dia.flag == true)
            {
                pd.create(dia.getPerson());
                pp = pd.read();
                fireTableDataChanged();
            }
        }
    }

    public class ActionDelete implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DELETE && currentRow != 0) // testing with currentRow == 0
        {
            Person p = pp.get(currentRow);
            pd.delete(p);
            pp = pd.read();
            fireTableDataChanged();
        }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public class ActionSelect implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
            JTable target = (JTable) e.getSource();
            currentRow = target.getSelectedRow();

            if (e.getClickCount() == 2)
            {
                Person p = pp.get(currentRow);
                PersonPhoneDialog dia = new PersonPhoneDialog();
                dia.setPerson(p);
                dia.setVisible(true);
                if (dia.flag == true)
                {
                    pd.update(dia.getPerson());
                    pp = pd.read();
                    fireTableDataChanged();
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public class ActionAddPhone implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            PhoneDialog dia = new PhoneDialog();
            dia.setId(pp.get(currentRow).id);
            dia.setVisible(true);
            if (dia.flag == true) {
                pd.createPhone(dia.getPhone(), pp.get(currentRow));
                pp = pd.read();
                fireTableDataChanged();
            }

        }

    }

    public class ActionDelPhone implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PhoneDialog dia = new PhoneDialog();
            dia.setId(pp.get(currentRow).id);
            dia.setVisible(true);
            if (dia.flag == true) {
                pd.deletePhone(dia.getPhone(), pp.get(currentRow));
                pp = pd.read();
                fireTableDataChanged();
            }

        }

    }

}
