import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int buttonUp = 0;
    public boolean onThis = false;
    public void act() 
    {
      GreenfootImage img = getImage();
      
      if(Greenfoot.mouseMoved(null)){
           onThis = Greenfoot.mouseMoved(this);
        }
    
      
      if(onThis){
         img.scale(300,160);  
        setImage(img);
        }
      else{
        img.scale(150,80);
        setImage(img);
        }
      
        
                   if(Greenfoot.mouseClicked(this)){
          Greenfoot.playSound("click.mp3");
        }
        

      
    }   
}
