import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;

/**
 * Write a description of class JellyObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JellyObject extends Actor
{
    private static final double ACCEL = 0.5;
    private GreenfootImage img = new GreenfootImage(TheWorld.WIDTH, TheWorld.HEIGHT);
    public ArrayList<JellyShape> shapes= new ArrayList<JellyShape>();
    public ArrayList<Edge> edges= new ArrayList<Edge>();
    
    public Edge world_edges[] = {new Edge(new Vertex(0,150),new Vertex(270,290)),
                           new Edge(new Vertex(270,290),new Vertex(420,290)),
                           new Edge(new Vertex(420,290),new Vertex(485,250)),
                           new Edge(new Vertex(485,250),new Vertex(600,250))};
    
    public void addedToWorld(World w) {
        setImage(img);
        
        setLocation(TheWorld.WIDTH/2, TheWorld.HEIGHT/2);
        
        updateImage();
    }
    public void addShape(JellyShape j, int x, int y)
    {
        shapes.add(j);
        getWorld().addObject(j,x,y);
    }
    public void act() {
        updateImage();
        
        processMovement();
        
        processPhysics();
    }
    
    private void updateImage() {
        // Clear the image.
        img.clear();
        
        /*// Fill with the base color
        img.setColor(Color.RED);
        int[] xPoints = new int[vertices.length - 1];
        int[] yPoints = new int[vertices.length - 1];
        for(int i = 0; i < vertices.length - 1; i++) {
            xPoints[i] = vertices[i].getRoundedX();
            yPoints[i] = vertices[i].getRoundedY();
        }
        img.fillPolygon(xPoints, yPoints, vertices.length - 1);*/
        
        // Draw all our edges
        img.setColor(Color.BLACK);
        for(Edge e : edges) {
            int x1 = e.getFirst().getRoundedX();
            int y1 = e.getFirst().getRoundedY();
            int x2 = e.getSecond().getRoundedX();
            int y2 = e.getSecond().getRoundedY();
            img.drawLine(x1, y1, x2, y2);
        }
    }
    
    private void processMovement() {
        /*
        // We use the WASD keys for movement.
        boolean shouldMoveUp    = Greenfoot.isKeyDown("w");
        boolean shouldMoveLeft  = Greenfoot.isKeyDown("a");
        boolean shouldMoveDown  = Greenfoot.isKeyDown("s");
        boolean shouldMoveRight = Greenfoot.isKeyDown("d");
        
        boolean shouldSpinRight    = Greenfoot.isKeyDown("right");
        boolean shouldSpinLeft  = Greenfoot.isKeyDown("left");
        
        for(int i = 0; i < vertices.length - 1; i++) {
            if(shouldMoveDown)  vertices[i].incVSpeed(ACCEL);
            if(shouldMoveUp)    vertices[i].decVSpeed(ACCEL);
            if(shouldMoveRight) vertices[i].incHSpeed(ACCEL);
            if(shouldMoveLeft)  vertices[i].decHSpeed(ACCEL);
            
            
            double xDiff = vertices[i].getX() - vertices[((i+1)%(vertices.length - 1))].getX();
            double yDiff = vertices[i].getY() - vertices[((i+1)%(vertices.length - 1))].getY();
            double angle = Math.atan2(yDiff, xDiff);
            
            if(shouldSpinRight)
            {
                vertices[i].incVSpeed(-.25 * Math.sin(angle));
                vertices[i].incHSpeed(-.25 * Math.cos(angle));
            }
            if(shouldSpinLeft)
            {
                vertices[i].incVSpeed(.25 * Math.sin(angle));
                vertices[i].incHSpeed(.25 * Math.cos(angle));
            }
        }
        */
    
    }
    
    private void processPhysics() {
        for(Edge e : edges) {
            Vertex first  = e.getFirst();
            Vertex second = e.getSecond();
            double xDiff = first.getX() - second.getX();
            double yDiff = first.getY() - second.getY();
            double length = e.getLength() - Math.hypot(xDiff, yDiff);
            //if(Math.abs(length) > 50.0)
                //length = 50 * Math.abs(length)/length;
            length /= 10;
            double angle = Math.atan2(yDiff, xDiff);
            double xvv = length * Math.cos(angle);
            double yvv = length * Math.sin(angle);
            
            first.incHSSpeed(xvv);
            first.incVSSpeed(yvv);
            second.decHSSpeed(xvv);
            second.decVSSpeed(yvv);
        }
    }
    
    /**d
     * Faster than (int)Math.round(value)
     * 
     * See http://myscrambledmind.com/blog/?p=43
     */
    private int round(double value) {
        return (int)(value + 0.5);
    }
}

