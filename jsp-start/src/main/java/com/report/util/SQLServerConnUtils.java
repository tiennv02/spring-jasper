package com.report.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLServerConnUtils {

    // Connect to SQLServer
    // (Using JDBC Driver: SQLJDBC)
    public static Connection getSQLServerConnection_SQLJDBC() {
//        try {
//            String pro= "\\application.properties";
//            Properties prop = new Properties();
//            FileInputStream in = new FileInputStream(pro);
//            prop.load(in);
//            in.close();
//
//            String url = prop.getProperty("spring.datasource.url");
//            String driver = prop.getProperty("spring.datasource.driverClassName");
//            String username = prop.getProperty("spring.datasource.username");
//            String password = prop.getProperty("spring.datasource.password");
//
//            return getSQLServerConnection_SQLJDBC(url, driver, username, password);
//        } catch (IOException e) {
//            //e.printStackTrace();
//        }
        return getSQLServerConnection_SQLJDBC("jdbc:sqlserver://localhost;databaseName=DuLieuCan", "com.microsoft.sqlserver.jdbc.SQLServerDriver", "sa", "a@123456");//a@123456
    }

    // Connect to SQLServer
    // (Using JDBC Driver: SQLJDBC)
    private static Connection getSQLServerConnection_SQLJDBC(String url,
                                                             String driver,
                                                             String userName,
                                                             String password) {
        try {
            // Declare the class Driver for SQLServer DB
            // This is necessary with Java 5 (or older)
            // Java6 (or newer) automatically find the appropriate driver.
            // If you use Java> 5, then this line is not needed.
            Class.forName(driver);

            String connectionURL = url;

            Connection conn = DriverManager.getConnection(connectionURL, userName,
                    password);
            return conn;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}