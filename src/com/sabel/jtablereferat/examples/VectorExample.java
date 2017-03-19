package com.sabel.jtablereferat.examples;

import javax.swing.*;
import java.util.Vector;

/**
 * Created by Matthias on 19.03.2017.
 */
public class VectorExample {
    public static void main(String[] args) {
        // Die Daten für das Table
        Vector data = new Vector();
        Vector rowA = new Vector();
        rowA.add("1");
        rowA.add("2");
        rowA.add("3");
        rowA.add("4");
        Vector rowB = new Vector();
        rowB.add("5");
        rowB.add("6");
        rowB.add("7");
        rowB.add("8");
        Vector rowC = new Vector();
        rowC.add("9");
        rowC.add("10");
        rowC.add("11");
        rowC.add("12");

        data.add(rowA);
        data.add(rowB);
        data.add(rowC);

        // Die Titel für das Table
        Vector title = new Vector();
        title.add("A");
        title.add("B");
        title.add("C");
        title.add("D");

        // Das JTable initialisieren
        JTable table = new JTable(data, title);

        JFrame frame = new JFrame("Demo");
        frame.getContentPane().add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

