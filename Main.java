import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            tampilkanMenu();
            String pilihan = input("Pilih menu: ");
            switch (pilihan) {
                case "1":
                    jalankanSkenarioDefault();
                    break;
                case "2":
                    jalankanModeKustom();
                    break;
                case "0":
                    System.out.println("Keluar.");
                    return;
                default:
                    System.out.println("Pilihan tidak dikenal. Coba lagi.\n");
            }
        }
    }

    private static void tampilkanMenu() {
        System.out.println("============================");
        System.out.println(" Sistem Pemesanan Hotel");
        System.out.println("============================");
        System.out.println("1. Jalankan skenario default");
        System.out.println("2. Mode interaktif (kustom)");
        System.out.println("0. Keluar");
    }

    private static void jalankanSkenarioDefault() {
        Hotel hotel = new Hotel();

        // Inisialisasi kamar default
        hotel.tambahKamar(new Kamar(101, "Single", 300000));
        hotel.tambahKamar(new Kamar(102, "Single", 300000));
        hotel.tambahKamar(new Kamar(201, "Double", 500000));
        hotel.tambahKamar(new Kamar(202, "Double", 500000));
        hotel.tambahKamar(new Kamar(301, "Suite", 900000));

        // Daftar tamu default
        List<Tamu> daftarTamu = new ArrayList<>();
        daftarTamu.add(new Tamu("Andi", 2));
        daftarTamu.add(new Tamu("Budi", 3));
        daftarTamu.add(new Tamu("Citra", 1));
        daftarTamu.add(new Tamu("Dewi", 4));

        String[] preferensiTipe = {"Single", "Double", "Single", "Suite"};

        prosesPemesananDanTampil(hotel, daftarTamu, preferensiTipe);
        System.out.println();
    }

    private static void jalankanModeKustom() {
        Hotel hotel = new Hotel();

        // Input kamar
        int jumlahKamar = parseIntSafe(input("Masukkan jumlah kamar: "), 0);
        for (int i = 0; i < jumlahKamar; i++) {
            System.out.println("Input kamar ke-" + (i + 1) + ":");
            int nomor = parseIntSafe(input("  Nomor kamar (int): "), 0);
            String tipe = input("  Tipe kamar (mis. Single/Double/Suite): ").trim();
            double harga = parseDoubleSafe(input("  Harga per malam (double): "), 0);
            hotel.tambahKamar(new Kamar(nomor, tipe, harga));
        }

        // Input tamu
        int jumlahTamu = parseIntSafe(input("Masukkan jumlah tamu: "), 0);
        List<Tamu> daftarTamu = new ArrayList<>();
        String[] preferensiTipe = new String[jumlahTamu];
        for (int i = 0; i < jumlahTamu; i++) {
            System.out.println("Input tamu ke-" + (i + 1) + ":");
            String nama = input("  Nama: ").trim();
            int durasi = parseIntSafe(input("  Durasi menginap (malam, int): "), 1);
            daftarTamu.add(new Tamu(nama, durasi));
            preferensiTipe[i] = input("  Tipe kamar diinginkan: ").trim();
        }

        prosesPemesananDanTampil(hotel, daftarTamu, preferensiTipe);
        System.out.println();
    }

    private static void prosesPemesananDanTampil(Hotel hotel, List<Tamu> daftarTamu, String[] preferensiTipe) {
        // Simulasi pemesanan
        for (int i = 0; i < daftarTamu.size(); i++) {
            Tamu tamu = daftarTamu.get(i);
            String tipeDiinginkan = preferensiTipe[i % preferensiTipe.length];

            Kamar kamarKosong = hotel.cariKamarKosong(tipeDiinginkan);
            if (kamarKosong != null) {
                kamarKosong.pesanKamar();
                double total = hotel.hitungTotalBayar(tamu, kamarKosong);
                System.out.println(tamu.getNama() + " memesan kamar " + kamarKosong.getNomorKamar() +
                        " (" + kamarKosong.getTipeKamar() + ") selama " + tamu.getDurasiMenginap() +
                        " malam. Total bayar: Rp" + (long) total);
            } else {
                System.out.println("Tidak ada kamar kosong tipe " + tipeDiinginkan + " untuk " + tamu.getNama());
            }
        }

        // Tampilkan daftar kamar yang masih kosong
        System.out.println("\nDaftar kamar kosong:");
        for (Kamar kamar : hotel.getDaftarKamar()) {
            if (!kamar.isDipesan()) {
                System.out.println("- Kamar " + kamar.getNomorKamar() + " (" + kamar.getTipeKamar() + ") - Rp" + (long) kamar.getHargaPerMalam());
            }
        }

        // Tampilkan daftar kamar yang sudah dipesan
        System.out.println("\nDaftar kamar dipesan:");
        for (Kamar kamar : hotel.getDaftarKamar()) {
            if (kamar.isDipesan()) {
                System.out.println("- Kamar " + kamar.getNomorKamar() + " (" + kamar.getTipeKamar() + ") - Rp" + (long) kamar.getHargaPerMalam());
            }
        }
    }

    private static String input(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine();
    }

    private static int parseIntSafe(String text, int defaultValue) {
        try {
            return Integer.parseInt(text.trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    private static double parseDoubleSafe(String text, double defaultValue) {
        try {
            return Double.parseDouble(text.trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }
}

