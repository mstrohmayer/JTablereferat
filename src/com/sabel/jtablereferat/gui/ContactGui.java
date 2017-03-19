package com.sabel.jtablereferat.gui;

import com.sabel.jtablereferat.model.Contact;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Matthias on 19.03.2017.
 */
public class ContactGui extends JFrame {
    private Container c;
    private JPanel jpNorth, jpSouth;
    private ContactTableModel contactTableModel;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private JButton jbNew, jbRemove;

    public ContactGui() throws HeadlessException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.initComponents();
        this.initEvents();

        this.setVisible(true);
    }

    private void initComponents() {
        c = getContentPane();

        jpNorth = new JPanel();
        contactTableModel = new ContactTableModel();
        jTable = new JTable(contactTableModel);
        jTable.setFillsViewportHeight(true);
        jTable.setDefaultRenderer(String.class,new DefaultTableCellRenderer());
        jScrollPane = new JScrollPane(jTable);
        jpNorth.add(jScrollPane);

        jpSouth = new JPanel();
        jbNew = new JButton("Neuer Kontakt");
        jbRemove = new JButton("Kontakt löschen");
        jpSouth.add(jbNew);
        jpSouth.add(jbRemove);

        c.add(jpNorth, BorderLayout.NORTH);
        c.add(jpSouth, BorderLayout.SOUTH);
    }

    private void initEvents() {
        contactTableModel.addTableModelListener(this.jTable);
        jbNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                contactTableModel.addContact(new Contact());
            }
        });
        jbRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                contactTableModel.removeContact(jTable.getSelectedRow());
            }
        });

    }
}
