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
    int vol;  
    public Level3World(int v)
    {
        music = new GreenfootSound("Rolemusic_-_02_-_ayVentura.mp3");
        vol = v;
        music.setVolume(vol);
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        setBackground("658_max.png");
       prepareInterface();
       lvl = 3;
       prepare();
        setPaintOrder(gearmo.class, Start.class, reset.class, CCBall.class, CBall.class, edgeicon.class, JellyObject.class, JellyShape.class);
             world_edges_U = new Edge[]{new Edge(new Vertex(0,450),new Vertex(394,491)),
                                    new Edge(new Vertex(394,491),new Vertex(675,328))}; 
     world_edges_D = new Edge[]{new Edge(new Vertex(0,328),new Vertex(675,328))};
                                
    world_edges_U_Absoulte = new Edge[]{ new Edge(new Vertex(310,0),new Vertex(800,268))};
    world_edges_D_Absoulte = new Edge[]{new Edge(new Vertex(350,600),new Vertex(800,423))};
    }
    
       public void prepare(){
                Gearmoposition();
        insertJelObjects();
        WorldBack5 worldback = new WorldBack5();
        addObject(worldback,WIDTH/2,HEIGHT/2);
        PressureSwitch pressureswitch = new PressureSwitch();
        addObject(pressureswitch, 1013, 571);
        
        edgeicon edgei=new edgeicon();
        addObject(edgei, 350, 370);
        
        pressureswitch.setLocation(150, 300);
        pSwitch = pressureswitch;
   
        nWorld = new WinScreen();
    }
      public void Gearmoposition()
  {
      gearmo = new gearmo();
      jellyGearMo = new JellyGearMo();
      addObject(gearmo, 100, 550);
      addObject(jellyGearMo, 100, 550);
  }
  public void insertJelObjects()
  {
      jellO = new JellyObject();
      jellO.shapes.add(jellyGearMo);
      addObject(jellO, 0, 0);
  }
}
