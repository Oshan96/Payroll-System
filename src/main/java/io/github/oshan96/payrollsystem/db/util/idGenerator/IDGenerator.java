package io.github.oshan96.payrollsystem.db.util.idGenerator;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author oshan
 */
public class IDGenerator {
    public static String getNewID(String tblName, String colName, String prefix) throws SQLException{
        String lastId = null;
        try {
            lastId = IDController.getLastID(tblName, colName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String newId;
        if (lastId != null) {
            String Id="";
            char[] reg=lastId.toCharArray();
            for(int i=prefix.length();i<reg.length;i++){
                Id+=reg[i];
            }
            int r=Integer.parseInt(Id);
            if(r<9){
                newId= prefix+"00"+(r+1);
            }else if(r<99){
                newId= prefix+"0"+(r+1);
            }else
                newId= prefix+(r+1);
        }else{
            newId = prefix+"001";
        }
        return newId;
    }

    public static String getNewID(String lastId, String prefix) throws SQLException {
        String Id="";
        char[] reg=lastId.toCharArray();
        for(int i=prefix.length();i<reg.length;i++){
            Id+=reg[i];
        }
        int r=Integer.parseInt(Id);
        if(r<9){
            return prefix+"00"+(r+1);
        }else if(r<99){
            return prefix+"0"+(r+1);
        }
        return prefix+(r+1);
    }
}
