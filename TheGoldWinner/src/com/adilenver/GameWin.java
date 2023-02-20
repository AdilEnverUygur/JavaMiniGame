package com.adilenver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// 1. Window drawing
// extends JFrame- In this way, it has the function of creating a window and listening to mouse and keyboard events
public class GameWin extends JFrame {

    //new Bg class
    Bg bg = new Bg();
    //new Line class
    Line line = new Line();
    //new Gold class
    Gold gold = new Gold();

    //define a canvas
    Image offScreenImage;

    // Create a launch method in the class to initialize window information
    void launch(){
        // First, set whether the window is visible
        this.setVisible(true);
        // Second, set the window size
        this.setSize(768,1000);
        // Then set the window location,This will center the window
        this.setLocationRelativeTo(null);
        // Then set the window title
        this.setTitle("The Gold Miner");
        // Finally, we add a method to close the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Use mouse events to change parameters
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == 1){
                    line.status = 1;
                }
            }
        });

        //Repeat drawing
        while (true){
            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Drawing method
    @Override
    public void paint(Graphics g) {
        offScreenImage = this.createImage(768,1000);
        Graphics gImage = offScreenImage.getGraphics();

        bg.paintSelf(gImage);
        line.paintSelf(gImage);
        gold.paintSelf(gImage);

        g.drawImage(offScreenImage,0,0,null);
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
