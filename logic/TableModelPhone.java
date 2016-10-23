package logic;

import dao.PersonDAO;
import dao.PersonDAO_Hibernate;
import dao.PersonDAO_Mock;
import dao.PersonDAO_MySQL;
import gui.PhoneDialog;

import javax.swing.table.AbstractTableModel;

import java.awt.event.*;
import java.util.List;

/**
 * Created by Alex-Notebook on 18.10.2016.
 */
@SuppressWarnings("serial")
public class TableModelPhone extends AbstractTableModel
{
    List<Phone> phList;

   // PersonDAO pd = new PersonDAO_Mock();
    PersonDAO pd = new PersonDAO_MySQL();
    //PersonDAO pd = new PersonDAO_Hibernate();

    public Person p;
    public int currentRow;

    public ActionSelect aSelect = new ActionSelect();

    public ActionCreate aCreate = new ActionCreate();
    public ActionDelete aDelete = new ActionDelete();

    public TableModelPhone(Person p)
    {
        this.p = p;
        phList = p.phoneList;

    }

    public String getColumnName (int col)
    {
        String[] m_colNames = { "num", "type"};
        return m_colNames[col];
    }

    @Override
    public int getRowCount() {
        return phList.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Phone ph = phList.get(row);
        Object ret = null;
        switch (col)
        {
            case 0:
                ret = ph.num;
                break;
            case 1:
                ret = ph.type;
                break;

        }
        return ret;
    }

    @Override
    public void setValueAt (Object val, int row, int col)
    {
        Phone ph = phList.get(row);
        switch (col)
        {
            case 0:
                ph.num = (String) val;
                break;
            case 1:
                ph.type = (String) val;
                break;
        }
        pd.updatePhone(ph, currentRow);
    }

    @Override
    public boolean isCellEditable (int row, int col)
    {
        return true;
    }

    class ActionSelect implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e) {

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

    class ActionCreate implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            PhoneDialog dia = new PhoneDialog(p);
            dia.setVisible(true);
            if (dia.flag == true)
            {
                pd.createPhone(dia.getPhone());
            }
        }
    }

    class ActionDelete implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DELETE)
            {
                Phone phone = phList.get(currentRow);
                pd.deletePhone(phone, p);
                fireTableDataChanged();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }
}
