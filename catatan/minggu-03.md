# Catatan Minggu 03: Warisan

## Yang saya kerjakan
Saya membuat tiga subclass dari `Aset`, yaitu `Ruang`, `Laptop`, dan `AlatLab`. Masing-masing mempunyai field khusus, getter, dan konstruktor yang memanggil `super(...)` lebih dulu supaya divalidasi `Aset` tetap berjalan. Setiap subclass juga meng-override `getJenis()` dan mengembalikan nilai `JenisAset` yang sesuai. Validasi tambahan saya tulis di konstruktor subclass: kapasitas > 0, spesifikasi dan nomor inventaris tidak kosong, laboratorium tidak kosong, dan tingkat risiko tidak null.

## Keputusan desain
Field yang dimiliki semua aset (`id`, `nama`) saya biarkan di `Aset`, karena semua jenis aset memakainya dan validasinya cukup ditulis sekali. [Sesuaikan dengan field asli di `Aset.java`.] Field yang hanya bermakna untuk satu jenis saya taruh di subclass: `kapasitas` di `Ruang`, `spesifikasi` dan `nomorInventaris` di `Laptop`, serta `laboratorium` dan `tingkatRisiko` di `AlatLab`. Kalau field itu dipindah ke induk, laptop akan membawa `kapasitas` yang tidak punya arti, dan `Aset` jadi penuh field yang sering kosong. Semua field subclass saya buat `final` karena nilainya tidak berubah setelah objek dibuat.

Satu keterbatasan inheritance di sistem ini: `AlatLab` mewarisi `Aset` sehingga `tingkatRisiko` terikat pada hierarki aset. Aturan risiko, misalnya syarat keselamatan sebelum alat boleh dipinjam, tidak bisa dipakai ulang oleh jenis aset lain tanpa membuat hierarki baru. Jenis aset juga ditentukan saat objek dibuat dan tidak bisa diubah. Dengan komposisi, `AlatLab` cukup memiliki objek `KebijakanRisiko` yang bisa diganti atau dipakai bersama. Hubungan "punya" ini lebih tepat daripada "adalah" dan lebih fleksibel. [Kalau ada contoh lain di `Aset` yang lebih cocok, ganti dengan itu.]

## Kendala
1. Setelah melihat nama tab tidak sama dengan nama class di dalam file, lalu menghapus kode dari `JenisAset.java` sampai tinggal enum aslinya dan menempelkannya ke `AlatLab.java`
2. Saya belum yakin bentuk konstruktor `Aset` dan tipe tingkat risiko yang dipakai tes karena `TingkatRisiko.java` belum ada di folder `model`; saya mencocokkannya dengan membuka `Aset.java` dan `Minggu03.java`
3. CI di GitHub merah karena error kompilasi kecil, nama file yang tidak sama dengan nama class, dan file yang lupa di-`git add`; saya mengatasinya dengan menjalankan `.\scripts\uji.ps1` sampai `BUILD SUCCESS` dan mengecek `git status` sebelum commit dan push. Hasil tes terakhir: [isi sendiri: semua tes lulus, atau tes yang sempat gagal dan cara memperbaikinya], dan status CI di GitHub: [isi sendiri: hijau atau merah].


## Penggunaan AI
- Alat yang dipakai: Claude
- Bagian yang dibantu AI: kerangka konstruktor, getter, dan `getJenis()` di `Ruang`, `Laptop`, `AlatLab`; ide contoh inheritance vs komposisi
- Prompt utama:
  1. Saya menempelkan teks tugas Minggu 3 (Tujuan sampai Pengumpulan) dan meminta dibuatkan kodenya.
  2. Saya menempelkan pesan error `UnsupportedOperationException: TODO minggu 3: konstruktor Ruang` dan `konstruktor Laptop` dari hasil tes, lalu bertanya apakah `Ruang.java` dan `Laptop.java` memang harus diisi sekarang, padahal saya kira dikerjakan di minggu 5 dan 8.

- Yang saya ubah atau tolak dari saran AI, dan alasannya: Saya menghapus kode `AlatLab` yang tertempel di `JenisAset.java` dan mengembalikan `JenisAset.java` ke versi dosen, karena enum itu disediakan dosen dan tidak boleh diubah. Saya juga mencocokkan konstruktor dengan `Minggu03HierarkiTest` sebelum menempel, dan memeriksa `docs/minggu-03.md` untuk memastikan `Ruang` dan `Laptop` memang tugas minggu 3.

- Satu hal yang saya pahami lebih baik sekarang: `super(kode, nama)` harus dipanggil di baris pertama konstruktor subclass. Dengan begitu validasi dari `Aset` (kode dan nama tidak boleh kosong) otomatis berlaku juga di `Ruang`, `Laptop`, dan `AlatLab`, jadi saya tidak perlu menulis ulang validasi yang sama. Subclass hanya menambah validasi untuk field miliknya sendiri, misalnya kapasitas harus lebih dari 0.