import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mplus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mplus extends Actor
{
    /**
     * Act - do whatever the Mplus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage("mplus.png");
        if (Greenfoot.mouseClicked(this)) 
        {
            if(((TitleScreen) getWorld()).mv<100)
            {
                ((TitleScreen) getWorld()).mv+= 10;
                ((TitleScreen) getWorld()).music.setVolume(((TitleScreen) getWorld()).mv);
            }
        }
    }    
}
