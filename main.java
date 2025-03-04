import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nMenu:");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Tambah Mahasiswa");
        System.out.println("3. Pinjam Buku");
        System.out.println("4. Kembalikan Buku");
        System.out.println("5. Tampilkan Peminjaman");
        System.out.println("6. Keluar");
        
        while (true) {

            System.out.print("Pilihan: ");
            int pilihan = sc.nextInt();
            
            if (pilihan == 1) {
                Perpustakaan.tambahBuku(sc);
            } else if (pilihan == 2) {
                Perpustakaan.tambahMahasiswa(sc);
            } else if (pilihan == 3) {
                Perpustakaan.pinjamBuku(sc);
            } else if (pilihan == 4) {
                Perpustakaan.kembalikanBuku(sc);
            } else if (pilihan == 5) {
                Perpustakaan.tampilkanPeminjaman();
            } else{
                break;
            }
        }
    }
}
