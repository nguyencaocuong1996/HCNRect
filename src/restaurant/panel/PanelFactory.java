/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel;

import assets.images.icons.IconResources;
import javax.swing.JPanel;
import restaurant.panel.booktable.JPanelBookTable;
import restaurant.panel.header.JPanelHeader;
import restaurant.panel.main.JPanelWelcome;
import restaurant.panel.order.JPanelOrderPickTable;
import restaurant.panel.order.JPanelOrder;
import restaurant.panel.ppackkage.JPanelManagementDish;
import restaurant.panel.ppackkage.JPanelManagementMaterial;
import restaurant.panel.ppackkage.JPanelManagementTable;
import restaurant.panel.provider.debt.JPanelManagementReceiptVoucherProvider;
import restaurant.panel.report.JPanelReportDetails;
import restaurant.panel.report.JPanelReportEndOfDay;
import restaurant.panel.staff.JPanelManagementStaff;
import restaurant.panel.transaction.bill.JPanelListBill;
import restaurant.panel.transaction.coupon.JPanelManagementCoupon;
import restaurant.panel.transaction.receipt.JPanelListReceipt;
/**
 *
 * @author WINDNCC
 */
public class PanelFactory {
    private static JPanelHeader headerOverview;
    private static JPanelHeader headerOrderPickTable;
    private static JPanelHeader headerOrder;
    private static JPanelHeader headerBookTable;
    private static JPanelHeader headerPackageMaterial;
    private static JPanelHeader headerPackageDish;
    private static JPanelHeader headerPackageTable;
    private static JPanelHeader headerReport;
    private static JPanelHeader headerImportMaterial;
    private static JPanelHeader headerManageStaff;
    private static JPanelHeader headerListBill;
    private static JPanelHeader headerListReceipt;
    private static JPanelHeader headerManagementCoupon;
    private static JPanelHeader headerManagementRVP;
    private static JPanelWelcome overview;
    private static JPanelSidebar sidebar;
    private static JPanelManagementDish managementDish;
    private static JPanelManagementTable managementTable;
    private static JPanelManagementMaterial managementMaterial;
    private static JPanelReportEndOfDay reportEndOfDay;
    private static JPanelReportDetails reportDetails;
    public class ID{
            public static final int SIDEBAR = 1;
            //content
            public static final int ORDER = 111;
            public static final int ORDER_PICK_TABLE = 112;
            public static final int BOOK_TABLE = 121;
            public static final int OVERVIEW = 131;
            public static final int PACKAGE_DISH = 141;
            public static final int PACKAGE_TABLE = 142;
            public static final int PACKAGE_MATERIAL = 143;
            public static final int REPORT_END_OF_DAY = 151;
            public static final int REPORT_DETAILS = 152;
            public static final int MANAGE_STAFF = 161;
            public static final int TRANS_BILL = 171;
            public static final int TRANS_RECEIPT = 172;
            public static final int TRANS_COUPON = 173;
            public static final int TRANS_RVP = 174;
            //header
            public static final int HEADER_OVERVIEW = 211;
            public static final int HEADER_ORDER_PICK_TABLE = 221;
            public static final int HEADER_ORDER = 231;
            public static final int HEADER_BOOK_TABLE = 241;
            public static final int HEADER_PACKAGE_MATERIAL = 251;
            public static final int HEADER_PACKAGE_DISH = 252;
            public static final int HEADER_PACKAGE_TABLE = 253;
            public static final int HEADER_PACKAGE_IMPORT_MATERIAL = 254;
            public static final int HEADER_REPORT = 261;
            public static final int HEADER_MANAGE_STAFF = 271;
            public static final int HEADER_TRANS_BILL = 281;
            public static final int HEADER_TRANS_RECEIPT_NOTE = 282;
            public static final int HEADER_TRANS_COUPON = 283;
            public static final int HEADER_TRANS_RVP = 284;
    }
    public static JPanel get(int panelId){
        JPanel jp;
        switch(panelId){
            case ID.SIDEBAR:
                if (sidebar == null) sidebar = new JPanelSidebar();
                jp = sidebar;
                break;
                
            case ID.OVERVIEW:
                if(overview == null) overview  = new JPanelWelcome();
                jp = overview;
                break;
                
            case ID.ORDER:
                jp = JPanelOrder.getInstance();
                break;
                
            case ID.ORDER_PICK_TABLE:
                jp = JPanelOrderPickTable.getInstance();
                break;
                
            case ID.BOOK_TABLE:
                jp = JPanelBookTable.getInstance();
                break;
            case ID.MANAGE_STAFF:
                jp = JPanelManagementStaff.getInstance();
                break;
                
            case ID.HEADER_OVERVIEW:
                if (PanelFactory.headerOverview == null) headerOverview = new JPanelHeader("Giới thiệu", IconResources.BOOKTABLE);
                jp = headerOverview;
                break;
                
            case ID.HEADER_ORDER:
                if(PanelFactory.headerOrder == null) headerOrder = new JPanelHeader("Gọi món", IconResources.ORDER, ID.ORDER_PICK_TABLE, ID.HEADER_ORDER_PICK_TABLE);
                jp = headerOrder;
                break;
                
            case ID.HEADER_BOOK_TABLE:
                if (headerBookTable == null) headerBookTable = new JPanelHeader("Danh sách đặt bàn", IconResources.BOOKTABLE);
                jp = headerBookTable;
                break;
                
            case ID.HEADER_ORDER_PICK_TABLE:
                if (headerOrderPickTable == null) headerOrderPickTable = new JPanelHeader("Chọn bàn", IconResources.BOOKTABLE);
                jp = headerOrderPickTable;
                break;
            // package
            case ID.HEADER_PACKAGE_DISH:
                if(headerPackageDish == null) headerPackageDish = new JPanelHeader("Quản lý món ăn", IconResources.PRAWN_WHITE_X50 );
                jp = headerPackageDish;
                break;
            case ID.HEADER_PACKAGE_IMPORT_MATERIAL:
                if(headerImportMaterial == null) headerImportMaterial = new JPanelHeader("Nhập kho", IconResources.COINS, PanelFactory.ID.PACKAGE_MATERIAL, PanelFactory.ID.HEADER_PACKAGE_MATERIAL);
                jp = headerImportMaterial;
                break;
            case ID.HEADER_REPORT:
                if (headerReport == null) {
                    headerReport = new JPanelHeader("Báo cáo", IconResources.PRAWN_WHITE_X50 );
                }
                jp = headerReport;
                break;
            case ID.PACKAGE_DISH:
                if(managementDish == null) managementDish = new JPanelManagementDish();
                jp = managementDish;
                break;
            case ID.HEADER_PACKAGE_MATERIAL:
                if(headerPackageMaterial == null) headerPackageMaterial = new JPanelHeader("Quản lý nguyên liệu", IconResources.COINS);
                jp = headerPackageMaterial;
                break;
            case ID.PACKAGE_MATERIAL:
                if (managementMaterial == null) {
                    managementMaterial = JPanelManagementMaterial.getInstance();
                }
                jp = managementMaterial;
                break;
            case ID.HEADER_PACKAGE_TABLE:
                if (headerPackageTable == null) {
                    headerPackageTable = new JPanelHeader("Quản lý bàn ăn", IconResources.ORDER_WHITE_X50);
                }
                jp = headerPackageTable;
                break;
            case ID.PACKAGE_TABLE:
                if(managementTable == null){
                    managementTable = JPanelManagementTable.getInstance();
                }
                jp = managementTable;
                break;
            //end package
            //report
            case ID.REPORT_END_OF_DAY:
                if(reportEndOfDay == null) reportEndOfDay = new JPanelReportEndOfDay();
                jp = reportEndOfDay;
                break;
            case ID.REPORT_DETAILS:
                if(reportDetails == null) reportDetails = new JPanelReportDetails();
                jp = reportDetails;
                break;
            case ID.HEADER_MANAGE_STAFF:
                if(headerManageStaff == null) headerManageStaff = new JPanelHeader("Quản lý nhân viên", IconResources.COINS);
                jp = headerManageStaff;
                break;   
            //#report
            //Transaction
            case ID.HEADER_TRANS_BILL:
                if (headerListBill == null) {
                    headerListBill = new JPanelHeader("Lịch sử hóa đơn", IconResources.ORDER);
                }
                jp = headerListBill;
                break;
            case ID.TRANS_BILL:
                jp = JPanelListBill.getInstance();
                break;
            case ID.HEADER_TRANS_RECEIPT_NOTE:
                if (headerListReceipt == null) {
                    headerListReceipt = new JPanelHeader("Lịch sử nhập hàng", IconResources.ORDER);
                }
                jp = headerListReceipt;
                break;
            case ID.TRANS_RECEIPT:
                jp = JPanelListReceipt.getInstance();
                break;
            case ID.HEADER_TRANS_COUPON:
                if (headerManagementCoupon == null) {
                    headerManagementCoupon = new JPanelHeader("Phiếu khuyến mãi", IconResources.ORDER);
                }
                jp = headerManagementCoupon;
                break;
            case ID.TRANS_COUPON:
                jp = JPanelManagementCoupon.getInstance();
                break;
            case ID.HEADER_TRANS_RVP:
                if (headerManagementRVP == null) {
                    headerManagementRVP = new JPanelHeader("Phiếu chi cho NCC", IconResources.ORDER);
                }
                jp = headerManagementRVP;
                break;
            case ID.TRANS_RVP:
                jp = JPanelManagementReceiptVoucherProvider.getInstance();
                break;
            //#Transaction
            default:
                jp = new JPanel();
                break;
        }
        return jp;
    }
}
