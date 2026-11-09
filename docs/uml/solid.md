# SOLID di Aset-Pinjam

## OCP (Open/Closed Principle): AturanDenda
Kelas yang terlibat: `AturanDenda`, `DendaFlat`, `DendaProgresif`. Cara menghitung denda baru bisa ditambah dengan membuat class baru yang mengimplementasikan `AturanDenda`, tanpa mengubah `Aset` atau kelas denda yang sudah ada. Jadi sistem terbuka untuk perluasan tetapi tertutup untuk perubahan, dan risiko merusak kode lama kecil.

## LSP (Liskov Substitution Principle): Aset dan subclass
Kelas yang terlibat: `Aset`, `Ruang`, `Laptop`, `AlatLab`. Objek subclass bisa dipakai di mana pun dibutuhkan `Aset` tanpa merusak perilaku. `bisaDipinjam()`, `hitungDenda(int)`, dan `getJenis()` tetap memenuhi kontraknya, misalnya hari negatif tetap ditolak dan 0 hari tetap 0. `KatalogAset` menyimpan semua jenis sebagai `Aset`.