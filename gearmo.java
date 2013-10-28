import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gearmo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gearmo extends AnimatedActor
{
    private int imageBuffer= 100;
    public int animate = 0;
    public int endX;
    public int endY;
    public gearmo()
    {
        super("gearmoI",".png",9);
    }
    public void act()
    {
        super.act();
        if(getWorld().getClass().getName() == "TitleScreen"){
                       if(animate == 0){
           animate = 1;
           endX = getX();
           endY = getY();
           setLocation(getX(),450);
        }
        if(animate == 1 && getY() > endY){
           setLocation(getX(),getY() - 6);
           if(getY() <= endY ){
            animate = 2;
            }
        }
        if(animate == 2){
            //Play sound here
            animate = 3;
        }
    }
    }
}
