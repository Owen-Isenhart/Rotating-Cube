import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

/**
 * 
 *
 * Owen Isenhart, rotating a cube in 3d
 */
public class Runner extends JPanel
{
    public static ArrayList<Vertex> vertecies;
    public static double xyPlaneRotationRads;
    public static double xzPlaneRotationRads;
    public static double yzPlaneRotationRads;
    
    public Runner(){
        vertecies = new ArrayList<>();
        vertecies.add(new Vertex(-1, -1, -1));
        vertecies.add(new Vertex(1, -1, -1));
        vertecies.add(new Vertex(-1, 1, -1));
        vertecies.add(new Vertex(1, 1, -1));
        vertecies.add(new Vertex(-1, -1, 1));
        vertecies.add(new Vertex(1, -1, 1));
        vertecies.add(new Vertex(-1, 1, 1));
        vertecies.add(new Vertex(1, 1, 1));
        
        xyPlaneRotationRads = .01;
        xzPlaneRotationRads = .01;
        yzPlaneRotationRads = .005;
    }
    
    public static void main(String[] args){
        Runner jPanel = new Runner();
        JFrame f = new JFrame("Rotating Cube");
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField xy = new JTextField("XY Rotation (0 - 100)");
        JTextField xz = new JTextField("XZ Rotation (0 - 100)");
        JTextField yz = new JTextField("YZ Rotation (0 - 100)");
        jPanel.add(xy);
        jPanel.add(xz);
        jPanel.add(yz);
        f.add(jPanel);
        f.setSize(450, 450);
        
        
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        while (true) {
            try{
                Thread.sleep(10);
            }
            catch (java.lang.InterruptedException ie){
                ie.printStackTrace();
            }
            String xyText = xy.getText();
            String xzText = xz.getText();
            String yzText = yz.getText();
            try {
                double temp = Double.parseDouble(xyText);
                if (temp <= 100 && temp >= 0)
                    xyPlaneRotationRads = temp/720;
            }
            catch (NumberFormatException e){}
            
            try {
                double temp = Double.parseDouble(xzText);
                if (temp <= 100 && temp >= 0)
                    xzPlaneRotationRads = temp/720;
            }
            catch (NumberFormatException e){}
            
            try {
                double temp = Double.parseDouble(yzText);
                if (temp <= 100 && temp >= 0)
                    yzPlaneRotationRads = temp/720;
            }
            catch (NumberFormatException e){}
            
            jPanel.repaint();
          }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.BLACK);
        
        for (int i = 0; i < vertecies.size(); i ++){
            vertecies.get(i).calculateRotation("xy", xyPlaneRotationRads);
            vertecies.get(i).calculateRotation("xz", xzPlaneRotationRads);
            vertecies.get(i).calculateRotation("yz", yzPlaneRotationRads);
        }
        
        //drawing lines
        g.setColor(Color.yellow);
        g.drawLine((int)(100*vertecies.get(0).x) + 200, (int)(100*-vertecies.get(0).y) + 200, (int)(100*vertecies.get(1).x) + 200, (int)(100*-vertecies.get(1).y) + 200);
        g.drawLine((int)(100*vertecies.get(2).x) + 200, (int)(100*-vertecies.get(2).y) + 200, (int)(100*vertecies.get(3).x) + 200, (int)(100*-vertecies.get(3).y) + 200);
        g.drawLine((int)(100*vertecies.get(4).x) + 200, (int)(100*-vertecies.get(4).y) + 200, (int)(100*vertecies.get(5).x) + 200, (int)(100*-vertecies.get(5).y) + 200);
        g.drawLine((int)(100*vertecies.get(6).x) + 200, (int)(100*-vertecies.get(6).y) + 200, (int)(100*vertecies.get(7).x) + 200, (int)(100*-vertecies.get(7).y) + 200);
        g.setColor(Color.red);
        g.drawLine((int)(100*vertecies.get(0).x) + 200, (int)(100*-vertecies.get(0).y) + 200, (int)(100*vertecies.get(2).x) + 200, (int)(100*-vertecies.get(2).y) + 200);
        g.drawLine((int)(100*vertecies.get(1).x) + 200, (int)(100*-vertecies.get(1).y) + 200, (int)(100*vertecies.get(3).x) + 200, (int)(100*-vertecies.get(3).y) + 200);
        g.drawLine((int)(100*vertecies.get(4).x) + 200, (int)(100*-vertecies.get(4).y) + 200, (int)(100*vertecies.get(6).x) + 200, (int)(100*-vertecies.get(6).y) + 200);
        g.drawLine((int)(100*vertecies.get(5).x) + 200, (int)(100*-vertecies.get(5).y) + 200, (int)(100*vertecies.get(7).x) + 200, (int)(100*-vertecies.get(7).y) + 200);
        g.setColor(Color.blue);
        g.drawLine((int)(100*vertecies.get(0).x) + 200, (int)(100*-vertecies.get(0).y) + 200, (int)(100*vertecies.get(4).x) + 200, (int)(100*-vertecies.get(4).y) + 200);
        g.drawLine((int)(100*vertecies.get(1).x) + 200, (int)(100*-vertecies.get(1).y) + 200, (int)(100*vertecies.get(5).x) + 200, (int)(100*-vertecies.get(5).y) + 200);
        g.drawLine((int)(100*vertecies.get(2).x) + 200, (int)(100*-vertecies.get(2).y) + 200, (int)(100*vertecies.get(6).x) + 200, (int)(100*-vertecies.get(6).y) + 200);
        g.drawLine((int)(100*vertecies.get(3).x) + 200, (int)(100*-vertecies.get(3).y) + 200, (int)(100*vertecies.get(7).x) + 200, (int)(100*-vertecies.get(7).y) + 200);

            
        for (int i = 0; i < vertecies.size(); i ++){
            drawVertex(vertecies.get(i), g);
        }
        
    }
    
    public void drawVertex(Vertex v, Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval((int)(100*v.x) + 200 - 4, (int)(100*-v.y) + 200 - 4, 8, 8);
        
        g.setColor(Color.GRAY);
        g.drawOval((int)(100*v.x) + 200 - 4, (int)(100*-v.y) + 200 - 4, 8, 8);
    }
    
    public void connectingLine(Vertex v1, Vertex v2, Color c, Graphics g){
        g.setColor(c);
        g.drawLine((int)(100*v1.x) + 200, (int)(100*-v1.y) + 200, (int)(100*v2.x) + 200, (int)(100*-v2.y) + 200);
    }
    
    
}
