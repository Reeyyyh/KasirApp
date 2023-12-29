import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KasirControllerTest {

    private KasirController kasirController = new KasirController();

    @Test
    public void testAutoCount() {
        // Melakukan pengujian pada metode AutoCount
        kasirController.setAutoCount("Total Harga : Rp 0", 0);

        // Assertion (Anda perlu mengganti nilai-nilai ini sesuai dengan logika Anda)
        assertEquals("Total Harga : Rp 0", kasirController.getLabelTotalHargaText());
    }
}
