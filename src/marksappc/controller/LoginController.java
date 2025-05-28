/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marksappc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import marksappc.dao.UserDao;
import marksappc.model.LoginRequest;
import marksappc.model.UserData;
import marksappc.view.LoginView;

/**
 *
 * @author sangyakoirala
 */
public class LoginController {
    LoginView view;
    public LoginController(LoginView view){
        this.view=view;
        LoginUser login= new LoginUser();
        this.view.loginUser(login);        
//        this.view.loginUser(new LoginUser());

        
    }
    public void open(){
        view.setVisible(true);
    }
    public void close(){
        view.dispose();
    }
    class LoginUser implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String email = view.getEmailTextField().getText();
            String password = String.valueOf(view.getPasswordField().getPassword());
            if (email.isEmpty()||password.isEmpty()){
                JOptionPane.showMessageDialog(view, "Fill in all the fields");
            } else {
                LoginRequest loginData = new LoginRequest(email,password);
                UserDao userDao = new UserDao();
                UserData user = userDao.login(loginData);
                if (user==null){
                    JOptionPane.showMessageDialog(view,"Invalid credentials");
                } else {
                    
                }
                
            }
        }
        
    }
}
