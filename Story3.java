import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Story3 extends Actor
{
    /**
     * Act - do whatever the Story3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage("story3.png");
        // Add your action code here.
                if(Greenfoot.mouseClicked(this)){
            getWorld().removeObjects(getWorld().getObjects(Mplus.class));
            getWorld().removeObjects(getWorld().getObjects(Mminus.class));
            getWorld().removeObjects(getWorld().getObjects(Options.class));
            getWorld().stopped();
            Greenfoot.setWorld(new TheWorld(((TitleScreen) getWorld()).music.getVolume()));
           
        }
    } 
    
}
