import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * @apiNote javafx version of JDK 21
 * @author Reys
 */
public class KasirApp extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Kasir.fxml"));
        Scene scene = new Scene(root);

        Image icon = new Image("file:asset\\img\\IconKasir.png");
        primaryStage.getIcons().add(icon);

        primaryStage.setTitle("Sistem Kasir");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
