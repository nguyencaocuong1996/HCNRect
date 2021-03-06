/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.InsertData;
import modal.ModalData;
import view.ViewData;
import view.ViewItem;

/**
 *
 * @author WINDNCC
 */
public class Database {
    public static Connection conn = null;
    private static String URL;
    private static String USER;
    private static String PASS;

    /**
     *
     * @return
     */ 
    public static Connection getConnection(){
//        Properties prop = new Properties();
        try{
//            prop.load(new FileReader(new File("configdb.properties")));
//            URL = prop.getProperty("url");
//            USER = prop.getProperty("user");
//            PASS = prop.getProperty("password");
              URL = "jdbc:mysql://localhost:3306/restaurant?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Saigon&useTimezone=yes";
              USER = "root";
              PASS = "";
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = (Connection) DriverManager.getConnection(URL, USER, PASS);
            
        } catch(SQLException ex) {
             Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static boolean rawUpdate(String query){
        Connection con = Database.getConnection();
        int row = 0;
        try {
            Statement stmt = (Statement) con.createStatement();
            row = stmt.executeUpdate(query);
            closeConnection();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return row > 0;
}
    
    public static void insert(String tableName, HashMap insertData) throws SQLException{
        Connection con = Database.getConnection();
        Set setInsert = (Set) insertData.entrySet();
        Iterator itDataInsert = setInsert.iterator();
        String columns = new String();
        String values = new String();
        while (itDataInsert.hasNext()) {
            Map.Entry nextElement = (Map.Entry) itDataInsert.next();
            if (columns.isEmpty()) {
                columns += "`" + nextElement.getKey() + "`";
            } else {
                columns += ",`" + nextElement.getKey() + "`";
            }
            if(values.isEmpty()){
                values += "'" + nextElement.getValue() + "'";
            } else {
                values += ",'" + nextElement.getValue() + "'";
            }
        }
        String sql = "INSERT INTO " + tableName + "(" + columns + ") VALUES(" + values + ")";
        try {
            Statement stmt = (Statement) con.createStatement();
            int row = stmt.executeUpdate(sql);
            closeConnection();
        } catch (SQLException e) {
            throw e;
        }
}   
public static void update(String tableName, HashMap updateData, String conditionStr) throws SQLException{
        Connection con = Database.getConnection();
        Set setInsert = (Set) updateData.entrySet();
        Iterator itDataInsert = setInsert.iterator();
        String dataStr = new String();
        while (itDataInsert.hasNext()) {
            Map.Entry nextElement = (Map.Entry) itDataInsert.next();
            if (!dataStr.isEmpty()) {
                dataStr +=", ";
            }
            if(nextElement.getValue() instanceof String){
                dataStr += "`" + nextElement.getKey() + "` = '" + nextElement.getValue() + "'";
            } else {
                dataStr += "`" + nextElement.getKey() + "` = " + nextElement.getValue();
            }
        }
        String sql = "UPDATE " + tableName + " SET " + dataStr + " WHERE " + conditionStr;
//        System.out.println(sql);
        try {
            Statement stmt = (Statement) con.createStatement();
            stmt.executeUpdate(sql);
            closeConnection();
        } catch (SQLException e) {
            throw e;
        }
}

public static void delete(String tableName, String conditionStr) throws SQLException{
        Connection con = Database.getConnection();
        String sql = "DELETE FROM " + tableName + " WHERE " + conditionStr;
//        System.out.println(sql);
        try {
            Statement stmt = (Statement) con.createStatement();
            stmt.executeUpdate(sql);
            closeConnection();
        } catch (SQLException e) {
            throw e;
        }
}

public static ViewData viewSelect(String query) throws SQLException{
        ViewData resViewData = new ViewData();
        Connection con = Database.getConnection();
        try {
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while(rs.next()){
                ViewItem item = new ViewItem();
                for (int i = 1; i <= columnCount; i++) {
                    item.put(rsmd.getColumnName(i), rs.getObject(rsmd.getColumnName(i)));
                }
                resViewData.add(item);
            }
            closeConnection();
            return resViewData;
        } catch (SQLException e) {
            throw e;
        }
}
public static ModalData modalSelect(String query) throws SQLException{
        ModalData resModalData = new ModalData();
        Connection con = Database.getConnection();
        query += " LIMIT 0,1";
        try {
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while(rs.next()){
                for (int i = 1; i <= columnCount; i++) {
                    resModalData.put(rsmd.getColumnName(i), rs.getObject(rsmd.getColumnName(i)));
                }
                break;
            }
            closeConnection();
            return resModalData;
        } catch (SQLException e) {
            throw e;
        }
}
    
    
    public static void closeConnection(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
