# Asumsi dan Keputusan Desain

Isi bagian ini sendiri. Satu entri per keputusan. Dinilai dari kejelasan alasan dan konsistensi dengan kode dan tes Anda,
bukan dari jawaban "benar".

Format tiap entri:

```
## A-NN: judul singkat
- Pertanyaan: ...
- Keputusan: ...
- Alasan: ...
- Dampak ke kode: ... (kelas/metode)
- Tes yang membuktikan: ... (nama tes di folder mahasiswa/)
```

## Aturan ambigu dari docs/aturan-bisnis.md

Salin setiap pertanyaan ambigu (nomor 1 sampai 7) ke sini dan jawab. 


## A-01: batas waktu bentrok
- Pertanyaan: 09:00-11:00 dan 11:00-13:00 pada aset yang sama bentrok atau tidak?
- Keputusan: Tidak bentrok.
- Alasan: Rentang saya perlakukan setengah terbuka (mulai, selesai), sehingga peminjaman yang berakhir tepat saat peminjaman lain mulai tidak berbagi waktu. Aset bisa langsung dipakai peminjam berikutnya.
- Dampak ke kode: `JadwalPeminjaman.bentrok`: bentrok jika aset sama dan `baru.mulai < lama.selesai` dan `lama.mulai < baru.selesai`, memakai `isBefore` (ketat).
- Tes yang membuktikan: `BatasBentrokTest.selesaiSamaDenganMulai` dan `BatasBentrokTest.mulaiSamaDenganSelesaiLamaTidakBentrokDariArahSebaliknya`.


## Asumsi lain

Tambahkan di sini keputusan lain yang Anda ambil: rumus denda progresif, perubahan skema database, format error API, dan seterusnya.
## A-02: Rumus Denda Progresif
- Pertanyaan: bagaimana rumus `DendaProgresif`?
- Keputusan: hari 1 sampai 7 sama dengan flat; tiap hari setelah hari ke-7 ditambah 50% tarif harian.
- Alasan: sederhana, tidak pernah lebih murah dari flat, tidak turun saat hari bertambah, dan pada hari ke-30 lebih mahal dari flat.
- Dampak ke kode: `DendaProgresif.hitung`.
- Tes yang membuktikan: `Minggu05AbstraksiTest.dendaProgresifMemenuhiSyaratMinimal` (tes dosen).
