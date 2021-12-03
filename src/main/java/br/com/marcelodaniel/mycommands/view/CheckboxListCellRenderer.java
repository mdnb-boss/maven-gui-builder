/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.marcelodaniel.mycommands.view;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author marcelo
 */
public class CheckboxListCellRenderer extends JCheckBox implements ListCellRenderer<String> {

    public Component getListCellRendererComponent(JList<? extends String> jlist, String value, int i, boolean isSelected, boolean bln1) {

//        setComponentOrientation(jlist.getComponentOrientation());
//        setFont(jlist.getFont());
        setBackground(jlist.getBackground());
        setForeground(jlist.getForeground());
        setSelected(isSelected);
//        setEnabled(jlist.isEnabled());
//
//        setText(value == null ? "" : value.toString());  

        setText(value);

        return this;
    }
  
}
