package Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gas4", "root", "ampuero");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gas4", "root", "alianza");

        } catch (Exception e) {
            System.err.println("Error" + e);
        }
    }

    public Connection getConnection() {
        return con;
    }
}
