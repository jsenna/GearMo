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
    public void act(){
        //Greenfoot.playSound("click.mp3");
      
        if(((LevelArea)getWorld()).lvl == 3 && ((LevelArea)getWorld()).gearmo.getX() <= this.getX() && ((LevelArea)getWorld()).gearmo.getY() <= this.getY()  ){
           setImage("switchOn.png");
           ((LevelArea)getWorld()).music.stop();
        ((LevelArea)getWorld()).nextWorld();
       //Greenfoot.setWorld(new WinScreen());
       }      
        
        
       if(((LevelArea)getWorld()).lvl == 2 && ((LevelArea)getWorld()).gearmo.getX() <= this.getX() && ((LevelArea)getWorld()).gearmo.getY() >= this.getY()  ){
           setImage("switchOn.png");
           ((LevelArea)getWorld()).music.stop();
        ((LevelArea)getWorld()).nextWorld();
       //Greenfoot.setWorld(new WinScreen());
       }
       
       
       if(((LevelArea)getWorld()).lvl == 1 && ((LevelArea)getWorld()).gearmo.getX() >= this.getX() ){
           setImage("switchOn.png");
           ((LevelArea)getWorld()).music.stop();
        ((LevelArea)getWorld()).nextWorld();
       //Greenfoot.setWorld(new WinScreen());
       }
       
    
}
    
}
