import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class reset here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class reset extends Actor
{
    /**
     * Act - do whatever the reset wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage("reset.png");
        if(Greenfoot.mouseClicked(this))
        {
            getWorld().removeObjects(getWorld().getObjects(JellyWheel.class));
            getWorld().removeObjects(getWorld().getObjects(gearmo.class));
            getWorld().removeObjects(getWorld().getObjects(JellyGearMo.class));
            getWorld().removeObjects(getWorld().getObjects(JellyObject.class));
            ((LevelArea) getWorld()).Gearmoposition();
            ((LevelArea) getWorld()).insertJelObjects();
            ((LevelArea) getWorld()).engine=false;
            ((LevelArea) getWorld()).build= true;
            if(((LevelArea) getWorld()).lvl == 3)
            {
                ((LevelArea) getWorld()).gravityswitch.resetGravity();
            }
        }
    }    
}
