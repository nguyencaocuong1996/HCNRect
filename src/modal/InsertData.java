package modal;
import database.Database;
import java.sql.SQLException;
import java.util.HashMap;
/**
 *
 * @author WINDNCC
 */
public class InsertData {
    protected HashMap data = new HashMap();
    protected String tableName;

    public InsertData(MDish dish) {
        tableName = "mon_an";
        this.data.put("TenMA", dish.getName());
        this.data.put("GiaMA", dish.getPrice());
        this.data.put("DiaChiAnhMA", dish.getImageUrl());
    }
    public InsertData(MMaterial material) {
        tableName = "nguyen_lieu";
        this.data.put("TenNL", material.getName());
        this.data.put("SoLuongTon", material.getInStock());
        this.data.put("DonVi", material.getUnit());
        this.data.put("MucToiThieu", material.getMinInStock());
    }
    public InsertData(MProvider provider) {
        tableName = "nha_cung_cap";
        this.data.put("TenNCC", provider.getName());
        this.data.put("SDTNCC", provider.getPhone());
        this.data.put("DiaChiNCC", provider.getAddress());
        this.data.put("MoTaNCC", provider.getDescription());
    }
    
    public InsertData(MReceiptNote receiptNote){
        tableName = "phieu_nhap_hang";
        this.data.put("MaPNH", receiptNote.getId());
        this.data.put("MaNCC", receiptNote.getProviderId());
        this.data.put("NgayNhapHang", receiptNote.getDate());
        this.data.put("TriGiaPNH", receiptNote.getTotalReceipt());
        this.data.put("SoTienDaTra", receiptNote.getPayAmount());
    }
    public InsertData(MReceiptNoteDetail receiptNoteDetail){
        tableName = "chi_tiet_phieu_nhap";
        this.data.put("MaPNH", receiptNoteDetail.getReceiptNoteId());
        this.data.put("MaNL", receiptNoteDetail.getMaterialId());
        this.data.put("SoLuongNhap", receiptNoteDetail.getQty());
        this.data.put("GiaNhap", receiptNoteDetail.getPrice());
    }
    public HashMap getData() {
        return data;
    }
    public String getTableName() {
        return tableName;
    }
    public void execute() throws SQLException
    {
        try {
            Database.insert(this.tableName, this.data);
        } catch (SQLException e) {
            throw e;
        }
      
    }
}
