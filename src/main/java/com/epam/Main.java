package com.epam;
import com.epam.connect.ConnectorDB;
import com.epam.daos.Department;
import com.epam.daos.Student;
import com.epam.daos.StudentDAO;
import com.epam.databaseinfo.DataBaseInfo;
import com.epam.dbcreation.DbCreation;
import com.epam.transactions.TransactionPerform;
import com.epam.transformer.GenericTransformer;
import org.apache.log4j.Logger;


import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    final static Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        try {
            Connection con = ConnectorDB.getConnection();
            PreparedStatement stm =con.prepareStatement("SELECT * FROM department");
            ResultSet rs =stm.executeQuery();
            List <Department> depart =GenericTransformer.ResultSetToListOfObjects(rs,Department.class);
            log.info(depart);
        } catch (SQLException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
/*
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
        */
    }

}
