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
        test.createAsciiImage();




    }


    public static void main(String[] args) {

        launch(args);
    }


}
