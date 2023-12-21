import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * @apiNote javafx version of JDK 21
 */
public class KasirController implements Initializable {

    // inisial variabel from fxml file
    //=============================================================================================

    //Label
    @FXML
    private Label BurgerLabel;

    @FXML
    private Label PizzaLabel;

    @FXML
    private Label RamenLabel;

    @FXML
    private Label DrinkLabel;
    
    
    //Image
    @FXML
    private ImageView BurgerImage;

    @FXML
    private ImageView DrinkImage;

    @FXML
    private ImageView PizzaImage;

    @FXML
    private ImageView RamenImage;
    

    //Effect
    @FXML
    private DropShadow originalDropShadow;





    //==============================================================================================

    /**
     * Burger entered
     * @param event mouse entered
     * @return color become red
     */
    @FXML
    void OnMouseEnteredBurger(MouseEvent event) {
        DropShadow redDropShadow = new DropShadow();
        redDropShadow.setColor(javafx.scene.paint.Color.RED);
        redDropShadow.setBlurType(originalDropShadow.getBlurType());
        redDropShadow.setHeight(originalDropShadow.getHeight());
        redDropShadow.setOffsetY(originalDropShadow.getOffsetY());
        redDropShadow.setRadius(originalDropShadow.getRadius());
        redDropShadow.setWidth(originalDropShadow.getWidth());
        BurgerImage.setEffect(redDropShadow);
    }

    /**
     * Burger Exit
     * @param event mouse exit
     * @return color back to original
     */
    @FXML
    void OnMouseExitedBurger(MouseEvent event) {
        BurgerImage.setEffect(originalDropShadow);
    }

    /**
     * Burger cliked
     * @param event mouse clicked, method begin
     * @return Burger method
     */
    @FXML
    void handleBurgerButtonClick(MouseEvent event) {
        System.out.println("burger click");
    }

    //==============================================================================================

    /**
     * Pizza entered
     * @param event mouse entered
     * @return color become red
     */
    @FXML
    void OnMouseEnteredPizza(MouseEvent event) {
        DropShadow redDropShadow = new DropShadow();
        redDropShadow.setColor(javafx.scene.paint.Color.RED);
        redDropShadow.setBlurType(originalDropShadow.getBlurType());
        redDropShadow.setHeight(originalDropShadow.getHeight());
        redDropShadow.setOffsetY(originalDropShadow.getOffsetY());
        redDropShadow.setRadius(originalDropShadow.getRadius());
        redDropShadow.setWidth(originalDropShadow.getWidth());
        PizzaImage.setEffect(redDropShadow);
    }

    /**
     * Pizza Exit
     * @param event mouse exit
     * @return color back to original
     */
    @FXML
    void OnMouseExitedPizza(MouseEvent event) {
        PizzaImage.setEffect(originalDropShadow);
    }
    
    /**
     * Pizza cliked
     * @param event mouse clicked, method begin
     * @return Pizza method
     */
    @FXML
    void handlePizzaButtonClick(MouseEvent event) {
        System.out.println("pizza cliked");
    }

    //==============================================================================================

    /**
     * Ramen entered
     * @param event mouse entered
     * @return color become red
     */
    @FXML
    void OnMouseEnteredRamen(MouseEvent event) {
        DropShadow redDropShadow = new DropShadow();
        redDropShadow.setColor(javafx.scene.paint.Color.RED);
        redDropShadow.setBlurType(originalDropShadow.getBlurType());
        redDropShadow.setHeight(originalDropShadow.getHeight());
        redDropShadow.setOffsetY(originalDropShadow.getOffsetY());
        redDropShadow.setRadius(originalDropShadow.getRadius());
        redDropShadow.setWidth(originalDropShadow.getWidth());
        RamenImage.setEffect(redDropShadow);
    }

    /**
     * Pizza Exit
     * @param event mouse exit
     * @return color back to original
     */
    @FXML
    void OnMouseExitedRamen(MouseEvent event) {
        RamenImage.setEffect(originalDropShadow);
    }


    /**
     * Ramen cliked
     * @param event mouse clicked, method begin
     * @return Ramen method
     */
    @FXML
    void handleRamenButtonClick(MouseEvent event) {
        System.out.println("ramen cliked");
    }

    //==============================================================================================

    /**
     * Ramen entered
     * @param event mouse entered
     * @return color become red
     */
    @FXML
    void OnMouseEnteredDrink(MouseEvent event) {
        DropShadow redDropShadow = new DropShadow();
        redDropShadow.setColor(javafx.scene.paint.Color.RED);
        redDropShadow.setBlurType(originalDropShadow.getBlurType());
        redDropShadow.setHeight(originalDropShadow.getHeight());
        redDropShadow.setOffsetY(originalDropShadow.getOffsetY());
        redDropShadow.setRadius(originalDropShadow.getRadius());
        redDropShadow.setWidth(originalDropShadow.getWidth());
        DrinkImage.setEffect(redDropShadow);
    }

    /**
     * Pizza Exit
     * @param event mouse exit
     * @return color back to original
     */
    @FXML
    void OnMouseExitedDrink(MouseEvent event) {
        DrinkImage.setEffect(originalDropShadow);
    }


    /**
     * Drink cliked
     * @param event mouse clicked, method begin
     * @return Drink method
     */
    @FXML
    void handleDrinkButtonClick(MouseEvent event) {
        System.out.println("drink cliked");
    }

    //==============================================================================================

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        originalDropShadow = (DropShadow) BurgerImage.getEffect();
        
        // BurgerImage.setOnMouseEntered(this::OnMouseEnteredBurger);
        // BurgerImage.setOnMouseExited(this::OnMouseExitedBurger);

    }


}

