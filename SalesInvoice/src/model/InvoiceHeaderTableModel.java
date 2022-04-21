/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.InvoiceFrame;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mahmoud
 */
public class InvoiceHeaderTableModel extends AbstractTableModel {

    private ArrayList<InvoiceHeader> invoicesArray;
    private String[] columns = {"Invoice Num", "Invoice Date", "Customer Name", "Invoice Total"};
    
    public InvoiceHeaderTableModel(ArrayList<InvoiceHeader> invoicesArray) {
        this.invoicesArray = invoicesArray;
    }

    @Override
    public int getRowCount() {
        return invoicesArray.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader invoice = invoicesArray.get(rowIndex);
        switch (columnIndex) {
            case 0: return invoice.getNumber();
            case 1: return InvoiceFrame.dateFormat.format(invoice.getInvoiceDate());
            case 2: return invoice.getCustomer();
            case 3: return invoice.getInvoiceTotal();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
