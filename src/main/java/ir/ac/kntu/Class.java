package ir.ac.kntu;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

public class Class {
    private String name;

    private User malekUser;

    private String ostad;

    private ArrayList<User> studentUser = new ArrayList<>();

    private ArrayList<Tamrin> tamrin = new ArrayList<>();

    private int tedadTamrin = 0;

    private String moaseseAmoozeshi;

    private int salTahsili;

    private boolean baz;

    private boolean omoomie;

    private String password;

    public void sabtNam(User user) {
        Scanner scanner = new Scanner(System.in);
        if (this.malekUser.equals(user)) {
            System.out.println("You are the owner of class so you cant register for that!!");
        } else if (this.baz) {
            if (!this.omoomie) {
                System.out.println("Class is private so enter the password:");
                String tempPass = scanner.next();
                if (this.password.equals(tempPass)) {
                    boolean sabtName = false;
                    for (int i = 0; i < studentUser.size(); i++) {
                        if (studentUser.get(i).equals(user)) {
                            sabtName = true;
                        }
                    }
                    if (sabtName == true) {
                        System.out.println("You registered at this class in the past. :| ");
                    }
                    if (sabtName == false) {
                        this.studentUser.add(user);
                        System.out.println("Class is open and password is correct so your register done successfully. :) ");
                    }
                }
            } else {
                boolean sabtName = false;
                for (int i = 0; i < studentUser.size(); i++) {
                    if (studentUser.get(i).equals(user)) {
                        sabtName = true;
                    }
                }
                if (sabtName == true) {
                    System.out.println("You registered at this class in the past. :| ");
                }
                if (sabtName == false) {
                    this.studentUser.add(user);
                    System.out.println("Class is open and its public so your register done successfully. :) ");
                }
            }
        } else {
            System.out.println("Class is close and you cant register in this class. :( ");
        }
    }

    public void sabtNamKhas(User user) {
        if (!this.baz) {
            boolean sabtName = false;
            for (int i = 0; i < studentUser.size(); i++) {
                if (studentUser.get(i).equals(user)) {
                    sabtName = true;
                }
            }
            if (sabtName == true) {
                System.out.println("This student was registered at this class in the past. :| ");
            }
            if (sabtName == false) {
                this.studentUser.add(user);
                System.out.println("This student is registered at the class successfully. :) ");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getMalekUser() {
        return malekUser;
    }

    public void setMalekUser(User malekUser) {
        this.malekUser = malekUser;
    }

    public String getOstad() {
        return ostad;
    }

    public void setOstad(String ostad) {
        this.ostad = ostad;
    }

    public ArrayList<User> getStudentUser() {
        return studentUser;
    }

    public void setStudentUser(ArrayList<User> studentUser) {
        this.studentUser = studentUser;
    }

    public ArrayList<Tamrin> getTamrin() {
        return tamrin;
    }

    public void setTamrin(ArrayList<Tamrin> tamrin) {
        this.tamrin = tamrin;
    }

    public String getMoaseseAmoozeshi() {
        return moaseseAmoozeshi;
    }

    public void setMoaseseAmoozeshi(String moaseseAmoozeshi) {
        this.moaseseAmoozeshi = moaseseAmoozeshi;
    }

    public int getSalTahsili() {
        return salTahsili;
    }

    public void setSalTahsili(int salTahsili) {
        this.salTahsili = salTahsili;
    }

    public boolean getBaz() {
        return baz;
    }

    public void setBaz(boolean baz) {
        this.baz = baz;
    }

    public int getTedadTamrin() {
        return tedadTamrin;
    }

    public void setTedadTamrin(int tedadTamrin) {
        this.tedadTamrin = tedadTamrin;
    }

    public boolean getKhosoosi() {
        return omoomie;
    }

    public void setKhosoosi(boolean khosoosi) {
        this.omoomie = khosoosi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Class(Class aClass) {
        this.name = aClass.name;
        this.malekUser = aClass.malekUser;
        this.ostad = aClass.ostad;
        this.moaseseAmoozeshi = aClass.moaseseAmoozeshi;
        this.salTahsili = aClass.salTahsili;
        this.baz = aClass.baz;
        this.studentUser = aClass.studentUser;
        this.omoomie = aClass.omoomie;
        this.password = aClass.password;
    }

    public Class(String name, User malekUser, String ostad, String moaseseAmoozeshi, int salTahsili, boolean baz, boolean khosoosi, String password) {
        this.name = name;
        this.malekUser = malekUser;
        this.ostad = ostad;
        this.moaseseAmoozeshi = moaseseAmoozeshi;
        this.salTahsili = salTahsili;
        this.baz = baz;
        this.omoomie = khosoosi;
        this.password = password;
    }

    public Class() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Class aClass = (Class) o;
        return tedadTamrin == aClass.tedadTamrin && salTahsili == aClass.salTahsili && baz == aClass.baz && omoomie == aClass.omoomie && name.equals(aClass.name) && malekUser.equals(aClass.malekUser) && ostad.equals(aClass.ostad) && studentUser.equals(aClass.studentUser) && tamrin.equals(aClass.tamrin) && moaseseAmoozeshi.equals(aClass.moaseseAmoozeshi) && password.equals(aClass.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, malekUser, ostad, studentUser, tamrin, tedadTamrin, moaseseAmoozeshi, salTahsili, baz, omoomie, password);
    }

    @Override
    public String toString() {
        return "Class{" +
                "name= " + name +
                ", malekUser= " + malekUser.getName() +
                ", ostad= " + ostad +
                ", moaseseAmoozeshi= " + moaseseAmoozeshi +
                ", salTahsili= " + salTahsili +
                ", baz= " + baz +
                ", omoomie= " + omoomie +
                ", student list=" + studentUser +
                '}';
    }
}
