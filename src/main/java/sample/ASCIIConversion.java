package sample;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ASCIIConversion {

    private BufferedImage img;
    private final String asciiCharacters;

    public ASCIIConversion() throws Exception {
        this.img = ImageIO.read(new File("C:\\Users\\rober\\IdeaProjects\\ASCII Art generator\\ascii-pineapple.jpg"));
        this.asciiCharacters = "\"`^\\\",:;Il!i~+_-?][}{1)(|\\\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$\"";
    }

    public void resize(int targetWidth, int targetHeight) {
        img = Scalr.resize(img, targetWidth, targetHeight);
    }

    public String[][] createRgbMatrix() {

        int width = img.getWidth();
        int height = img.getHeight();

        String[][] pixelMatrix = new String[width][height];

        for (int j = 0; j < height; j++) {

            for (int i = 0; i < width; i++) {

                int rgbValue = img.getRGB(i, j);

                int red = (rgbValue >> 16) & 0x000000FF;
                int green = (rgbValue >> 8) & 0x000000FF;
                int blue = (rgbValue) & 0x000000FF;

                pixelMatrix[i][j] = "(" + red + ", " + green + ", " + blue + ")";

            }

        }
        return pixelMatrix;

    }

    public int[][] createBrightnessMatrix() {


        int width = img.getWidth();
        int height = img.getHeight();

        String[][] rgbMatrix = createRgbMatrix();
        int[][] brightnessMatrix = new int[width][height];

        for (int i = 0; i < rgbMatrix.length; i++) {

            for (int j = 0; j < rgbMatrix[i].length; j++) {


                String modifiedElement = rgbMatrix[i][j].replace("(", "").replace(")", "");
                String[] valuesAsArray = modifiedElement.split(",");

                int first = Integer.parseInt(valuesAsArray[0]);
                int second = Integer.parseInt(valuesAsArray[1].trim());
                int third = Integer.parseInt(valuesAsArray[2].trim());


                brightnessMatrix[i][j] = (int) Math.floor((first + second + third) / 3);
            }
        }

        return brightnessMatrix;
    }

    public void createAsciiImage() {

        int width = img.getWidth();
        int height = img.getHeight();

        int[][] brightnessMatrix = createBrightnessMatrix();

        for (int j = 0; j < height; j++) {

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < width; i++) {

                int index = (brightnessMatrix[i][j] * asciiCharacters.length() - 1) / 255;
                char asciiChar = asciiCharacters.charAt(index);

                for (int n = 0; n < 3; n++) {
                    builder.append(asciiChar);
                }

            }

            System.out.println(builder);
        }

    }


}
