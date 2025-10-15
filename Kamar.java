public class Kamar {
    private int nomorKamar;
    private String tipeKamar;
    private double hargaPerMalam;
    private boolean status; // false = kosong, true = dipesan

    public Kamar(int nomorKamar, String tipeKamar, double hargaPerMalam) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        this.hargaPerMalam = hargaPerMalam;
        this.status = false;
    }

    public int getNomorKamar() {
        return nomorKamar;
    }

    public void setNomorKamar(int nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public void setTipeKamar(String tipeKamar) {
        this.tipeKamar = tipeKamar;
    }

    public double getHargaPerMalam() {
        return hargaPerMalam;
    }

    public void setHargaPerMalam(double hargaPerMalam) {
        this.hargaPerMalam = hargaPerMalam;
    }

    public boolean isDipesan() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void pesanKamar() {
        this.status = true;
    }

    public void kosongkanKamar() {
        this.status = false;
    }

    @Override
    public String toString() {
        return "Kamar{" +
                "nomorKamar=" + nomorKamar +
                ", tipeKamar='" + tipeKamar + '\'' +
                ", hargaPerMalam=" + hargaPerMalam +
                ", status=" + (status ? "dipesan" : "kosong") +
                '}';
    }
}

