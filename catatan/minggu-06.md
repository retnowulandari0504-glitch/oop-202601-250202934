# Catatan Minggu 06: UML dan SOLID

## Yang saya kerjakan
Saya membuat Class Diagram di `docs/uml/class.md` dari kode yang sudah ada (`Aset` dan tiga subclass, `DendaFlat`, `DendaProgresif`, `KatalogAset`, `Peminjaman`), lengkap dengan atribut, method, visibilitas, relasi, dan multiplisitas. Saya juga membuat Sequence Diagram pengajuan peminjaman di `docs/uml/sequence.md` dengan fragmen `alt` untuk skenario sukses dan skenario bentrok. Terakhir, saya menulis `docs/uml/solid.md` yang menunjukkan prinsip OCP dan LSP beserta kelas yang terlibat.

## Keputusan desain
- Prinsip OCP ditunjukkan di `AturanDenda`, `DendaFlat`, dan `DendaProgresif`: aturan denda baru bisa ditambah dengan class baru tanpa mengubah `Aset` atau kelas denda yang sudah ada.
- Prinsip LSP saya tunjukkan di `Aset`, `Ruang`, `Laptop`, dan `AlatLab`: subclass bisa dipakai di mana pun dibutuhkan `Aset` tanpa merusak perilaku.
- Diagram dibuat dengan Mermaid dalam berkas `.md` supaya langsung tampil di GitHub dan bisa diperiksa terhadap kode. Saya tidak mengubah kode karena prinsipnya sudah terlihat di kode yang ada.

## Kendala
1. Kesulitan mencari letaknya docs/uml
2. Berkas `solid.md` sempat kosong sehingga tes `catatanSolidAda` gagal dengan pesan `Expecting actual: 0 to be greater than: 300`. Setelah saya isi (797 karakter), tes lulus.
**Membuat Class Diagram (`class.md`).** Kesulitan terbesar adalah menjaga diagram tetap sama dengan kode, bukan sketsa ideal. Ada banyak kelas (`Aset`, `Ruang`, `Laptop`, `AlatLab`, `DendaFlat`, `DendaProgresif`, `KatalogAset`, `Peminjaman`), dan saya harus menentukan visibilitas (`-`, `+`, `#`), tipe, serta relasi dan multiplisitasnya. Saya juga sempat bingung membedakan pewarisan (`Aset <|-- Ruang`), implementasi interface (`DapatDipinjam <|.. Aset`), dan asosiasi (`Peminjaman --> Aset`). Saya mengatasinya dengan membuka file asli satu per satu dan mencocokkan nama atribut dan method sebelum menulis diagram.


Hasil tes terakhir: semua tes lulus, BUILD SUCCESS. Status CI di GitHub: Hijau.


## Penggunaan AI
- Alat yang dipakai: Claude
- Bagian yang dibantu AI: kerangka Class Diagram, Sequence Diagram, dan isi `solid.md`
- Prompt utama:
  1. Saya menempelkan teks tugas Minggu 6 dan meminta bantuan membuat diagram serta penjelasan SOLID.
  2. Saya menempelkan hasil tes yang gagal (`solid.md minimal 300 karakter`) dan menanyakan penyebabnya.
- Yang saya ubah atau tolak dari saran AI, dan alasannya: saya mengganti nama kelas di sequence diagram dengan kelas asli di paket `jadwal`, atau menyesuaikan atribut `Peminjam` dengan file aslinya.
- Satu hal yang saya pahami lebih baik sekarang: perbedaan agregasi dan komposisi, atau mengapa OCP memudahkan pengembangan.