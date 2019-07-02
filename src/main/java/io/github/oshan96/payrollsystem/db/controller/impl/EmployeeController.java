package io.github.oshan96.payrollsystem.db.controller.impl;

import io.github.oshan96.payrollsystem.db.connection.DBConnection;
import io.github.oshan96.payrollsystem.db.controller.DBController;
import io.github.oshan96.payrollsystem.model.db.Employee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author oshan
 */
public class EmployeeController implements DBController<Employee> {
    private Connection connection;

    public EmployeeController() throws SQLException, IOException, ClassNotFoundException {
        connection = DBConnection.getInstance().getConnection();
    }

    @Override
    public boolean add(Employee employee) throws SQLException {
        String sql = "INSERT INTO post VALUES (?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1,employee.getId());
        stm.setObject(2,employee.getName());
        stm.setObject(3,employee.getAddress());
        stm.setObject(4,employee.getNic());
        stm.setObject(5,employee.getDob());
        stm.setObject(6,employee.getPost().getId());

        return stm.executeUpdate() > 0;
    }

    @Override
    public Employee get(String id) throws Exception {
        PostController pCon = new PostController();

        String sql = "SELECT * FROM employee WHERE id=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1,id);
        ResultSet rst = stm.executeQuery();

        rst.next();

        return new Employee(
                rst.getString(1),
                rst.getString(2),
                rst.getString(3),
                rst.getString(4),
                rst.getString(5),
                pCon.get(rst.getString(6))
        );
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql = "DELETE FROM employee WHERE id=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1,id);

        return stm.executeUpdate()>0;
    }

    @Override
    public boolean update(Employee employee) throws Exception {
        String sql = "UPDATE employee SET name=?, address=?, nic=?, dob=?, pid=? WHERE id=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1,employee.getName());
        stm.setObject(2,employee.getAddress());
        stm.setObject(3,employee.getNic());
        stm.setObject(4,employee.getDob());
        stm.setObject(5,employee.getPost().getId());
        stm.setObject(6,employee.getId());

        return stm.executeUpdate()>0;
    }
}
