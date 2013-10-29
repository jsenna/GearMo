import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JellyCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JellyCar extends JellyObject
{
    /**
     * Act - do whatever the JellyCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    double radius;
    public JellyCar(double _radius)
    {
        //shapes = new JellyShape[2];
        //edges = new Edge[1];
        radius = _radius;
        
        shapes.add(new JellyWheel(radius));
        shapes.add(new JellyWheel(radius));
    }
    
    public void addedToWorld(World w) {
        //getWorld().addObject(shapes[0], getX(), getY());
        getWorld().addObject(shapes.get(0), getX(), getY());
        //getWorld().addObject(shapes[1], getX() + (int)radius*2, getY());
        getWorld().addObject(shapes.get(1), getX() + (int)radius*2, getY());
        //edges[0] = new Edge(shapes[0].vertices[10], shapes[1].vertices[10]);
        edges.add(new Edge(shapes.get(0).vertices[10], shapes.get(1).vertices[10]));
        super.addedToWorld(w);
    }
        
        
     
}
