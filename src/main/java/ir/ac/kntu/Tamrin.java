package ir.ac.kntu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Tamrin {
    private String name;

    private ArrayList<Soal> soal = new ArrayList<>();

    private String tozih;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int zaribTakhir;

    private LocalDateTime takhirTime;

    private Scanner receiver = new Scanner(System.in);

    public void setTime(String str) {
        int year, day, month, hour, minute, second, i = 0;
        LocalDateTime localDateTime;
        System.out.println("Enter year (like:YYYY):");
        year = receiver.nextInt();
        System.out.println("Enter month (like:MM):");
        month = receiver.nextInt();
        System.out.println("Enter day (like:DD):");
        day = receiver.nextInt();
        System.out.println("Enter hour (like:HH):");
        hour = receiver.nextInt();
        System.out.println("Enter minute (like:MM):");
        minute = receiver.nextInt();
        System.out.println("Enter second (like:SS):");
        second = receiver.nextInt();
        localDateTime = LocalDateTime.of(year, month, day, hour, minute, second);
        if (localDateTime.isBefore(LocalDateTime.now())) {
            i = 1;
        }
        for (; i == 1; ) {
            System.out.println("The input time is before now :( !!!");
            System.out.println("Enter year (like:YYYY):");
            year = receiver.nextInt();
            System.out.println("Enter month (like:MM):");
            month = receiver.nextInt();
            System.out.println("Enter day (like:DD):");
            day = receiver.nextInt();
            System.out.println("Enter hour (like:HH):");
            hour = receiver.nextInt();
            System.out.println("Enter minute (like:MM):");
            minute = receiver.nextInt();
            System.out.println("Enter second (like:SS):");
            second = receiver.nextInt();
            localDateTime = LocalDateTime.of(year, month, day, hour, minute, second);
            if (localDateTime.isAfter(LocalDateTime.now())) {
                i = 0;
            }
        }
        barresyNahaie(str, localDateTime);
    }

    private void barresyNahaie(String str, LocalDateTime localDateTime) {
        if (str.equals("Start")) {
            this.startTime = localDateTime;
        } else if (str.equals("End")) {
            this.endTime = localDateTime;
        } else if (str.equals("Delay")) {
            this.takhirTime = localDateTime;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Soal> getSoal() {
        return soal;
    }

    public void setSoal(ArrayList<Soal> soal) {
        this.soal = soal;
    }

    public String getTozih() {
        return tozih;
    }

    public void setTozih(String tozih) {
        this.tozih = tozih;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getZaribTakhir() {
        return zaribTakhir;
    }

    public void setZaribTakhir(int zaribTakhir) {
        this.zaribTakhir = zaribTakhir;
    }

    public LocalDateTime getTakhirTime() {
        return takhirTime;
    }

    public void setTakhirTime(LocalDateTime takhirTime) {
        this.takhirTime = takhirTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tamrin tamrin = (Tamrin) o;
        return zaribTakhir == tamrin.zaribTakhir && takhirTime == tamrin.takhirTime && name.equals(tamrin.name) && soal.equals(tamrin.soal) && tozih.equals(tamrin.tozih) && startTime.equals(tamrin.startTime) && endTime.equals(tamrin.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, soal, tozih, startTime, endTime, zaribTakhir, takhirTime);
    }

    @Override
    public String toString() {
        return "Tamrin{" +
                "name='" + name + '\'' +
                ", tozih='" + tozih + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", zaribTakhir=" + zaribTakhir +
                ", takhirTime=" + takhirTime +
                '}';
    }
}
