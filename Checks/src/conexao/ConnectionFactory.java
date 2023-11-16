/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;
/**
 *
 * @author POSTO
 */
public class ConnectionFactory {
    private final String DRIVER ="com.mysql.jdbc.Driver";
    private final String URL ="jdbc:mysql://localhost:3306/cheques";
    private final String USER ="root";
    private final String PASS ="";
    
    public Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw  new RuntimeException("Conexão Falhou", ex);
        }
    };
    public static void closeConnection(Connection con) throws SQLException{
            if(con!=null){
                con.close();
            }
    };
    public static void closeConnection(Connection con, PreparedStatement stmt) throws SQLException{
            con.close();
            if(con != null){
                stmt.close();
            } 
    };
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) throws SQLException{
        con.close();
        stmt.close();
        if(rs != null){
            rs.close();
        }
    }
        
}
