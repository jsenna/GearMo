import greenfoot.*;
import java.awt.Color;
public abstract class JellyShape extends Actor {
    private static final double ACCEL = 0.5;
    private GreenfootImage img = new GreenfootImage(TheWorld.WIDTH, TheWorld.HEIGHT);
    protected Vertex[] vertices;
    protected Edge[] edges;
    
    public Edge world_edges[] = {new Edge(new Vertex(0,150),new Vertex(270,290)),
                           new Edge(new Vertex(270,290),new Vertex(420,290)),
                           new Edge(new Vertex(420,290),new Vertex(485,250)),
                           new Edge(new Vertex(485,250),new Vertex(600,250))};
    
    public void addedToWorld(World w) {
        setImage(img);
        
        for(Vertex v : vertices) {
            v.incX(getX());
            v.incY(getY());
        }
        
        setLocation(TheWorld.WIDTH/2, TheWorld.HEIGHT/2);
        
        updateImage();
    }
    
    public void act() {
        updateImage();
        
        processMovement();
        
        processPhysics();
    }
    
    private void updateImage() {
        // Clear the image.
        img.clear();
        
        // Fill with the base color
        img.setColor(Color.RED);
        int[] xPoints = new int[vertices.length - 1];
        int[] yPoints = new int[vertices.length - 1];
        for(int i = 0; i < vertices.length - 1; i++) {
            xPoints[i] = vertices[i].getRoundedX();
            yPoints[i] = vertices[i].getRoundedY();
        }
        img.fillPolygon(xPoints, yPoints, vertices.length - 1);
        
        // Draw all our edges
        img.setColor(Color.BLACK);
        for(Edge e : edges) {
            int x1 = e.getFirst().getRoundedX();
            int y1 = e.getFirst().getRoundedY();
            int x2 = e.getSecond().getRoundedX();
            int y2 = e.getSecond().getRoundedY();
            //img.drawLine(x1, y1, x2, y2);
        }
    }
    
    private void processMovement() {
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
        
        for(Vertex v : vertices) {
            v.incVSpeed(ACCEL*0.9); //gravity
            v.slow();
            v.move();
            v.checkWallCollisions();
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
    
    protected class Vertex {
        private double x;
        private double y;
        private double hSpeed = 0;
        private double vSpeed = 0;
        private double springXVel = 0;
        private double springYVel = 0;
        
        boolean isColliding = false;
        
        Vertex(double x, double y) {
            this.x = x;
            this.y = y;
        }
        
        public void move() {
            x += hSpeed + springXVel;
            y += vSpeed + springYVel;
        }
        
        public void slow() {
            /*if(Math.abs(hSpeed) > 3.0)
                hSpeed = 3.0 * Math.abs(hSpeed)/hSpeed;
            if(Math.abs(vSpeed) > 3.0)
                vSpeed = 3.0 * Math.abs(vSpeed)/vSpeed;*/
            hSpeed *= 0.98;
            vSpeed *= 0.98;
            
                springXVel *= .98;
                springYVel *= .98;
            
           
        }
        
        public void incX(double val) {
            x += val;
        }
        public void incY(double val) {
            y += val;
        }
        
        public void incHSpeed(double val) {
            hSpeed += val;
        }
        public void decHSpeed(double val) {
            hSpeed -= val;
        }
        public void incVSpeed(double val) {
            vSpeed += val;
        }
        public void decVSpeed(double val) {
            vSpeed -= val;
        }
        
        public void incHSSpeed(double val) {
            springXVel += val;
        }
        public void decHSSpeed(double val) {
            springXVel -= val;
        }
        public void incVSSpeed(double val) {
            springYVel += val;
        }
        public void decVSSpeed(double val) {
            springYVel -= val;
        }
        
        public void checkWallCollisions() {
            if(x < 0) {
                isColliding = true;
                x = 0;
                stop();
            } else if(x >= TheWorld.WIDTH) {
                isColliding = true;
                x = TheWorld.WIDTH - 1;
                stop();
            }
            if(y < 0) {
                isColliding = true;
                y = 0;
                stop();
            } else if(y >= TheWorld.HEIGHT) {
                isColliding = true;
                y = TheWorld.HEIGHT - 1;
                stop();
            }
            
            for(int i = 0; i < world_edges.length; i++)
            {
                if( x > world_edges[i].first.x && x < world_edges[i].second.x)
                {
                    double diffX = x - world_edges[i].first.x;
                    double diffEdge = world_edges[i].second.x - world_edges[i].first.x;
                    double yEdge = world_edges[i].first.y + (world_edges[i].second.y - world_edges[i].first.y)*(diffX/diffEdge);
                    if(y > yEdge)
                    {
                        isColliding = true;
                        y = yEdge;
                        stop();
                    }
                }
            }
        }
        
        public int getRoundedX() {
            return round(x);
        }
        public int getRoundedY() {
            return round(y);
        }
        
        private void stop() {
            hSpeed = 0;
            vSpeed = 0;
            
            springXVel = 0;
            springYVel = 0;
        }
        
        // Getters and setters
        public double getX() { return x; }
        public double getY() { return y; }
        public double getHSpeed() { return hSpeed; }
        public double getVSpeed() { return vSpeed; }
        public void setX(double x) { this.x = x; }
        public void setY(double y) { this.y = y; }
        public void setHSpeed(double hSpeed) { this.hSpeed = hSpeed; }
        public void setVSpeed(double vSpeed) { this.vSpeed = vSpeed; }
    }
    
    protected class Edge {
        private Vertex first;
        private Vertex second;
        private double length;
        
        Edge(Vertex first, Vertex second) {
            this.first = first;
            this.second = second;
            double xDiff = first.getX() - second.getX();
            double yDiff = first.getY() - second.getY();
            length = Math.hypot(xDiff, yDiff);
        }
        
        // Getters
        public Vertex getFirst() { return first; }
        public Vertex getSecond() { return second; }
        public double getLength() { return length; }
    }
}
