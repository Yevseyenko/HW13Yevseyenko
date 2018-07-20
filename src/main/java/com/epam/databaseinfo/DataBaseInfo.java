package com.epam.databaseinfo;

import com.epam.connect.ConnectorDB;
import org.apache.log4j.Logger;

import java.sql.*;

public class DataBaseInfo {
    final static Logger log = Logger.getLogger(DataBaseInfo.class);

    public void showDatabase() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        DatabaseMetaData md;
        ResultSet rs;
        try {
            connection = ConnectorDB.getConnection();
            md = connection.getMetaData();
            statement = connection.createStatement();
            log.info("Database URL() - " + md.getURL());
            log.info("Database Username()- " + md.getUserName());
            log.info("Database ProductVersion - " + md.getDatabaseProductVersion());
            log.info("Database DriverMajorVersion - " + md.getDriverMajorVersion());
            log.info(" Database DriverMinorVersion - " + md.getDriverMinorVersion());
            log.info("Database MaxRowSize - " + md.getMaxRowSize());
            log.info("Database MaxStatementLength - " + md.getMaxStatementLength());
            log.info(" Database MaxTablesInSelect - " + md.getMaxTablesInSelect());
            log.info("Database TypeInfo");
            ResultSet resultSet = md.getColumns(null, null, "student", null);
            while (resultSet.next()) {
                String name = resultSet.getString("COLUMN_NAME");
                String type = resultSet.getString("TYPE_NAME");
                int size = resultSet.getInt("COLUMN_SIZE");
                log.info("Column name: [" + name + "]; type: [" + type + "]; size: [" + size + "]");
            }
            rs = md.getTableTypes();
            while (rs.next()) {
                log.info(rs.getString(1));
            }
            log.info("Database Tables:");
            rs = md.getTables("students", "", "%", new String[0]);
            while (rs.next()) {
                log.info(rs.getString("TABLE_NAME"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }

        }
    }
}

