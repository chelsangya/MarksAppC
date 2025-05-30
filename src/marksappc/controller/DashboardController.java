/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marksappc.controller;

import marksappc.model.UserData;
import marksappc.view.DashboardView;

/**
 *
 * @author sangyakoirala
 */
public class DashboardController {
    private DashboardView view;
    private UserData user;
    public DashboardController(DashboardView view,UserData user){
        this.view= view;
        this.user = user;
        String name= user.getName();
        this.view.getWelcomeLabel().setText("Welcome "+name);
    }
    public void open(){
        view.setVisible(true);
    }
    public void close(){
        view.dispose();
    }
}
