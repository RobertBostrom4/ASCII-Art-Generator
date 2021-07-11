package sample;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Image img = new Image("file:ascii-pineapple.jpg");
        ASCIIConversion test = new ASCIIConversion();

        test.resize((int) img.getWidth() / 10, (int) img.getHeight() / 10);

        char[][] asciiMatrix = test.createAsciiMatrix();

        for (int i = 0; i < asciiMatrix.length; i++) {
            for (int j = 0; j < asciiMatrix[j].length; j++) {


                for (int n = 0; n < 3; n++) {
                    System.out.print(asciiMatrix[i][j]);

                }


            }
            System.out.println();
        }


    }


    public static void main(String[] args) {

        launch(args);
    }


}
