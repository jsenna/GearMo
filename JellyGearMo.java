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
        
        vertices = new Vertex[] {bl, br};
        edges = new Edge[] {new Edge(bl, br)};
    }
    
    public void act()
    {
        super.act();
        double xDiff = bl.getX() - br.getX();
        double yDiff = bl.getY() - br.getY();
        double angle = Math.atan2(yDiff, xDiff);
        
        //((TheWorld) getWorld()).gearmo.setRotation(angle);
    }
        
        
}
