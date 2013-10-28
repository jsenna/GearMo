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
    JellyWheel jel = new JellyWheel(25);
    MouseInfo mouse=Greenfoot.getMouseInfo();
    public int rotation = 0;
    /**
     * Act - do whatever the BallIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        rotation++;
        setRotation(rotation);
        if (Greenfoot.mouseDragged(this)) {
            MouseInfo mouse=Greenfoot.getMouseInfo();
            x=mouse.getX();
            y=mouse.getY();
        } 
        if (Greenfoot.mousePressed(this)){
            drag=true;
        }
        if (Greenfoot.mouseClicked(this)) 
        {
            drag=false;
            getWorld().addObject(jel,x, y);
            setLocation(x,y);
        }
        setLocation(x, y);
    }    
}
