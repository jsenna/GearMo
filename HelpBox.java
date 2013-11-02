import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpBox extends Actor
{
    /**
     * Act - do whatever the HelpBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int animate = 0;
    public int endX;
    public int endY;
   
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
           getWorld().removeObject(this);
        }
    }        
       
}
