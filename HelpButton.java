import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpButton extends Button
{
    /**
     * Act - do whatever the HelpButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int endX;
    public int endY;
    public int animate = 0;
    
    public void act() 
    {
        // Add your action code here.
        super.act();
        if(onThis){
           setImage("helpButton.png");
           
        }
        else{
           setImage("helpButtonSmall.png");
        }
               if(animate == 0){
           animate = 1;
           endX = getX();
           endY = getY();
           setLocation(650,getY());
        }
        if(animate == 1 && getX() > endX){
           setLocation(getX() - 3,getY());
           if(getX() <= endX ){
            animate = 2;
            }
        }
        if(animate == 2){
            //Play sound here
            animate = 3;
        }
        if(Greenfoot.mouseClicked(this)){
            HelpBox hb = new HelpBox();
           getWorld().addObject(hb,300,200);
           //hb.setLocation(300,200);
           
        }        
    }    
}
