import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * A JavaFX application for a cashier system.
 *
 * @apiNote JavaFX version of JDK 21
 * @version 1.0
 * @author Rehan, Dimas
 */
public class KasirApp extends Application {
    /**
     * Memulai aplikasi JavaFX, memuat file Kasir.fxml.
     *
     * @param primaryStage Panggung utama untuk aplikasi ini.
     * @throws Exception Jika terjadi kesalahan selama pengambilan FXML file.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Kasir.fxml"));
        Scene scene = new Scene(root);

        // Set application icon
        Image icon = new Image("file:asset\\img\\IconKasir.png");
        primaryStage.getIcons().add(icon);

        primaryStage.setTitle("selected item Kasir");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
