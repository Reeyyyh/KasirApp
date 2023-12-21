import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * @apiNote javafx version of JDK 21
 */
public class KasirController implements Initializable {

    // inisial variabel from fxml file
    //=============================================================================================

    //Label
    @FXML
    private Label BurgerLabel, PizzaLabel, RamenLabel,DrinkLabel;

    //Price
    @FXML
    private Label BurgerPrice, PizzaPrice, RamenPrice, DrinkPrice;

    //for call
    @FXML
    private Label MenuYangDipesan;

    @FXML
    private Label HargaMenu;
    
    
    //Image
    @FXML
    private ImageView BurgerImage, PizzaImage, RamenImage, DrinkImage;

    //Effect
    @FXML
    private DropShadow originalDropShadow;
    
    //Pane
    @FXML
    private Pane PaneShow;





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
        PaneShow.setVisible(true);
        MenuYangDipesan.setText("Menu yang di pesan : "+BurgerLabel.getText());
        HargaMenu.setText("Harga : "+BurgerPrice.getText());
        
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
        PaneShow.setVisible(true);
        MenuYangDipesan.setText("Menu yang di pesan : "+PizzaLabel.getText());
        HargaMenu.setText("Harga : "+PizzaPrice.getText());
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
     * Ramen Exit
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
        PaneShow.setVisible(true);
        MenuYangDipesan.setText("Menu yang di pesan : "+RamenLabel.getText());
        HargaMenu.setText("Harga : "+RamenPrice.getText());
    }

    //==============================================================================================

    /**
     * Drink entered
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
     * Drink Exit
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
        PaneShow.setVisible(true);
        MenuYangDipesan.setText("Menu yang di pesan : "+DrinkLabel.getText());
        HargaMenu.setText("Harga : "+DrinkPrice.getText());
    }

    //==============================================================================================

    /**
     * Clear cliked
     * @param event mouse clicked
     * @return Pane invisible
     */
    @FXML
    void handleClearButtonClick(ActionEvent event){
        System.out.println("clear");
        PaneShow.setVisible(false);
    }

    /**
     * confirm cliked
     * @param event mouse clicked
     * @return result
     */
    @FXML
    void handleConfirmButtonClick(ActionEvent event){
        System.out.println("confirm");
    }



    //==============================================================================================

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        originalDropShadow = (DropShadow) BurgerImage.getEffect();
        
        
        // BurgerImage.setOnMouseEntered(this::OnMouseEnteredBurger);
        // BurgerImage.setOnMouseExited(this::OnMouseExitedBurger);

    }


}