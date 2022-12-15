import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    BufferedImage standardImage;
    
    // To keep track of a singel cars position
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.darkGray);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            standardImage = new BufferedImage(64,64,BufferedImage.TYPE_INT_RGB);
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
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Volvo240) {
                g.drawImage(volvoImage, vehicle.getX(), vehicle.getY(), null);
            }
            else if (vehicle instanceof Scania) {
                g.drawImage(scaniaImage, vehicle.getX(), vehicle.getY(), null);
            }
            else if (vehicle instanceof Saab95) {
                g.drawImage(saabImage, vehicle.getX(), vehicle.getY(), null);
            }
            else
                g.drawImage(standardImage, vehicle.getX(), vehicle.getY(), null);
            
        }
    }       // see javadoc for more info on the parameters
}

