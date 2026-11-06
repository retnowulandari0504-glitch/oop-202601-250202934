# Catatan Minggu 04: Polimorfisme

## Yang saya kerjakan
Saya mengisi `hitungDenda(int)` di `Aset` lalu menimpanya (override) di `Ruang`, `Laptop`, dan `AlatLab` dengan pengganda 1x, 2x, dan 4x. Rumus dendanya hari x pengganda x `Varian.aktif().dendaPerHari`. Hari 0 menghasilkan 0, dan hari negatif melempar `IllegalArgumentException`. Saya juga membuat dua versi `cari(...)` di `KatalogAset`: `cari(kata)` untuk mencari nama tanpa membedakan huruf besar atau kecil, dan `cari(kata, jenis)` yang hanya mengembalikan aset dengan jenis tertentu.

## Keputusan desain
Aturan minggu ini sudah pasti, jadi tidak ada keputusan besar. Satu keputusan kecil: rumus denda saya tulis sekali di `Aset` lewat method `protected hitungDenda(int, int)`, lalu tiap subclass hanya mengirim penggandanya. Dengan begitu rumus dan validasi hari negatif tidak ditulis ulang tiga kali. Overriding terjadi pada `hitungDenda(int)` di subclass (dipilih saat program berjalan sesuai tipe objek), sedangkan overloading terjadi pada `hitungDenda(int, int)` dan `cari(kata)` / `cari(kata, jenis)` (dipilih saat kompilasi dari parameter).

## Kendala
1. Kurang tanda kurung kurawal `{}` saat menambahkan method `hitungDenda` dan `cari(...)`, sehingga kompilasi gagal. Saya mengatasinya dengan membaca nomor baris di pesan error dan mengklik tanda kurung di VS Code untuk melihat pasangannya.
2. Tes minggu 4 awalnya gagal: 3 tes `cari` error dengan pesan `TODO minggu 4: cari(String)` karena `KatalogAset` belum saya isi, sedangkan 5 tes `hitungDenda` sudah lulus.
3. Tombol Run dari ekstensi Code Runner menampilkan banyak error `cannot find symbol` karena hanya mengompilasi satu file. Saya beralih memakai `.\scripts\uji.ps1 -Minggu 4`, yang hasilnya sama dengan CI.
4. Saat menempel kode `KatalogAset`, isi file sempat tidak berubah (tes yang sama gagal dua kali) karena kode belum tertempel dan tersimpan. Saya memastikannya dengan `Select-String ... 'TODO'` dan `git status --short` sebelum menjalankan tes lagi.

Hasil tes terakhir: semua tes lulus (27 tes, minggu 1 sampai 4), BUILD SUCCESS. Status CI di GitHub: hijau.

## Penggunaan AI
- Alat yang dipakai: Claude
- Bagian yang dibantu AI: `hitungDenda` di `Aset`, `Ruang`, `Laptop`, `AlatLab`, dan `cari(...)` di `KatalogAset`
- Prompt utama:
  1. Saya menempelkan teks tugas Minggu 4 dan meminta dibuatkan kodenya.
  2. Saya menempelkan hasil `.\scripts\uji.ps1 -Minggu 4` yang menunjukkan 3 tes `cari` gagal, lalu menanyakan penyebabnya dan cara memperbaikinya.
- Yang saya ubah atau tolak dari saran AI, dan alasannya: Saya menunjukkan isi `KatalogAset.java` asli lebih dulu supaya nama field (`daftar`) dan import cocok, dan saya tidak mengubah `tambah()` dan `semua()` karena sudah disediakan dosen.
- Satu hal yang saya pahami lebih baik sekarang: overriding memilih method saat program berjalan sesuai tipe objek sebenarnya (misalnya `hitungDenda` di `Laptop`), sedangkan overloading memilih method saat kompilasi berdasarkan parameter (misalnya `cari(kata)` dan `cari(kata, jenis)`).