import java.net.URL;
import java.util.ResourceBundle;

import java.util.concurrent.atomic.AtomicInteger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
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

    @FXML
    private Pane PaneConfirm;

    //Button
    @FXML
    private Button PayButton;

    @FXML
    private Button CheckOut;

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

    @FXML
    void OnMouseEnteredBurger(MouseEvent event) {
        BurgerImage.setEffect(redDropShadow);
    }

    @FXML
    void OnMouseExitedBurger(MouseEvent event) {
        BurgerImage.setEffect(originalDropShadow);
    }

    @FXML
    void handleBurgerButtonClick(MouseEvent event) {
        System.out.println("burger click");
        
            PaneShow.setVisible(true);
            PaneConfirm.setVisible(false);

            MenuYangDipesan.setText("Menu yang di pesan : "+BurgerLabel.getText());
            HargaMenu.setText("Harga : Rp "+BurgerPrice.getText());
            
            disableOtherItems(BurgerImage);

            AutoCount(BurgerPrice);
        
    }

    //==============================================================================================
    //Pizza ImageView click

    @FXML
    void OnMouseEnteredPizza(MouseEvent event) {
        PizzaImage.setEffect(redDropShadow);
    }

    @FXML
    void OnMouseExitedPizza(MouseEvent event) {
        PizzaImage.setEffect(originalDropShadow);
    }
    
    @FXML
    void handlePizzaButtonClick(MouseEvent event) {
        System.out.println("pizza cliked");
        
            PaneShow.setVisible(true);
            PaneConfirm.setVisible(false);

            MenuYangDipesan.setText("Menu yang di pesan : "+PizzaLabel.getText());
            HargaMenu.setText("Harga : Rp "+PizzaPrice.getText());
            
            disableOtherItems(PizzaImage);

            AutoCount(PizzaPrice);
    }

    //==============================================================================================
    //Ramen ImageView click

    @FXML
    void OnMouseEnteredRamen(MouseEvent event) {
        RamenImage.setEffect(redDropShadow);
    }

    @FXML
    void OnMouseExitedRamen(MouseEvent event) {
        RamenImage.setEffect(originalDropShadow);
    }

    @FXML
    void handleRamenButtonClick(MouseEvent event) {
        System.out.println("ramen cliked");
        
            PaneShow.setVisible(true);
            PaneConfirm.setVisible(false);

            MenuYangDipesan.setText("Menu yang di pesan : "+RamenLabel.getText());
            HargaMenu.setText("Harga : Rp "+RamenPrice.getText());
           
            disableOtherItems(RamenImage);

            AutoCount(RamenPrice);
        
    }

    //==============================================================================================
    //Drink ImageView click

    @FXML
    void OnMouseEnteredDrink(MouseEvent event) {
        DrinkImage.setEffect(redDropShadow);
    }

    @FXML
    void OnMouseExitedDrink(MouseEvent event) {
        DrinkImage.setEffect(originalDropShadow);
    }

    @FXML
    void handleDrinkButtonClick(MouseEvent event) {
        System.out.println("drink cliked");
        
            PaneShow.setVisible(true);
            PaneConfirm.setVisible(false);

            MenuYangDipesan.setText("Menu yang di pesan : "+DrinkLabel.getText());
            HargaMenu.setText("Harga : Rp "+DrinkPrice.getText());
    
            disableOtherItems(DrinkImage);

            AutoCount(DrinkPrice);
        
    }

    //==============================================================================================
    // pane item

    @FXML
    void handleClearButtonClick(ActionEvent event){
        System.out.println("clear");
        PaneShow.setVisible(false);
        BurgerImage.setDisable(false);
        PizzaImage.setDisable(false);
        RamenImage.setDisable(false);
        DrinkImage.setDisable(false);
        HistoryPembelianButton.setDisable(false);

        PaneConfirm.setVisible(false);
        TextFieldPembayaran.clear();
    }

    @FXML
    void handleConfirmButtonClick(ActionEvent event){
        System.out.println("confirm");
        if (JumlahPesanan.get() == 0) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setHeaderText("order at least one item");
                alert.show();
        } else {
            PaneConfirm.setVisible(true);
            CheckOut.setDisable(true);
        }
        
    }

    @FXML
    void handlePayButtonClick(ActionEvent event){
        System.out.println("Pay get clicked");

        try {
            String InputTextfield = TextFieldPembayaran.getText();

                int Pembayaran = Integer.parseInt(InputTextfield);

                int Kembalian = Pembayaran - TotalHarga.get();

                if (Kembalian <= -1){
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setHeaderText("your money is less");
                    alert.show();
                } else {
                    LabelKembalian.setText("Kembalian : "+String.valueOf(Kembalian));
                    BurgerImage.setDisable(true);
                    PizzaImage.setDisable(true);
                    RamenImage.setDisable(true);
                    DrinkImage.setDisable(true);
                    PaneShow.setDisable(true);
                    TextFieldPembayaran.setDisable(true);

                    PayButton.setDisable(true);
                    CheckOut.setDisable(false);

                    
                }
            
        } catch (NumberFormatException nfe) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Enter a number");
            alert.show();
        } catch (Exception e){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Sorry for the inconvenience");
            alert.show();
        }
        
    }

    @FXML
    void handleCheckOutButtonClick(ActionEvent event){
        System.out.println("check out get clicked");
        BurgerImage.setDisable(false);
        PizzaImage.setDisable(false);
        RamenImage.setDisable(false);
        DrinkImage.setDisable(false);
        PaneShow.setDisable(false);

        TextFieldPembayaran.setDisable(false);
        HistoryPembelianButton.setDisable(false);

        PayButton.setDisable(false);

        PaneShow.setVisible(false);
        PaneConfirm.setVisible(false);

        //place to add to data


        LabelKembalian.setText("Kembalian : ");

    }

    //==============================================================================================
    //Hitory Pembelian Button action
    @FXML
    void handleHistoryPembelianButton(ActionEvent event){
        System.out.println("history pembelian button clik");
    }

    //==============================================================================================
    //non fxml item

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
    AtomicInteger TotalHarga = new AtomicInteger(0);
    AtomicInteger JumlahPesanan = new AtomicInteger(0);
    private void AutoCount(Label Price) {

        TextFieldPembayaran.clear();

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
        valueFactory.setValue(0);
        SpinnerJumlahPesanan.setValueFactory(valueFactory);
    
        SpinnerJumlahPesanan.valueProperty().addListener((observable, oldValue, newValue) -> {
            int hargaPerItem = Integer.parseInt(Price.getText());
            int jumlahPesanan = newValue;
            int totalHarga = hargaPerItem * jumlahPesanan;
            LabelTotalHarga.setText("Total Harga : Rp " + totalHarga);
            PaneConfirm.setVisible(false);
            TotalHarga.set(totalHarga);
            JumlahPesanan.set(jumlahPesanan);
        });
        
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

    }

}


//Pattern InputPembayaran = Pattern.compile("^[0-9]+$");
// if (InputPembayaran.matcher(InputTextfield).matches()){
                
            // } else {
            //     Alert alert = new Alert(AlertType.WARNING);
            //     alert.setHeaderText("please enter a number");
            //     alert.show();
            // }