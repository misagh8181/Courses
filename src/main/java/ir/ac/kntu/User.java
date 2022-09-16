package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String name;

    private String userName;

    private String email;

    private String passWord;

    private String nationalCode;

    private String phoneNumber;

    private ArrayList<Class> ownClasses = new ArrayList<>();

    private int tedadKelas = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Class> getOwnClasses() {
        return ownClasses;
    }

    public void setOwnClasses(ArrayList<Class> ownClasses) {
        this.ownClasses = ownClasses;
    }

    public int getTedadKelas() {
        return tedadKelas;
    }

    public void setTedadKelas(int tedadKelas) {
        this.tedadKelas = tedadKelas;
    }


    public User(User user) {
        this.name = user.name;
        this.userName = user.userName;
        this.email = user.email;
        this.passWord = user.passWord;
        this.nationalCode = user.nationalCode;
        this.phoneNumber = user.phoneNumber;
    }

    public User(String name, String userName, String email, String passWord, String internationalCode, String phoneNumber) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
        this.nationalCode = internationalCode;
        this.phoneNumber = phoneNumber;
    }

    public User() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return name.equals(user.name) && userName.equals(user.userName) && email.equals(user.email) && passWord.equals(user.passWord) && nationalCode.equals(user.nationalCode) && phoneNumber.equals(user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, userName, email, passWord, nationalCode, phoneNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "name= " + name +
                ", userName= " + userName +
                ", email= " + email +
                ", internationalCode= " + nationalCode +
                ", phoneNumber= " + phoneNumber +
                '}';
    }
}
