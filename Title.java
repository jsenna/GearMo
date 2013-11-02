import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
public class Title extends Actor
{
    /**
     * Act - do whatever the Title wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public int dir = 1;
    public int move = 0;
    
    public String title = "GearMo";
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
    
    
    public Title(){
       GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        Font font = image.getFont();
        font = font.deriveFont(48.0f);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        setImage(image);
    }
    public void act() 
    {
       if(move < 45){ 
       if(dir == 1){
        setLocation(getX(),getY() + 1);
        move++;
        }
        else{
        setLocation(getX(),getY() - 1);
        move++;
        }
    }
       else{
       move = 0;
       dir = dir * -1;
       }
      
       //getImage().drawString(title,11,128);
       
    }    
}
