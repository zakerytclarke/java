/**
 * Game Manager Tester
 * @author Zakery Clarke
 * @class CS-251-002
 * @date 11/24/17
 */

public class GameManagerTest{
    /**
     * tests my game manager class
     * @param args null
     */
   public static void main(String [] args)
   {
       
           GameManager game=new GameManager("maze1.txt");
           game.printboard();
           game.move();
           game.direction(2);
           for(int i=0;i<10;i++) {
               game.move();
           }
           System.out.println("Create a different board");
           GameManager game2=new GameManager("maze2.txt");
           game2.printboard();
           game2.direction(0);
           for(int i=0;i<4;i++) {
               game2.move();
           }
           System.out.println("Back to the Original Board");
           game.direction(0);
           game.move();
           game.move();
           game.direction(1);
           game.move();
           game.move();
           game.direction(3);
           game.move();
           game.move();
   
   }
}