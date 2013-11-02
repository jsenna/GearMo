import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends Button
{
    /**
     * Act - do whatever the Options wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
        boolean toggle=true;
      
        public Options()
        {
            setImage("Options.png");
        }
        public void act() 
        {
            if (Greenfoot.mouseClicked(this)) 
            {
                if(toggle==false)
                {
                    toggle=false;
                    toggle(true);
                }
                if(toggle==true)
                {
                    toggle=true;
                    toggle(false);
                }
            }
        }    
        
        public void toggle(boolean b)
        {
            if(b==false)
            {
                ((TitleScreen) getWorld()).music.setVolume(0);
            }
            if(b==true)
            {
                System.out.println("hi");
                ((TitleScreen) getWorld()).music.setVolume(((TitleScreen) getWorld()).mv);
            }
        }
}
