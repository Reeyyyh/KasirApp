# Sistem Kasir JavaFX

Sistem Kasir JavaFX adalah aplikasi sederhana untuk manajemen pesanan dan histori pembelian. Aplikasi ini dikembangkan menggunakan JavaFX dan menyediakan antarmuka pengguna grafis (GUI) untuk pengguna.

## Fitur

- **Pemesanan Menu:** Pilih dan pesan berbagai menu seperti Burger, Pizza, Ramen, dan Minuman.
- **Perhitungan Otomatis:** Otomatis menghitung total harga pesanan berdasarkan jumlah yang dipilih.
- **Histori Pembelian:** Melihat histori pembelian dengan rincian waktu, menu, jumlah, total harga, pembayaran, dan kembalian.
- **Penghapusan Data:** Hapus entri histori pembelian dengan mudah. (masih memiliki bug)

## Teknologi

- JavaFX
- SceneBuilder (untuk styling)

## Penggunaan

1. Pastikan Anda memiliki Java diinstal di sistem Anda.
2. Jalankan file `KasirApp.java` untuk memulai aplikasi.
3. Pilih menu, atur jumlah pesanan, lalu konfirmasi dan bayar.
4. Lihat histori pembelian untuk melihat catatan pesanan sebelumnya.

## Struktur Proyek

- `KasirApp.java`: Kelas utama untuk menjalankan aplikasi.
- `Kasir.fxml`: FXML file untuk antarmuka pengguna.
- `HistoryController.java`: Kontroller untuk menangani logika dan tampilan histori pembelian.
- `DataReader.java`: Kelas pembantu untuk membaca data dari file.
- `asset/img`: Direktori berisi gambar ikon dan gambar menu.

## Kontribusi

Silakan berkontribusi dengan membuat *pull request* untuk perbaikan bug atau peningkatan fitur.

## Lisensi

Proyek ini dilisensikan di bawah [MIT License](LICENSE).
