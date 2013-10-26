import greenfoot.*;
public class JellyPentagon extends JellyShape {
    public JellyPentagon() {
        Vertex top      = new Vertex(  0, -25);
        Vertex right    = new Vertex( 25, - 6);
        Vertex left     = new Vertex(-25, - 6);
        Vertex botRight = new Vertex( 16,  25);
        Vertex botLeft  = new Vertex(-16,  25);
        vertices = new Vertex[] {
            top,
            right,
            botRight,
            botLeft,
            left
        };
        edges = new Edge[] {
            new Edge(top,     left),
            new Edge(top,     right),
            new Edge(top,     botLeft),
            new Edge(top,     botRight),
            new Edge(left,    right),
            new Edge(left,    botLeft),
            new Edge(left,    botRight),
            new Edge(right,   botLeft),
            new Edge(right,   botRight),
            new Edge(botLeft, botRight)
        };
    }
}
