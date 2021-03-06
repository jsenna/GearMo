import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CBall extends Actor
{
    private int x= 55,y=500;
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
        if(((LevelArea) getWorld()).build==true)
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
                JellyWheel jel = new JellyWheel(25, -.50);
                ((LevelArea) getWorld()).jellO.addShape(jel, x, y);
                setLocation(x,y);
                reset=false;
            }
            if(reset==false)
            {
                if (this.getWorld().getClass() == TheWorld.class) 
                {  
                    setLocation(55,500);
                } 
                if (this.getWorld().getClass() == Level2World.class) 
                {  
                    setLocation(55,330);
                } 
                if (this.getWorld().getClass() == Level3World.class) 
                {  
                    setLocation(55,370);
                } 
            }else
            {
                setLocation(x,y);
            }
        }
    } 
    
}
