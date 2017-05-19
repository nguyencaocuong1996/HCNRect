/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


/**
 *
 * @author WINDNCC
 */
public abstract class View {
    protected ViewData data;
    protected ViewData filterData;
    protected static View instance;
    public ViewData getData() {
        return data;
    }

    public ViewData getFilterData() {
        return filterData;
    }
    
    public void filter(FilterView fw){
        filterData.removeAll(filterData);
        data.forEach((t) -> {
            if (fw.filter(t)) {
                filterData.add(t);
            }
        });
    }
}
