import java.util.ArrayList;

public class Hotel {
    private ArrayList<Kamar> daftarKamar;

    public Hotel() {
        daftarKamar = new ArrayList<>();
    }

    public void tambahKamar(Kamar kamar) {
        daftarKamar.add(kamar);
    }

    public Kamar cariKamarKosong(String tipe) {
        for (Kamar kamar : daftarKamar) {
            if (!kamar.isStatus() && kamar.getipekamar().equalsIgnoreCase(tipe)) {
                return kamar;
            }
        }
        return null;
    }

    public double hitungTotalBayar(Tamu t, Kamar k) {
        return t.getDurasiMenginap() * k.getHargaPerMalam();
    }

    public void tampilkanDaftarKamar() {
        for (Kamar kamar : daftarKamar) {
            System.out.println(kamar.infoKamar());
        }
    }
}
