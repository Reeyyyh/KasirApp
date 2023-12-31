import java.net.URL;
import java.util.ResourceBundle;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Controller untuk menangani tampilan dan logika dari histori pesanan.
 *
 * @apiNote Digunakan untuk menampilkan dan menghapus data histori pesanan.
 * @version 1.0
 */
public class HistoryController implements Initializable {

    @FXML
    private TableView<DataModel> HistoryTable;
    
    @FXML
    private TableColumn<DataModel, String> colWaktu;
    
    @FXML
    private TableColumn<DataModel, String> colMenu;
    
    @FXML
    private TableColumn<DataModel, String> colJumlah;
    
    @FXML
    private TableColumn<DataModel, String> colHarga;
    
    @FXML
    private TableColumn<DataModel, String> colBayar;
    
    @FXML
    private TableColumn<DataModel, String> colKembalian;

    @FXML
    private Button deleteButton;

    @FXML
    private Button kasirButton;

    private ObservableList<DataModel> Data = FXCollections.observableArrayList();

    public class DataModel {
        private final String waktu;
        private final String menu;
        private final String jumlah;
        private final String totalHarga;
        private final String pembayaran;
        private final String kembalian;
    
        public DataModel(String waktu, String menu, String jumlah, String totalHarga, String pembayaran, String kembalian) {
            this.waktu = waktu;
            this.menu = menu;
            this.jumlah = jumlah;
            this.totalHarga = totalHarga;
            this.pembayaran = pembayaran;
            this.kembalian = kembalian;
        }
        public String getWaktu() {
            return waktu;
        }

        public String getMenu() {
            return menu;
        }

        public String getJumlah() {
            return jumlah;
        }

        public String getTotalHarga() {
            return totalHarga;
        }

        public String getPembayaran() {
            return pembayaran;
        }

        public String getKembalian() {
            return kembalian;
        }
    }

    /**
     * Kelas pembantu untuk membaca data dari file.
     */
    private class DataReader {
        /**
         * Membaca data dari file teks.
         *
         * @param namaFile Nama file yang akan dibaca.
         * @return List<String> berisi baris-baris data dari file.
         */
        public static List<String> bacaData(String namaFile) {
            Path path = Paths.get(namaFile);
            try {
                return Files.readAllLines(path);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /**
     * Memperbarui Data.txt dengan data terbaru setelah penghapusan.
     */
    private void updateTxtFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\Data.txt"))) {
            for (DataModel data : Data) {
                String line = String.format("%s, %s, %s, %s, %s, %s", data.getWaktu(), data.getMenu(),data.getJumlah(), data.getTotalHarga(), data.getPembayaran(), data.getKembalian());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void DeleteButtonClick(ActionEvent event) {
        System.out.println("delete click");

        DataModel select = HistoryTable.getSelectionModel().getSelectedItem();
        if (select != null){
            Data.remove(select);
            HistoryTable.getSelectionModel().clearSelection();
            updateTxtFile();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Pilih Tabel yang ingin di Hapus");
            alert.show();
        }
    }

    /**
     * Mengarahkan kembali ke antarmuka pengguna Sistem Kasir.
     *
     * @param event Aksi klik tombol kembali ke Kasir.
     */
    @FXML
    void KasirButtonClick(ActionEvent event) {
        System.out.println("kasir clicked");
        try {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Kasir.fxml"));
        Scene scene = new Scene(root);

        Image icon = new Image("file:asset\\img\\IconKasir.png");
        primaryStage.getIcons().add(icon);

        primaryStage.setTitle("Sistem Kasir");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Menginisialisasi tampilan tabel dan membaca data dari file .txt.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    // Mapping kolom ke properti DataModel
        colWaktu.setCellValueFactory(new PropertyValueFactory<>("waktu"));
        colMenu.setCellValueFactory(new PropertyValueFactory<>("menu"));
        colJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("totalHarga"));
        colBayar.setCellValueFactory(new PropertyValueFactory<>("pembayaran"));
        colKembalian.setCellValueFactory(new PropertyValueFactory<>("kembalian"));

        // Baca data dari file dan tambahkan ke dalam ObservableList
        List<String> lines = DataReader.bacaData("src\\Data.txt");
        for (String line : lines) {
            String[] parts = line.split(","); // pemisah pada file
            if (parts.length == 6) {
                String waktu = parts[0].trim();
                String menu = parts[1].trim();
                String jumlah = parts[2].trim();
                String totalHarga = parts[3].trim();
                String pembayaran = parts[4].trim();
                String kembalian = parts[5].trim();
                Data.add(new DataModel(waktu, menu, jumlah, totalHarga, pembayaran, kembalian));
            }
        }

        // Set item ke dalam tabel
        HistoryTable.setItems(Data);
    }

}
