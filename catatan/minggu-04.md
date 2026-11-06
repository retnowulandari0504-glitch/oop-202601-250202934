# Catatan Minggu 04: Polimorfisme

## Yang saya kerjakan
Saya mengisi `hitungDenda(int)` di `Aset` lalu menimpanya (override) di `Ruang`, `Laptop`, dan `AlatLab` dengan pengganda 1x, 2x, dan 4x. Rumus dendanya hari x pengganda x `Varian.aktif().dendaPerHari`. Hari 0 menghasilkan 0, dan hari negatif melempar `IllegalArgumentException`. Saya juga membuat dua versi `cari(...)` di `KatalogAset`: `cari(kata)` untuk mencari nama tanpa membedakan huruf besar atau kecil, dan `cari(kata, jenis)` yang hanya mengembalikan aset dengan jenis tertentu.

## Keputusan desain
Aturan minggu ini sudah pasti, jadi tidak ada keputusan besar. Satu keputusan kecil: rumus denda saya tulis sekali di `Aset` lewat method `protected hitungDenda(int, int)`, lalu tiap subclass hanya mengirim penggandanya. Dengan begitu rumus dan validasi hari negatif tidak ditulis ulang tiga kali. Overriding terjadi pada `hitungDenda(int)` di subclass (dipilih saat program berjalan sesuai tipe objek), sedangkan overloading terjadi pada `hitungDenda(int, int)` dan `cari(kata)` / `cari(kata, jenis)` (dipilih saat kompilasi dari parameter).

## Kendala
Kendala utama saya adalah kurang tanda kurung kurawal `{}` saat menambahkan method `hitungDenda` dan `cari(...)`. Karena ada `{` atau `}` yang tidak berpasangan, kompilasi gagal dan seluruh build ikut gagal. Saya mengatasinya dengan membaca nomor baris di pesan error Maven, mengklik tanda kurung di VS Code untuk melihat pasangannya, lalu menambah atau menghapus kurung yang salah dan memastikan method baru berada di dalam class. Saya juga menjalankan `.\scripts\uji.ps1 -Minggu 4` sebelum commit supaya error seperti ini ketahuan di komputer sendiri.

Hasil tes terakhir: awalnya 3 tes `cari` gagal karena `KatalogAset` belum diisi; setelah saya isi, semua tes lulus (27 tes, minggu 1 sampai 4), BUILD SUCCESS. 

## Penggunaan AI
- Alat yang dipakai: Claude
- Bagian yang dibantu AI: `hitungDenda` di `Aset`, `Ruang`, `Laptop`, `AlatLab`, dan kerangka `cari(...)` di `KatalogAset`
- Prompt utama:
  1. Saya menempelkan teks tugas Minggu 4 dan meminta dibuatkan kodenya.
  2. Saya menempelkan isi `Aset.java` dan `Ruang.java` saya, lalu meminta versi lengkap dengan `hitungDenda`.
- Yang saya ubah atau tolak dari saran AI, dan alasannya: Menyesuaikan nama field di `KatalogAset` dengan file asli, atau cara membaca `dendaPerHari` sesuai `Varian.java`.
- Satu hal yang saya pahami lebih baik sekarang: Kerangka: overriding memilih method saat program berjalan sesuai tipe objek sebenarnya, sedangkan overloading memilih saat kompilasi berdasarkan parameter.
