import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    private ArrayList<BufferedImage> images;
    // To keep track of a singel cars position

    private ArrayList<Point> points;

    // TODO: Make this genereal for all cars
    void moveit(int x, int y, int index){
        points.get(index).x = x;
        points.get(index).y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<MotorVehicle> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.images = new ArrayList<BufferedImage>();
        this.points = new ArrayList<Point>();
        // Print an error message in case file is not found with a try/catch block
        try {
            for (MotorVehicle car : cars){
                points.add(new Point());
                images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+car.getModelName()+".jpg")));
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int index = 0; index < images.size(); index++){
            g.drawImage(images.get(index), points.get(index).x, points.get(index).y, null); // see javadoc for more info on the parameters
        }
    }
}
