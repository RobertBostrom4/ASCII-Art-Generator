package sample;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Image sourceImage = new Image("file:ascii-pineapple.jpg");
        ASCIIConversion test = new ASCIIConversion();

        Image resizedImage = test.resize(sourceImage, (int) sourceImage.getWidth() / 4, (int) sourceImage.getHeight() / 4, true);

        String asciiCharacters = "\"`^\\\",:;Il!i~+_-?][}{1)(|\\\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$\"";
        char[] asciiAsArray = asciiCharacters.toCharArray();


        int width = (int) resizedImage.getWidth();
        int height = (int) resizedImage.getHeight();

        int[][] brightnessMatrix = new int[width][height];

        PixelReader targetImage = resizedImage.getPixelReader();

        ImageView imgV = new ImageView(resizedImage);

        for (int i = 0; i < width; i++) {

            for (int j = 0; j < height; j++) {


                Color newColor = targetImage.getColor(i, j);

                double red = newColor.getRed();
                double green = newColor.getGreen();
                double blue = newColor.getBlue();


                double colorBrightness = newColor.getBrightness() * 100;

                brightnessMatrix[i][j] = Math.round((int) colorBrightness);

            }

        }
        char[][] ascii = new char[width][height];
        for (int i = 0; i < width; i++) {

            for (int j = 0; j < height; j++) {


                int value = brightnessMatrix[i][j];


                for (int n = 0; n < asciiAsArray.length; n++) {
                    double percentage = Math.round((double) n / asciiAsArray.length * 100);


                    if (value == (int) percentage) {
                        ascii[i][j] = asciiAsArray[n];

                    }

                }
            }
        }
      //   Arrays.stream(ascii).forEach(chars -> System.out.println(chars));

     /*   for (int i = 0; i < ascii.length; i++) {


            for (int j = 0; j < ascii[i].length; j++) {

                for (int n = 0; n < 3; n++) {
                    System.out.print(ascii[i][j]);
                }


            }
            System.out.println("");
        }

      */
            Pane layout = new Pane();


            layout.getChildren().add(imgV);
            Scene s = new Scene(layout);
            primaryStage.setTitle("ASCII");
            primaryStage.setScene(s);
            primaryStage.show();
        }


    public static void main(String[] args) {
        launch(args);
    }
}
