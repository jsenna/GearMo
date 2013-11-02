import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3World extends LevelArea
{

    /**
     * Constructor for objects of class Level3World.
     * 
     */
    public Level3World()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       prepareInterface();
       lvl = 3;
       prepare();
        setPaintOrder(gearmo.class, Start.class, reset.class, CCBall.class, CBall.class, edgeicon.class, JellyObject.class, JellyShape.class);
    }
    
       public void prepare(){
                Gearmoposition();
        insertJelObjects();
        Smokestack smokestack = new Smokestack();
        addObject(smokestack, 332, 300);
        WorldBack5 worldback = new WorldBack5();
        addObject(worldback,WIDTH/2,HEIGHT/2);
        addObject(smokestack, 400, 300);
        PressureSwitch pressureswitch = new PressureSwitch();
        addObject(pressureswitch, 1013, 571);
        

        pressureswitch.setLocation(913, 490);
        pSwitch = pressureswitch;
        TriRobot trirobot = new TriRobot();
        addObject(trirobot, 338, 80);
        trirobot.setLocation(339, 77);
        trirobot.setLocation(362, 77);
        nWorld = new WinScreen();
    }
      public void Gearmoposition()
  {
      gearmo = new gearmo();
      jellyGearMo = new JellyGearMo();
      addObject(gearmo, 100, 80);
      addObject(jellyGearMo, 100, 80);
  }
  public void insertJelObjects()
  {
      jellO = new JellyObject();
      jellO.shapes.add(jellyGearMo);
      addObject(jellO, 0, 0);
  }
}
