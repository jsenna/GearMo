import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public int soundPlay = 0;
    public int mv=50;
    public GreenfootSound music;
    public GreenfootSound voice;
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
        //Greenfoot.playSound("Rolemusic_-_Savage_Steel_Fun_Club.mp3");
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        music = new GreenfootSound("Rolemusic_-_Savage_Steel_Fun_Club.mp3");
        voice = new GreenfootSound("gearmo.mp3");
        music.setVolume(mv);
        Title title = new Title();
        addObject(title, 85, 71);
        title.setLocation(341, 176);
        Button button = new Button();
        addObject(button, 107, 253);
        removeObject(button);
        TitleButton titlebutton = new TitleButton();
        addObject(titlebutton, 165, 267);
        titlebutton.setLocation(158, 263);
        HelpButton helpbutton = new HelpButton();
        addObject(helpbutton, 466, 269);
        titlebutton.setLocation(154, 268);
        helpbutton.setLocation(455, 269);
        titlebutton.setLocation(152, 269);
        helpbutton.setLocation(452, 268);
        //Greenfoot.playSound("Rolemusic_-_Savage_Steel_Fun_Club.mp3");
        removeObject(titlebutton);
        removeObject(helpbutton);
        removeObject(title);
        TitleGear titlegear = new TitleGear();
        addObject(titlegear, 300, 200);
        titlegear.setLocation(303, 198);
        gearmo gm= new gearmo();
        addObject(gm, 300,200);
        Title title2 = new Title();
        addObject(title2, 252, 79);
        title2.setLocation(346, 141);
        TitleButton titlebutton2 = new TitleButton();
        addObject(titlebutton2, 157, 293);
        HelpButton helpbutton2 = new HelpButton();
        addObject(helpbutton2, 461, 297);
        helpbutton2.setLocation(455, 292);
        titlebutton2.setLocation(149, 291);
        helpbutton2.setLocation(449, 291);
        titlegear.setLocation(300, 243);
        titlegear.setLocation(300, 200);
        
        
       Options option= new Options();
       addObject(option, 480, 50);
       Mplus mp= new Mplus();
       addObject(mp,546,50);
       Mminus mm= new Mminus();
       addObject(mm,414,50);
        
    }
    
    public void started(){
        voice.play();
    }
    public void stopped(){
        music.stop();
        soundPlay = 0;
        Greenfoot.playSound("yippee.mp3");
    }

    public void act(){
       if(!voice.isPlaying() && soundPlay == 0){
           soundPlay = 1;
           music.playLoop();
        }
    }
    
}
