package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class ASCIIConversion {

    private final Image sourceImage;
    private final char[] asciiCharacters;

    public ASCIIConversion() {
        this.sourceImage = new Image("file:ascii-pineapple.jpg");
        this.asciiCharacters = "\"`^\\\",:;Il!i~+_-?][}{1)(|\\\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$\"".toCharArray();
    }

    public Image resize(Image source, int targetWidth, int targetHeight, boolean preserveRatio) {

        ImageView i = new ImageView(source);
        i.setPreserveRatio(preserveRatio);
        i.setFitWidth(targetWidth);
        i.setFitHeight(targetHeight);

        return i.snapshot(null, null);
    }

    public String[][] createRgbMatrix() {

        Image resizedImage = resize(sourceImage, (int) sourceImage.getWidth() / 5, (int) sourceImage.getHeight() / 5, true);

        int width = (int) resizedImage.getWidth();
        int height = (int) resizedImage.getHeight();


        PixelReader targetImage = resizedImage.getPixelReader();

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

        Image resizedImage = resize(sourceImage, (int) sourceImage.getWidth() / 5, (int) sourceImage.getHeight() / 5, true);

        int width = (int) resizedImage.getWidth();
        int height = (int) resizedImage.getHeight();

        String[][] rgbMatrix = createRgbMatrix();
        int[][] brightnessMatrix = new int[width][height];

        for (int i = 0; i < rgbMatrix.length; i++) {

            for (int j = 0; j < rgbMatrix[i].length; j++) {


                String modifiedElement = rgbMatrix[i][j].replace("(", "").replace(")", "");
                String[] valuesAsArray = modifiedElement.split(",");

                int first = Integer.valueOf(valuesAsArray[0]);
                int second = Integer.valueOf(valuesAsArray[1].trim());
                int third = Integer.valueOf(valuesAsArray[2].trim());


                brightnessMatrix[i][j] = (first + second + third) / 3;
            }
        }

        return brightnessMatrix;
    }

    public char[][] createAsciiMatrix() {

        Image resizedImage = resize(sourceImage, (int) sourceImage.getWidth() / 5, (int) sourceImage.getHeight() / 5, true);

        int width = (int) resizedImage.getWidth();
        int height = (int) resizedImage.getHeight();

        int[][] brightnessMatrix = createBrightnessMatrix();
        char[][] asciiMatrix = new char[width][height];


        for (int i = 0; i < brightnessMatrix.length; i++) {

            for (int j = 0; j < brightnessMatrix[j].length; j++) {

double percentage = brightnessMatrix[i][j] / 255;



            }

        }

        return  asciiMatrix;
    }


}
