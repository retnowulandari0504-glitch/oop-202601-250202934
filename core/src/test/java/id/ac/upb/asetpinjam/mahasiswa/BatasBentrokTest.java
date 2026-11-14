package id.ac.upb.asetpinjam.mahasiswa;

import static org.assertj.core.api.Assertions.assertThat;

import id.ac.upb.asetpinjam.jadwal.JadwalPeminjaman;
import id.ac.upb.asetpinjam.model.Aset;
import id.ac.upb.asetpinjam.model.Peminjam;
import id.ac.upb.asetpinjam.model.Peminjaman;
import id.ac.upb.asetpinjam.model.Ruang;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("week7")
class BatasBentrokTest {

    private final Peminjam peminjam = new Peminjam("M1", "Budi");
    private final Aset ruangA = new Ruang("R1", "Ruang A", 30);
    private final Aset ruangB = new Ruang("R2", "Ruang B", 20);

    private static LocalDateTime jam(int j, int m) {
        return LocalDateTime.of(2026, 11, 10, j, m);
    }

    private Peminjaman pinjam(String id, Aset aset, LocalDateTime mulai, LocalDateTime selesai) {
        return new Peminjaman(id, peminjam, aset, mulai, selesai);
    }

    @Test
    void selesaiSamaDenganMulai() {
        JadwalPeminjaman jadwal = new JadwalPeminjaman(2);
        jadwal.tambah(pinjam("P1", ruangA, jam(9, 0), jam(11, 0)));

        assertThat(jadwal.bentrok(pinjam("P2", ruangA, jam(11, 0), jam(13, 0)))).isFalse();
    }

    @Test
    void mulaiSamaDenganSelesaiLamaTidakBentrokDariArahSebaliknya() {
        JadwalPeminjaman jadwal = new JadwalPeminjaman(2);
        jadwal.tambah(pinjam("P1", ruangA, jam(11, 0), jam(13, 0)));

        assertThat(jadwal.bentrok(pinjam("P2", ruangA, jam(9, 0), jam(11, 0)))).isFalse();
    }

    @Test
    void tumpangTindihSatuMenitBentrok() {
        JadwalPeminjaman jadwal = new JadwalPeminjaman(2);
        jadwal.tambah(pinjam("P1", ruangA, jam(9, 0), jam(11, 0)));

        assertThat(jadwal.bentrok(pinjam("P2", ruangA, jam(10, 59), jam(13, 0)))).isTrue();
    }

    @Test
    void rentangIdentikBentrok() {
        JadwalPeminjaman jadwal = new JadwalPeminjaman(2);
        jadwal.tambah(pinjam("P1", ruangA, jam(9, 0), jam(11, 0)));

        assertThat(jadwal.bentrok(pinjam("P2", ruangA, jam(9, 0), jam(11, 0)))).isTrue();
    }

    @Test
    void rentangBaruTerkandungDiDalamLamaBentrok() {
        JadwalPeminjaman jadwal = new JadwalPeminjaman(2);
        jadwal.tambah(pinjam("P1", ruangA, jam(8, 0), jam(14, 0)));

        assertThat(jadwal.bentrok(pinjam("P2", ruangA, jam(10, 0), jam(11, 0)))).isTrue();
    }

    @Test
    void rentangBaruMembungkusLamaBentrok() {
        JadwalPeminjaman jadwal = new JadwalPeminjaman(2);
        jadwal.tambah(pinjam("P1", ruangA, jam(10, 0), jam(11, 0)));

        assertThat(jadwal.bentrok(pinjam("P2", ruangA, jam(8, 0), jam(14, 0)))).isTrue();
    }

    @Test
    void waktuSamaTetapiAsetBedaTidakBentrok() {
        JadwalPeminjaman jadwal = new JadwalPeminjaman(2);
        jadwal.tambah(pinjam("P1", ruangA, jam(9, 0), jam(11, 0)));

        assertThat(jadwal.bentrok(pinjam("P2", ruangB, jam(9, 0), jam(11, 0)))).isFalse();
    }

    @Test
    void terpisahJauhTidakBentrok() {
        JadwalPeminjaman jadwal = new JadwalPeminjaman(2);
        jadwal.tambah(pinjam("P1", ruangA, jam(8, 0), jam(9, 0)));

        assertThat(jadwal.bentrok(pinjam("P2", ruangA, jam(15, 0), jam(16, 0)))).isFalse();
    }
}