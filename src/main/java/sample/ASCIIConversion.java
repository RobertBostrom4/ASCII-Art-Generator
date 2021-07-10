package sample;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ASCIIConversion {

    private Image sourceImage;
    private final char[] asciiCharacters;

    public ASCIIConversion() {
        this.sourceImage = new Image("file:ascii-pineapple.jpg");
        this.asciiCharacters = "\"`^\\\",:;Il!i~+_-?][}{1)(|\\\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$\"".toCharArray();
    }

    public void resize(int targetWidth, int targetHeight) {


        BufferedImage img = null;

        try {
            img = ImageIO.read(new File("C:\\Users\\rober\\IdeaProjects\\ASCII Art generator\\ascii-pineapple.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage imgRescaled = Scalr.resize(img, targetWidth, targetHeight);

        WritableImage newImage = new WritableImage(targetWidth, targetHeight);

        PixelWriter writer = newImage.getPixelWriter();

        for (int i = 0; i < targetWidth; i++) {

            for (int j = 0; j < targetHeight; j++) {


                writer.setArgb(i, j, imgRescaled.getRGB(i, j));


            }

        }

        sourceImage = newImage;
    }

    public String[][] createRgbMatrix() {

        PixelReader targetImage = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        String[][] pixelMatrix = new String[width][height];

        for (int i = 0; i < width; i++) {

            for (int j = 0; j < height; j++) {

                Color newColor = targetImage.getColor(i, j);

                int red = (int) Math.round(newColor.getRed() * 255);
                int green = (int) Math.round(newColor.getGreen() * 255);
                int blue = (int) Math.round(newColor.getBlue() * 255);

                pixelMatrix[i][j] = "(" + red + ", " + green + ", " + blue + ")";

            }

        }
        return pixelMatrix;

    }

    public int[][] createBrightnessMatrix() {


        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        String[][] rgbMatrix = createRgbMatrix();
        int[][] brightnessMatrix = new int[width][height];

        for (int i = 0; i < rgbMatrix.length; i++) {

            for (int j = 0; j < rgbMatrix[i].length; j++) {


                String modifiedElement = rgbMatrix[i][j].replace("(", "").replace(")", "");
                String[] valuesAsArray = modifiedElement.split(",");

                int first = Integer.parseInt(valuesAsArray[0]);
                int second = Integer.parseInt(valuesAsArray[1].trim());
                int third = Integer.parseInt(valuesAsArray[2].trim());


                brightnessMatrix[i][j] = ((first + second + third) / 3);
            }
        }

        return brightnessMatrix;
    }

    public char[][] createAsciiMatrix() {

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        int[][] brightnessMatrix = createBrightnessMatrix();
        char[][] asciiMatrix = new char[width][height];


        for (int i = 0; i < width; i++) {

            for (int j = 0; j < height; j++) {

                double percentage = Math.round(((double) brightnessMatrix[i][j] / 255) * 100);


                for (int n = 0; n < asciiCharacters.length; n++) {


                    double nextPercentage = Math.round(((double) n / asciiMatrix.length) * 100);

                    if (percentage == nextPercentage) {
                        asciiMatrix[i][j] = asciiCharacters[n];

                    }

                }


            }

        }

        return asciiMatrix;
    }


}
