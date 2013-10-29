import greenfoot.*;
import java.awt.Color;
public class JellyWheel extends JellyShape {
    public JellyWheel(double radius, double _torque) {
   
        int points = 10;
        torque = _torque;
        vertices = new Vertex[points + 1];
        
        for(int i = 0; i < points; i++)
        {
            double theta = 2 * 3.141592653 * ((double)i / (double)points);
            //System.out.println(theta + " " + i + " " + radius + " " + Math.cos(theta) + " " + Math.sin(theta));
            vertices[i] = new Vertex(radius * Math.cos(theta), radius * Math.sin(theta));
            //System.out.println("x: [" + radius * Math.cos(theta) +"] y: [" + radius * Math.sin(theta));
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
    
    public void updateImage() {

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
        for(int i = 0; i < vertices.length - 1; i++) {
            int x1 = vertices[i].getRoundedX();
            int y1 = vertices[i].getRoundedY();
            int x2 = vertices[(i+1)%(vertices.length - 1)].getRoundedX();
            int y2 = vertices[(i+1)%(vertices.length - 1)].getRoundedY();
            img.drawLine(x1, y1, x2, y2);
        }
    }
}
