package image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageResize {

    public static void main(String[] args) {
        // Input and output file paths
        String inputFile = "img/vic.png";
        String outputFile = inputFile;

        // Desired width and height for the resized image
        int newWidth = 30;
        int newHeight = 30;

        try {
            // Read the original image from file
            File input = new File(inputFile);
            BufferedImage originalImage = ImageIO.read(input);

            // Create a new BufferedImage with the desired size
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());

            // Resize the original image to the new BufferedImage
            resizedImage.getGraphics().drawImage(originalImage, 0, 0, newWidth, newHeight, null);

            // Write the resized image to output file
            File output = new File(outputFile);
            ImageIO.write(resizedImage, "png", output);

            System.out.println("Image resized successfully.");

        } catch (IOException e) {
            System.out.println("Error resizing image: " + e.getMessage());
        }
    }
}
