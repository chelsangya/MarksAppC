/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marksappc.dao;

import marksappc.database.MySqlConnection;
import marksappc.model.UserData;
import java.sql.*;
import marksappc.model.LoginRequest;

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
    
    public UserData login(LoginRequest loginReq){
//        Step 1: write query
        String query = "SELECT * FROM users WHERE email=? and fpassword=?";
//        Step 2: open connection
        Connection conn = mySql.openConnection();
        try{
//            Step 3: start prepared statement
            PreparedStatement stmnt = conn.prepareStatement(query);
//            Step 4: clean query if needed
            stmnt.setString(1,loginReq.getEmail());
            stmnt.setString(2,loginReq.getPassword());
//            Step 5: execute query or update
//            always use executeQuery for select query
//            it returns rows so, use ResultSet
            ResultSet result= stmnt.executeQuery();
//            Step 6: check returned data from query
            if (result.next()){
//           the string inside getString should match the name of column in database
                String id= result.getString("id"); 
                String name = result.getString("fname");
                String email = result.getString("email");
                String password = result.getString("password");
                UserData user = new UserData(id,name,email,password);
                return user;
            } else{
                return null;
            }   
        } catch(Exception e){
            return null;
        } finally{
            mySql.closeConnection(conn);
        }
    }
}
