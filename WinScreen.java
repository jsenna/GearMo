import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends World
{

    /**
     * Constructor for objects of class WinScreen.
     * 
     */
    public WinScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        WinBox winbox = new WinBox();
        addObject(winbox, 326, 203);
        winbox.setLocation(300, 200);

        gearmo gearmo = new gearmo();
        addObject(gearmo, 279, 286);
        gearmo.setLocation(296, 287);
    }
 public void reset() 
   {
       //soundPlay = 0;
      Greenfoot.setWorld(new TitleScreen()); //starts a new world          
  }
}
