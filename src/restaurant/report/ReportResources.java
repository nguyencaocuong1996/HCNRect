/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.report;

/**
 *
 * @author WINDNCC
 */
public class ReportResources {
    public static final String RP_BILL = ReportResources.class.getResource("source/IReportPayment.jrxml").toString().substring(6);
    public static final String RP_TOP_DISH_BY_MOTH = ReportResources.class.getResource("source/IReportTopDishByMoth.jrxml").toString().substring(6);
    public static final String RP_EOD_REVENUE = ReportResources.class.getResource("source/eod/IReportEODRevenue.jrxml").toString().substring(6);
    public static final String RP_EOD_DISH = ReportResources.class.getResource("source/eod/IReportEODDish.jrxml").toString().substring(6);
}
