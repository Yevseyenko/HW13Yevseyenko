package com.epam.transactions;

import com.epam.connect.ConnectorDB;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionPerform {
    final static Logger log = Logger.getLogger(TransactionPerform.class);

    public void runTransaction() throws SQLException {
        String insertTableSQL = "INSERT INTO student(Code_stud, Student_name, Student_surname, Student_middlename) VALUES(?,?,?,?)";
        String updateTableSQL = "UPDATE student SET Code_stud =? WHERE Code_stud = ?";
        String deleteFromTableSQL = "DELETE FROM student WHERE Code_stud= ?";
        Connection connection = null;
        PreparedStatement firstStatement = null;
        PreparedStatement secondStatement = null;
        PreparedStatement thirdStatement = null;
        try {
            connection = ConnectorDB.getConnection();
            connection.setAutoCommit(false);
            firstStatement = connection.prepareStatement(insertTableSQL);
            firstStatement.setInt(1, 9);
            firstStatement.setString(2, "Petro");
            firstStatement.setString(3, "Andrusiv");
            firstStatement.setString(4, "Stepanovych");
            firstStatement.executeUpdate();
            secondStatement = connection.prepareStatement(updateTableSQL);
            secondStatement.setInt(1, 2);
            secondStatement.setInt(2, 1);
            secondStatement.executeUpdate();
            thirdStatement = connection.prepareStatement(deleteFromTableSQL);
            thirdStatement.setInt(1, 1);
            thirdStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            log.info(e.getMessage());
            connection.rollback();
        } finally {
            if (firstStatement != null) {
                firstStatement.close();
            }

            if (secondStatement != null) {
                secondStatement.close();
            }
            if (thirdStatement != null) {
                thirdStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
