
package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class lib {

    public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=swp201c;user=sa;password=123;encrypt=false";
    public static final Connection getConnection() throws ClassNotFoundException{
        Connection con = null;
        try{
            Class.forName(driverName);
            con=DriverManager.getConnection(dbURL);
            System.out.println("connection successlly");
        }catch(SQLException e){
            System.out.println("error "+ e );
        }
        return con;
    }
    // ngắt kết nối 
    public static final void getClose(Connection con) throws SQLException{
         try {
            if (con != null) {
                con.close();
                System.out.println("Connection closed successfully.");
            } else {
                System.out.println("Connection is null.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(lib.class.getName()).log(Level.SEVERE, "Exception in closeConnection", ex);
            System.out.println("Failed to close connection.");
        }
    }
}
