package image;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageRotator {
    public static void main(String[] args) {
        try {
            // Load the image
            File inputFile = new File("/Users/chenghanqin/Desktop/javagame/generated_image.png");
            BufferedImage originalImage = ImageIO.read(inputFile);

            // Specify the angle of rotation (in radians)
            double angle = Math.toRadians(270); // 45 degrees
            
            // Calculate the pivot point (center of the image)
            int centerX = originalImage.getWidth() / 2;
            int centerY = originalImage.getHeight() / 2;

            // Create an AffineTransform instance
            AffineTransform transform = new AffineTransform();
            transform.rotate(angle, centerX, centerY);

            // Determine the new dimensions of the rotated image
            double[] pt = new double[] {0, 0, originalImage.getWidth(), originalImage.getHeight()};
            transform.transform(pt, 0, pt, 0, 2);
            int newWidth = (int) Math.max(pt[0], pt[2]);
            int newHeight = (int) Math.max(pt[1], pt[3]);

            // Create a new buffered image with new dimensions
            BufferedImage rotatedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());

            // Create a Graphics2D object for the new image
            Graphics2D g2d = rotatedImage.createGraphics();

            // Apply the transform to the Graphics2D object
            g2d.setTransform(transform);

            // Draw the original image onto the rotated image
            g2d.drawImage(originalImage, 0, 0, null);
            g2d.dispose();

            // Save the rotated image
            File outputFile = new File("/Users/chenghanqin/Desktop/javagame/generated_image.png");
            ImageIO.write(rotatedImage, "png", outputFile);

            System.out.println("Image rotated and saved as " + outputFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
