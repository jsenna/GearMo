import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JellyGearMo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JellyGearMo extends JellyShape
{
    /**
     * Act - do whatever the JellyGearMo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Vertex bl;
    public Vertex br;
    public JellyGearMo()
    {
        bl = new Vertex(-30, 0);
        br = new Vertex(30,0);
        Vertex ml1 = new Vertex(-45, -40);
        Vertex ml2 = new Vertex(-45, -70);
        Vertex mr1 = new Vertex(45, -40);
        Vertex mr2 = new Vertex(45, -70);
        Vertex top = new Vertex(0, -90);
        
        vertices = new Vertex[] {bl, br, ml1, ml2, mr1, mr2, top};
        edges = new Edge[vertices.length * vertices.length];
        for(int i = 0; i < vertices.length; i++)
        {
            for(int j = 0; j < vertices.length; j++)
            {
                edges[i*vertices.length + j] = new Edge(vertices[i], vertices[j]);
            }
        }
    }
    
    public void act()
    {
        super.act();
        double xDiff = br.x - bl.x;
        double yDiff = br.y - bl.y;
        double angle = Math.atan2(yDiff, xDiff);
        
        double xAvg = (bl.x + br.x)/2;
        double yAvg = (bl.y + br.y)/2;
        double imgX = xAvg + 46* Math.sin(angle);
        double imgY = yAvg - 46* Math.cos(angle);
        //System.out.println("angle " + angle + "avg " + xAvg + " " + yAvg);
        ((LevelArea) getWorld()).gearmo.setLocation((int)imgX, (int)imgY);
        ((LevelArea) getWorld()).gearmo.setRotation((int)(angle * (180/3.14)));
        
    }
    
     public void updateImage() {
         return;
    }      
}
