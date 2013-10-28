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
    public int animate = 0;
    public int endX;
    public int endY;
    
    public TitleGear(){
        
    }
    public void act() 
    { setRotation(r++);
        if(getWorld().getClass().getName() == "TitleScreen"){
                       if(animate == 0){
           animate = 1;
           endX = getX();
           endY = getY();
           setLocation(getX(),-100);
        }
        if(animate == 1 && getY() < endY){
           setLocation(getX(),getY() + 6);
           if(getY() >= endY ){
            animate = 2;
            }
        }
        if(animate == 2){
            //Play sound here
            animate = 3;
        }
    }
    }   
}
