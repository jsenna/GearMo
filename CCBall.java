import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CCBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CCBall extends Actor
{
    private int x=200 ,y=355;
    JellyWheel jel = new JellyWheel(25);
    private Boolean drag=false;
    MouseInfo mouse=Greenfoot.getMouseInfo();
    /**
     * Act - do whatever the BallIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseDragged(jel)) {
            MouseInfo mouse=Greenfoot.getMouseInfo();
            x=mouse.getX();
            y=mouse.getY();
        } 
        if (Greenfoot.mousePressed(this)){
            drag=true;
        }
        if (Greenfoot.mouseClicked(this)) {
            getWorld().addObject(jel,250,250);
            drag=false;
            setLocation(x,y);
        }
        setLocation(x,y);
    }    
}
