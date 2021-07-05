package sample;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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

        Image resizedImage = test.resize(sourceImage, (int) sourceImage.getWidth() /5, (int) sourceImage.getHeight() / 5, true);


        int width = (int) resizedImage.getWidth();
        int height = (int) resizedImage.getHeight();

        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0, width, height);


        PixelReader targetImage = resizedImage.getPixelReader();

        ImageView imgV = new ImageView(resizedImage);



        //   Arrays.stream(ascii).forEach(chars -> System.out.println(chars));
/* gc.setFill(Color.WHITE);
        Label label = new Label();
        label.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setTextFill(Color.WHITE);
        label.setFont(new Font("Arial",6));
StringBuilder ss = new StringBuilder();
        for (int i = 0; i < ascii.length; i++) {


            for (int j = 0; j < ascii[i].length; j++) {
            //    gc.fillText(String.valueOf(ascii[0][0]), i, j);

                for (int n = 0; n < 3; n++) {
               //   System.out.print(ascii[i][j]);
                    ss.append(ascii[i][j]);

                }


            }
            ss.append("\n");
        }

*/
        Pane layout = new Pane();

//label.setText(ss.toString());



      //  layout.getChildren().add(label);
     //   Scene s = new Scene(layout);
      //  primaryStage.setTitle("ASCII");
   //     primaryStage.setScene(s);
   //     primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
