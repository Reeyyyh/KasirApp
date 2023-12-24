import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
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

    @FXML
    private Label LabelTotalHarga;

    @FXML
    private Label LabelKembalian;

    
    //Image
    @FXML
    private ImageView BurgerImage, PizzaImage, RamenImage, DrinkImage;

    //Effect
    @FXML
    private DropShadow originalDropShadow;
    
    //Pane
    @FXML
    private Pane PaneShow;

    //Button
    @FXML
    private Button HistoryPembelianButton;

    //Spinner
    @FXML
    private Spinner<Integer> SpinnerJumlahPesanan;

    //Textfield
    @FXML
    private TextField TextFieldPembayaran;

    //==============================================================================================



    //Non FXML
    //==============================================================================================
    private DropShadow redDropShadow = new DropShadow();


    //==============================================================================================
    //Burger ImageView click

    /**
     * Burger entered
     * @param event mouse entered
     * @return color become red
     */
    @FXML
    void OnMouseEnteredBurger(MouseEvent event) {
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
            HargaMenu.setText("Harga : Rp "+BurgerPrice.getText());
            
            disableOtherItems(BurgerImage);

            AutoCount(BurgerPrice);
        
    }

    //==============================================================================================
    //Pizza ImageView click

    /**
     * Pizza entered
     * @param event mouse entered
     * @return color become red
     */
    @FXML
    void OnMouseEnteredPizza(MouseEvent event) {
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
            HargaMenu.setText("Harga : Rp "+PizzaPrice.getText());
            
            disableOtherItems(PizzaImage);

            AutoCount(PizzaPrice);
    }

    //==============================================================================================
    //Ramen ImageView click

    /**
     * Ramen entered
     * @param event mouse entered
     * @return color become red
     */
    @FXML
    void OnMouseEnteredRamen(MouseEvent event) {
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
            HargaMenu.setText("Harga : Rp "+RamenPrice.getText());
           
            disableOtherItems(RamenImage);

            AutoCount(RamenPrice);
        
    }

    //==============================================================================================
    //Drink ImageView click

    /**
     * Drink entered
     * @param event mouse entered
     * @return color become red
     */
    @FXML
    void OnMouseEnteredDrink(MouseEvent event) {
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
            HargaMenu.setText("Harga : Rp "+DrinkPrice.getText());
    
            disableOtherItems(DrinkImage);

            AutoCount(DrinkPrice);
        
    }

    //==============================================================================================
    // pane item

    /**
     * Clear cliked
     * @param event mouse clicked
     * @return Pane invisible, and other item can be selected
     */
    @FXML
    void handleClearButtonClick(ActionEvent event){
        System.out.println("clear");
        PaneShow.setVisible(false);
        BurgerImage.setDisable(false);
        PizzaImage.setDisable(false);
        RamenImage.setDisable(false);
        DrinkImage.setDisable(false);
        HistoryPembelianButton.setDisable(false);
        TextFieldPembayaran.clear();

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
    //Hitory Pembelian Button action
    @FXML
    void handleHistoryPembelianButton(ActionEvent event){
        System.out.println("history pembelian button clik");
    }



    //==============================================================================================
    //non fxml item

    /**
     * to disable not selected item
     * @param selectedItem a selected ImageView
     */
    private void disableOtherItems(ImageView selectedItem) {
        // Menonaktifkan item-item lainnya
        if (selectedItem != BurgerImage) {
            BurgerImage.setDisable(true);
        }
        if (selectedItem != PizzaImage) {
            PizzaImage.setDisable(true);
        }
        if (selectedItem != RamenImage) {
            RamenImage.setDisable(true);
        }
        if (selectedItem != DrinkImage) {
            DrinkImage.setDisable(true);
        }
        HistoryPembelianButton.setDisable(true);
    }

    //AutoCount
    private void AutoCount(Label Price) {

        AtomicInteger TotalHarga = new AtomicInteger(0);

        TextFieldPembayaran.clear();
        TextFieldPembayaran.setText("0");

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
        valueFactory.setValue(0);
        SpinnerJumlahPesanan.setValueFactory(valueFactory);
    
        SpinnerJumlahPesanan.valueProperty().addListener((observable, oldValue, newValue) -> {
            int hargaPerItem = Integer.parseInt(Price.getText());
            int jumlahPesanan = newValue;
            int totalHarga = hargaPerItem * jumlahPesanan;
            TotalHarga.set(totalHarga);
            LabelTotalHarga.setText("Total Harga : Rp " + totalHarga);
            Pembayaran(TotalHarga.get());
        });
        
    }
    

    //Pembayaran
    private void Pembayaran(int TotalHarga){
        Pattern pattern = Pattern.compile("^[0-9]+$");
        String inputBayar = TextFieldPembayaran.getText();

        Matcher matcher = pattern.matcher(inputBayar);
        if (matcher.matches()) {
            // Input hanya mengandung angka, Anda dapat melanjutkan dengan proses pembayaran
            // ...
            System.out.println("Input sesuai dengan pola angka");
        } else {
            // Input tidak hanya mengandung angka, Anda dapat menangani kasus ini, misalnya, menampilkan pesan kesalahan
            // ...
            System.out.println("Input mengandung karakter selain angka");
        }
    }


    //==============================================================================================


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        originalDropShadow = (DropShadow) BurgerImage.getEffect();

        redDropShadow.setColor(javafx.scene.paint.Color.RED);
        redDropShadow.setBlurType(originalDropShadow.getBlurType());
        redDropShadow.setHeight(originalDropShadow.getHeight());
        redDropShadow.setOffsetY(originalDropShadow.getOffsetY());
        redDropShadow.setRadius(originalDropShadow.getRadius());
        redDropShadow.setWidth(originalDropShadow.getWidth());

        initializeTextField();

    }

    private void initializeTextField() {
        TextFormatter<Object> formatter = new TextFormatter<>(change -> {
            if (change.isContentChange()) {
                String newText = change.getControlNewText();
                if (newText.matches("\\d*")) {
                    return change; // Accept the change
                }
                return null; // Reject the change
            }
            return change;
        });

        TextFieldPembayaran.setTextFormatter(formatter);
    }

}