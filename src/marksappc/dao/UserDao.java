/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marksappc.dao;

import marksappc.database.MySqlConnection;
import marksappc.model.UserData;
import java.sql.*;

/**
 *
 * @author sangyakoirala
 */
public class UserDao {
    MySqlConnection mySql = new MySqlConnection();
    public boolean register(UserData user){
        String query="INSERT INTO users(fname,email,fpassword) VALUES (?,?,?)";
        Connection conn = mySql.openConnection();
        try{
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.setString(1, user.getName());
            stmnt.setString(2,user.getEmail());
            stmnt.setString(3,user.getPassword());
            int result = stmnt.executeUpdate();
            return result>0;
        } catch(Exception e){
            return false;
        } finally{
            mySql.closeConnection(conn);
        }
    }
}
