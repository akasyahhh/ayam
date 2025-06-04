import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.Locale;

class Mahasiswa {
     String nama;
     String tanggallahir; 
     String alamat;
     String jurusan;
     String kelas;

    public Mahasiswa(String nama, String tanggallahir, String alamat, String jurusan, String kelas) {
        this.nama = nama;
        this.tanggallahir = tanggallahir;
        this.alamat = alamat;
        this.jurusan = jurusan;
        this.kelas = kelas;
    }

    void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Tempat tanggal lahir: " + tanggallahir);
        System.out.println("Alamat: " + alamat);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("Kelas: " + kelas);
        System.out.println("Umur: " + calculateAge() + " tahun"); // Display age
    }

    int calculateAge() {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy",  new Locale("id", "ID"));
        LocalDate birthDate = LocalDate.parse(tanggallahir, formatter); // Parse the date of birth
        LocalDate currentDate = LocalDate.now(); // Get the current date
        Period age = Period.between(birthDate, currentDate);
        return age.getYears(); 
    }
}

public class Main {
    public static void main(String[] args) {
        Mahasiswa mahasiswa1 = new Mahasiswa
        ("RIZKY", "10 Juni 2005", "JL. Karya no 21 E", "Sistem Informasi", "C-1");
        Mahasiswa mahasiswa2 = new Mahasiswa
        ("Andi", "27 September 2001", "JL. Perak no 28 E", "Teknologi informasi", "B-1 2022");
        
        
        mahasiswa2.displayInfo(); 
    }
}
