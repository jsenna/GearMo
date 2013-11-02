import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Edge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Edge {
        public Vertex first;
        public Vertex second;
        public double length;
        public double stiffness = 1;
        
        Edge(Vertex first, Vertex second) {
            this.first = first;
            this.second = second;
            double xDiff = first.getX() - second.getX();
            double yDiff = first.getY() - second.getY();
            length = Math.hypot(xDiff, yDiff);
        }
        
        Edge(Vertex first, Vertex second, double _stiffness) {
            this.first = first;
            this.second = second;
            double xDiff = first.getX() - second.getX();
            double yDiff = first.getY() - second.getY();
            length = Math.hypot(xDiff, yDiff);
            stiffness = _stiffness;
        }
        
        // Getters
        public Vertex getFirst() { return first; }
        public Vertex getSecond() { return second; }
        public double getLength() { return length; }
    }
