package image;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageColorExtractor {

    public static void main(String[] args) {
        try {
            // Load the image file
            File imageFile = new File("img/1.png");
            BufferedImage image = ImageIO.read(imageFile);

            // Get image dimensions
            // int width = image.getWidth();
            // int height = image.getHeight();

            // Iterate through each pixel
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    // Get RGB values of the pixel
                    int rgb = image.getRGB(x, y);
                    int red = (rgb >> 16) & 0xFF;
                    int green = (rgb >> 8) & 0xFF;
                    int blue = rgb & 0xFF;

                    // Create a Color object
                    Color color = new Color(red, green, blue);

                    // Print or process the color as needed
                    System.out.println("Pixel at (" + x + "," + y + "): " + color);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
