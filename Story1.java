import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Story1 extends Actor
{
    /**
     * Act - do whatever the Story1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setImage("story1.png");
        if(Greenfoot.mouseClicked(this)){
        getWorld().addObject(new Story2(),400,300);
        }
    }    
}
