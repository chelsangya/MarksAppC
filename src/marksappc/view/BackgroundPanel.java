/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marksappc.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author sangyakoirala
 */
public class BackgroundPanel extends JPanel {

    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        backgroundImage = new ImageIcon(imagePath).getImage();
        setLayout(null); // optional: use layout manager if you want
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw scaled background
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

}
