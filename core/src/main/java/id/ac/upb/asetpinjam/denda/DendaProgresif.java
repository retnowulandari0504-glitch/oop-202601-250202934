package id.ac.upb.asetpinjam.denda;

import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.model.Aset;

public class DendaProgresif implements AturanDenda {

    private static final int BATAS_HARI = 7;

    @Override
    public long hitung(Aset aset, int hariTerlambat) {
        if (hariTerlambat < 0) {
            throw new IllegalArgumentException("Hari terlambat tidak boleh negatif!");
        }
        long flat = aset.hitungDenda(hariTerlambat);
        if (hariTerlambat <= BATAS_HARI) {
            return flat;
        }
        long tarifPerHari = aset.hitungDenda(1);
        long lebihHari = hariTerlambat - BATAS_HARI;
        return flat + (tarifPerHari * lebihHari) / 2;
    }
}