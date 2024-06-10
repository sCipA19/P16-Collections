package Tugas;

public class mahasiswa {
    String nim, nama, noTelp;

    public mahasiswa() {

    }

    public mahasiswa(String nim, String nama, String noTelp) {
        this.nim = nim;
        this.nama = nama;
        this.noTelp = noTelp;
    }

    public String toString() {
        return String.format("%s\t%-15s\t%s", nim, nama, noTelp);
    }
}
