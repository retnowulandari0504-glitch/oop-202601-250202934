# Catatan Minggu 05: Abstraksi

## Yang saya kerjakan
Saya menjadikan `Aset` sebagai class `abstract`, mengisi `bisaDipinjam()` (true hanya jika status TERSEDIA dan kondisi bukan RUSAK_BERAT), dan menjadikan `getJenis()` serta `hitungDenda(int)` method abstrak. Saya juga mengisi `DendaFlat` (hasilnya sama dengan `aset.hitungDenda(hari)`) dan `DendaProgresif`, yang keduanya mengimplementasikan interface `AturanDenda`.

## Keputusan desain
- `Aset` dibuat abstract karena tidak masuk akal ada aset yang "generik"; yang ada selalu Ruang, Laptop, atau AlatLab. Abstract class dipakai untuk berbagi field dan kode (`kode`, `nama`, `status`, `kondisi`), sedangkan interface (`DapatDipinjam`, `AturanDenda`) dipakai sebagai kontrak kemampuan yang bisa diimplementasikan class mana pun.
- Method `protected hitungDenda(int, int)` tetap ada di `Aset` sebagai helper, supaya rumus dan validasi hari negatif ditulis sekali dan subclass hanya mengirim penggandanya.
- Rumus denda progresif (asumsi): hari 1 sampai 7 sama dengan flat; setiap hari setelah hari ke-7 ditambah 50% dari tarif harian. Alasannya sederhana, tidak pernah lebih murah dari flat, tidak turun saat hari bertambah, dan pada hari ke-30 lebih mahal dari flat.

## Kendala
1. `AturanDenda` ternyata ada di folder `kontrak`, bukan `denda`, jadi `DendaFlat` dan `DendaProgresif` merah karena import belum ada. Saya menemukannya dengan mencari file berisi kata "Denda", lalu menambah `import id.ac.upb.asetpinjam.kontrak.AturanDenda;`.
2. Tes minggu 5 sempat gagal karena `Aset` belum abstract dan `bisaDipinjam()` masih `TODO`.
3. Baris `public abstract class Aset ...` sempat terketik di terminal, bukan di file, sehingga muncul error `The type Aset must be an abstract class to define abstract methods` dan puluhan tes dari minggu 2 sampai 5 ikut gagal. Saya memastikan perubahan masuk ke file dengan `Select-String ... 'abstract class'`.

Hasil tes terakhir: semua tes lulus, setelah dicek diterminal `.\scripts\uji.ps1 -Minggu 5` menampilkan hasil akhir. Status CI di GitHub: hijau

## Penggunaan AI
- Alat yang dipakai: Claude
- Bagian yang dibantu AI: perubahan `Aset` (abstract, `bisaDipinjam`), `DendaFlat`, `DendaProgresif`, dan membaca pesan error tes
- Prompt utama:
  1. Saya menempelkan hasil tes yang gagal (`The type Aset must be an abstract class`) dan menanyakan penyebabnya.
- Yang saya ubah atau tolak dari saran AI, dan alasannya: Tebakan awal AI soal import `AturanDenda` meleset, jadi saya mencari lokasi file aslinya dan membaca isi interface sebelum menempel kode. Saya juga memastikan baris `abstract class` benar-benar masuk ke file `Aset.java`, bukan ke terminal.

- Satu hal yang saya pahami lebih baik sekarang: Class yang punya method abstrak wajib dideklarasikan `abstract`, kalau tidak semua class akan menjadi error. Bedanya abstract class (berbagi field dan kode antar jenis yang berkerabat) dengan interface (kontrak kemampuan seperti `AturanDenda`).