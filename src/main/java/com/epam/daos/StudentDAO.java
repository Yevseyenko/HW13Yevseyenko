package com.epam.daos;

import com.epam.connect.ConnectorDB;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class StudentDAO {
    public Student getStudent(int Code_stud) {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectorDB.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM student WHERE Code_stud=" + Code_stud);
            if (rs.next()) {
                return extractStudentsFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public Set getAllStudents() {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectorDB.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM student");
            Set students = new HashSet();
            while (rs.next()) {
                Student student = extractStudentsFromResultSet(rs);
                students.add(student);
            }
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private Student extractStudentsFromResultSet(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setCode_stud(rs.getInt("Code_stud"));
        student.setStudent_name(rs.getString("Stud_name"));
        student.setStudent_surname(rs.getString("Stud_surname"));
        student.setStudent_middlename(rs.getString("Stud_middlename"));
        return student;
    }

    public boolean insertStudent(Student student) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectorDB.getConnection();
            ps = connection.prepareStatement("INSERT INTO student VALUES (? , ?, ?, ?)");
            ps.setInt(1, student.getCode_stud());
            ps.setString(2, student.getStudent_name());
            ps.setString(3, student.getStudent_surname());
            ps.setString(4, student.getStudent_middlename());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean updateStudent(Student student) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectorDB.getConnection();
            ps = connection.prepareStatement("UPDATE student SET Stud_code=?, Stud_name=?, Stud_surname=?, Stud_middlename=? WHERE Stud_code=?");
            ps.setInt(1, student.getCode_stud());
            ps.setString(2, student.getStudent_name());
            ps.setString(3, student.getStudent_surname());
            ps.setString(4, student.getStudent_middlename());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean deleteUser(int Stud_code) {
        Connection connection = null;
        Statement stmt = null;

        try {
            connection = ConnectorDB.getConnection();
            stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM student WHERE Stud_code=" + Stud_code);
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
    }
}
