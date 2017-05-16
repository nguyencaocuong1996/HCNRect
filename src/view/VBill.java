/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import modal.Customer;
import modal.Dish;
import modal.Staff;

/**
 *
 * @author WINDNCC
 */
public class VBill {
    protected int billId;
    protected Customer customer;
    protected Staff staff;
    protected ArrayList<Dish> listDish;
    protected float invoiceValue;
}
