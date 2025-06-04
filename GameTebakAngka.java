import java.util.Scanner;
import java.util.Random;

// Encapsulation: Base class untuk pemain
class Pemain {
    private String nama;
    private int skor;

    public Pemain(String nama) {
        this.nama = nama;
        this.skor = 0;
    }

    public String getNama() {
        return nama;
    }

    public int getSkor() {
        return skor;
    }

    public void tambahSkor() {
        this.skor++;
    }
}

// Subclass untuk pemain manusia
class PemainManusia extends Pemain {
    private Scanner scanner;

    public PemainManusia(String nama, Scanner scanner) {
        super(nama);
        this.scanner = scanner;
    }

    public int tebakAngka() {
        System.out.print(getNama() + ", masukkan tebakan Anda (1-10): ");
        return scanner.nextInt();
    }
}

// Main class
public class GameTebakAngka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Game Tebak Angka untuk 2 Pemain ===");

        // Input nama pemain
        System.out.print("Masukkan nama pemain 1: ");
        String namaPemain1 = scanner.nextLine();
        PemainManusia pemain1 = new PemainManusia(namaPemain1, scanner);

        System.out.print("Masukkan nama pemain 2: ");
        String namaPemain2 = scanner.nextLine();
        PemainManusia pemain2 = new PemainManusia(namaPemain2, scanner);

        boolean mainLagi = true; // Flag untuk menentukan apakah permainan akan diulang

        while (mainLagi) {
            // Angka rahasia
            Random random = new Random();
            int angkaRahasia = random.nextInt(10) + 1;

            System.out.println("\nAngka rahasia telah dipilih. Tebak angka antara 1-10!");

            boolean gameSelesai = false;
            while (!gameSelesai) {
                // Giliran pemain 1
                System.out.println("\n--- Giliran " + pemain1.getNama() + " ---");
                int tebakanPemain1 = pemain1.tebakAngka();
                if (tebakanPemain1 == angkaRahasia) {
                    System.out.println("Selamat, " + pemain1.getNama() + "! Anda menebak dengan benar!");
                    pemain1.tambahSkor();
                    gameSelesai = true;
                    break;
                } else {
                    System.out.println("Salah, tebakan Anda terlalu " + (tebakanPemain1 < angkaRahasia ? "rendah!" : "tinggi!"));
                }

                // Giliran pemain 2
                System.out.println("\n--- Giliran " + pemain2.getNama() + " ---");
                int tebakanPemain2 = pemain2.tebakAngka();
                if (tebakanPemain2 == angkaRahasia) {
                    System.out.println("Selamat, " + pemain2.getNama() + "! Anda menebak dengan benar!");
                    pemain2.tambahSkor();
                    gameSelesai = true;
                    break;
                } else {
                    System.out.println("Salah, tebakan Anda terlalu " + (tebakanPemain2 < angkaRahasia ? "rendah!" : "tinggi!"));
                }
            }

            // Menampilkan skor terkini
            System.out.println("\n=== Skor Terkini ===");
            System.out.println(pemain1.getNama() + ": " + pemain1.getSkor());
            System.out.println(pemain2.getNama() + ": " + pemain2.getSkor());

            // Menanyakan apakah ingin bermain lagi
            System.out.print("\nApakah Anda ingin bermain lagi? (y/n): ");
            String jawaban = scanner.next().toLowerCase();
            if (!jawaban.equals("y")) {
                mainLagi = false; // Keluar dari loop jika jawaban bukan "y"
            }
        }

        // Menampilkan skor akhir sebelum keluar
        System.out.println("\n=== Skor Akhir ===");
        System.out.println(pemain1.getNama() + ": " + pemain1.getSkor());
        System.out.println(pemain2.getNama() + ": " + pemain2.getSkor());
        System.out.println("Terima kasih telah bermain! Sampai jumpa!");

        scanner.close();
    }
}