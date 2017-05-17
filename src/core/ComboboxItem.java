/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author WINDNCC
 */
public class ComboboxItem {
    private Object value;
    private String label;

    public ComboboxItem(String label, Object value) {
        this.value = value;
        this.label = label;
    }

    public Object getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return label;
    }
}
