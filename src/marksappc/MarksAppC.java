/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package marksappc;

import marksappc.controller.RegisterController;
import marksappc.view.BackgroundCheck;
import marksappc.view.RegisterView;

/**
 *
 * @author sangyakoirala
 */
public class MarksAppC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RegisterView view = new RegisterView();
        RegisterController controller = new RegisterController(view);
        controller.open();
        
    }
    
}

 
