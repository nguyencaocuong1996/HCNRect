/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import modal.MCustomer;
import modal.MDish;
import modal.MStaff;

/**
 *
 * @author WINDNCC
 */
public class VBill {
    protected int billId;
    protected MCustomer customer;
    protected MStaff staff;
    protected ArrayList<MDish> listDish;
    protected float invoiceValue;
}
