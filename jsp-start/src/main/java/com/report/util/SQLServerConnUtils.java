package com.report.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnUtils {

    // Connect to SQLServer
    // (Using JDBC Driver: SQLJDBC)
    public static Connection getSQLServerConnection_SQLJDBC() {
        String hostName = "localhost";
        // String sqlInstanceName = "SQLEXPRESS";
        String database = "DuLieuCan";
        String userName = "sa";
        String password = "123";

        return getSQLServerConnection_SQLJDBC(hostName,
                database, userName, password);
    }

    // Connect to SQLServer
    // (Using JDBC Driver: SQLJDBC)
    private static Connection getSQLServerConnection_SQLJDBC(String hostName,
                                                             String database, String userName,
                                                             String password) {
        try {
            // Declare the class Driver for SQLServer DB
            // This is necessary with Java 5 (or older)
            // Java6 (or newer) automatically find the appropriate driver.
            // If you use Java> 5, then this line is not needed.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // jdbc:sqlserver://ServerIp:1433/SQLEXPRESS;databaseName=simplehr
            String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" + ";databaseName=" + database;

            Connection conn = DriverManager.getConnection(connectionURL, userName,
                    password);
            return conn;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}