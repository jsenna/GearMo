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
       
      
       
       
       if(((LevelArea)getWorld()).gearmo.getX() >= 450 ){
           setImage("switchOn.png");
           
        ((LevelArea)getWorld()).nextWorld();
       //Greenfoot.setWorld(new WinScreen());
       }
       
    }
}
    
}
