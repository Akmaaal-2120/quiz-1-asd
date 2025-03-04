import java.util.Scanner;

class Perpustakaan {
    static Buku[] bukuList = new Buku[5];
    static Mahasiswa[] mahasiswaList = new Mahasiswa[2];
    static int bukuCount = 0, mahasiswaCount = 0;
    
    static void tambahBuku(Scanner sc) {
        if (bukuCount < 5) {
            System.out.print("Masukkan kode buku: ");
            String kode = sc.next();
            System.out.print("Masukkan judul buku: ");
            sc.nextLine();
            String judul = sc.nextLine();
            System.out.print("Masukkan penulis: ");
            String penulis = sc.nextLine();
            bukuList[bukuCount++] = new Buku(kode, judul, penulis);
            System.out.println("Buku berhasil ditambahkan!");
        } else {
            System.out.println("Koleksi buku penuh!");
        }
    }
    
    static void tambahMahasiswa(Scanner sc) {
        if (mahasiswaCount < 2) {
            System.out.print("Masukkan NIM mahasiswa: ");
            String nim = sc.next();
            System.out.print("Masukkan nama mahasiswa: ");
            sc.nextLine();
            String nama = sc.nextLine();
            mahasiswaList[mahasiswaCount++] = new Mahasiswa(nim, nama);
            System.out.println("Mahasiswa berhasil ditambahkan!");
        } else {
            System.out.println("Jumlah mahasiswa penuh!");
        }
    }

    static void pinjamBuku(Scanner sc) {
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = sc.next();
        Mahasiswa mhs = cariMahasiswa(nim);
        if (mhs == null || mhs.jumlahDipinjam >= 2) {
            System.out.println("Mahasiswa tidak ditemukan atau sudah mencapai batas peminjaman!");
            return;
        }
        System.out.print("Masukkan kode buku: ");
        String kode = sc.next();
        Buku b = cariBuku(kode);
        if (b == null || b.dipinjam) {
            System.out.println("Buku tidak ditemukan atau sudah dipinjam!");
        } else {
            b.dipinjam = true;
            mhs.bukuDipinjam[mhs.jumlahDipinjam++] = b;
            System.out.println("Buku berhasil dipinjam!");
        }
    }

    static void kembalikanBuku(Scanner sc) {
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = sc.next();
        Mahasiswa mhs = cariMahasiswa(nim);
        if (mhs == null) {
            System.out.println("Mahasiswa tidak ditemukan!");
            return;
        }
        System.out.print("Masukkan kode buku yang akan dikembalikan: ");
        String kode = sc.next();
        for (int i = 0; i < mhs.jumlahDipinjam; i++) {
            if (mhs.bukuDipinjam[i] != null && mhs.bukuDipinjam[i].kode.equals(kode)) {
                mhs.bukuDipinjam[i].dipinjam = false;
                System.out.println("Buku berhasil dikembalikan!");
                mhs.bukuDipinjam[i] = null;
                mhs.jumlahDipinjam--;
                return;
            }
        }
        System.out.println("Buku tidak ditemukan dalam daftar peminjaman mahasiswa!");
    }

    static void tampilkanPeminjaman() {
        boolean adaPeminjaman = false;
        System.out.println("\nDaftar Peminjaman:");
        for (int i = 0; i < mahasiswaList.length; i++) {
            Mahasiswa m = mahasiswaList[i];
            if (m != null && m.jumlahDipinjam > 0) {
                System.out.println("Mahasiswa: " + m.nama + " (" + m.nim + ")");
                adaPeminjaman = true;
                for (int j = 0; j < m.bukuDipinjam.length; j++) {
                    Buku b = m.bukuDipinjam[j];
                    if (b != null) {
                        System.out.println("  - " + b.judul + " oleh " + b.penulis);
                    }
                }
            }
        }
        if (!adaPeminjaman) {
            System.out.println("Tidak ada peminjaman yang sedang berlangsung.");
        }
    }
    
    static Mahasiswa cariMahasiswa(String nim) {
        for (int i = 0; i < mahasiswaList.length; i++) {
            if (mahasiswaList[i] != null && mahasiswaList[i].nim.equals(nim)) return mahasiswaList[i];
        }
        return null;
    }
    
    static Buku cariBuku(String kode) {
        for (int i = 0; i < bukuList.length; i++) {
            if (bukuList[i] != null && bukuList[i].kode.equals(kode)) return bukuList[i];
        }
        return null;
    }
}