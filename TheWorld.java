import greenfoot.*;
import java.awt.Color;
public class TheWorld extends World {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    private static int shapeCounter = 0;
    public int soundPlay = 0;
    public boolean engine=false;
    public gearmo gearmo;
    
    public TheWorld() {
        super(WIDTH, HEIGHT, 1);
        prepare();
        GreenfootImage img = new GreenfootImage(WIDTH, HEIGHT);
        img.setColor(Color.CYAN);
        img.fill();
        //setBackground(img);
        
        setPaintOrder(gearmo.class, Start.class, CCBall.class, CBall.class, JellyObject.class, JellyShape.class);

        shapeCounter++;
    }
    private void prepare()
    {
        gearmo = new gearmo();
        addObject(gearmo, 100, 80);
        Smokestack smokestack = new Smokestack();
        addObject(smokestack, 332, 300);
        WorldBack1 worldback = new WorldBack1();
        addObject(worldback,300,200);
        addObject(smokestack, 400, 300);
        PressureSwitch pressureswitch = new PressureSwitch();
        addObject(pressureswitch, 541, 278);
        pressureswitch.setLocation(549, 269);

        pressureswitch.setLocation(537, 271);

        TriRobot trirobot = new TriRobot();
        CBall cball= new CBall();
        
        CCBall ccball= new CCBall();

        Start star= new Start();

        
        addObject(trirobot, 338, 80);
        trirobot.setLocation(339, 77);
        trirobot.setLocation(362, 77);
        addObject(cball,55,355);
        addObject(ccball,200,355);
        addObject(star, 525 ,25);
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
       soundPlay = 0;
      Greenfoot.setWorld(new TitleScreen()); //starts a new world          
  }
  

}
