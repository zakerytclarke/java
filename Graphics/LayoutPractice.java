/**
 * Layout Practice
 * @author Zakery Clarke
 * @class CS-251-002
 * @date 11/11/17
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Layout Practice
 * Creates a practice layout
 */
public class LayoutPractice{
    static int x=0;//number of clicks
    /**
     * Creates a new JPanel
     * 
     */
        public static class MyPanel extends JPanel {
            public MyPanel() {
                setPreferredSize(new Dimension(500,500));//window size
                setBackground(Color.BLUE);//background color
            }

            public void paintComponent(Graphics g) {//the panel being drawn on
                super.paintComponent(g);
                for(int i=1;i<20;i+=3) {//loop through shapes
                    Color color = new Color(i*10,20/i,34);//creates a gradient
                    g.setColor(color);//sets the color to the gradient    
                    g.fillRect(10*i,10*i,10*(i+5),10*(i+5));//rectangle
                    g.setColor(Color.YELLOW);//sets the color to yellow
                    g.fillOval(i*10,i*10,i*5,i*5);//draws a circle
                }
            }
        }
/*
 * creates the GUI for my layout
 */
        private static void createAndShowGUI() {
            final JFrame frame = new JFrame("Ooh Look at me!");//name of the frame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            frame.setResizable(false);//dont let the width/height change
            JPanel panel = new JPanel();//panel
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

            JPanel borderedPanel = new MyPanel();
            panel.add(borderedPanel);
            JLabel label = new JLabel("Number of Clicks: "+x);//label that lists the number of clicks
            panel.add(label);//adds the label
            
            JButton button = new JButton("Click Me!");//button
            panel.add(button);//adds the button
            
            button.addActionListener( new ActionListener()//event listener for button click
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    x++;//increases clicks
                    label.setText("Number of Clicks: "+x);//change label
                    JOptionPane.showMessageDialog(null, "Number of Clicks: "+x);//dialog box
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
                        createAndShowGUI();//creates and draws layout
                    }
                });
        }

    }