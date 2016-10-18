package gui;

import javax.swing.*;

/**
 * Created by Alex-Notebook on 18.10.2016.
 */
@SuppressWarnings("serial")
public class TFrame extends JFrame
{
    public TFrame()
    {
        setTitle("Person");
        setBounds(100,100,700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new TPanel());

        setVisible(true);
    }
}
