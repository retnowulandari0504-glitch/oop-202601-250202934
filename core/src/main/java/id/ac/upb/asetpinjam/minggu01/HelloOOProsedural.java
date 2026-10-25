package id.ac.upb.asetpinjam.minggu01;

import id.ac.upb.asetpinjam.config.Varian;

public final class HelloOOProsedural {

    private HelloOOProsedural() {
    }

    public static String sapa(String nama, String nim) {
        return "Aset-Pinjam | " + nama + " | " + nim;
    }

    public static void main(String[] args) {
        Varian v = Varian.aktif();
        System.out.println(sapa(v.nama, v.nim));
    }
}