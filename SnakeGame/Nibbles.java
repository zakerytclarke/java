/**
 * Nibbles
 * @author Zakery Clarke
 * @class CS-251-002
 * @date 11/11/17
 */
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Layout Practice
 * Creates a practice layout
 */
public class Nibbles extends JPanel{
    static int x=0;//number of clicks
    static int width=0;
    static int height=0;
    static GameManager game=new GameManager("maze1.txt");
  
    
    /**
     * Creates a new JPanel
     * 
     */
        public static class MyPanel extends JPanel {
            
            public MyPanel() {
                setPreferredSize(new Dimension(width*25,height*25));//window size
                setBackground(Color.BLACK);//background color
            }

            public void paintComponent(Graphics g) {//the panel being drawn on
                super.paintComponent(g);
                g.setColor(Color.GRAY);
                String board=game.printboard();
                for(int y=0;y<height;y++) {
                    for(int x=0;x<width;x++) {
                        String t=board.substring(y*width+x,y*width+x+1);
                        g.setColor(Color.BLACK);
                        if(t.equals("X")){
                            g.setColor(Color.GRAY);
                        }
                        if(t.equals("S")){
                            g.setColor(Color.GREEN);
                        }
                        if(t.equals("s")){
                            g.setColor(Color.GREEN);
                        }
                        if(t.equals("f")){
                            g.setColor(Color.YELLOW);
                        }
                        
                        //System.out.print(t);
                        g.fillRect((x)*25,(y)*25,(x+1)*25,(y+1)*25);//rectangle
                    }

                    System.out.println();
               }
    
            }
        }
        private static void createAndShowGUI() {
  
            final JFrame frame = new JFrame("Nibbles");//name of the frame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            frame.setResizable(false);//dont let the width/height change
    
            JPanel panel = new JPanel();//panel
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
            JPanel borderedPanel = new MyPanel();
            panel.add(borderedPanel);
            JLabel label = new JLabel("Score: "+x);//label that lists the number of clicks
            panel.add(label);//adds the label
            

            JButton button = new JButton("Start");//button;
            panel.add(button);//adds the button
            
            
            button.addActionListener( new ActionListener()//event listener for button click
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                  MyPanel.repaint();
                    game.move();
                }
            });
            
            
            
            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        }
/**
 * Main method of program, creates a JFrame
 * @param args no arguments 
 */
        public static void main(String[] args) {
            
            SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        width=game.width;
                        height=game.height;
                        createAndShowGUI();//creates and draws layout
                        //game.move();
                      
                        Timer t = new Timer( );
                        t.scheduleAtFixedRate(new TimerTask() {

                            @Override
                            public void run() {
                              game.move();
                              
                            }
                        },0,1000);
                        
                    }
                });
        }

    }  