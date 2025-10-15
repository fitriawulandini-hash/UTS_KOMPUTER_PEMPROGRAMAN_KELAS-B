import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final List<Kamar> daftarKamar;

    public Hotel() {
        this.daftarKamar = new ArrayList<>();
    }

    public void tambahKamar(Kamar kamar) {
        this.daftarKamar.add(kamar);
    }

    public List<Kamar> getDaftarKamar() {
        return daftarKamar;
    }

    public Kamar cariKamarKosong(String tipe) {
        for (Kamar kamar : daftarKamar) {
            if (!kamar.isDipesan()) {
                if (kamar.getTipeKamar().equalsIgnoreCase(tipe)) {
                    return kamar;
                }
            }
        }
        return null;
    }

    public double hitungTotalBayar(Tamu tamu, Kamar kamar) {
        return tamu.getDurasiMenginap() * kamar.getHargaPerMalam();
    }
}

