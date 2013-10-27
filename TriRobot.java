import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TriRobot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TriRobot extends Actor
{
    /**
     * Act - do whatever the TriRobot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int imageTimer = 20;
    public int img = 0;
    public void act() 
    {
      if(imageTimer > 0){
        imageTimer += -1;
        }
        if(imageTimer <= 0){
           imageTimer = 20;
           animate();
        }
        
    }    
    
    public void animate(){
       if(img == 1){
        img = 0;
        setImage("triRobotA.png");
        }
        else if(img == 0){
        img = 1;
        setImage("triRobotB.png");
    }
    }
}
