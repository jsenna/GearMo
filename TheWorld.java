import greenfoot.*;
import java.awt.Color;
public class TheWorld extends World {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    private static int shapeCounter = 0;
    
    public TheWorld() {
        super(WIDTH, HEIGHT, 1);
        
        GreenfootImage img = new GreenfootImage(WIDTH, HEIGHT);
        img.setColor(Color.CYAN);
        img.fill();
        //setBackground(img);
        
        switch(shapeCounter % 3) {
            case 0:
                addObject(new JellyWheel(50), 100, 100);
                break;
            case 1:
                addObject(new JellyPentagon(), 100, 100);
                break;
            case 2:
                addObject(new JellyTriangle(50), 100, 100);
                break;
        }
        shapeCounter++;
    }
}
