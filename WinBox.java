import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinBox extends Actor
{
    /**
     * Act - do whatever the WinBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int animate = 0;
    public int endX;
    public int endY;
    public void act() 
    {
        setImage("winBox.png");
        super.act();
        if(animate == 0){
           animate = 1;
           endX = getX();
           endY = getY();
           setLocation(50,getY());
        }
        if(animate == 1 && getX() < endX){
           setLocation(getX() + 3,getY());
           if(getX() >= endX ){
            animate = 2;
            }
        }
        if(animate == 2){
            //Play sound here
            animate = 3;
        }
        
        if(Greenfoot.mouseClicked(this)){
            getWorld().stopped();
            Greenfoot.setWorld(new TitleScreen());
           
        }
    }    
}
