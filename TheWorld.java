import greenfoot.*;
import java.awt.Color;
public class TheWorld extends World {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private static int shapeCounter = 0;
    public int soundPlay = 0;
    public boolean engine=false;
    public boolean build=true;
    public gearmo gearmo;
    JellyGearMo jellyGearMo;
    public JellyObject jellO;
    public GreenfootSound music;
    public PressureSwitch pSwitch;
    
    public TheWorld() {
        super(WIDTH, HEIGHT, 1);
        music = new GreenfootSound("Rolemusic_-_04_-_Scape_from_the_city.mp3");
        prepare();
        GreenfootImage img = new GreenfootImage(WIDTH, HEIGHT);
        img.setColor(Color.CYAN);
        img.fill();
        
        setPaintOrder(gearmo.class, Start.class, reset.class, CCBall.class, CBall.class, edgeicon.class, JellyObject.class, JellyShape.class);
        
        shapeCounter++;
    }
    private void prepare()
    {
        Gearmoposition();
        insertJelObjects();
        Smokestack smokestack = new Smokestack();
        addObject(smokestack, 332, 300);
        WorldBack1 worldback = new WorldBack1();
        addObject(worldback,WIDTH/2,HEIGHT/2);
        addObject(smokestack, 400, 300);
        PressureSwitch pressureswitch = new PressureSwitch();
        addObject(pressureswitch, 1013, 571);
        

        pressureswitch.setLocation(913, 490);
        pSwitch = pressureswitch;
        TriRobot trirobot = new TriRobot();
        CBall cball= new CBall();
        CCBall ccball= new CCBall();

        Start start= new Start();
        reset reset= new reset();
        edgeicon edgei=new edgeicon();
        
        addObject(trirobot, 338, 80);
        trirobot.setLocation(339, 77);
        trirobot.setLocation(362, 77);
        addObject(cball,55,500);
        addObject(ccball,200,500);
        addObject(start, 725 ,25);
        addObject(reset, 725, 60);
        addObject(edgei, 350, 500);
    }
    public void act(){
       if(soundPlay == 0){
           soundPlay = 1;
           music.play();
        }
    }
    public JellyObject getJello()
    {
        return jellO;
    }
    
        public void started(){
       // Greenfoot.playSound("Rolemusic_-_04_-_Scape_from_the_city.mp3");
    }
    
    public void reset() 
   {
       soundPlay = 0;
      Greenfoot.setWorld(new TitleScreen()); //starts a new world          
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
