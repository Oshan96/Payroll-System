package io.github.oshan96.payrollsystem.db.util.idGenerator;

import io.github.oshan96.payrollsystem.db.connection.DBConnection;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author oshan
 */
public class IDController {
    public static String getLastID(String tblName, String colName) throws SQLException, IOException, ClassNotFoundException, URISyntaxException {
        String SQL=String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1",colName,tblName,colName);
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(SQL);
        if(rst.next())
            return rst.getString(1);
        return null;
    }
}
