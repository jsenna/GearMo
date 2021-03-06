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
    int count = 0;
    double verX, verY;
    double lowest;
    double save;
    public int imageTimer = 20;
    Vertex V1, V2;
    int img=0;
    int JJ,KK;
    int JJ2, KK2;
    double savestartx=0,savestarty=0, saveendx=0, saveendy=0;
    /**
     * Act - do whatever the BallIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(((LevelArea) getWorld()).build==true)
        {
            if(tool==true)
            {
                if(Greenfoot.mouseClicked(world))
                {
                    MouseInfo mouse=Greenfoot.getMouseInfo();
                    if(count==1)
                    {
                        saveendx=mouse.getX();
                        saveendy=mouse.getY();
                        lowest=10;
                        
                        //System.out.println("end " + saveendx + " " + saveendy);
                        
                         for(int j=0;j<((LevelArea) getWorld()).jellO.shapes.size();j++)
                        {
                            for(int k=0; k<((LevelArea) getWorld()).jellO.shapes.get(j).vertices.length;k++)
                            {
                                verX= ((LevelArea) getWorld()).jellO.shapes.get(j).vertices[k].x;
                                verY= ((LevelArea) getWorld()).jellO.shapes.get(j).vertices[k].y;
                                
                                double dis=calcDistance(verX,verY,saveendx,saveendy);
                                if(dis<lowest)
                                {
                                    lowest=dis;
                                    V2= ((LevelArea) getWorld()).jellO.shapes.get(j).vertices[k];
                                    JJ2=j;
                                    KK2=k;
                                    //System.out.println("New lowest " + V2.x + " " + V2.y);
                                }
                                //System.out.println("distance: " + dis);
                                //System.out.println(dis);
                                //System.out.println(k+ " x: " + verX + " y: "+ verY);
                            }
                        }
                        
                        //System.out.println("lowest: " + lowest);
                        
                        if(lowest==10)
                        {
                            count--;
                        }
                        
                        //System.out.println("V1 " + V1.x + " " + V1.y + "V2 " + V2.x + " " + V2.y);
                        // System.out.println(((TheWorld) getWorld()).jellO.edges.size());
                     
                        //System.out.println(((TheWorld) getWorld()).jellO.edges.size());
                        count++;
                        if(count==2)
                        {
                            for(int i = 0; i < 3; i++)
                                ((LevelArea) getWorld()).jellO.edges.add(new Edge(((LevelArea) getWorld()).jellO.shapes.get(JJ).vertices[KK], ((LevelArea) getWorld()).jellO.shapes.get(JJ2).vertices[KK2], 1.0));
                            tool=false;
                            setImage("Rodoff.png");
                        }
                    }
                    if(count==0)
                    {
                        savestartx=mouse.getX();
                        savestarty=mouse.getY();
                        lowest=10;
                        
                        //System.out.println("start " + savestartx + " " + savestarty);
                        
                        for(int j=0;j<((LevelArea) getWorld()).jellO.shapes.size();j++)
                        {
                            for(int k=0; k<((LevelArea) getWorld()).jellO.shapes.get(j).vertices.length;k++)
                            {
                                verX= ((LevelArea) getWorld()).jellO.shapes.get(j).vertices[k].x;
                                verY= ((LevelArea) getWorld()).jellO.shapes.get(j).vertices[k].y;
                                
                                double dis=calcDistance(verX,verY,savestartx,savestarty);
                                if(dis<lowest)
                                {
                                    lowest=dis;
                                    V1= ((LevelArea) getWorld()).jellO.shapes.get(j).vertices[k];
                                    JJ = j;
                                    KK = k;
                                }
                                //System.out.println("distance: " + dis);
                                //System.out.println(dis);
                                //System.out.println(k+ " x: " + verX + " y: "+ verY);
                            }
                        }
                        //System.out.println("lowest: " + lowest);
                        if(lowest==10)
                        {
                            count--;
                        }
                        count++;
                    }
                }
            }
            if (Greenfoot.mouseClicked(this)) 
            {
                if(tool==false){
                    tool=true;
                    count=0;
                    setImage("Rodred1.png");
                }
                else{
                    tool=false;
                    setImage("Rodoff.png");
                }
            }
            if(tool==false)
            {
                setImage("Rodoff.png");
            }
            if(count==0 && tool==true)
            {
                   if(imageTimer > 0){
                       imageTimer += -1;
                   }
                   if(imageTimer <= 0){
                       imageTimer = 20;
                       animateR();
                    }
            }
            if(count==1)
            {
                   if(imageTimer > 0){
                       imageTimer += -1;
                   }
                   if(imageTimer <= 0){
                       imageTimer = 20;
                       animateB();
                    }
            }
        }
    }
    
    private double calcDistance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)); 
    }    
    
    public void animateR(){
       if(img == 1){
        img = 0;
        setImage("Rodred1.png");
        }
        else if(img == 0){
        img = 1;
        setImage("Rodred2.png");
       }
    }
    
    public void animateB(){
       if(img == 1){
           img = 0;
           setImage("Rodblue1.png");
        }
        else if(img == 0){
           img = 1;
           setImage("Rodblue2.png");
        }
    }
}
