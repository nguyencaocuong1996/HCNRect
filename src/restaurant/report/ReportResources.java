/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.report;

import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author WINDNCC
 */
public class ReportResources {
    public static final String RP_BILL = ReportResources.class.getResource("source/IReportPayment.jrxml").toString().substring(6);
    public static final String RP_TOP_DISH_BY_MOTH = ReportResources.class.getResource("source/IReportTopDishByMoth.jrxml").toString().substring(6);
    public static final String RP_EOD_REVENUE = ReportResources.class.getResource("source/eod/IReportEODRevenue.jrxml").toString().substring(6);
    public static final String RP_EOD_DISH = ReportResources.class.getResource("source/eod/IReportEODDish.jrxml").toString().substring(6);
    public static final String RECEIVE_MOTH = ReportResources.class.getResource("source/details/IReportReceiveMonth.jrxml").toString().substring(6);
    public static final String RECEIVE_YEAR = ReportResources.class.getResource("source/details/IReportReceiveYear.jrxml").toString().substring(6);
    public static final String RECEIVE_RANGE = ReportResources.class.getResource("source/details/IReportReceiveRange.jrxml").toString().substring(6);
    public static final String RECEIPT_NOTE = ReportResources.class.getResource("source/IReportReceiptNote.jrxml").toString().substring(6);
//    public static final String DISH_RANGE = ReportResources.class.getResource("source/eod/IReportDetailDishRange.jrxml").toString().substring(6);
    public static void showReport(String url, Map<String, Object> params) throws JRException
    {
        JasperReport jR = JasperCompileManager.compileReport(url);
        JasperPrint jP = JasperFillManager.fillReport(jR, params, database.Database.getConnection());
        JasperViewer.viewReport(jP,false);
    }
}
