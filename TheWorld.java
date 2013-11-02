import greenfoot.*;
import java.awt.Color;
public class TheWorld extends LevelArea {
    
    public TheWorld() {
        
       
        prepareInterface();
        lvl = 1;
        prepare();
        
        world_edges_U_Absoulte = new Edge[0];
        world_edges_D_Absoulte = new Edge[0];
        
        world_edges_U = new Edge[0];
        world_edges_D = new Edge[]{new Edge(new Vertex(0,266),new Vertex(354,452)),
                           new Edge(new Vertex(354,452),new Vertex(559,452)),
                           new Edge(new Vertex(559,452),new Vertex(649,369)),
                           new Edge(new Vertex(649,369),new Vertex(797,369))};
        
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
        addObject(pressureswitch, 660, 571);
        
        edgeicon edgei=new edgeicon();
        addObject(edgei, 350, 500);
        

        //pressureswitch.setLocation(913, 490);
        pSwitch = pressureswitch;
        TriRobot trirobot = new TriRobot();
        addObject(trirobot, 338, 80);
        trirobot.setLocation(339, 77);
        trirobot.setLocation(362, 77);
        nWorld = new Level2World();
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
