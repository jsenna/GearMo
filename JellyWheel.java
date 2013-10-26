import greenfoot.*;
public class JellyWheel extends JellyShape {
    public JellyWheel(double radius) {
   
        int points = 15;
        
        vertices = new Vertex[points + 1];
        
        for(int i = 0; i < points; i++)
        {
            double theta = 2 * 3.141592653 * ((double)i / (double)points);
            System.out.println(theta + " " + i + " " + radius + " " + Math.cos(theta) + " " + Math.sin(theta));
            vertices[i] = new Vertex(radius * Math.cos(theta), radius * Math.sin(theta));
            System.out.println("x: [" + radius * Math.cos(theta) +"] y: [" + radius * Math.sin(theta));
        }
        
        vertices[points] = new Vertex(0, 0);
        edges = new Edge[points * (points + 1)];
        
        for(int i = 0; i < points; i++)
        {
            for(int j = 0; j < points; j++)
            {
                edges[i*points + j] = new Edge(vertices[i], vertices[j]);
            }
            edges[points * points + i] = new Edge(vertices[i], vertices[points]);
        }
        
    }
}
