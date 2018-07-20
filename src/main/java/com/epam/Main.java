package com.epam;
import com.epam.daos.Student;
import com.epam.daos.StudentDAO;
import com.epam.databaseinfo.DataBaseInfo;
import com.epam.dbcreation.DbCreation;
import com.epam.transactions.TransactionPerform;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        DbCreation db = new DbCreation();
        try {
            db.createDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Student stud = new Student(5, "Володимир", "Богданов", "Данилович");
        StudentDAO studDao = new StudentDAO();
        studDao.insertStudent(stud);
        DataBaseInfo dataBaseInfo = new DataBaseInfo();
        try {
            dataBaseInfo.showDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TransactionPerform transaction = new TransactionPerform();
        try {
            transaction.runTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
