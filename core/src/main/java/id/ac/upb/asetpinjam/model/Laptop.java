package id.ac.upb.asetpinjam.model;

public class Laptop extends Aset {

    private final String spesifikasi;
    private final String nomorInventaris;

    public Laptop(String kode, String nama, String spesifikasi, String nomorInventaris) {
        super(kode, nama);
        if (spesifikasi == null || spesifikasi.trim().isEmpty()) {
            throw new IllegalArgumentException("Spesifikasi tidak boleh kosong!");
        }
        if (nomorInventaris == null || nomorInventaris.trim().isEmpty()) {
            throw new IllegalArgumentException("Nomor inventaris tidak boleh kosong!");
        }
        this.spesifikasi = spesifikasi;
        this.nomorInventaris = nomorInventaris;
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }

    public String getNomorInventaris() {
        return nomorInventaris;
    }

    @Override
    public JenisAset getJenis() {
        return JenisAset.LAPTOP;
    }
}