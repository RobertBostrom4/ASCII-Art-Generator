package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ASCIIConversion test = new ASCIIConversion();
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
