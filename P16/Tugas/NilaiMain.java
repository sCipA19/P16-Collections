package Tugas;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class NilaiMain {
    String kodeNil;
    double nilai;
    mahasiswa mhs;
    MataKuliah mk;

    public NilaiMain(String kodeNil, double nilai, mahasiswa mhs, MataKuliah mk) {
        this.kodeNil = kodeNil;
        this.nilai = nilai;
        this.mhs = mhs;
        this.mk = mk;
    }

    List<mahasiswa> mhsA = new ArrayList<>();
    List<MataKuliah> matkulA = new ArrayList<>();

    public void tambahMhs(mahasiswa... mahasiswa) {
        mhsA.addAll(Arrays.asList(mahasiswa));
    }

    public void tambahMatkul(MataKuliah... matkul) {
        matkulA.addAll(Arrays.asList(matkul));
    }

    public void tampilMhs() {
        mhsA.stream().forEach(mhs -> {
            System.out.println("" + mhs.toString());
        });
    }

    public void tampilMatkul() {
        matkulA.stream().forEach(mk -> {
            System.out.println("" + mk.toString());
        });
    }

    int linearSearchMhs(String nim) {
        for (int i = 0; i < mhsA.size(); i++) {
            if (nim.equals(mhsA.get(i).nim)) {
                return i;
            }
        }
        return -1;
    }

    int linearSearchMatkul(String matkul) {
        for (int i = 0; i < matkulA.size(); i++) {
            if (matkul.equals(matkulA.get(i).kodeMk)) {
                return i;
            }
        }
        return -1;
    }

    mahasiswa cariMhs(String nim) {
        for (int i = 0; i < mhsA.size(); i++) {
            if (nim.equals(mhsA.get(i).nim)) {
                return mhsA.get(i);
            }
        }
        return null;
    }

    MataKuliah cariMatkul(String matkul) {
        for (int i = 0; i < matkulA.size(); i++) {
            if (matkul.equals(matkulA.get(i).kodeMk)) {
                return matkulA.get(i);
            }
        }
        return null;
    }

    public String toString(int idx1, int idx2) {
        return mhsA.get(idx1).nim + "\t" + mhsA.get(idx1).nama + "\t" + matkulA.get(idx2).namaMk + "\t"
                + matkulA.get(idx2).sks + "\t";
    }

    static Comparator<NilaiMain> CompNilai = (n1, n2) -> {
        if (n1.nilai < n2.nilai) {
            return -1;
        } else if (n1.nilai > (n2).nilai) {
            return 1;
        } else {
            return 0;
        }
    };

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sd = new Scanner(System.in);
        Scanner sb = new Scanner(System.in);

        List<NilaiMain> nill = new ArrayList<>();
        NilaiMain n = new NilaiMain("", 0, null, null);

        mahasiswa m1 = new mahasiswa("20001", "Natasha", "021xxx");
        mahasiswa m2 = new mahasiswa("20002", "Amanda", "021xxx");
        mahasiswa m3 = new mahasiswa("20003", "Iqball", "021xxx");
        mahasiswa m4 = new mahasiswa("20004", "Anggara", "021xxx");
        mahasiswa m5 = new mahasiswa("20005", "Guanna", "021xxx");
        mahasiswa m6 = new mahasiswa("20006", "Natasha", "021xxx");

        n.tambahMhs(m1, m2, m3, m4, m5, m6);

        MataKuliah mk1 = new MataKuliah("0001", "Internet of Things", 3);
        MataKuliah mk2 = new MataKuliah("0002", "Algoritma dan Struktur Data", 2);
        MataKuliah mk3 = new MataKuliah("0003", "Algoritma dan Pemrograman", 2);
        MataKuliah mk4 = new MataKuliah("0004", "Praktikum Algoritma dan Struktur Data", 3);
        MataKuliah mk5 = new MataKuliah("0005", "Algoritma dan Struktur Data", 3);

        n.tambahMatkul(mk1, mk2, mk3, mk4, mk5);

        NilaiMain n1 = null;
        String nimMhs, mkMhs;

        int menu = 0;
        do {
            System.out.println("+===================================================+");
            System.out.println("+ Sistem Pengelolahan Data Nilai Mahasiswa Semester +");
            System.out.println("+===================================================+");
            System.out.println(" 1. Input Nilai");
            System.out.println(" 2. Tampil Nilai");
            System.out.println(" 3. Mencari Nilai Mahasiswa");
            System.out.println(" 4. Urut Data Nilai");
            System.out.println(" 5. Keluar");
            System.out.println("+==================================================+");
            System.out.print("Pilih\t\t\t\t: ");
            menu = sd.nextInt();
            System.out.println("");

            switch (menu) {
                case 1:
                    System.out.print("Kode\t\t\t\t: ");
                    String kd = sc.nextLine();
                    System.out.print("Nilai\t\t\t\t: ");
                    double nilMhs = sb.nextDouble();
                    System.out.println("");

                    System.out.println("                    Daftar Mahasiswa               ");
                    System.out.println("====================================================");
                    System.out.println("NIM\tNama\t\tNo Telp");
                    n.tampilMhs();
                    System.out.println("---------------------------------------------------");
                    System.out.print("Pilih Mahasiswa by nim\t\t: ");
                    nimMhs = sc.nextLine();
                    mahasiswa mahaSiswas;
                    mahaSiswas = n.cariMhs(nimMhs);

                    System.out.println("");
                    System.out.println("                    Daftar Mata Kuliah              ");
                    System.out.println("====================================================");
                    System.out.println("Kode\tMata Kuliah\t\t\t\tSKS");
                    n.tampilMatkul();
                    System.out.println("---------------------------------------------------");
                    System.out.print("Pilih Mata Kuliah by Kode\t:");
                    mkMhs = sc.nextLine();
                    MataKuliah mataKuliahs;
                    mataKuliahs = n.cariMatkul(mkMhs);

                    n1 = new NilaiMain(kd, nilMhs, mahaSiswas, mataKuliahs);

                    nill.add(n1);
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("                  Daftar Nilai Mahasiswa           ");
                    System.out.println("====================================================");
                    System.out.println("NIM\tNama\tMata Kuliah\t\tSKS\tNilai");
                    for (int i = 0; i < nill.size(); i++) {
                        n.linearSearchMhs(nill.get(i).mhs.nim);
                        n.linearSearchMatkul(nill.get(i).mk.kodeMk);
                        System.out.println(n.toString(n.linearSearchMhs(nill.get(i).mhs.nim),
                                n.linearSearchMatkul(nill.get(i).mk.kodeMk)) + nill.get(i).nilai);
                    }
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("                  Daftar Nilai Mahasiswa           ");
                    System.out.println("====================================================");
                    System.out.println("NIM\tNama\tMata Kuliah\t\tSKS\tNilai");
                    int sks = 0;
                    for (int i = 0; i < nill.size(); i++) {
                        n.linearSearchMhs(nill.get(i).mhs.nim);
                        n.linearSearchMatkul(nill.get(i).mk.kodeMk);
                        System.out.println(n.toString(n.linearSearchMhs(nill.get(i).mhs.nim),
                                n.linearSearchMatkul(nill.get(i).mk.kodeMk)) + nill.get(i).nilai);
                    }
                    System.out.println("---------------------------------------------------");
                    System.out.print("Masukkan Data Mahasiswa NIM\t\t: ");
                    String input = sc.nextLine();
                    System.out.println("");
                    for (int i = 0; i < nill.size(); i++) {
                        if (input.equalsIgnoreCase(nill.get(i).mhs.nim)) {
                            sks += n.matkulA.get(i).sks;
                            n.linearSearchMhs(nill.get(i).mhs.nim);
                            n.linearSearchMatkul(nill.get(i).mk.kodeMk);
                            System.out.println(n.toString(n.linearSearchMhs(nill.get(i).mhs.nim),
                                    n.linearSearchMatkul(nill.get(i).mk.kodeMk)) + nill.get(i).nilai);
                        }
                    }
                    System.out.println("---------------------------------------------------");
                    System.out.println("Total SKS " + sks + " Telah Diambil");
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("                  Daftar Mahasiswa                 ");
                    System.out.println("====================================================");
                    System.out.println("NIM\tNama\tMata Kuliah\t\tSKS\tNilai");
                    nill.sort(CompNilai);
                    for (int i = 0; i < nill.size(); i++) {
                        n.linearSearchMhs(nill.get(i).mhs.nim);
                        n.linearSearchMatkul(nill.get(i).mk.kodeMk);
                        System.out.println(n.toString(n.linearSearchMhs(nill.get(i).mhs.nim),
                                n.linearSearchMatkul(nill.get(i).mk.kodeMk)) + nill.get(i).nilai);
                    }
                    System.out.println("");
                    break;

                case 5:
                    System.out.println("+==================================================+");
                    System.out.println("+                    Terima Kasih                  +");
                    System.out.println("+==================================================+");
                    break;
            }
        } while (menu < 5 && menu > 0);
    }
}

