package com.sabel.jtablereferat.examples;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Matthias on 19.03.2017.
 */
public class JsonExample extends JFrame{
    public static void main(String[] args) {
        new JsonExample();
    }

    public JsonExample() {
        Container container = this.getContentPane();


        String[] columnNames = {
                "First Name","Last Name","Sport","# of Years","Vegetarian"};

        Object[][] data = {
                {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}
        };
        JTable table = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        container.setLayout(new BorderLayout());
        container.add(table.getTableHeader(), BorderLayout.PAGE_START);
        container.add(scrollPane, BorderLayout.CENTER);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
