import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2World extends LevelArea
{
    TriRobot trirobot; 
    /**
     * Constructor for objects of class Level2World.
     * 
     */
    int vol;
    public Level2World(int v)
    {      
        music = new GreenfootSound("Rolemusic_-_01_-_A_ninja_among_culturachippers.mp3");
        vol = v;
        music.setVolume(vol);
     setBackground("7845.png");   
     prepareInterface();
     lvl = 2;
     prepare();
     setPaintOrder(gearmo.class, Start.class, reset.class, CCBall.class, CBall.class, edgeicon.class, JellyObject.class, JellyShape.class);
     
     world_edges_U = new Edge[]{new Edge(new Vertex(0,404),new Vertex(543,404)),
                                    new Edge(new Vertex(543,404),new Vertex(663,273))}; 
     world_edges_D = new Edge[]{new Edge(new Vertex(0,273),new Vertex(663,273))};
     
     world_edges_U_Absoulte = new Edge[0];
     world_edges_D_Absoulte = new Edge[0];
    }
    public void prepare(){
                Gearmoposition();
        insertJelObjects();
        WorldBack2 worldback = new WorldBack2();
        addObject(worldback,WIDTH/2,HEIGHT/2);
        PressureSwitch pressureswitch = new PressureSwitch();
        addObject(pressureswitch, 1013, 571);
        
        edgeicon edgei=new edgeicon();
        addObject(edgei, 350, 330);
   
        pressureswitch.setLocation(100, 500);
        pSwitch = pressureswitch;
        trirobot = new TriRobot();
        addObject(trirobot, 338, 240);
        addObject(trirobot, 368, 240);
        addObject(trirobot, 400, 240);

        
        nWorld = new Level3World(vol);
    }
      public void Gearmoposition()
  {
      gearmo = new gearmo();
      jellyGearMo = new JellyGearMo();
      addObject(gearmo, 130, 130);   
      addObject(jellyGearMo, 130, 130);
  }
  public void insertJelObjects()
  {
      jellO = new JellyObject();
      
      jellO.shapes.add(jellyGearMo);
      addObject(jellO, 0, 0);
  }
 
    
}
