package com.report.util;


import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {

    public static Connection getConnection() {

        // Using Oracle
        // You may be replaced by other Database.
        return SQLServerConnUtils.getSQLServerConnection_SQLJDBCAuthen();
//        return SQLServerConnUtils.getSQLServerConnection_SQLJDBC();
    }

    //
    // Test Connection ...
    //
    public static void main(String[] args) {

        System.out.println("Get connection ... ");

        // Get a Connection object

        Connection conn = ConnectionUtils.getConnection();

        System.out.println("Get connection " + conn);

        System.out.println("Done!");
    }
}
