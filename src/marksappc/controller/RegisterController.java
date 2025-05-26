/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marksappc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import marksappc.dao.UserDao;
import marksappc.model.UserData;
import marksappc.view.RegisterView;

/**
 *
 * @author sangyakoirala
 */
public class RegisterController {
    private RegisterView view = new RegisterView();
    public RegisterController(RegisterView view){
        this.view=view;
        view.registerUser(new RegisterUser());
    }
    public void open(){
        this.view.setVisible(true);
    }
    public void close(){
        this.view.dispose();
    }
    class RegisterUser implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameTextField().getText();
            String email = view.getEmailTextField().getText();
            String password = String.valueOf(view.getPasswordField().getPassword());
            String confirmPassword = String.valueOf(view.getConfirmPasswordField().getPassword());
            UserData user = new UserData(name,email,password);
            UserDao userDao = new UserDao();
            boolean result = userDao.register(user);
            if (result){
                JOptionPane.showMessageDialog(view, "Registered successfully");
            } else {
                JOptionPane.showMessageDialog(view,"Registration failed");
            }
        }
        
    }
}
