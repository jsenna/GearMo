import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PressureSwitch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PressureSwitch extends Switchable
{
    /**
     * Act - do whatever the PressureSwitch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public void activate(){
        //Greenfoot.playSound("click.mp3");
        if(on == 0){
       setImage("switchOn.png");
      
       on = 1;
       
       if(((TheWorld)getWorld()).gearmo.getX() >= 420){
        ((TheWorld)getWorld()).music.stop();
       Greenfoot.setWorld(new WinScreen());
       }
       
    }
}
    
}
