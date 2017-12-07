import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Snake Game Manager
 * @author Zakery Clarke
 * @class CS-251-002
 * @date 11/24/17
 */

public class GameManager{
   int width=0;
   int height=0;
   Snake snake;
   ArrayList<Wall> walls;
   Food food;
   public GameManager(String file) {
       this.walls = new ArrayList<Wall>();//creates an array list to store the walls
       //reads in the file format
       try(BufferedReader br = new BufferedReader(new FileReader(file))) {
           for(String line; (line = br.readLine()) != null; ) {
               String[] fa = line.split(" ");
               if(fa.length<3) {
                   this.width=Integer.parseInt(fa[0]);//sets the width
                   this.height=Integer.parseInt(fa[1]);//sets the height
               }else {
                   int a=Integer.parseInt(fa[0]);
                   int b=Integer.parseInt(fa[1]);
                   int c=Integer.parseInt(fa[2]);
                   int d=Integer.parseInt(fa[3]);
                   for(int y=b;y<d+1;y++) {
                       for(int x=a;x<c+1;x++) {
                               this.walls.add(new Wall(x,y));//adds a new wall for every coordinate within the specified rectangle
                       }
                   }    

               }
           }
       } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
       //spawns snake and food randomly, but we dont want random yet
       /*
       int x=(int) Math.floor(Math.random()*width);
       int y=(int) Math.floor(Math.random()*height);
       while(openposition(x,y)!="Empty") {
           x=(int) Math.floor(Math.random()*width);
           y=(int) Math.floor(Math.random()*height);
       }
       this.snake=new Snake(x,y,0);
       
       x=(int) Math.floor(Math.random()*width);
       y=(int) Math.floor(Math.random()*height);
       while(openposition(x,y)!="Empty") {
           x=(int) Math.floor(Math.random()*width);
           y=(int) Math.floor(Math.random()*height);
       }
       this.food=new Food(0,0);
       */
       //will remove this -v
       this.snake=new Snake(2,4,0);//creates a snake at a specific coordinate
       this.food=new Food(12,3);//creates a food at a specific coordinate
   }
   /**
    * Prints the string representation of the current board     
    */
   public String printboard() {
       String guitxt="";
        for(int y=0;y<height;y++) {
            for(int x=0;x<width;x++) {
                String o=".";
                for(int i=0;i<walls.size();i++) {
                    Wall wall=walls.get(i);
                    if(wall.x==x && wall.y==y) {
                        o="X";//adds a wall if there is a wall
                    }
                }
                if(snake.x==x && snake.y==y) {
                    o="S";//adds a snake head if there is a snake head
                }
                for(int i=0;i<snake.tail.size();i++) {
                    if(snake.tail.get(i).x==x && snake.tail.get(i).y==y) {
                        o="s";//adds a snake tail if there is a snake tail
                    }   
                }
                if(food.x==x && food.y==y) {
                    o="f";//adds a food if there is a food at coordinate
                }
                System.out.print(o);//prints the board chararacter
                guitxt=guitxt+o;
            } 
            System.out.println();
        }
        return guitxt;
   }
   /**
    * Used to determine what object occupies a coordinate
    * @param x the x coor to test
    * @param y the y coor to test
    * @return a string of the object at that coordinate
    */
   public String openposition(int x,int y) {
       String o="Empty";
       for(int i=0;i<walls.size();i++) {
           if(walls.get(i).x==x && walls.get(i).y==y) {
               o="Wall";
           }
       }
       
       for(int i=0;i<this.snake.tail.size();i++) {
           if(this.snake.tail.get(i).x==x && this.snake.tail.get(i).y==y) {
               o="Tail";
           }
       }
       if(this.snake.x==this.food.x && this.snake.y==this.food.y) {
           o="Food";
       }
       return o;
   }
   /**
    * moves the snake
    */
   public void move() {
       snake.move();//moves the snake
       //check for collisions
       if(openposition(this.snake.x,this.snake.y)==("Wall")||openposition(snake.x,snake.y)==("Tail")){
           System.out.println("Collided with "+openposition(this.snake.x,this.snake.y));
       }
       //check for eating
       if(openposition(this.snake.x,this.snake.y)=="Food"){
           System.out.println("Ate");
           int x=(int) Math.floor(Math.random()*width);
           int y=(int) Math.floor(Math.random()*height);
           this.food.x=-1;//remove food from the board
           this.food.y=-1;
           while(!openposition(x,y).equals("Empty")){
               x=(int) Math.floor(Math.random()*width);
               y=(int) Math.floor(Math.random()*height);
           }
           
           this.food.x=x;
           this.food.y=y;
           this.snake.length++;//snake grows when eating
       }
       printboard();//outputs the board
       
   }
   /**
    * change the snakes direction
    * @param d the direction(0=up,1=left,2=right,3=down)
    */
   public void direction(int d) {
       System.out.println(snake.direction(d));  
   }

public ArrayList<Wall> getwalls(){
return this.walls;    
}

}
    
