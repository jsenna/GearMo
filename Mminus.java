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
    
    public Mminus(){
        setImage("mminus.png");
    }
    public void act() 
    {
            if (Greenfoot.mouseClicked(this)) 
            {
                if(((TitleScreen) getWorld()).mv>0)
                {
                    ((TitleScreen) getWorld()).mv+= -10;
                    ((TitleScreen) getWorld()).music.setVolume(((TitleScreen) getWorld()).mv);
                }
            }
    }    
}
