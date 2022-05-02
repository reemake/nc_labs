package jdbc;

import java.sql.*;

public class H2Connector {

    private static final  String H2_URL = "jdbc:h2:~/test";
    private static final  String H2_USER = "sa";
    private static final  String H2_PASSWORD = "";

    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(H2_URL, H2_USER, H2_PASSWORD);
    }
}
