import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mminus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mminus extends Actor
{
    /**
     * Act - do whatever the Mminus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int j = 50;
    public void act() 
    {
            setImage("mminus.png");
            if (Greenfoot.mouseClicked(this)) 
            {
                j+= -10;
                ((TitleScreen) getWorld()).music.setVolume(j);
            }
    }    
}
