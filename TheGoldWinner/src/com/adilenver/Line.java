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
    //status 0 swing, 1 crawl, 2 take back, 3 fetch return
    int status ;

    GameWin frame;
    Line(GameWin frame){
        this.frame = frame;
    }

    void logic(){
        for (Object obj : this.frame.objectList) {
            if (endX > obj.x && endX < obj.x + obj.width
                    && endY > obj.y && endY < obj.y + obj.height) {
                status = 3;
                obj.flag = true;
            }
        }
    }

    void lines(Graphics g){
        endX = (int) (x + length * Math.cos(n * Math.PI));
        endY = (int) (y + length * Math.sin(n * Math.PI));
        //Set color
        g.setColor(Color.red);
        g.drawLine(x,y,endX,endY);
    }

    void paintSelf(Graphics g){
        logic();
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
                break;
            case 3 :
                if (length > 100){
                    length = length - 10;
                    lines(g);
                    for (Object obj : this.frame.objectList){
                        if (obj.flag){
                            obj.x = endX - obj.getWidth()/2;
                            obj.y = endY;
                            if (length <= 100){
                                obj.x = -150;
                                obj.y = -150;
                                obj.flag = false;
                                status = 0;
                            }
                        }
                    }
                }
                break;
            default:
        }



    }
}
