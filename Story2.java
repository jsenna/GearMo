import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Story2 extends Actor
{
    /**
     * Act - do whatever the Story2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
              setImage("story2.png");
        if(Greenfoot.mouseClicked(this)){
           getWorld().addObject(new Story3(),400,300);
        }
    }    
}
