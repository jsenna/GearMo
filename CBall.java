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
    public boolean reset;
    private Boolean drag=false;
    MouseInfo mouse=Greenfoot.getMouseInfo();
    public int rotation = 0;
    /**
     * Act - do whatever the BallIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(((TheWorld) getWorld()).build==true)
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
                reset=true;
            }
            if (Greenfoot.mouseClicked(this)) 
            {
                drag=false;
                ((TheWorld) getWorld()).jellO.addShape(new JellyWheel(25, -.20), x, y);
                setLocation(x,y);
                reset=false;
            }
            if(reset==false)
            {
                setLocation(55,355);
            }else
            {
                setLocation(x,y);
            }
        }
    } 
    
}
