import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleGear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleGear extends Actor
{
    /**
     * Act - do whatever the TitleGear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int dir = 1;
    public int move = 0;
    
    public String title = "GearMo";
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
    public int r = 0;
    TitleGear t;
    
    public TitleGear(){
        
    }
    public void act() 
    { setRotation(r++);
      
       //getImage().drawString(title,11,128);
       
    }   
}
