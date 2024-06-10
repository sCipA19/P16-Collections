package Tugas;

public class MataKuliah {
    String kodeMk, namaMk;
    int sks;

    public MataKuliah(String kodeMk, String namaMk, int sks) {
        this.kodeMk = kodeMk;
        this.namaMk = namaMk;
        this.sks = sks;
    }

    public String toString() {
        return String.format("%s\t%-40s%s", kodeMk, namaMk, sks);
    }
}
