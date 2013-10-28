import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The AnimatedActor class serves as a superclass for other, more specific
 * Actor classes. It provides a mechanism to give actors an animated image.
 * 
 * ...more here.. image names
 * 
 * @author mik
 * @version 1.0
 */
public class AnimatedActor extends Mover
{
    private GreenfootImage[] images;
    private int currentImage = 0;
    private int imageBuffer = 3;
    private boolean on= false;
    private int delay=0;
    
    public boolean animateBuffer() 
    {
        if (imageBuffer < 1)
        {
            imageBuffer = 5;
            return true;
        }
        else
            imageBuffer--;
            
        return false;
    }
    
    public AnimatedActor(String basename, String suffix, int noOfImages)
    {
        images = new GreenfootImage[noOfImages];
        for(int i=0; i < noOfImages; i++) {
            images[i] = new GreenfootImage(basename + i + suffix);
        }
        setImage(images[currentImage]);
    }
    
    /**
     * Act - do whatever the AnimatedActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(on ==true)
        {
            if(animateBuffer())
            {
                currentImage = (currentImage + 1) % images.length;
                setImage(images[currentImage]);
            }
            if(delay == 205)
            {
                delay=0;
                on=false;
            }
            delay--;
        }
        if(on==false)
        {
            delay++;
            if(delay==250)
            {
                on=true;
            }
        }
        
    }
}