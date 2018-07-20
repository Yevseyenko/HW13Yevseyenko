package com.epam.dbcreation;

import com.epam.transactions.TransactionPerform;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbCreation {
    final static Logger log = Logger.getLogger(DbCreation.class);

    public static Connection connectToDB(String username, String password) {
        try {
          //  Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sys?allowPublicKeyRetrieval=true&useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Properties objProperties = new Properties();
            objProperties.put("user", username);
            objProperties.put("password", password);
            objProperties.put("useUnicode", "true");
            objProperties.put("characterEncoding", "utf-8");

            Connection con = DriverManager.getConnection(url, objProperties);
            return con;
        } catch (Exception ex) {
            log.info("Connection to sql database failed.");
            ex.printStackTrace();
            return null;
        }
    }

    public void createDB() throws SQLException {
        Connection con = connectToDB("root", "1111");
        String q = "";
        File f = new File("src/main/resources/student.sql");
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            String line =null;
            line = bf.readLine();
            while (line != null) {
                q = q + line + "\n";
                line = bf.readLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String[] commands = q.split(";");
        Statement statement = null;
        try {
            statement = con.createStatement();
            for (String s : commands) {
                statement.execute(s);
            }
        } catch (Exception ex) {
            log.info(ex.getMessage());
        } finally {
            if (con != null) {
                con.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }
}
