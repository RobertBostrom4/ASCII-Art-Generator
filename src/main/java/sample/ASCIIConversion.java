package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ASCIIConversion {


    public Image resize(Image source, int targetWidth, int targetHeight, boolean preserveRatio) {

        ImageView i = new ImageView(source);
        i.setPreserveRatio(preserveRatio);
        i.setFitWidth(targetWidth);
        i.setFitHeight(targetHeight);

        return i.snapshot(null, null);
    }

}
