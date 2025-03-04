class Mahasiswa {
    String nim, nama;
    Buku[] bukuDipinjam = new Buku[2];
    int jumlahDipinjam = 0;
    
    Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }
}