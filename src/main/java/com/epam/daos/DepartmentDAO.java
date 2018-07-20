package com.epam.daos;

import com.epam.connect.ConnectorDB;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {

    public Set getAllDepartments() {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = ConnectorDB.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM department");
            Set departments = new HashSet();
            while (rs.next()) {
                Department department = extractDepartmentFromResultSet(rs);
                departments.add(department);
            }
            return departments;
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
            if (rs != null) {
                try {
                    rs.close();
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

    private Department extractDepartmentFromResultSet(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setCode_spec(rs.getInt("Code_spec"));
        department.setSpeciality_name(rs.getString("Speciality_name"));
        department.setSpeciality_description(rs.getString("Speciality_description"));
        return department;
    }

    public boolean insertDepartment(Department department) {
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            ps = connection.prepareStatement("INSERT INTO department VALUES ( ?, ?, ?)");
            ps.setInt(1, department.getCode_spec());
            ps.setString(2, department.getSpeciality_name());
            ps.setString(3, department.getSpeciality_description());

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

    public boolean updateDepartment(Department department) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectorDB.getConnection();
            ps = connection.prepareStatement("UPDATE department SET Code_spec=?, Speciality_name=?, Speciality_description=? WHERE Code_spec=?");
            ps.setInt(1, department.getCode_spec());
            ps.setString(2, department.getSpeciality_name());
            ps.setString(3, department.getSpeciality_description());

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

    public boolean deleteDepartment(int Code_spec) {
        Connection connection = null;
        Statement stmt = null;
        try {
            connection = ConnectorDB.getConnection();
            stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM department WHERE Code_spec=" + Code_spec);
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
        }
        return false;
    }
}
