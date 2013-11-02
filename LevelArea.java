import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelArea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelArea extends World
{

    /**
     * Constructor for objects of class LevelArea.
     * 
     */
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static int shapeCounter = 0;
    public int soundPlay = 0;
    public boolean engine=false;
    public boolean build=true;
    public gearmo gearmo;
    JellyGearMo jellyGearMo;
    public JellyObject jellO;
    public GreenfootSound music;
    public PressureSwitch pSwitch;
    public World nWorld;
    public Edge[] world_edges_U;
    public Edge[] world_edges_D;
    public Edge[] world_edges_U_Absoulte;
    public Edge[] world_edges_D_Absoulte;
    public int lvl;
    /**
     * Constructor for objects of class Level2World.
     * 
     */
    public LevelArea()
    {    
        super(WIDTH, HEIGHT, 1);
        music = new GreenfootSound("Rolemusic_-_04_-_Scape_from_the_city.mp3");
        music.setVolume(50);
    }
    public void prepareInterface(){
        CBall cball= new CBall();
        CCBall ccball= new CCBall();

        Start start= new Start();
        reset reset= new reset();
        edgeicon edgei=new edgeicon();
        
        
        addObject(cball,55,500);
        addObject(ccball,200,500);
        addObject(start, 720 ,25);
        addObject(reset, 720, 60);
        addObject(edgei, 350, 500);
    }
        public void act(){
       if(soundPlay == 0){
           soundPlay = 1;
           music.play();
        }
    }
      public void reset() 
   {
       soundPlay = 0;
      Greenfoot.setWorld(new TitleScreen()); //starts a new world          
  }
  
  public void nextWorld(){
     Greenfoot.setWorld(nWorld);
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
