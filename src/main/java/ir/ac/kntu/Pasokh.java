package ir.ac.kntu;

import java.time.LocalDateTime;

public class Pasokh {
    private String userName;

    private String soalName;

    private LocalDateTime tarikhErsal;

    private int zaribTakhir;

    private double nomre;

    private double nomreBaTakhir;

    private boolean nahaiee;

    private String matnePasokh;

    public void setTime() {
        this.tarikhErsal = LocalDateTime.now();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSoalName() {
        return soalName;
    }

    public void setSoalName(String soalName) {
        this.soalName = soalName;
    }

    public LocalDateTime getTarikhErsal() {
        return tarikhErsal;
    }

    public void setTarikhErsal(LocalDateTime tarikhErsal) {
        this.tarikhErsal = tarikhErsal;
    }

    public int getZaribTakhir() {
        return zaribTakhir;
    }

    public void setZaribTakhir(int zaribTakhir) {
        this.zaribTakhir = zaribTakhir;
    }

    public double getNomre() {
        return nomre;
    }

    public void setNomre(double nomre) {
        this.nomre = nomre;
    }

    public double getNomreBaTakhir() {
        return nomreBaTakhir;
    }

    public void setNomreBaTakhir(double nomreBaTakhir) {
        this.nomreBaTakhir = nomreBaTakhir;
    }

    public boolean isNahaiee() {
        return nahaiee;
    }

    public void setNahaiee(boolean nahaiee) {
        this.nahaiee = nahaiee;
    }

    public String getMatnePasokh() {
        return matnePasokh;
    }

    public void setMatnePasokh(String matnePasokh) {
        this.matnePasokh = matnePasokh;
    }
}
