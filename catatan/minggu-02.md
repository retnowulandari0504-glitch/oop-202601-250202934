# Catatan Minggu 2: (Struktur OOP: Kelas, Objek, Enkapsulasi)

## Yang saya kerjakan
Saya melengkapi kelas "Aset" yang berisi kode, nama, status, kondisi, getter dan setter. nilai awal 'status, adalah TERSEDIA dan 'kondisi' adalah BAIK, 'setnama' menolak nilai kosong/null, sedangkan 'setStatus' dan 'setKondisi' menolak null. 

## Keputusan desain
- 'Kode' saya buat 'final' dan 'tidak diberi setter', sehingga kode tidak bisa diubah setelah objek dibuat 
- Kode tidak diubah-ubah (tidak di-trim dan tidak dijadikan huruf besar), disimpan persis sesuai yang diinput.

## Kendala
Setelah mengetik kode, banyak garis merah muncul. ternyata penyebabnya salah ketik:
- "StatuseAset" seharusnya "StatusAset"
- 'retrun' seharusnya 'return'
- titik koma (;) hilang di 'this.kondisi = kondisi'

## Penggunaan AI
- Alat yang dipakai: Claude 

- Bagian yang dibantu AI: kerangka kelas `Aset` (konstruktor, getter, setter dan validasinya), serta membantu menemukan penyebab error di editor.

- Prompt utama: (tempel 1-3 prompt yang paling menentukan)
     1. Spesifikasi tugas minggu 2 beserta kode awal `Aset.java`, lalu meminta dibuatkan kodenya.
    2. Screenshot editor dengan pertanyaan "banyak yang merah, masalahnya apa dan solusinya bagaimana".

- Yang saya ubah atau tolak dari saran AI, dan alasannya:
 Saya tetap memakai `trim().isEmpty()` dan pesan error buatan saya sendiri, bukan `isBlank()` saran dari AI, karena itu yang sudah saya tulis dan sudah berfungsi sama. Saya juga menghapus komentar `// TODO minggu 2` yang sudah tidak diperlukan karena kodenya sudah selesai.

- Satu hal yang saya pahami lebih baik sekarang:
Field dibuat `private` supaya orang lain tidak bisa mengisi nilainya sembarangan dari luar. Lewat setter, setiap nilai yang masuk bisa dicek dulu di satu tempat (misalnya tidak boleh null/tidak boleh kosong). 