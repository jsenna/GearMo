import greenfoot.*;
import java.awt.Color;
public abstract class JellyShape extends Actor {
    private static final double ACCEL = 0.5;
    public GreenfootImage img = new GreenfootImage(TheWorld.WIDTH, TheWorld.HEIGHT);
    protected Vertex[] vertices;
    protected Edge[] edges;
    public double torque = 0;
    public int lvl = 1;
    
    /*public Edge world_edges[] = {new Edge(new Vertex(0,266),new Vertex(354,452)),
                           new Edge(new Vertex(354,452),new Vertex(559,452)),
                           new Edge(new Vertex(559,452),new Vertex(649,369)),
                           new Edge(new Vertex(649,369),new Vertex(797,369))};*/
    
        public Edge world_edges2[] = {new Edge(new Vertex(0,93),new Vertex(696,93)),
                           new Edge(new Vertex(696,93),new Vertex(696,490)),
                           new Edge(new Vertex(696,490),new Vertex(0,490))};                       
        
        public Edge world_edges3[] = {new Edge(new Vertex(0,203),new Vertex(165,203)),
                           new Edge(new Vertex(165,203),new Vertex(250,294)),
                           new Edge(new Vertex(250,294),new Vertex(329,203)),
                           new Edge(new Vertex(329,203),new Vertex(406,294)),
                           new Edge(new Vertex(406,294),new Vertex(481,203)),
                           new Edge(new Vertex(481,203),new Vertex(555,294)), 
                           new Edge(new Vertex(559,294),new Vertex(700,337)),
                           new Edge(new Vertex(700,337),new Vertex(673,366)),
                           new Edge(new Vertex(673,366),new Vertex(0,366)),
                           new Edge(new Vertex(555,0),new Vertex(0,266)),
                           new Edge(new Vertex(0,593),new Vertex(867,382)),
                           };                       
                           
        public Edge plate_edges[] = {new Edge(new Vertex(460,251),new Vertex(610,251)),
                           new Edge(new Vertex(610,251),new Vertex(610,291)),
                           new Edge(new Vertex(610,291),new Vertex(460,291)),
                           new Edge(new Vertex(460,291),new Vertex(460,251))};                       
    
                           
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
        
        if(((LevelArea) getWorld()).engine)
        {
            updateImage();
        
            processMovement();
        
            processPhysics();
        }
        if(getWorld().getClass().getName() == "TheWorld"){
           lvl = 1;
        }
        if(getWorld().getClass().getName() == "Level2World"){
           lvl = 2;
        }
        if(getWorld().getClass().getName() == "Level3World"){
           lvl=3;
        }
        
    }
    
    public void updateImage() {

        // Clear the image.
        img.clear();
        
        // Fill with the base color
        img.setColor(Color.RED);
        int[] xPoints = new int[vertices.length /*- 1*/];
        int[] yPoints = new int[vertices.length /*- 1*/];
        for(int i = 0; i < vertices.length /*- 1*/; i++) {
            xPoints[i] = vertices[i].getRoundedX();
            yPoints[i] = vertices[i].getRoundedY();
        }
        img.fillPolygon(xPoints, yPoints, vertices.length /*- 1*/);
        
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
            double _torque = torque;
            
            if(shouldSpinRight)
            {
                _torque = -.25;
            }
            if(shouldSpinLeft)
            {
                _torque = .25;
            }
            
            vertices[i].incVSpeed(_torque * Math.sin(angle));
            vertices[i].incHSpeed(_torque * Math.cos(angle));
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
            checkWallCollisions(v);
        }
    }
    
    public void checkWallCollisions(Vertex v) {
        if(v.x < 0) {
            v.isColliding = true;
            v.x = 0;
            v.stop();
        } else if(v.x >= TheWorld.WIDTH) {
            v.isColliding = true;
            v.x = TheWorld.WIDTH - 1;
            v.stop();
        }
        if(v.y < 0) {
            v.isColliding = true;
            v.y = 0;
            v.stop();
        } else if(v.y >= TheWorld.HEIGHT) {
            v.isColliding = true;
            v.y = TheWorld.HEIGHT - 1;
            v.stop();
        }
        Edge[] world_edges_U = ((LevelArea) getWorld()).world_edges_U;
        Edge[] world_edges_D = ((LevelArea) getWorld()).world_edges_D;
        
        for(int i = 0; i < world_edges_D.length; i++)
        {
            if( v.x > world_edges_D[i].first.x && v.x < world_edges_D[i].second.x)
            {
                double diffX = v.x - world_edges_D[i].first.x;
                double diffEdge = world_edges_D[i].second.x - world_edges_D[i].first.x;
                double yEdge = world_edges_D[i].first.y + (world_edges_D[i].second.y - world_edges_D[i].first.y)*(diffX/diffEdge);
                if(v.y > yEdge)
                {
                    v.isColliding = true;
                    v.y = yEdge;
                    v.stop();
                }
            }
        }
        for(int i = 0; i < world_edges_U.length; i++)
        {
            if( v.x > world_edges_U[i].first.x && v.x < world_edges_U[i].second.x)
            {
                double diffX = v.x - world_edges_U[i].first.x;
                double diffEdge = world_edges_U[i].second.x - world_edges_U[i].first.x;
                double yEdge = world_edges_U[i].first.y + (world_edges_U[i].second.y - world_edges_U[i].first.y)*(diffX/diffEdge);
                if(v.y < yEdge)
                {
                    v.isColliding = true;
                    v.y = yEdge;
                    v.stop();
                }
            }
        }
        
        for(int i = 0; i < plate_edges.length; i++)
        {
            if( v.x > plate_edges[i].first.x && v.x < plate_edges[i].second.x)
            {
                double diffX = v.x - plate_edges[i].first.x;
                double diffEdge = plate_edges[i].second.x - plate_edges[i].first.x;
                double yEdge = plate_edges[i].first.y + (plate_edges[i].second.y - plate_edges[i].first.y)*(diffX/diffEdge);
                if(v.y > yEdge)
                {
                    /*v.isColliding = true;
                    v.y = yEdge;
                    v.stop();*/
                    ((LevelArea) getWorld()).pSwitch.activate();
                }
            }
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
