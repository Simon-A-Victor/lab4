package View;

import Application.MotorVehiclePositionObserver;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements MotorVehiclePositionObserver {


    private ArrayList<BufferedImage> images;


    private ArrayList<Point> points;


    public void actOnMotorVehiclePositionUpdate(int x, int y, int index){
        points.get(index).x = x;
        points.get(index).y = y;
    }

    @Override
    public void actOnTickChange() {
        repaint();
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<String> modelNames) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.images = new ArrayList<BufferedImage>();
        this.points = new ArrayList<Point>();
        // Print an error message in case file is not found with a try/catch block
        try {
            for (String modelName : modelNames){
                points.add(new Point());
                images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+modelName+".jpg")));
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int index  = 0; index < images.size(); index++) {
            g.drawImage(images.get(index), points.get(index).x, points.get(index).y, null); // see javadoc for more info on the parameters
        }
    }
}
