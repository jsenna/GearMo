import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vertex here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vertex {
    public double x;
    public double y;
    public double hSpeed = 0;
    public double vSpeed = 0;
    public double springXVel = 0;
    public double springYVel = 0;
    
    boolean isCollidingWall = false;
    boolean isCollidingD = false;
    boolean isCollidingU = false;
    
    Vertex(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void move() {
        x += hSpeed + springXVel;
        y += vSpeed + springYVel;
    }
    
    public void slow() {
        /*if(Math.abs(hSpeed) > 3.0)
            hSpeed = 3.0 * Math.abs(hSpeed)/hSpeed;
        if(Math.abs(vSpeed) > 3.0)
            vSpeed = 3.0 * Math.abs(vSpeed)/vSpeed;*/
        hSpeed *= 0.98;
        vSpeed *= 0.98;
        
            springXVel *= .98;
            springYVel *= .98;
        
       
    }
    
    public void incX(double val) {
        x += val;
    }
    public void incY(double val) {
        y += val;
    }
    
    public void incHSpeed(double val) {
        hSpeed += val;
    }
    public void decHSpeed(double val) {
        hSpeed -= val;
    }
    public void incVSpeed(double val) {
        vSpeed += val;
    }
    public void decVSpeed(double val) {
        vSpeed -= val;
    }
    
    public void incHSSpeed(double val) {
        springXVel += val;
    }
    public void decHSSpeed(double val) {
        springXVel -= val;
    }
    public void incVSSpeed(double val) {
        springYVel += val;
    }
    public void decVSSpeed(double val) {
        springYVel -= val;
    }
    
    public int getRoundedX() {
        return round(x);
    }
    public int getRoundedY() {
        return round(y);
    }
    
    public void stop() {
        hSpeed = 0;
        vSpeed = 0;
        
        springXVel = 0;
        springYVel = 0;
    }
    
    public int round(double value) {
        return (int)(value + 0.5);
    }
    
    // Getters and setters
    public double getX() { return x; }
    public double getY() { return y; }
    public double getHSpeed() { return hSpeed; }
    public double getVSpeed() { return vSpeed; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setHSpeed(double hSpeed) { this.hSpeed = hSpeed; }
    public void setVSpeed(double vSpeed) { this.vSpeed = vSpeed; }
}
