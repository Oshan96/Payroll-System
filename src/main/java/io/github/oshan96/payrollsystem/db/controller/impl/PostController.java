package io.github.oshan96.payrollsystem.db.controller.impl;

import io.github.oshan96.payrollsystem.db.connection.DBConnection;
import io.github.oshan96.payrollsystem.db.controller.DBController;
import io.github.oshan96.payrollsystem.model.db.Post;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oshan
 */
public class PostController implements DBController<Post> {

    private Connection connection;

    public PostController() throws SQLException, IOException, ClassNotFoundException {
        connection = DBConnection.getInstance().getConnection();
    }

    @Override
    public boolean add(Post post) throws Exception {
        String sql = "INSERT INTO post VALUES (?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1,post.getId());
        stm.setObject(2,post.getBasicSalary());
        stm.setObject(3,post.getHourlyRate());

        return stm.executeUpdate() > 0;
    }

    @Override
    public Post get(String id) throws Exception {
        String sql = "SELECT * FROM post WHERE pid=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1,id);

        ResultSet rst = stm.executeQuery();
        rst.next();
        return new Post(
            rst.getString(1),
            rst.getDouble(2),
            rst.getDouble(3)
        );
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql = "DELETE FROM post WHERE pid=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1,id);

        return stm.executeUpdate()>0;
    }

    @Override
    public boolean update(Post post) throws Exception {
        String sql = "UPDATE post SET basicSalary=?, hourlyRate=? WHERE pid=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1,post.getBasicSalary());
        stm.setObject(2,post.getHourlyRate());
        stm.setObject(3,post.getId());

        return stm.executeUpdate()>0;
    }

    public List<String> getIDs() throws Exception {
        List<String> ids = new ArrayList<>();
        String sql = "SELECT pid FROM post";
        PreparedStatement stm = connection.prepareStatement(sql);

        ResultSet rst = stm.executeQuery();
        while(rst.next())
            ids.add(rst.getString(1));

        return ids;
    }

}
