package com.sabel.jtablereferat.gui;

import com.sabel.jtablereferat.model.Contact;
import com.sabel.jtablereferat.model.ContactService;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthias on 19.03.2017.
 */
public class ContactTableModel implements TableModel {
    private List<TableModelListener> listeners;
    private ContactService cs = new ContactService();

    public ContactTableModel() {
        this.listeners = new ArrayList<>();
        this.cs = new ContactService();
    }

    @Override
    public int getRowCount() {
        return cs.getSize();
    }

    @Override
    public int getColumnCount() {
        return cs.getHeader().length - 1;
    }

    @Override
    public String getColumnName(int i) {
        if (i < cs.getHeader().length) {
            String[] titles = cs.getHeader();
            return titles[i];
        }
        throw new IllegalArgumentException("Wrong column");
    }

    @Override
    public Class<?> getColumnClass(int i) {
        switch (i) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            default:
                throw new IllegalArgumentException("Wrong column");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (rowIndex == 0) {
            return false;
        }
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return cs.getContact(rowIndex).getID();
            case 1:
                return cs.getContact(rowIndex).getFirstname();
            case 2:
                return cs.getContact(rowIndex).getName();
            case 3:
                return cs.getContact(rowIndex).getEmail();
            case 4:
                return cs.getContact(rowIndex).getNummer();
            default:
                throw new IllegalArgumentException("Wrong column");
        }
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        Contact contact = cs.getContact(rowIndex);

        switch (columnIndex) {
            case 0:
                break;
            case 1:
                contact.setFirstname((String) o);
                break;
            case 2:
                contact.setName((String) o);
                break;
            case 3:
                contact.setEmailAddress((String) o);
                break;
            case 4:
                contact.setPhoneNumber((String) o);
                break;
            default:
                throw new IllegalArgumentException("Wrong column");
        }
        cs.setContact(contact);
        TableModelEvent event = new TableModelEvent(this, rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, TableModelEvent.UPDATE);
        for (TableModelListener listener : listeners) {
            listener.tableChanged(event);
        }
    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {
        listeners.add(tableModelListener);
    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {
        listeners.remove(tableModelListener);
    }

    public void addContact(Contact contact) {
        cs.add(contact);
        int row = cs.getSize();

        TableModelEvent event = new TableModelEvent(this, row, row, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        for (TableModelListener listener : listeners) {
            listener.tableChanged(event);
        }
    }

    public void removeContact( int row) {
        cs.remove(row);
        TableModelEvent event = new TableModelEvent(this, row, row, TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
        for (TableModelListener listener : listeners) {
            listener.tableChanged(event);
        }
    }
}
