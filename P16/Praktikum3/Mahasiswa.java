package Praktikum3;

public class Mahasiswa {
    String nim;
    String nama;
    String notelp;

    public Mahasiswa() {

    }

    public Mahasiswa(String nim, String nama, String notelp) {
        this.nim = nim;
        this.nama = nama;
        this.notelp = notelp;
    }

    public String toString() {
        return "mahasiswa{" + "nim= " + nim + ", nama= " + nama + ", notelp= " + notelp + '}';
    }
}
