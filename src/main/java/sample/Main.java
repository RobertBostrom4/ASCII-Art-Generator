package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Image sourceImage = new Image("file:ascii-pineapple.jpg");
        ASCIIConversion test = new ASCIIConversion();

        Image resizedImage = test.resize(sourceImage, (int) sourceImage.getWidth() / 10, (int) sourceImage.getHeight() / 10, true);


        int width = (int) resizedImage.getWidth();
        int height = (int) resizedImage.getHeight();

        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width, height);


        PixelReader targetImage = resizedImage.getPixelReader();

        ImageView imgV = new ImageView(resizedImage);

        char[][] testing = test.createAsciiMatrix();
        int[][] testr = test.createBrightnessMatrix();
        char[][] testi = test.createAsciiMatrix();
        String[][] teso = test.createRgbMatrix();

        System.out.println(teso[0][0]);
        System.out.println(testing[0][0]);
        System.out.println(testi[0][0]);

        for (int i = 0; i < testing.length; i++) {
            for (int j = 0; j < testing[j].length; j++) {


                for (int n = 0; n < 3; n++) {
                    //   System.out.print(testing[i][j]);

                }


            }
            //    System.out.println();
        }
        // System.out.println(testing.length);

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


        //     layout.getChildren().add(imgV);
        //    Scene s = new Scene(layout);
        //  primaryStage.setTitle("ASCII");
        //       primaryStage.setScene(s);
        //         primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
