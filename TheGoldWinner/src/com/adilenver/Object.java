package com.adilenver;

import java.awt.*;

public class Object {
    //coordinates
    int x ;
    int y ;
    //width-height
    int width ;
    int height ;
    //image
    Image img;
    //mark it can move or not
    boolean flag;
    //Quality
    int m;

    void paintSelf(Graphics g){
        g.drawImage(img,x,y,null);
    }

    public int getWidth() {
        return width;
    }

    //Get rectangle
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
}
