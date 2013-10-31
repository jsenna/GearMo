import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class edgeicon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class edgeicon extends Actor
{
    public JellyObject JConstruct= new JellyObject();
    TheWorld world= (TheWorld) getWorld();
    public boolean tool=false;
    public boolean mousedown=false;
    int limit = 0 ;
    int count = 0;
    double verX, verY;
    double lowest;
    double low;
    Vertex StartlowV, EndlowV;
    int savestartx=0,savestarty=0, saveendx=0, saveendy=0, x, y;
    public int rotation = 0;
    /**
     * Act - do whatever the BallIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            if(tool==false){
                tool=true;
                setImage("Rod.png");
            }
            else{
                tool=false;
                setImage("Rodoff.png");
            }
        }
        if(tool==true)
        {
            if(Greenfoot.mouseClicked(world))
            {
                MouseInfo mouse=Greenfoot.getMouseInfo();
                if(count==0)
                {
                    savestartx=mouse.getX();
                    savestarty=mouse.getY();
                    System.out.println("start " + savestartx + " " + savestarty);
                }
            }
        }
    }
    
    private double calcDistance(double x1, double y1, double x2, double y2)
    {
        for(int j=0;j<((TheWorld) getWorld()).jellO.shapes.size();j++)
        {
            for(int k=0; k<((TheWorld) getWorld()).jellO.shapes.get(j).vertices.length;k++)
            {
                verX= ((TheWorld) getWorld()).jellO.shapes.get(j).vertices[k].x;
                verY= ((TheWorld) getWorld()).jellO.shapes.get(j).vertices[k].y;
                
                low = ((saveendx-verX)*(saveendx-verX) + (saveendy-verY)*(saveendy-verY));
                StartlowV= ((TheWorld) getWorld()).jellO.shapes.get(j).vertices[k];
                if(low<lowest)
                {
                    lowest=((saveendx-verX)*(saveendx-verX) + (saveendy-verY)*(saveendy-verY));
                    StartlowV= ((TheWorld) getWorld()).jellO.shapes.get(j).vertices[k];
                }
            }
        }
        return 0;
    }
    
} 
