package View;

import Model.MotorVehiclePositionObserver;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements MotorVehiclePositionObserver {

    private ArrayList<ImageAndPositionInformation> imagesAndPositions;

    public void actOnMotorVehiclePositionUpdate(int x, int y, String modelName){
        imagesAndPositions.add(new ImageAndPositionInformation(modelName, new Point(x,y)));
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
        this.imagesAndPositions = new ArrayList<ImageAndPositionInformation>();
    }

    private class ImageAndPositionInformation{
        BufferedImage modelImage;
        Point position;

        public ImageAndPositionInformation(String modelName, Point position){
            // Print an error message in case file is not found with a try/catch block
            try {
                //points.add(new Point());
                this.modelImage = (ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+modelName+".jpg")));
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
            this.position = position;
        }
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ImageAndPositionInformation carInfo : imagesAndPositions) {
            g.drawImage(carInfo.modelImage, carInfo.position.x, carInfo.position.y, null); // see javadoc for more info on the parameters
        }
        imagesAndPositions.clear();
    }
}
