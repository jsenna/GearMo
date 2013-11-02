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
        boolean mc=false;
        public void act() 
        {
            if(mc==false);
            {
                setImage("Options.png");
            }
            if (Greenfoot.mouseClicked(this)) 
            {
                mc=true;
                if(toggle==false)
                {
                    toggle(true);
                }
                if(toggle==true)
                {
                    toggle(false);
                }
            }
        }    
        
        public void toggle(boolean b)
        {
            if(b==false)
            {
                toggle=true;
                ((TitleScreen) getWorld()).music.setVolume(0);
            }
            if(b==true)
            {
                toggle=false;
                ((TitleScreen) getWorld()).music.setVolume(50);
            }
        }
}
