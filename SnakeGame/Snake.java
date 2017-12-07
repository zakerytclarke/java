import java.util.ArrayList;
/**
 * Snake Object
 * @author Zakery Clarke
 * @class CS-251-002
 * @date 11/24/17
 */
public class Snake {
    int x=0;//x coordinate
    int y=0;//y coordinate
    int length=7;//the initial snake length
    int direction=0;//direction
    ArrayList<Wall> tail = new ArrayList<Wall>();//stores the tail as a list of wall objects 
    /**
     * Constructor for the snake
     * @param x the starting x position of the snake
     * @param y the starting x position of the snake
     * @param d the direction the snake is heading(0-up,1-left,3-down,2-right)
     */
    public Snake(int x,int y,int d) {
        this.x=x;
        this.y=y;
        this.direction=d;
    }
    /**
     * Moves the snake by 1 step in its direction
     * @returns a string when the snake has moved
     */
    public String move() {    
        this.tail.add(0,new Wall(x,y));//adds tail
        switch(this.direction) {
        case 0:
            this.y--;
        break;    
        case 1:
            this.x--;
        break;
        case 2:
            this.x++;
        break;    
        case 3:
            this.y++;    
        }
        
        if(this.tail.size()>this.length) {
            this.tail.remove(this.tail.size()-1);//trims tail to length
        }
        return "Moved";    
        }
    /**
     * Change the snakes direction
     * @param d the direction to change(0=up,1=left,2=right,3=down)
     * @return string describing the change
     */
    public String direction(int d) {
        this.direction=d;
        String s="";
        switch(this.direction) {
        case 0:
            s="Up";
        break;    
        case 1:
            s="Left";
        break;
        case 2:
            s="Right";
        break;    
        case 3:
            s="Down";    
        }
        return "Snake changed direction to "+s;
    }
}