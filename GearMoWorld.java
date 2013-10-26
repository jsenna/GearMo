import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GearMoWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GearMoWorld extends World
{

    /**
     * Constructor for objects of class GearMoWorld.
     * 
     */
    public GearMoWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
        Greenfoot.playSound("Rolemusic_-_04_-_Scape_from_the_city.mp3");
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {

        Level1 level1 = new Level1();
        addObject(level1, 303, 202);
        level1.setLocation(301, 199);
        level1.setLocation(299, 198);
        level1.setLocation(300, 201);
        level1.setLocation(299, 199);
        level1.setLocation(300, 199);
        level1.setLocation(300, 199);
        level1.setLocation(300, 200);
    }
}
