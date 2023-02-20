package com.adilenver;

import java.awt.*;

//Red line drawing
public class Line {
    //Starting point coordinates
    int x = 380;
    int y = 180;

    //End point coordinates
    int endX = 500;
    int endY = 500;

    //Line length
    double length = 100;
    double n = 0;

    //direction Initially set to 1
    int dir = 1;

    //status 0 swing, 1 crawl, 2 take back
    int status ;

    void lines(Graphics g){
        endX = (int) (x + length * Math.cos(n * Math.PI));
        endY = (int) (y + length * Math.sin(n * Math.PI));
        //Set color
        g.setColor(Color.red);
        g.drawLine(x,y,endX,endY);
    }

    void paintSelf(Graphics g){

        switch (status){
            case 0 :
                if (n < 0.1){
                    dir = 1;
                } else if (n > 0.9) {
                    dir = -1;
                }
                lines(g);
                n = n + 0.005 * dir;
                break;
            case 1 :
                if (length < 500){
                    length = length + 10;
                    lines(g);
                }else {
                    status = 2;
                }
                break;
            case 2 :
                if (length > 100){
                    length = length - 10;
                    lines(g);
                }else {
                    status = 0;
                }
            default:
        }



    }
}
