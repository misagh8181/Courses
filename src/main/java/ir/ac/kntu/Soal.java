package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Objects;

public class Soal {
    private String name;

    private int barom;

    private String tozih;

    private MizanSakhti mizanSakhti;

    private ArrayList<Pasokh> pasokh = new ArrayList<>();

    private int tedadPasokh = 0;

    private String pasokhDorost;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBarom() {
        return barom;
    }

    public void setBarom(int barom) {
        this.barom = barom;
    }

    public String getTozih() {
        return tozih;
    }

    public void setTozih(String tozih) {
        this.tozih = tozih;
    }

    public MizanSakhti getMizanSakhti() {
        return mizanSakhti;
    }

    public void setMizanSakhti(MizanSakhti mizanSakhti) {
        this.mizanSakhti = mizanSakhti;
    }

    public ArrayList<Pasokh> getPasokh() {
        return pasokh;
    }

    public int getTedadPasokh() {
        return tedadPasokh;
    }

    public void setTedadPasokh(int tedadPasokh) {
        this.tedadPasokh = tedadPasokh;
    }

    public void setPasokh(ArrayList<Pasokh> pasokh) {
        this.pasokh = pasokh;
    }

    public String getPasokhDorost() {
        return pasokhDorost;
    }

    public void setPasokhDorost(String pasokhDorost) {
        this.pasokhDorost = pasokhDorost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Soal soal = (Soal) o;
        return barom == soal.barom && name.equals(soal.name) && tozih.equals(soal.tozih) && mizanSakhti == soal.mizanSakhti && pasokh.equals(soal.pasokh) && pasokhDorost.equals(soal.pasokhDorost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, barom, tozih, mizanSakhti, pasokh, pasokhDorost);
    }

    @Override
    public String toString() {
        return "Soal{" +
                "name='" + name + '\'' +
                ", barom=" + barom +
                ", tozih='" + tozih + '\'' +
                ", mizanSakhti=" + mizanSakhti +
                '}';
    }
}
