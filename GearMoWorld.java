import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GearMoWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GearMoWorld extends World
{

    /**
     * Constructor for objects of class GearMoWorld.
     * 
     */
    int soundPlay = 0;
    public GearMoWorld()
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
        Smokestack smokestack = new Smokestack();
        addObject(smokestack, 332, 300);
        PressureSwitch pressureswitch = new PressureSwitch();
        addObject(pressureswitch, 541, 278);
        pressureswitch.setLocation(549, 269);

        pressureswitch.setLocation(537, 271);

        TriRobot trirobot = new TriRobot();
        addObject(trirobot, 338, 80);
        trirobot.setLocation(339, 77);
        trirobot.setLocation(362, 77);
    }
    
    public void act(){
       if(soundPlay == 0){
           soundPlay = 1;
           Greenfoot.playSound("Rolemusic_-_04_-_Scape_from_the_city.mp3");
        }
    }
    
        public void started(){
       // Greenfoot.playSound("Rolemusic_-_04_-_Scape_from_the_city.mp3");
    }
    
    public void reset() 
{
   if(Greenfoot.mouseClicked(this))
   {
       soundPlay = 0;
      Greenfoot.setWorld(new TitleScreen()); //starts a new world    
    }  
}


}
