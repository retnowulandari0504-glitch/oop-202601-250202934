# Catatan Minggu 07: Koleksi

## Yang saya kerjakan
Saya mengisi empat method di `JadwalPeminjaman`: `bentrok` (true jika ada peminjaman pada aset yang sama dengan rentang waktu yang tumpang tindih), `semuaUrutMulai` (diurutkan menaik menurut waktu mulai dengan `Comparator`), `perAset` (dikelompokkan menurut kode aset), dan `hapus` (true jika ada yang terhapus). Method `ajukan` sengaja saya biarkan karena itu tugas minggu 9. Saya juga menulis 8 tes sendiri di `mahasiswa/BatasBentrokTest.java` untuk perilaku di batas waktu.

## Keputusan desain
- Peminjaman 09:00-11:00 dan 11:00-13:00 pada aset yang sama TIDAK dianggap bentrok, karena rentang diperlakukan setengah terbuka (mulai, selesai): kedua peminjaman tidak berbagi waktu. Kondisi bentrok: mulai baru < selesai lama dan mulai lama < selesai baru.  Keputusan ini juga saya catat di `docs/asumsi.md`.
- Struktur data: `List` untuk daftar utama karena urutan penambahan terjaga dan mudah diurutkan dengan `Comparator`. `Map` (kode aset ke daftar peminjaman) dipakai untuk `perAset` karena pengelompokan per kunci lebih tepat daripada menyaring list berulang kali. `Set` tidak saya pakai karena `id` peminjaman sudah unik dan tidak ada kebutuhan membuang duplikat.
- `semuaUrutMulai` mengurutkan salinan list, bukan list aslinya, supaya urutan penambahan di `daftar` tidak berubah.

## Kendala
1. Yang pertama saya tempel ternyata menggunakan template asli, sehingga empat method masih `TODO` dan tes minggu 7 akan gagal. Saya memastikannya dengan `Select-String ... 'TODO minggu 7'` sampai tidak ada hasil.
2. `BatasBentrokTest` ternyata sudah ada di `core/src/test/java/.../mahasiswa` dengan `@Disabled`, bukan di folder terpisah. Isinya sempat belum berubah karena kode belum tertempel dan tersimpan, jadi saya cek lagi dengan `Select-String` sebelum menjalankan tes.
3. Harus membuka `Peminjam.java` untuk tahu `Peminjam` adalah record `(id, nama)` sebelum menulis tes.

Hasil tes terakhir: semua tes lulus (51 tes, minggu 1 sampai 7), BUILD SUCCESS.

## Penggunaan AI
- Alat yang dipakai: Claude
- Bagian yang dibantu AI: method di `JadwalPeminjaman` dan kerangka 8 tes di `BatasBentrokTest`
- Prompt utama: Saya menempelkan isi template `JadwalPeminjaman.java` dan `BatasBentrokTest.java` supaya kodenya sesuai.
- Yang saya ubah atau tolak dari saran AI, dan alasannya: mengecek isi template dan record `Peminjam` dulu sebelum menempel, karena tebakan awal soal konstruktor harus dicocokkan dengan kode asli.
- Satu hal yang saya pahami lebih baik sekarang: kapan memilih List, Map, atau Set, atau mengapa batas waktu perlu diputuskan lewat rentang setengah terbuka.