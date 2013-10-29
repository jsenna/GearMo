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
        //Vertex tl = new Vertex(-30, -50);
        //Vertex tr = new Vertex(30, -50);
        
        vertices = new Vertex[] {bl, br};//, tl, tr};
        edges = new Edge[] {new Edge(bl, br)};/*, new Edge(tl, tr), new Edge(bl, tl), new Edge(br, tr)
        , new Edge(bl, tr), new Edge(br, tl)};*/
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
        System.out.println("angle " + angle + "avg " + xAvg + " " + yAvg);
        ((TheWorld) getWorld()).gearmo.setLocation((int)imgX, (int)imgY);
        ((TheWorld) getWorld()).gearmo.setRotation((int)(angle * (180/3.14)));
        
    }
        
        
}
