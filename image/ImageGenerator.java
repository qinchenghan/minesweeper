package image;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageGenerator {
    public static void main(String[] args) {
        int width = 30;
        int height = 30;

        // Create a BufferedImage object
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Get the Graphics2D object
        Graphics2D g = image.createGraphics();
        Color color = new Color(180, 180, 180);
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        // Color brown = new Color(139, 69, 19);
        // g.setColor(Color.BLACK);
        // g.setFont(new Font("Arial", Font.BOLD, 20));
        // g.drawString("7", 10, 22);

        // Draw some text
        // g2d.setColor(Color.BLACK);
        // g2d.setFont(new Font("Arial", Font.BOLD, 45));
        // g2d.drawString("Hello, Java!", 450, 400);

        // Draw an arc
        // g2d.setColor(Color.GREEN);
        // g2d.drawArc(500, 150, 100, 100, 0, 180);

        //g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // 50% transparency


        // Dispose of the Graphics2D object
        g.dispose();

        // Save the image to a file
        try {
            ImageIO.write(image, "png", new File("img/generated.png"));
            System.out.println("Image saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
