/**
 *
 * @author ASUS ROG
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class config {
    
    private static Connection MySQLConfig;
    static Connection getConnection;
    public static Connection configDB()throws SQLException{
        try {
           String url="jdbc:mysql://localhost:3306/db_rumahsakit";
           String user="root";
           String pass="";
           
           DriverManager.registerDriver(new com.mysql.jdbc.Driver());
           MySQLConfig=DriverManager.getConnection(url, user, pass);
           
        } catch (SQLException e){
            System.out.println("koneksi gagal "+e.getMessage());
        }
        return MySQLConfig;
    }
}

