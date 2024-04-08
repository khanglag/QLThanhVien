/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.QLTV;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author khang
 */
public class TableActionCellEditor extends DefaultCellEditor{

    private TableActionEvent event;
    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event=event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        //return super.getTableCellEditorComponent(table, value, isSelected, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        PanelAction ac = new PanelAction();
        ac.initEvent(event, row);
        ac.setBackground(table.getSelectionBackground());
        return ac;
    }
    
    
}
