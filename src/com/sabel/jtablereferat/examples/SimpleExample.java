package com.sabel.jtablereferat.examples;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Matthias on 19.03.2017.
 */
public class SimpleExample {

    public static void main(String[] args) {
        new SimpleExample();



    }

    public SimpleExample() {

        //1. Schritt: Spaltennamen erzeugen
        String[] columnNames = {
                "A", "B", "C","D"
        };
        //2. Schritt: Tabelendaten erzeugen
        Object[][] data = {
                {"a","b","c","d"},
                {"e","f","g","h"},
                {"i","j","k","l"},
                {"m","n","o","p"}
        };

        //3. Schritt: JTable-Object erzeugen
        JTable table = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JFrame frame = new JFrame("Einfaches Beispiel für eine JTable");
        Container c = frame.getContentPane();

        c.setLayout(new BorderLayout());
        c.add(table.getTableHeader(), BorderLayout.PAGE_START);
        c.add(table, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
