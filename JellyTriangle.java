import greenfoot.*;
public class JellyTriangle extends JellyShape {
    public JellyTriangle(int sideLength) {
        double l = sideLength;
        double h = l * Math.sin(Math.toRadians(60));
        l /= 2;
        h /= 2;
        Vertex top      = new Vertex( 0, -h);
        Vertex botRight = new Vertex( l,  h);
        Vertex botLeft  = new Vertex(-l,  h);
        vertices = new Vertex[] {
            top,
            botRight,
            botLeft
        };
        edges = new Edge[] {
            new Edge(top,     botLeft),
            new Edge(top,     botRight),
            new Edge(botLeft, botRight)
        };
    }
}
