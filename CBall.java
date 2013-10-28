import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CBall extends Actor
{
    private int x= 55,y=355;
    private Boolean drag=false;
    MouseInfo mouse=Greenfoot.getMouseInfo();
    /**
     * Act - do whatever the BallIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseDragged(this)) {
            MouseInfo mouse=Greenfoot.getMouseInfo();
            x=mouse.getX();
            y=mouse.getY();
        } 
        if (Greenfoot.mousePressed(this)) drag=true;
        if (Greenfoot.mouseClicked(null)) {
            drag=false;
            setLocation(x,y);
        }
        setLocation(x,y);
    }    
}
