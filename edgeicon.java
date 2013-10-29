import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class edgeicon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class edgeicon extends Actor
{
    public JellyObject JConstruct= new JellyObject();
    MouseInfo mouse=Greenfoot.getMouseInfo();
    TheWorld world= (TheWorld) getWorld();
    public boolean tool=false;
    int limit = 0 ;
    int savestartx=0,savestarty=0, saveendx=0, saveendy=0, x, y;
    public int rotation = 0;
    /**
     * Act - do whatever the BallIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            if( tool==false){tool=true;}
            else{tool=false;}
        }
        if(tool==true)
        {
            if (Greenfoot.mouseDragged(null)){
                /*MouseInfo mouse=Greenfoot.getMouseInfo();
                x=mouse.getX();
                y=mouse.getY();*/
            }
            if(Greenfoot.mousePressed(null))
            {
               /* savestartx= mouse.getX();
                savestarty= mouse.getY();*/
            }
            if(Greenfoot.mouseClicked(world.getJello()))
            {
               /* saveendx= x;
                saveendy= y;*/
                move(10);
            }
        }
    }
    
} 
