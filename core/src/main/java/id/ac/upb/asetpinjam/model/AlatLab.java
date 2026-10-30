   package id.ac.upb.asetpinjam.model;

   public class AlatLab extends Aset {
       private final String laboratorium;
       private final TingkatRisiko tingkatRisiko;

       public AlatLab(String id, String nama, String laboratorium, TingkatRisiko tingkatRisiko) {
           super(id, nama);
           if (laboratorium == null || laboratorium.isBlank()) {
               throw new IllegalArgumentException("Laboratorium tidak boleh kosong");
           }
           if (tingkatRisiko == null) {
               throw new IllegalArgumentException("Tingkat risiko tidak boleh null");
           }
           this.laboratorium = laboratorium;
           this.tingkatRisiko = tingkatRisiko;
       }

       public String getLaboratorium() {
           return laboratorium;
       }

       public TingkatRisiko getTingkatRisiko() {
           return tingkatRisiko;
       }

       @Override
       public JenisAset getJenis() {
           return JenisAset.ALAT_LAB;
       }
   }