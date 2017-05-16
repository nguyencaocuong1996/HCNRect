/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.InsertData;

/**
 *
 * @author WINDNCC
 */
public class Database {
    private static Connection conn = null;
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
              URL = "jdbc:mysql://johnny.heliohost.org:3306/windncc_restaurant?useUnicode=yes&characterEncoding=UTF-8";
              USER = "windncc_cuongdt";
              PASS = "db123456";
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = (Connection) DriverManager.getConnection(URL, USER, PASS);
        } catch(SQLException ex) {
             Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    
    public static void insert(String tableName, HashMap insertData){
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
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
}   
public static void update(String tableName, HashMap updateData, String conditionStr){
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
        String sql = "UPDATE " + tableName + " SE T " + dataStr + " WHERE " + conditionStr;
//        System.out.println(sql);
        try {
            Statement stmt = (Statement) con.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
}

public static void delete(String tableName, String conditionStr){
        Connection con = Database.getConnection();
        String sql = "DELETE FROM " + tableName + " WHERE " + conditionStr;
//        System.out.println(sql);
        try {
            Statement stmt = (Statement) con.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.toString());
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
