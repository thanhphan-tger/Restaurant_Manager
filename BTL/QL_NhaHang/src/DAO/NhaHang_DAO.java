/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class NhaHang_DAO {
    private Connection connection = null;

    public Connection getConnection() {
        return connection;
    }
    PreparedStatement preStatement = null;
    Statement statement = null;
    
    private String db_server = "Tger_Phrey\\SQLEXPRESS";
    private String db_user = "sa";
    private String db_pass = "123";
    private String db_name = "QL_NhaHang";
    
    public NhaHang_DAO()
    {
        SQLServerDataSource db = new SQLServerDataSource();
        
        db.setServerName(db_server);
        db.setUser(db_user);
        db.setPassword(db_pass);
        db.setDatabaseName(db_name);
        db.setPortNumber(1433);
        db.setEncrypt(false);
        
        try {
            connection = db.getConnection();
        } catch (SQLServerException ex) {
            Logger.getLogger(NhaHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet selectData(String sql)
    {
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(NhaHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return rs;
    }
}
